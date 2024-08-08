<nav>
    <ul class="pagination pagination-lg justify-content-center">
        <li class="page-item <c:if test="${currentPage == 1}">
                        disabled
                    </c:if>">
            <a class="page-link" href="list-book?page=${currentPage -1}">Previous</a>
        </li>
        <c:forEach begin="1" end="${numberOfPage}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active" aria-current="page">
                        <a class="page-link"
                           href="list-book?page=${i}">
                                ${i}
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="list-book?page=${i}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <li class="page-item <c:if test="${currentPage >= numberOfPage}">
                        disabled
                    </c:if>">
            <a class="page-link" href="list-book?page=${currentPage +1}">Next</a>
        </li>
    </ul>
</nav>