import com.alibaba.fastjson.JSONArray;
import com.dayi.demo.statistic.service.UserStatistic;
import com.dayi.demo.util.ExcelUtil;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author wut
 */
public class Test extends SpringTestBase{
    @Resource
    private UserStatistic userStatistics;

    @org.junit.Test
    public void test() throws Exception{
        File file = new File("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        FileOutputStream out = new FileOutputStream(file);
        JSONArray jsonArray = userStatistics.doStatisicTester();
        userStatistics.exportExcelTester(out);

    }

}
