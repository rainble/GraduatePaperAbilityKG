package cn.edu.fudan.selab.abilitykg.Domain;

public class AbilityDesc {

    private Ability verb;
    private String object;

    @Override
    public String toString() {
        return "AbilityDesc{" +
                "verb=" + verb +
                ", object='" + object + '\'' +
                '}';
    }

    public void setVerb(Ability verb) {
        this.verb = verb;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Ability getVerb() {
        return verb;
    }

    public String getObject() {
        return object;
    }
}
