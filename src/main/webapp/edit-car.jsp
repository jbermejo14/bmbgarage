<%@ page import="org.bmbgarage.dao.Database" %>
<%@ page import="org.bmbgarage.dao.CarDao" %>
<%@ page import="org.bmbgarage.domain.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>
<style>
    .btn-black{
        background-color: #000 !important;
        color: #fff;
    }
</style>
<script>
    $(document).ready(function () {
        $("#edit-button").click(function (event) {
            event.preventDefault();
            const form = $("#edit-form")[0];
            const data = new FormData(form);

            $("#edit-button").prop("disabled", true);

            $.ajax({
                type: "POST",
                enctype: "multipart/form-data",
                url: "edit-car",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $("#result").html(data);
                    $("#name").value("");
                    $("#edit-button").prop("disabled", false);
                },
                error: function (error) {
                    $("#result").html(error.responseText);
                    $("#edit-button").prop("disabled", false);
                }
            });
        });
    });
</script>

<%
    if (!role.equals("admin")) {
        response.sendRedirect("/bmbgarage");
    }
    int id;
    Car car = null;
    if (request.getParameter("id") == null) {
        id = 0;
    } else {
        id = Integer.parseInt(request.getParameter("id"));
        Database.connect();
        car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(id));
    }
%>

<main>
    <section class="py-5 container">
        <h1>Register New Car</h1>
        <form class="row g-3 needs-validation" method="post" enctype="multipart/form-data" id="edit-form">
            <div class="mb-3">
                <label for="brand" class="form-label">Brand</label>
                <input type="text" name="brand" class="form-control" id="brand" value="Brand">
            </div>
            <div class="mb-3">
                <label for="carmodel" class="form-label">Model</label>
                <input type="text" name="carmodel" class="form-control" id="carmodel" value="Model">
            </div>
            <div class="mb-3">
                <label for="licenseplate" class="form-label">License Plate</label>
                <input type="text" name="licenseplate" class="form-control" id="licenseplate"
                    value="XXXX-XXX">
            </div>
            <div class="mb-3">
                <label for="date" class="form-label">Date</label>
                <input type="number" name="date" class="form-control" id="date">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <input type="number" name="price" class="form-control" id="price">
            </div>
            <div class="col-12">
                <button class="btn btn-black w-100" id="edit-button" type="submit">Send</button>
            </div>
        </form>
        <div id="result"></div>
    </section>
</main>

