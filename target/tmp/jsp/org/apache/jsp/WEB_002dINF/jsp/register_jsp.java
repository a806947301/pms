package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"page-wrapper flex-row align-items-center\" id=\"register\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row justify-content-center\">\r\n");
      out.write("            <div class=\"col-md-5\">\r\n");
      out.write("                <div class=\"card p-4\">\r\n");
      out.write("                    <div class=\"card-header text-center text-uppercase h4 font-weight-light\">\r\n");
      out.write("                        注册\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"card-body py-5\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">姓名</label>\r\n");
      out.write("                            <input class=\"form-control\" type=\"name\" v-model=\"name\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">部门</label>\r\n");
      out.write("                            <select class=\"form-control\" v-model=\"departmentId\">\r\n");
      out.write("                                <option v-for=\"department in departments\" v-bind:value=\"department.id\">\r\n");
      out.write("                                    {{department.departmentName}}\r\n");
      out.write("                                </option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">邮箱\r\n");
      out.write("                                <small style=\"color:red;\">{{existEmail?\"邮箱已存在\":\"\"}}</small>\r\n");
      out.write("                            </label>\r\n");
      out.write("                            <input class=\"form-control\" type=\"email\" v-model=\"email\" v-on:blur=\"validationEmail()\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">验证码\r\n");
      out.write("                                <small style=\"color:red;\">{{valificationTrue?\"\":\"验证码错误\"}}</small>\r\n");
      out.write("                            </label>\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-md-8\">\r\n");
      out.write("                                    <input class=\"form-control\" type=\"text\" v-model=\"inputCode\"\r\n");
      out.write("                                           v-on:blur=\"validationCodeFunction()\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"col-md-4\">\r\n");
      out.write("                                    <button class=\"btn btn-outline-info\" type=\"button\"\r\n");
      out.write("                                            v-on:click=\"getVarification()\">\r\n");
      out.write("                                        {{valificationButton}}\r\n");
      out.write("                                    </button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                       <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">工号</label>\r\n");
      out.write("                            <input class=\"form-control\" type=\"number\" v-model=\"jobNumber\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">密码</label>\r\n");
      out.write("                            <input class=\"form-control\" type=\"password\" v-model=\"password\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label class=\"form-control-label\">再次输入密码\r\n");
      out.write("                                <small style=\"color:red;\">{{passwordTrue?\"\":\"两次密码不一样\"}}</small>\r\n");
      out.write("                            </label>\r\n");
      out.write("                            <input class=\"form-control\" type=\"password\" v-on:blur=\"validationPassword()\"\r\n");
      out.write("                                v-model=\"repassword\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"card-footer\">\r\n");
      out.write("                        <button class=\"btn btn-success btn-block\" type=\"submit\" v-on:click=\"register()\">立即注册</button>\r\n");
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
      out.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\r\n");
      out.write("<script src=\"/js/vue.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    var vm = new Vue({\r\n");
      out.write("        el:'#register',\r\n");
      out.write("        data:{\r\n");
      out.write("            email:null,\r\n");
      out.write("            name:null,\r\n");
      out.write("            password:null,\r\n");
      out.write("            repassword:null,\r\n");
      out.write("            departmentId:null,\r\n");
      out.write("            jobNumber:null,\r\n");
      out.write("            msg:null,\r\n");
      out.write("            departmentId:null,\r\n");
      out.write("            departments:{},\r\n");
      out.write("            existEmail:false,\r\n");
      out.write("            valificationButton:\"获取验证码\",\r\n");
      out.write("            valificationCode:null,\r\n");
      out.write("            inputCode:null,\r\n");
      out.write("            valificationTrue:true,\r\n");
      out.write("            isValification:false,\r\n");
      out.write("            passwordTrue:true\r\n");
      out.write("        },\r\n");
      out.write("        created:function() {\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/department/finfAllDepartment\")\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.departments = response.data;\r\n");
      out.write("                    vm.departmentId = response.data[0].id;\r\n");
      out.write("                })\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            getVarification:function() {\r\n");
      out.write("                if(this.existEmail) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(this.isValification) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"email\",this.email);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/user/getVarification\",params)\r\n");
      out.write("                    .then(function (value) {\r\n");
      out.write("                        if(value.data.success == false) {\r\n");
      out.write("                            alert(value.msg);\r\n");
      out.write("                            return;\r\n");
      out.write("                        }\r\n");
      out.write("                        vm.valificationCode = value.data.msg;\r\n");
      out.write("                        vm.valificationButton = \"验证码已发送\";\r\n");
      out.write("                        vm.isValification = true;\r\n");
      out.write("                    })\r\n");
      out.write("            },\r\n");
      out.write("            validationCodeFunction:function() {\r\n");
      out.write("                if(this.inputCode != this.valificationCode) {\r\n");
      out.write("                    this.valificationTrue =false;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            },\r\n");
      out.write("            validationPassword:function(){\r\n");
      out.write("              if(this.password != this.repassword) {\r\n");
      out.write("                  this.passwordTrue = false;\r\n");
      out.write("              } else {\r\n");
      out.write("                  this.passwordTrue = true;\r\n");
      out.write("              }\r\n");
      out.write("            },\r\n");
      out.write("            validationEmail:function() {\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"email\",this.email);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/user/existEmail\",params)\r\n");
      out.write("                    .then(function (value) {\r\n");
      out.write("                        if(value.data.success == true) {\r\n");
      out.write("                            vm.existEmail = value.data.msg;\r\n");
      out.write("                        } else {\r\n");
      out.write("                            alert(value.data.msg);\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("            },\r\n");
      out.write("            register:function() {\r\n");
      out.write("                this.validationPassword();\r\n");
      out.write("                this.validationCodeFunction();\r\n");
      out.write("                this.validationEmail();\r\n");
      out.write("                if(this.existEmail || (!this.passwordTrue) || (!this.valificationTrue)) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(this.name == null || this.email == null || this.password == null || this.repassword == null) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                if(this.jobNumber == null || this.departmentId == null || this.inputCode == null) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"name\",this.name);\r\n");
      out.write("                params.append(\"jobNumber\",this.jobNumber);\r\n");
      out.write("                params.append(\"email\",this.email);\r\n");
      out.write("                params.append(\"password\",this.password);\r\n");
      out.write("                params.append(\"department.id\",this.departmentId);\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/user/register\",params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        alert(response.data.msg);\r\n");
      out.write("                        if(response.data.success) {\r\n");
      out.write("                            window.location.href=\"/user/loginPage\";\r\n");
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
