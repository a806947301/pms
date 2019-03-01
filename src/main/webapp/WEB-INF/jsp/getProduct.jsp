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
    <title>产品</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="/css/bootstrap-select.min.css">
    <!-- simditor -->
    <%--<link rel="stylesheet" href="/simditor/styles/app.css">
    <link rel="stylesheet" href="/simditor/styles/mobile.css">--%>
    <link rel="stylesheet" href="/simditor/styles/simditor.css">

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
                                    <div class="col-md-9">{{product.productName}}</div>
                                    <div class="col-md-2">
                                        <button class="btn btn-block btn-outline-warning" type="button" data-toggle="modal" data-target="#updateProductModal"
                                                v-on:click="updateProductModal(product.id,product.productName,product.productPresentation)">更新产品信息</button>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="card">
                                            <div class="card-header border border-top-0 border-right-0 border-left-0">
                                                产品描述
                                            </div>

                                            <div class="card-body">
                                                {{product.productPresentation}}
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <%-- 显示成员 --%>
                                        <div class="card">
                                            <div class="card-header">
                                                产品成员组
                                            </div>
                                            <div class="card-body">
                                                <div class="row pre-scrollable">
                                                    <table class="table table-hover">
                                                        <tbody>
                                                            <tr v-for="participator in participators">
                                                                <td>{{participator.department.departmentName}}-{{participator.name}}</td>
                                                                <td>
                                                                    <button class="btn btn-outline-danger btn-sm" type="button"
                                                                            v-on:click="deleteParticipator(participator.id)">
                                                                        移出产品组
                                                                    </button>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <%-- 添加成员 --%>
                                        <div class="form-group">
                                            <label >参与人员</label>
                                            <select id ="schoolno"class="form-control selectpicker" data-live-search="true" multiple v-model="newParticipators">
                                            </select>
                                            <br><br>
                                            <button class="btn btn-block btn-outline-success" type="button" v-on:click="addParticipators()">添加成员</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--更新产品模拟框--%>
<div class="modal fade" id="updateProductModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <h3>更新产品</h3>
                <a class="close" data-dismiss="modal">×</a>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <div class="form-group">
                        <label  class="control-label">id</label>
                        <input type="text" class="form-control" v-model="id"
                               disabled>
                    </div>
                    <div class="form-group">
                        <label  class="control-label">产品名</label>
                        <input type="text" class="form-control" v-model="productName"
                               placeholder="产品名">
                    </div>
                    <div class="form-group">
                        <label  class="control-label">产品描述</label>
                        <textarea name="textarea-input" class="form-control" id="textarea-input" placeholder="Content..." rows="9" v-model="productPresentation">

                        </textarea>
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" v-on:click="updateProduct()"  data-dismiss="modal">
                    更新产品
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
    var updateVm = new Vue({
        el:'#updateProductModal',
        data:{
            id:null,
            productName:null,
            productPresentation:null
        },
        methods:{
            updateProduct:function() {
                console.log(this.id + "\t" + this.productName + "\t" + this.productPresentation)
                params = new URLSearchParams();
                params.append("id",this.id);
                params.append("productName",this.productName);
                params.append("productPresentation",this.productPresentation);
                axios
                    .post("/product/updateProduct",params)
                    .then(function (response) {
                        vm.updateProduct();
                    })
            }
        }
    })
    var vm = new Vue({
        el:"#getProduct",
        data:{
            product:{productName:null},
            productId:null,
            participators:null,
            newParticipators:null
        },
        created:function(){
            this.productId = window.location.href.split('/')[window.location.href.split('/').length-1];
            params = new URLSearchParams();
            params.append("id",this.productId)
            axios
                .post("/product/getProduct",params)
                .then(function (response) {
                    vm.product = response.data;
                });
            axios
                .post("/product/getProductParticipator",params)
                .then(function (response) {
                    vm.participators = response.data;
                })
            axios
                .post("/user/findAllUser")
                .then(function (response) {
                    vm.users = response.data;
                    outer:for( i in vm.users)
                    {
                        for(j in vm.participators) {
                            if(vm.participators[j].id == vm.users[i].id) {
                                continue outer;
                            }
                        }
                        console.log("set")
                        setParticipator(vm.users[i].id,vm.users[i].department.departmentName + "-"+vm.users[i].name)
                    }
                })
        },
        methods:{
            updateProduct:function(){
                params = new URLSearchParams();
                params.append("id",this.productId)
                axios
                    .post("/product/getProduct",params)
                    .then(function (response) {
                        vm.product = response.data;
                    });
            },
            addParticipators:function () {

                params = new URLSearchParams();
                params.append("id",this.productId);
                params.append("newParticipator",this.newParticipators);
                axios
                    .post("/product/addProductParticipator",params)
                    .then(function (response) {
                        vm.updateParticipator();
                    })


            },
            deleteParticipator:function(userId) {
                params = new URLSearchParams();
                params.append("productId",this.productId);
                params.append("userId",userId);
                axios
                    .post("/product/deleteProductParticipator",params)
                    .then(function (response) {
                        vm.updateParticipator();
                    })
            },
            updateParticipator:function() {
                console.log(11);
                params = new URLSearchParams();
                params.append("id",this.productId);
                axios
                    .post("/product/getProductParticipator",params)
                    .then(function (response) {
                        vm.participators = response.data;
                        reImportSelectData();
                    })
            },
            updateProductModal:function(productId,productName,productPresentation) {
                updateVm.id = productId;
                updateVm.productName = productName;
                updateVm.productPresentation = productPresentation;
            }
        }
    })
    function reImportSelectData() {
        clearParticipator();
        outer:for( i in vm.users)
        {
            for(j in vm.participators) {
                if(vm.participators[j].id == vm.users[i].id) {
                    continue outer;
                }
            }
            console.log("set")
            setParticipator(vm.users[i].id,vm.users[i].department.departmentName + "-"+vm.users[i].name)
        }
    }
    function setParticipator(value,html) {
        $('#schoolno.selectpicker').append("<option value='"+value+"'>"+html+"</option>");
        $('#schoolno').selectpicker('refresh');
        $('#schoolno').selectpicker('render');
    }
    function clearParticipator() {

        $('#schoolno.selectpicker').empty();
        $('#schoolno').selectpicker('refresh');
        $('#schoolno').selectpicker('render');
    }
</script>
</body>
</html>
