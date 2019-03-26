package com.dayi.demo.statistic.service.impl;

import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.statistic.model.dto.UserBugDto;
import com.dayi.demo.statistic.service.UserStatisticService;
import com.dayi.demo.statistic.model.vo.UserBugVo;
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
import java.util.LinkedList;
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
    public List<UserBugDto> doStatisicDeveloper() {
        //获取开发人员角色
        Role role = roleService.getRoleByRoleName(DEVELOPER_NAME);
        //获取所有开发人员
        List<User> users = userService.findByUserRole(null, role.getId());
        //获取开发人员id对应的bug量
        Map<String, UserBugVo> developerVoMap = bugService.countBugByProcesser();
        return doPackageUser(users, developerVoMap);
    }

    @Override
    public List<UserBugDto> doStatisicTester() {
        //获取测试人员角色
        Role role = roleService.getRoleByRoleName(TESTER_NAME);
        //获取所有测试人员
        List<User> users = userService.findByUserRole(null, role.getId());
        //获取测试人员id对应的bug量
        Map<String, UserBugVo> testerVoMap = bugService.countBugByProposer();
        return doPackageUser(users, testerVoMap);
    }


    @Override
    public void exportExcelDeveloper(OutputStream out) throws IOException {
        List<UserBugDto> developers = doStatisicDeveloper();
        doExportExcelUser(developers, out);
    }

    @Override
    public void exportExcelTester(OutputStream out) throws IOException {
        List<UserBugDto> testers = doStatisicTester();
        doExportExcelUser(testers,out);
    }

    /**
     * 把用户Dto List封装成Excel，并用输出流输出
     *
     * @param list
     * @param out
     * @throws IOException
     */
    public void doExportExcelUser(List<UserBugDto> list, OutputStream out) throws IOException {
        final int maxCellNumber = 5;
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
        titleCells[3].setCellValue("验收中Bug");
        titleCells[4].setCellValue("已完成Bug");
        titleCells[5].setCellValue("Bug总数");
        int bodyLength = 0;
        for (UserBugDto user : list) {
            // 创建标题一行及单元格
            XSSFRow bodyRow = sheet.createRow(rowNumber++);
            XSSFCell[] bodyCells = ExcelUtil.createCells(bodyRow, maxCellNumber, bodyStyle);
            //插入数据到单元格
            bodyCells[0].setCellValue(bodyLength++);
            bodyCells[1].setCellValue(user.getName());
            bodyCells[2].setCellValue(user.getDesignate());
            bodyCells[3].setCellValue(user.getChecking());
            bodyCells[4].setCellValue(user.getFinished());
            bodyCells[5].setCellValue(user.getBugNumber());

        }
        ExcelUtil.setSizeColumn(sheet, rowNumber, maxCellNumber);
        // 把Excel写入到输出流中
        workBook.write(out);
        out.flush();
        //操作结束，关闭流
        out.close();
    }

    /**
     * 封装成用户Bug Dto的List
     *
     * @param users
     * @param bugMap
     * @return
     */
    private List<UserBugDto> doPackageUser(List<User> users, Map<String, UserBugVo> bugMap) {
        List<UserBugDto> userBugDtos = new LinkedList<UserBugDto>();
        UserBugDto userDto;
        for (User user : users) {
            //封装成Dto
            userDto = new UserBugDto(bugMap.get(user.getId()));
            userDto.setUserId(user.getId());
            userDto.setName(user.getName());

            //添加到list
            userBugDtos.add(userDto);
        }
        return userBugDtos;
    }

}
