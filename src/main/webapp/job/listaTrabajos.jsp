<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 6/7/2024
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="org.example.lab7crud.componentes.Beans.Jobs"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Jobs> listaTrabajos = (ArrayList<Jobs>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Empleos</title>
    <style>
        table {
            width: 75%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Lista de Empleados</h1>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Titulo de trabajo</th>
        <th>Salario minimo</th>
        <th>Salario maximo</th>
        <th>Acciones</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <% for (Jobs job : listaTrabajos) { %>
    <tbody>
    <tr>
        <td><%=job.getJob_id()%></td>
        <td><%=job.getJob_title()%></td>
        <td><%=job.getMin_salary()%></td>
        <td><%=job.getMax_salary()%></td>
        <td>
            <button onclick="editarTrabajo('<%= job.getJob_id() %>')">Editar</button>
        </td>
        <td><button onclick="borrarTrabajo('<%= job.getJob_id() %>')">Borrar</button></td>
    </tr>
    </tbody>
    <% } %>
</table>
<br>
<button onclick="window.location.href='/create-employee'">Crear Nuevo Empleado</button>

<script>
    function editarTrabajo(id) {
        window.location.href = `/edit-job?id=${id}`;
    }

    function borrarTrabajo(id) {
        if(confirm('¿Está seguro que desea borrar este trabajo?')) {
            // Lógica para borrar trabajo
            window.location.href = `/delete-job?id=${id}`;
        }
    }
</script>
</body>
</html>

