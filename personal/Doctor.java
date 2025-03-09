package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.Speciality;

public abstract class Doctor extends Personal{
    Speciality speciality;
    
    private String specialityName() {
        switch (speciality) {
            case DIGESTIVE:
                return "Aparato digestivo";
            case CARDIOLOGY:
                return "Cardiolog�a";
            case SURGERY:
                return "Cirug�a general";
            case DERMATOLOGY:
                return "Dermatolog�a";
            case INTERNAL:
                return "Medicina interna";
            case ONCOLOGY:
                return "Oncolog�a";
            case OPHTHALMOLOGY:
                return "Oftalmolog�a";
            case PSYCHIATRY:
                return "Psiquiatr�a";
            case TRAUMATOLOGY:
                return "Traumatolog�a";
        }
        return "No registrada";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Doctor) return nif.equals(((Doctor) obj).nif);
        throw new IllegalArgumentException("Se deben comparar dos m�dicos");
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nEspecialidad: " + specialityName();
    }
}
