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
    <title>添加Bug</title>
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
                                添加Bug
                            </div>

                            <div class="card-body">

                                <div class="row" id="addBug">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label >Bug详情</label>
                                            <input type="text" class="form-control" placeholder="文本输入" v-model="title">
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <label >请选择Bug处理人</label>
                                            <select id ="schoolno"class="form-control selectpicker" data-live-search="true" v-model="processer" >
                                            </select>
                                            <br><br>
                                        </div>
                                        <div class="form-group">
                                            <label >Bug描述</label>
                                            <div>
                                                <textarea id="editor" placeholder="Balabala" autofocus ></textarea>

                                            </div>
                                            <br><br>
                                        </div>

                                        <button class="btn btn-block btn-secondary" type="button" v-on:click="addBug()">创建产品</button>

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
<script src="/simditor/scripts/hotkeys.js"></script>
<script src="/simditor/scripts/uploader.js"></script>
<script src="/simditor/scripts/simditor.js"></script>
<%--vue--%>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/js/vue.min.js"></script>

<script>

    var vm = new Vue({
        el:"#addBug",
        data:{
            projectId:null,
            productId:null,
            bugContent:null,
            processer:null,
            title:null,
            content:null
        },
        created:function(){
            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];
            this.productId = window.location.href.split('/')[window.location.href.split('/').length-2];
            params = new URLSearchParams();
            params.append("id",this.productId);
            axios
                .post("/user/findUserByProductId",params)
                .then(function (response) {
                    vm.users = response.data;
                    vm.processer = vm.users[0].id;
                    for( i in vm.users)
                    {
                        setParticipator(vm.users[i].id,vm.users[i].department.departmentName + "-"+vm.users[i].name)
                    }
                })
        },
        methods:{
            addBug:function() {
                vm.content = $('#editor').val();
                params = new URLSearchParams();
                params.append("bugTitle",vm.title);
                params.append("bugContent",vm.content);
                params.append("projectId",vm.projectId);
                params.append("bugProcesser.id",vm.processer);
                axios
                    .post("/bug/addBug",params)
                    .then(function (response) {

                    })

            }
        }
    })
    function setParticipator(value,html) {
        $('#schoolno.selectpicker').append("<option value='"+value+"'>"+html+"</option>");
        $('#schoolno').selectpicker('refresh');
        $('#schoolno').selectpicker('render');
    }

    $(function(){
        Simditor.locale = 'zh-CN';//设置中文
        var editor = new Simditor({
            textarea: $("#editor"),  //textarea的id
            placeholder: '',
            toolbar:  ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容
            pasteImage: true,//允许粘贴图片
            defaultImage: '/simditor/images/image.png',//编辑器插入的默认图片，此处可以删除
            upload : {
                url : '/bug/bugImgUpload', //文件上传的接口地址
                params: {projectId:vm.projectId}, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                fileKey:'file', //服务器端获取文件数据的参数名
                connectionCount: 3,
                leaveConfirm: '正在上传文件'
            }
        });
    });

</script>
</body>
</html>
