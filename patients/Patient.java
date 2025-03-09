package src.uned.poo.hospital.patients;

import src.uned.poo.hospital.types.TypeOfPatient;

public abstract class Patient {
    String fullName;
    String nif;
    int age;
    TypeOfPatient type;
    
    private String typeName() {
        switch (type) {
            case NEWBORN:
                return "Neonato";
            case CHILD:
                return "Niño";
            case ADULT:
                return "Adulto";
        }
        return "No registrado";
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getNif() {
        return nif;
    }
    
    public void setNif(String nif) {
        this.nif = nif;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Patient) return nif.equals(((Patient) obj).nif);
        throw new IllegalArgumentException("Se deben comparar dos pacientes");
    }
    
    @Override
    public String toString() {
        return "Nombre: " + fullName + "\nNIF: " + nif + "\nEdad: " + age + "\nTipo: " + typeName();
    }
}
