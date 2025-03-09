package src.uned.poo.hospital.campus;

import src.uned.poo.hospital.personal.Student;
import java.util.LinkedList;
import java.util.Iterator;

public class TrainingUnit {
    private LinkedList<Student> students;
    private int labs;
    
    public TrainingUnit(int labs) {
        students = new LinkedList<>();
        this.labs = labs;
    }
    
    private boolean isInList(Student student) { //saber si un estudiante está ya en la lista
        return students.contains(student);
    }
    
    public int getLabs() {
        return labs;
    }
    
    public void setLabs(int labs) {
        this.labs = labs;
    }
    
    public void addStudent(Student student) {
        if (!isInList(student)) students.add(student); //añadir estudiante si no está lista ya
    }
    
    public boolean removeStudent(Student student) {
        return students.remove(student);
    }
    
    public Iterator<Student> iterator(){
        return students.iterator();    
    }
}
