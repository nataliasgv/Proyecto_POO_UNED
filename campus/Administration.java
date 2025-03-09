package src.uned.poo.hospital.campus;

import src.uned.poo.hospital.personal.*;
import java.util.LinkedList;

public class Administration {
    String address;
    String documentation;
    String log;
    String accountant;
    int billing;
    LinkedList<Personal> humanResources;
    LinkedList<Support> supporters;
    
    public Administration(String address, String documentation, String log, String accountant, int billing, LinkedList<Personal> humanResources, LinkedList<Support> supporters) {
        this.address = address;
        this.documentation = documentation;
        this.log = log;
        this.accountant = accountant;
        this.billing = billing;
        this.humanResources = humanResources;
        this.supporters = supporters;
    }
}
