package src.uned.poo.hospital.campus;

import src.uned.poo.hospital.patients.Patient;

public class NormalRoom {
    int room;
    Patient patient;
    
    public NormalRoom(int room, Patient patient) {
        this.room = room;
        this.patient = patient;
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
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NormalRoom) return room == ((NormalRoom) obj).room;
        throw new IllegalArgumentException("Se deben comparar dos habitaciones de UCI"); //para no añadir dos veces la misma habitación
    }
    
    @Override
    public String toString() {
        return "UCI nÃºmero : " + room + "\nOcupante : " + patient.getFullName();
    }
}
