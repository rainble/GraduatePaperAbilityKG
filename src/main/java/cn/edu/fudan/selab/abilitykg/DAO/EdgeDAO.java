package cn.edu.fudan.selab.abilitykg.DAO;

import cn.edu.fudan.selab.abilitykg.Domain.Edge;
import cn.edu.fudan.selab.abilitykg.Domain.EdgeDTO;
import org.apache.ibatis.annotations.Param;

public interface EdgeDAO {

    EdgeDTO queryEdgeByLocationId(@Param("locationId")int locationId);

}
