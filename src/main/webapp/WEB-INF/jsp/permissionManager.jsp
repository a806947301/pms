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
    <title>权限管理</title>
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
                                权限管理
                            </div>

                            <div class="card-body p-0"  id="permissionTable">
                                <%--<div class="p-4">
                                    <canvas id="line-chart" width="100%" height="20"></canvas>
                                </div>--%>
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>权限名</th>
                                            <th>字段</th>
                                            <th>是否菜单</th>
                                            <th>上级菜单id</th>
                                            <th>创建时间</th>
                                            <th>更新时间</th>
                                            <th>
                                                <button class="btn btn-outline-success" data-toggle="modal" data-target="#addPermissionModal" onclick="addPermissionVm.initModal()">
                                                    <i class="fa fa-align-center"></i> &nbsp; 添加权限
                                                </button>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <tr v-for="p in permissions.list" key="p.id">
                                            <td>{{p.id}}</td>
                                            <td>{{p.permissionName}}</td>
                                            <td>{{p.field}}</td>
                                            <td>{{p.menu}}</td>
                                            <td>{{p.parentId==""?"无":p.parentId}}</td>
                                            <td>{{crtTimeFtt(p.addTime)}}</td>
                                            <td>{{crtTimeFtt(p.updateTime)}}</td>
                                            <td>
                                                <button class="btn btn-outline-warning" data-toggle="modal" data-target="#updatePermissionModal"
                                                        v-on:click="updatePermissionVm.initModal(p.id,p.permissionName,p.field,p.menu,p.parentId)">
                                                    <i class="fa fa-clipboard"></i> &nbsp; 修改
                                                </button>
                                                <button class="btn btn-outline-danger" v-on:click="deletePermission(p.id)">
                                                    <i class="fa fa-trash"></i>&nbsp; 删除
                                                </button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>


                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                    <ul class="pagination pagination-lg" v-if="permissions.pageNum <= permissions.pages && permissions.pageNum >= 3">
                                        <li><a v-on:Click="getPage(permissions.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(permissions.pageNum-2)" href="javascript:void(0);" v-show="permissions.pages>=permissions.pageNum-2"  v-bind:class="{'active':(permissions.pageNum==2)}">{{permissions.pageNum-2}}</a></li>
                                        <li><a v-on:Click="getPage(permissions.pageNum-1)" href="javascript:void(0);" v-show="permissions.pages>=permissions.pageNum-1"  v-bind:class="{'active':(permissions.pageNum==2)}">{{permissions.pageNum-1}}</a></li>
                                        <li><a v-on:Click="getPage(permissions.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{permissions.pageNum}}</a></li>
                                        <li><a v-on:Click="getPage(permissions.pageNum+1)" href="javascript:void(0);" v-show="permissions.pages>=permissions.pageNum+1" >{{permissions.pageNum+1}}</a></li>
                                        <li><a v-on:Click="getPage(permissions.pageNum+2)" href="javascript:void(0);" v-show="permissions.pages>=permissions.pageNum+2" >{{permissions.pageNum+2}}</a></li>
                                        <li><a v-on:Click="getPage(permissions.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
                                    <ul class="pagination pagination-lg" v-else>
                                        <li><a v-on:Click="getPage(permissions.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(permissions.pageNum==1)}">1</a></li>
                                        <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="permissions.pages>=2"  v-bind:class="{'active':(permissions.pageNum==2)}">2</a></li>
                                        <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="permissions.pages>=3"  v-bind:class="{'active':(permissions.pageNum==3)}">3</a></li>
                                        <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="permissions.pages>=4"  v-bind:class="{'active':(permissions.pageNum==4)}">4</a></li>
                                        <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="permissions.pages>=5"  v-bind:class="{'active':(permissions.pageNum==5)}">5</a></li>
                                        <li><a v-on:Click="getPage(permissions.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
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
<%-- 添加权限模拟框 --%>
<div class="modal fade" id="addPermissionModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>添加权限</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label class="control-label">权限名</label>
                    <input type="text" class="form-control" v-model="permissionName"
                           placeholder="请输入权限名称"><br>
                </div>
                <div class="form-group">
                    <label class="control-label">权限字段</label>
                    <input type="text" class="form-control" v-model="field"
                           placeholder="请输入权限字段"><br>
                </div>
                <div class="form-group">
                    <label class="control-label">类别</label>
                    <select class="form-control" v-model="menu">
                        <option value="true">是一个菜单</option>
                        <option value="false">不是菜单</option>
                    </select><br>
                </div>
                <div class="form-group">
                    <label class="control-label">父级菜单</label>
                    <select class="form-control" v-model="parentId">
                        <option value="">无</option>
                        <option v-for="m in menus" v-bind:value="m.id">{{m.permissionName}}</option>
                    </select><br>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="addPermission()"  data-dismiss="modal">
                    添加权限
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%-- 更新权限模拟框 --%>
<div class="modal fade" id="updatePermissionModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>更新权限</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label class="control-label">ID</label>
                    <input type="text" class="form-control" v-model="id"
                           placeholder=""><br>
                </div>
                <div class="form-group">
                    <label class="control-label">权限名</label>
                    <input type="text" class="form-control" v-model="permissionName"
                           placeholder="请输入权限名称"><br>
                </div>
                <div class="form-group">
                    <label class="control-label">权限字段</label>
                    <input type="text" class="form-control" v-model="field"
                           placeholder="请输入权限字段"><br>
                </div>
                <div class="form-group">
                    <label class="control-label">类别</label>
                    <select class="form-control" v-model="menu">
                        <option value="true">是一个菜单</option>
                        <option value="false">不是菜单</option>
                    </select><br>
                </div>
                <div class="form-group">
                    <label class="control-label">父级菜单</label>
                    <select class="form-control" v-model="parentId">
                        <option value="">无</option>
                        <option v-for="m in menus" v-bind:value="m.id">{{m.permissionName}}</option>
                    </select><br>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="updatePermission()"  data-dismiss="modal">
                    更新权限
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
    /** 更新权限模拟框vm */
    var updatePermissionVm = new Vue({
        el:"#updatePermissionModal",
        data:{
            id:null,
            field:null,
            menu:null,
            permissionName:null,
            parentId:null,
            menus:{}
        },
        methods:{
            updatePermission:function () {
                params = new URLSearchParams();
                params.append("id",this.id);
                params.append("field",this.field);
                params.append("menu",this.menu);
                params.append("permissionName",this.permissionName);
                params.append("parentId",this.parentId);
                axios
                    .post("/permission/updatePermission",params)
                    .then(function (response) {
                        vm.getPage(vm.permissions.pageNum);
                        if("true" == response.data.success) {
                            alert("更新成功");
                        } else {
                            alert(response.data.msg);
                        }
                    })
            },
            initModal:function (id,permissionName,field,menu,parentId) {
                this.id = id;
                this.permissionName = permissionName;
                this.field = field;
                this.menu = menu;
                this.parentId = parentId;
                axios
                    .post("/permission/findPermissionMenu")
                    .then(function (response) {
                        updatePermissionVm.menus = response.data.obj;
                    })
                }

        }
    })
    /** 添加权限模拟框vm */
    var addPermissionVm = new Vue({
        el:"#addPermissionModal",
        data:{
            field:null,
            menu:null,
            permissionName:null,
            parentId:null,
            menus:{}
        },
        methods:{
            addPermission:function ( ) {
                params = new URLSearchParams();
                params.append("permissionName",this.permissionName);
                params.append("field",this.field);
                params.append("menu",this.menu);
                params.append("parentId",this.parentId);

                axios
                    .post("/permission/addPermission",params)
                    .then(function (response) {
                        vm.getPage(vm.permissions.pageNum);
                        if("true" == response.data.success) {
                            alert("添加成功");
                        } else {
                            alert(response.data.msg);
                        }

                    })
            },
            initModal:function () {
                axios
                    .post("/permission/findPermissionMenu")
                    .then(function (response) {
                        addPermissionVm.menus = response.data.obj;
                    })
            }
        }
    })
    /** 显示权限 */
    var vm = new Vue({
        el:"#permissionTable" ,
        data:{
            permissions:{}
        },
        created:function (){
            params = new URLSearchParams();
            params.append("currentPage",1);
            params.append("pageSize",5);
            axios
                .post("/permission/findPermission",params)
                .then(function (response) {
                   vm.permissions = response.data.obj;
                })
        },
        methods:{
            getPage:function(currentPage) {
                if(currentPage<=0)
                {
                    return;
                }
                if(currentPage>vm.permissions.pages)
                {
                    return;
                }

                params = new URLSearchParams();
                params.append("currentPage",currentPage);
                params.append("pageSize",5);
                axios
                    .post("/permission/findPermission",params)
                    .then(function (response) {
                        vm.permissions = response.data.obj;
                    })
            },
            beforeUpdate:function(id,roleName)
            {
                updateRoleVm.id = id;
                updateRoleVm.roleName = roleName;
            },
            deletePermission:function(id) {
                params = new URLSearchParams();
                params.append("id",id);
                axios
                    .post("/permission/deletePermission",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.getPage(vm.permissions.pageNum);
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


</script>

</body>


</html>
