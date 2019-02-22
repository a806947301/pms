<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>创建产品</title>
    <link rel="stylesheet" href="/vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/css/styles.css">
    
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <div class="page-header">
        <jsp:include page="page_head.jsp"></jsp:include>
    </div>

    <div class="main-container">
        <jsp:include page="page_left.jsp"></jsp:include>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light">
                                添加产品
                            </div>

                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="normal-input" class="form-control-label">Normal Input</label>
                                            <input id="normal-input" class="form-control" value="Input value">
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="read-only" class="form-control-label">Read Only</label>
                                            <input id="read-only" class="form-control" value="Input value" readonly>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="disabled-input" class="form-control-label">Disabled Input</label>
                                            <input id="disabled-input" class="form-control" value="Input value" disabled>
                                        </div>
                                    </div>
                                </div>

                                <div class="row mt-4">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="placeholder-input" class="form-control-label">Placeholder</label>
                                            <input id="placeholder-input" class="form-control" placeholder="Placeholder text">
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="required-input" class="require">Required</label>
                                            <input id="required-input" class="form-control" value="Input value">
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="form-control-label">Static</label>
                                            <p class="form-control-plaintext">email@example.com</p>
                                        </div>
                                    </div>
                                </div>

                                <div class="row mt-4">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="help-text-input" class="form-control-label">Help text</label>
                                            <input id="help-text-input" class="form-control" placeholder="Enter email">
                                            <small class="form-text">We'll never share your email with anyone else.</small>
                                        </div>
                                    </div>
                                </div>

                                <div class="row mt-4">
                                    <div class="col-md-4">
                                        <label>Sizes</label>

                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-sm" placeholder="Small">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Normal">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-lg" placeholder="Large">
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="single-select">Example select</label>
                                            <select id="single-select" class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="multi-select">Example multiple select</label>
                                            <select id="multi-select" class="form-control" multiple="">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="textarea">Example textarea</label>
                                            <textarea id="textarea" class="form-control" rows="6"></textarea>
                                        </div>
                                    </div>
                                </div>
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
</body>
</html>
