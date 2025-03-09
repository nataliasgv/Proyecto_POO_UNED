package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.Speciality;

public class Cardiologist extends Doctor {
    public Cardiologist(String fullName, String nif, int age) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.speciality = Speciality.CARDIOLOGY;
    }
}
