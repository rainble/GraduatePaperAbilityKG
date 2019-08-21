package cn.edu.fudan.selab.abilitykg.DAO;

import cn.edu.fudan.selab.abilitykg.Domain.Ability;
import cn.edu.fudan.selab.abilitykg.Domain.Action;
import cn.edu.fudan.selab.abilitykg.Domain.Location;
import cn.edu.fudan.selab.abilitykg.Domain.LocationDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocationDAO {

//    List<Ability> queryAbilityById(@Param("locationId")int locationId);
//
//    List<Location> queryAllLoaction();

    List<LocationDTO> queryLocationByAbility(@Param("ability") String ability);

}
