package cn.edu.fudan.selab.abilitykg.Domain;

import java.util.List;

public class Process {

    private int processId;
    private List<Action> actions;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId=" + processId +
                ", actions=" + actions +
                '}';
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getProcessId() {
        return processId;
    }
}
