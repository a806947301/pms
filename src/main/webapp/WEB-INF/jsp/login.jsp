<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/5
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4" id="loginForm">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                        登录
                    </div>

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">邮箱</label>
                            <input type="email" class="form-control" v-model="email">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input type="password" class="form-control" v-model="password">
                        </div>

                       <%-- <div class="custom-control custom-checkbox mt-4">
                            <input type="checkbox" class="custom-control-input" id="login">
                            <label class="custom-control-label" for="login">Check this custom checkbox</label>
                        </div>--%>
                    </div>

                    <div class="card-footer">
                        <div class="row">
                            <div class="col-6">
                                <button type="button" class="btn btn-primary px-5" v-on:click="login()">登录</button>
                            </div>

                            <div class="col-6">
                                <a href="/user/registerPage" class="btn btn-link">立即注册?</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/popper.js/popper.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/vendor/chart.js/chart.min.js"></script>
<script src="/js/carbon.js"></script>
<script src="/js/demo.js"></script>
<%--vue--%>
<script src="/js/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    var vm = new Vue({
        el:'#loginForm',
        data:{
            email:null,
            password:null,
            msg:null
        },
        methods:{
            login:function() {
                params = new URLSearchParams();
                params.append("email",this.email);
                params.append("password",this.password);
                axios
                    .post("/user/login",params)
                    .then(function (response) {
                        result = response.data;
                        if(result.success == false) {
                            alert(result.msg);
                        } else {
                           window.location.href=result.msg;
                        }
                    })
            }

        }
    })
</script>
</body>
</html>
