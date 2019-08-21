package cn.edu.fudan.selab.abilitykg.Domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EdgeDTO {

    private String edgeIPAddress;
    private int locationId;
    private String ability;

    @Override
    public String toString() {
        return "Edge{" +
                "edgeIPAddress='" + edgeIPAddress + '\'' +
                ", locationId=" + locationId +
                ", ability='" + ability + '\'' +
                '}';
    }

    public void setEdgeIPAddress(String edgeIPAddress) {
        this.edgeIPAddress = edgeIPAddress;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getEdgeIPAddress() {
        return edgeIPAddress;
    }

    public int getLocationId() {
        return locationId;
    }


    public String getAbility() {
        return ability;
    }
}
