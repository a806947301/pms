package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.LinkedList;
import java.util.List;
import com.dayi.demo.user.model.Department;
import com.github.pagehelper.PageInfo;

public final class premissionManager_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <title>权限管理</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/simple-line-icons/css/simple-line-icons.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/vendor/font-awesome/css/fontawesome-all.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/styles.css\">\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        ul.pagination {\n");
      out.write("            display: inline-block;\n");
      out.write("            padding: 0;\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        ul.pagination li {display: inline;}\n");
      out.write("\n");
      out.write("        ul.pagination li a {\n");
      out.write("            color: black;\n");
      out.write("            float: left;\n");
      out.write("            padding: 8px 16px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            transition: background-color .3s;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .pagination li:first-child a {\n");
      out.write("            border-top-left-radius: 5px;\n");
      out.write("            border-bottom-left-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .pagination li:last-child a {\n");
      out.write("            border-top-right-radius: 5px;\n");
      out.write("            border-bottom-right-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        ul.pagination li a.active {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            border: 1px solid #4CAF50;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        ul.pagination li a:hover:not(.active) {background-color: #ddd;}\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body class=\"sidebar-fixed header-fixed\">\n");
      out.write("<div class=\"page-wrapper\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "page_head.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"main-container\">\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "page_left.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row \">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div class=\"card-header\">\n");
      out.write("                                权限管理\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"card-body p-0\"  id=\"premissionTable\">\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                    <table class=\"table table-striped\">\n");
      out.write("                                        <thead>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>id</th>\n");
      out.write("                                            <th>权限名</th>\n");
      out.write("                                            <th>字段</th>\n");
      out.write("                                            <th>是否菜单</th>\n");
      out.write("                                            <th>上级菜单id</th>\n");
      out.write("                                            <th>创建时间</th>\n");
      out.write("                                            <th>更新时间</th>\n");
      out.write("                                            <th>\n");
      out.write("                                                <button class=\"btn btn-outline-success\" data-toggle=\"modal\" data-target=\"#addPremissionModal\" onclick=\"addPremissionVm.initModal()\">\n");
      out.write("                                                    <i class=\"fa fa-align-center\"></i> &nbsp; 添加权限\n");
      out.write("                                                </button>\n");
      out.write("                                            </th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        </thead>\n");
      out.write("                                        <tbody>\n");
      out.write("\n");
      out.write("                                        <tr v-for=\"p in premissions.list\" key=\"p.id\">\n");
      out.write("                                            <td>{{p.id}}</td>\n");
      out.write("                                            <td>{{p.premissionName}}</td>\n");
      out.write("                                            <td>{{p.field}}</td>\n");
      out.write("                                            <td>{{p.menu}}</td>\n");
      out.write("                                            <td>{{p.parentId==\"\"?\"无\":p.parentId}}</td>\n");
      out.write("                                            <td>{{crtTimeFtt(p.addTime)}}</td>\n");
      out.write("                                            <td>{{crtTimeFtt(p.updateTime)}}</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <button class=\"btn btn-outline-warning\" data-toggle=\"modal\" data-target=\"#updatePremissionModal\"\n");
      out.write("                                                        v-on:click=\"updatePremissionVm.initModal(p.id,p.premissionName,p.field,p.menu,p.parentId)\">\n");
      out.write("                                                    <i class=\"fa fa-clipboard\"></i> &nbsp; 修改\n");
      out.write("                                                </button>\n");
      out.write("                                                <button class=\"btn btn-outline-danger\" v-on:click=\"deletePremission(p.id)\">\n");
      out.write("                                                    <i class=\"fa fa-trash\"></i>&nbsp; 删除\n");
      out.write("                                                </button>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        </tbody>\n");
      out.write("                                    </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"justify-content-around mt-4 p-4 bg-light d-flex border-top d-md-down-none\">\n");
      out.write("                                    <ul class=\"pagination pagination-lg\" v-if=\"premissions.pageNum <= premissions.pages && premissions.pageNum >= 3\">\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum-1)\" href=\"javascript:void(0);\">&laquo;</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum-2)\" href=\"javascript:void(0);\" v-show=\"premissions.pages>=premissions.pageNum-2\"  v-bind:class=\"{'active':(premissions.pageNum==2)}\">{{premissions.pageNum-2}}</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum-1)\" href=\"javascript:void(0);\" v-show=\"premissions.pages>=premissions.pageNum-1\"  v-bind:class=\"{'active':(premissions.pageNum==2)}\">{{premissions.pageNum-1}}</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum)\" href=\"javascript:void(0);\"   v-bind:class=\"{'active':true}\">{{premissions.pageNum}}</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum+1)\" href=\"javascript:void(0);\" v-show=\"premissions.pages>=premissions.pageNum+1\" >{{premissions.pageNum+1}}</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum+2)\" href=\"javascript:void(0);\" v-show=\"premissions.pages>=premissions.pageNum+2\" >{{premissions.pageNum+2}}</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum+1)\" href=\"javascript:void(0);\">&raquo;</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul class=\"pagination pagination-lg\" v-else>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum-1)\" href=\"javascript:void(0);\">&laquo;</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(1)\" href=\"javascript:void(0);\" v-bind:class=\"{'active':(premissions.pageNum==1)}\">1</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(2)\" href=\"javascript:void(0);\" v-show=\"premissions.pages>=2\"  v-bind:class=\"{'active':(premissions.pageNum==2)}\">2</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(3)\" href=\"javascript:void(0);\" v-show=\"premissions.pages>=3\"  v-bind:class=\"{'active':(premissions.pageNum==3)}\">3</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(4)\" href=\"javascript:void(0);\" v-show=\"premissions.pages>=4\"  v-bind:class=\"{'active':(premissions.pageNum==4)}\">4</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(5)\" href=\"javascript:void(0);\" v-show=\"premissions.pages>=5\"  v-bind:class=\"{'active':(premissions.pageNum==5)}\">5</a></li>\n");
      out.write("                                        <li><a v-on:Click=\"getPage(premissions.pageNum+1)\" href=\"javascript:void(0);\">&raquo;</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- 模拟框 -->\n");
      out.write("\n");
      out.write("<div class=\"modal fade\" id=\"addPremissionModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("\n");
      out.write("                <h3>添加权限</h3>\n");
      out.write("                <a class=\"close\" data-dismiss=\"modal\">×</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">权限名</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" v-model=\"premissionName\"\n");
      out.write("                           placeholder=\"请输入权限名称\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">权限字段</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" v-model=\"field\"\n");
      out.write("                           placeholder=\"请输入权限字段\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">类别</label>\n");
      out.write("                    <select class=\"form-control\" v-model=\"menu\">\n");
      out.write("                        <option value=\"true\">是一个菜单</option>\n");
      out.write("                        <option value=\"false\">不是菜单</option>\n");
      out.write("                    </select><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">父级菜单</label>\n");
      out.write("                    <select class=\"form-control\" v-model=\"parentId\">\n");
      out.write("                        <option value=\"\">无</option>\n");
      out.write("                        <option v-for=\"m in menus\" v-bind:value=\"m.id\">{{m.premissionName}}</option>\n");
      out.write("                    </select><br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\n");
      out.write("                </button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" v-on:click=\"addPremission()\"  data-dismiss=\"modal\">\n");
      out.write("                    添加权限\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div><!-- /.modal-content -->\n");
      out.write("    </div><!-- /.modal -->\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"modal fade\" id=\"updatePremissionModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("\n");
      out.write("                <h3>更新权限</h3>\n");
      out.write("                <a class=\"close\" data-dismiss=\"modal\">×</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">ID</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" v-model=\"id\"\n");
      out.write("                           placeholder=\"\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">权限名</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" v-model=\"premissionName\"\n");
      out.write("                           placeholder=\"请输入权限名称\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">权限字段</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" v-model=\"field\"\n");
      out.write("                           placeholder=\"请输入权限字段\"><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">类别</label>\n");
      out.write("                    <select class=\"form-control\" v-model=\"menu\">\n");
      out.write("                        <option value=\"true\">是一个菜单</option>\n");
      out.write("                        <option value=\"false\">不是菜单</option>\n");
      out.write("                    </select><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"control-label\">父级菜单</label>\n");
      out.write("                    <select class=\"form-control\" v-model=\"parentId\">\n");
      out.write("                        <option value=\"\">无</option>\n");
      out.write("                        <option v-for=\"m in menus\" v-bind:value=\"m.id\">{{m.premissionName}}</option>\n");
      out.write("                    </select><br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭\n");
      out.write("                </button>\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" v-on:click=\"updatePremission()\"  data-dismiss=\"modal\">\n");
      out.write("                    更新权限\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div><!-- /.modal-content -->\n");
      out.write("    </div><!-- /.modal -->\n");
      out.write("</div>\n");
      out.write("<script src=\"/vendor/jquery/jquery.min.js\"></script>\n");
      out.write("<script src=\"/vendor/popper.js/popper.min.js\"></script>\n");
      out.write("<script src=\"/vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"/vendor/chart.js/chart.min.js\"></script>\n");
      out.write("<script src=\"/js/carbon.js\"></script>\n");
      out.write("<script src=\"/js/demo.js\"></script>\n");
      out.write("<script src=\"/js/vue.min.js\"></script>\n");
      out.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("    /** 更新权限模拟框vm */\n");
      out.write("    var updatePremissionVm = new Vue({\n");
      out.write("        el:\"#updatePremissionModal\",\n");
      out.write("        data:{\n");
      out.write("            id:null,\n");
      out.write("            field:null,\n");
      out.write("            menu:null,\n");
      out.write("            premissionName:null,\n");
      out.write("            parentId:null,\n");
      out.write("            menus:{}\n");
      out.write("        },\n");
      out.write("        methods:{\n");
      out.write("            updatePremission:function () {\n");
      out.write("                params = new URLSearchParams();\n");
      out.write("                params.append(\"id\",this.id);\n");
      out.write("                params.append(\"field\",this.field);\n");
      out.write("                params.append(\"menu\",this.menu);\n");
      out.write("                params.append(\"premissionName\",this.premissionName);\n");
      out.write("                params.append(\"parentId\",this.parentId);\n");
      out.write("                axios\n");
      out.write("                    .post(\"/premission/updatePremission\",params)\n");
      out.write("                    .then(function (response) {\n");
      out.write("                        vm.getPage(vm.premissions.pageNum);\n");
      out.write("                        if(\"true\" == response.data.success) {\n");
      out.write("                            alert(\"更新成功\");\n");
      out.write("                        } else {\n");
      out.write("                            alert(response.data.msg);\n");
      out.write("                        }\n");
      out.write("                    })\n");
      out.write("            },\n");
      out.write("            initModal:function (id,premissionName,field,menu,parentId) {\n");
      out.write("                this.id = id;\n");
      out.write("                this.premissionName = premissionName;\n");
      out.write("                this.field = field;\n");
      out.write("                this.menu = menu;\n");
      out.write("                this.parentId = parentId;\n");
      out.write("                axios\n");
      out.write("                    .post(\"/premission/findPremissionMenu\")\n");
      out.write("                    .then(function (response) {\n");
      out.write("                        updatePremissionVm.menus = response.data;\n");
      out.write("                    })\n");
      out.write("                }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("    })\n");
      out.write("    /** 添加权限模拟框vm */\n");
      out.write("    var addPremissionVm = new Vue({\n");
      out.write("        el:\"#addPremissionModal\",\n");
      out.write("        data:{\n");
      out.write("            field:null,\n");
      out.write("            menu:null,\n");
      out.write("            premissionName:null,\n");
      out.write("            parentId:null,\n");
      out.write("            menus:{}\n");
      out.write("        },\n");
      out.write("        methods:{\n");
      out.write("            addPremission:function ( ) {\n");
      out.write("                params = new URLSearchParams();\n");
      out.write("                params.append(\"premissionName\",this.premissionName);\n");
      out.write("                params.append(\"field\",this.field);\n");
      out.write("                params.append(\"menu\",this.menu);\n");
      out.write("                params.append(\"parentId\",this.parentId);\n");
      out.write("\n");
      out.write("                axios\n");
      out.write("                    .post(\"/premission/addPremission\",params)\n");
      out.write("                    .then(function (response) {\n");
      out.write("                        vm.getPage(vm.premissions.pageNum);\n");
      out.write("                        if(\"true\" == response.data.success) {\n");
      out.write("                            alert(\"添加成功\");\n");
      out.write("                        } else {\n");
      out.write("                            alert(response.data.msg);\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    })\n");
      out.write("            },\n");
      out.write("            initModal:function () {\n");
      out.write("                axios\n");
      out.write("                    .post(\"/premission/findPremissionMenu\")\n");
      out.write("                    .then(function (response) {\n");
      out.write("                        addPremissionVm.menus = response.data;\n");
      out.write("                    })\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    })\n");
      out.write("    /** 显示权限 */\n");
      out.write("    var vm = new Vue({\n");
      out.write("        el:\"#premissionTable\" ,\n");
      out.write("        data:{\n");
      out.write("            premissions:{}\n");
      out.write("        },\n");
      out.write("        created:function (){\n");
      out.write("            params = new URLSearchParams();\n");
      out.write("            params.append(\"currentPage\",1);\n");
      out.write("            axios\n");
      out.write("                .post(\"/premission/findPremission\",params)\n");
      out.write("                .then(function (response) {\n");
      out.write("                   vm.premissions = response.data;\n");
      out.write("                })\n");
      out.write("        },\n");
      out.write("        methods:{\n");
      out.write("            getPage:function(currentPage) {\n");
      out.write("                if(currentPage<=0)\n");
      out.write("                {\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                if(currentPage>vm.premissions.pages)\n");
      out.write("                {\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                params = new URLSearchParams();\n");
      out.write("                params.append(\"currentPage\",currentPage);\n");
      out.write("                axios\n");
      out.write("                    .post(\"/premission/findPremission\",params)\n");
      out.write("                    .then(function (response) {\n");
      out.write("                        vm.premissions = response.data;\n");
      out.write("                    })\n");
      out.write("            },\n");
      out.write("            beforeUpdate:function(id,roleName)\n");
      out.write("            {\n");
      out.write("                updateRoleVm.id = id;\n");
      out.write("                updateRoleVm.roleName = roleName;\n");
      out.write("            },\n");
      out.write("            deletePremission:function(id) {\n");
      out.write("                params = new URLSearchParams();\n");
      out.write("                params.append(\"id\",id);\n");
      out.write("                axios\n");
      out.write("                    .post(\"/premission/deletePremission\",params)\n");
      out.write("                    .then(function (response) {\n");
      out.write("                        alert(response.data.msg);\n");
      out.write("                        vm.getPage(vm.premissions.pageNum);\n");
      out.write("                    })\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    })\n");
      out.write("    // 对Date的扩展，将 Date 转化为指定格式的String\n");
      out.write("    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，\n");
      out.write("    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)\n");
      out.write("    // 例子：\n");
      out.write("    // (new Date()).Format(\"yyyy-MM-dd hh:mm:ss.S\") ==> 2006-07-02 08:09:04.423\n");
      out.write("    // (new Date()).Format(\"yyyy-M-d h:m:s.S\")      ==> 2006-7-2 8:9:4.18\n");
      out.write("    Date.prototype.Format = function(fmt)\n");
      out.write("    { //author: meizz\n");
      out.write("        var o = {\n");
      out.write("            \"M+\" : this.getMonth()+1,                 //月份\n");
      out.write("            \"d+\" : this.getDate(),                    //日\n");
      out.write("            \"h+\" : this.getHours(),                   //小时\n");
      out.write("            \"m+\" : this.getMinutes(),                 //分\n");
      out.write("            \"s+\" : this.getSeconds(),                 //秒\n");
      out.write("            \"q+\" : Math.floor((this.getMonth()+3)/3), //季度\n");
      out.write("            \"S\"  : this.getMilliseconds()             //毫秒\n");
      out.write("        };\n");
      out.write("        if(/(y+)/.test(fmt))\n");
      out.write("            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+\"\").substr(4 - RegExp.$1.length));\n");
      out.write("        for(var k in o)\n");
      out.write("            if(new RegExp(\"(\"+ k +\")\").test(fmt))\n");
      out.write("                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : ((\"00\"+ o[k]).substr((\"\"+ o[k]).length)));\n");
      out.write("        return fmt;\n");
      out.write("    }\n");
      out.write("    function crtTimeFtt(value){\n");
      out.write("        return new Date(value).Format(\"yyyy-MM-dd hh:mm:ss\");\n");
      out.write("    }\n");
      out.write("    function beforeAdd()\n");
      out.write("    {\n");
      out.write("        addRoleVm.roleName = \"\";\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
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
