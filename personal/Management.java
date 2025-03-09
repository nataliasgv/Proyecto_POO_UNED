package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.ManagementType;

public class Management extends Personal{
    ManagementType type;
    
    public Management(String fullName, String nif, int age, ManagementType type) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.type = type;
    }
}
