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
    <title>注册</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="page-wrapper flex-row align-items-center" id="register">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                        注册
                    </div>

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">姓名</label>
                            <input class="form-control" type="name" v-model="name">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">部门</label>
                            <select class="form-control" v-model="departmentId">
                                <option v-for="department in departments" v-bind:value="department.id">
                                    {{department.departmentName}}
                                </option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">邮箱
                                <small style="color:red;">{{existEmail?"邮箱已存在":""}}</small>
                            </label>
                            <input class="form-control" type="email" v-model="email" v-on:blur="validationEmail()">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">验证码
                                <small style="color:red;">{{valificationTrue?"":"验证码错误"}}</small>
                            </label>
                            <div class="row">
                                <div class="col-md-8">
                                    <input class="form-control" type="text" v-model="inputCode"
                                           v-on:blur="validationCodeFunction()">
                                </div>
                                <div class="col-md-4">
                                    <button class="btn btn-outline-info" type="button"
                                            v-on:click="getVarification()">
                                        {{valificationButton}}
                                    </button>
                                </div>
                            </div>

                        </div>

                       <div class="form-group">
                            <label class="form-control-label">工号</label>
                            <input class="form-control" type="number" v-model="jobNumber">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input class="form-control" type="password" v-model="password">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">再次输入密码
                                <small style="color:red;">{{passwordTrue?"":"两次密码不一样"}}</small>
                            </label>
                            <input class="form-control" type="password" v-on:blur="validationPassword()"
                                v-model="repassword">
                        </div>
                    </div>

                    <div class="card-footer">
                        <button class="btn btn-success btn-block" type="submit" v-on:click="register()">立即注册</button>
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
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="/js/vue.min.js"></script>
<script>
    var vm = new Vue({
        el:'#register',
        data:{
            email:null,
            name:null,
            password:null,
            repassword:null,
            departmentId:null,
            jobNumber:null,
            msg:null,
            departmentId:null,
            departments:{},
            existEmail:false,
            valificationButton:"获取验证码",
            valificationCode:null,
            inputCode:null,
            valificationTrue:true,
            isValification:false,
            passwordTrue:true
        },
        created:function() {
            axios
                .post("/department/finfAllDepartment")
                .then(function (response) {
                    vm.departments = response.data.obj;
                    vm.departmentId = response.data.obj[0].id;
                })
        },
        methods:{
            getVarification:function() {
                if(this.existEmail) {
                    return;
                }
                if(this.isValification) {
                    return;
                }
                vm.isValification = true;
                vm.valificationButton = "正在发送...";
                params = new URLSearchParams();
                params.append("email",this.email);
                axios
                    .post("/user/getVarification",params)
                    .then(function (value) {
                        if(value.data.success == false) {
                            alert(value.msg);
                            return;
                        }
                        vm.valificationCode = value.data.obj;
                        vm.valificationButton = "验证码已发送";
                        vm.isValification = true;
                    })
            },
            validationCodeFunction:function() {
                if(this.inputCode != this.valificationCode) {
                    this.valificationTrue = false;
                } else {
                    this.valificationTrue = true;
                }

            },
            validationPassword:function(){
              if(this.password != this.repassword) {
                  this.passwordTrue = false;
              } else {
                  this.passwordTrue = true;
              }
            },
            validationEmail:function() {
                params = new URLSearchParams();
                params.append("email",this.email);
                axios
                    .post("/user/existEmail",params)
                    .then(function (value) {
                        if(value.data.success == true) {
                            vm.existEmail = value.data.obj;
                        } else {
                            alert(value.data.msg);
                        }
                    })
            },
            register:function() {
                this.validationPassword();
                this.validationCodeFunction();
                this.validationEmail();
                if(this.existEmail || (!this.passwordTrue) || (!this.valificationTrue)) {
                    return;
                }
                if(this.name == null || this.email == null || this.password == null || this.repassword == null) {
                    return;
                }
                if(this.jobNumber == null || this.departmentId == null || this.inputCode == null) {
                    return;
                }
                params = new URLSearchParams();
                params.append("name",this.name);
                params.append("jobNumber",this.jobNumber);
                params.append("email",this.email);
                params.append("password",this.password);
                params.append("department.id",this.departmentId);
                axios
                    .post("/user/register",params)
                    .then(function (response) {
                        alert(response.data.msg);
                        if(response.data.success) {
                            window.location.href="/user/loginPage";
                        }
                    })
            }

        }
    })
</script>
</body>
</html>
