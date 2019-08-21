package cn.edu.fudan.selab.abilitykg.Domain;

import java.util.Arrays;
import java.util.List;

public class Location {

    private List<AbilityDesc> abilityList;
    private int locationId;
    private String label;
    private int[] reachableLocation;

    public void setReachableLoaction(int[] reachableLoaction) {
        this.reachableLocation = reachableLoaction;
    }

    public int[] getReachableLoaction() {
        return reachableLocation;
    }

    @Override
    public String toString() {
        return "Location{" +
                "abilityList=" + abilityList.toString() +
                ", locationId=" + locationId +
                ", label='" + label + '\'' +
                ", reachableLocation=" + reachableLocation.toString() +
                '}';
    }

    public void setAbilityList(List<AbilityDesc> abilityList) {
        this.abilityList = abilityList;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<AbilityDesc> getAbilityList() {
        return abilityList;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getLabel() {
        return label;
    }
}
