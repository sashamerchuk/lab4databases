package model;

import controller.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient {
    public void createPatient(Integer id_patient,String name,Integer age,
    String work, String email,Integer phone,String lifestyle,Integer bad_habits){
        try(Connection connection = DBConnection.get_connection()){
            System.out.println("Error");
            PreparedStatement ps = null;
            String SQLINSERT = "INSERT INTO `hospitallab4db`.`patient` (" +
                    "id_patient,name,age,work,email,phone,lifestyle,bad_habits)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(SQLINSERT);
            ps.setInt(1,id_patient);
            ps.setString(2,name);
            ps.setInt(3,age);
            ps.setString(4,work);
            ps.setString(5,email);
            ps.setInt(6,phone);
            ps.setString(7,lifestyle);
            ps.setInt(8,bad_habits);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  void readPatient(){
        try (Connection connection = DBConnection.get_connection()){
            PreparedStatement pr = null;
            ResultSet res = null;
            String SQLREAD  = "select * from patient";
            pr = connection.prepareStatement(SQLREAD);
            System.out.println(pr);
            res = pr.executeQuery();
            while(res.next()){
                System.out.println("id patient -  "  + res.getInt("id_patient"));
                System.out.println("name - " + res.getString("name"));
                System.out.println("age - " + res.getInt("age"));
                System.out.println("work - " + res.getString("work"));
                System.out.println("email - " + res.getString("email"));
                System.out.println("phone - " + res.getInt("phone"));
                System.out.println("lifestyle - " + res.getString("lifestyle"));
                System.out.println("bad_habits" + res.getInt("bad_habits"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updatePatient(Integer id_patient,String name,Integer age,
                              String work, String email,Integer phone,String lifestyle,Integer bad_habits){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLUPDATE = "UPDATE `patient` SET `id_patient`=?," +
                    "`name`=?,age=?,work=?,email=?,phone=?,lifestyle=?," +
                    "bad_habits=? WHERE `id_patient`=?";
            ps = connection.prepareStatement(SQLUPDATE);
            ps.setInt(1,id_patient);
            ps.setString(2,name);
            ps.setInt(3,age);
            ps.setString(4,work);
            ps.setString(5,email);
            ps.setInt(6,phone);
            ps.setString(7,lifestyle);
            ps.setInt(8,bad_habits);
            ps.setInt(9,id_patient);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deletePatient(Integer id_patient){
        try(Connection connection=DBConnection.get_connection()){
            PreparedStatement ps =null;
            String SQLDELETE = "DELETE FROM `patient` WHERE id_patient=?";
            ps = connection.prepareStatement(SQLDELETE);
            ps.setInt(1,id_patient);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
