<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="GET" action="search-book">
    <table class="table table-borderless ">
        <tr>
            <th>
                <label for="searchBook">Book name</label>
            </th>
            <th>
                <label for="categoryId">Category</label>
            </th>
            <th></th>
        </tr>
        <tr>
            <td>
                <input type="text" id="searchBook" name="bookName" class="form-control">
            </td>
            <td>
                <select id="categoryId" name="categoryId" class="form-select form-select-sm">
                    <option value="" selected>--Select--</option>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.id}">
                                ${category.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" value="Search" class="btn btn-primary">
            </td>
        </tr>
    </table>
</form>
