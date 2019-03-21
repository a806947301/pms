<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="sidebar">
    <nav class="sidebar-nav">
        <ul class="nav">
            <li class="nav-title">Navigation</li>

            <li class="nav-item">
                <a href="/user/index" class="nav-link active">
                    <i class="icon icon-speedometer"></i> 首页
                </a>
            </li>
            <%--用户系统--%>
            <shiro:hasPermission name="userSys">
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-energy"></i> 用户系统 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <shiro:hasPermission name="department">
                    <li class="nav-item">
                        <a href="/department/departmentManegerPage" class="nav-link">
                            <i class="icon icon-energy"></i> 部门管理
                        </a>
                    </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="user">
                    <li class="nav-item">
                        <a href="/user/userManager" class="nav-link">
                            <i class="icon icon-energy"></i> 用户管理
                        </a>
                    </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="role">
                    <li class="nav-item">
                        <a href="/role/roleManager" class="nav-link">
                            <i class="icon icon-energy"></i> 角色管理
                        </a>
                    </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="permission">
                    <li class="nav-item">
                        <a href="/permission/permissionManger" class="nav-link">
                            <i class="icon icon-energy"></i> 权限管理
                        </a>
                    </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="loginLog">
                    <li class="nav-item">
                        <a href="/user/loginLogPage" class="nav-link">
                            <i class="icon icon-energy"></i> 登陆日志
                        </a>
                    </li>
                    </shiro:hasPermission>
                </ul>
            </li>
            </shiro:hasPermission>
            <!-- 产品 -->
            <shiro:hasPermission name="product">
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-target"></i> 产品 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <shiro:hasPermission name="select:product">
                    <li class="nav-item">
                        <a href="/product/findProductPage" class="nav-link">
                            <i class="icon icon-target"></i> 产品列表
                        </a>
                    </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="add:product">
                    <li class="nav-item">
                        <a href="/product/addProductPage" class="nav-link">
                            <i class="icon icon-target"></i> 创建产品
                        </a>
                    </li>
                    </shiro:hasPermission>
                </ul>
            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="project">
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-graph"></i> 项目 <i class="fa fa-caret-left"></i>
                </a>
                <shiro:hasPermission name="select:project">
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/project/findProjectPage" class="nav-link">
                            <i class="icon icon-graph"></i> 项目列表
                        </a>
                    </li>
                </ul>
                </shiro:hasPermission>
                <shiro:hasPermission name="add:project">
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/project/addProjectPage" class="nav-link">
                            <i class="icon icon-graph"></i> 添加项目
                        </a>
                    </li>
                </ul>
                </shiro:hasPermission>
            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="statistic">
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-umbrella"></i> 数据统计 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <shiro:hasPermission name="product:statistic">
                    <li class="nav-item">
                        <a href="/statistic/productStatisticPage" class="nav-link">
                            <i class="icon icon-umbrella"></i> 产品统计
                        </a>
                    </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="developer:statistic">
                    <li class="nav-item">
                        <a href="/statistic/developerStatisticPage" class="nav-link">
                            <i class="icon icon-umbrella"></i> 开发人员统计
                        </a>
                    </li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="test:statistic">
                    <li class="nav-item">
                        <a href="/statistic/testerStatisticPage" class="nav-link">
                            <i class="icon icon-umbrella"></i> 测试人员统计
                        </a>
                    </li>
                    </shiro:hasPermission>
                </ul>
            </li>
            </shiro:hasPermission>
        </ul>
    </nav>
</div>
</body>
</html>
