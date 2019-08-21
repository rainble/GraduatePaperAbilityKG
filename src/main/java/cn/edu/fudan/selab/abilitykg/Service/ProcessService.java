package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.DAO.ProcessDAO;
import cn.edu.fudan.selab.abilitykg.Domain.*;
import cn.edu.fudan.selab.abilitykg.Domain.Abilities.Execute;
import cn.edu.fudan.selab.abilitykg.Domain.Process;
import cn.edu.fudan.selab.abilitykg.Utils.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.media.sound.SF2InstrumentRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.fudan.selab.abilitykg.Domain.ExecuteNode;

import java.util.*;

@Service
public class ProcessService {

    @Autowired
    private ProcessDAO processDAO;

    @Autowired
    private LocationService locationService;

    @Autowired
    private EdgeService edgeService;

    public Process queryProcessById(int processId) {
        ProcessDTO processDTO = processDAO.queryProcessById(processId);
        Process process = processAnalysis(processDTO.getActionList());
        process.setProcessId(processDTO.getProcessId());
        return process;
    }


    public Process processAnalysis(String process) {
        String[] actions = process.split(",");
        Process processObject = new Process();
        List<Action> actionList = new ArrayList<>();
        for (String s : actions) {
            String[] action = s.split(" ");
            Action actionObject = new Action();
            actionObject.setType(action[0]);
            for (Ability ability : Ability.values()) {
                if (ability.getAbility().equals(action[1])) {
                    actionObject.setPredicate(ability);
                }
            }
            actionObject.setObject(action[2]);
            actionObject.setAdverbial(action[3]);
            actionObject.setParameters(action[4]);
            actionList.add(actionObject);
        }
        processObject.setActions(actionList);
        return processObject;
    }


    public ExecuteNode getExecuteSequence (Process process) {
        List<List<Location>> locationGraph = new ArrayList<>();
        for (Action action : process.getActions()) {
            if (action.getType().equals("hardware")) {
                List<Location> locationList = locationService.queryLocationByAbility(action);
                locationGraph.add(locationList);
            } else if (action.getType().equals("software")) {
                List<Location> locationList = new ArrayList<>();
                Location location = new Location();
                location.setLocationId(0);
                locationList.add(location);
            }
        }
        ExecuteNode firstNode = new ExecuteNode();

        //策略选择，类比hashmap，总长超过16，有一个list超过64时改用蚁群
        if (getMaxSize(locationGraph) > 64 && locationGraph.size() > 16) {
            Strategy acoStrategy = new ACOService();
            Context context = new Context(acoStrategy);
            firstNode = context.algorithm(locationGraph, process);
        } else {
            Strategy backTrackingStrategy = new BackTrackingService();
            Context context = new Context(backTrackingStrategy);
            firstNode = context.algorithm(locationGraph, process);
        }

        return firstNode;

    }

    private  <T>int getMaxSize(List<List<T>> graph) {

        int[] maxSize = {Integer.MIN_VALUE};

        graph.forEach(list -> {maxSize[0] = Math.max(maxSize[0], list.size());});

        return maxSize[0];
    }

    public Process processParse(String processJsonStr) {
        JSONObject processJson = JSON.parseObject(processJsonStr);
        Process process = new Process();
        process.setProcessId(processJson.getInteger("processId"));
        String actionListStr = processJson.getString("actionList");
        process.setActions(actionParse(actionListStr));
        return process;
    }

    public List<Action> actionParse(String actionListStr) {
        JSONArray actionJsonObj = JSON.parseArray(actionListStr);
        List<Action> actionList = new ArrayList<Action>();

        for (int i = 0; i < actionJsonObj.size(); i++) {
            JSONObject tmp = actionJsonObj.getJSONObject(i);
            Action action = new Action();
            action.setType(tmp.getString("type"));
            for (Ability ability : Ability.values()) {
                if (ability.getAbility().equals(tmp.getString("predicate").toLowerCase())) {
                    action.setPredicate(ability);
                    break;
                }
            }
            action.setObject(tmp.getString("object"));
            action.setAdverbial(tmp.getString("adverbial"));
            action.setParameters(tmp.getString("parameters"));
            actionList.add(action);
        }

        return actionList;
    }



    public String runProcess(Process process) {

        ExecuteNode firstNode = getExecuteSequence(process);
        String result = "process description has some error";
        ExecuteNode tmp = firstNode;
        while (tmp.getNext() != null) {
            if (tmp.getType() == "software" || tmp.getType() == "hardware") {
                Map<String, String> para = new HashMap<>();
                if (tmp.getParameters() != null || tmp.getParameters().length() < 1) {
                    JSONObject parametersJsonObj = JSON.parseObject(tmp.getParameters());
                    for (String s : parametersJsonObj.keySet()) {
                        para.put(s, parametersJsonObj.getString(s));
                    }
                }
                result = HttpRequest.sendPostInBody(tmp.getIPAddress(), para);
            } else {
                return result;
            }
        }
        return result;
    }


//        Edge edge = edgeService.queryEdgeByLocationId(tmp.getLocation().getLocationId());
//
//        tmp = tmp.getNext();
//        while (tmp.getNext() != null) {
//            edge = edgeService.queryEdgeByLocationId(tmp.getLocation().getLocationId());
//            HttpRequest.sendGet()
//            tmp = tmp.getNext();
//        }
    }
