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
    <title>需求</title>
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
            <div class="container-fluid"  id="need">
                <div class="row ">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header border border-top-0 border-right-0 border-left-0">
                                    <div class="col-md-8">
                                        <h4>需求说明文档</h4>
                                    </div>
                                    <div class="col-md-4">
                                        创建时间：{{crtTimeFtt(need.addTime)}}
                                    </div>
                                </div>

                            <div class="card-body">
                                {{need.needDescription}}
                            </div>
                        </div>
                    </div>





                </div>
                <div class="row ">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header border border-top-0 border-right-0 border-left-0">
                                    <div class="col-md-8">
                                        <h5>需求说明文档</h5>
                                    </div>
                                    <div class="col-md-4">

                                    </div>
                                </div>

                            <div class="card-body">
                                {{need.descriptionFilename}}
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-2"></div>
                                    <div class="col-md-4">
                                        <button class="btn btn-outline-success" type="button" v-on:click="download(need.descriptionFilepath+'.html')">在线预览</button>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-outline-primary" type="button" v-on:click="download(need.descriptionFilepath)">立即下载</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card">
                            <div class="card-header border border-top-0 border-right-0 border-left-0">
                                    <div class="col-md-8">
                                        <h5>需求文件</h5>
                                    </div>
                                    <div class="col-md-4">

                                    </div>
                                </div>

                            <div class="card-body">
                                {{need.needFilename}}
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4"></div>
                                    <div class="col-md-4">
                                        <button class="btn btn-outline-primary" type="button" v-on:click="download(need.needFilepath)">立即下载</button>
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
<script src="/js/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
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
    };
    var vm = new Vue({
        el:"#need" ,
        data:{
            needId:null,
            need:{

            }
        },
        created:function (){
            this.needId = window.location.href.split('/')[window.location.href.split('/').length-1];
            params = new URLSearchParams();
            params.append("id",this.needId);
            axios
                .post("/need/getNeed",params)
                .then(function (response) {
                    vm.need =  response.data ;

                })
        },
        methods:{
            download:function(path) {
                window.location.href=path;
            }

        }

    })
    // 对Date的扩展，将 Date 转化为指定格式的String
    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    // 例子：
    // (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18

    function crtTimeFtt(value){
        return new Date(value).Format("yyyy-MM-dd hh:mm:ss");
    }


</script>

</body>


</html>
