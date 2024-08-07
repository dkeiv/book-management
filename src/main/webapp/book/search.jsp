<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="GET" action="search-book">
    <table>
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
                <input type="text" id="searchBook" name="bookName">
            </td>
            <td>
                <select id="categoryId" name="categoryId">
                    <option value="" selected>Category</option>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.id}">
                                ${category.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" value="Search">
            </td>
        </tr>
    </table>
</form>
