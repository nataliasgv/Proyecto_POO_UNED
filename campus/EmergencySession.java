package src.uned.poo.hospital.campus;

import src.uned.poo.hospital.patients.Patient;
import src.uned.poo.hospital.personal.Doctor;

public class EmergencySession {
    private static EmergencySession instance = null;
    private Doctor doctor;
    private Patient patient;
    
    private EmergencySession(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }
    
    public static EmergencySession getInstance(Doctor doctor, Patient patient) {
        if (instance == null) {
            instance = new EmergencySession(doctor, patient);
        } else {
            instance.setDoctor(doctor);
            instance.setPatient(patient);
        }
        return instance;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
