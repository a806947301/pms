<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dayi.demo.common.department.model.Department" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/css/styles.css">

    <style>
        ul.pagination {
            display: inline-block;
            padding: 0;
            margin: 0;
        }

        ul.pagination li {display: inline;}

        ul.pagination li a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        .pagination li:first-child a {
            border-top-left-radius: 5px;
            border-bottom-left-radius: 5px;
        }

        .pagination li:last-child a {
            border-top-right-radius: 5px;
            border-bottom-right-radius: 5px;
        }

        ul.pagination li a.active {
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
        }

        ul.pagination li a:hover:not(.active) {background-color: #ddd;}
    </style>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <jsp:include page="page_head.jsp"></jsp:include>

    <div class="main-container">

        <jsp:include page="page_left.jsp"></jsp:include>

        <div class="content">
            <div class="container-fluid">
                <div class="row ">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                部门管理
                            </div>

                            <div class="card-body p-0">
                                <%--<div class="p-4">
                                    <canvas id="line-chart" width="100%" height="20"></canvas>
                                </div>--%>
                                    <table class="table table-striped" id="departmentTable">
                                        <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>部门名称</th>
                                            <th>创建时间</th>
                                            <th>更新时间</th>
                                            <th>
                                                <button class="btn btn-outline-success" data-toggle="modal" data-target="#modal-10">
                                                    <i class="fa fa-align-center"></i> &nbsp; 添加部门
                                                </button>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <tr>
                                            <td> id {{message}}</td>
                                            <td> DepartmentName</td>
                                            <td> AddTime</td>
                                            <td> UpdateTime</td>
                                            <td>
                                                <button class="btn btn-outline-warning" data-toggle="modal" data-target="#modal-12">
                                                    <i class="fa fa-clipboard"></i> &nbsp; 修改
                                                </button>
                                                <button class="btn btn-outline-danger" data-toggle="modal" data-target="#modal-8">
                                                    <i class="fa fa-trash"></i>&nbsp; 删除
                                                </button>
                                            </td>
                                        </tr>

                                        </tbody>
                                    </table>


                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                    <ul class="pagination pagination-lg">
                                        <li><a href="#">&laquo;</a></li>
                                        <li><a href="#" class="active">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">&raquo;</a></li>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>




                    More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
                </div>


                <%--<div class="row ">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                Total Users
                            </div>

                            <div class="card-body p-0">
                                <div class="p-4">
                                    <canvas id="line-chart" width="100%" height="20"></canvas>
                                </div>

                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                    <div class="text-center">
                                        <div class="text-muted small">Total Traffic</div>
                                        <div>12,457 Users (40%)</div>
                                    </div>

                                    <div class="text-center">
                                        <div class="text-muted small">Banned Users</div>
                                        <div>95,333 Users (5%)</div>
                                    </div>

                                    <div class="text-center">
                                        <div class="text-muted small">Page Views</div>
                                        <div>957,565 Pages (50%)</div>
                                    </div>

                                    <div class="text-center">
                                        <div class="text-muted small">Total Downloads</div>
                                        <div>957,565 Files (100 TB)</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
                </div>--%>
            </div>
        </div>
    </div>

</div>
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/popper.js/popper.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/vendor/chart.js/chart.min.js"></script>
<script src="/js/carbon.js"></script>
<script src="/js/demo.js"></script>
<script src="/js/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    var vm = new Vue({
        el:"#departmentTable" ,
        data:{
            message:"hello",
            departments:null
        },
        created:function (){
            console.log("111")
            params = new URLSearchParams();
            params.append("page",1);
            axios
                .post("/department/departmentPage")
                .then(function (response) {
                   vm.departments = eval('(' + response.data + ')').pageInfo;

                })
        },


    })
</script>

</body>


</html>
