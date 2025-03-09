package src.uned.poo.hospital.campus;

import java.time.LocalDate;
import java.time.LocalTime;
import src.uned.poo.hospital.personal.Doctor;
import src.uned.poo.hospital.patients.Patient;
import java.time.format.DateTimeFormatter;

public class ConsultationSession {
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    
    public ConsultationSession(Patient patient, Doctor doctor, LocalDate date, LocalTime time, int duration) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public Doctor getMedic() {
        return doctor;
    }
    
    public void setMedic(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public LocalTime getTime() {
        return time;
    }
    
    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date.format(formatter) + " " + time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
