package model;

import controller.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeDoctor {
    public void createAnalysis(Integer idtype_doctor,String type_doctor){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLINSERT = "INSERT INTO `hospitallab4db`.`type_doctor` (idtype_doctor, type_doctor)"
                    + "VALUES(?,?)";
            ps = connection.prepareStatement(SQLINSERT);
            ps.setInt(1,idtype_doctor);
            ps.setString(2,type_doctor);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  void readTypeDoctor(){
        try (Connection connection = DBConnection.get_connection()){
            PreparedStatement pr = null;
            ResultSet res = null;
            String SQLREAD  = "select * from type_doctor";
            pr = connection.prepareStatement(SQLREAD);
            System.out.println(pr);
            res = pr.executeQuery();
            while(res.next()){
                System.out.println("idtype_doctor -  "  + res.getInt("idtype_doctor"));
                System.out.println("type_doctor - " + res.getString("type_doctor"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateHabits(Integer idtype_doctor,String type_doctor){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLUPDATE = "UPDATE `type_doctor` SET `idtype_doctor`=?," +
                    "`type_doctor`=? WHERE `idtype_doctor`=?";
            ps = connection.prepareStatement(SQLUPDATE);
            ps.setInt(1,idtype_doctor);
            ps.setString(2,type_doctor);
            ps.setInt(3,idtype_doctor);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteTypeDoctor(Integer idtype_doctor){
        try(Connection connection=DBConnection.get_connection()){
            PreparedStatement ps =null;
            String SQLDELETE = "DELETE FROM `type_doctor` WHERE idtype_doctor=?";
            ps = connection.prepareStatement(SQLDELETE);
            ps.setInt(1,idtype_doctor);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
