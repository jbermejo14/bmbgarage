<%@ page import="org.bmbgarage.dao.Database" %>
<%@ page import="org.bmbgarage.dao.CarDao" %>
<%@ page import="org.bmbgarage.domain.Car" %>
<%@ page import="org.bmbgarage.domain.Client" %>
<%@ page import="org.bmbgarage.dao.ClientDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>
<style>
    .btn-black{
        background-color: #000 !important;
        color: #fff;
    }
</style>
<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    }
    Database.connect();
    Client client = Database.jdbi.withExtension(ClientDao.class, dao -> dao.getClient(id));
%>
<main>
    <section class="py-5 text-center container">
        <h1>Your Profile:</h1>
    </section>
    <div class="container">
        <h5 class="card-title">Username: <%= client.getUsername() %></h5>
        <h6 class="card-text">Mobile Number: <%= client.getPhonenumber() %></h6>
        <h6 class="card-text">Email: <%= client.getEmail() %></h6>
        <button class="btn btn-black"><a href="edit-user.jsp" class="nav-link px-2 btn btn-black">Edit Profile</a></button>
    </div>
</main>