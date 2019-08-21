package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.Domain.ExecuteNode;
import cn.edu.fudan.selab.abilitykg.Domain.Location;
import cn.edu.fudan.selab.abilitykg.Domain.Process;

import java.util.List;

public interface Strategy {

    ExecuteNode algorithm(List<List<Location>> locationGraph, Process process);

}
