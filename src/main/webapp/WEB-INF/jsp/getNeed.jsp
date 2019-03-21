<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dayi.demo.user.model.Department" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
                                <div class="row">
                                    <div class="col-md-4">
                                        <h4>需求</h4>
                                    </div>
                                    <div class="col-md-6">
                                        创建时间：{{crtTimeFtt(need.addTime)}}
                                    </div>
                                    <div class="col-md-2" v-if="need.user.email == '<shiro:principal/>'">
                                        <button class="btn btn-outline-danger" v-on:click="deleteNeed()">
                                            <i class="fa fa-trash"></i>&nbsp; 删除
                                        </button>
                                    </div>
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
                                        <button class="btn btn-outline-success" type="button"
                                                v-on:click="download(need.descriptionFilepath+'.html')">
                                            在线预览
                                        </button>
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-outline-primary" type="button"
                                                v-on:click="download(need.descriptionFilepath)">
                                            立即下载
                                        </button>
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
                                    <div class="col-md-4">
                                    </div>
                                    <div class="col-md-4">
                                        <button class="btn btn-outline-success" type="button" v-on:click="preview()"
                                                data-toggle="modal" data-target="#myModal">
                                            在线预览
                                        </button>
                                    </div>
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

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">预览文件</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>文件名</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td v-on:click="click(0,'',true,true)" style="cursor: pointer;">...</td>
                            </tr>
                            <tr v-for="(file,index) in tree.children"
                                v-on:click="click(index,file.filename,file.isDirection,false)"
                                style="cursor: pointer;">
                                <td>
                                    <i class="fa fa-align-center" v-if="file.isDirection"></i>
                                    <i class="fa fa-clipboard" v-else></i>
                                    {{file.filename}}
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
    var treeVm = new Vue({
        el:'#myModal',
        data:{
            tree:{},
            baseTree:null
        },
        methods:{
            click:function(index,name,isDirection,isGoParent){
                if(!isDirection) {
                    window.open(this.tree.children[index].file);
                    return;
                }
                if(isGoParent) {
                    if(this.tree.parent == null) return;
                    this.tree = this.tree.parent;
                    return;
                }
                parentTree = this.tree;
                this.tree = this.tree.children[index];
                this.tree.parent = parentTree;

            }
        }
    })
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
            deleteNeed:function() {
                params = new URLSearchParams();
                params.append("needId",this.needId);
                axios
                    .post("/need/deleteNeed",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        if (response.data.success) {
                            window.location.href = "/project/getProjectPage/" + vm.need.project.id;
                        }

                    })
            },
            preview:function() {
                params = new URLSearchParams();
                params.append("needId",this.needId);
                axios
                    .post("/need/previewNeedFile",params)
                    .then(function (response) {
                        treeVm.tree = response.data;
                        treeVm.baseTree = response.data;
                        /*console.log(response.data)*/

                    })
            },
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
