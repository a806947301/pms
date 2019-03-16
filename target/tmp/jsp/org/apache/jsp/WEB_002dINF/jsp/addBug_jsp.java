package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addBug_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>添加Bug</title>\r\n");
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
      out.write("                                添加Bug\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"row\" id=\"addBug\">\r\n");
      out.write("                                    <div class=\"col-md-12\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >Bug详情</label>\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" placeholder=\"文本输入\" v-model=\"title\">\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >请选择Bug处理人</label>\r\n");
      out.write("                                            <select id =\"schoolno\"class=\"form-control selectpicker\" data-live-search=\"true\" v-model=\"processer\" >\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <label >Bug描述</label>\r\n");
      out.write("                                            <div>\r\n");
      out.write("                                                <textarea id=\"editor\" placeholder=\"Balabala\" autofocus ></textarea>\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <br><br>\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <button class=\"btn btn-block btn-secondary\" type=\"button\" v-on:click=\"addBug()\">创建Bug</button>\r\n");
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
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
      out.write("<script src=\"/simditor/scripts/hotkeys.js\"></script>\r\n");
      out.write("<script src=\"/simditor/scripts/uploader.js\"></script>\r\n");
      out.write("<script src=\"/simditor/scripts/simditor.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>\r\n");
      out.write("<script src=\"/js/vue.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    var vm = new Vue({\r\n");
      out.write("        el:\"#addBug\",\r\n");
      out.write("        data:{\r\n");
      out.write("            projectId:null,\r\n");
      out.write("            productId:null,\r\n");
      out.write("            bugContent:null,\r\n");
      out.write("            processer:null,\r\n");
      out.write("            title:null,\r\n");
      out.write("            content:null,\r\n");
      out.write("            roleId:null\r\n");
      out.write("        },\r\n");
      out.write("        created:function(){\r\n");
      out.write("            this.projectId = window.location.href.split('/')[window.location.href.split('/').length-1];\r\n");
      out.write("            this.productId = window.location.href.split('/')[window.location.href.split('/').length-2];\r\n");
      out.write("            params1 = new URLSearchParams();\r\n");
      out.write("            params1.append(\"rolename\",\"开发人员\");\r\n");
      out.write("            axios\r\n");
      out.write("                .post(\"/role/getRoleByRoleName\",params1)\r\n");
      out.write("                .then(function (response) {\r\n");
      out.write("                    vm.roleId = response.data.id;\r\n");
      out.write("                    params1 = new URLSearchParams();\r\n");
      out.write("                    params1.append(\"productId\",vm.productId);\r\n");
      out.write("                    params1.append(\"roleId\",vm.roleId);\r\n");
      out.write("                    axios\r\n");
      out.write("                        .post(\"/user/findUserByproductIdRole\",params1)\r\n");
      out.write("                        .then(function (response) {\r\n");
      out.write("                            vm.users = response.data;\r\n");
      out.write("                            vm.processer = vm.users[0].id;\r\n");
      out.write("                            for( i in vm.users)\r\n");
      out.write("                            {\r\n");
      out.write("                                setParticipator(vm.users[i].id,vm.users[i].department.departmentName + \"-\"+vm.users[i].name)\r\n");
      out.write("                            }\r\n");
      out.write("                        })\r\n");
      out.write("                })\r\n");
      out.write("\r\n");
      out.write("        },\r\n");
      out.write("        methods:{\r\n");
      out.write("            addBug:function() {\r\n");
      out.write("                vm.content = $('#editor').val();\r\n");
      out.write("                params = new URLSearchParams();\r\n");
      out.write("                params.append(\"bugTitle\",vm.title);\r\n");
      out.write("                params.append(\"bugContent\",vm.content);\r\n");
      out.write("                params.append(\"project.id\",vm.projectId);\r\n");
      out.write("                params.append(\"bugProcesser.id\",vm.processer);\r\n");
      out.write("               // window.location.href = \"/bug/getBugPage/\" + vm.productId + \"/\" + vm.projectId + \"/\" + \"aaaa\";\r\n");
      out.write("                axios\r\n");
      out.write("                    .post(\"/bug/addBug\",params)\r\n");
      out.write("                    .then(function (response) {\r\n");
      out.write("                        result = response.data;\r\n");
      out.write("                        if(result.success) {\r\n");
      out.write("                            alert(\"添加成功\");\r\n");
      out.write("                            window.location.href = \"/bug/getBugPage/\" + vm.productId + \"/\" + vm.projectId + \"/\" + result.msg;\r\n");
      out.write("                        } else {\r\n");
      out.write("                            alert(result.msg);\r\n");
      out.write("                        }\r\n");
      out.write("                    })\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("    function setParticipator(value,html) {\r\n");
      out.write("        $('#schoolno.selectpicker').append(\"<option value='\"+value+\"'>\"+html+\"</option>\");\r\n");
      out.write("        $('#schoolno').selectpicker('refresh');\r\n");
      out.write("        $('#schoolno').selectpicker('render');\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    $(function(){\r\n");
      out.write("        Simditor.locale = 'zh-CN';//设置中文\r\n");
      out.write("        var editor = new Simditor({\r\n");
      out.write("            textarea: $(\"#editor\"),  //textarea的id\r\n");
      out.write("            placeholder: '',\r\n");
      out.write("            toolbar:  ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link', 'image', 'hr', '|', 'indent', 'outdent', 'alignment'], //工具条都包含哪些内容\r\n");
      out.write("            pasteImage: true,//允许粘贴图片\r\n");
      out.write("            defaultImage: '/simditor/images/image.png',//编辑器插入的默认图片，此处可以删除\r\n");
      out.write("            upload : {\r\n");
      out.write("                url : '/bug/bugImgUpload', //文件上传的接口地址\r\n");
      out.write("                params: {projectId:vm.projectId}, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交\r\n");
      out.write("                fileKey:'file', //服务器端获取文件数据的参数名\r\n");
      out.write("                connectionCount: 3,\r\n");
      out.write("                leaveConfirm: '正在上传文件'\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
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
