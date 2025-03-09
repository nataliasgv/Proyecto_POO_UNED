package src.uned.poo.hospital.patients;

import src.uned.poo.hospital.types.TypeOfPatient;

public class ChildPatient extends Patient{
    public ChildPatient(String fullName, String nif, int age) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.type = TypeOfPatient.CHILD;
    }
}
