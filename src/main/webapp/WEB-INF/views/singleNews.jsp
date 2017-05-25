<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.05.17
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--Header--%>
<jsp:include page="include/header.jsp"/>

<%--Page Content--%>
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
                            <h3 class="post">${news.name}</h3>

                            <div class="last-article">

                                <p class="artext">${news.description}</p>

                                <p class="artext">${news.content}</p>

                                <ul class="tags">
                                    <c:forEach items="${news.categorys}" var="categor">
                                        <li><a class="tag" href="#">${categor.name}</a></li>
                                    </c:forEach>
                                </ul>

                                <div class="clearfix"></div>

                            </div>
                        </div>
                        <div class="container-fluid">
                            <div class="pull-right" >
                                <div>
                                    <a href="#" class="btn btn-default btn-lg">
                                        <span class="glyphicon glyphicon-edit"></span> Edit
                                    </a>
                                    <a href=${pageContext.request.contextPath}/news/delete/${item.id} class="btn btn-default btn-lg">
                                        <span class="glyphicon glyphicon-trash"></span> Delete
                                    </a>
                                </div>
                            </div>
                            <div class="pull-left" >
                                <div class="w3-clear nextprev">
                                    <a class="w3-left w3-btn" href="#">❮ All News</a>
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
                <div class="newsletter">
                    <h1 class="side-title-head">Newsletter</h1>

                    <p class="sign">Sign up to receive our free newsletters!</p>

                    <form>
                        <input type="text" class="text" value="Email Address" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = 'Email Address';}">
                        <input type="submit" value="submit">
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<%--Footer--%>
<jsp:include page="include/footer.jsp"/>
