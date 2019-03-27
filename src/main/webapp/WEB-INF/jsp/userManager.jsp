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
    <title>用户管理</title>
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
                                用户管理
                            </div>

                            <div class="card-body p-0"  id="userTable">
                                <%--<div class="p-4">
                                    <canvas id="line-chart" width="100%" height="20"></canvas>
                                </div>--%>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>姓名</th>
                                        <th>创建时间</th>
                                        <th>更新时间</th>
                                        <th>部门名称</th>
                                        <th>工号</th>
                                        <th>邮箱</th>
                                        <th>状态</th>
                                        <th>
                                            <button class="btn btn-outline-success" data-toggle="modal" data-target="#addUserModal" onclick="beforeAdd()">
                                                <i class="fa fa-align-center"></i> &nbsp; 添加用户
                                            </button>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr v-for="user in users.list" key="user.id">
                                        <td>{{user.id}}</td>
                                        <td>{{user.name}}</td>
                                        <td>{{crtTimeFtt(user.addTime)}}</td>
                                        <td>{{crtTimeFtt(user.updateTime)}}</td>
                                        <td>{{user.department.departmentName}}</td>
                                        <td>{{user.jobNumber}}</td>
                                        <td>{{user.email}}</td>
                                        <td>{{user.stopped?"停用":"启用"}}</td>
                                        <td>
                                            <button class="btn btn-outline-warning" data-toggle="modal" data-target="#updateUserModal"
                                                    v-on:click="beforeUpdate(user.id,user.name,user.jobNumber,user.department.id,user.email)" >
                                                <i class="fa fa-clipboard"></i> &nbsp; 修改
                                            </button>
                                            <button class="btn btn-outline-danger" v-on:click="updateStopped(user.id,!user.stopped)">
                                                <i class="fa fa-trash"></i>&nbsp; {{!user.stopped?"停用":"启用"}}
                                            </button>
                                            <button class="btn btn-outline-primary" data-toggle="modal" data-target="#ascribedRoleModal"
                                                    v-on:click="ascribedRoleModalVm.getHasRoles(user.id)">
                                                <i class="fa fa-magnet"></i> &nbsp; 角色
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>


                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                        <ul class="pagination pagination-lg" v-if="users.pageNum <= users.pages && users.pageNum >= 3">
                                            <li><a v-on:Click="getPage(users.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                            <li><a v-on:Click="getPage(users.pageNum-2)" href="javascript:void(0);" v-show="users.pages>=users.pageNum-2"  v-bind:class="{'active':(users.pageNum==2)}">{{users.pageNum-2}}</a></li>
                                            <li><a v-on:Click="getPage(users.pageNum-1)" href="javascript:void(0);" v-show="users.pages>=users.pageNum-1"  v-bind:class="{'active':(users.pageNum==2)}">{{users.pageNum-1}}</a></li>
                                            <li><a v-on:Click="getPage(users.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{users.pageNum}}</a></li>
                                            <li><a v-on:Click="getPage(users.pageNum+1)" href="javascript:void(0);" v-show="users.pages>=users.pageNum+1" >{{users.pageNum+1}}</a></li>
                                            <li><a v-on:Click="getPage(users.pageNum+2)" href="javascript:void(0);" v-show="users.pages>=users.pageNum+2" >{{users.pageNum+2}}</a></li>
                                            <li><a v-on:Click="getPage(users.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                        </ul>
                                        <ul class="pagination pagination-lg" v-else>
                                            <li><a v-on:Click="getPage(users.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                            <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(users.pageNum==1)}">1</a></li>
                                            <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="users.pages>=2"  v-bind:class="{'active':(users.pageNum==2)}">2</a></li>
                                            <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="users.pages>=3"  v-bind:class="{'active':(users.pageNum==3)}">3</a></li>
                                            <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="users.pages>=4"  v-bind:class="{'active':(users.pageNum==4)}">4</a></li>
                                            <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="users.pages>=5"  v-bind:class="{'active':(users.pageNum==5)}">5</a></li>
                                            <li><a v-on:Click="getPage(users.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
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
<%-- 添加用户模拟框 --%>
<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>添加用户</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <div class="form-group">
                        <label  class="control-label">姓名</label>
                        <input type="text" class="form-control" id="addName" v-model="name"
                               placeholder="输入姓名">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">工号</label>
                        <input type="text" class="form-control" id="addJobNumber" v-model="jobNumber"
                               placeholder="输入工号">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">部门</label>
                        <select class="form-control" v-model="departmentId" id="addUserDepartmentId">
                            <option v-for="(department,index) in departmentList" v-bind:value="department.id">{{department.departmentName}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">邮箱</label>
                        <input type="text" class="form-control" id="addEmail" v-model="email"
                               placeholder="输入邮箱">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">密码</label>
                        <input type="text" class="form-control" id="addPassword" v-model="password"
                               placeholder="输入密码">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="addUser()"  data-dismiss="modal">
                    添加用户
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%-- 更新部门模拟框 --%>
<div class="modal fade" id="updateUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>更新用户</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <div class="form-group">
                        <label  class="control-label">id</label>
                        <input type="text" class="form-control" id="updatePassword" v-model="id"
                               disabled>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">姓名</label>
                        <input type="text" class="form-control" id="updateName" v-model="name"
                               placeholder="输入姓名">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">工号</label>
                        <input type="text" class="form-control" id="updateJobNumber" v-model="jobNumber"
                               placeholder="输入工号">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">部门</label>
                        <select class="form-control" id="updateUserList" v-model="departmentId">
                            <option v-for="(department,index) in departmentList" v-bind:value="department.id" >{{department.departmentName}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">邮箱</label>
                        <input type="text" class="form-control" id="updateEmail" v-model="email"
                               placeholder="输入邮箱">
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="updateUser()"  data-dismiss="modal">
                    更新用户
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%-- 赋予角色模拟框 --%>
<div class="modal fade" id="ascribedRoleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>赋予角色</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">
                <div class="row">
                     <div class="card col-md-6">
                        <div class="card-header">
                            已有角色
                        </div>
                        <div class="card-body">
                            <div class="row pre-scrollable">
                                <table class="table table-hover">
                                    <tbody>
                                    <tr v-for="role in hasRoles">
                                        <td>{{role.roleName}}</td>
                                        <td>
                                            <button class="btn btn-outline-danger btn-sm" type="button"
                                                    v-on:click="cancelRole(role.id)">
                                                移除角色
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                     <div class="card col-md-6">
                        <div class="card-header">
                            未获得角色
                        </div>
                        <div class="card-body">
                            <div class="row pre-scrollable">
                                <table class="table table-hover">
                                    <tbody>
                                    <tr v-for="role in havnRoles">
                                        <td>{{role.roleName}}</td>
                                        <td>
                                            <button class="btn btn-outline-success btn-sm" type="button"
                                                    v-on:click="ascribedRole(role.id)">
                                                增加角色
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
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
    var updateUser = new Vue({
        el:"#updateUserModal",
        data:{
            id:null,
            name:null,
            jobNumber:null,
            departmentId:null,
            email:null,
            password:null,
            departmentList:null
        },
        created:function(){
        axios
                .post("/department/finfAllDepartment")
                .then(function (response) {
                    updateUser.departmentList = response.data.obj;
                })
        },
        methods:{
            updateUser:function () {
                params = new URLSearchParams();
                params.append("id",updateUser.id);
                params.append("name",updateUser.name);
                params.append("jobNumber",updateUser.jobNumber);
                params.append("department.id",updateUser.departmentId);
                params.append("email",updateUser.email);
                axios
                    .post("/user/updateUser",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.getPage(vm.users.pageNum);
                    })
            }
        }
    })
    /** 添加用户模拟框vm */
    var addUser = new Vue({
        el:"#addUserModal",
        data:{
            name:null,
            jobNumber:null,
            departmentId:null,
            email:null,
            password:null,
            departmentList:null
        },
        created:function(){
            axios
                .post("/department/finfAllDepartment")
                .then(function (response) {
                    addUser.departmentList = response.data.obj;
                })
        },
        methods:{
            addUser:function ( ) {
                /*console.log("姓名："+addUser.name + "    工号："+addUser.jobNumber + "    部门id："+addUser.departmentId
                    + "    邮箱："+addUser.email + "    密码：" + addUser.password)*/
                params = new URLSearchParams();
                params.append("name",addUser.name);
                params.append("jobNumber",addUser.jobNumber);
                params.append("department.id",addUser.departmentId);
                params.append("email",addUser.email);
                params.append("password",addUser.password);
                axios
                    .post("/user/addUser",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.getPage(vm.users.pageNum);
                    })
            }
        }
    })
    /** 显示用户 */
    var vm = new Vue({
        el:"#userTable" ,
        data:{
            message:"hello",
            users:{
                list:null

            }
        },
        created:function (){
            params = new URLSearchParams();
            params.append("currentPage",1);
            params.append("pageSize",5);
            axios
                .post("/user/findUser",params)
                .then(function (response) {
                    vm.users =  response.data.obj ;

                })
        },
        methods:{
            getPage:function(currentPage) {
                if(currentPage<=0)
                {
                    return;
                }
                if(currentPage>vm.users.pages)
                {
                    return;
                }

                params = new URLSearchParams();
                params.append("currentPage",currentPage);
                params.append("pageSize",5);
                axios
                    .post("/user/findUser",params)
                    .then(function (response) {
                        vm.users =  response.data.obj ;
                    })
            },
            beforeUpdate:function(id,name,jobNumber,departmentId,email) {
                updateUser.id = id;
                updateUser.name = name;
                updateUser.jobNumber = jobNumber;
                updateUser.email = email;
                updateUser.departmentId=departmentId;
            },
            updateStopped:function(id,stopped) {
                params = new URLSearchParams();
                params.append("id",id);
                params.append("stopped",stopped)
                axios
                    .post("/user/updateUser",params)
                    .then(function (response) {
                        alert(response.data.msg)
                        vm.getPage(vm.users.pageNum);
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
        addUser.name=""
        addUser.jobNumber=""
        addUser.email=""
        addUser.password=""
    }
    function beforeUpdate(id,departmentName)
    {
        /*  updateDepartment.id = id;
          updateDepartment.departmentName = departmentName;*/
        console.log(id);
    }

    var ascribedRoleModalVm = new Vue({
        el:'#ascribedRoleModal',
        data:{
            userId:null,
            roles:{},
            hasRoles:{},
            havnRoles:{}
        },
        created:function(){
            axios
                .post("/role/findAllRole")
                .then(function (response) {
                    ascribedRoleModalVm.roles = response.data.obj;
                })
        },
        methods:{
            getHasRoles:function(id){
                this.userId = id;
                params = new URLSearchParams();
                params.append("userId",this.userId);
                axios
                    .post("/role/findRoleByUserId",params)
                    .then(function (response) {
                        ascribedRoleModalVm.hasRoles = response.data.obj;
                        ascribedRoleModalVm.havnRoles = array_difference(ascribedRoleModalVm.roles,ascribedRoleModalVm.hasRoles);
                    })
            },
            ascribedRole:function(roleId) {
                params = new URLSearchParams();
                params.append("userId",this.userId);
                params.append("roleId",roleId);
                axios
                    .post("/role/ascribedRole",params)
                    .then(function (response) {
                        if(response.data.success == true) {
                            ascribedRoleModalVm.getHasRoles(ascribedRoleModalVm.userId);
                        } else {
                            alert(response.data.msg);
                        }
                    })
            },
            cancelRole:function(roleId) {
                params = new URLSearchParams();
                params.append("userId",this.userId);
                params.append("roleId",roleId);
                axios
                    .post("/role/cancelRole",params)
                    .then(function (response) {
                        if(response.data.success == true) {
                            ascribedRoleModalVm.getHasRoles(ascribedRoleModalVm.userId);
                        } else {
                            alert(response.data.msg);
                        }
                    })
            }
        }
    });
    function array_remove_repeat(a) { // 去重
        var r = [];
        for(var i = 0; i < a.length; i ++) {
            var flag = true;
            var temp = a[i];
            for(var j = 0; j < r.length; j ++) {
                if(temp === r[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                r.push(temp);
            }
        }
        return r;
    }
    function array_difference(a, b) { // 差集 a - b
                                      //clone = a
        var clone = a.slice(0);

        for(var i = 0; i < b.length; i ++) {
            var temp = b[i];
            for(var j = 0; j < clone.length; j ++) {
                if(temp.id === clone[j].id) {
                    //remove clone[j]
                    clone.splice(j,1);
                }
            }
        }
        return array_remove_repeat(clone);
    }
</script>

</body>


</html>
