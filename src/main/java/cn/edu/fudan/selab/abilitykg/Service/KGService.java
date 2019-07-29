package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.Domain.Ability;
import cn.edu.fudan.selab.abilitykg.Domain.Entity;
import cn.edu.fudan.selab.abilitykg.Domain.Location;
import cn.edu.fudan.selab.abilitykg.Exception.NoSuchEntityException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class KGService {

    public Location askKGForNearLocation(Location location) {

        Location result = new Location(location.getLabel());


        return result;
    }

    public Entity askKGForEntityByAbilityAndLocation(Ability ability, Queue<Location> location) throws Exception {

        Entity result = new Entity();

        if (result != null) {
            return result;

        } else {
            throw  new NoSuchEntityException(ability, location);
        }

    }

    public List<Ability> askKGForAbilitiesByLocation(Location location) {

        List<Ability> abilityList = new ArrayList<Ability>();


        return abilityList;
    }


}
