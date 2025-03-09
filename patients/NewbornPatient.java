package src.uned.poo.hospital.patients;

import src.uned.poo.hospital.types.TypeOfPatient;

public class NewbornPatient extends Patient{
    public NewbornPatient(String fullName, String nif, int age) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.type = TypeOfPatient.NEWBORN;
    }
}
