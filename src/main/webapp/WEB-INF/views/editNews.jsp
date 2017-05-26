<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.05.17
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

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
                    <div class="head-articles">
                        <header>
                            <h3 class="title-head">Edit News</h3>
                        </header>
                    </div>
                    <%--form to add news--%>
                    <form:form action="${pageContext.request.contextPath}/news/edit/${newsObject.id}" method="post"
                               modelAttribute="newsObject" accept-charset="UTF-8">
                        <div class="form-group">
                            <label for="title" class="control-label">Title:</label>
                            <input type="text" class="form-control" name="name" id="title" value="${newsObject.name}"
                                   placeholder="News Title" required>
                        </div>
                        <div class="form-group">
                            <label for="description">Short description:</label>
                            <textarea class="form-control" name="description" id="description" rows="3" required>${newsObject.description}</textarea>
                        </div>

                        <div class="form-group">
                            <label for="content">Content:</label>
                            <textarea class="form-control" name="content" id="content" rows="5" required>${newsObject.content}</textarea>
                        </div>

                        <%--<div class="form-group">--%>
                            <%--<label for="select_cat">Current category:</label>--%>
                            <%--<ul class="tags" id="select_cat">--%>
                                <%--<c:forEach items="${newsObject.categorys}" var="category">--%>
                                    <%--<li><a class="tag" href="#">${category.name}</a></li>--%>
                                <%--</c:forEach>--%>
                            <%--</ul>--%>
                        <%--</div>--%>

                        <div class="form-group">
                            <label for="cat">Current categories(select category max 5):</label>
                            <form:select class="selectpicker" multiple="true" id="cat" path="categorys"
                                         data-max-options="5">
                                <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                            </form:select>
                        </div>
                        <hr>
                        <div class="div_margin_top">
                            <div class="container-fluid">
                                <div class="pull-right">
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-default btn-lg">
                                            <span class="glyphicon glyphicon-save"></span> Save
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-4 side-bar">
                    <jsp:include page="include/menu.jsp"/>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!-- content-section-end-here -->

<%--Footer--%>
<jsp:include page="include/footer.jsp"/>

