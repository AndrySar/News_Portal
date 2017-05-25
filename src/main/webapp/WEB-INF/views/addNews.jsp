<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.05.17
  Time: 8:29
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
<div class="main-body">
    <div class="wrap">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/news">News</a></li>
            <li class="active">Add News</li>
        </ol>
        <div class="single-page">
                    <div class="col-md-8 content-left single-post">
                        <div class="head-articles">
                            <header>
                                <h3 class="title-head">News</h3>
                            </header>
                        </div>
                            <%--form to add news--%>
                            <form:form action="${pageContext.request.contextPath}/news/add" method="post" modelAttribute="newsObject" accept-charset="UTF-8">
                                <div class="form-group">
                                    <label for="title" class="control-label">Title:</label>
                                    <input type="text" class="form-control" name="name" id="title" placeholder="News Title" required>
                                </div>
                                <div class="form-group">
                                    <label for="description">Short description:</label>
                                    <textarea class="form-control" name="description" id="description" rows="3" required></textarea>
                                </div>

                                <div class="form-group">
                                    <label for="content">Content:</label>
                                    <textarea class="form-control" name="content" id="content" rows="5" required></textarea>
                                </div>

                                <div class="form-group">
                                    <label for="cat">Category(max 5):</label>
                                    <form:select class="selectpicker" multiple="true" id="cat" path="categorys" data-max-options="5">
                                        <form:options items="${categories}" itemValue="id" itemLabel="name"/>
                                    </form:select>
                                </div>

                                <div class="clearfix"></div>

                                <div class="container-fluid">
                                    <div class="pull-right" >
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-default btn-lg">
                                                <span class="glyphicon glyphicon-save"></span> Add
                                            </button>
                                        </div>
                                    </div>
                                </div>

                            </form:form>
                            <div class="clearfix"></div>
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
            <div class="clearfix"></div>
        </div>
    </div>
</div>


<%--Footer--%>
<jsp:include page="include/footer.jsp"/>
