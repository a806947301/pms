<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <a href="index.html" class="nav-link active">
                    <i class="icon icon-speedometer"></i> Dashboard
                </a>
            </li>
            <%--用户系统--%>
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-energy"></i> 用户系统 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/department/departmentManeger" class="nav-link">
                            <i class="icon icon-energy"></i> 部门管理
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="buttons.html" class="nav-link">
                            <i class="icon icon-energy"></i> Buttons
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="cards.html" class="nav-link">
                            <i class="icon icon-energy"></i> Cards
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="modals.html" class="nav-link">
                            <i class="icon icon-energy"></i> Modals
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="tabs.html" class="nav-link">
                            <i class="icon icon-energy"></i> Tabs
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="progress-bars.html" class="nav-link">
                            <i class="icon icon-energy"></i> Progress Bars
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="widgets.html" class="nav-link">
                            <i class="icon icon-energy"></i> Widgets
                        </a>
                    </li>
                </ul>
            </li>
            <!-- 产品 -->
            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-target"></i> 产品 <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="/product/addProductPage" class="nav-link">
                            <i class="icon icon-target"></i> 创建产品
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="layouts-fixed-sidebar.html" class="nav-link">
                            <i class="icon icon-target"></i> Fixed Sidebar
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="layouts-fixed-header.html" class="nav-link">
                            <i class="icon icon-target"></i> Fixed Header
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="layouts-hidden-sidebar.html" class="nav-link">
                            <i class="icon icon-target"></i> Hidden Sidebar
                        </a>
                    </li>
                </ul>
            </li>



            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-graph"></i> Charts <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="chartjs.html" class="nav-link">
                            <i class="icon icon-graph"></i> Chart.js
                        </a>
                    </li>
                </ul>
            </li>

            <li class="nav-item">
                <a href="forms.html" class="nav-link">
                    <i class="icon icon-puzzle"></i> Forms
                </a>
            </li>

            <li class="nav-item">
                <a href="tables.html" class="nav-link">
                    <i class="icon icon-grid"></i> Tables
                </a>
            </li>

            <li class="nav-title">More</li>

            <li class="nav-item nav-dropdown">
                <a href="#" class="nav-link nav-dropdown-toggle">
                    <i class="icon icon-umbrella"></i> Pages <i class="fa fa-caret-left"></i>
                </a>

                <ul class="nav-dropdown-items">
                    <li class="nav-item">
                        <a href="blank.html" class="nav-link">
                            <i class="icon icon-umbrella"></i> Blank Page
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
