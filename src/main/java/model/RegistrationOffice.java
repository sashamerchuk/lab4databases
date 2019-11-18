package model;

import controller.connection.DBConnection;

import java.sql.*;

public class RegistrationOffice {
    public void createRegistrationOffice(Integer id_of_patient, String data,Integer id_medical_doctor,
                                         String type_of_treatment,Integer money,Integer doctor_iddoctor,Integer patient_id_patient){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLINSERT = "INSERT INTO `hospitallab4db`.`registration_office` " +
                    "(id_of_patient, data, id_medical_doctor, type_of_treatment, money, doctor_iddoctor, patient_id_patient)"
                    + "VALUES(?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(SQLINSERT);
            ps.setInt(1,id_of_patient);
            ps.setString(2,data);
            ps.setInt(3,id_medical_doctor);
            ps.setString(4,type_of_treatment);
            ps.setInt(5,money);
            ps.setInt(6,doctor_iddoctor);
            ps.setInt(7,patient_id_patient);
            ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  void readRegistrationOffice(){
        try (Connection connection = DBConnection.get_connection()){
            PreparedStatement pr = null;
            ResultSet res = null;
            String SQLREAD  = "select * from registration_office";
            pr = connection.prepareStatement(SQLREAD);
            System.out.println(pr);
            res = pr.executeQuery();
            while(res.next()){
                System.out.println("id patient - "  + res.getInt("id_of_patient"));
                System.out.println("data - " + res.getString("data"));
                System.out.println("id_medical_doctor - " + res.getInt("id_medical_doctor"));
                System.out.println("type_of_treatment - " + res.getString("type_of_treatment"));
                System.out.println("money - " + res.getInt("money"));
                System.out.println("doctor id - " + res.getInt("doctor_iddoctor"));
                System.out.println("patient_id_patient - " + res.getInt("patient_id_patient"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateRegistrationOffice(Integer id_of_patient, String data,Integer id_medical_doctor,
                                         String type_of_treatment,Integer money,Integer doctor_iddoctor,Integer patient_id_patient){
        try(Connection connection = DBConnection.get_connection()){
            PreparedStatement ps = null;
            String SQLUPDATE = "UPDATE registration_office SET `id_of_patient`=?," +
                    "`data`=?,`id_medical_doctor`=?,`type_of_treatment`=?,money=?," +
                    "doctor_iddoctor=?,patient_id_patient=? WHERE patient_id_patient=? AND doctor_iddoctor=? ";
            ps = connection.prepareStatement(SQLUPDATE);
            ps.setInt(1,id_of_patient);
            ps.setString(2,data);
            ps.setInt(3,id_medical_doctor);
            ps.setString(4,type_of_treatment);
            ps.setInt(5,money);
            ps.setInt(6,doctor_iddoctor);
            ps.setInt(7,patient_id_patient);
            ps.setInt(8,doctor_iddoctor);
            ps.setInt(9,patient_id_patient);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteRegistrationOffice(Integer id_of_patient,Integer id_medical_doctor){
        try(Connection connection=DBConnection.get_connection()){
            PreparedStatement ps =null;
            String SQLDELETE = "DELETE FROM `registration_office` WHERE id_of_patient=? AND id_medical_doctor=?";
            ps = connection.prepareStatement(SQLDELETE);
            ps.setInt(1,id_of_patient);
            ps.setInt(2,id_medical_doctor);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
