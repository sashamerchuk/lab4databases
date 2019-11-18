package model;

import controller.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Analysis {
    public void createAnalysis(Integer idanalysis,String analysis_description,Integer patient_id_patient){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLINSERT = "INSERT INTO `hospitallab4db`.`analysis` (idanalysis,analysis_description,patient_id_patient)"
                    + "VALUES(?,?,?)";
            ps = connection.prepareStatement(SQLINSERT);
            ps.setInt(1,idanalysis);
            ps.setString(2,analysis_description);
            ps.setInt(3,patient_id_patient);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  void readAnalysis(){
        try (Connection connection = DBConnection.get_connection()){
            PreparedStatement pr = null;
            ResultSet res = null;
            String SQLREAD  = "select * from analysis";
            pr = connection.prepareStatement(SQLREAD);
            System.out.println(pr);
            res = pr.executeQuery();
            while(res.next()){
                System.out.println("id analysis  - "  + res.getInt("idanalysis"));
                System.out.println("analysis description - " + res.getString("analysis_description"));
                System.out.println("patient id  - " + res.getInt("patient_id_patient"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateAnalysis(Integer idanalysis,String analysis_description,Integer patient_id_patient){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLUPDATE = "UPDATE `analysis` SET `idanalysis`=?," +
                    "`analysis_description`=?,`patient_id_patient`=? WHERE `idanalysis`=? AND `patient_id_patient`=?";
            ps = connection.prepareStatement(SQLUPDATE);
            ps.setInt(1,idanalysis);
            ps.setString(2,analysis_description);
            ps.setInt(3,patient_id_patient);
            ps.setInt(4,idanalysis);
            ps.setInt(5,patient_id_patient);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteAnalysis(Integer idanalysis){
        try(Connection connection=DBConnection.get_connection()){
            PreparedStatement ps =null;
            String SQLDELETE = "DELETE FROM `analysis` WHERE idanalysis=?";
            ps = connection.prepareStatement(SQLDELETE);
            ps.setInt(1,idanalysis);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
