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
            <shiro:hasPermission name="user">
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-energy"></i> 用户系统 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/department/departmentManegerPage" class="nav-link">
                            <i class="icon icon-energy"></i> 部门管理
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/user/userManager" class="nav-link">
                            <i class="icon icon-energy"></i> 用户管理
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/role/roleManager" class="nav-link">
                            <i class="icon icon-energy"></i> 角色管理
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/premission/premissionManger" class="nav-link">
                            <i class="icon icon-energy"></i> 权限管理
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/user/loginLogPage" class="nav-link">
                            <i class="icon icon-energy"></i> 登陆日志
                        </a>
                    </li>
                </ul>
            </li>
            </shiro:hasPermission>
            <!-- 产品 -->
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-target"></i> 产品 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/product/findProductPage" class="nav-link">
                            <i class="icon icon-target"></i> 产品列表
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="/product/addProductPage" class="nav-link">
                            <i class="icon icon-target"></i> 创建产品
                        </a>
                    </li>
                </ul>
            </li>
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-graph"></i> 项目 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/project/findProjectPage" class="nav-link">
                            <i class="icon icon-graph"></i> 项目列表
                        </a>
                    </li>
                </ul>
                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/project/addProjectPage" class="nav-link">
                            <i class="icon icon-graph"></i> 添加项目
                        </a>
                    </li>
                </ul>
            </li>



            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-umbrella"></i> 数据统计 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/product/productStatisticsPage" class="nav-link">
                            <i class="icon icon-umbrella"></i> 产品统计
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="login.html" class="nav-link">
                            <i class="icon icon-umbrella"></i> Login
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="register.html" class="nav-link">
                            <i class="icon icon-umbrella"></i> Register
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="invoice.html" class="nav-link">
                            <i class="icon icon-umbrella"></i> Invoice
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="404.html" class="nav-link">
                            <i class="icon icon-umbrella"></i> 404
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="500.html" class="nav-link">
                            <i class="icon icon-umbrella"></i> 500
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="settings.html" class="nav-link">
                            <i class="icon icon-umbrella"></i> Settings
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
