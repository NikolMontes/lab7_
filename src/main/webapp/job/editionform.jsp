<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 6/7/2024
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear-Nuevo-Empleado/Editar</title>
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
        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Crear Nuevo Empleado</h1>
<form action="/home?action=create" method="post">
    <label for="employee_id">ID del Empleado:</label>
    <input type="text" id="employee_id" name="employee_id" required>

    <label for="first_name">Nombre:</label>
    <input type="text" id="first_name" name="first_name" required>

    <label for="last_name">Apellido:</label>
    <input type="text" id="last_name" name="last_name" required>

    <label for="email">Correo:</label>
    <input type="email" id="email" name="email" required>

    <label for="phone_number">Número Telefónico:</label>
    <input type="text" id="phone_number" name="phone_number" required>

    <label for="hire_date">Fecha de Contratación:</label>
    <input type="date" id="hire_date" name="hire_date" required>

    <label for="salary">Salario:</label>
    <input type="number" step="0.01" id="salary" name="salary" required>

    <label for="commission_pct">Porcentaje de Comisión:</label>
    <input type="number" step="0.01" id="commission_pct" name="commission_pct" required>



    <label for="job_title">Título del Puesto de Trabajo:</label>
    <input type="text" id="job_title" name="job_title" required>

    <button type="submit">Crear Empleado</button>
</form>
</body>
</html>

