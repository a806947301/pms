package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addProject_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>创建项目</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/simple-line-icons/css/simple-line-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/font-awesome/css/fontawesome-all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/styles.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap-select.min.css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- simditor -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/simditor/styles/simditor.css\">\r\n");
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
      out.write("                                创建项目\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row\" id=\"addProject\">\r\n");
      out.write("                                    <div class=\"col-md-12\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >项目名</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"文本输入\" v-model=\"projectName\" >\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >所属产品</label>\r\n");
      out.write("                                            <select id =\"schoolno\"class=\"form-control selectpicker\" data-live-search=\"true\"\r\n");
      out.write("                                                    data-live-search=\"true\" v-model=\"productId\">\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"row\">\r\n");
      out.write("                                                <div class=\"col-md-4\">\r\n");
      out.write("                                                    <label >开始时间</label>\r\n");
      out.write("                                                    <input id=\"meeting\" type=\"date\" value=\"\" class=\"form-control\" v-model=\"beginDate\"/>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"col-md-2\"></div>\r\n");
      out.write("                                                <div class=\"col-md-4\">\r\n");
      out.write("                                                    <label >结束时间</label>\r\n");
      out.write("                                                    <input id=\"meeting1\" type=\"date\" value=\"\" class=\"form-control\" v-model=\"endDate\"/>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <button class=\"btn btn-block btn-secondary\" type=\"button\" v-on:click=\"addProject()\">创建项目</button>\r\n");
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
      out.write("</div>\r\n");
      out.write("<script src=\"/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/vendor/popper.js/popper.min.js\"></script>\r\n");
      out.write("<script src=\"/vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"/vendor/chart.js/chart.min.js\"></script>\r\n");
      out.write("<script src=\"/js/carbon.js\"></script>\r\n");
      out.write("<script src=\"/js/demo.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap-select.min.js\"></script>\r\n");
      out.write("<script src=\"/js/i18n/defaults-zh_CN.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"/simditor/scripts/module.js\"></script>\r\n");
      out.write("<script src=\"/simditor/scripts/uploader.js\"></script>\r\n");
      out.write("<script src=\"/simditor/scripts/hotkeys.js\"></script>\r\n");
      out.write("<script src=\"/simditor/scripts/simditor.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\r\n");
      out.write("<script src=\"/js/vue.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    var vm = new Vue({\r\n");
      out.write("        el:\"#addProject\",\r\n");
      out.write("        data:{\r\n");
      out.write("            projectName:null,\r\n");
      out.write("            products:null,\r\n");
      out.write("            productId:null,\r\n");
      out.write("            beginDate:null,\r\n");
      out.write("            endDate:null\r\n");
      out.write("        },\r\n");
      out.write("        created:function(){\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/product/findAllProduct\")\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.products = response.data;\r\n");
      out.write("                    vm.productId = vm.products[0].id;\r\n");
      out.write("                    for( i in vm.products)\r\n");
      out.write("                    {\r\n");
      out.write("                        setParticipator(vm.products[i].id,vm.products[i].productName)\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            addProject:function () {\r\n");
      out.write("                if(null == this.beginDate) {\r\n");
      out.write("                    alert(\"开始时间不能为空\");\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(null == this.endDate) {\r\n");
      out.write("                    alert(\"结束时间不能为空\");\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(null == this.productId) {\r\n");
      out.write("                    alert(\"产品id不能为空\");\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(null == this.projectName) {\r\n");
      out.write("                    alert(\"项目名不能为空\");\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                /*console.log(\"productName:\"+vm.productName)\r\n");
      out.write("                console.log(\"productPresentation:\"+vm.productPresentation)\r\n");
      out.write("                console.log(\"participator:\"+vm.participator)*/\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"beginDate\",vm.beginDate);\r\n");
      out.write("                params.append(\"endDate\",vm.endDate);\r\n");
      out.write("                params.append(\"product.id\",vm.productId);\r\n");
      out.write("                params.append(\"projectName\",vm.projectName);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/project/addProject\",params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        result = response.data;\r\n");
      out.write("                        console.log(result)\r\n");
      out.write("                        if(result.success) {\r\n");
      out.write("                            alert(\"添加成功\");\r\n");
      out.write("                            window.location.href=\"/project/getProjectPage/\" + result.msg;\r\n");
      out.write("                        } else {\r\n");
      out.write("                            alert(result.msg);\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    function setParticipator(value,html) {\r\n");
      out.write("        $('#schoolno.selectpicker').append(\"<option value='\"+value+\"'>\"+html+\"</option>\");\r\n");
      out.write("        $('#schoolno').selectpicker('refresh');\r\n");
      out.write("        $('#schoolno').selectpicker('render');\r\n");
      out.write("    }\r\n");
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
