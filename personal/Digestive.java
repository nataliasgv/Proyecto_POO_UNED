package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.Speciality;

public class Digestive extends Doctor {
    public Digestive(String fullName, String nif, int age) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.speciality = Speciality.DIGESTIVE;
    }
}
