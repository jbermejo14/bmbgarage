<%@ page import="org.bmbgarage.dao.Database" %>
<%@ page import="org.bmbgarage.dao.CarDao" %>
<%@ page import="org.bmbgarage.domain.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>

<body>
    <main>
        <%
          int id = Integer.parseInt(request.getParameter("id"));
          Database.connect();
          Car car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(id));
        %>
        <div class="container">
            <div class="card text-center">
                <div class="card-header">Car</div>
                <div class="card-body">
                    <img src="../bmbpictures/<%= car.getImage()%>"/>
                    <h5 class="card-title"><%= car.getBrand() %></h5>
                    <p class="card-text"><%= car.getCarmodel() %></p>
                    <p class="card-text"><%= car.getPrice() %></p>
                    <%
                        if (role.equals("admin")) {
                    %>
                        <a href="removecar?id=<%= car.getId()%>" class="btn btn-primary">Delete Car</a>
                    <%
                       }
                    %>

                </div>
            </div>
        </div>
        <button class="btn btn-secondary" onclick="pageBack()">Back</button>
    </main>
    <script>
            function pageBack() {
                window.history.back();
            }
        </script>
</body>