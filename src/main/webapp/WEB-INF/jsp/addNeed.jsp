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
    <title>添加需求</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="/css/bootstrap-select.min.css">

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
                                添加需求
                            </div>

                            <div class="card-body">

                                <div class="row" id="addNeedForm">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label >需求名称</label>
                                            <input type="text" class="form-control" placeholder="文本输入" v-model="needName">
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <label >需求详情</label>
                                            <textarea class="form-control" rows="3" v-model=" needDescription"></textarea>
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <label >需求说明文件</label>
                                            <input type="file" class="form-control-file" id="needDescriptionFile">
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <label >需求文件</label>
                                            <input type="file" class="form-control-file" id="needFile">
                                            <br><br>
                                        </div>

                                        <button class="btn btn-block btn-secondary" type="button" v-on:click="addNeed()">创建需求</button>

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
<%--vue--%>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/js/vue.min.js"></script>

<script>
var vm = new Vue({
    el:'#addNeedForm',
    data:{
        projectId:null,
        needName:null,
        needDescription:null,
        needName:null
    },
    created:function(){
        this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];
    },
    methods:{
        addNeed:function () {
            var params = new window.FormData();
            params.append("needDescriptionFile",document.querySelector('#needDescriptionFile').files[0]);
            params.append("needFile",document.querySelector("#needFile").files[0]);
            params.append("project.id",this.projectId);
            params.append("needDescription",this.needDescription);
            params.append("needName",this.needName);
            var options = {  // 设置axios的参数
                url: '/need/addNeed',
                data: params,
                method: 'post',
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            }

            axios
                .post( '/need/addNeed',params,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(function (response) {
                    console.log(response.data);
                })
        }
    }
})


</script>
</body>
</html>
