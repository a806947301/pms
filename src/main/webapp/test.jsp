<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/simditor/styles/simditor.css">
    <script src="/vendor/jquery/jquery.min.js"></script><%--
<script src="/vendor/popper.js/popper.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/vendor/chart.js/chart.min.js"></script>
<script src="/js/carbon.js"></script>
<script src="/js/demo.js"></script>
<script src="/js/bootstrap-select.min.js"></script>
<script src="/js/i18n/defaults-zh_CN.min.js"></script>--%>
    <%-- Simditor --%>
    <script src="/simditor/scripts/module.js"></script>
    <script src="/simditor/scripts/hotkeys.js"></script>
    <script src="/simditor/scripts/uploader.js"></script>
    <script src="/simditor/scripts/simditor.js"></script>
</head>
<body>
<textarea id="editor" placeholder="Balabala" autofocus ></textarea>
<script>
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
                params: null,//{projectId:111/*vm.projectId*/}, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
                fileKey:'file', //服务器端获取文件数据的参数名
                connectionCount: 3,
                leaveConfirm: '正在上传文件'
            },
            success:function(data) {
                alert(data);
            }
        });
    });
</script>
</body>
</html>
