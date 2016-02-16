<%-- 
    Document   : second
    Created on : Feb 10, 2016, 9:36:43 AM
    Author     : Ohjelmistokehitys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
        <link rel='stylesheet' href='@routes.WebJarAssets.at(WebJarAssets.locate("css/bootstrap.min.css"))'>
        <title>Teacher</title>
    </head>
    <body>
            <%@include file="header.jsp" %>
            <h1>Add new teacher information</h1>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <form:form action="/admin/teacher" method="POST" modelAttribute="teacher">
                            <form:label path="">Name:</form:label><br/>
                            <form:input class="form-control" path="TName"></form:input><br/>

                            <form:label path="">Email:</form:label><br/>
                            <form:input class="form-control" path="email"></form:input><br/>

                            <form:label path="">Phone:</form:label><br/>
                            <form:input class="form-control" path="phone"></form:input><br/>

                            <form:label path="">Subject:</form:label><br/>
                            <form:input class="form-control" path="TSubject"></form:input><br/>

                            <input class="btn btn-warning" type="submit" value="Save teacher"/>


                        </form:form>
                    </div>
                    <div class="col-md-8">
                <!-- <p>${save_info}</p> -->
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Subject</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="teach" items="${teachers}">
                            <tr>
                                <td>${teach.getTName()}</td>
                                <td>${teach.getEmail()}</td>
                                <td>${teach.getPhone()}</td>
                                <td>${teach.getTSubject()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div> 
            </div> <!-- row -->
        </div> <!--container -->
    </body>
</html>
