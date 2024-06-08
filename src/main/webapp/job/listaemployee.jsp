<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 6/7/2024
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="org.example.lab7crud.componentes.Beans.Employees"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Employees> listaTrabajadores = (ArrayList<Employees>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Lista de Empleados</title>
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
        <th>Nombre</th>
        <th>numero telefonico</th>
        <th>correo</th>
        <th>Puesto de trabajo</th>
        <th>Dia de contratacion</th>
        <th>Salario</th>
        <th>.</th>
        <th>.</th>
    </tr>
    </thead>
    <% for (Employees employees : listaTrabajadores) { %>
    <tbody>
    <!-- Suponiendo que esta sección se llenará dinámicamente -->
    <!-- Ejemplo de fila de empleado -->
    <tr>
        <td><%=employees.getEmployee_id()%></td>
        <td><%=employees.getFirst_name()%></td>
        <td><%=employees.getPhone_number()%></td>
        <td><%=employees.getEmail()%></td>
        <td>null</td>
        <td><%=employees.getHire_date()%></td>
        <td><%=employees.getSalary()%></td>
        <td>
            <button onclick="editarEmpleado('<%= employees.getEmployee_id() %>')">Editar</button>
        </td>
        <td><button onclick="borrarEmpleado('<%= employees.getEmployee_id() %>')">Borrar</button></td>
    </tr>

    </tbody>
    <% } %>
</table>
<br>
<button onclick="window.location.href='/create-employee'">Crear Nuevo Empleado</button>

<script>
    function editarEmpleado(id) {
        window.location.href = `/edit-job?id=${id}`;
    }

    function borrarEmpleado(id) {
        if(confirm('¿Está seguro que desea borrar este trabajo?')) {
            // Lógica para borrar trabajo
            window.location.href = `/delete-job?id=${id}`;
        }
    }
</script>
</body>
</html>
