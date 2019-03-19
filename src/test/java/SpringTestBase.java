import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author WuTong<wut@pvc123.com>
 * @Date 2019-03-12
 */
@ContextConfiguration(locations = { "classpath:spring-dao-conf.xml" , "classpath:spring-mvc-conf.xml"
        , "classpath:spring-resources-conf.xml", "classpath:spring-shiro-conf.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestBase extends AbstractJUnit4SpringContextTests {

}
