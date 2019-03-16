package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dayi.demo.user.model.User;

public final class page_005fhead_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar page-header\">\r\n");
      out.write("    <a href=\"#\" class=\"btn btn-link sidebar-mobile-toggle d-md-none mr-auto\">\r\n");
      out.write("        <i class=\"fa fa-bars\"></i>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"/user/index\">\r\n");
      out.write("        <img src=\"/imgs/logo.png\" alt=\"logo\">\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <a href=\"#\" class=\"btn btn-link sidebar-toggle d-md-down-none\">\r\n");
      out.write("        <i class=\"fa fa-bars\"></i>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <li class=\"nav-item dropdown\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                <img src=\"/imgs/avatar-1.png\" class=\"avatar avatar-sm\" alt=\"logo\">\r\n");
      out.write("                <span class=\"small ml-1 d-md-down-none\">");
      out.print(((User)(session.getAttribute("user"))).getName());
      out.write("</span>\r\n");
      out.write("            </a>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("               ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"dropdown-header\">Settings</div>\r\n");
      out.write("\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <a href=\"javascript:void(0);\" class=\"dropdown-item\" onclick=\"logout()\">\r\n");
      out.write("                    <i class=\"fa fa-lock\"></i> 退出登陆\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</nav>\r\n");
      out.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function logout() {\r\n");
      out.write("        axios\r\n");
      out.write("            .post(\"/user/logout\")\r\n");
      out.write("            .then(function (response) {\r\n");
      out.write("                alert(response.data.msg);\r\n");
      out.write("                location.reload();\r\n");
      out.write("            })\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
