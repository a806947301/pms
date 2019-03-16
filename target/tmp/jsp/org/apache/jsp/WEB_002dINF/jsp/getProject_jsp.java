package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getProject_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>项目</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/simple-line-icons/css/simple-line-icons.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/font-awesome/css/fontawesome-all.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/styles.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/bootstrap-select.min.css\">\r\n");
      out.write("    <!-- simditor -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/simditor/styles/simditor.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("        ul.pagination {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        ul.pagination li {display: inline;}\r\n");
      out.write("\r\n");
      out.write("        ul.pagination li a {\r\n");
      out.write("            color: black;\r\n");
      out.write("            float: left;\r\n");
      out.write("            padding: 8px 16px;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            transition: background-color .3s;\r\n");
      out.write("            border: 1px solid #ddd;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .pagination li:first-child a {\r\n");
      out.write("            border-top-left-radius: 5px;\r\n");
      out.write("            border-bottom-left-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .pagination li:last-child a {\r\n");
      out.write("            border-top-right-radius: 5px;\r\n");
      out.write("            border-bottom-right-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        ul.pagination li a.active {\r\n");
      out.write("            background-color: #4CAF50;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: 1px solid #4CAF50;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        ul.pagination li a:hover:not(.active) {background-color: #ddd;}\r\n");
      out.write("    </style>\r\n");
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
      out.write("                        <div class=\"card\" id=\"getProduct\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"card-header bg-light\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-md-8\">{{project.projectName}}</div>\r\n");
      out.write("                                    <div class=\"col-md-2\">\r\n");
      out.write("                                        ");
      if (_jspx_meth_shiro_hasPermission_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-1\" v-if=\"project.finished\">\r\n");
      out.write("                                        <button class=\"btn btn-success\" type=\"button\" data-toggle=\"modal\" data-target=\"#finishedModal\"\r\n");
      out.write("                                                v-on:click=\"finishedVm.beforeVm(project.id,false)\">\r\n");
      out.write("                                            <i class=\"fa fa-cut\"></i>&nbsp; 已完成\r\n");
      out.write("                                        </button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-1\" v-else>\r\n");
      out.write("                                        <button class=\"btn btn-warning\" type=\"button\" data-toggle=\"modal\" data-target=\"#finishedModal\"\r\n");
      out.write("                                                v-on:click=\"finishedVm.beforeVm(project.id,true)\">\r\n");
      out.write("                                            <i class=\"fa fa-clipboard\"></i> &nbsp; 未完成\r\n");
      out.write("                                        </button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-body text-center\">\r\n");
      out.write("                                所属产品：<a v-bind:href=\"['/product/getProductPage/'+project.product.id]\">{{project.product.productName}}</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-6\" id=\"needTable\">\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div class=\"card-header bg-light\">\r\n");
      out.write("                                <dir class=\"row\">\r\n");
      out.write("                                    <div class=\"col-md-2\">\r\n");
      out.write("                                        需求\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-6\"></div>\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        ");
      if (_jspx_meth_shiro_hasPermission_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </dir>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-body  border-top\" v-for=\"need in needs.list\">\r\n");
      out.write("                                <a v-bind:href=\"['/need/getNeedPage/'+need.id]\">{{need.needName}}</a> - <small class=\"text-mutedz\">{{need.user.name}}</small><br>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none\">\r\n");
      out.write("                                <ul class=\"pagination pagination-lg\" v-if=\"needs.pageNum <= needs.pages && needs.pageNum >= 3\">\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum-1)\" href=\"javascript:void(0);\">&laquo;</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum-2)\" href=\"javascript:void(0);\" v-show=\"needs.pages>=needs.pageNum-2\"  v-bind:class=\"{'active':(needs.pageNum==2)}\">{{needs.pageNum-2}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum-1)\" href=\"javascript:void(0);\" v-show=\"needs.pages>=needs.pageNum-1\"  v-bind:class=\"{'active':(needs.pageNum==2)}\">{{needs.pageNum-1}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum)\" href=\"javascript:void(0);\"   v-bind:class=\"{'active':true}\">{{needs.pageNum}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum+1)\" href=\"javascript:void(0);\" v-show=\"needs.pages>=needs.pageNum+1\" >{{needs.pageNum+1}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum+2)\" href=\"javascript:void(0);\" v-show=\"needs.pages>=needs.pageNum+2\" >{{needs.pageNum+2}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum+1)\" href=\"javascript:void(0);\">&raquo;</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <ul class=\"pagination pagination-lg\" v-else>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum-1)\" href=\"javascript:void(0);\">&laquo;</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(1)\" href=\"javascript:void(0);\" v-bind:class=\"{'active':(needs.pageNum==1)}\">1</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(2)\" href=\"javascript:void(0);\" v-show=\"needs.pages>=2\"  v-bind:class=\"{'active':(needs.pageNum==2)}\">2</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(3)\" href=\"javascript:void(0);\" v-show=\"needs.pages>=3\"  v-bind:class=\"{'active':(needs.pageNum==3)}\">3</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(4)\" href=\"javascript:void(0);\" v-show=\"needs.pages>=4\"  v-bind:class=\"{'active':(needs.pageNum==4)}\">4</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(5)\" href=\"javascript:void(0);\" v-show=\"needs.pages>=5\"  v-bind:class=\"{'active':(needs.pageNum==5)}\">5</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(needs.pageNum+1)\" href=\"javascript:void(0);\">&raquo;</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-6\" id=\"bugTable\">\r\n");
      out.write("                        <div class=\"card\">\r\n");
      out.write("                            <div class=\"card-header bg-light\">\r\n");
      out.write("                                <dir class=\"row\">\r\n");
      out.write("                                    <div class=\"col-md-2\">\r\n");
      out.write("                                        bug\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-2\"></div>\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        ");
      if (_jspx_meth_shiro_hasPermission_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        ");
      if (_jspx_meth_shiro_hasPermission_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </dir>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-body  border-top\" v-for=\"bug in bugs.list\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-md-8\">\r\n");
      out.write("                                        <a v-bind:href=\"['/bug/getBugPage/'+vm.productId+'/'+ vm.projectId +'/'+bug.id]\">{{bug.bugTitle}}</a>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-4\" v-if=\"bug.bugStatus==3\">\r\n");
      out.write("                                        <button class=\"btn btn-success\">已完成</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-4\" v-else-if=\"bug.bugStatus==2\">\r\n");
      out.write("                                        <button class=\"btn btn-warning\">验收中</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-4\" v-else-if=\"bug.bugStatus==1\">\r\n");
      out.write("                                        <button class=\"btn btn-info\">处理中</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-4\" v-else>\r\n");
      out.write("                                        <button class=\"btn btn-danger\">指派中</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <small>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-md-4\">\r\n");
      out.write("                                            提出者-{{bug.bugProposer.name}}\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-4\">\r\n");
      out.write("                                            处理者-{{bug.bugProcesser.name}}\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-4\">\r\n");
      out.write("                                            日期 {{dateFormat(bug.addTime)}}\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </small>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none\">\r\n");
      out.write("                                <ul class=\"pagination pagination-lg\" v-if=\"bugs.pageNum <= bugs.pages && bugs.pageNum >= 3\">\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum-1)\" href=\"javascript:void(0);\">&laquo;</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum-2)\" href=\"javascript:void(0);\" v-show=\"bugs.pages>=bugs.pageNum-2\"  v-bind:class=\"{'active':(bugs.pageNum==2)}\">{{bugs.pageNum-2}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum-1)\" href=\"javascript:void(0);\" v-show=\"bugs.pages>=bugs.pageNum-1\"  v-bind:class=\"{'active':(bugs.pageNum==2)}\">{{bugs.pageNum-1}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum)\" href=\"javascript:void(0);\"   v-bind:class=\"{'active':true}\">{{bugs.pageNum}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum+1)\" href=\"javascript:void(0);\" v-show=\"bugs.pages>=bugs.pageNum+1\" >{{bugs.pageNum+1}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum+2)\" href=\"javascript:void(0);\" v-show=\"bugs.pages>=bugs.pageNum+2\" >{{bugs.pageNum+2}}</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum+1)\" href=\"javascript:void(0);\">&raquo;</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <ul class=\"pagination pagination-lg\" v-else>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum-1)\" href=\"javascript:void(0);\">&laquo;</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(1)\" href=\"javascript:void(0);\" v-bind:class=\"{'active':(bugs.pageNum==1)}\">1</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(2)\" href=\"javascript:void(0);\" v-show=\"bugs.pages>=2\"  v-bind:class=\"{'active':(bugs.pageNum==2)}\">2</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(3)\" href=\"javascript:void(0);\" v-show=\"bugs.pages>=3\"  v-bind:class=\"{'active':(bugs.pageNum==3)}\">3</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(4)\" href=\"javascript:void(0);\" v-show=\"bugs.pages>=4\"  v-bind:class=\"{'active':(bugs.pageNum==4)}\">4</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(5)\" href=\"javascript:void(0);\" v-show=\"bugs.pages>=5\"  v-bind:class=\"{'active':(bugs.pageNum==5)}\">5</a></li>\r\n");
      out.write("                                    <li><a v-on:Click=\"getPage(bugs.pageNum+1)\" href=\"javascript:void(0);\">&raquo;</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal fade\" id=\"updateProjectModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("\r\n");
      out.write("                <h3>更新项目</h3>\r\n");
      out.write("                <a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label  class=\"control-label\">id</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" v-model=\"project.id\"\r\n");
      out.write("                               disabled>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label  class=\"control-label\">项目名</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" v-model=\"project.projectName\"\r\n");
      out.write("                               placeholder=\"产品名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label  class=\"control-label\">所属产品</label>\r\n");
      out.write("                        <select id =\"schoolno\"class=\"form-control selectpicker\" data-live-search=\"true\"\r\n");
      out.write("                                 v-model=\"productId\">\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-6\">\r\n");
      out.write("                            <label >开始时间</label>\r\n");
      out.write("                            <input id=\"meeting\" type=\"date\" value=\"\" class=\"form-control\" v-model=\"project.beginDate\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-md-6\">\r\n");
      out.write("                            <label >结束时间</label>\r\n");
      out.write("                            <input id=\"meeting1\" type=\"date\" value=\"\" class=\"form-control\"  v-model=\"project.endDate\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <br><br><br><br><br><br>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\r\n");
      out.write("                </button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" v-on:click=\"updateProduct()\"  data-dismiss=\"modal\">\r\n");
      out.write("                    更新项目\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div><!-- /.modal-content -->\r\n");
      out.write("    </div><!-- /.modal -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal fade\" id=\"filtrateModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("\r\n");
      out.write("                <h3>筛选Bug</h3>\r\n");
      out.write("                <a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    开始日期\r\n");
      out.write("                    <input type=\"date\" v-model=\"begin\"/>\r\n");
      out.write("                    结束日期\r\n");
      out.write("                    <input type=\"date\" v-model=\"end\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label>状态</label>\r\n");
      out.write("                    <select class=\"form-control\" v-model=\"status\">\r\n");
      out.write("                        <option value=\"0\">指派中</option>\r\n");
      out.write("                        <option value=\"1\">处理中</option>\r\n");
      out.write("                        <option value=\"2\">验收中</option>\r\n");
      out.write("                        <option value=\"3\">已完成</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label>提出者</label>\r\n");
      out.write("                    <select class=\"form-control\" v-model=\"proposerId\">\r\n");
      out.write("                        <option v-for=\"proposer in proposers\" v-bind:value=\"proposer.id\">{{proposer.name}}</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label>处理者</label>\r\n");
      out.write("                    <select class=\"form-control\" v-model=\"processerId\">\r\n");
      out.write("                        <option v-for=\"processer in processers\" v-bind:value=\"processer.id\">{{processer.name}}</option>\r\n");
      out.write("\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\r\n");
      out.write("                </button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" v-on:click=\"filtrate()\"  data-dismiss=\"modal\">\r\n");
      out.write("                    更新项目\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div><!-- /.modal-content -->\r\n");
      out.write("    </div><!-- /.modal -->\r\n");
      out.write("</div>\r\n");
      if (_jspx_meth_shiro_hasPermission_4(_jspx_page_context))
        return;
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
      out.write("    var finishedVm = new Vue({\r\n");
      out.write("        el:'#finishedModal',\r\n");
      out.write("        data:{\r\n");
      out.write("            finished:null,\r\n");
      out.write("            id:null\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            beforeVm:function(id,finished) {\r\n");
      out.write("                this.id = id;\r\n");
      out.write("                this.finished = finished;\r\n");
      out.write("            },\r\n");
      out.write("            update:function() {\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"projectId\",this.id);\r\n");
      out.write("                params.append(\"finished\",this.finished);\r\n");
      out.write("                params.append(\"countBugNotfinished\",vm.countBugNofinished);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/project/updateProjectFinished\",params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        alert(response.data.msg);\r\n");
      out.write("                    })\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    var updateVm = new Vue({\r\n");
      out.write("        el:'#updateProjectModal',\r\n");
      out.write("        data:{\r\n");
      out.write("            productId:null,\r\n");
      out.write("            project:{\r\n");
      out.write("                id:null\r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            updateProduct:function() {\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"id\",this.project.id);\r\n");
      out.write("                params.append(\"projectName\",this.project.projectName);\r\n");
      out.write("                params.append(\"beginDate\",this.project.beginDate);\r\n");
      out.write("                params.append(\"endDate\",this.project.endDate);\r\n");
      out.write("                params.append(\"product.id\",this.productId);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/project/updateProject\",params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        alert(response.data.msg);\r\n");
      out.write("                        vm.updateProjects();\r\n");
      out.write("                    })\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    var vm = new Vue({\r\n");
      out.write("        el:\"#getProduct\",\r\n");
      out.write("        data:{\r\n");
      out.write("            projectId:null,\r\n");
      out.write("            project:{\r\n");
      out.write("                product:{productName:null}\r\n");
      out.write("            },\r\n");
      out.write("            countBugNofinished:null\r\n");
      out.write("        },\r\n");
      out.write("        created:function(){\r\n");
      out.write("            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];\r\n");
      out.write("            params = new URLSearchParams();\r\n");
      out.write("            params.append(\"id\",this.projectId)\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/bug/countBugByProjectNoFinished\",params)\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.countBugNofinished = response.data;\r\n");
      out.write("                    console.log(vm.countBugNofinished)\r\n");
      out.write("                });\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/project/getProject\",params)\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.project = response.data;\r\n");
      out.write("                    bugVm.productId = vm.productId;\r\n");
      out.write("                });\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/product/findAllProduct\")\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.products = response.data;\r\n");
      out.write("                    vm.productId = vm.products[0].id;\r\n");
      out.write("                    for( i in vm.products)\r\n");
      out.write("                    {\r\n");
      out.write("                        setParticipator(vm.products[i].id,vm.products[i].productName);\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            beforeUpdate:function() {\r\n");
      out.write("                updateVm.project = JSON.parse(JSON.stringify(this.project));\r\n");
      out.write("                updateVm.project.beginDate = dateFormat (updateVm.project.beginDate);\r\n");
      out.write("                updateVm.project.endDate = dateFormat (updateVm.project.endDate);\r\n");
      out.write("                updateVm.productId = this.project.product.id;\r\n");
      out.write("                reflash(this.project.product.id);\r\n");
      out.write("            },\r\n");
      out.write("           updateProjects:function(){\r\n");
      out.write("               params = new URLSearchParams();\r\n");
      out.write("               params.append(\"id\",this.projectId)\r\n");
      out.write("               axios\r\n");
      out.write("                   .post(\"/project/getProject\",params)\r\n");
      out.write("                   .then(function (response) {\r\n");
      out.write("                       vm.project = response.data;\r\n");
      out.write("                   });\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    var needVm = new Vue({\r\n");
      out.write("        el:'#needTable',\r\n");
      out.write("        data:{\r\n");
      out.write("            projectId:null,\r\n");
      out.write("            needs:{\r\n");
      out.write("                list:null\r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("        created:function () {\r\n");
      out.write("            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];\r\n");
      out.write("            params = new URLSearchParams();\r\n");
      out.write("            params.append(\"projectId\",this.projectId);\r\n");
      out.write("            params.append(\"currentPage\",1);\r\n");
      out.write("            params.append(\"pageSize\",5);\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/need/findNeedByProjectId\",params)\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    needVm.needs = response.data;\r\n");
      out.write("                });\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            addNeed:function() {\r\n");
      out.write("                window.location.href=\"/need/addNeedPage/\"+this.projectId;\r\n");
      out.write("            },\r\n");
      out.write("            getPage:function (currentPage) {\r\n");
      out.write("                if(currentPage<=0)\r\n");
      out.write("                {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(currentPage>this.needs.pages)\r\n");
      out.write("                {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"projectId\",this.projectId);\r\n");
      out.write("                params.append(\"currentPage\",currentPage);\r\n");
      out.write("                params.append(\"pageSize\",5);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/need/findNeedByProjectId\",params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        needVm.needs = response.data;\r\n");
      out.write("                    });\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    var bugVm = new Vue({\r\n");
      out.write("        el:'#bugTable',\r\n");
      out.write("        data:{\r\n");
      out.write("            projectId:null,\r\n");
      out.write("            productId:null,\r\n");
      out.write("            bugs:{\r\n");
      out.write("                list:null\r\n");
      out.write("            },\r\n");
      out.write("            params:null,\r\n");
      out.write("            proposerId:null,\r\n");
      out.write("            processerId:null,\r\n");
      out.write("            begin:null,\r\n");
      out.write("            end:null,\r\n");
      out.write("            status:-1\r\n");
      out.write("        },\r\n");
      out.write("        created:function () {\r\n");
      out.write("            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];\r\n");
      out.write("            this.productId = vm.productId;\r\n");
      out.write("            this.params = new URLSearchParams();\r\n");
      out.write("            this.params.append(\"projectId\",this.projectId);\r\n");
      out.write("            this.params.append(\"currentPage\",1);\r\n");
      out.write("            this.params.append(\"pageSize\",5);\r\n");
      out.write("            this.params.append(\"status\",-1);\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/bug/findBugByProject\",this.params)\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    bugVm.bugs = response.data;\r\n");
      out.write("                    filtrateVm.processers=[];\r\n");
      out.write("                    filtrateVm.proposers=[];\r\n");
      out.write("                    for(bug in bugVm.bugs.list) {\r\n");
      out.write("                        flag = false;\r\n");
      out.write("                        for(processer in filtrateVm.processers) {\r\n");
      out.write("                            if(filtrateVm.processers[processer].id == bugVm.bugs.list[bug].bugProcesser.id) {\r\n");
      out.write("                                flag = true;\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                        if(flag == false) {\r\n");
      out.write("                            filtrateVm.processers.push(bugVm.bugs.list[bug].bugProcesser)\r\n");
      out.write("                        }\r\n");
      out.write("                        flag = false;\r\n");
      out.write("                        for(index in filtrateVm.proposers) {\r\n");
      out.write("                            if(filtrateVm.proposers[index].id == bugVm.bugs.list[bug].bugProposer.id) {\r\n");
      out.write("                                flag = true;\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                        if(flag == false) {\r\n");
      out.write("                            filtrateVm.proposers.push(bugVm.bugs.list[bug].bugProposer)\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            addBug:function() {\r\n");
      out.write("                window.location.href=\"/bug/addBugPage/\"+vm.productId + \"/\" + this.projectId;\r\n");
      out.write("            },\r\n");
      out.write("            getPage:function(currentPage) {\r\n");
      out.write("                if(currentPage<=0) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(currentPage>this.bugs.pages && currentPage != 1) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                filtrateVm.processers=[];\r\n");
      out.write("                filtrateVm.proposers=[];\r\n");
      out.write("                this.params.delete(\"currentPage\");\r\n");
      out.write("                this.params.append(\"currentPage\",currentPage);\r\n");
      out.write("                this.params.delete(\"status\");\r\n");
      out.write("                this.params.append(\"status\",this.status);\r\n");
      out.write("                this.params.delete(\"begin\");\r\n");
      out.write("                if(null != this.begin) {\r\n");
      out.write("                    this.params.append(\"begin\",new Date(this.begin));\r\n");
      out.write("                }\r\n");
      out.write("                this.params.delete(\"end\")\r\n");
      out.write("                if(null != this.end) {\r\n");
      out.write("                    this.params.append(\"end\",new Date(this.end));\r\n");
      out.write("                }\r\n");
      out.write("                this.params.delete(\"processerId\")\r\n");
      out.write("                if(null != this.processerId) {\r\n");
      out.write("                    this.params.append(\"processerId\",this.processerId);\r\n");
      out.write("                }\r\n");
      out.write("                this.params.delete(\"proposerId\")\r\n");
      out.write("                if(null != this.proposerId) {\r\n");
      out.write("                    this.params.append(\"proposerId\",this.proposerId);\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/bug/findBugByProject\",this.params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        bugVm.bugs = response.data;\r\n");
      out.write("                        filtrateVm.processers=[];\r\n");
      out.write("                        filtrateVm.proposers=[];\r\n");
      out.write("                        for(bug in bugVm.bugs.list) {\r\n");
      out.write("                            flag = false;\r\n");
      out.write("                            for(processer in filtrateVm.processers) {\r\n");
      out.write("                                if(filtrateVm.processers[processer].id == bugVm.bugs.list[bug].bugProcesser.id) {\r\n");
      out.write("                                    flag = true;\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("                            if(flag == false) {\r\n");
      out.write("                                filtrateVm.processers.push(bugVm.bugs.list[bug].bugProcesser)\r\n");
      out.write("                            }\r\n");
      out.write("                            flag = false;\r\n");
      out.write("                            for(index in filtrateVm.proposers) {\r\n");
      out.write("                                if(filtrateVm.proposers[index].id == bugVm.bugs.list[bug].bugProposer.id) {\r\n");
      out.write("                                    flag = true;\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("                            if(flag == false) {\r\n");
      out.write("                                filtrateVm.proposers.push(bugVm.bugs.list[bug].bugProposer)\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    var filtrateVm = new Vue({\r\n");
      out.write("        el:\"#filtrateModal\",\r\n");
      out.write("        data:{\r\n");
      out.write("            processers:[],\r\n");
      out.write("            proposers:[],\r\n");
      out.write("            begin:null,\r\n");
      out.write("            end:null,\r\n");
      out.write("            status:-1,\r\n");
      out.write("            proposerId:null,\r\n");
      out.write("            processerId:null\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            reflash:function() {\r\n");
      out.write("                this.begin = null;\r\n");
      out.write("                this.end = null;\r\n");
      out.write("                this.status = -1;\r\n");
      out.write("                this.proposerId = null;\r\n");
      out.write("                this.processerId = null;\r\n");
      out.write("            },\r\n");
      out.write("            filtrate:function() {\r\n");
      out.write("                bugVm.begin = this.begin;\r\n");
      out.write("                bugVm.end = this.end;\r\n");
      out.write("                bugVm.status = this.status;\r\n");
      out.write("                bugVm.proposerId = this.proposerId;\r\n");
      out.write("                bugVm.processerId = this.processerId;\r\n");
      out.write("                bugVm.getPage(bugVm.bugs.pageNum);\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    function reflash(id) {\r\n");
      out.write("        $('.selectpicker').selectpicker('val',id);\r\n");
      out.write("        $(\"#schoolno\").selectpicker('refresh');\r\n");
      out.write("    }\r\n");
      out.write("    function setParticipator(value,html) {\r\n");
      out.write("        $('#schoolno.selectpicker').append(\"<option value='\"+value+\"'>\"+html+\"</option>\");\r\n");
      out.write("        $('#schoolno').selectpicker('refresh');\r\n");
      out.write("        $('#schoolno').selectpicker('render');\r\n");
      out.write("    }\r\n");
      out.write("    function dateFormat(val) {\r\n");
      out.write("        val = new Date(val)\r\n");
      out.write("        year = val.getFullYear().toString();\r\n");
      out.write("        month = val.getMonth() >= 9\r\n");
      out.write("            ? (val.getMonth() + 1).toString()\r\n");
      out.write("            : \"0\" + (val.getMonth() + 1);\r\n");
      out.write("        date = val.getDate() >= 9\r\n");
      out.write("            ? val.getDate().toString()\r\n");
      out.write("            : \"0\" + val.getDate();\r\n");
      out.write("        return year + \"-\" + month + \"-\" + date;\r\n");
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

  private boolean _jspx_meth_shiro_hasPermission_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_0 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_0.setParent(null);
    _jspx_th_shiro_hasPermission_0.setName("update:project");
    int _jspx_eval_shiro_hasPermission_0 = _jspx_th_shiro_hasPermission_0.doStartTag();
    if (_jspx_eval_shiro_hasPermission_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <button class=\"btn btn-block btn-outline-warning\" type=\"button\" data-toggle=\"modal\" data-target=\"#updateProjectModal\"\r\n");
        out.write("                                                v-on:click=\"beforeUpdate()\">更新项目信息</button>\r\n");
        out.write("                                        ");
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

  private boolean _jspx_meth_shiro_hasPermission_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_1 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_1.setParent(null);
    _jspx_th_shiro_hasPermission_1.setName("add:need");
    int _jspx_eval_shiro_hasPermission_1 = _jspx_th_shiro_hasPermission_1.doStartTag();
    if (_jspx_eval_shiro_hasPermission_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <button class=\"btn btn-outline-primary\" type=\"button\"\r\n");
        out.write("                                                v-on:click=\"addNeed()\">\r\n");
        out.write("                                            添加需求\r\n");
        out.write("                                        </button>\r\n");
        out.write("                                        ");
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

  private boolean _jspx_meth_shiro_hasPermission_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_2 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_2.setParent(null);
    _jspx_th_shiro_hasPermission_2.setName("select:bug");
    int _jspx_eval_shiro_hasPermission_2 = _jspx_th_shiro_hasPermission_2.doStartTag();
    if (_jspx_eval_shiro_hasPermission_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <button class=\"btn btn-outline-success\" type=\"button\" data-toggle=\"modal\" data-target=\"#filtrateModal\"\r\n");
        out.write("                                            onclick=\"filtrateVm.reflash()\">\r\n");
        out.write("                                            筛选\r\n");
        out.write("                                        </button>\r\n");
        out.write("                                        ");
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

  private boolean _jspx_meth_shiro_hasPermission_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_3 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_3.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_3.setParent(null);
    _jspx_th_shiro_hasPermission_3.setName("add:bug");
    int _jspx_eval_shiro_hasPermission_3 = _jspx_th_shiro_hasPermission_3.doStartTag();
    if (_jspx_eval_shiro_hasPermission_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <button class=\"btn btn-outline-primary\" type=\"button\"\r\n");
        out.write("                                            v-on:click=\"addBug()\">\r\n");
        out.write("                                            添加Bug\r\n");
        out.write("                                        </button>\r\n");
        out.write("                                        ");
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

  private boolean _jspx_meth_shiro_hasPermission_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_4 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_4.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_4.setParent(null);
    _jspx_th_shiro_hasPermission_4.setName("update:project");
    int _jspx_eval_shiro_hasPermission_4 = _jspx_th_shiro_hasPermission_4.doStartTag();
    if (_jspx_eval_shiro_hasPermission_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\r');
        out.write('\n');
        out.write("\r\n");
        out.write("<div class=\"modal fade\" id=\"finishedModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
        out.write("    <div class=\"modal-dialog\">\r\n");
        out.write("        <div class=\"modal-content\">\r\n");
        out.write("            <div class=\"modal-header\">\r\n");
        out.write("\r\n");
        out.write("                <h3>项目完成状态</h3>\r\n");
        out.write("                <a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
        out.write("            </div>\r\n");
        out.write("            <div class=\"modal-body\">\r\n");
        out.write("                确定要更新项目完成状态为：{{finished ? \"已完成\" : \"未完成\"}}\r\n");
        out.write("            </div>\r\n");
        out.write("            <div class=\"modal-footer\">\r\n");
        out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\r\n");
        out.write("                </button>\r\n");
        out.write("                <button type=\"button\" class=\"btn btn-primary\" v-on:click=\"update()\"  data-dismiss=\"modal\">\r\n");
        out.write("                    确定更新\r\n");
        out.write("                </button>\r\n");
        out.write("            </div>\r\n");
        out.write("\r\n");
        out.write("        </div><!-- /.modal-content -->\r\n");
        out.write("    </div><!-- /.modal -->\r\n");
        out.write("</div>\r\n");
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
}
