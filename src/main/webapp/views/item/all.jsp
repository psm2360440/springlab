<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .medium_img {
        width: 80px;
    }
</style>

<div class="col-sm-8 text-left">
    <div class="row content">
        <div class="col-sm-6 text-left">
            <h3>전체 상품 보기 화면입니다.</h3>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>IMG</th>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>PRICE</th>
                    <th>REGDATE</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="obj" items="${allitem}">
                    <tr>
                        <td><a href="/item/get?id=${obj.id}"><img class="medium_img" src="/img/${obj.imgname}"></a></td>
                        <td>${obj.id}</td>
                        <td>${obj.name}</td>
                        <td><fmt:formatNumber value="${obj.price}" type="currency"/></td>
                        <td><fmt:formatDate value="${obj.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
