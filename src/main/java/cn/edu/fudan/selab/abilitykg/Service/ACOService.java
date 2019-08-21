package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.Domain.ExecuteNode;
import cn.edu.fudan.selab.abilitykg.Domain.Location;
import cn.edu.fudan.selab.abilitykg.Utils.Parameters;
import cn.edu.fudan.selab.abilitykg.Domain.Process;

import java.util.ArrayList;
import java.util.List;

public class ACOService implements Strategy{

    @Override
    public ExecuteNode algorithm(List<List<Location>> locationGraph, Process process) {

        ExecuteNode startNode = new ExecuteNode();

        ACO(locationGraph, process, startNode);

        return startNode;
    }

    public class LocationNode {
        public int locationId;
        public EntityNode first;
    }

    public class EntityNode {
        public int entityId;
        public EntityNode next;
    }

    public class CallSequence {
        public LocationNode[] locationNodes;
    }




    private int ANT_NUMBER = 100;
    private int ITERATION_NUMBER = 20;

    public List<Integer> ACO(List<List<Location>> locationGraph, Process process, ExecuteNode startNode) {

        ExecuteNode tmpNode = startNode;



        for (int i = 0; i < ITERATION_NUMBER; i++) {
            for (int a = 0; a < ANT_NUMBER; a++) {

            }
        }
        return new ArrayList<>();
    }

}
