<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dayi.demo.user.model.Department" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登陆日志</title>
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
                <div class="row ">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>登陆日志</h4>
                            </div>

                            <div class="card-body p-0"  id="logsTable">
                                <%--<div class="p-4">
                                    <canvas id="line-chart" width="100%" height="20"></canvas>
                                </div>--%>
                                <ul class="list-group" >
                                    <li v-for="log in logs.list" class="list-group-item">
                                        <div class="row">
                                            <div class="col-md-4">
                                                登陆ip：{{log.ip}}
                                            </div>
                                            <div class="col-md-4">
                                                登陆时间：{{crtTimeFtt(log.addTime)}}
                                            </div>
                                            <div class="col-md-4">
                                                登陆人：{{log.user.department.departmentName}}-{{log.user.name}}
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <div class="justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none">
                                    <ul class="pagination pagination-lg" v-if="logs.pageNum <= logs.pages && logs.pageNum >= 3">
                                        <li><a v-on:Click="getPage(logs.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(logs.pageNum-2)" href="javascript:void(0);" v-show="logs.pages>=logs.pageNum-2"  v-bind:class="{'active':(logs.pageNum==2)}">{{logs.pageNum-2}}</a></li>
                                        <li><a v-on:Click="getPage(logs.pageNum-1)" href="javascript:void(0);" v-show="logs.pages>=logs.pageNum-1"  v-bind:class="{'active':(logs.pageNum==2)}">{{logs.pageNum-1}}</a></li>
                                        <li><a v-on:Click="getPage(logs.pageNum)" href="javascript:void(0);"   v-bind:class="{'active':true}">{{logs.pageNum}}</a></li>
                                        <li><a v-on:Click="getPage(logs.pageNum+1)" href="javascript:void(0);" v-show="logs.pages>=logs.pageNum+1" >{{logs.pageNum+1}}</a></li>
                                        <li><a v-on:Click="getPage(logs.pageNum+2)" href="javascript:void(0);" v-show="logs.pages>=logs.pageNum+2" >{{logs.pageNum+2}}</a></li>
                                        <li><a v-on:Click="getPage(logs.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
                                    <ul class="pagination pagination-lg" v-else>
                                        <li><a v-on:Click="getPage(logs.pageNum-1)" href="javascript:void(0);">&laquo;</a></li>
                                        <li><a v-on:Click="getPage(1)" href="javascript:void(0);" v-bind:class="{'active':(logs.pageNum==1)}">1</a></li>
                                        <li><a v-on:Click="getPage(2)" href="javascript:void(0);" v-show="logs.pages>=2"  v-bind:class="{'active':(logs.pageNum==2)}">2</a></li>
                                        <li><a v-on:Click="getPage(3)" href="javascript:void(0);" v-show="logs.pages>=3"  v-bind:class="{'active':(logs.pageNum==3)}">3</a></li>
                                        <li><a v-on:Click="getPage(4)" href="javascript:void(0);" v-show="logs.pages>=4"  v-bind:class="{'active':(logs.pageNum==4)}">4</a></li>
                                        <li><a v-on:Click="getPage(5)" href="javascript:void(0);" v-show="logs.pages>=5"  v-bind:class="{'active':(logs.pageNum==5)}">5</a></li>
                                        <li><a v-on:Click="getPage(logs.pageNum+1)" href="javascript:void(0);">&raquo;</a></li>
                                    </ul>
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
<script src="/js/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    /** 显示日志 */
    var vm = new Vue({
        el:"#logsTable" ,
        data:{
            logs:{}
        },
        created:function (){
            this.userId = window.location.href.split('/')[window.location.href.split('/').length-1];
            params = new URLSearchParams();
            /*params.append("id",this.userId);*/
            params.append("currentPage",1);
            params.append("pageSize",10);
            axios
                .post("/user/loginLogByUser",params)
                .then(function (response) {
                    vm.logs =  response.data.obj;

                })
        },
        methods:{
            getPage:function(currentPage) {

                if(currentPage<=0)
                {
                    return;
                }
                if(currentPage>vm.logs.pages)
                {
                    return;
                }

                params = new URLSearchParams();
                params.append("currentPage",currentPage);
                params.append("pageSize",10);
                /*params.append("id",vm.userId)*/
                axios
                    .post("/user/loginLogByUser",params)
                    .then(function (response) {
                        vm.logs =  response.data.obj ;
                    })
            },

        }

    })
    // 对Date的扩展，将 Date 转化为指定格式的String
    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    // 例子：
    // (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
    Date.prototype.Format = function(fmt)
    { //author: meizz
        var o = {
            "M+" : this.getMonth()+1,                 //月份
            "d+" : this.getDate(),                    //日
            "h+" : this.getHours(),                   //小时
            "m+" : this.getMinutes(),                 //分
            "s+" : this.getSeconds(),                 //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S"  : this.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }
    function crtTimeFtt(value){
        return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
    }
    function beforeAdd()
    {
        addUser.name=""
        addUser.jobNumber=""
        addUser.email=""
        addUser.password=""
    }
    function beforeUpdate(id,departmentName)
    {
        /*  updateDepartment.id = id;
          updateDepartment.departmentName = departmentName;*/
        console.log(id);
    }

</script>

</body>


</html>
