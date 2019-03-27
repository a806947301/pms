<%@ page import="com.dayi.demo.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Bug</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="/css/bootstrap-select.min.css">
    <!-- simditor -->
    <%--<link rel="stylesheet" href="/simditor/styles/app.css">
    <link rel="stylesheet" href="/simditor/styles/mobile.css">--%>
    <link rel="stylesheet" href="/simditor/styles/simditor.css">
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
<%
    User user = (User)session.getAttribute("user");
%>
<div class="page-wrapper">
    <div class="page-header">
        <jsp:include page="page_head.jsp"></jsp:include>
    </div>

    <div class="main-container">
        <jsp:include page="page_left.jsp"></jsp:include>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card" id="getBug">

                            <div class="card-header bg-light">
                                <div class="row">
                                    <div class="col-md-8">{{bug.bugTitle}}</div>
                                    <div class="col-md-1">
                                        <div v-if="bug.noProcessing">

                                        </div>
                                    </div>
                                    <div class="col-md-1">
                                        <div  v-if="bug.bugStatus==2">
                                            <button class="btn btn-success">已完成</button>
                                        </div>
                                        <div  v-else-if="bug.bugStatus==1">
                                            <button class="btn btn-warning" v-if="!bug.noProcessing">验收中</button>
                                            <button class="btn btn-secondary" v-else>不予处理</button>
                                        </div>
                                        <div  v-else>
                                            <button class="btn btn-danger">指派中</button>
                                        </div>

                                    </div>
                                    <div class="col-md-1" v-if="bug.bugProposer.email == '<shiro:principal/>'">
                                        <button class="btn btn-outline-primary" type="button" v-on:click="beforeUpdate()"
                                                data-toggle="modal" data-target="#updateBug">修改</button>
                                    </div>
                                    <div class="col-md-1" v-if="bug.bugProposer.email == '<shiro:principal/>'">
                                        <button class="btn btn-outline-dark" type="button" v-on:click="deleteBug()"
                                            >删除</button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <small>处理者：{{bug.bugProcesser.name}}</small>
                                    </div>
                                    <div class="col-md-4">
                                        <small>提出者：{{bug.bugProposer.name}}</small>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body">
                                <div v-html="bug.bugContent">
                                </div>
                            </div>
                            <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                <button class="btn btn-outline-danger" type="button"
                                        v-if="(bug.bugStatus==0&&bug.bugProcesser.id=='<%=user.getId()%>') || (bug.bugStatus==1 &&bug.bugProposer.id=='<%=user.getId()%>')"
                                        data-toggle="modal" data-target="#redesignate">
                                    重新指派
                                </button>
                                <button class="btn btn-outline-info" type="button"
                                        v-if="bug.bugStatus==0 && bug.bugProcesser.id=='<%=user.getId()%>'"
                                        data-toggle="modal" data-target="#processSelf"
                                        v-on:click="">
                                    自己处理
                                </button>
                                <button class="btn btn-outline-success" type="button"
                                        v-if="bug.bugStatus==1 && bug.bugProposer.id=='<%=user.getId()%>'"
                                    v-on:click="closeBug()">关闭Bug</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8" id="bugDescriptionList">
                        <div class="card">
                            <div class="card-header bg-light">
                                <dir class="row">
                                    <div class="col-md-2">
                                        说明
                                    </div>
                                </dir>
                            </div>
                            <div class="card-body  border-top" v-for="description in descriptions.list">
                                {{description.content}}
                            </div>
                            <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                <ul class="pagination pagination-lg" v-if="descriptions.pageNum <= descriptions.pages && descriptions.pageNum >= 3">
                                    <li><a v-on:Click="getPage(descriptions.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                    <li><a v-on:Click="getPage(descriptions.pageNum-2)" href="javascript:void(0);" v-show="descriptions.pages>=descriptions.pageNum-2"  v-bind:class="{'active':(descriptions.pageNum==2)}">{{descriptions.pageNum-2}}</a></li>
                                    <li><a v-on:Click="getPage(descriptions.pageNum-1)" href="javascript:void(0);" v-show="descriptions.pages>=descriptions.pageNum-1"  v-bind:class="{'active':(descriptions.pageNum==2)}">{{descriptions.pageNum-1}}</a></li>
                                    <li><a v-on:Click="getPage(descriptions.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{descriptions.pageNum}}</a></li>
                                    <li><a v-on:Click="getPage(descriptions.pageNum+1)" href="javascript:void(0);" v-show="descriptions.pages>=descriptions.pageNum+1" >{{descriptions.pageNum+1}}</a></li>
                                    <li><a v-on:Click="getPage(descriptions.pageNum+2)" href="javascript:void(0);" v-show="descriptions.pages>=descriptions.pageNum+2" >{{descriptions.pageNum+2}}</a></li>
                                    <li><a v-on:Click="getPage(descriptions.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                                <ul class="pagination pagination-lg" v-else>
                                    <li><a v-on:Click="getPage(descriptions.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                    <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(descriptions.pageNum==1)}">1</a></li>
                                    <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="descriptions.pages>=2"  v-bind:class="{'active':(descriptions.pageNum==2)}">2</a></li>
                                    <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="descriptions.pages>=3"  v-bind:class="{'active':(descriptions.pageNum==3)}">3</a></li>
                                    <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="descriptions.pages>=4"  v-bind:class="{'active':(descriptions.pageNum==4)}">4</a></li>
                                    <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="descriptions.pages>=5"  v-bind:class="{'active':(descriptions.pageNum==5)}">5</a></li>
                                    <li><a v-on:Click="getPage(descriptions.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-4" id="bugOperatingRecord">
                        <div class="card">
                            <div class="card-header bg-light">
                                <dir class="row">
                                    <div class="col-md-12">
                                        操作记录
                                    </div>
                                </dir>
                            </div>
                            <div class="card-body  border-top" v-for="record in records.list">
                                {{record.user.name}}
                                <font v-if="record.operationNumber==0">指派</font>
                                <font v-else-if="record.operationNumber==1">设置自己处理</font>
                                <font v-else-if="record.operationNumber==2">设置不予处理</font>
                                <font v-else-if="record.operationNumber==3">添加说明</font>
                                <font v-else>关闭Bug</font>
                                <font v-if="record.operationUser != null">{{record.operationUser.name}}</font>
                                <br>
                            </div>
                            <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                <ul class="pagination pagination-lg" v-if="records.pageNum <= records.pages && records.pageNum >= 3">
                                    <li><a v-on:Click="getPage(records.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                    <li><a v-on:Click="getPage(records.pageNum-2)" href="javascript:void(0);" v-show="records.pages>=records.pageNum-2"  v-bind:class="{'active':(records.pageNum==2)}">{{records.pageNum-2}}</a></li>
                                    <li><a v-on:Click="getPage(records.pageNum-1)" href="javascript:void(0);" v-show="records.pages>=records.pageNum-1"  v-bind:class="{'active':(records.pageNum==2)}">{{records.pageNum-1}}</a></li>
                                    <li><a v-on:Click="getPage(records.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{records.pageNum}}</a></li>
                                    <li><a v-on:Click="getPage(records.pageNum+1)" href="javascript:void(0);" v-show="records.pages>=records.pageNum+1" >{{records.pageNum+1}}</a></li>
                                    <li><a v-on:Click="getPage(records.pageNum+2)" href="javascript:void(0);" v-show="records.pages>=records.pageNum+2" >{{records.pageNum+2}}</a></li>
                                    <li><a v-on:Click="getPage(records.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                                <ul class="pagination pagination-lg" v-else>
                                    <li><a v-on:Click="getPage(records.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                    <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(records.pageNum==1)}">1</a></li>
                                    <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="records.pages>=2"  v-bind:class="{'active':(records.pageNum==2)}">2</a></li>
                                    <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="records.pages>=3"  v-bind:class="{'active':(records.pageNum==3)}">3</a></li>
                                    <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="records.pages>=4"  v-bind:class="{'active':(records.pageNum==4)}">4</a></li>
                                    <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="records.pages>=5"  v-bind:class="{'active':(records.pageNum==5)}">5</a></li>
                                    <li><a v-on:Click="getPage(records.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
               <%-- <div class="row" id="addBugDescription">
                    <div class="card col-md-12">
                        <div class="card-header bg-light">
                            添加说明
                        </div>
                        <div class="card-body text-center">
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea><br>
                            <button class="btn btn-block btn-info" type="button">提交说明</button>
                        </div>

                    </div>
                </div>--%>
            </div>
        </div>
    </div>
</div>
<%--自己处理选项模拟框--%>
<div class="modal fade" id="processSelf" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" >自己处理Bug</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <button class="btn btn-block btn-outline-warning" type="button" data-dismiss="modal"
                        onClick="vm.noProcessing()">设置不予处理</button>
                <button class="btn btn-block btn-outline-primary" type="button" data-dismiss="modal"
                        data-toggle="modal" data-target="#addDescription">添加说明</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--重新指派模拟框--%>
<div class="modal fade" id="redesignate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">选择重新指派对象</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <select class="form-control" v-model="processer">
                    <option v-for="user in users" v-bind:value="user.id">{{user.department.departmentName}}-{{user.name}}</option>
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" v-on:click="redesignate()">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--添加说明模拟框--%>
<div class="modal fade" id="addDescription" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" >输入要添加的说明</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <textarea class="form-control"  rows="3" v-model="content"></textarea><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" v-on:click="addBugDescription()">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--更新Bug信息模拟框--%>
<div class="modal fade bs-example-modal-lg" id="updateBug" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" style="width: 1000px;">
            <div class="modal-header">
                <h4 class="modal-title" >修改Bug</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label><h5>标题</h5></label>
                    <input type="text" class="form-control" v-model="title">
                </div>
                <div class="form-group">
                    <label><h5>内容</h5></label>
                    <textarea id="editor" placeholder="Balabala" autofocus></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" v-on:click="updateBug()">提交更改</button>
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
<script src="/js/bootstrap-select.min.js"></script>
<script src="/js/i18n/defaults-zh_CN.min.js"></script>
<%-- Simditor --%>
<script src="/simditor/scripts/module.js"></script>
<script src="/simditor/scripts/uploader.js"></script>
<script src="/simditor/scripts/hotkeys.js"></script>
<script src="/simditor/scripts/simditor.js"></script>
<%--vue--%>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/js/vue.min.js"></script>

<script>

    var updateVm = new Vue({
        el:"#updateBug",
        data:{
            bugId:null,
            title:null
        },
        methods:{
            updateBug:function() {
                params = new URLSearchParams();
                params.append("id", this.bugId);
                params.append("bugTitle", this.title);
                params.append("bugContent", editor.getValue());
                axios
                    .post("/bug/updateBug",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.getBug();
                    });


            }

        }
    })
    var bugOperatingRecordVm = new Vue({
        el:'#bugOperatingRecord',
        data:{
            bugId:null,
            records:{
                list:null
            }
        },
        created:function() {
            this.bugId = window.location.href.split('/')[window.location.href.split('/').length-1];
            params = new URLSearchParams();
            params.append("bugId",this.bugId);
            params.append("currentPage",1);
            params.append("pageSize",5);
            axios
                .post("/bug/findBugOperatingRecord",params)
                .then(function (response) {
                    bugOperatingRecordVm.records = response.data.obj;
                });
        },
        methods:{
            getPage:function(currentPage) {
                if(currentPage<=0) {
                    return ;
                }
                if(currentPage > this.records.pages) {
                    return ;
                }
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                params.append("currentPage",currentPage);
                params.append("pageSize",5);
                axios
                    .post("/bug/findBugOperatingRecord",params)
                    .then(function (response) {
                        bugOperatingRecordVm.records = response.data.obj;
                    });
            }
        }
    })
    var bugDescriptionVm = new Vue({
        el:'#bugDescriptionList',
        data:{
            bugId:null,
            descriptions:{
                list:null
            }
        },
        created:function () {
            this.bugId = window.location.href.split('/')[window.location.href.split('/').length-1];
            params = new URLSearchParams();
            params.append("bugId",this.bugId);
            params.append("currentPage",1);
            params.append("pageSize",5);
            axios
                .post("/bug/findDescription",params)
                .then(function (response) {
                    bugDescriptionVm.descriptions = response.data.obj;
                });
        },
        methods:{
            getPage:function (currentPage) {
                if(currentPage<=0) {
                    return ;
                }
                if(currentPage != 0 && currentPage > this.descriptions.pages) {
                    return ;
                }
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                params.append("currentPage",currentPage);
                params.append("pageSize",5);
                axios
                    .post("/bug/findDescription",params)
                    .then(function (response) {
                        bugDescriptionVm.descriptions = response.data.obj;
                    });
            }
        }
    })

    var vm = new Vue({
        el:"#getBug",
        data:{
            bugId:null,
            projectId:null,
            productId:null,
            bug:{
                bugTitle:null,
                bugContent:null,
                bugProcesser:{
                    name:null
                },
                bugProposer:{
                    name:null
                }
            }
        },
        created:function(){
            this.getBug();
        },
        methods:{
            deleteBug:function() {
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                axios
                    .post("/bug/deleteBug",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        if (response.data.success) {
                            window.location.href = "/project/getProjectPage/" + vm.bug.project.id;
                        }
                    });
            },
            getBug:function() {
                this.bugId = window.location.href.split('/')[window.location.href.split('/').length-1];
                params = new URLSearchParams();
                params.append("id",this.bugId)
                axios
                    .post("/bug/getBug",params)
                    .then(function (response) {
                        vm.bug = response.data.obj;
                        vm.projectId = vm.bug.project.id;
                        vm.productId = vm.bug.project.product.id;
                        redesignateVm.loadPerson();
                        f();
                    });
            },
            beforeUpdate:function() {
                updateVm.bugId = this.bug.id;
                updateVm.title = this.bug.bugTitle;
                editor.setValue(this.bug.bugContent);
            },
            reloadBug:function() {
                params = new URLSearchParams();
                params.append("id",this.bugId);
                axios
                    .post("/bug/getBug",params)
                    .then(function (response) {
                        vm.bug = response.data.obj;
                        bugOperatingRecordVm.getPage(bugOperatingRecordVm.records.pageNum);
                        bugDescriptionVm.getPage(bugDescriptionVm.descriptions.pageNum);
                    });
            },
            processSelf:function() {
                params = new URLSearchParams();
                params.append("id", this.bugId);
                params.append("bugStatus", 1);
                axios
                    .post("/bug/updateBugStatus",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.reloadBug();
                    });

            },
            noProcessing:function () {
                params = new URLSearchParams();
                params.append("id", this.bugId);
                params.append("bugStatus", 1);
                params.append("noProcessing", true);
                axios
                    .post("/bug/updateBugStatus",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.reloadBug();
                    });
            },
            closeBug:function() {
                params = new URLSearchParams();
                params.append("id", this.bugId);
                params.append("bugStatus", 2);
                axios
                    .post("/bug/updateBugStatus",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.reloadBug();
                    });
            }
        }
    });
    var addDescriptionVm = new Vue({
        el:"#addDescription",
        data:{
            content:null
        },
        created:function () {
            this.bugId = window.location.href.split('/')[window.location.href.split('/').length-1];
        },
        methods:{
            addBugDescription:function () {
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                params.append("content",this.content);
                axios
                    .post("/bug/addBugDescription",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.reloadBug();
                        bugDescriptionVm.getPage(0);
                    })
            }
        }
    })
    var redesignateVm = new Vue({
        el:"#redesignate",
        data:{
            projectId:null,
            productId:null,
            users:null,
            bugId:null,
            processer:null
        },
        created:function () {


        },
        methods:{
            loadPerson:function() {
                this.bugId = vm.bug.id;
                this.projectId = vm.projectId;
                this.productId = vm.productId;
                params = new URLSearchParams();
                params.append("roleName","开发人员");
                axios
                    .post("/role/getRoleByRoleName",params)
                    .then(function (response) {
                        redesignateVm.roleId = response.data.obj.id;
                        params = new URLSearchParams();
                        params.append("productId",redesignateVm.productId);
                        params.append("roleId",redesignateVm.roleId);
                        axios
                            .post("/user/findUserByproductIdRole",params)
                            .then(function (response) {
                                redesignateVm.users = response.data.obj;
                            })
                    })
            },
            redesignate:function () {
                params = new URLSearchParams();
                params.append("id",this.bugId);
                params.append("bugProcesser.id",this.processer);
                params.append("bugStatus", 0);
                axios
                    .post("/bug/updateBugStatus",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.reloadBug();
                    })
            }
        }
    })

    function reflash(id) {
        $('.selectpicker').selectpicker('val',id);
        $("#schoolno").selectpicker('refresh');
    }
    function setParticipator(value,html) {
        $('#schoolno.selectpicker').append("<option value='"+value+"'>"+html+"</option>");
        $('#schoolno').selectpicker('refresh');
        $('#schoolno').selectpicker('render');
    }
    function dateFormat(val) {
        val = new Date(val)
        year = val.getFullYear().toString();
        month = val.getMonth() >= 9
            ? (val.getMonth() + 1).toString()
            : "0" + (val.getMonth() + 1);
        date = val.getDate() >= 9
            ? val.getDate().toString()
            : "0" + val.getDate();
        return year + "-" + month + "-" + date;
    }

    function f() {
        Simditor.locale = 'zh-CN';//设置中文
        editor = new Simditor({
            textarea: $("#editor"),  //textarea的id
            placeholder: '',
            toolbar: ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol',
                'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容
            pasteImage: true,//允许粘贴图片
            defaultImage: '/simditor/images/image.png',//编辑器插入的默认图片，此处可以删除
            upload: {
                url: '/bug/bugImgUpload', //文件上传的接口地址
                params: {projectId: vm.projectId}, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                fileKey: 'file', //服务器端获取文件数据的参数名
                connectionCount: 3,
                leaveConfirm: '正在上传文件'
            }
        });
    }

</script>
</body>
</html>
