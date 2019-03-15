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
    <title>创建项目</title>
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
                        <div class="card">
                            <div class="card-header bg-light">
                                创建项目
                            </div>

                            <div class="card-body">

                                <div class="row" id="addProject">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label >项目名</label>
                                            <input type="text" class="form-control" placeholder="文本输入" v-model="projectName" >
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <label >所属产品</label>
                                            <select id ="schoolno"class="form-control selectpicker" data-live-search="true"
                                                    data-live-search="true" v-model="productId">
                                            </select>
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <label >开始时间</label>
                                                    <input id="meeting" type="date" value="" class="form-control" v-model="beginDate"/>
                                                </div>
                                                <div class="col-md-2"></div>
                                                <div class="col-md-4">
                                                    <label >结束时间</label>
                                                    <input id="meeting1" type="date" value="" class="form-control" v-model="endDate"/>
                                                </div>
                                            </div>
                                            <br><br>
                                        </div>

                                        <button class="btn btn-block btn-secondary" type="button" v-on:click="addProject()">创建项目</button>

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
        el:"#addProject",
        data:{
            projectName:null,
            products:null,
            productId:null,
            beginDate:null,
            endDate:null
        },
        created:function(){
            axios
                .post("/product/findAllProduct")
                .then(function (response) {
                    vm.products = response.data;
                    vm.productId = vm.products[0].id;
                    for( i in vm.products)
                    {
                        setParticipator(vm.products[i].id,vm.products[i].productName)
                    }
                })
        },
        methods:{
            addProject:function () {
                if(null == this.beginDate) {
                    alert("开始时间不能为空");
                    return;
                }
                if(null == this.endDate) {
                    alert("结束时间不能为空");
                    return;
                }
                if(null == this.productId) {
                    alert("产品id不能为空");
                    return;
                }
                if(null == this.projectName) {
                    alert("项目名不能为空");
                    return;
                }
                /*console.log("productName:"+vm.productName)
                console.log("productPresentation:"+vm.productPresentation)
                console.log("participator:"+vm.participator)*/
                params = new URLSearchParams();
                params.append("beginDate",vm.beginDate);
                params.append("endDate",vm.endDate);
                params.append("product.id",vm.productId);
                params.append("projectName",vm.projectName);
                axios
                    .post("/project/addProject",params)
                    .then(function (response) {
                        result = response.data;
                        console.log(result)
                        if(result.success) {
                            alert("添加成功");
                            window.location.href="/project/getProjectPage/" + result.msg;
                        } else {
                            alert(result.msg);
                        }
                    })
            }
        }
    })
    function setParticipator(value,html) {
        $('#schoolno.selectpicker').append("<option value='"+value+"'>"+html+"</option>");
        $('#schoolno').selectpicker('refresh');
        $('#schoolno').selectpicker('render');
    }


</script>
</body>
</html>
