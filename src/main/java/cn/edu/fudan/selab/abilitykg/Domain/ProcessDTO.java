package cn.edu.fudan.selab.abilitykg.Domain;

public class ProcessDTO {

    private int processId;
    private String actionList;

    @Override
    public String toString() {
        return "ProcessDTO{" +
                "processId=" + processId +
                ", actionList='" + actionList + '\'' +
                '}';
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public void setActionList(String actionList) {
        this.actionList = actionList;
    }

    public int getProcessId() {
        return processId;
    }

    public String getActionList() {
        return actionList;
    }
}
