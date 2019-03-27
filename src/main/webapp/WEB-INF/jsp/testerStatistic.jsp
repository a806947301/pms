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
    <title>测试人员统计</title>
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
                        <div class="card" id="productStatistics">

                            <div class="card-header bg-light">
                                <div class="row">
                                    <div class="col-md-9"><h4>测试人员统计</h4></div>
                                    <div class="col-md-2">
                                        <button class="btn btn-block btn-outline-warning" type="button" data-toggle="modal"
                                                v-on:click="exportExcel()">导出EXCEL</button>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th scope="col">序号</th>
                                        <th scope="col">姓名</th>
                                        <th scope="col">指派中Bug</th>
                                        <th scope="col">验收中Bug</th>
                                        <th scope="col">已完成Bug</th>
                                        <th scope="col">Bug总数</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr v-for="(tester,index) in testers">
                                        <td>{{index+1}}</td>
                                        <td>{{tester.name}}</td>
                                        <td>{{tester.designate}}</td>
                                        <td>{{tester.checking}}</td>
                                        <td>{{tester.finished}}</td>
                                        <td>{{tester.bugNumber}}</td>
                                    </tr>
                                    </tbody>


                                </table>
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
        el:"#productStatistics",
        data:{
            testers:{}
        },
        created:function(){
            axios
                .post("/statistic/testerStatistic")
                .then(function (response) {
                    vm.testers = response.data.obj;
                });


        },
        methods: {
            exportExcel:function () {
                window.location.href="/statistic/exportExcelTester";
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
