import cn.edu.fudan.selab.abilitykg.DAO.LocationDAO;
import cn.edu.fudan.selab.abilitykg.Domain.Action;
import cn.edu.fudan.selab.abilitykg.Domain.Location;
import cn.edu.fudan.selab.abilitykg.Domain.LocationDTO;
import cn.edu.fudan.selab.abilitykg.Service.LocationService;
import cn.edu.fudan.selab.abilitykg.Service.ProcessService;
import cn.edu.fudan.selab.abilitykg.Domain.Process;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LocationServiceTest extends BaseTest {

    @Autowired
    LocationDAO locationDAO;

    @Autowired
    LocationService locationService;

    @Autowired
    ProcessService processService;

    @Test
    public void testQueryLocationByAbility() {
        String ability = "provide water";
        List<LocationDTO> locationDTO = locationDAO.queryLocationByAbility(ability);
        locationDTO.forEach(System.out::println);
        Process process = processService.queryProcessById(2);
        List<List<Location>> locationGraph = new ArrayList<>();
        for (Action action : process.getActions()) {
            List<Location> locationList = locationService.queryLocationByAbility(action);
            locationGraph.add(locationList);
        }
        locationGraph.forEach(System.out::println);
    }



}
