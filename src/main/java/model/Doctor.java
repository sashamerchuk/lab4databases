package model;

import controller.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    public void createDoctor(Integer iddoctor,Integer type_doctor,String full_name,
    String time_of_reception,String email,Integer phone,Integer experience,String license,
                             Integer type_doctor_idtype_doctor){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLINSERT = "INSERT INTO `hospitallab4db`.`doctor` " +
                    "(iddoctor,type_doctor,full_name,time_of_reception,email,phone,experience,license,type_doctor_idtype_doctor)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(SQLINSERT);
            ps.setInt(1,iddoctor);
            ps.setInt(2,type_doctor);
            ps.setString(3,full_name);
            ps.setString(4,time_of_reception);
            ps.setString(5,email);
            ps.setInt(6,phone);
            ps.setInt(7,experience);
            ps.setString(8,license);
            ps.setInt(9,type_doctor_idtype_doctor);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  void readDoctor(){
        try (Connection connection = DBConnection.get_connection()){
            PreparedStatement pr = null;
            ResultSet res = null;
            String SQLREAD  = "select * from doctor";
            pr = connection.prepareStatement(SQLREAD);
            System.out.println(pr);
            res = pr.executeQuery();
            while(res.next()){
                System.out.println("iddoctor - "  + res.getInt("iddoctor"));
                System.out.println("type_doctor - " + res.getInt("type_doctor"));
                System.out.println("full_name - " + res.getString("full_name"));
                System.out.println("time_of_reception - " + res.getString("time_of_reception"));
                System.out.println("email - " + res.getString("email"));
                System.out.println("phone - " + res.getInt("phone"));
                System.out.println("experience - " + res.getInt("experience"));
                System.out.println("license - " + res.getString("license"));
                System.out.println("type_doctor_idtype_doctor - " + res.getInt("type_doctor_idtype_doctor"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateDoctor(Integer iddoctor,Integer type_doctor,String full_name,
                             String time_of_reception,String email,Integer phone,Integer experience,String license,
                             Integer type_doctor_idtype_doctor){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLUPDATE = "UPDATE `doctor` SET iddoctor=?," +
                    "type_doctor=?,full_name=?,time_of_reception=?," +
                    "email=?,phone=?,experience=?,license=?,type_doctor_idtype_doctor=? WHERE iddoctor=?";
            ps = connection.prepareStatement(SQLUPDATE);
            ps.setInt(1,iddoctor);
            ps.setInt(2,type_doctor);
            ps.setString(3,full_name);
            ps.setString(4,time_of_reception);
            ps.setString(5,email);
            ps.setInt(6,phone);
            ps.setInt(7,experience);
            ps.setString(8,license);
            ps.setInt(9,type_doctor_idtype_doctor);
            ps.setInt(10,iddoctor);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteDoctor(Integer iddoctor){
        try(Connection connection=DBConnection.get_connection()){
            PreparedStatement ps =null;
            String SQLDELETE = "DELETE FROM `doctor` WHERE iddoctor=?";
            ps = connection.prepareStatement(SQLDELETE);
            ps.setInt(1,iddoctor);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
