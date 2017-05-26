<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.05.17
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%--Header--%>
<jsp:include page="include/header.jsp"/>

    <%--Page Content--%>
    <!-- content-section-start-here -->
    <div class="main-body">
        <div class="wrap">
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/news">News</a></li>
                <li class="active">Review News</li>
            </ol>
            <div class="single-page">
                <div class="col-md-8 content-left single-post">
                    <%--if (!news) else--%>
                    <c:choose>
                        <c:when test="${not empty news}">
                            <div class="blog-posts">
                                <h3 class="post"><s:escapeBody htmlEscape="true">${news.name}</s:escapeBody></h3>
                                <div class="last-article">
                                    <div class="blog_author">
                                        <p><s:escapeBody htmlEscape="true">${news.content}</s:escapeBody></p>
                                    </div>
                                    <ul class="tags">
                                        <c:forEach items="${news.categorys}" var="categor">
                                            <li><a class="tag" href="#">${categor.name}</a></li>
                                        </c:forEach>
                                    </ul>
                                    <div class="artext">
                                        <p>Post on ${news.formatDate}</p>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <div class="container-fluid">
                                <div class="pull-right" >
                                    <div>
                                        <a href="${pageContext.request.contextPath}/news/edit/${news.id}" class="btn btn-default btn-lg">
                                            <span class="glyphicon glyphicon-edit"></span> Edit
                                        </a>
                                        <a href="${pageContext.request.contextPath}/news/delete/${news.id}" class="btn btn-default btn-lg"
                                           onclick="return deleteNewsFunction('<s:escapeBody htmlEscape="true"> ${item.name}</s:escapeBody>');">
                                            <span class="glyphicon glyphicon-trash"></span> Delete
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div>
                                <h3> Sorry, this news is not found! </h3>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-4 side-bar">
                    <jsp:include page="include/menu.jsp"/>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>

<%--Footer--%>
<jsp:include page="include/footer.jsp"/>
