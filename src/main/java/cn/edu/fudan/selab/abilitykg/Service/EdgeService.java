package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.DAO.EdgeDAO;
import cn.edu.fudan.selab.abilitykg.Domain.Ability;
import cn.edu.fudan.selab.abilitykg.Domain.AbilityDesc;
import cn.edu.fudan.selab.abilitykg.Domain.Edge;
import cn.edu.fudan.selab.abilitykg.Domain.EdgeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EdgeService {

    @Autowired
    EdgeDAO edgeDAO;

    public Edge queryEdgeByLocationId(int locationId) {
        EdgeDTO edgeDTO = edgeDAO.queryEdgeByLocationId(locationId);
        Edge edge = new Edge();
        edge.setLocationId(edgeDTO.getLocationId());
        edge.setEdgeIPAddress(edgeDTO.getEdgeIPAddress());
        edge.setAbilityDescList(transferAbility(edgeDTO.getAbility()));
        return edge;
    }


    public List<AbilityDesc> transferAbility(String ability) {
        List<AbilityDesc> abilityDescList = new ArrayList<>();
        String[] abilities = ability.split(",");
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

}
