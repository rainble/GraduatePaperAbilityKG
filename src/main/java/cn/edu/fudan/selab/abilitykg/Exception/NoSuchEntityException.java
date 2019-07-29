package cn.edu.fudan.selab.abilitykg.Exception;

import cn.edu.fudan.selab.abilitykg.Domain.Ability;
import cn.edu.fudan.selab.abilitykg.Domain.Location;

import java.util.Queue;

public class NoSuchEntityException extends Exception{

    private Ability ability;
    private Queue<Location> location;
    public NoSuchEntityException(Ability ability, Queue<Location> location) {
        this.ability = ability;
        this.location = location;
    }

    @Override
    public String toString() {
        return "NoSuchEntityException{" +
                "ability=" + ability.toString() +
                ", location=" + location.toString() +
                '}';
    }
}
