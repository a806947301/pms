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
    <title>项目</title>
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
                        <div class="card" id="getProduct">

                            <div class="card-header bg-light">
                                <div class="row">
                                    <div class="col-md-8">{{project.projectName}}</div>
                                    <div class="col-md-2">
                                        <button class="btn btn-block btn-outline-warning" type="button" data-toggle="modal" data-target="#updateProjectModal"
                                                v-on:click="beforeUpdate()">更新项目信息</button>
                                    </div>
                                    <div class="col-md-1" v-if="project.finished">
                                        <button class="btn btn-success" type="button" data-toggle="modal" data-target="#finishedModal"
                                                v-on:click="finishedVm.beforeVm(project.id,false)">
                                            <i class="fa fa-cut"></i>&nbsp; 已完成
                                        </button>
                                    </div>
                                    <div class="col-md-1" v-else>
                                        <button class="btn btn-warning" type="button" data-toggle="modal" data-target="#finishedModal"
                                                v-on:click="finishedVm.beforeVm(project.id,true)">
                                            <i class="fa fa-clipboard"></i> &nbsp; 未完成
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body text-center">
                                所属产品：<a v-bind:href="['/product/getProductPage/'+project.product.id]">{{project.product.productName}}</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6" id="needTable">
                        <div class="card">
                            <div class="card-header bg-light">
                                <dir class="row">
                                    <div class="col-md-2">
                                        需求
                                    </div>
                                    <div class="col-md-6"></div>
                                    <div class="col-md-4">
                                        <button class="btn btn-outline-primary" type="button"
                                                v-on:click="addNeed()">
                                            添加需求
                                        </button>
                                    </div>
                                </dir>
                            </div>
                            <div class="card-body  border-top" v-for="need in needs.list">
                                <a v-bind:href="['/need/getNeedPage/'+need.id]">{{need.needName}}</a> - <small class="text-mutedz">{{need.user.name}}</small><br>
                            </div>
                            <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                <ul class="pagination pagination-lg" v-if="needs.pageNum <= needs.pages && needs.pageNum >= 3">
                                    <li><a v-on:Click="getPage(needs.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                    <li><a v-on:Click="getPage(needs.pageNum-2)" href="javascript:void(0);" v-show="needs.pages>=needs.pageNum-2"  v-bind:class="{'active':(needs.pageNum==2)}">{{needs.pageNum-2}}</a></li>
                                    <li><a v-on:Click="getPage(needs.pageNum-1)" href="javascript:void(0);" v-show="needs.pages>=needs.pageNum-1"  v-bind:class="{'active':(needs.pageNum==2)}">{{needs.pageNum-1}}</a></li>
                                    <li><a v-on:Click="getPage(needs.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{needs.pageNum}}</a></li>
                                    <li><a v-on:Click="getPage(needs.pageNum+1)" href="javascript:void(0);" v-show="needs.pages>=needs.pageNum+1" >{{needs.pageNum+1}}</a></li>
                                    <li><a v-on:Click="getPage(needs.pageNum+2)" href="javascript:void(0);" v-show="needs.pages>=needs.pageNum+2" >{{needs.pageNum+2}}</a></li>
                                    <li><a v-on:Click="getPage(needs.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                                <ul class="pagination pagination-lg" v-else>
                                    <li><a v-on:Click="getPage(needs.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                    <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(needs.pageNum==1)}">1</a></li>
                                    <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="needs.pages>=2"  v-bind:class="{'active':(needs.pageNum==2)}">2</a></li>
                                    <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="needs.pages>=3"  v-bind:class="{'active':(needs.pageNum==3)}">3</a></li>
                                    <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="needs.pages>=4"  v-bind:class="{'active':(needs.pageNum==4)}">4</a></li>
                                    <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="needs.pages>=5"  v-bind:class="{'active':(needs.pageNum==5)}">5</a></li>
                                    <li><a v-on:Click="getPage(needs.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6" id="bugTable">
                        <div class="card">
                            <div class="card-header bg-light">
                                <dir class="row">
                                    <div class="col-md-2">
                                        bug
                                    </div>
                                    <div class="col-md-2"></div>
                                    <div class="col-md-4">
                                        <button class="btn btn-outline-success" type="button" data-toggle="modal" data-target="#filtrateModal"
                                            onclick="filtrateVm.reflash()">
                                            筛选
                                        </button>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-outline-primary" type="button"
                                            v-on:click="addBug()">
                                            添加Bug
                                        </button>
                                    </div>
                                </dir>
                            </div>
                            <div class="card-body  border-top" v-for="bug in bugs.list">
                                <div class="row">
                                    <div class="col-md-8">
                                        <a v-bind:href="['/bug/getBugPage/'+vm.productId+'/'+ vm.projectId +'/'+bug.id]">{{bug.bugTitle}}</a>
                                    </div>
                                    <div class="col-md-4" v-if="bug.bugStatus==3">
                                        <button class="btn btn-success">已完成</button>
                                    </div>
                                    <div class="col-md-4" v-else-if="bug.bugStatus==2">
                                        <button class="btn btn-warning">验收中</button>
                                    </div>
                                    <div class="col-md-4" v-else-if="bug.bugStatus==1">
                                        <button class="btn btn-info">处理中</button>
                                    </div>
                                    <div class="col-md-4" v-else>
                                        <button class="btn btn-danger">指派中</button>
                                    </div>
                                </div>
                                <small>
                                    <div class="row">
                                        <div class="col-md-4">
                                            提出者-{{bug.bugProposer.name}}
                                        </div>
                                        <div class="col-md-4">
                                            处理者-{{bug.bugProcesser.name}}
                                        </div>
                                        <div class="col-md-4">
                                            日期 {{dateFormat(bug.addTime)}}
                                        </div>
                                    </div>
                                </small>
                            </div>
                            <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                <ul class="pagination pagination-lg" v-if="bugs.pageNum <= bugs.pages && bugs.pageNum >= 3">
                                    <li><a v-on:Click="getPage(bugs.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                    <li><a v-on:Click="getPage(bugs.pageNum-2)" href="javascript:void(0);" v-show="bugs.pages>=bugs.pageNum-2"  v-bind:class="{'active':(bugs.pageNum==2)}">{{bugs.pageNum-2}}</a></li>
                                    <li><a v-on:Click="getPage(bugs.pageNum-1)" href="javascript:void(0);" v-show="bugs.pages>=bugs.pageNum-1"  v-bind:class="{'active':(bugs.pageNum==2)}">{{bugs.pageNum-1}}</a></li>
                                    <li><a v-on:Click="getPage(bugs.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{bugs.pageNum}}</a></li>
                                    <li><a v-on:Click="getPage(bugs.pageNum+1)" href="javascript:void(0);" v-show="bugs.pages>=bugs.pageNum+1" >{{bugs.pageNum+1}}</a></li>
                                    <li><a v-on:Click="getPage(bugs.pageNum+2)" href="javascript:void(0);" v-show="bugs.pages>=bugs.pageNum+2" >{{bugs.pageNum+2}}</a></li>
                                    <li><a v-on:Click="getPage(bugs.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                                <ul class="pagination pagination-lg" v-else>
                                    <li><a v-on:Click="getPage(bugs.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                    <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(bugs.pageNum==1)}">1</a></li>
                                    <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="bugs.pages>=2"  v-bind:class="{'active':(bugs.pageNum==2)}">2</a></li>
                                    <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="bugs.pages>=3"  v-bind:class="{'active':(bugs.pageNum==3)}">3</a></li>
                                    <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="bugs.pages>=4"  v-bind:class="{'active':(bugs.pageNum==4)}">4</a></li>
                                    <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="bugs.pages>=5"  v-bind:class="{'active':(bugs.pageNum==5)}">5</a></li>
                                    <li><a v-on:Click="getPage(bugs.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--更新项目模拟框--%>
<div class="modal fade" id="updateProjectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>更新项目</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <div class="form-group">
                        <label  class="control-label">id</label>
                        <input type="text" class="form-control" v-model="project.id"
                               disabled>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">项目名</label>
                        <input type="text" class="form-control" v-model="project.projectName"
                               placeholder="产品名">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">所属产品</label>
                        <select id ="schoolno"class="form-control selectpicker" data-live-search="true"
                                 v-model="productId">
                        </select>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label >开始时间</label>
                            <input id="meeting" type="date" value="" class="form-control" v-model="project.beginDate"/>
                        </div>

                        <div class="col-md-6">
                            <label >结束时间</label>
                            <input id="meeting1" type="date" value="" class="form-control"  v-model="project.endDate"/>
                        </div>
                        <br><br><br><br><br><br>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="updateProduct()"  data-dismiss="modal">
                    更新项目
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--筛选模拟框--%>
<div class="modal fade" id="filtrateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>筛选项目</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    开始日期
                    <input type="date" v-model="begin"/>
                    结束日期
                    <input type="date" v-model="end"/>
                </div>
                <div class="form-group">
                    <label>状态</label>
                    <select class="form-control" v-model="status">
                        <option value="0">指派中</option>
                        <option value="1">处理中</option>
                        <option value="2">验收中</option>
                        <option value="3">已完成</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>提出者</label>
                    <select class="form-control" v-model="proposerId">
                        <option v-for="proposer in proposers" v-bind:value="proposer.id">{{proposer.name}}</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>处理者</label>
                    <select class="form-control" v-model="processerId">
                        <option v-for="processer in processers" v-bind:value="processer.id">{{processer.name}}</option>

                    </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="filtrate()"  data-dismiss="modal">
                    更新项目
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--确定完成状态--%>
<div class="modal fade" id="finishedModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>项目完成状态</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">
                确定要更新项目完成状态为：{{finished ? "已完成" : "未完成"}}
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="update()"  data-dismiss="modal">
                    确定更新
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
    var finishedVm = new Vue({
        el:'#finishedModal',
        data:{
            finished:null,
            id:null
        },
        methods:{
            beforeVm:function(id,finished) {
                this.id = id;
                this.finished = finished;
            },
            update:function() {
                params = new URLSearchParams();
                params.append("projectId",this.id);
                params.append("finished",this.finished);
                params.append("countBugNotfinished",vm.countBugNofinished);
                axios
                    .post("/project/updateProjectFinished",params)
                    .then(function (response) {
                        alert(response.data.msg);
                    })
            }

        }
    })
    var updateVm = new Vue({
        el:'#updateProjectModal',
        data:{
            productId:null,
            project:{
                id:null
            }
        },
        methods:{
            updateProduct:function() {
                params = new URLSearchParams();
                params.append("id",this.project.id);
                params.append("projectName",this.project.projectName);
                params.append("beginDate",this.project.beginDate);
                params.append("endDate",this.project.endDate);
                params.append("product.id",this.productId);
                axios
                    .post("/project/updateProject",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        vm.updateProjects();
                    })
            }
        }
    })
    var vm = new Vue({
        el:"#getProduct",
        data:{
            projectId:null,
            project:{
                product:{productName:null}
            },
            countBugNofinished:null
        },
        created:function(){
            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];
            params = new URLSearchParams();
            params.append("id",this.projectId)
            axios
                .post("/bug/countBugByProjectNoFinished",params)
                .then(function (response) {
                    vm.countBugNofinished = response.data;
                    console.log(vm.countBugNofinished)
                });
            axios
                .post("/project/getProject",params)
                .then(function (response) {
                    vm.project = response.data;
                    bugVm.productId = vm.productId;
                });
            axios
                .post("/product/findAllProduct")
                .then(function (response) {
                    vm.products = response.data;
                    vm.productId = vm.products[0].id;
                    for( i in vm.products)
                    {
                        setParticipator(vm.products[i].id,vm.products[i].productName);
                    }
                })
        },
        methods:{
            beforeUpdate:function() {
                updateVm.project = JSON.parse(JSON.stringify(this.project));
                updateVm.project.beginDate = dateFormat (updateVm.project.beginDate);
                updateVm.project.endDate = dateFormat (updateVm.project.endDate);
                updateVm.productId = this.project.product.id;
                reflash(this.project.product.id);
            },
           updateProjects:function(){
               params = new URLSearchParams();
               params.append("id",this.projectId)
               axios
                   .post("/project/getProject",params)
                   .then(function (response) {
                       vm.project = response.data;
                   });
            }
        }
    })
    var needVm = new Vue({
        el:'#needTable',
        data:{
            projectId:null,
            needs:{
                list:null
            }
        },
        created:function () {
            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];
            params = new URLSearchParams();
            params.append("projectId",this.projectId);
            params.append("currentPage",1);
            axios
                .post("/need/findNeedByProjectId",params)
                .then(function (response) {
                    needVm.needs = response.data;
                });
        },
        methods:{
            addNeed:function() {
                window.location.href="/need/addNeedPage/"+this.projectId;
            },
            getPage:function (currentPage) {
                if(currentPage<=0)
                {
                    return;
                }
                if(currentPage>this.needs.pages)
                {
                    return;
                }
                params = new URLSearchParams();
                params.append("projectId",this.projectId);
                params.append("currentPage",currentPage);
                axios
                    .post("/need/findNeedByProjectId",params)
                    .then(function (response) {
                        needVm.needs = response.data;
                    });
            }
        }
    })
    var bugVm = new Vue({
        el:'#bugTable',
        data:{
            projectId:null,
            productId:null,
            bugs:{
                list:null
            },
            params:null,
            proposerId:null,
            processerId:null,
            begin:null,
            end:null,
            status:-1
        },
        created:function () {
            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];
            this.productId = vm.productId;
            this.params = new URLSearchParams();
            this.params.append("projectId",this.projectId);
            this.params.append("currentPage",1);
            this.params.append("pageSize",5);
            this.params.append("status",-1);
            axios
                .post("/bug/findBugByProject",this.params)
                .then(function (response) {
                    bugVm.bugs = response.data;
                    filtrateVm.processers=[];
                    filtrateVm.proposers=[];
                    for(bug in bugVm.bugs.list) {
                        flag = false;
                        for(processer in filtrateVm.processers) {
                            if(filtrateVm.processers[processer].id == bugVm.bugs.list[bug].bugProcesser.id) {
                                flag = true;
                            }
                        }
                        if(flag == false) {
                            filtrateVm.processers.push(bugVm.bugs.list[bug].bugProcesser)
                        }
                        flag = false;
                        for(index in filtrateVm.proposers) {
                            if(filtrateVm.proposers[index].id == bugVm.bugs.list[bug].bugProposer.id) {
                                flag = true;
                            }
                        }
                        if(flag == false) {
                            filtrateVm.proposers.push(bugVm.bugs.list[bug].bugProposer)
                        }
                    }
                });
        },
        methods:{
            addBug:function() {
                window.location.href="/bug/addBugPage/"+vm.productId + "/" + this.projectId;
            },
            getPage:function(currentPage) {
                if(currentPage<=0) {
                    return;
                }
                if(currentPage>this.bugs.pages && currentPage != 1) {
                    return;
                }
                filtrateVm.processers=[];
                filtrateVm.proposers=[];
                this.params.delete("currentPage");
                this.params.append("currentPage",currentPage);
                this.params.delete("status");
                this.params.append("status",this.status);
                this.params.delete("begin");
                if(null != this.begin) {
                    this.params.append("begin",new Date(this.begin));
                }
                this.params.delete("end")
                if(null != this.end) {
                    this.params.append("end",new Date(this.end));
                }
                this.params.delete("processerId")
                if(null != this.processerId) {
                    this.params.append("processerId",this.processerId);
                }
                this.params.delete("proposerId")
                if(null != this.proposerId) {
                    this.params.append("proposerId",this.proposerId);
                }


                axios
                    .post("/bug/findBugByProject",this.params)
                    .then(function (response) {
                        bugVm.bugs = response.data;
                        filtrateVm.processers=[];
                        filtrateVm.proposers=[];
                        for(bug in bugVm.bugs.list) {
                            flag = false;
                            for(processer in filtrateVm.processers) {
                                if(filtrateVm.processers[processer].id == bugVm.bugs.list[bug].bugProcesser.id) {
                                    flag = true;
                                }
                            }
                            if(flag == false) {
                                filtrateVm.processers.push(bugVm.bugs.list[bug].bugProcesser)
                            }
                            flag = false;
                            for(index in filtrateVm.proposers) {
                                if(filtrateVm.proposers[index].id == bugVm.bugs.list[bug].bugProposer.id) {
                                    flag = true;
                                }
                            }
                            if(flag == false) {
                                filtrateVm.proposers.push(bugVm.bugs.list[bug].bugProposer)
                            }
                        }
                    });
            }
        }
    })
    var filtrateVm = new Vue({
        el:"#filtrateModal",
        data:{
            processers:[],
            proposers:[],
            begin:null,
            end:null,
            status:-1,
            proposerId:null,
            processerId:null
        },
        methods:{
            reflash:function() {
                this.begin = null;
                this.end = null;
                this.status = -1;
                this.proposerId = null;
                this.processerId = null;
            },
            filtrate:function() {
                bugVm.begin = this.begin;
                bugVm.end = this.end;
                bugVm.status = this.status;
                bugVm.proposerId = this.proposerId;
                bugVm.processerId = this.processerId;
                bugVm.getPage(bugVm.bugs.pageNum);
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
