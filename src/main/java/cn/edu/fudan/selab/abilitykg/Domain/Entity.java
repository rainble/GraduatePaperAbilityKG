package cn.edu.fudan.selab.abilitykg.Domain;


import java.sql.Timestamp;

public class Entity {

    private AbilityDesc ability;
    private int entityId;
    private String LocationId;
    private boolean entityStatus;
    private String callUrl;
    private Timestamp lastCallTime;

    @Override
    public String toString() {
        return "Entity{" +
                "ability='" + ability + '\'' +
                ", entityId=" + entityId +
                ", LocationId='" + LocationId + '\'' +
                ", deviceStatus=" + entityStatus +
                ", callUrl='" + callUrl + '\'' +
                ", lastCallTime=" + lastCallTime +
                '}';
    }

    public void setAbility(AbilityDesc ability) {
        this.ability = ability;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void setLocationId(String locationId) {
        LocationId = locationId;
    }

    public void setDeviceStatus(boolean entityStatus) {
        this.entityStatus = entityStatus;
    }

    public void setCallUrl(String callUrl) {
        this.callUrl = callUrl;
    }

    public void setLastCallTime(Timestamp lastCallTime) {
        this.lastCallTime = lastCallTime;
    }

    public AbilityDesc getAbility() {
        return ability;
    }

    public int getEntityId() {
        return entityId;
    }

    public String getLocationId() {
        return LocationId;
    }

    public boolean isDeviceStatus() {
        return entityStatus;
    }

    public String getCallUrl() {
        return callUrl;
    }

    public Timestamp getLastCallTime() {
        return lastCallTime;
    }
}
