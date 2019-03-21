import com.dayi.demo.bug.dao.BugDao;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.statistic.dto.ProductBugDto;
import com.dayi.demo.statistic.dto.UserBugDto;
import com.dayi.demo.statistic.service.ProductStatisticService;
import com.dayi.demo.statistic.service.UserStatisticService;
import com.dayi.demo.statistic.vo.UserBugVo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-24
 */
public class Test extends SpringTestBase{

    @Resource
    UserStatisticService service;

    @org.junit.Test
    public void test(){
        service.doStatisicTester();

        System.out.println(1);

    }

}
