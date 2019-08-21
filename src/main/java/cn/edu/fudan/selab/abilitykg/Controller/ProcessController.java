package cn.edu.fudan.selab.abilitykg.Controller;

import cn.edu.fudan.selab.abilitykg.Domain.Process;
import cn.edu.fudan.selab.abilitykg.Service.ProcessService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response) {
        String param = request.getParameter("param");
        return "abilitykg return " + param;
    }


    @RequestMapping(value = "/runProcess", method = RequestMethod.POST)
    @ResponseBody
    public String runProcess(HttpServletRequest request, HttpServletResponse response) {
        String processStr = request.getParameter("process");
        Process process = processService.processParse(processStr);
        String result = process.getActions().toString();
//        String result = processService.runProcess(process);
        return result;
    }

    @RequestMapping(value = "/runProcessById", method = RequestMethod.POST)
    @ResponseBody
    public String runProcessById(HttpServletRequest request, HttpServletResponse response) {
        int processId = Integer.valueOf(request.getParameter("processId"));
        Process process = processService.queryProcessById(processId);
        String result = processService.runProcess(process);
        return result;
    }

}
