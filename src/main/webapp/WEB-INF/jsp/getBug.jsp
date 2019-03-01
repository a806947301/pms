<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <button class="btn btn-outline-danger" type="button" v-if="bug.bugStatus==0 || bug.bugStatus==2"
                                        data-toggle="modal" data-target="#redesignate">
                                    重新指派
                                </button>
                                <button class="btn btn-outline-warning" type="button" v-if="bug.bugStatus==1"
                                    v-on:click="noProcessing()">设置不予处理</button>
                                <button class="btn btn-outline-primary" type="button" v-if="bug.bugStatus==1"
                                        data-toggle="modal" data-target="#addDescription">添加说明</button>
                                <button class="btn btn-outline-info" type="button"  v-if="bug.bugStatus==0"
                                        v-on:click="processSelf()">
                                    自己处理
                                </button>
                                <button class="btn btn-outline-success" type="button" v-if="bug.bugStatus==2"
                                    v-on:click="closeBug()">关闭Bug</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8" id="bugTable">
                        <div class="card">
                            <div class="card-header bg-light">
                                <dir class="row">
                                    <div class="col-md-2">
                                        说明
                                    </div>
                                </dir>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆说明<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆说明<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆说明求<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆说明<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一说明<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆说明<br>
                            </div>
                            <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                <ul class="pagination pagination-lg" v-if="departments.pageNum <= departments.pages && departments.pageNum >= 3">
                                    <li><a href="javascript:void(0);">&laquo;</a></li>
                                    <li><a href="javascript:void(0);" class="active">1</a></li>
                                    <li><a href="javascript:void(0);" >2</a></li>
                                    <li><a href="javascript:void(0);" >3</a></li>
                                    <li><a href="javascript:void(0);" >4</a></li>
                                    <li><a href="javascript:void(0);" >5</a></li>
                                    <li><a href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header bg-light">
                                <dir class="row">
                                    <div class="col-md-12">
                                        操作记录
                                    </div>
                                </dir>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆需求<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆需求<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆需求<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆需求<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆需求<br>
                            </div>
                            <div class="card-body  border-top">
                                这是一堆需求<br>
                            </div>
                            <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                <ul class="pagination pagination-lg" v-if="departments.pageNum <= departments.pages && departments.pageNum >= 3">
                                    <li><a href="javascript:void(0);">&laquo;</a></li>
                                    <li><a href="javascript:void(0);" class="active">1</a></li>
                                    <li><a href="javascript:void(0);" >2</a></li>
                                    <li><a href="javascript:void(0);" >3</a></li>
                                    <li><a href="javascript:void(0);" >4</a></li>
                                    <li><a href="javascript:void(0);" >5</a></li>
                                    <li><a href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row" id="addBugDescription">
                    <div class="card col-md-12">
                        <div class="card-header bg-light">
                            添加说明
                        </div>
                        <div class="card-body text-center">
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea><br>
                            <button class="btn btn-block btn-info" type="button">提交说明</button>
                        </div>

                    </div>
                </div>
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
                <textarea class="form-control"  rows="3"></textarea><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" v-on:click="redesignate()">提交更改</button>
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
