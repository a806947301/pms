import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.controller.UserController;
import com.dayi.demo.statistic.service.ProductStatisticService;
import com.dayi.demo.statistic.service.UserStatisticService;
import com.dayi.demo.user.service.UserService;
import org.apache.commons.io.FileUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author wut
 */
public class Test extends SpringTestBase{


    @org.junit.Test
    public void test() {
        String path = "D:\\JAVA";
        File f = new File(path);
        System.out.println(f.exists());
        System.out.println(f.isDirectory());
        /*try {
            FileUtils.deleteDirectory(f);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
