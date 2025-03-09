package src.uned.poo.hospital.campus;

import src.uned.poo.hospital.personal.*;
import src.uned.poo.hospital.patients.Patient;

public class UciRoom {
    private int room;
    private Patient patient;
    private Nurse supervisor;
    
    public UciRoom(int room, Patient patient, Nurse supervisor) {
        this.room = room;
        this.patient = patient;
        this.supervisor = supervisor;
    }
    
    public int getRoom() {
        return room;
    }
    
    public void setRoom(int room) {
        this.room = room;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public Nurse getSupervisor() {
        return supervisor;
    }
    
    public void setSupervisor(Nurse supervisor) {
        this.supervisor = supervisor;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UciRoom) return room == ((UciRoom) obj).room;
        throw new IllegalArgumentException("Se deben comparar dos habitaciones de UCI");//para no añadir dos veces la misma habitación
    }
    
    @Override
    public String toString() {
        return "UCI número : " + room + "\nOcupante : " + patient.getFullName() + "\nSupervisor actual: " + supervisor.getFullName();
    }
}
