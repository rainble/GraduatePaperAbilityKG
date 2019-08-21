package cn.edu.fudan.selab.abilitykg.DAO;


import cn.edu.fudan.selab.abilitykg.Domain.ProcessDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface ProcessDAO {

    ProcessDTO queryProcessById(@Param("processId")int processId);

}
