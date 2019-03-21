<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dayi.demo.user.model.Department" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>部门管理</title>
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

                            <div class="card-body p-0"  id="departmentTable">
                                <%--<div class="p-4">
                                    <canvas id="line-chart" width="100%" height="20"></canvas>
                                </div>--%>
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>部门名称</th>
                                            <th>创建时间</th>
                                            <th>更新时间</th>
                                            <th>
                                                <button class="btn btn-outline-success" data-toggle="modal" data-target="#addDepartmentModal" onclick="beforeAdd()">
                                                    <i class="fa fa-align-center"></i> &nbsp; 添加部门
                                                </button>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <%--<tr>
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
                                        </tr>--%>
                                        <tr v-for="department in departments.list" key="department.id">
                                            <td>{{department.id}}</td>
                                            <td>{{department.departmentName}}</td>
                                            <td>{{crtTimeFtt(department.addTime)}}</td>
                                            <td>{{crtTimeFtt(department.updateTime)}}</td>
                                            <td>
                                                <button class="btn btn-outline-warning" data-toggle="modal" data-target="#updateDepartmentModal"
                                                        v-on:click="beforeUpdate(department.id,department.departmentName)">
                                                    <i class="fa fa-clipboard"></i> &nbsp; 修改
                                                </button>
                                                <button class="btn btn-outline-danger" v-on:click="deleteDepartment(department.id)">
                                                    <i class="fa fa-trash"></i>&nbsp; 删除
                                                </button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>


                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                    <ul class="pagination pagination-lg" v-if="departments.pageNum <= departments.pages && departments.pageNum >= 3">
                                        <li><a v-on:Click="getPage(departments.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(departments.pageNum-2)" href="javascript:void(0);" v-show="departments.pages>=departments.pageNum-2"  v-bind:class="{'active':(departments.pageNum==2)}">{{departments.pageNum-2}}</a></li>
                                        <li><a v-on:Click="getPage(departments.pageNum-1)" href="javascript:void(0);" v-show="departments.pages>=departments.pageNum-1"  v-bind:class="{'active':(departments.pageNum==2)}">{{departments.pageNum-1}}</a></li>
                                        <li><a v-on:Click="getPage(departments.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{departments.pageNum}}</a></li>
                                        <li><a v-on:Click="getPage(departments.pageNum+1)" href="javascript:void(0);" v-show="departments.pages>=departments.pageNum+1" >{{departments.pageNum+1}}</a></li>
                                        <li><a v-on:Click="getPage(departments.pageNum+2)" href="javascript:void(0);" v-show="departments.pages>=departments.pageNum+2" >{{departments.pageNum+2}}</a></li>
                                        <li><a v-on:Click="getPage(departments.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
                                    <ul class="pagination pagination-lg" v-else>
                                        <li><a v-on:Click="getPage(departments.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(departments.pageNum==1)}">1</a></li>
                                        <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="departments.pages>=2"  v-bind:class="{'active':(departments.pageNum==2)}">2</a></li>
                                        <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="departments.pages>=3"  v-bind:class="{'active':(departments.pageNum==3)}">3</a></li>
                                        <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="departments.pages>=4"  v-bind:class="{'active':(departments.pageNum==4)}">4</a></li>
                                        <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="departments.pages>=5"  v-bind:class="{'active':(departments.pageNum==5)}">5</a></li>
                                        <li><a v-on:Click="getPage(departments.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>





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
<!-- 模拟框 -->
<%-- 添加部门模拟框 --%>
<div class="modal fade" id="addDepartmentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>添加部门</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">

                    <div class="form-group">
                        <input type="text" class="form-control" id="name" v-model="departmentName"
                               placeholder="请输入部门名称">
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="addDepartment()"  data-dismiss="modal">
                    添加部门
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%-- 更新部门模拟框 --%>
<div class="modal fade" id="updateDepartmentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>更新部门</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">
                    <div class="form-group">
                        <label  class="control-label">ID</label>
                        <input type="text" class="form-control" id="id" v-model="id"
                               placeholder="部门id号" disabled>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">名称</label>
                        <input type="text" class="form-control" id="updateName" v-model="departmentName"
                               placeholder="请输入部门名称">
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="updateDepartment()"  data-dismiss="modal">
                    更新部门信息
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
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
    /** 更新部门模拟框vm */
    var updateDepartment = new Vue({
        el:"#updateDepartmentModal",
        data:{
            id:null,
            departmentName:null
        },
        methods:{
            updateDepartment:function () {
                console.log("更新部门   id = " + updateDepartment.id + "    name = "+updateDepartment.departmentName)
                params = new URLSearchParams();
                params.append("id",updateDepartment.id);
                params.append("departmentName",updateDepartment.departmentName);
                axios
                    .post("/department/updateDepartment",params)
                    .then(function (response) {
                        vm.getPage(vm.departments.pageNum);
                    })
            }
        }
    })
    /** 添加部门模拟框vm */
    var addDepartment = new Vue({
        el:"#addDepartmentModal",
        data:{
            departmentName:null
        },
        methods:{
            addDepartment:function ( ) {
                console.log("添加部门"+addDepartment.departmentName);
                params = new URLSearchParams();
                params.append("departmentName",addDepartment.departmentName);
                axios
                    .post("/department/addDepartment",params)
                    .then(function (response) {
                        vm.getPage(vm.departments.pageNum);
                    })
            }
        }
    })
    /** 显示部门 */
    var vm = new Vue({
        el:"#departmentTable" ,
        data:{
            message:"hello",
            departments:{
                list:null

            }
        },
        created:function (){
            params = new URLSearchParams();
            params.append("currentPage",1);
            params.append("pageSize",5);
            axios
                .post("/department/findDepartment",params)
                .then(function (response) {
                   vm.departments = response.data;

                })
        },
        methods:{
            getPage:function(currentPage) {
                if (currentPage<=0) {
                    return;
                }
                if (currentPage>vm.departments.pages) {
                    return;
                }

                params = new URLSearchParams();
                params.append("currentPage",currentPage);
                params.append("pageSize",5);
                axios
                    .post("/department/findDepartment",params)
                    .then(function (response) {
                        vm.departments = response.data;
                    })
            },
            beforeUpdate:function(id,departmentName)
            {
                updateDepartment.id = id;
                updateDepartment.departmentName = departmentName;
            },
            deleteDepartment:function(id) {
                params = new URLSearchParams();
                params.append("id",id);
                axios
                    .post("/department/deleteDepartment",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.getPage(vm.departments.pageNum);
                    })
            }
        }

    })
    // 对Date的扩展，将 Date 转化为指定格式的String
    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    // 例子：
    // (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
    Date.prototype.Format = function(fmt)
    { //author: meizz
        var o = {
            "M+" : this.getMonth()+1,                 //月份
            "d+" : this.getDate(),                    //日
            "h+" : this.getHours(),                   //小时
            "m+" : this.getMinutes(),                 //分
            "s+" : this.getSeconds(),                 //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S"  : this.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }
    function crtTimeFtt(value){
        return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
    }
    function beforeAdd()
    {
        addDepartment.departmentName = "";
    }
    function beforeUpdate(id,departmentName)
    {
      /*  updateDepartment.id = id;
        updateDepartment.departmentName = departmentName;*/
        console.log(id);
    }

</script>

</body>


</html>
