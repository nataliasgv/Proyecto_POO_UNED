package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.Speciality;

public class Traumatologist extends Doctor {
    public Traumatologist(String fullName, String nif, int age) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.speciality = Speciality.TRAUMATOLOGY;
    }
}
