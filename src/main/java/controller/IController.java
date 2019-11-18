package controller;

import java.sql.Date;
import java.sql.SQLException;

public interface IController {
    void createAnalysis(Integer idanalysis,String analysis_description,Integer patient_id_patient) throws SQLException;
    void createDiagnosis(Integer iddiagnosis,String description_diagnosis,Integer patient_id_patient,
                         String data_diagnosis) throws SQLException;
    void createPatient(Integer id_patient,String name,Integer age,
                       String work, String email,Integer phone,String lifestyle,Integer bad_habits) throws  SQLException;
    void createHabits(Integer idhabits,String habits) throws SQLException;
    void createDoctor(Integer iddoctor,Integer type_doctor,String full_name,
                      String time_of_reception,String email,Integer phone,Integer experience,String license,Integer type_doctor_idtype_doctor) throws SQLException;
    void createTypeDoctor(Integer idtype_doctor,String type_doctor) throws SQLException;
    void createRegistrationOffice(Integer id_of_patient, String data,Integer id_medical_doctor,
                                  String type_of_treatment,Integer money,Integer doctor_iddoctor,Integer patient_id_patient) throws SQLException;

    void readAnalysis() throws SQLException;
    void readDiagnosis() throws SQLException;
    void readDoctor() throws SQLException;
    void readHabits() throws SQLException;
    void readPatient() throws SQLException;
    void readRegistrationOffice() throws SQLException;
    void readTypeDoctor() throws SQLException;

    void updateAnalysis(Integer idanalysis,String analysis_description,Integer patient_id_patient) throws SQLException;
    void updateDiagnosis(Integer iddiagnosis,String description_diagnosis,Integer patient_id_patient,String data_diagnosis) throws SQLException;
    void updateDoctor(Integer iddoctor,Integer type_doctor,String full_name,
                      String time_of_reception,String email,Integer phone,Integer experience,String license,Integer type_doctor_idtype_doctor) throws SQLException;
    void updateHabits(Integer idhabits,String habits) throws SQLException;
    void updatePatient(Integer id_patient,String name,Integer age,
                       String work, String email,Integer phone,String lifestyle,Integer bad_habits) throws SQLException;
    void updateRegistrationOffice(Integer id_of_patient, String data,Integer id_medical_doctor,
                                  String type_of_treatment,Integer money,Integer doctor_iddoctor,Integer patient_id_patient) throws SQLException;
    void updateTypeDoctor(Integer idtype_doctor,String type_doctor) throws SQLException;

    void deleteAnalysis(Integer idanalysis) throws SQLException;
    void deleteDiagnosis(Integer iddiagnosis) throws SQLException;
    void deleteDoctor(Integer iddoctor) throws SQLException;
    void deleteHabits(Integer idhabits) throws SQLException;
    void deletePatient(Integer id_patient) throws SQLException;
    void deleteRegistrationOffice(Integer id_of_patient,Integer id_medical_doctor) throws SQLException;
    void deleteTypeDoctor(Integer idtype_doctor) throws SQLException;
}
