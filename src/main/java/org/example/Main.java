package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            //Antes de comenzar debemos de añadir la libreria de derby.jar

            //Cargamos el driver
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            //Establecemos la conexion con la base de datos, donde debe estar abierto Docker que es quien la contiene
            Connection conexion = DriverManager.getConnection("jdbc:hsqldb:C:\\HSQLDB");

            //Preparamos la consulta que deseamos realizar
            Statement sentencia = conexion.createStatement();
            String consulta = "SELECT * FROM empleados WHERE dept_no='10';";
            ResultSet resultado = sentencia.executeQuery(consulta);

            //Recorremos el resultado obtenido de la consulta mediante un bucle mientras que haya registros
            while (resultado.next()) {
                System.out.println("Apellido: " + resultado.getString(1));
                System.out.println("Oficio: " + resultado.getString(2));
                System.out.println("Salario: " + resultado.getInt(3));
            }

            //Cerramos los recursos utilizados
            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }
}