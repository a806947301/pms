import com.alibaba.fastjson.JSONArray;
import com.dayi.demo.statistic.service.UserStatisticService;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author wut
 */
public class Test extends SpringTestBase{
    @Resource
    private UserStatisticService userStatisticsService;

    @org.junit.Test
    public void test() throws Exception{
        File file = new File("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        FileOutputStream out = new FileOutputStream(file);
        JSONArray jsonArray = userStatisticsService.doStatisicTester();
        userStatisticsService.exportExcelTester(out);

    }

}
