package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.DAO.LocationDAO;
import cn.edu.fudan.selab.abilitykg.Domain.*;
import cn.edu.fudan.selab.abilitykg.Utils.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationDAO locationDAO;

    public List<Location> queryLocationByAbility(Action action) {
        String ability = action.getMatchTemp();
        List<LocationDTO> locationDTO = locationDAO.queryLocationByAbility(ability);
        List<Location> result = new ArrayList<>();
        for (LocationDTO dto : locationDTO) {
            Location tmp = new Location();
            tmp.setLabel(dto.getLabel());
            tmp.setLocationId(dto.getLocationId());
            tmp.setReachableLoaction(transferReachableLocation(dto.getReachableLocation()));
            List<AbilityDesc> abilityDescList = transferAbility(dto.getAbility());
            tmp.setAbilityList(abilityDescList);
            result.add(tmp);
        }
        return result;
    }

    public List<AbilityDesc> transferAbility(String ability) {
        List<AbilityDesc> abilityDescList = new ArrayList<>();
        String[] abilities = ability.split(";");
        for (String s : abilities) {
            String[] s1 = s.split(" ");
            AbilityDesc abilityDesc = new AbilityDesc();
            for (Ability ability1 : Ability.values()) {
                if (ability1.getAbility().equals(s1[0])){
                    abilityDesc.setVerb(ability1);
                }
            }
            abilityDesc.setObject(s1[1]);
            abilityDescList.add(abilityDesc);
        }
        return abilityDescList;
    }

    public int[] transferReachableLocation(String reachableLoaction) {
        String[] tmp = reachableLoaction.split(",");
        int[] result = new int[tmp.length];
        int i = 0;
        for (String s : tmp) {
            result[i++] = Integer.valueOf(s);
        }
        return result;
    }

//    public class EdgeNode {
//        public int adjvex;
//        public VertexNode next;
//        public int weight;
//    }
//
//    public class VertexNode {
//        public int vexId;
//        public EdgeNode first;
//    }
//
//    public class AdjList {
//        public VertexNode[] vertexNodes = new VertexNode[Parameters.MAX_LOCATION_NUMBER] ;
//    }
//
//    //需要整栋楼每一个location的reachableLocation
//    public void transferToAdjList(String[] reachableLoaction) {
//        VertexNode[] loactionGraph = new VertexNode[Parameters.MAX_LOCATION_NUMBER];
//        int i = 0;
//        for (String s : reachableLoaction) {
//            String[] locations = s.split(",");
//            VertexNode tmpNode = new VertexNode();
//            tmpNode.vexId = i;
//            for (String ss : locations) {
//                EdgeNode tmpEdge = new EdgeNode();
//                tmpEdge.adjvex = ss.charAt(0) - '0';
//            }
//        }
//
//    }

    public int[][] transferToGraph(List<Location> locationList) {
        String[] reachableLocations = new String[locationList.size()];
        int[][] locationGraph = new int[locationList.size()][locationList.size()];
        int i = 0;
        for (Location location : locationList) {
//            reachableLocations[i++] = location.getReachableLoaction();
        }
        int j = 1;
        for (String s : reachableLocations) {
            String[] ss = s.split(",");
            for (String sss : ss) {
                locationGraph[j][sss.charAt(0) - '0'] = 1;
            }
            j++;
        }
        for (int k = 0; k < locationList.size(); k++) {
            for (int h = 0; h < locationList.size(); h++) {
                if (locationGraph[k][h] == 0 && k != h) {
                    locationGraph[k][h] = Integer.MAX_VALUE;
                }
            }
        }
        return locationGraph;
    }


}
