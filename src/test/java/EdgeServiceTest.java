import cn.edu.fudan.selab.abilitykg.DAO.EdgeDAO;
import cn.edu.fudan.selab.abilitykg.Domain.Edge;
import cn.edu.fudan.selab.abilitykg.Domain.EdgeDTO;
import cn.edu.fudan.selab.abilitykg.Service.EdgeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EdgeServiceTest extends BaseTest {

    @Autowired
    EdgeDAO edgeDAO;

    @Autowired
    EdgeService edgeService;

    @Test
    public void testQueryEdgeByLocationId() {
        EdgeDTO edgeDTO =  edgeDAO.queryEdgeByLocationId(1);
        System.out.println(edgeDTO.toString());
        Edge edge = edgeService.queryEdgeByLocationId(1);
        System.out.println(edge.toString());
    }

}
