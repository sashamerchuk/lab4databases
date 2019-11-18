package model;

import controller.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;

public class Diagnosis {
    public void createDiagnosis(Integer iddiagnosis,String description_diagnosis,Integer patient_id_patient,
    String data_diagnosis){
        try (Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLINSERT = "INSERT INTO `hospitallab4db`.`diagnosis`(iddiagnosis,description_diagnosis,patient_id_patient,data_diagnosis)" +
                    "VALUES(?,?,?,?)";
            ps=connection.prepareStatement(SQLINSERT);
            ps.setInt(1,iddiagnosis);
            ps.setString(2,description_diagnosis);
            ps.setInt(3,patient_id_patient);
            ps.setString(4,data_diagnosis);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void readDiagnosis(){
        try (Connection connection = DBConnection.get_connection()){
            PreparedStatement pr = null;
            ResultSet res = null;
            String SQLREAD  = "select * from diagnosis";
            pr = connection.prepareStatement(SQLREAD);
            System.out.println(pr);
            res = pr.executeQuery();
            while(res.next()){
                System.out.println("iddiagnosis -  "  + res.getInt("iddiagnosis"));
                System.out.println("description_diagnosis - " + res.getString("description_diagnosis"));
                System.out.println("patient id  - " + res.getInt("patient_id_patient"));
                System.out.println("data_diagnosis -  " + res.getString("data_diagnosis"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateDiagnosis(Integer iddiagnosis,String description_diagnosis,Integer patient_id_patient,
                                String data_diagnosis){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLUPDATE = "UPDATE `diagnosis` SET `iddiagnosis`=?," +
                    "`description_diagnosis`=?,`patient_id_patient`=?,`data_diagnosis`=? WHERE `iddiagnosis`=?";
            ps = connection.prepareStatement(SQLUPDATE);
            ps.setInt(1,iddiagnosis);
            ps.setString(2,description_diagnosis);
            ps.setInt(3,patient_id_patient);
            ps.setString(4,data_diagnosis);
            ps.setInt(5,iddiagnosis);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteDiagnosis(Integer iddiagnosis){
        try(Connection connection=DBConnection.get_connection()){
            PreparedStatement ps =null;
            String SQLDELETE = "DELETE FROM `diagnosis` WHERE iddiagnosis=?";
            ps = connection.prepareStatement(SQLDELETE);
            ps.setInt(1,iddiagnosis);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
