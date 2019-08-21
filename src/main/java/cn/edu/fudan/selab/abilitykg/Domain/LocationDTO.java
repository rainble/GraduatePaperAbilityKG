package cn.edu.fudan.selab.abilitykg.Domain;

public class LocationDTO {

    private String ability;
    private int locationId;
    private String label;
    private String reachableLocation;

    @Override
    public String toString() {
        return "LocationDTO{" +
                "ability='" + ability + '\'' +
                ", locationId=" + locationId +
                ", label='" + label + '\'' +
                ", reachableLocation='" + reachableLocation + '\'' +
                '}';
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setReachableLocation(String reachableLocation) {
        this.reachableLocation = reachableLocation;
    }

    public String getAbility() {
        return ability;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getLabel() {
        return label;
    }

    public String getReachableLocation() {
        return reachableLocation;
    }
}
