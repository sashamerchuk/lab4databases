package controller;

import model.*;

import java.sql.Date;
import java.sql.SQLException;

public class Controller implements IController {
    private static Analysis analysis;
    private static Diagnosis diagnosis;
    private  static Patient patient;
    private static Habits habits1;
    private static Doctor doctor;
    private static TypeDoctor typeDoctor;
    private static RegistrationOffice registrationOffice;
    public Controller(){
        analysis = new Analysis();
        diagnosis = new Diagnosis();
        patient = new Patient();
        habits1 = new Habits();
        doctor = new Doctor();
        typeDoctor = new TypeDoctor();
        registrationOffice = new RegistrationOffice();
    }

    @Override
    public void createAnalysis(Integer idanalysis,String analysis_description,Integer patient_id_patient){
        analysis.createAnalysis(idanalysis,analysis_description,patient_id_patient);
    }
    @Override
    public void createDiagnosis(Integer iddiagnosis,String description_diagnosis,Integer patient_id_patient,
                                String data_diagnosis){
        diagnosis.createDiagnosis(iddiagnosis,description_diagnosis,patient_id_patient,data_diagnosis);
    }
    @Override
    public void createPatient(Integer id_patient,String name,Integer age,
                              String work, String email,Integer phone,String lifestyle,Integer bad_habits){
        patient.createPatient(id_patient,name,age,work,email,phone,lifestyle,bad_habits);
    }

    @Override
    public void createHabits(Integer idhabits,String habits){
        habits1.createHabits(idhabits,habits);
    }

    @Override
    public void createDoctor(Integer iddoctor,Integer type_doctor,String full_name,
                             String time_of_reception,String email,Integer phone,Integer experience,String license,Integer type_doctor_idtype_doctor){
        doctor.createDoctor(iddoctor,type_doctor,full_name,time_of_reception,email,phone,experience,license,type_doctor_idtype_doctor);
    }
    @Override
    public void createTypeDoctor(Integer idtype_doctor,String type_doctor){
        typeDoctor.createAnalysis(idtype_doctor,type_doctor);
    }
    @Override
    public void createRegistrationOffice(Integer id_of_patient, String data,Integer id_medical_doctor,
                                         String type_of_treatment,Integer money,Integer doctor_iddoctor,Integer patient_id_patient){
        registrationOffice.createRegistrationOffice(id_of_patient,data,id_medical_doctor,type_of_treatment,money,doctor_iddoctor,patient_id_patient);
    }

    @Override
    public void readAnalysis() throws SQLException{
        analysis.readAnalysis();
    }

    @Override
    public void readDiagnosis() throws SQLException{
        diagnosis.readDiagnosis();
    }

    @Override
    public void readDoctor() throws SQLException{
        doctor.readDoctor();
    }

    @Override
    public void readHabits() throws SQLException{
        habits1.readHabits();
    }

    @Override
    public void readPatient() throws SQLException{
        patient.readPatient();
    }

    @Override
    public void readRegistrationOffice() throws SQLException{
        registrationOffice.readRegistrationOffice();
    }
    @Override
    public void readTypeDoctor() throws SQLException{
        typeDoctor.readTypeDoctor();
    }

    @Override
    public void updateAnalysis(Integer idanalysis,String analysis_description,Integer patient_id_patient) throws SQLException{
        analysis.updateAnalysis(idanalysis,analysis_description,patient_id_patient);
    }

    @Override
    public void updateDiagnosis(Integer iddiagnosis,String description_diagnosis,Integer patient_id_patient,String data_diagnosis) throws SQLException{
        diagnosis.updateDiagnosis(iddiagnosis,description_diagnosis,patient_id_patient,data_diagnosis);
    }

    @Override
    public void updateDoctor(Integer iddoctor,Integer type_doctor,String full_name,
                             String time_of_reception,String email,Integer phone,Integer experience,String license,Integer type_doctor_idtype_doctor
                             ){
        doctor.updateDoctor(iddoctor,type_doctor,full_name,time_of_reception,email,phone,experience,license,type_doctor_idtype_doctor);
    }

    @Override
    public void updateHabits(Integer idhabits,String habits) throws SQLException{
        habits1.updateHabits(idhabits,habits);
    }

    @Override
    public void updatePatient(Integer id_patient,String name,Integer age,
                              String work, String email,Integer phone,String lifestyle,Integer bad_habits) throws SQLException{
        patient.updatePatient(id_patient,name,age,work,email,phone,lifestyle,bad_habits);
    }

    @Override
    public void updateRegistrationOffice(Integer id_of_patient, String data,Integer id_medical_doctor,
                                         String type_of_treatment,Integer money,Integer doctor_iddoctor,Integer patient_id_patient) throws SQLException{
        registrationOffice.updateRegistrationOffice(id_of_patient,data,id_medical_doctor,type_of_treatment,money,doctor_iddoctor,patient_id_patient);
    }

    @Override
    public void updateTypeDoctor(Integer idtype_doctor,String type_doctor)throws SQLException{
        typeDoctor.updateHabits(idtype_doctor,type_doctor);
    }

    @Override
    public void deleteAnalysis(Integer idanalysis) throws SQLException{
        analysis.deleteAnalysis(idanalysis);
    }

    @Override
    public void deleteDiagnosis(Integer iddiagnosis) throws SQLException{
        diagnosis.deleteDiagnosis(iddiagnosis);
    }

    @Override
    public void deleteDoctor(Integer iddoctor) throws SQLException{
        doctor.deleteDoctor(iddoctor);
    }

    @Override
    public void deleteHabits(Integer idhabits) throws SQLException{
        habits1.deleteHabits(idhabits);
    }

    @Override
    public void deletePatient(Integer id_patient) throws SQLException{
        patient.deletePatient(id_patient);
    }

    @Override
    public void deleteRegistrationOffice(Integer id_of_patient,Integer id_medical_doctor){
        registrationOffice.deleteRegistrationOffice(id_of_patient, id_medical_doctor);
    }
    @Override
    public void deleteTypeDoctor(Integer idtype_doctor) throws SQLException{
        typeDoctor.deleteTypeDoctor(idtype_doctor);
    }
}
