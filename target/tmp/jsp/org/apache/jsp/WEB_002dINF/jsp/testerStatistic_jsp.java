package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testerStatistic_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>测试人员统计</title>\r\n");
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
      out.write("                        <div class=\"card\" id=\"productStatistics\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"card-header bg-light\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-md-9\"><h4>测试人员统计</h4></div>\r\n");
      out.write("                                    <div class=\"col-md-2\">\r\n");
      out.write("                                        <button class=\"btn btn-block btn-outline-warning\" type=\"button\" data-toggle=\"modal\"\r\n");
      out.write("                                                v-on:click=\"exportExcel()\">导出EXCEL</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <table class=\"table table-hover\">\r\n");
      out.write("                                    <thead>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th scope=\"col\">序号</th>\r\n");
      out.write("                                        <th scope=\"col\">姓名</th>\r\n");
      out.write("                                        <th scope=\"col\">指派中Bug</th>\r\n");
      out.write("                                        <th scope=\"col\">处理中Bug</th>\r\n");
      out.write("                                        <th scope=\"col\">验收中Bug</th>\r\n");
      out.write("                                        <th scope=\"col\">已完成Bug</th>\r\n");
      out.write("                                        <th scope=\"col\">Bug总数</th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                    <tr v-for=\"(tester,index) in testers\">\r\n");
      out.write("                                        <td>{{index+1}}</td>\r\n");
      out.write("                                        <td>{{tester.username}}</td>\r\n");
      out.write("                                        <td>{{tester.designate}}</td>\r\n");
      out.write("                                        <td>{{tester.processing}}</td>\r\n");
      out.write("                                        <td>{{tester.checking}}</td>\r\n");
      out.write("                                        <td>{{tester.finished}}</td>\r\n");
      out.write("                                        <td>{{tester.bugNumber}}</td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
      out.write("        el:\"#productStatistics\",\r\n");
      out.write("        data:{\r\n");
      out.write("            testers:{}\r\n");
      out.write("        },\r\n");
      out.write("        created:function(){\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/statistic/testerStatistic\")\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.testers = response.data;\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        },\r\n");
      out.write("        methods: {\r\n");
      out.write("            exportExcel:function () {\r\n");
      out.write("                window.location.href=\"/statistic/exportExcelTester\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    function reImportSelectData() {\r\n");
      out.write("        clearParticipator();\r\n");
      out.write("        outer:for( i in vm.users)\r\n");
      out.write("        {\r\n");
      out.write("            for(j in vm.participators) {\r\n");
      out.write("                if(vm.participators[j].id == vm.users[i].id) {\r\n");
      out.write("                    continue outer;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            console.log(\"set\")\r\n");
      out.write("            setParticipator(vm.users[i].id,vm.users[i].department.departmentName + \"-\"+vm.users[i].name)\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    function setParticipator(value,html) {\r\n");
      out.write("        $('#schoolno.selectpicker').append(\"<option value='\"+value+\"'>\"+html+\"</option>\");\r\n");
      out.write("        $('#schoolno').selectpicker('refresh');\r\n");
      out.write("        $('#schoolno').selectpicker('render');\r\n");
      out.write("    }\r\n");
      out.write("    function clearParticipator() {\r\n");
      out.write("\r\n");
      out.write("        $('#schoolno.selectpicker').empty();\r\n");
      out.write("        $('#schoolno').selectpicker('refresh');\r\n");
      out.write("        $('#schoolno').selectpicker('render');\r\n");
      out.write("    }\r\n");
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
