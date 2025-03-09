package src.uned.poo.hospital.personal;

import src.uned.poo.hospital.types.Speciality;

public abstract class Doctor extends Personal{
    Speciality speciality;
    
    private String specialityName() {
        switch (speciality) {
            case DIGESTIVE:
                return "Aparato digestivo";
            case CARDIOLOGY:
                return "Cardiología";
            case SURGERY:
                return "Cirugía general";
            case DERMATOLOGY:
                return "Dermatología";
            case INTERNAL:
                return "Medicina interna";
            case ONCOLOGY:
                return "Oncología";
            case OPHTHALMOLOGY:
                return "Oftalmología";
            case PSYCHIATRY:
                return "Psiquiatría";
            case TRAUMATOLOGY:
                return "Traumatología";
        }
        return "No registrada";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Doctor) return nif.equals(((Doctor) obj).nif);
        throw new IllegalArgumentException("Se deben comparar dos médicos");
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nEspecialidad: " + specialityName();
    }
}
