package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.Domain.ExecuteNode;
import cn.edu.fudan.selab.abilitykg.Domain.Location;
import cn.edu.fudan.selab.abilitykg.Domain.Process;


import java.util.List;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public ExecuteNode algorithm(List<List<Location>> locationGraph, Process process) {
        return this.strategy.algorithm(locationGraph, process);
    }

}
