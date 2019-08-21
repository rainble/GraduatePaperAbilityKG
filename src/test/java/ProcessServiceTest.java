import cn.edu.fudan.selab.abilitykg.DAO.ProcessDAO;
import cn.edu.fudan.selab.abilitykg.Domain.ProcessDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessServiceTest extends BaseTest {

    @Autowired
    ProcessDAO processDAO;

    @Test
    public void queryProcessByIdTest() {
        int processId = 2;
        ProcessDTO processDTO = processDAO.queryProcessById(processId);
        System.out.println(processDTO.toString());
    }

}
