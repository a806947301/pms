package com.dayi.demo.statistic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.statistic.service.UserStatisticService;
import com.dayi.demo.user.model.Role;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.RoleService;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * 用户统计模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-13
 */
@Component
public class UserStatisticServiceImpl implements UserStatisticService {

    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;

    @Resource
    private BugService bugService;

    /**
     * 开发人员角色名
     */
    private static final String DEVELOPER_NAME = "开发人员";

    /**
     * 测试人员角色名
     */
    private static final String TESTER_NAME = "测试人员";

    @Override
    public JSONArray doStatisicDeveloper() {
        //获取开发人员角色
        Role role = roleService.getRoleByRoleName(DEVELOPER_NAME);
        //获取所有开发人员
        List<User> users = userService.findByUserRole(null, role.getId());
        //获取开发人员id对应的bug量
        Map<String, JSONObject> processerBugMap = bugService.countBugByProcesser();
        JSONArray userJsonArray = doPackageUserBugJsonArray(users, processerBugMap);
        return userJsonArray;
    }

    @Override
    public JSONArray doStatisicTester() {
        //获取测试人员角色
        Role role = roleService.getRoleByRoleName(TESTER_NAME);
        //获取所有测试人员
        List<User> users = userService.findByUserRole(null, role.getId());
        //获取测试人员id对应的bug量
        Map<String, JSONObject> processerBugMap = bugService.countBugByProposer();
        JSONArray userJsonArray = doPackageUserBugJsonArray(users, processerBugMap);
        return userJsonArray;
    }


    @Override
    public void exportExcelDeveloper(OutputStream out) throws IOException {
        JSONArray developers = doStatisicDeveloper();
        doExportExcelUser(developers, out);
    }

    @Override
    public void exportExcelTester(OutputStream out) throws IOException {
        JSONArray testers = doStatisicTester();
        doExportExcelUser(testers,out);
    }

    /**
     * 把人员和用户bug统计Map封装成JSONArrary
     *
     * @param users
     * @param bugMap
     * @return
     */
    public JSONArray doPackageUserBugJsonArray(List<User> users, Map<String, JSONObject> bugMap) {
        JSONArray userJsonArray = new JSONArray();
        JSONObject userJson;
        for (User user : users) {
            userJson = bugMap.get(user.getId());
            // 如果没有记录，即所有bug数都为空
            if (null == userJson) {
                userJson = new JSONObject();
                userJson.put("bugNumber", 0);
                userJson.put("designate", 0);
                userJson.put("processing", 0);
                userJson.put("checking", 0);
                userJson.put("finished", 0);
            }
            userJson.put("username", user.getName());
            userJsonArray.add(userJson);
        }
        return userJsonArray;
    }

    /**
     * 把用户JSONArray封装成Excel，并用输出流输出
     *
     * @param jsonArray
     * @param out
     * @throws IOException
     */
    public void doExportExcelUser(JSONArray jsonArray, OutputStream out) throws IOException {
        final int maxCellNumber = 6;
        // 创建工作薄
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 设置body样式
        XSSFCellStyle bodyStyle = ExcelUtil.createStyle(workBook, "宋体", Font.COLOR_NORMAL, false);
        // 设置标题样式
        XSSFCellStyle titleStyle = ExcelUtil.createStyle(workBook, "宋体", Font.COLOR_NORMAL, true);
        XSSFFont productFont = titleStyle.getFont();
        productFont.setFontHeight((short) 320);
        titleStyle.setFont(productFont);
        // 创建工作簿
        XSSFSheet sheet = workBook.createSheet();
        // 行数设置为0
        int rowNumber = 0;
        //创建表头行
        XSSFRow header = sheet.createRow(rowNumber++);
        XSSFCell[] titleCells = ExcelUtil.createCells(header, maxCellNumber, titleStyle);
        //插入数据到表头
        titleCells[0].setCellValue("序号");
        titleCells[1].setCellValue("姓名");
        titleCells[2].setCellValue("指派中Bug");
        titleCells[3].setCellValue("处理中Bug");
        titleCells[4].setCellValue("验收中Bug");
        titleCells[5].setCellValue("已完成Bug");
        titleCells[6].setCellValue("Bug总数");
        int bodyLength = 0;
        for (Object developerObj : jsonArray) {
            JSONObject developer = (JSONObject) developerObj;
            // 创建标题一行及单元格
            XSSFRow bodyRow = sheet.createRow(rowNumber++);
            XSSFCell[] bodyCells = ExcelUtil.createCells(bodyRow, maxCellNumber, bodyStyle);
            //插入数据到单元格
            bodyCells[0].setCellValue(bodyLength++);
            bodyCells[1].setCellValue((String) developer.get("username"));
            bodyCells[2].setCellValue((int) developer.get("designate"));
            bodyCells[3].setCellValue((int) developer.get("processing"));
            bodyCells[4].setCellValue((int) developer.get("checking"));
            bodyCells[5].setCellValue((int) developer.get("finished"));
            bodyCells[6].setCellValue((int) developer.get("bugNumber"));

        }
        ExcelUtil.setSizeColumn(sheet, rowNumber, maxCellNumber);
        // 把Excel写入到输出流中
        workBook.write(out);
        out.flush();
        //操作结束，关闭流
        out.close();
    }
}
