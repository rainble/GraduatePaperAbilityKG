package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.Domain.Ability;
import cn.edu.fudan.selab.abilitykg.Domain.Entity;
import cn.edu.fudan.selab.abilitykg.Domain.Location;
import cn.edu.fudan.selab.abilitykg.Domain.Process;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AbilityMatchService {





    public List<Ability> askWarehouseForAbilities(Process process) {

        List<Ability> abilityList = new ArrayList<Ability>();


        return abilityList;
    }

    public List<Ability> abilityMatch(List<Ability> provide, List<Ability> environment) {
        List<Ability> result = new ArrayList<Ability>();
        Set<Ability> tmp = new HashSet<Ability>();
        for (Ability ability : provide) {
            tmp.add(ability);
        }
        for (Ability ability : environment) {
            if (!tmp.contains(ability)){
                result.add(ability);
            }
        }
        return result;
    }



}
