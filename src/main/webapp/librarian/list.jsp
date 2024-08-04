<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>id</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="count" scope="page" value="0"/>
    <c:forEach items="${librarianList}" var="librarian">
        <c:set var="count" value="${count + 1}" scope="page"/>
        <tr>
            <td>${count}</td>
            <td>${librarian.name}</td>
            <td>${librarian.email}</td>
            <td>${librarian.password}</td>
            <td>
                <a href="products?action=delete&id=${librarian.id}" class="btn btn-danger btn-sm"
                   onclick="confirmDeletion(event)">Xóa</a> |
                <a href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}"
                   class="btn btn-warning btn-sm">Sửa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Thêm JavaScript của Bootstrap cho các tính năng bổ sung -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

