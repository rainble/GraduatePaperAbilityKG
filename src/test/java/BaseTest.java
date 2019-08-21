import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Spring/spring-DAO.xml", "classpath:Spring/spring-Service.xml", "classpath:Spring/spring-Controller.xml"})
public class BaseTest {
}
