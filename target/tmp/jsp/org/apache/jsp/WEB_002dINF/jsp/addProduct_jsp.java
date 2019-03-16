package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>创建产品</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/simple-line-icons/css/simple-line-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/font-awesome/css/fontawesome-all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/styles.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap-select.min.css\">\r\n");
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
      out.write("                                添加产品\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row\" id=\"addProduct\">\r\n");
      out.write("                                    <div class=\"col-md-12\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >产品名</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"文本输入\" v-model=\"productName\" >\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >参与人员</label>\r\n");
      out.write("                                            <select id =\"schoolno\"class=\"form-control selectpicker\" data-live-search=\"true\" multiple  v-model=\"participator\">\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >产品介绍</label>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <textarea class=\"form-control\" rows=\"5\"  v-model=\"productPresentation\" >\r\n");
      out.write("                                                </textarea>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <button class=\"btn btn-block btn-secondary\" type=\"button\" v-on:click=\"addProduct\">创建产品</button>\r\n");
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
      out.write("        el:\"#addProduct\",\r\n");
      out.write("        data:{\r\n");
      out.write("            users:null,\r\n");
      out.write("            participator:null,\r\n");
      out.write("            productName:null,\r\n");
      out.write("            productPresentation:null,\r\n");
      out.write("            test:null\r\n");
      out.write("        },\r\n");
      out.write("        created:function(){\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/user/findAllUser\")\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.users = response.data;\r\n");
      out.write("                    for( i in vm.users)\r\n");
      out.write("                    {\r\n");
      out.write("                        setParticipator(vm.users[i].id,vm.users[i].department.departmentName + \"-\"+vm.users[i].name)\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            addProduct:function () {\r\n");
      out.write("                /*console.log(\"productName:\"+vm.productName)\r\n");
      out.write("                console.log(\"productPresentation:\"+vm.productPresentation)\r\n");
      out.write("                console.log(\"participator:\"+vm.participator)*/\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"productName\",vm.productName);\r\n");
      out.write("                params.append(\"productPresentation\",vm.productPresentation);\r\n");
      out.write("                params.append(\"participator\",vm.participator);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/product/addProduct\",params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        result = response.data;\r\n");
      out.write("                        if(result.success == true) {\r\n");
      out.write("                            alert(\"添加成功\");\r\n");
      out.write("                            window.location.href=\"/product/getProductPage/\" + result.msg;\r\n");
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
