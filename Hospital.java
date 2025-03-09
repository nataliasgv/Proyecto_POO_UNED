package src.uned.poo.hospital;

import src.uned.poo.hospital.campus.*;
import src.uned.poo.hospital.patients.*;
import src.uned.poo.hospital.personal.*;
import src.uned.poo.hospital.types.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Hospital {
    
    private final Scanner scanner;
    private final LinkedList<Doctor> doctors;
    private final LinkedList<Nurse> nurses;
    private final LinkedList<Patient> patients;
    private final LinkedList<UciRoom> uciRooms;
    private final TrainingUnit trainingUnit;
    private int labs;
    private int uciNumber;
    
    public Hospital(){ 
        scanner = new Scanner(System.in);
        doctors = new LinkedList<>();
        nurses = new LinkedList<>();
        patients = new LinkedList<>();
        labs = 6;//el numero de laboratiorio esta establecido arbitrariamente como 6, el usuario puede cambiarlo
        uciNumber = 1;
        trainingUnit = new TrainingUnit(labs);
        uciRooms = new LinkedList<>();
    }
    
    public void init(){
        doctors.add(new Cardiologist("Maria Perez", "12345678A", 43));
        doctors.add(new Dermatologist("Juan Lopez", "23456789B", 38));
        doctors.add(new Oncologist("Manuela Hernandez", "87654321C", 50));
        doctors.add(new Traumatologist("Hector Sanz", "98765432D", 27));
        
        nurses.add(new Nurse("Julian Casablancas", "13579021A", 45 ));
        nurses.add(new Nurse("Carmen Lorenzo", "11202456A", 37 ));
        nurses.add(new Nurse("Michael Scott", "78239472J", 60 ));
        nurses.add(new Nurse("Laura Martinez", "73890623I", 35 ));
        
        patients.add(new AdultPatient("Paula Moretti", "15638290Y", 37));
        patients.add(new AdultPatient("Albert Alcantara", "71628920B", 25));
        patients.add(new ChildPatient("Estrella Cortes", "26153895O", 7));
        patients.add(new NewbornPatient("Marta Perez ", "34526189Y", 1));
        
        trainingUnit.addStudent(new Student("Andrés Martínez", "18394075G", 23, Speciality.CARDIOLOGY));
        trainingUnit.addStudent(new Student("Sofía Hernández", "09251637I", 22, Speciality.DIGESTIVE));
        trainingUnit.addStudent(new Student("Raquel Silva", "28394598", 19, Speciality.ONCOLOGY));
        trainingUnit.addStudent(new Student("Jacob Black", "38298467Y", 24, Speciality.OPHTHALMOLOGY));
    }
    
        public static Student searchStudentNif(LinkedList<Student> students, String StudentNif){
        for(Student student : students){
            if (student.getNif().equals(StudentNif)){
                return student;
            }
        }
        System.out.println("Dni " + StudentNif + " no registrado");
        return null;
        //método para encontrar a un estudiante según su dni
    }
    
    public static Doctor searchDoctorNif(LinkedList<Doctor> doctors, String DoctorNif){
        for(Doctor doctor : doctors){
            if (doctor.getNif().equals(DoctorNif)){
                return doctor;
            }
        }
        System.out.println("Dni " + DoctorNif + " no registrado");
        return null;
        //método para encontrar a un médico según su dni
    }
    
    public static Patient searchPatientNif(LinkedList<Patient> patients, String PatientNif){
        for(Patient patient : patients){
            if (patient.getNif().equals(PatientNif)){
                return patient;
            }
        }
        System.out.println("Dni " + PatientNif + " no registrado");
        return null;
        //método para encontrar a un paciente según su dni
    }   
    
    public static Nurse searchNurseNif(LinkedList<Nurse> nurses, String NurseNif){
        for(Nurse nurse : nurses){
            if (nurse.getNif().equals(NurseNif)){
                return nurse;
            }
        }
        System.out.println("Dni " + NurseNif + " no registrado");
        return null;
        //método para encontrar a un enfermero según su dni
    }
    
    public void menu(){
        int selectMenu;
        System.out.println("Pulse 1 para dar de alta a un nuevo médico");
        System.out.println("Pulse 2 para dar de baja a un médico");
        System.out.println("Pulse 3 para ver la lista de médicos");
        System.out.println("Pulse 4 para dar de alta a un nuevo enfermero");
        System.out.println("Pulse 5 para dar de baja a un enfermero");
        System.out.println("Pulse 6 para ver la lista de enfermeros");
        System.out.println("Pulse 7 para dar de alta a un estudiante");
        System.out.println("Pulse 8 para ver la lista de estudiantes");
        System.out.println("Pulse 9 para establecer un nuevo numero de laboratorios para la Unidad de Formación");
        System.out.println("Pulse 10 para ingresar a un nuevo paciente");
        System.out.println("Pulse 11 para ver la lista de pacientes");
        System.out.println("Pulse 12 para dar una cita a un paciente con un médico");
        System.out.println("Pulse 13 para gestionar un ingreso a urgencias");
        System.out.println("Pulse 14 para ver la lista de habitaciones de la Unidad de Cuidados Intensivos");
        
        do {
            selectMenu = scanner.nextInt();
            scanner.nextLine(); //"consume" los caracteres adicionales que puedan quedar
            switch(selectMenu){
                case 1:
                    registerDoctor();
                break;
                case 2:
                    removeDoctor();
                break;
                case 3:
                    printDoctorsList();
                break;
                case 4:
                    registerNurse();
                break;
                case 5:
                    removeNurse();
                break;
                case 6:
                    printNursesList();
                break;
                case 7:
                    registerStudent();
                break;
                case 8:
                    printStudentsList();
                break;
                case 9:
                    assignLabsNum();
                break;
                case 10:
                    registerPatient();
                break;
                case 11:
                    printPatientsList();
                break;
                case 12:
                     assignConsultation();
                break;
                case 13:
                     emergencyRoom();
                break;
                case 14:
                     printUciRoomsList();
                break;
                default: 
                System.out.println("Opción no valida");
                menu();
            }        
        }while(selectMenu > 14 || selectMenu < 1);
    }
    private void registerDoctor(){
        int selectDoc;
        System.out.println("Introduzca nombre completo");
        String fullName = scanner.nextLine();
        System.out.println("Introduzca dni");
        String nif = scanner.nextLine();
        System.out.println("Introduzca edad");
        int age = scanner.nextInt();
        System.out.println("Introduzca el numero correspondiente a la especialidad (Digestivo(1), Cardiología(2), Cirugía General(3), Dermatología(4), Medicina Interna(5), Oncología(6), Oftalmología(7), Psiquiatría(8), Traumatología(9))");
        do{
            selectDoc = scanner.nextInt();
            scanner.nextLine();
            switch(selectDoc){   
                case 1:
                    Doctor digestive = new Digestive(fullName, nif, age);
                    doctors.add(digestive);
                    System.out.println("Médico Digestivo dado de alta");
                    menu();
                break;
                case 2:
                    Doctor cardiologist = new Cardiologist(fullName, nif, age);
                    doctors.add(cardiologist);
                    System.out.println("Cardiólogo dado de alta");
                    menu();
                break;        
                case 3:
                    Doctor surgeon = new Surgeon(fullName, nif, age);
                    doctors.add(surgeon);
                    System.out.println("Cirujano dado de alta");
                    menu();
                break;        
                case 4:
                    Doctor dermatologist = new Dermatologist(fullName, nif, age);
                    doctors.add(dermatologist);
                    System.out.println("Dermatologo dado de alta");
                    menu();
                break;        
                case 5:
                    Doctor internal = new Internal(fullName, nif, age);
                    doctors.add(internal);
                    System.out.println("Médico Interno dado de alta");
                    menu();
                break;        
                case 6:
                    Doctor oncologist = new Oncologist(fullName, nif, age);
                    doctors.add(oncologist);
                    System.out.println("Oncólogo dado de alta");
                    menu();
                break;        
                case 7:
                    Doctor ophthalmologist = new Ophthalmologist(fullName, nif, age);
                    doctors.add(ophthalmologist);
                    System.out.println("Oftalmólogo dado de alta");
                    menu();
                break;        
                case 8:
                    Doctor psychiatrist = new Psychiatrist(fullName, nif, age);
                    doctors.add(psychiatrist);
                    System.out.println("Psiquiatra dado de alta");
                    menu();
                break;        
                case 9:
                    Doctor traumatologist = new Traumatologist(fullName, nif, age);
                    doctors.add(traumatologist);
                    System.out.println("Traumatologo dado de alta");
                    menu();
                break;    
                default:
                    System.out.println("Opción no válida, introduzca un número del 1 al 9");
                    menu();
            }                               
        }while (selectDoc < 9 || selectDoc < 1);
    } 
    
    private void removeDoctor(){
        System.out.println("Introduzca el dni del médico");
        String doctorNif = scanner.nextLine();
        Doctor foundDoctor = searchDoctorNif(doctors, doctorNif);
        doctors.remove(foundDoctor);
        System.out.println("Médico con dni " + doctorNif + " dado de baja");
        menu();
    }
    
    private void printDoctorsList(){
        Iterator<Doctor> it = doctors.iterator();
        while(it.hasNext()){
            Doctor i = it.next();
            System.out.println(i.toString());
        }
        //volver al menú
        menu();
    }
    
    private void registerNurse(){
        System.out.println("Introduzca nombre completo");
        String fullName = scanner.nextLine();
        System.out.println("Introduzca dni");
        String nif = scanner.nextLine();
        System.out.println("Introduzca edad");
        int age = scanner.nextInt();
        Nurse nurse = new Nurse(fullName, nif, age);
        nurses.add(nurse);
        menu();
    }
    
    private void removeNurse(){
        System.out.println("Introduzca el dni del enfermero");
        String nurseNif = scanner.nextLine();
        Nurse foundNurse = searchNurseNif(nurses, nurseNif);
        nurses.remove(foundNurse);
        System.out.println("Enfermero con dni " + nurseNif + " dado de baja");
        menu();
    }
    
    private void printNursesList(){
        Iterator<Nurse> it = nurses.iterator();
        while(it.hasNext()){
            Nurse i = it.next();
            System.out.println(i.toString());
        }
        menu();
    }
    
    public void registerStudent(){
        int selectStudent;
        System.out.println("Introduzca nombre completo");
        String fullName = scanner.nextLine();
        System.out.println("Introduzca dni");
        String nif = scanner.nextLine();
        System.out.println("Introduzca edad");
        int age = scanner.nextInt();
        System.out.println("Introduzca el numero correspondiente a la especialidad (Digestivo(1), Cardiología(2), Cirugía General(3), Dermatología(4), Medicina Interna(5), Oncología(6), Oftalmología(7), Psiquiatría(8), Traumatología(9))");
        do{
            selectStudent = scanner.nextInt();
            scanner.nextLine();
            switch(selectStudent){   
                case 1:
                    Speciality digestive = Speciality.DIGESTIVE;
                    Student digestiveStudent = new Student(fullName, nif, age, digestive);
                    trainingUnit.addStudent(digestiveStudent);
                    System.out.println("Estudiante Digestivo dado de alta");
                    menu();
                break;
                case 2:
                    Speciality cardiology = Speciality.CARDIOLOGY;
                    Student cardiologyStudent = new Student(fullName, nif, age, cardiology);
                    trainingUnit.addStudent(cardiologyStudent);
                    System.out.println("Estudiante Cardiología dado de alta");
                    menu();
                break;        
                case 3:
                    Speciality surgery = Speciality.SURGERY;
                    Student surgeryStudent = new Student(fullName, nif, age, surgery);
                    trainingUnit.addStudent(surgeryStudent);
                    System.out.println("Estudiante Cirugía General dado de alta");
                    menu();
                break;        
                case 4:
                    Speciality dermatology = Speciality.DERMATOLOGY;
                    Student dermatologyStudent = new Student(fullName, nif, age, dermatology);
                    trainingUnit.addStudent(dermatologyStudent);
                    System.out.println("Estudiante Dermatología dado de alta");
                    menu();
                break;        
                case 5:
                    Speciality internal = Speciality.INTERNAL;
                    Student internalStudent = new Student(fullName, nif, age, internal);
                    trainingUnit.addStudent(internalStudent);
                    System.out.println("Estudiante Medicina Interna dado de alta");
                    menu();
                break;        
                case 6:
                    Speciality oncology = Speciality.ONCOLOGY;
                    Student oncologyStudent = new Student(fullName, nif, age, oncology);
                    trainingUnit.addStudent(oncologyStudent);
                    System.out.println("Estudiante Oncología dado de alta");
                    menu();
                break;        
                case 7:
                    Speciality ophthalmology = Speciality.OPHTHALMOLOGY;
                    Student ophthalmologyStudent = new Student(fullName, nif, age, ophthalmology);
                    trainingUnit.addStudent(ophthalmologyStudent);
                    System.out.println("Estudiante Oftalmología dado de alta");
                    menu();
                break;        
                case 8:
                    Speciality psychiatry = Speciality.PSYCHIATRY;
                    Student psychiatryStudent = new Student(fullName, nif, age, psychiatry);
                    trainingUnit.addStudent(psychiatryStudent);
                    System.out.println("Psiquiatra dado de alta");
                    menu();
                break;        
                case 9:
                    Speciality traumatology = Speciality.TRAUMATOLOGY;
                    Student traumatologyStudent = new Student(fullName, nif, age, traumatology);
                    trainingUnit.addStudent(traumatologyStudent);
                    System.out.println("Estudiante Traumatología dado de alta");
                    menu();
                break;    
                default:
                    System.out.println("Opción no válida, introduzca un número del 1 al 9");
                    menu();
            }                               
        }while (selectStudent > 9 || selectStudent < 1);
    } 
    
    private void printStudentsList(){
        Iterator<Student> it = trainingUnit.iterator();
        while(it.hasNext()){
            Student i = it.next();
            System.out.println(i.toString());
        }
        menu();
    }
    
    public void assignLabsNum(){
        System.out.println("Ingrese el numero de laboratorios");
        labs = scanner.nextInt();
    }
    
    private void registerPatient(){
        int selectPatType;
        int selectPatSpeciality;
        System.out.println("Introduzca nombre completo");
        String fullName = scanner.nextLine();
        System.out.println("Introduzca dni");
        String nif = scanner.nextLine();
        System.out.println("Introduzca edad");
        int age = scanner.nextInt();
        System.out.println("Introduzca el numero correspondiente al tipo de paciente: Neonato(1), Niño(2), Adulto(3)");
        do{
            selectPatType = scanner.nextInt();
            scanner.nextLine();
            switch(selectPatType){   
                case 1:
                    Patient newbornPatient = new NewbornPatient(fullName, nif, age);
                    patients.add(newbornPatient);
                    System.out.println("Paciente dado de alta");
                    menu();
                break;   
                case 2:
                    Patient childPatient = new ChildPatient(fullName, nif, age);
                    patients.add(childPatient);
                    System.out.println("Paciente dado de alta");
                    menu();
                break;        
                case 3:
                    Patient adultPatient = new AdultPatient(fullName, nif, age);
                    patients.add(adultPatient);
                    System.out.println("Paciente dado de alta");
                    menu();
                break;
                default:
                    System.out.println("Opción no válida, introduzca un número del 1 al 3");
                    menu();
            }
    
                
        }while (selectPatType > 3 || selectPatType < 1);
    } 
    
     private void printPatientsList(){
        Iterator<Patient> it = patients.iterator();
        while(it.hasNext()){
            Patient i = it.next();
            System.out.println(i.toString());
        }
        menu();
    }
    
    private void assignConsultation(){
        System.out.println("Introduzca el dni del paciente");
        String patientNif = scanner.nextLine();
        Patient foundPatient = searchPatientNif(patients, patientNif);
        
        System.out.println("Introduzca el dni del doctor");
        String doctorNif = scanner.nextLine();
        Doctor foundDoctor = searchDoctorNif(doctors, doctorNif);
        
        System.out.println("Introduzca la fecha y la hora de la consulta (MM dd yyyy HH mm)");
        String userInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy HH mm");
        LocalDate consultationDate = LocalDate.parse(userInput, formatter);
        LocalTime consultationTime = LocalTime.parse(userInput, formatter);
        System.out.println("Introduzca la duración de la cita en minutos");
        int duration = scanner.nextInt();

        System.out.println("Fecha introducida: " + consultationDate);
        System.out.println("Hora introducida: " + consultationTime);
        
        ConsultationSession consultationSession = new ConsultationSession(foundPatient, foundDoctor, consultationDate, consultationTime, duration);
        
        menu();
    }   
    
    private void emergencyRoom(){
        System.out.println("Introduzca el dni del paciente");
        String patientNif = scanner.nextLine();
        Patient foundPatient = searchPatientNif(patients, patientNif);
        
        Random rand = new Random();
        int max = 1, min = 0;
        int randomNum = rand.nextInt(max - min + 1) + min; 
        //se elige aleatoriamente si el paciente necesita ir a la UCI o puede ir a su casa, en un hospital real esto se decidiría tras un diagnóstico
        
        if(randomNum == 1){
            System.out.println("Introduzca el dni del enfermero supervisor");
            String nurseNif = scanner.nextLine();
            Nurse foundNurse = searchNurseNif(nurses, nurseNif);
           
            UciRoom uciRoom = new UciRoom(uciNumber, foundPatient, foundNurse);
            uciRooms.add(uciRoom);
            System.out.println("Paciente admitido en la UCI");
            uciNumber++; 
            
            menu(); 
        }else{
            System.out.println("El paciente puede volver a casa");
            menu();
        }
    }
    
    private void printUciRoomsList(){
        Iterator<UciRoom> it = uciRooms.iterator();
        while(it.hasNext()){
            UciRoom i = it.next();
            System.out.println(i.toString());
        }
        //volver al menú
        menu();
    }
}

