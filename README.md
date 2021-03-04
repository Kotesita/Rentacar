# Ejercicio 2

### 1. 
```SELECT SUM(CASE WHEN salary<3500 then 1 else 0 end) AS SegmentoA, SUM(CASE WHEN salary between 3500 AND 7999 then 1 else 0 end) AS SegmentoB, SUM(CASE WHEN salary>=8000 then 1 else 0 end) AS SegmentoC FROM employees;```
### 2. 
```SELECT SUM(CASE WHEN salary<3500 then 1 else 0 end) AS SegmentoA, SUM(CASE WHEN salary between 3500 AND 7999 then 1 else 0 end) AS SegmentoB, SUM(CASE WHEN salary>=8000 then 1 else 0 end) AS SegmentoC FROM employees AS emp INNER JOIN departments AS dep ON dep.department_id=emp.department_id;```
### 3. 
```SELECT dep.department_id, dep.department_name AS departamento, ANY_VALUE(first_name) AS nombre, ANY_VALUE(last_name) AS apellido, ANY_VALUE(email) AS email, ANY_VALUE(phone_number) AS telefono, MAX(salary) AS salario_maximo FROM employees AS emp INNER JOIN departments AS dep ON dep.department_id=emp.department_id GROUP BY dep.department_id ORDER BY dep.department_id;```
### 4. 
```SELECT first_name AS nombre, last_name AS apellido, email, phone_number AS telefono, hire_date AS fecha_contrato FROM employees AS emp INNER JOIN jobs ON emp.job_id=jobs.job_id WHERE TIMESTAMPDIFF(year,hire_date,now())>=15 AND job_title LIKE '%manager%';```
### 5. 
```SELECT dep.department_name, AVG(salary) AS sueldo_promedio, count(*) AS cantidad_empleados FROM employees AS emp INNER JOIN departments AS dep ON emp.department_id=dep.department_id GROUP BY dep.department_id HAVING COUNT(employee_id)>10; ```
### 6. 
```SELECT COUNT(employee_id) AS cantidad_empleados, AVG(salary) AS salario_promedio, MIN(salary) AS salario_minimo, MAX(salary) AS salario_maximo, AVG(TIMESTAMPDIFF(year,hire_date,now())) AS promedio_anios_antiguedad, country_name AS pais FROM employees AS emp INNER JOIN departments AS dep ON emp.department_id=dep.department_id INNER JOIN locations AS loc ON dep.location_id=loc.location_id INNER JOIN countries AS cou ON loc.country_id=cou.country_id GROUP BY cou.country_id;```

# Ejercicio 1 y 3

Para el desarrollo de estos problemas se trabajó con Sprint Tool Suite. Para iniciar se creó un proyecto "Spring Starter".
En ambos proyectos se debe crear una base de datos con un nombre identificativo y configurar la base de datos en el archivo ```application.properties``` ubicado en "src/main/resources". spring.datasource.url=jdbc:mysql://localhost:3306/myhotel


```
spring.datasource.url=jdbc:mysql://{direccion_ip_mysql}/{nombre_bdd}
spring.datasource.username={user}
spring.datasource.password={password}
```

Automoviles: 
{ "id":0,
  "num_puertas":0,
  "cap_pasajeros":0,
  "cap_maleta":0,
  "cap_toneladas":0,
  "num_ejes":0,
  "vehiculos":[],
  "tipo":""
}

Vehiculos:
{ "id":0,
  "patente":"",
  "marca":"",
  "modelo":"",
  "anio":0,
  "kilometros":0.0
  "cilindrada:0.0
  "automovil":"",
  "mantenciones":[]
  }
  
Mantenciones:
{"id":0,
  "fecha_mantencion":,
  "valor":0.0,
  "descripcion":""
  "vehiculo":""
}

## Para el proyecto Rentacar: Endpoints

* GET: /auto : Obtiene todos los automóviles creados.
* POST: /auto: Crea uno o varios automoviles.
* GET: /auto/{id}: Obtiene información del automóvil de id específica.
* PUT: /auto/{id}: Modifica el auto de id específica
* DELETE: /auto/{id}: Elimina el auto de id específica
* GET: /mantencion : Obtiene todos las mantenciones realizadas.
* POST: /mantencoon: Crea uno o varios mantenciones.
* GET: /mantencion/{id}: Obtiene información de la mantención de id específica.
* PUT: /mantencion/{id}: Modifica la mantención de id específica
* DELETE: /mantencion/{id}: Elimina la mantención de id específica
* GET: /vehiculo : Obtiene todos los vehiculos creados.
* POST: /vehiculo: Crea uno o varios vehiculos.
* GET: /vehiculo/{id}: Obtiene información del vehiculo de id específica.
* PUT: /vehiculo/{id}: Modifica el vehiculo de id específica
* DELETE: /vehiculo/{id}: Elimina el vehiculo de id específica

## Para el proyecto Empresa: Endpoints

* GET: /empleadosGrupo: resuelve la consulta detallada el punto 1 del ejercicio 2.
* GET: /departamentosGrupo: resuelve la consulta detallada el punto 2 del ejercicio 2.
* GET: /empleadosAntiguos: resuelve la consulta detallada el punto 3 del ejercicio 2.
