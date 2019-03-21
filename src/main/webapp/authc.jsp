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
    <link rel="stylesheet" href="/css/bootstrap-treeview.min.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="/css/styles.css">--%>

</head>
<body>
<div id="treeview1"></div>

</body>
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/js/bootstrap-treeview.min.js"></script>
<script src="/js/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>


    /**/
    var nodeCheckedSilent = false;
    function nodeChecked (event, node){
        if(nodeCheckedSilent){
            return;
        }
        nodeCheckedSilent = true;
        checkAllParent(node);
        checkAllSon(node);
        nodeCheckedSilent = false;
        result = $('#treeview1').treeview('getChecked');
    }

    var nodeUncheckedSilent = false;
    function nodeUnchecked  (event, node){
        if(nodeUncheckedSilent)
            return;
        nodeUncheckedSilent = true;
        uncheckAllParent(node);
        uncheckAllSon(node);
        nodeUncheckedSilent = false;
        result = $('#treeview1').treeview('getChecked')
    }

    //选中全部父节点
    function checkAllParent(node){
        $('#treeview1').treeview('checkNode',node.nodeId,{silent:true});
        var parentNode = $('#treeview1').treeview('getParent',node.nodeId);
        if(!("nodeId" in parentNode)){
            return;
        }else{
            checkAllParent(parentNode);
        }
    }
    //取消全部父节点
    function uncheckAllParent(node){
        $('#treeview1').treeview('uncheckNode',node.nodeId,{silent:true});
        var siblings = $('#treeview1').treeview('getSiblings', node.nodeId);
        var parentNode = $('#treeview1').treeview('getParent',node.nodeId);
        if(!("nodeId" in parentNode)) {
            return;
        }
        var isAllUnchecked = true;  //是否全部没选中
        for(var i in siblings){
            if(siblings[i].state.checked){
                isAllUnchecked=false;
                break;
            }
        }
        if(isAllUnchecked){
            uncheckAllParent(parentNode);
        }

    }

    //级联选中所有子节点
    function checkAllSon(node){
        $('#treeview1').treeview('checkNode',node.nodeId,{silent:true});
        if(node.nodes!=null&&node.nodes.length>0){
            for(var i in node.nodes){
                checkAllSon(node.nodes[i]);
            }
        }
    }
    //级联取消所有子节点
    function uncheckAllSon(node){
        $('#treeview1').treeview('uncheckNode',node.nodeId,{silent:true});
        if(node.nodes!=null&&node.nodes.length>0){
            for(var i in node.nodes){
                uncheckAllSon(node.nodes[i]);
            }
        }
    }

    /**/

    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg); //获取url中"?"符后的字符串并正则匹配
        var context = "";
        if (r != null)
            context = r[2];
        reg = null;
        r = null;
        return context == null || context == "" || context == "undefined" ? "" : context;
    }

    var result = 1;
    var data ;
    params = new URLSearchParams();
    params.append("roleId",getQueryString("roleId"));
    axios
        .post("/permission/permissionTree",params)
        .then(function (response) {
            data = response.data;
            $('#treeview1').treeview({
                data: data,
                showIcon: false,
                showCheckbox: true,
                levels:1,
                onNodeChecked:nodeChecked ,
                onNodeUnchecked:nodeUnchecked
            })
            result = $('#treeview1').treeview('getChecked');
        })



</script>
</html>
