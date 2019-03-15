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
    <title>创建产品</title>
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
                                添加产品
                            </div>

                            <div class="card-body">

                                <div class="row" id="addProduct">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label >产品名</label>
                                            <input type="text" class="form-control" placeholder="文本输入" v-model="productName" >
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <label >参与人员</label>
                                            <select id ="schoolno"class="form-control selectpicker" data-live-search="true" multiple  v-model="participator">
                                            </select>
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <label >产品介绍</label>
                                            <div>
                                                <textarea class="form-control" rows="5"  v-model="productPresentation" >
                                                </textarea>
                                            </div>
                                            <br><br>
                                        </div>

                                        <button class="btn btn-block btn-secondary" type="button" v-on:click="addProduct">创建产品</button>

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
        el:"#addProduct",
        data:{
            users:null,
            participator:null,
            productName:null,
            productPresentation:null,
            test:null
        },
        created:function(){
            axios
                .post("/user/findAllUser")
                .then(function (response) {
                    vm.users = response.data;
                    for( i in vm.users)
                    {
                        setParticipator(vm.users[i].id,vm.users[i].department.departmentName + "-"+vm.users[i].name)
                    }
                })
        },
        methods:{
            addProduct:function () {
                /*console.log("productName:"+vm.productName)
                console.log("productPresentation:"+vm.productPresentation)
                console.log("participator:"+vm.participator)*/
                params = new URLSearchParams();
                params.append("productName",vm.productName);
                params.append("productPresentation",vm.productPresentation);
                params.append("participator",vm.participator);
                axios
                    .post("/product/addProduct",params)
                    .then(function (response) {
                        result = response.data;
                        if(result.success == true) {
                            alert("添加成功");
                            window.location.href="/product/getProductPage/" + result.msg;
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
