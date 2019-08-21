package cn.edu.fudan.selab.abilitykg.Domain;

import cn.edu.fudan.selab.abilitykg.Enmu.AbilityType;

import java.util.List;

public enum  Ability {

    COMPUTE("compute"),
    DISPLAY("display"),
    EXECUTE("execute"),
    INTERACT("interact"),
    LOADING("loading"),
    PERCEIVE("perceive"),
    PROCESS("process"),
    PROVIDE("provide"),
    STORAGE("storage"),
    TRANSFER("transfer");

    private String ability;

    Ability(String ability) {
        this.ability = ability;
    }

    public String getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return ability;
    }
}
