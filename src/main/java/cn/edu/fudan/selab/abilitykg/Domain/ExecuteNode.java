package cn.edu.fudan.selab.abilitykg.Domain;

public class ExecuteNode {

    private String type;

    private String IPAddress;

    private AbilityDesc abilityDesc;

    //json
    private String parameters;

    private ExecuteNode next;

    @Override
    public String toString() {
        return "ExecuteNode{" +
                "type='" + type + '\'' +
                ", IPAddress='" + IPAddress + '\'' +
                ", abilityDesc=" + abilityDesc +
                ", parameters='" + parameters + '\'' +
                ", next=" + next +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public void setAbilityDesc(AbilityDesc abilityDesc) {
        this.abilityDesc = abilityDesc;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public void setNext(ExecuteNode next) {
        this.next = next;
    }

    public String getType() {
        return type;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public AbilityDesc getAbilityDesc() {
        return abilityDesc;
    }

    public String getParameters() {
        return parameters;
    }

    public ExecuteNode getNext() {
        return next;
    }
}
