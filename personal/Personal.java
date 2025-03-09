package src.uned.poo.hospital.personal;

public abstract class Personal {
    String fullName;
    String nif;
    int age;
    
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
    public String toString() {
        return "Nombre: " + fullName + "\nNIF: " + nif + "\nEdad: " + age;
    }
}
