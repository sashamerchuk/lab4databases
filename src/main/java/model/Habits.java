package model;

import controller.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Habits {
    public void createHabits(Integer idhabits,String habits){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLINSERT = "INSERT INTO `hospitallab4db`.`habits` (idhabits, habits)"
                    + "VALUES(?,?)";
            ps = connection.prepareStatement(SQLINSERT);
            ps.setInt(1,idhabits);
            ps.setString(2,habits);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("Eror");
            System.out.println(e.getMessage());
        }
    }
    public  void readHabits(){
        try (Connection connection = DBConnection.get_connection()){
            PreparedStatement pr = null;
            ResultSet res = null;
            String SQLREAD  = "select * from habits";
            pr = connection.prepareStatement(SQLREAD);
            System.out.println(pr);
            res = pr.executeQuery();
            while(res.next()){
                System.out.println("id habits  - "  + res.getInt("idhabits"));
                System.out.println("habits - " + res.getString("habits"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateHabits(Integer idhabits,String habits){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLUPDATE = "UPDATE `habits` SET `idhabits`=?," +
                    "`habits`=? WHERE `idhabits`=?";
            ps = connection.prepareStatement(SQLUPDATE);
            ps.setInt(1,idhabits);
            ps.setString(2,habits);
            ps.setInt(3,idhabits);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteHabits(Integer idhabits){
        try(Connection connection=DBConnection.get_connection()){
            PreparedStatement ps =null;
            String SQLDELETE = "DELETE FROM `habits` WHERE idhabits=?";
            ps = connection.prepareStatement(SQLDELETE);
            ps.setInt(1,idhabits);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
