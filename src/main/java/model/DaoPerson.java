//Cristopher Soto Ventura 4B - DSM
package model;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoPerson {
    public void registrarPerson(BeanPerson person) {
        try
                (Connection con = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement(
                         "INSERT INTO persons (curp, rfc, name, first_lastname, second_lastname, fecha_nac) values (?,?,?,?,?,?)");
                ) {
            pstm.setString(1, person.getCurp());
            pstm.setString(2, person.getRfc());
            pstm.setString(3, person.getName());
            pstm.setString(4, person.getFirst_lastname());
            pstm.setString(5, person.getSecond_lastname());
            pstm.setString(6, person.getFecha_nac());

           pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultarPersona(BeanPerson person) {
        try
                (Connection con = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement(
                         "SELECT * FROM persons WHERE curp=?");
                ) {
            pstm.setString(1, person.getCurp());

            ResultSet res = pstm.executeQuery();

            while (res.next()){
                person.setCurp(res.getString("curp"));
                person.setRfc(res.getString("rfc"));
                person.setName(res.getString("name"));
                person.setFirst_lastname(res.getString("first_lastname"));
                person.setSecond_lastname(res.getString("second_lastname"));
                person.setFecha_nac(res.getString("fecha_nac"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersona(BeanPerson person) {
        try
                (Connection con = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement(
                         "DELETE FROM persons WHERE curp = ?");
                ) {
            pstm.setString(1, person.getCurp());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BeanPerson> persons() {
        List<BeanPerson> listPerson = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persons");

            while (rs.next()){
                BeanPerson person = new BeanPerson();
                person.setCurp(rs.getString("curp"));
                person.setRfc(rs.getString("rfc"));
                person.setName(rs.getString("name"));
                person.setFirst_lastname(rs.getString("first_lastname"));
                person.setSecond_lastname(rs.getString("second_lastname"));
                person.setFecha_nac(rs.getString("fecha_nac"));

                listPerson.add(person);
            }

            rs.close();
            connection.close();
            statement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return listPerson;
    }
}