package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class page_005fleft_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_hasPermission_name;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_shiro_hasPermission_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_shiro_hasPermission_name.release();
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"sidebar\">\r\n");
      out.write("    <nav class=\"sidebar-nav\">\r\n");
      out.write("        <ul class=\"nav\">\r\n");
      out.write("            <li class=\"nav-title\">Navigation</li>\r\n");
      out.write("\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a href=\"/user/index\" class=\"nav-link active\">\r\n");
      out.write("                    <i class=\"icon icon-speedometer\"></i> 首页\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_shiro_hasPermission_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            <!-- 产品 -->\r\n");
      out.write("            ");
      if (_jspx_meth_shiro_hasPermission_6(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_shiro_hasPermission_9(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            ");
      if (_jspx_meth_shiro_hasPermission_12(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_shiro_hasPermission_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_0 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_0.setParent(null);
    _jspx_th_shiro_hasPermission_0.setName("userSys");
    int _jspx_eval_shiro_hasPermission_0 = _jspx_th_shiro_hasPermission_0.doStartTag();
    if (_jspx_eval_shiro_hasPermission_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <li class=\"nav-item nav-dropdown\">\r\n");
        out.write("                <a href=\"#\" class=\"nav-link nav-dropdown-toggle\">\r\n");
        out.write("                    <i class=\"icon icon-energy\"></i> 用户系统 <i class=\"fa fa-caret-left\"></i>\r\n");
        out.write("                </a>\r\n");
        out.write("\r\n");
        out.write("                <ul class=\"nav-dropdown-items\">\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                </ul>\r\n");
        out.write("            </li>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_0);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_0);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_1(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_1 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_0);
    _jspx_th_shiro_hasPermission_1.setName("department");
    int _jspx_eval_shiro_hasPermission_1 = _jspx_th_shiro_hasPermission_1.doStartTag();
    if (_jspx_eval_shiro_hasPermission_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/department/departmentManegerPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-energy\"></i> 部门管理\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_1);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_1);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_2(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_2 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_0);
    _jspx_th_shiro_hasPermission_2.setName("user");
    int _jspx_eval_shiro_hasPermission_2 = _jspx_th_shiro_hasPermission_2.doStartTag();
    if (_jspx_eval_shiro_hasPermission_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/user/userManager\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-energy\"></i> 用户管理\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_2);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_2);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_3(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_3 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_3.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_0);
    _jspx_th_shiro_hasPermission_3.setName("role");
    int _jspx_eval_shiro_hasPermission_3 = _jspx_th_shiro_hasPermission_3.doStartTag();
    if (_jspx_eval_shiro_hasPermission_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/role/roleManager\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-energy\"></i> 角色管理\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_3);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_3);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_4(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_4 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_4.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_0);
    _jspx_th_shiro_hasPermission_4.setName("premission");
    int _jspx_eval_shiro_hasPermission_4 = _jspx_th_shiro_hasPermission_4.doStartTag();
    if (_jspx_eval_shiro_hasPermission_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/premission/premissionManger\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-energy\"></i> 权限管理\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_4);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_4);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_5(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_5 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_5.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_0);
    _jspx_th_shiro_hasPermission_5.setName("loginLog");
    int _jspx_eval_shiro_hasPermission_5 = _jspx_th_shiro_hasPermission_5.doStartTag();
    if (_jspx_eval_shiro_hasPermission_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/user/loginLogPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-energy\"></i> 登陆日志\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_5);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_5);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_6 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_6.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_6.setParent(null);
    _jspx_th_shiro_hasPermission_6.setName("product");
    int _jspx_eval_shiro_hasPermission_6 = _jspx_th_shiro_hasPermission_6.doStartTag();
    if (_jspx_eval_shiro_hasPermission_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <li class=\"nav-item nav-dropdown\">\r\n");
        out.write("                <a href=\"#\" class=\"nav-link nav-dropdown-toggle\">\r\n");
        out.write("                    <i class=\"icon icon-target\"></i> 产品 <i class=\"fa fa-caret-left\"></i>\r\n");
        out.write("                </a>\r\n");
        out.write("\r\n");
        out.write("                <ul class=\"nav-dropdown-items\">\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_6, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_8((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_6, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                </ul>\r\n");
        out.write("            </li>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_6);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_6);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_7(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_7 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_7.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_6);
    _jspx_th_shiro_hasPermission_7.setName("select:product");
    int _jspx_eval_shiro_hasPermission_7 = _jspx_th_shiro_hasPermission_7.doStartTag();
    if (_jspx_eval_shiro_hasPermission_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/product/findProductPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-target\"></i> 产品列表\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_7);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_7);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_8(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_8 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_8.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_6);
    _jspx_th_shiro_hasPermission_8.setName("add:product");
    int _jspx_eval_shiro_hasPermission_8 = _jspx_th_shiro_hasPermission_8.doStartTag();
    if (_jspx_eval_shiro_hasPermission_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/product/addProductPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-target\"></i> 创建产品\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_8);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_8);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_9 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_9.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_9.setParent(null);
    _jspx_th_shiro_hasPermission_9.setName("project");
    int _jspx_eval_shiro_hasPermission_9 = _jspx_th_shiro_hasPermission_9.doStartTag();
    if (_jspx_eval_shiro_hasPermission_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <li class=\"nav-item nav-dropdown\">\r\n");
        out.write("                <a href=\"#\" class=\"nav-link nav-dropdown-toggle\">\r\n");
        out.write("                    <i class=\"icon icon-graph\"></i> 项目 <i class=\"fa fa-caret-left\"></i>\r\n");
        out.write("                </a>\r\n");
        out.write("                ");
        if (_jspx_meth_shiro_hasPermission_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_9, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                ");
        if (_jspx_meth_shiro_hasPermission_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_9, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("            </li>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_9);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_9);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_10(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_10 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_10.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_9);
    _jspx_th_shiro_hasPermission_10.setName("select:project");
    int _jspx_eval_shiro_hasPermission_10 = _jspx_th_shiro_hasPermission_10.doStartTag();
    if (_jspx_eval_shiro_hasPermission_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <ul class=\"nav-dropdown-items\">\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/project/findProjectPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-graph\"></i> 项目列表\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                </ul>\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_10.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_10);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_10);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_11(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_9, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_11 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_11.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_9);
    _jspx_th_shiro_hasPermission_11.setName("add:project");
    int _jspx_eval_shiro_hasPermission_11 = _jspx_th_shiro_hasPermission_11.doStartTag();
    if (_jspx_eval_shiro_hasPermission_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                <ul class=\"nav-dropdown-items\">\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/project/addProjectPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-graph\"></i> 添加项目\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                </ul>\r\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_11);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_11);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_12(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_12 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_12.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_12.setParent(null);
    _jspx_th_shiro_hasPermission_12.setName("statistic");
    int _jspx_eval_shiro_hasPermission_12 = _jspx_th_shiro_hasPermission_12.doStartTag();
    if (_jspx_eval_shiro_hasPermission_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("            <li class=\"nav-item nav-dropdown\">\r\n");
        out.write("                <a href=\"#\" class=\"nav-link nav-dropdown-toggle\">\r\n");
        out.write("                    <i class=\"icon icon-umbrella\"></i> 数据统计 <i class=\"fa fa-caret-left\"></i>\r\n");
        out.write("                </a>\r\n");
        out.write("\r\n");
        out.write("                <ul class=\"nav-dropdown-items\">\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_13((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_12, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_14((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_12, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                    ");
        if (_jspx_meth_shiro_hasPermission_15((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_hasPermission_12, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                </ul>\r\n");
        out.write("            </li>\r\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_12.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_12);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_12);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_13(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_12, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_13 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_13.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_12);
    _jspx_th_shiro_hasPermission_13.setName("product:statistic");
    int _jspx_eval_shiro_hasPermission_13 = _jspx_th_shiro_hasPermission_13.doStartTag();
    if (_jspx_eval_shiro_hasPermission_13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/statistic/productStatisticPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-umbrella\"></i> 产品统计\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_13.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_13);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_13);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_14(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_12, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_14 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_14.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_12);
    _jspx_th_shiro_hasPermission_14.setName("developer:statistic");
    int _jspx_eval_shiro_hasPermission_14 = _jspx_th_shiro_hasPermission_14.doStartTag();
    if (_jspx_eval_shiro_hasPermission_14 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/statistic/developerStatisticPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-umbrella\"></i> 开发人员统计\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_14.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_14);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_14);
    return false;
  }

  private boolean _jspx_meth_shiro_hasPermission_15(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_hasPermission_12, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_15 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_15.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_hasPermission_12);
    _jspx_th_shiro_hasPermission_15.setName("test:statistic");
    int _jspx_eval_shiro_hasPermission_15 = _jspx_th_shiro_hasPermission_15.doStartTag();
    if (_jspx_eval_shiro_hasPermission_15 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                    <li class=\"nav-item\">\r\n");
        out.write("                        <a href=\"/statistic/testerStatisticPage\" class=\"nav-link\">\r\n");
        out.write("                            <i class=\"icon icon-umbrella\"></i> 测试人员统计\r\n");
        out.write("                        </a>\r\n");
        out.write("                    </li>\r\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_shiro_hasPermission_15.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_hasPermission_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_15);
      return true;
    }
    _jspx_tagPool_shiro_hasPermission_name.reuse(_jspx_th_shiro_hasPermission_15);
    return false;
  }
}
