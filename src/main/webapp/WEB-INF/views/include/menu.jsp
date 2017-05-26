<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.05.17
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <!-- menu-section-start-here -->
            <div class="first_half">
                <div class="div_margin_top">
                    <div class="categories">
                        <header>
                            <h3 class="side-title-head">Categories</h3>
                        </header>
                        <ul>
                            <c:forEach items="${categories}" var="category">
                                <li><a href="${pageContext.request.contextPath}/news?caregoryId=${category.id}">${category.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="newsletter">
                    <h1 class="side-title-head">Search News</h1>
                    <p class="sign">Enter a string to search for</p>
                    <form action="${pageContext.request.contextPath}/news" method="get" accept-charset="UTF-8">
                        <input type="text" class="text" name="search" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = 'Enter string';}" value="${param.search}" required/>
                        <input type="submit" value="Search">
                    </form>
                </div>
                <div class="div_margin_top">
                    <a href="${pageContext.request.contextPath}/news"
                       class="btn btn-default btn-lg btn-block">
                        <span class="glyphicon glyphicon-share-alt"></span> News
                    </a>
                </div>
                <div class="div_margin_top">
                    <a href="${pageContext.request.contextPath}/news/add"
                       class="btn btn-default btn-lg btn-block">
                        <span class="glyphicon glyphicon-plus-sign"></span> Add News
                    </a>
                </div>
            </div>
            <!-- menu-section-end-here -->
