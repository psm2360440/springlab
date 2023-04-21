<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let register_form = {
        init: function () {
            $('#register_btn').click(function () {
                register_form.send();
            });
        },
        send: function () {
            $('#register_form').attr({
                'action': '/registerimpl',
                'method': 'post'
            });
            $('#register_form').submit();
        }
    };
    $(function () {
        register_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="page-header">
        <h1>REGISTER</h1>
    </div>
    <p>WELCOME</p>
    <p>DIGI Campus 2nd</p>
    <form id="register_form">
        <div class="form-group">
            <input type="id" name="id" class="form-control" id="email" placeholder="ID">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="PASSWORD">
        </div>
        <div class="form-group">
            <input type="password2" class="form-control" id="pwd2" placeholder="PASSWORD HERE AGAIN">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="name" name="name" placeholder="NAME">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="phone" name="phone" placeholder="PHONE">
        </div>
        <button type="button" id="register_btn" class="btn btn-block">REGISTER</button>
    </form>
</div>

