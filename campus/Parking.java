package src.uned.poo.hospital.campus;

public class Parking {
    int spaces;
    int cars;
    
    public Parking(int spaces) {
        this.spaces = spaces;
    }
    
    public int getSpaces() {
        return spaces;
    }
    
    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }
    
    public boolean addCar() {
        if (cars > spaces) return false;
        cars++;
        return true;
    }
    
    public boolean removeCar() {
        if (cars == 0) return false;
        cars--;
        return true;
    }
}
