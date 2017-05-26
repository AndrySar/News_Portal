<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23.05.17
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<jsp:include page="include/header.jsp"/>

    <%--Page Content--%>
    <!-- content-section-start-here -->
    <div class="main-body">
        <div class="wrap">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 content-left">
                        <div class="articles">
                            <header>
                                <h3 class="title-head">
                                    <c:if test="${not empty headTitle}">${headTitle.name}</c:if>
                                    <c:if test="${empty headTitle}">News</c:if>
                                </h3>
                            </header>

                            <c:if test="${empty newsList}">
                                <div class="div_margin_top">
                                    <h3>
                                        <p>News not found</p>
                                    </h3>
                                </div>
                            </c:if>

                            <c:forEach items="${newsList}" var="item">
                                <div class="article">
                                    <div class="article-left">
                                        <a href=${pageContext.request.contextPath}/news/${item.id}><img
                                                src="images/article4.jpg"></a>
                                    </div>
                                    <div class="article-right">
                                        <div class="article-title">
                                            <p>On ${item.formatDate}</p>
                                            <a class="title" href=${pageContext.request.contextPath}/news/${item.id}>
                                                <s:escapeBody htmlEscape="true"> ${item.name}</s:escapeBody>
                                            </a>
                                        </div>
                                        <div class="article-text">
                                            <p><s:escapeBody htmlEscape="true">${item.description}</s:escapeBody></p>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>

                                    <ul class="tags">
                                        <c:forEach items="${item.categorys}" var="categor">
                                            <li><a class="tag" href="#">${categor.name}</a></li>
                                        </c:forEach>
                                    </ul>
                                    <div class="container-fluid">
                                        <div class="pull-right">
                                            <div>
                                                <a href="${pageContext.request.contextPath}/news/${item.id}"
                                                   class="btn btn-default btn-sm">
                                                    <span class="glyphicon glyphicon-chevron-right"></span> Read More
                                                </a>
                                                <a href="${pageContext.request.contextPath}/news/edit/${item.id}"
                                                   class="btn btn-default btn-sm">
                                                    <span class="glyphicon glyphicon-edit"></span> Edit
                                                </a>
                                                <a href="${pageContext.request.contextPath}/news/delete/${item.id}"
                                                   onclick="return deleteNewsFunction('<s:escapeBody htmlEscape="true"> ${item.name}</s:escapeBody>');"
                                                   class="btn btn-default btn-sm">
                                                    <span class="glyphicon glyphicon-trash"></span> Delete
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="div_margin_top">
                                <div class="container-fluid">
                                    <div class="pull-right">
                                        <a href="${pageContext.request.contextPath}/news/add"
                                           class="btn btn-default btn-lg">
                                            <span class="glyphicon glyphicon-plus-sign"></span> Add News
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 side-bar">
                        <div class="div_margin_top">
                            <jsp:include page="include/menu.jsp"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- content-section-ends-here -->

<script type="text/javascript">
    'use strict'

    var ms = getParameterByName("message");
    if(ms !== null) {
        alert(ms);
    }
</script>


<jsp:include page="include/footer.jsp"/>
