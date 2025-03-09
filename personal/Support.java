package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.ServiceType;

public class Support extends Personal{
    ServiceType type;
    
    public Support(String fullName, String nif, int age, ServiceType type) {
        this.fullName = fullName;
        this.nif = nif;
        this.age = age;
        this.type = type;
    }
}
