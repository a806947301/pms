<%@ page import="com.dayi.demo.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                                    <div class="col-md-2">
                                        <div v-if="bug.noProcessing">

                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div  v-if="bug.bugStatus==3">
                                            <button class="btn btn-success">已完成</button>
                                        </div>
                                        <div  v-else-if="bug.bugStatus==2">
                                            <button class="btn btn-warning" v-if="!bug.noProcessing">验收中</button>
                                            <button class="btn btn-secondary" v-else>不予处理</button>
                                        </div>
                                        <div  v-else-if="bug.bugStatus==1">
                                            <button class="btn btn-info">处理中</button>
                                        </div>
                                        <div  v-else>
                                            <button class="btn btn-danger">指派中</button>
                                        </div>

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
                                <button class="btn btn-outline-danger" type="button" v-if="(bug.bugStatus==0&&bug.bugProcesser.id=='<%=user.getId()%>') || (bug.bugStatus==2&&bug.bugProposer.id=='<%=user.getId()%>')"
                                        data-toggle="modal" data-target="#redesignate">
                                    重新指派
                                </button>
                                <button class="btn btn-outline-warning" type="button" v-if="bug.bugStatus==1 && bug.bugProcesser.id=='<%=user.getId()%>'"
                                    v-on:click="noProcessing()">设置不予处理</button>
                                <button class="btn btn-outline-primary" type="button" v-if="bug.bugStatus==1 && bug.bugProcesser.id=='<%=user.getId()%>'"
                                        data-toggle="modal" data-target="#addDescription">添加说明</button>
                                <button class="btn btn-outline-info" type="button"  v-if="bug.bugStatus==0 && bug.bugProcesser.id=='<%=user.getId()%>'"
                                        v-on:click="processSelf()">
                                    自己处理
                                </button>
                                <button class="btn btn-outline-success" type="button" v-if="bug.bugStatus==2 && bug.bugProposer.id=='<%=user.getId()%>'"
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
            axios
                .post("/bug/findBugOperatingRecord",params)
                .then(function (response) {
                    bugOperatingRecordVm.records = response.data;
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
                axios
                    .post("/bug/findBugOperatingRecord",params)
                    .then(function (response) {
                        bugOperatingRecordVm.records = response.data;
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
            axios
                .post("/bug/findDescription",params)
                .then(function (response) {
                    bugDescriptionVm.descriptions = response.data;
                });
        },
        methods:{
            getPage:function (currentPage) {
                if(currentPage<=0) {
                    return ;
                }
                if(currentPage > this.descriptions.pages) {
                    return ;
                }
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                params.append("currentPage",currentPage);
                axios
                    .post("/bug/findDescription",params)
                    .then(function (response) {
                        bugDescriptionVm.descriptions = response.data;
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
            this.bugId = window.location.href.split('/')[window.location.href.split('/').length-1];
            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-2];
            this.productId = window.location.href.split('/')[window.location.href.split('/').length-3];
            params = new URLSearchParams();
            params.append("id",this.bugId)
            axios
                .post("/bug/getBug",params)
                .then(function (response) {
                    vm.bug = response.data;

                });

        },
        methods:{
            reloadBug:function() {
                params = new URLSearchParams();
                params.append("id",this.bugId);
                axios
                    .post("/bug/getBug",params)
                    .then(function (response) {
                        vm.bug = response.data;
                        bugOperatingRecordVm.getPage(bugOperatingRecordVm.records.pageNum);
                        bugDescriptionVm.getPage(bugDescriptionVm.descriptions.pageNum);
                    });
            },
            processSelf:function() {
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                axios
                    .post("/bug/processSelf",params)
                    .then(function (response) {
                        vm.reloadBug();
                    });

            },
            noProcessing:function () {
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                axios
                    .post("/bug/noProcessing",params)
                    .then(function (response) {
                        vm.reloadBug();
                    });
            },
            closeBug:function() {
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                axios
                    .post("/bug/closeBug",params)
                    .then(function (response) {
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
                        vm.reloadBug();
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
            this.bugId = window.location.href.split('/')[window.location.href.split('/').length-1];
            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-2];
            this.productId = window.location.href.split('/')[window.location.href.split('/').length-3];
            params = new URLSearchParams();
            params.append("id",this.productId);
            axios
                .post("/user/findUserByProductId",params)
                .then(function (response) {
                    redesignateVm.users = response.data;
                })
        },
        methods:{
            redesignate:function () {
                params = new URLSearchParams();
                params.append("bugId",this.bugId);
                params.append("userId",this.processer)
                axios
                    .post("/bug/redesignate",params)
                    .then(function (response) {
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
</script>
</body>
</html>
