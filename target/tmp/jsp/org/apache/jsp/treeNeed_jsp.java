package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class treeNeed_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap-treeview.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"treeview1\"></div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script src=\"/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap-treeview.min.js\"></script>\r\n");
      out.write("<script src=\"/js/vue.min.js\"></script>\r\n");
      out.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    /**/\r\n");
      out.write("    var nodeCheckedSilent = false;\r\n");
      out.write("    function nodeChecked (event, node){\r\n");
      out.write("        if(nodeCheckedSilent){\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        nodeCheckedSilent = true;\r\n");
      out.write("        checkAllParent(node);\r\n");
      out.write("        checkAllSon(node);\r\n");
      out.write("        nodeCheckedSilent = false;\r\n");
      out.write("        result = $('#treeview1').treeview('getChecked');\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var nodeUncheckedSilent = false;\r\n");
      out.write("    function nodeUnchecked  (event, node){\r\n");
      out.write("        if(nodeUncheckedSilent)\r\n");
      out.write("            return;\r\n");
      out.write("        nodeUncheckedSilent = true;\r\n");
      out.write("        uncheckAllParent(node);\r\n");
      out.write("        uncheckAllSon(node);\r\n");
      out.write("        nodeUncheckedSilent = false;\r\n");
      out.write("        result = $('#treeview1').treeview('getChecked')\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //选中全部父节点\r\n");
      out.write("    function checkAllParent(node){\r\n");
      out.write("        $('#treeview1').treeview('checkNode',node.nodeId,{silent:true});\r\n");
      out.write("        var parentNode = $('#treeview1').treeview('getParent',node.nodeId);\r\n");
      out.write("        if(!(\"nodeId\" in parentNode)){\r\n");
      out.write("            return;\r\n");
      out.write("        }else{\r\n");
      out.write("            checkAllParent(parentNode);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    //取消全部父节点\r\n");
      out.write("    function uncheckAllParent(node){\r\n");
      out.write("        $('#treeview1').treeview('uncheckNode',node.nodeId,{silent:true});\r\n");
      out.write("        var siblings = $('#treeview1').treeview('getSiblings', node.nodeId);\r\n");
      out.write("        var parentNode = $('#treeview1').treeview('getParent',node.nodeId);\r\n");
      out.write("        if(!(\"nodeId\" in parentNode)) {\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        var isAllUnchecked = true;  //是否全部没选中\r\n");
      out.write("        for(var i in siblings){\r\n");
      out.write("            if(siblings[i].state.checked){\r\n");
      out.write("                isAllUnchecked=false;\r\n");
      out.write("                break;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        if(isAllUnchecked){\r\n");
      out.write("            uncheckAllParent(parentNode);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //级联选中所有子节点\r\n");
      out.write("    function checkAllSon(node){\r\n");
      out.write("        $('#treeview1').treeview('checkNode',node.nodeId,{silent:true});\r\n");
      out.write("        if(node.nodes!=null&&node.nodes.length>0){\r\n");
      out.write("            for(var i in node.nodes){\r\n");
      out.write("                checkAllSon(node.nodes[i]);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    //级联取消所有子节点\r\n");
      out.write("    function uncheckAllSon(node){\r\n");
      out.write("        $('#treeview1').treeview('uncheckNode',node.nodeId,{silent:true});\r\n");
      out.write("        if(node.nodes!=null&&node.nodes.length>0){\r\n");
      out.write("            for(var i in node.nodes){\r\n");
      out.write("                uncheckAllSon(node.nodes[i]);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    /**/\r\n");
      out.write("\r\n");
      out.write("    function getQueryString(name) {\r\n");
      out.write("        var reg = new RegExp(\"(^|&)\" + name + \"=([^&]*)(&|$)\", \"i\");\r\n");
      out.write("        var r = window.location.search.substr(1).match(reg); //获取url中\"?\"符后的字符串并正则匹配\r\n");
      out.write("        var context = \"\";\r\n");
      out.write("        if (r != null)\r\n");
      out.write("            context = r[2];\r\n");
      out.write("        reg = null;\r\n");
      out.write("        r = null;\r\n");
      out.write("        return context == null || context == \"\" || context == \"undefined\" ? \"\" : context;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var result = 1;\r\n");
      out.write("    var data ;\r\n");
      out.write("    params = new URLSearchParams();\r\n");
      out.write("    params.append(\"roleId\",getQueryString(\"roleId\"));\r\n");
      out.write("    axios\r\n");
      out.write("        .post(\"/premission/premissionTree\",params)\r\n");
      out.write("        .then(function (response) {\r\n");
      out.write("            data = response.data;\r\n");
      out.write("            $('#treeview1').treeview({\r\n");
      out.write("                data: data,\r\n");
      out.write("                showIcon: false,\r\n");
      out.write("                levels:1\r\n");
      out.write("            })\r\n");
      out.write("            result = $('#treeview1').treeview('getChecked');\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
