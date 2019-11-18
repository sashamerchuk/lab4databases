package view;

import com.sun.tools.jdeprscan.scan.Scan;
import controller.Controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class MyView {
    private static Controller controller;
    private static String menu = ("\t1-Create\n \t2-Read\n \t3 - Update\n \t4 - Delete");

    public MyView() {
        controller = new Controller();
    }

    public void show() throws SQLException {
        String menuPoint;
        do {
            System.out.println("\nPress Enter to continue");
            new Scanner(System.in).nextLine();
            outputMenu();
            System.out.print("\nPlease, select menu point: ");
            menuPoint = new Scanner(System.in).nextLine().toUpperCase();
            switch (menuPoint) {
                case "1":
                    analysis();
                    break;
                case "2":
                    diagnosis();
                case "3":
                    patient();
                case "4":
                    habits();
                case "5":
                    doctor();
                case "6":
                    typeDoctor();
                case "7":
                    registrationOffice();
                case "exit":
                    break;
                default:
                    System.out.println("Menu point does not exist");
            }
        } while (!menuPoint.equals("exit"));
    }

    private void outputMenu() {
        System.out.println("Menu");
        System.out.println("Choose table");
        System.out.println("\t1-Analysis\n" + "\t2 - Diagnosis\n" + "\t3 -Patient\n"
                + "\t4- Habits\n" + "\t5 - Doctor\n" + "\t6 - TypeDoctor\n" + "\t7 - RegistrationOffice");
    }

    private void analysis() throws SQLException {
        System.out.println("Table - Analysis");
        System.out.println(menu);
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                System.out.println("Enter idanalysis");
                Integer idanalysis = new Scanner(System.in).nextInt();
                System.out.println("Enter analysis_description");
                String analysis_description = new Scanner(System.in).nextLine();
                System.out.println("Enter patient_id");
                Integer patient_id_patient = new Scanner(System.in).nextInt();
                controller.createAnalysis(idanalysis, analysis_description, patient_id_patient);
                break;
            case "2":
                controller.readAnalysis();
            case "3":
                System.out.println("Enter idanalysis");
                Integer newIdAnalysis = new Scanner(System.in).nextInt();
                System.out.println("Enter analysis_description");
                String newAnalysisDescription = new Scanner(System.in).nextLine();
                System.out.println("Enter patient id");
                Integer newPatient_id_patient = new Scanner(System.in).nextInt();
                controller.updateAnalysis(newIdAnalysis,newAnalysisDescription,newPatient_id_patient);
                break;
            case "4":
                System.out.println("Enter idanalysis");
                Integer deleteIdanalysis = new Scanner(System.in).nextInt();
                controller.deleteAnalysis(deleteIdanalysis);
                break;
            case "exit":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void diagnosis() throws SQLException {
        System.out.println("Table  - Diagnosis");
        System.out.println(menu);

        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                System.out.println("Enter iddiagnosis");
                Integer iddiagnosis = new Scanner(System.in).nextInt();
                System.out.println("Enter analysis_description");
                String description_diagnosis = new Scanner(System.in).nextLine();
                System.out.println("Enter patient_id");
                Integer patient_id_diagnos = new Scanner(System.in).nextInt();
                System.out.println("Enter date");
                String date = new Scanner(System.in).nextLine();
                controller.createDiagnosis(iddiagnosis, description_diagnosis, patient_id_diagnos, date);
                break;
            case "2":
                controller.readDiagnosis();
            case "3":
                System.out.println("Enter iddiagnosis");
                Integer newIddiagnosis = new Scanner(System.in).nextInt();
                System.out.println("Enter description diagnosis");
                String newAnalysisDescription = new Scanner(System.in).nextLine();
                System.out.println("Enter patient id");
                Integer newPatient_id_patient = new Scanner(System.in).nextInt();
                System.out.println("Enter data diagnosis");
                String newData = new Scanner(System.in).nextLine();
                controller.updateDiagnosis(newIddiagnosis,newAnalysisDescription,newPatient_id_patient,newData);
                break;
            case "4":
                System.out.println("Enter iddiagnosis");
                Integer deleteIdDiagnosis = new Scanner(System.in).nextInt();
                controller.deleteDiagnosis(deleteIdDiagnosis);
                break;
            case "exit":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void patient() throws SQLException {
        System.out.println("Table - Patient");
        System.out.println(menu);
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                System.out.println("Enter id_patient");
                Integer id_patient = new Scanner(System.in).nextInt();
                System.out.println("Enter name");
                String name = new Scanner(System.in).nextLine();
                System.out.println("Enter age");
                Integer age = new Scanner(System.in).nextInt();
                System.out.println("Enter work");
                String work = new Scanner(System.in).nextLine();
                System.out.println("Enter email");
                String email = new Scanner(System.in).nextLine();
                System.out.println("Enter phone");
                Integer phone = new Scanner(System.in).nextInt();
                System.out.println("Enter lifestyle");
                String lifestyle = new Scanner(System.in).nextLine();
                System.out.println("Enter bad_habits");
                Integer bad_habits = new Scanner(System.in).nextInt();
                controller.createPatient(id_patient, name, age, work, email, phone, lifestyle, bad_habits);
                break;
            case "2":
                controller.readPatient();
            case "3":
                System.out.println("Enter id_patient");
                Integer newIdPatient = new Scanner(System.in).nextInt();
                System.out.println("Enter name");
                String newName = new Scanner(System.in).nextLine();
                System.out.println("Enter age");
                Integer newAge = new Scanner(System.in).nextInt();
                System.out.println("Enter work");
                String newWork = new Scanner(System.in).nextLine();
                System.out.println("Enter email");
                String newEmail = new Scanner(System.in).nextLine();
                System.out.println("Enter phone");
                Integer newPhone = new Scanner(System.in).nextInt();
                System.out.println("Enter lifestyle");
                String newlifestyle = new Scanner(System.in).nextLine();
                System.out.println("Enter bad_habits");
                Integer newBadHabits = new Scanner(System.in).nextInt();
                controller.updatePatient(newIdPatient,newName,newAge,newWork,newEmail,newPhone,newlifestyle,newBadHabits);
                break;
            case "4":
                System.out.println("Enter id_patient");
                Integer deleteIdPatient = new Scanner(System.in).nextInt();
                controller.deletePatient(deleteIdPatient);
                break;
            case "exit":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void habits() throws SQLException {
        System.out.println("Table - Habits");
        System.out.println(menu);
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                System.out.println("Enter idhabits");
                Integer idhabits = new Scanner(System.in).nextInt();
                System.out.println("Enter habits");
                String habits = new Scanner(System.in).nextLine();

                controller.createHabits(idhabits, habits);
                break;
            case "2":
                controller.readHabits();
            case "exit":
                System.out.println("Exit");
                break;
            case "3":
                System.out.println("Enter idhabits");
                Integer newIdHabits = new Scanner(System.in).nextInt();
                System.out.println("Enter habits");
                String newHabits = new Scanner(System.in).nextLine();
                controller.updateHabits(newIdHabits,newHabits);
                break;
            case "4":
                System.out.println("Enter idhabits");
                Integer deleteIdHabits = new Scanner(System.in).nextInt();
                controller.deleteHabits(deleteIdHabits);
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void doctor() throws SQLException {
        System.out.println("Table - Doctor");
        System.out.println(menu);
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                System.out.println("Enter iddoctor");
                Integer iddoctor = new Scanner(System.in).nextInt();
                System.out.println("Enter type doctor ");
                Integer type_doctor = new Scanner(System.in).nextInt();
                System.out.println("Enter full_name");
                String full_name = new Scanner(System.in).nextLine();
                System.out.println("Enter time_of_reception str");
                String time_of_reception = new Scanner(System.in).nextLine();
                System.out.println("Enter email");
                String email = new Scanner(System.in).nextLine();
                System.out.println("Enter the phone");
                Integer phone = new Scanner(System.in).nextInt();
                System.out.println("Enter experience");
                Integer experience = new Scanner(System.in).nextInt();
                System.out.println("Enter license");
                String license = new Scanner(System.in).nextLine();
                System.out.println("Enter type id doctor ");
                Integer type_doctor_idtype_doctor = new Scanner(System.in).nextInt();

                controller.createDoctor(iddoctor, type_doctor, full_name, time_of_reception, email, phone, experience, license,type_doctor_idtype_doctor);
                break;
            case "2":
                controller.readDoctor();
                break;
            case "3":
                System.out.println("Enter iddoctor");
                Integer newIddoctor = new Scanner(System.in).nextInt();
                System.out.println("Enter type_doctor");
                Integer newTypeDoctor = new Scanner(System.in).nextInt();
                System.out.println("Enter full name");
                String newFullName = new Scanner(System.in).nextLine();
                System.out.println("Enter time of reception");
                String newTimeOfReception = new Scanner(System.in).nextLine();
                System.out.println("Enter email");
                String newEmail = new Scanner(System.in).nextLine();
                System.out.println("Enter phone");
                Integer newPhone = new Scanner(System.in).nextInt();
                System.out.println("Enter experience");
                Integer newExperience = new Scanner(System.in).nextInt();
                System.out.println("Enter license");
                String newLicense = new Scanner(System.in).nextLine();
                System.out.println("Enter type_doctor_idtype_doctor");
                Integer newTypeDoctorId = new Scanner(System.in).nextInt();
                controller.updateDoctor(newIddoctor,newTypeDoctor,newFullName,newTimeOfReception,
                        newEmail,newPhone,newExperience,newLicense,newTypeDoctorId);
                break;
            case "4":
                System.out.println("Enter iddoctor");
                Integer deleteIdDoctor = new Scanner(System.in).nextInt();
                controller.deleteDoctor(deleteIdDoctor);
                break;
            case "exit":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }

    private void typeDoctor() throws SQLException {
        System.out.println("Table - TypeDoctor");
        System.out.println(menu);
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                System.out.println("Enter idtype_doctor");
                Integer idtype_doctor = new Scanner(System.in).nextInt();
                System.out.println("Enter type_doctor str");
                String type_doctor = new Scanner(System.in).nextLine();

                controller.createTypeDoctor(idtype_doctor, type_doctor);
                break;
            case "2":
                controller.readTypeDoctor();
                break;
            case "3":
                System.out.println("Enter idtype_doctor");
                Integer newIdTypeDoctor = new Scanner(System.in).nextInt();
                System.out.println("Enter type_doctor");
                String newTypeDoctor = new Scanner(System.in).nextLine();
                controller.updateTypeDoctor(newIdTypeDoctor,newTypeDoctor);
                break;
            case "4":
                System.out.println("Enter idtype_doctor");
                Integer deleteIdOfPatient = new Scanner(System.in).nextInt();
                controller.deleteTypeDoctor(deleteIdOfPatient);
                break;
            case "exit":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }
    private  void registrationOffice() throws SQLException {
        System.out.println("Table - RegistrationOffice");
        System.out.println(menu);
        switch (new Scanner(System.in).nextLine().toUpperCase()) {
            case "1":
                System.out.println("Enter id_of_patient");
                Integer id_of_patient = new Scanner(System.in).nextInt();
                System.out.println("Enter data");
                String data = new Scanner(System.in).nextLine();
                System.out.println("Enter id_medical_doctor");
                Integer id_medical_doctor = new Scanner(System.in).nextInt();
                System.out.println("Enter type_of_treatment");
                String type_of_treatment = new Scanner(System.in).nextLine();
                System.out.println("Enter the money");
                Integer money = new Scanner(System.in).nextInt();
                System.out.println("Enter id doctor");
                Integer doctor_iddoctor = new Scanner(System.in).nextInt();
                System.out.println("Enter patient_id_patient");
                Integer patient_id_patient = new Scanner(System.in).nextInt();
                controller.createRegistrationOffice(id_of_patient,data,id_medical_doctor,type_of_treatment,money,doctor_iddoctor,patient_id_patient);
                break;
            case "2":
                controller.readRegistrationOffice();
                break;
            case "3":
                System.out.println("Enter id_of_patient");
                Integer newIdPatient = new Scanner(System.in).nextInt();
                System.out.println("Enter data");
                String newData = new Scanner(System.in).nextLine();
                System.out.println("Enter id_medical_doctor");
                Integer newIdMedicalDoctor = new Scanner(System.in).nextInt();
                System.out.println("Enter type_of_treatment");
                String newTypeTreatment = new Scanner(System.in).nextLine();
                System.out.println("Enter money");
                Integer newMoney = new Scanner(System.in).nextInt();
                System.out.println("Enter doctoriddoctor");
                Integer newDoctorIdDoctor = new Scanner(System.in).nextInt();
                System.out.println("Enter patient_id_patient");
                Integer newPatientIdPatient = new Scanner(System.in).nextInt();
                controller.updateRegistrationOffice(newIdPatient,newData,newIdMedicalDoctor,newTypeTreatment,newMoney,newDoctorIdDoctor,newPatientIdPatient);
                break;
            case "4":
                System.out.println("Enter id_of_patient");
                Integer deleteIdOfPatient = new Scanner(System.in).nextInt();
                System.out.println("Enter id_of_medical_doctor");
                Integer deleteIdMedicDoctor = new Scanner(System.in).nextInt();
                controller.deleteRegistrationOffice(deleteIdOfPatient,deleteIdMedicDoctor);
                break;
            case "exit":
                System.out.println("Exit");
                break;
            default:
                System.out.println("Input is incorrect");
        }
    }
}