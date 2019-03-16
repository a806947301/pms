package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addNeed_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>添加需求</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/simple-line-icons/css/simple-line-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/font-awesome/css/fontawesome-all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/styles.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap-select.min.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"sidebar-fixed header-fixed\">\r\n");
      out.write("<div class=\"page-wrapper\">\r\n");
      out.write("    <div class=\"page-header\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "page_head.jsp", out, false);
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"main-container\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "page_left.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div class=\"card-header bg-light\">\r\n");
      out.write("                                添加需求\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row\" id=\"addNeedForm\">\r\n");
      out.write("                                    <div class=\"col-md-12\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >需求名称</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"文本输入\" v-model=\"needName\">\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >需求详情</label>\r\n");
      out.write("                                            <textarea class=\"form-control\" rows=\"3\" v-model=\" needDescription\"></textarea>\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >需求说明文件</label>\r\n");
      out.write("                                            <input type=\"file\" class=\"form-control-file\" id=\"needDescriptionFile\">\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >需求文件</label>\r\n");
      out.write("                                            <input type=\"file\" class=\"form-control-file\" id=\"needFile\">\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <button class=\"btn btn-block btn-secondary\" type=\"button\" v-on:click=\"addNeed()\">创建需求</button>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/vendor/popper.js/popper.min.js\"></script>\r\n");
      out.write("<script src=\"/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/vendor/chart.js/chart.min.js\"></script>\r\n");
      out.write("<script src=\"/js/carbon.js\"></script>\r\n");
      out.write("<script src=\"/js/demo.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\r\n");
      out.write("<script src=\"/js/vue.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("var vm = new Vue({\r\n");
      out.write("    el:'#addNeedForm',\r\n");
      out.write("    data:{\r\n");
      out.write("        projectId:null,\r\n");
      out.write("        needName:null,\r\n");
      out.write("        needDescription:null,\r\n");
      out.write("        needName:null\r\n");
      out.write("    },\r\n");
      out.write("    created:function(){\r\n");
      out.write("        this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];\r\n");
      out.write("    },\r\n");
      out.write("    methods:{\r\n");
      out.write("        addNeed:function () {\r\n");
      out.write("            var params = new window.FormData();\r\n");
      out.write("            params.append(\"needDescriptionFile\",document.querySelector('#needDescriptionFile').files[0]);\r\n");
      out.write("            params.append(\"needFile\",document.querySelector(\"#needFile\").files[0]);\r\n");
      out.write("            params.append(\"project.id\",this.projectId);\r\n");
      out.write("            params.append(\"needDescription\",this.needDescription);\r\n");
      out.write("            params.append(\"needName\",this.needName);\r\n");
      out.write("            var options = {  // 设置axios的参数\r\n");
      out.write("                url: '/need/addNeed',\r\n");
      out.write("                data: params,\r\n");
      out.write("                method: 'post',\r\n");
      out.write("                headers: {\r\n");
      out.write("                    'Content-Type': 'multipart/form-data'\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            axios\r\n");
      out.write("                .post( '/need/addNeed',params,{\r\n");
      out.write("                    headers: {\r\n");
      out.write("                        'Content-Type': 'multipart/form-data'\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    result = response.data;\r\n");
      out.write("                    if(result.success) {\r\n");
      out.write("                        alert(\"添加成功！\");\r\n");
      out.write("                        window.location.href = \"/need/getNeedPage/\" + result.msg;\r\n");
      out.write("                    } else {\r\n");
      out.write("                        alert(result.msg);\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
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
