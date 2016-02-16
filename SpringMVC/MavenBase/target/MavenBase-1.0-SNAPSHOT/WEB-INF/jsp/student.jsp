<%-- 
    Document   : student
    Created on : Feb 16, 2016, 1:53:21 PM
    Author     : Ohjelmistokehitys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                  <%@include file="header.jsp" %>
            <h1>Add new student information</h1>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <form:form action="/admin/student" method="POST" modelAttribute="students">
                            <form:label path="">Name:</form:label><br/>
                            <form:input class="form-control" path="SName"></form:input><br/>
                            
                            <form:label path="">Address:</form:label><br/>
                            <form:input class="form-control" path="Address"></form:input><br/>

                            <form:label path="">Email:</form:label><br/>
                            <form:input class="form-control" path="email"></form:input><br/>

                            <form:label path="">Phone:</form:label><br/>
                            <form:input class="form-control" path="phone"></form:input><br/>

                         

                            <input class="btn btn-warning" type="submit" value="Save student"/>


                        </form:form>
                    </div>
                    <div class="col-md-8">
                <!-- <p>${save_info}</p> -->
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone</th>    
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.getSName()}</td>
                                <td>${student.getAddress()}</td>
                                <td>${student.getEmail()}</td>
                                <td>${student.getPhone()}</td>
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div> 
            </div> <!-- row -->
        </div> <!--container -->
    </body>
</html>
