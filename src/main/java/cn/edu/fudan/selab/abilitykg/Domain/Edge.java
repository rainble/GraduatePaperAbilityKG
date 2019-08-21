package cn.edu.fudan.selab.abilitykg.Domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Edge {

    //这个IP地址是写在edge里的用来接收使能描述然后调用对应设备的统一接口，类似于queryDeviceByAbilityDesc
    private String edgeIPAddress;
    private int locationId;
    private List<AbilityDesc> abilityDescList;

    @Override
    public String toString() {
        return "Edge{" +
                "edgeIPAddress='" + edgeIPAddress + '\'' +
                ", locationId=" + locationId +
                ", abilityDescList='" + abilityDescList.toString() + '\'' +
                '}';
    }

    public void setEdgeIPAddress(String edgeIPAddress) {
        this.edgeIPAddress = edgeIPAddress;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    public void setAbilityDescList(List<AbilityDesc> abilityDescList) {
        this.abilityDescList = abilityDescList;
    }

    public String getEdgeIPAddress() {
        return edgeIPAddress;
    }

    public int getLocationId() {
        return locationId;
    }


    public List<AbilityDesc> getAbilityDescList() {
        return abilityDescList;
    }
}
