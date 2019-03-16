package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>登录</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/simple-line-icons/css/simple-line-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/font-awesome/css/fontawesome-all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/styles.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"page-wrapper flex-row align-items-center\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row justify-content-center\">\r\n");
      out.write("            <div class=\"col-md-5\">\r\n");
      out.write("                <div class=\"card p-4\" id=\"loginForm\">\r\n");
      out.write("                    <div class=\"card-header text-center text-uppercase h4 font-weight-light\">\r\n");
      out.write("                        登录\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"card-body py-5\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">邮箱</label>\r\n");
      out.write("                            <input type=\"email\" class=\"form-control\" v-model=\"email\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">密码</label>\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" v-model=\"password\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                       ");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"card-footer\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-6\">\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-primary px-5\" v-on:click=\"login()\">登录</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"col-6\">\r\n");
      out.write("                                <a href=\"/user/registerPage\" class=\"btn btn-link\">立即注册?</a>\r\n");
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
      out.write("\r\n");
      out.write("<script src=\"/js/vue.min.js\"></script>\r\n");
      out.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    var vm = new Vue({\r\n");
      out.write("        el:'#loginForm',\r\n");
      out.write("        data:{\r\n");
      out.write("            email:null,\r\n");
      out.write("            password:null,\r\n");
      out.write("            msg:null\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            login:function() {\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"email\",this.email);\r\n");
      out.write("                params.append(\"password\",this.password);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/user/login\",params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        result = response.data;\r\n");
      out.write("                        if(result.success == false) {\r\n");
      out.write("                            alert(result.msg);\r\n");
      out.write("                        } else {\r\n");
      out.write("                            window.location.href=result.msg;\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
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
