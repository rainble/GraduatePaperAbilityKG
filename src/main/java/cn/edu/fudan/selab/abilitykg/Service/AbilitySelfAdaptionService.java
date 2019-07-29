package cn.edu.fudan.selab.abilitykg.Service;

import cn.edu.fudan.selab.abilitykg.Domain.Ability;
import cn.edu.fudan.selab.abilitykg.Domain.DirectedGraph;
import cn.edu.fudan.selab.abilitykg.Domain.Entity;
import cn.edu.fudan.selab.abilitykg.Domain.Location;
import cn.edu.fudan.selab.abilitykg.Exception.NoSuchEntityException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class AbilitySelfAdaptionService {

    private int cost;

    public static final Logger logger = Logger.getLogger(AbilitySelfAdaptionService.class);

    @Autowired
    KGService kgService;

    public Entity selfAdaption(List<Ability> needAbilities, List<Ability> lackingAbilities, Location location) {

        DirectedGraph<Location> locationMap = initLocationMap();

        while (true) {
            Queue<Location> substituteLocation = locationMap.getBreadthFirstTraversal(location);
            for (Ability ability : lackingAbilities) {
                try {
                    Entity entity = kgService.askKGForEntityByAbilityAndLocation(ability, substituteLocation);
                } catch (NoSuchEntityException e) {
                    e.getStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public List<Ability>  isSubstituteAvailable() {
        return new ArrayList<>();
    }


    /**
     * 初始化当前房间的位置网格，方便做代价筛选
     * @return cn.edu.fudan.selab.abilitykg.Service.AbilitySelfAdaptionService.Graph
     * @create 2019-07-17 15:02
    **/
    public DirectedGraph initLocationMap() {

        DirectedGraph locationMap = new DirectedGraph();


        return locationMap;
    }



}
