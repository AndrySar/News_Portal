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
            <li><a href="index.html">Home</a></li>
            <li class="active">Single Page</li>
        </ol>
        <div class="single-page">
            <div class="col-md-8 content-left single-post">
                <div class="blog-posts">
                    <h3 class="post">Donald Trump News - Donald Trump Special Reports - Summarizes the latest news about
                        Donald Trump</h3>

                    <div class="last-article">
                        <p class="artext">With Cameron immediately renewing his pledge to hold a referendum on British
                            membership of the European Union, the result throws up questions about Britain’s
                            constitutional future. For now, the surprise victory was welcomed by markets, with stocks
                            and the pound rallying as it became clear Cameron had defied forecasts of a hung parliament
                            to easily defeat Ed Miliband’s Labour Party and govern alone.</p>

                        <p class="artext">The premier was meeting with Queen Elizabeth II at Buckingham Palace as the
                            Conservatives reached the 326-seat threshold that allows them
                            to ditch their Liberal Democrat coalition partners and govern alone in the 650-seat
                            Parliament.</p>
                        <ul class="tags">
                            <li><a class="tag" href="#">Markets</a></li>
                            <li><a href="#">Business</a></li>
                            <li><a href="#">Sport</a></li>
                            <li><a href="#">Special reports</a></li>
                            <li><a href="#">Culture</a></li>
                        </ul>
                        <div class="clearfix"></div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="container-fluid">
                    <div class="pull-right" >
                        <button type="button" class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-edit"></span> Edit
                        </button>
                        <button type="button" class="btn btn-default btn-lg">
                            <span class="glyphicon glyphicon-trash"></span> Delete
                        </button>
                    </div>
                    <div class="pull-left" >
                        <div class="w3-clear nextprev">
                            <a class="w3-left w3-btn" href="#">❮ All News</a>
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
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<%--Footer--%>
<jsp:include page="include/footer.jsp"/>
