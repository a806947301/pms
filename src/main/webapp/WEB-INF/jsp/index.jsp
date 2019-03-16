<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header">
                                <h4>您参与的产品</h4>
                            </div>
                            <div class="card-body p-0"  id="productTable">
                                <ul class="list-group" >
                                    <a v-for="product in products.list" class="list-group-item" v-bind:href="['/product/getProductPage/'+product.id]">
                                        {{product.productName}}
                                    </a>
                                </ul>
                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                    <ul class="pagination pagination-lg" v-if="products.pageNum <= products.pages && products.pageNum >= 3">
                                        <li><a v-on:Click="getPage(products.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(products.pageNum-2)" href="javascript:void(0);" v-show="products.pages>=products.pageNum-2"  v-bind:class="{'active':(products.pageNum==2)}">{{products.pageNum-2}}</a></li>
                                        <li><a v-on:Click="getPage(products.pageNum-1)" href="javascript:void(0);" v-show="products.pages>=products.pageNum-1"  v-bind:class="{'active':(products.pageNum==2)}">{{products.pageNum-1}}</a></li>
                                        <li><a v-on:Click="getPage(products.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{products.pageNum}}</a></li>
                                        <li><a v-on:Click="getPage(products.pageNum+1)" href="javascript:void(0);" v-show="products.pages>=products.pageNum+1" >{{products.pageNum+1}}</a></li>
                                        <li><a v-on:Click="getPage(products.pageNum+2)" href="javascript:void(0);" v-show="products.pages>=products.pageNum+2" >{{products.pageNum+2}}</a></li>
                                        <li><a v-on:Click="getPage(products.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
                                    <ul class="pagination pagination-lg" v-else>
                                        <li><a v-on:Click="getPage(products.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(products.pageNum==1)}">1</a></li>
                                        <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="products.pages>=2"  v-bind:class="{'active':(products.pageNum==2)}">2</a></li>
                                        <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="products.pages>=3"  v-bind:class="{'active':(products.pageNum==3)}">3</a></li>
                                        <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="products.pages>=4"  v-bind:class="{'active':(products.pageNum==4)}">4</a></li>
                                        <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="products.pages>=5"  v-bind:class="{'active':(products.pageNum==5)}">5</a></li>
                                        <li><a v-on:Click="getPage(products.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card" id="bugTable">
                            <div class="card-header bg-light">
                                您被指派的Bug
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
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/popper.js/popper.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/vendor/chart.js/chart.min.js"></script>
<script src="/js/carbon.js"></script>
<script src="/js/demo.js"></script>
<script src="/js/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    /** 显示产品 */
    var vm = new Vue({
        el:"#productTable" ,
        data:{
            products:{
                list:null
            }
        },
        created:function (){
            params = new URLSearchParams();
            params.append("currentPage",1);
            params.append("pageSize",5);
            axios
                .post("/product/findProductByCurrentUser",params)
                .then(function (response) {
                    vm.products =  response.data ;

                })
        },
        methods:{
            getPage:function(currentPage) {
                if(currentPage<=0)
                {
                    return;
                }
                if(currentPage>vm.products.pages)
                {
                    return;
                }

                params = new URLSearchParams();
                params.append("currentPage",currentPage);
                params.append("pageSize",5);
                axios
                    .post("/product/findProductByCurrentUser",params)
                    .then(function (response) {
                        vm.products =  response.data ;
                    })
            },

        }

    })
    var bugVm = new Vue({
        el:'#bugTable',
        data:{
            bugs:{
                list:null
            },
        },
        created:function () {
            params = new URLSearchParams();
            params.append("currentPage",1);
            params.append("pageSize",5);
            axios
                .post("/bug/findBugByCurrentUserDesignee",params)
                .then(function (response) {
                    bugVm.bugs = response.data;
                });
        },
        methods:{
            getPage:function(currentPage) {
                if(currentPage<=0) {
                    return;
                }
                if(currentPage>this.bugs.pages && currentPage != 1) {
                    return;
                }
                params = new URLSearchParams();
                params.append("currentPage",currentPage);
                params.append("pageSize",5);
                axios
                    .post("/bug/findBugByCurrentUserDesignee",params)
                    .then(function (response) {
                        bugVm.bugs = response.data;
                    });

            }
        }
    })
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
