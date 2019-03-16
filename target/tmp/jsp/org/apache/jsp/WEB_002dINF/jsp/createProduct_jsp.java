package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
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
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"normal-input\" class=\"form-control-label\">Normal Input</label>\r\n");
      out.write("                                            <input id=\"normal-input\" class=\"form-control\" value=\"Input value\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"read-only\" class=\"form-control-label\">Read Only</label>\r\n");
      out.write("                                            <input id=\"read-only\" class=\"form-control\" value=\"Input value\" readonly>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"disabled-input\" class=\"form-control-label\">Disabled Input</label>\r\n");
      out.write("                                            <input id=\"disabled-input\" class=\"form-control\" value=\"Input value\" disabled>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row mt-4\">\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"placeholder-input\" class=\"form-control-label\">Placeholder</label>\r\n");
      out.write("                                            <input id=\"placeholder-input\" class=\"form-control\" placeholder=\"Placeholder text\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"required-input\" class=\"require\">Required</label>\r\n");
      out.write("                                            <input id=\"required-input\" class=\"form-control\" value=\"Input value\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label class=\"form-control-label\">Static</label>\r\n");
      out.write("                                            <p class=\"form-control-plaintext\">email@example.com</p>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row mt-4\">\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"help-text-input\" class=\"form-control-label\">Help text</label>\r\n");
      out.write("                                            <input id=\"help-text-input\" class=\"form-control\" placeholder=\"Enter email\">\r\n");
      out.write("                                            <small class=\"form-text\">We'll never share your email with anyone else.</small>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row mt-4\">\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <label>Sizes</label>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control form-control-sm\" placeholder=\"Small\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"Normal\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control form-control-lg\" placeholder=\"Large\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"single-select\">Example select</label>\r\n");
      out.write("                                            <select id=\"single-select\" class=\"form-control\">\r\n");
      out.write("                                                <option>1</option>\r\n");
      out.write("                                                <option>2</option>\r\n");
      out.write("                                                <option>3</option>\r\n");
      out.write("                                                <option>4</option>\r\n");
      out.write("                                                <option>5</option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"multi-select\">Example multiple select</label>\r\n");
      out.write("                                            <select id=\"multi-select\" class=\"form-control\" multiple=\"\">\r\n");
      out.write("                                                <option>1</option>\r\n");
      out.write("                                                <option>2</option>\r\n");
      out.write("                                                <option>3</option>\r\n");
      out.write("                                                <option>4</option>\r\n");
      out.write("                                                <option>5</option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label for=\"textarea\">Example textarea</label>\r\n");
      out.write("                                            <textarea id=\"textarea\" class=\"form-control\" rows=\"6\"></textarea>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
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
