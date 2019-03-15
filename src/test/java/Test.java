import com.alibaba.fastjson.JSONArray;
import com.dayi.demo.controller.UserController;
import com.dayi.demo.statistic.service.ProductStatisticService;
import com.dayi.demo.statistic.service.UserStatisticService;
import com.dayi.demo.user.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author wut
 */
public class Test extends SpringTestBase{
    @Resource
    private UserStatisticService userStatisticsService;

    @Resource
    private ProductStatisticService productStatisticService;

    @Resource
    UserService userService;
    @Resource
    UserController userController;

    @org.junit.Test
    public void test() throws Exception{
        boolean existEmail = userService.doExistEmail("8069473011@qq.com");
        System.out.println(existEmail?"存在":"不存在");

    }

}
