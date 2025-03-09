package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.Speciality;

public class Nurse extends Personal{
    Speciality speciality;
    
    public Nurse(String fullName, String nif, int age) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.speciality = Speciality.NURSE;
    }
    
    public Speciality getSpeciality() {
        return speciality;
    }
    
    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
