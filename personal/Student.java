package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.Speciality;

public class Student extends Personal {
    Speciality speciality;
    
    public Student(String fullName, String nif, int age, Speciality speciality) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.speciality = speciality;
    }
}
