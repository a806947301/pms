package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta name=\"viewport\"\r\n");
      out.write("          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>产品</title>\r\n");
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
      out.write("        ul.pagination li {\r\n");
      out.write("            display: inline;\r\n");
      out.write("        }\r\n");
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
      out.write("        ul.pagination li a:hover:not(.active) {\r\n");
      out.write("            background-color: #ddd;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
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
      out.write("                                    <div class=\"col-md-9\"><h4>{{product.productName}}</h4></div>\r\n");
      out.write("                                    <div class=\"col-md-2\">\r\n");
      out.write("                                        ");
      if (_jspx_meth_shiro_hasPermission_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-md-8\">\r\n");
      out.write("                                        <div class=\"card\">\r\n");
      out.write("                                            <div class=\"card-header border border-top-0 border-right-0 border-left-0\">\r\n");
      out.write("                                                产品描述\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"card-body\">\r\n");
      out.write("                                                {{product.productPresentation}}\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"card\">\r\n");
      out.write("                                            <div class=\"card-header\">\r\n");
      out.write("                                                <h7>项目列表</h7>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"card-body p-0\" id=\"projectTable\">\r\n");
      out.write("                                                ");
      out.write("\r\n");
      out.write("                                                <ul class=\"list-group\">\r\n");
      out.write("                                                    <a v-for=\"(project,index) in projects.list\" class=\"list-group-item\"\r\n");
      out.write("                                                       v-bind:href=\"['/project/getProjectPage/'+project.id]\">\r\n");
      out.write("                                                        <div>\r\n");
      out.write("                                                            <h8>{{project.projectName}}</h8>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                        <div>\r\n");
      out.write("                                                            <small v-if=\"project.product\">\r\n");
      out.write("                                                                {{project.product.productName}} -\r\n");
      out.write("                                                                <span class=\"badge badge-success\"\r\n");
      out.write("                                                                      v-if=\"project.finished==true\">已完成</span>\r\n");
      out.write("                                                                <span class=\"badge badge-warning\" v-else>未完成</span>\r\n");
      out.write("                                                            </small>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </a>\r\n");
      out.write("\r\n");
      out.write("                                                </ul>\r\n");
      out.write("                                                <div class=\"justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none\">\r\n");
      out.write("                                                    <ul class=\"pagination pagination-lg\"\r\n");
      out.write("                                                        v-if=\"projects.pageNum <= projects.pages && projects.pageNum >= 3\">\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum-1)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\">&laquo;</a></li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum-2)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-show=\"projects.pages>=projects.pageNum-2\"\r\n");
      out.write("                                                               v-bind:class=\"{'active':(projects.pageNum==2)}\">{{projects.pageNum-2}}</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum-1)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-show=\"projects.pages>=projects.pageNum-1\"\r\n");
      out.write("                                                               v-bind:class=\"{'active':(projects.pageNum==2)}\">{{projects.pageNum-1}}</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-bind:class=\"{'active':true}\">{{projects.pageNum}}</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum+1)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-show=\"projects.pages>=projects.pageNum+1\">{{projects.pageNum+1}}</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum+2)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-show=\"projects.pages>=projects.pageNum+2\">{{projects.pageNum+2}}</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum+1)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\">&raquo;</a></li>\r\n");
      out.write("                                                    </ul>\r\n");
      out.write("                                                    <ul class=\"pagination pagination-lg\" v-else>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum-1)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\">&laquo;</a></li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(1)\" href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-bind:class=\"{'active':(projects.pageNum==1)}\">1</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(2)\" href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-show=\"projects.pages>=2\"\r\n");
      out.write("                                                               v-bind:class=\"{'active':(projects.pageNum==2)}\">2</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(3)\" href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-show=\"projects.pages>=3\"\r\n");
      out.write("                                                               v-bind:class=\"{'active':(projects.pageNum==3)}\">3</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(4)\" href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-show=\"projects.pages>=4\"\r\n");
      out.write("                                                               v-bind:class=\"{'active':(projects.pageNum==4)}\">4</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(5)\" href=\"javascript:void(0);\"\r\n");
      out.write("                                                               v-show=\"projects.pages>=5\"\r\n");
      out.write("                                                               v-bind:class=\"{'active':(projects.pageNum==5)}\">5</a>\r\n");
      out.write("                                                        </li>\r\n");
      out.write("                                                        <li><a v-on:Click=\"getPage(projects.pageNum+1)\"\r\n");
      out.write("                                                               href=\"javascript:void(0);\">&raquo;</a></li>\r\n");
      out.write("                                                    </ul>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-4\">\r\n");
      out.write("                                        ");
      out.write("\r\n");
      out.write("                                        <div class=\"card\">\r\n");
      out.write("                                            <div class=\"card-header\">\r\n");
      out.write("                                                产品成员组\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"card-body\">\r\n");
      out.write("                                                <div class=\"row pre-scrollable\">\r\n");
      out.write("                                                    <table class=\"table table-hover\">\r\n");
      out.write("                                                        <tbody>\r\n");
      out.write("                                                        <tr v-for=\"participator in participators\">\r\n");
      out.write("                                                            <td>\r\n");
      out.write("                                                                {{participator.department.departmentName}}-{{participator.name}}\r\n");
      out.write("                                                            </td>\r\n");
      out.write("                                                            <td>\r\n");
      out.write("                                                                ");
      if (_jspx_meth_shiro_hasPermission_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                            </td>\r\n");
      out.write("                                                        </tr>\r\n");
      out.write("                                                        </tbody>\r\n");
      out.write("                                                    </table>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        ");
      out.write("\r\n");
      out.write("                                        ");
      if (_jspx_meth_shiro_hasPermission_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal fade\" id=\"updateProductModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"\r\n");
      out.write("     aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("\r\n");
      out.write("                <h3>更新产品</h3>\r\n");
      out.write("                <a class=\"close\" data-dismiss=\"modal\">×</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label class=\"control-label\">id</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" v-model=\"id\"\r\n");
      out.write("                               disabled>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label class=\"control-label\">产品名</label>\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" v-model=\"productName\"\r\n");
      out.write("                               placeholder=\"产品名\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label class=\"control-label\">产品描述</label>\r\n");
      out.write("                        <textarea name=\"textarea-input\" class=\"form-control\" id=\"textarea-input\"\r\n");
      out.write("                                  placeholder=\"Content...\" rows=\"9\" v-model=\"productPresentation\">\r\n");
      out.write("\r\n");
      out.write("                        </textarea>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\r\n");
      out.write("                </button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" v-on:click=\"updateProduct()\" data-dismiss=\"modal\">\r\n");
      out.write("                    更新产品\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div><!-- /.modal-content -->\r\n");
      out.write("    </div><!-- /.modal -->\r\n");
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
      out.write("    var updateVm = new Vue({\r\n");
      out.write("        el: '#updateProductModal',\r\n");
      out.write("        data: {\r\n");
      out.write("            id: null,\r\n");
      out.write("            productName: null,\r\n");
      out.write("            productPresentation: null\r\n");
      out.write("        },\r\n");
      out.write("        methods: {\r\n");
      out.write("            updateProduct: function () {\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"id\", this.id);\r\n");
      out.write("                params.append(\"productName\", this.productName);\r\n");
      out.write("                params.append(\"productPresentation\", this.productPresentation);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/product/updateProduct\", params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        alert(response.data.msg);\r\n");
      out.write("                        vm.updateProduct();\r\n");
      out.write("                    })\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    var vm = new Vue({\r\n");
      out.write("        el: \"#getProduct\",\r\n");
      out.write("        data: {\r\n");
      out.write("            product: {productName: null},\r\n");
      out.write("            productId: null,\r\n");
      out.write("            participators: null,\r\n");
      out.write("            newParticipators: null,\r\n");
      out.write("            projects: {}\r\n");
      out.write("        },\r\n");
      out.write("        created: function () {\r\n");
      out.write("            this.productId = window.location.href.split('/')[window.location.href.split('/').length - 1];\r\n");
      out.write("            params = new URLSearchParams();\r\n");
      out.write("            params.append(\"id\", this.productId)\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/product/getProduct\", params)\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.product = response.data;\r\n");
      out.write("                });\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/product/getProductParticipator\", params)\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.participators = response.data;\r\n");
      out.write("                })\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/user/findAllUser\")\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.users = response.data;\r\n");
      out.write("                    outer:for (i in vm.users) {\r\n");
      out.write("                        for (j in vm.participators) {\r\n");
      out.write("                            if (vm.participators[j].id == vm.users[i].id) {\r\n");
      out.write("                                continue outer;\r\n");
      out.write("                            }\r\n");
      out.write("                        }\r\n");
      out.write("                        setParticipator(vm.users[i].id, vm.users[i].department.departmentName + \"-\" + vm.users[i].name)\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("            projectParams = new URLSearchParams();\r\n");
      out.write("            projectParams.append(\"productId\", this.productId);\r\n");
      out.write("            projectParams.append(\"currentPage\", 1);\r\n");
      out.write("            projectParams.append(\"pageSize\", 7);\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/project/findByProductId\", projectParams)\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.projects = response.data;\r\n");
      out.write("                })\r\n");
      out.write("        },\r\n");
      out.write("        methods: {\r\n");
      out.write("            getPage: function (currentPage) {\r\n");
      out.write("                if (currentPage <= 0) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if (currentPage > vm.projects.pages) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                projectParams = new URLSearchParams();\r\n");
      out.write("                projectParams.append(\"productId\", this.productId);\r\n");
      out.write("                projectParams.append(\"currentPage\", currentPage);\r\n");
      out.write("                projectParams.append(\"pageSize\", 7);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/project/findByProductId\", projectParams)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        vm.projects = response.data;\r\n");
      out.write("                    })\r\n");
      out.write("            },\r\n");
      out.write("            updateProduct: function () {\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"id\", this.productId)\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/product/getProduct\", params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        vm.product = response.data;\r\n");
      out.write("                    });\r\n");
      out.write("            },\r\n");
      out.write("            addParticipators: function () {\r\n");
      out.write("\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"id\", this.productId);\r\n");
      out.write("                params.append(\"newParticipator\", this.newParticipators);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/product/addProductParticipator\", params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        vm.updateParticipator();\r\n");
      out.write("                    })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            },\r\n");
      out.write("            deleteParticipator: function (userId) {\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"productId\", this.productId);\r\n");
      out.write("                params.append(\"userId\", userId);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/product/deleteProductParticipator\", params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        if (response.data.success == false) {\r\n");
      out.write("                            alert(response.data.msg);\r\n");
      out.write("                        }\r\n");
      out.write("                        vm.updateParticipator();\r\n");
      out.write("                    })\r\n");
      out.write("            },\r\n");
      out.write("            updateParticipator: function () {\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"id\", this.productId);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/product/getProductParticipator\", params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        vm.participators = response.data;\r\n");
      out.write("                        reImportSelectData();\r\n");
      out.write("                    })\r\n");
      out.write("            },\r\n");
      out.write("            updateProductModal: function (productId, productName, productPresentation) {\r\n");
      out.write("                updateVm.id = productId;\r\n");
      out.write("                updateVm.productName = productName;\r\n");
      out.write("                updateVm.productPresentation = productPresentation;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("    function reImportSelectData() {\r\n");
      out.write("        clearParticipator();\r\n");
      out.write("        outer:for (i in vm.users) {\r\n");
      out.write("            for (j in vm.participators) {\r\n");
      out.write("                if (vm.participators[j].id == vm.users[i].id) {\r\n");
      out.write("                    continue outer;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            setParticipator(vm.users[i].id, vm.users[i].department.departmentName + \"-\" + vm.users[i].name)\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function setParticipator(value, html) {\r\n");
      out.write("        $('#schoolno.selectpicker').append(\"<option value='\" + value + \"'>\" + html + \"</option>\");\r\n");
      out.write("        $('#schoolno').selectpicker('refresh');\r\n");
      out.write("        $('#schoolno').selectpicker('render');\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_shiro_hasPermission_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_hasPermission_0 = (org.apache.shiro.web.tags.HasPermissionTag) _jspx_tagPool_shiro_hasPermission_name.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_hasPermission_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_hasPermission_0.setParent(null);
    _jspx_th_shiro_hasPermission_0.setName("update:product");
    int _jspx_eval_shiro_hasPermission_0 = _jspx_th_shiro_hasPermission_0.doStartTag();
    if (_jspx_eval_shiro_hasPermission_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <button class=\"btn btn-block btn-outline-warning\" type=\"button\"\r\n");
        out.write("                                                data-toggle=\"modal\" data-target=\"#updateProductModal\"\r\n");
        out.write("                                                v-on:click=\"updateProductModal(product.id,product.productName,product.productPresentation)\">\r\n");
        out.write("                                            更新产品信息\r\n");
        out.write("                                        </button>\r\n");
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
    _jspx_th_shiro_hasPermission_1.setName("addUser:product");
    int _jspx_eval_shiro_hasPermission_1 = _jspx_th_shiro_hasPermission_1.doStartTag();
    if (_jspx_eval_shiro_hasPermission_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                                                    <button class=\"btn btn-outline-danger btn-sm\"\r\n");
        out.write("                                                                            type=\"button\"\r\n");
        out.write("                                                                            v-on:click=\"deleteParticipator(participator.id)\">\r\n");
        out.write("                                                                        移出产品组\r\n");
        out.write("                                                                    </button>\r\n");
        out.write("                                                                ");
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
    _jspx_th_shiro_hasPermission_2.setName("addUser:product");
    int _jspx_eval_shiro_hasPermission_2 = _jspx_th_shiro_hasPermission_2.doStartTag();
    if (_jspx_eval_shiro_hasPermission_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                        <div class=\"form-group\">\r\n");
        out.write("                                            <label>参与人员</label>\r\n");
        out.write("                                            <select id=\"schoolno\" class=\"form-control selectpicker\"\r\n");
        out.write("                                                    data-live-search=\"true\" multiple v-model=\"newParticipators\">\r\n");
        out.write("                                            </select>\r\n");
        out.write("                                            <br><br>\r\n");
        out.write("                                            <button class=\"btn btn-block btn-outline-success\" type=\"button\"\r\n");
        out.write("                                                    v-on:click=\"addParticipators()\">添加成员\r\n");
        out.write("                                            </button>\r\n");
        out.write("                                        </div>\r\n");
        out.write("                                    </div>\r\n");
        out.write("                                    ");
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
}
