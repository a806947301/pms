<%@ page import="com.dayi.demo.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar page-header">
    <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
        <i class="fa fa-bars"></i>
    </a>

    <a class="navbar-brand" href="#">
        <img src="/imgs/logo.png" alt="logo">
    </a>

    <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
        <i class="fa fa-bars"></i>
    </a>

    <ul class="navbar-nav ml-auto">
        <%--<li class="nav-item d-md-down-none">
            <a href="#">
                <i class="fa fa-bell"></i>
                <span class="badge badge-pill badge-danger">5</span>
            </a>
        </li>

        <li class="nav-item d-md-down-none">
            <a href="#">
                <i class="fa fa-envelope-open"></i>
                <span class="badge badge-pill badge-danger">5</span>
            </a>
        </li>--%>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <img src="/imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                <span class="small ml-1 d-md-down-none"><%=((User)(session.getAttribute("user"))).getName()%></span>
            </a>

            <div class="dropdown-menu dropdown-menu-right">
               <%-- <div class="dropdown-header">Account</div>

                <a href="#" class="dropdown-item">
                    <i class="fa fa-user"></i> Profile
                </a>

                <a href="#" class="dropdown-item">
                    <i class="fa fa-envelope"></i> Messages
                </a>--%>

                <div class="dropdown-header">Settings</div>

                <%--<a href="#" class="dropdown-item">
                    <i class="fa fa-bell"></i> Notifications
                </a>

                <a href="#" class="dropdown-item">
                    <i class="fa fa-wrench"></i> Settings
                </a>--%>

                <a href="javascript:void(0);" class="dropdown-item" onclick="logout()">
                    <i class="fa fa-lock"></i> 退出登陆
                </a>
            </div>
        </li>
    </ul>
</nav>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    function logout() {
        axios
            .post("/user/logout")
            .then(function (response) {
                alert(response.data.msg);
                location.reload();
            })
    }
</script>
</body>

</html>
