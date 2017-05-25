<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23.05.17
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp"/>

<div class="main-body">
    <div class="wrap">
        <div class="container">
            <div class="row">
                <div class="col-md-8 content-left">
                    <div class="articles">
                        <header>
                            <h3 class="title-head">News</h3>
                        </header>

                        <c:if test="${empty newsList}">
                            <p>Nope news</p>
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
                                                ${item.name}
                                        </a>
                                    </div>
                                    <div class="article-text">
                                        <p>${item.description}</p>

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
                                            <a href=${pageContext.request.contextPath}/news/${item.id} class="btn btn-default btn-sm">
                                                <span class="glyphicon glyphicon-chevron-right"></span> Read More
                                            </a>
                                            <a href="#" class="btn btn-default btn-sm">
                                                <span class="glyphicon glyphicon-edit"></span> Edit
                                            </a>
                                            <a href=${pageContext.request.contextPath}/news/delete/${item.id} class="btn btn-default btn-sm">
                                                <span class="glyphicon glyphicon-trash"></span> Delete
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="clearfix"></div>
                        <div class="container-fluid">
                            <div class="pull-right">
                                <a href="#" class="btn btn-info btn-lg">
                                    <span class="glyphicon glyphicon-plus"></span> Add News
                                </a>
                            </div>
                        </div>
                    </div>
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
                </div>
            </div>
        </div>
    </div>
</div>
<!-- content-section-ends-here -->

<script>
    'use strict'
    function getUrlParameter(name) {
        name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
        var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
        var results = regex.exec(location.search);
        return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
    };

    let message = getUrlParameter('message');
    console.log(massege);


</script>


<jsp:include page="include/footer.jsp"/>
