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
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 75%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 3px rgba(0, 0, 0, 0.1);
            align-items: center;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        button {
            background-color: white;
            color: #007bff;
            border: 2px solid #007bff;
            border-radius: 5px;
            padding: 5px 10px;
            cursor: pointer;
            transition: background-color 0.3s, color 0.3s;
        }
        button:hover {
            background-color: #007bff;
            color: white;
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
        <th>Numero Telefonico</th>
        <th>Correo</th>
        <th>Puesto de Trabajo</th>
        <th>Dia de Contratacion</th>
        <th>Salario</th>
        <th>Editar</th>
        <th>Borrar</th>
    </tr>
    </thead>
    <tbody>
    <% for (Employees employees : listaTrabajadores) { %>
    <tr>
        <td><%=employees.getEmployee_id()%></td>
        <td><%=employees.getFullNameEmployee()%></td>
        <td><%=employees.getPhone_number()%></td>
        <td><%=employees.getEmail()%></td>
        <td><%=employees.getJobTitle()%></td> <!-- Assuming this gets the job title -->
        <td><%=employees.getHire_date()%></td>
        <td><%=employees.getSalary()%></td>
        <td>
            <form action="<%=request.getContextPath()%>/home" method="get">
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="employeeId" value="<%=employees.getEmployee_id()%>">
                <button type="submit">Editar</button>
            </form>
        </td>
        <td>
            <button onclick="borrarEmpleado('<%= employees.getEmployee_id() %>')">Borrar</button>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<br>
<button onclick="window.location.href='/home?action=new'">Crear Nuevo Empleado</button>

<script>
    function editarEmpleado(id) {
        window.location.href = `/home?action=edit&employeeId=${id}`;
    }

    function borrarEmpleado(id) {
        if(confirm('¿Está seguro que desea borrar este empleado?')) {
            window.location.href = `/home?action=del&employeeId=${id}`;
        }
    }
</script>
</body>
</html>
