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
    <title>角色管理</title>
    <%--<link rel="stylesheet" href="/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/css/bootstrap-treeview.min.css">
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
                                角色管理
                            </div>

                            <div class="card-body p-0"  id="roleTable">
                                <%--<div class="p-4">
                                    <canvas id="line-chart" width="100%" height="20"></canvas>
                                </div>--%>
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>角色名称</th>
                                            <th>创建时间</th>
                                            <th>更新时间</th>
                                            <th>
                                                <button class="btn btn-outline-success" data-toggle="modal" data-target="#addRoleModal" onclick="beforeAdd()">
                                                    <i class="fa fa-align-center"></i> &nbsp; 添加角色
                                                </button>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <tr v-for="role in roles.list" key="role.id">
                                            <td>{{role.id}}</td>
                                            <td>{{role.roleName}}</td>
                                            <td>{{crtTimeFtt(role.addTime)}}</td>
                                            <td>{{crtTimeFtt(role.updateTime)}}</td>
                                            <td>
                                                <button class="btn btn-outline-warning" data-toggle="modal" data-target="#updateRoleModal"
                                                        v-on:click="beforeUpdate(role.id,role.roleName)">
                                                    <i class="fa fa-clipboard"></i> &nbsp; 修改
                                                </button>
                                                <button class="btn btn-outline-danger" v-on:click="deleteRole(role.id)">
                                                    <i class="fa fa-trash"></i>&nbsp; 删除
                                                </button>
                                                <button class="btn btn-outline-primary" data-toggle="modal" data-target="#authorizationModal"
                                                        v-on:click="beforeAuthc(role.id)">
                                                    <i class="fa fa-magnet"></i> &nbsp; 授权
                                                </button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>


                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                    <ul class="pagination pagination-lg" v-if="roles.pageNum <= roles.pages && roles.pageNum >= 3">
                                        <li><a v-on:Click="getPage(roles.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(roles.pageNum-2)" href="javascript:void(0);" v-show="roles.pages>=roles.pageNum-2"  v-bind:class="{'active':(roles.pageNum==2)}">{{roles.pageNum-2}}</a></li>
                                        <li><a v-on:Click="getPage(roles.pageNum-1)" href="javascript:void(0);" v-show="roles.pages>=roles.pageNum-1"  v-bind:class="{'active':(roles.pageNum==2)}">{{roles.pageNum-1}}</a></li>
                                        <li><a v-on:Click="getPage(roles.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{roles.pageNum}}</a></li>
                                        <li><a v-on:Click="getPage(roles.pageNum+1)" href="javascript:void(0);" v-show="roles.pages>=roles.pageNum+1" >{{roles.pageNum+1}}</a></li>
                                        <li><a v-on:Click="getPage(roles.pageNum+2)" href="javascript:void(0);" v-show="roles.pages>=roles.pageNum+2" >{{roles.pageNum+2}}</a></li>
                                        <li><a v-on:Click="getPage(roles.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
                                    <ul class="pagination pagination-lg" v-else>
                                        <li><a v-on:Click="getPage(roles.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(roles.pageNum==1)}">1</a></li>
                                        <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="roles.pages>=2"  v-bind:class="{'active':(roles.pageNum==2)}">2</a></li>
                                        <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="roles.pages>=3"  v-bind:class="{'active':(roles.pageNum==3)}">3</a></li>
                                        <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="roles.pages>=4"  v-bind:class="{'active':(roles.pageNum==4)}">4</a></li>
                                        <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="roles.pages>=5"  v-bind:class="{'active':(roles.pageNum==5)}">5</a></li>
                                        <li><a v-on:Click="getPage(roles.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>





                </div>



            </div>
        </div>
    </div>

</div>
<!-- 模拟框 -->
<%-- 添加角色模拟框 --%>
<div class="modal fade" id="addRoleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>添加角色</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">

                    <div class="form-group">
                        <input type="text" class="form-control" id="name" v-model="roleName"
                               placeholder="请输入角色名称">
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="addRole()"  data-dismiss="modal">
                    添加角色
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%-- 更新角色模拟框 --%>
<div class="modal fade" id="updateRoleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>更新角色</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">
                    <div class="form-group">
                        <label  class="control-label">ID</label>
                        <input type="text" class="form-control" v-model="id"
                               placeholder="角色id号" disabled>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">名称</label>
                        <input type="text" class="form-control" v-model="roleName"
                               placeholder="请输入角色名称">
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="updateRole()"  data-dismiss="modal">
                    更新角色信息
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--授权模拟框--%>
<div class="modal fade" id="authorizationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>授权</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body modal-content">
                <iframe class="col-md-12" frameborder="0" id="authc" name="frames" height="400px"></iframe>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="authorization()"  data-dismiss="modal">
                    授权
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
<script src="/js/bootstrap-treeview.min.js"></script>
<script>
    /** 更新角色模拟框vm */
    var updateRoleVm = new Vue({
        el:"#updateRoleModal",
        data:{
            id:null,
            roleName:null
        },
        methods:{
            updateRole:function () {
                params = new URLSearchParams();
                params.append("id",this.id);
                params.append("roleName",this.roleName);
                axios
                    .post("/role/updateRole",params)
                    .then(function (response) {
                        vm.getPage(vm.roles.pageNum);
                        if(true == response.data.success) {
                            alert("更新成功");
                        } else {
                            alert(response.data.msg);
                        }
                    })
            }
        }
    })
    /** 添加角色模拟框vm */
    var addRoleVm = new Vue({
        el:"#addRoleModal",
        data:{
            roleName:null
        },
        methods:{
            addRole:function ( ) {
                params = new URLSearchParams();
                params.append("roleName",this.roleName);
                axios
                    .post("/role/addRole",params)
                    .then(function (response) {
                        vm.getPage(vm.roles.pageNum);
                        if(true == response.data.success) {
                            alert("添加成功");
                        } else {
                            alert(response.data.msg);
                        }

                    })
            }
        }
    })
    /** 显示角色 */
    var vm = new Vue({
        el:"#roleTable" ,
        data:{
            roles:{}
        },
        created:function (){
            params = new URLSearchParams();
            params.append("currentPage",1);
            axios
                .post("/role/findRole",params)
                .then(function (response) {
                   vm.roles = response.data;
                })
        },
        methods:{
            beforeAuthc:function(id){
                authcModalVm.roleId = id;
                document.getElementById('authc').src="/authc.jsp?roleId=" + id;
            },
            getPage:function(currentPage) {
                if(currentPage<=0)
                {
                    return;
                }
                if(currentPage>vm.roles.pages)
                {
                    return;
                }

                params = new URLSearchParams();
                params.append("currentPage",currentPage);
                axios
                    .post("/role/findRole",params)
                    .then(function (response) {
                        vm.roles = response.data;
                    })
            },
            beforeUpdate:function(id,roleName)
            {
                updateRoleVm.id = id;
                updateRoleVm.roleName = roleName;
            },
            deleteRole:function(id) {
                params = new URLSearchParams();
                params.append("id",id);
                axios
                    .post("/role/deleteRole",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.getPage(vm.roles.pageNum);
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
        if(/(y+)/.test(fmt))
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
        addRoleVm.roleName = "";
    }
    var authcModalVm = new Vue({
        el:'#authorizationModal',
        data:{
            roleId:null
        },
        methods:{
            authorization:function () {
                var result = document.getElementById('authc').contentWindow.result;
                var permissions = new Array();
                for ( var i = 0; i <result.length; i++){
                    permissions[i] = result[i].id;
                }
                params = new URLSearchParams();
                params.append("roleId",this.roleId);
                params.append("permissions",permissions);
                axios
                    .post("/permission/authorization",params)
                    .then(function (response) {
                            alert(response.data.msg);
                    })

            }
        }
    })



</script>

</body>



</html>
