package cn.edu.fudan.selab.abilitykg.DAO;

import org.apache.ibatis.annotations.Param;

public interface EntityDAO {

    public String queryCallUrlById(@Param("entityId")int entityId);


}
