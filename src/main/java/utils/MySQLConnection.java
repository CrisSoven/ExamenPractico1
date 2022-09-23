//Cristopher Soto Ventura 4B - DSM
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

//CREATE TABLE `xmlrpc`.`persons` (
//  `curp` VARCHAR(18) NOT NULL,
//  `rfc` VARCHAR(13) NOT NULL,
//  `name` VARCHAR(45) NOT NULL,
//  `first_lastname` VARCHAR(45) NOT NULL,
//   `second_lastname` VARCHAR(45),
//  `fecha_nac` DATE NULL,
//  PRIMARY KEY (`curp`),
//  UNIQUE INDEX `curp_UNIQUE` (`curp` ASC) VISIBLE,
//  UNIQUE INDEX `rfc_UNIQUE` (`rfc` ASC) VISIBLE);

public class MySQLConnection {
    public static Connection getConnection(){

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/xmlrpc","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        try {
            Connection conexion = MySQLConnection.getConnection();
            if (conexion != null) {
                System.out.println("Conectado");
                conexion.close();
            }
            else{
                System.out.println("No conectado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
