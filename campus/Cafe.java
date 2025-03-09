package src.uned.poo.hospital.campus;

public class Cafe {
    private int tables;
    private int clients;
    
    public Cafe(int tables){
        this.tables = tables;
        clients = 0;
    }
    
    public int getTables() {
        return tables;
    }
    
    public void setTables(int tables) {
        this.tables = tables;
    }
    
    public int getClients() {
        return clients;
    }
    
    public void setClients(int clients) {
        this.clients = clients;
    }
    
    public boolean addClient() {
        if(clients > tables) return false;
        clients++;
        return true;
    }
    
    public boolean removeClient() {
        if(clients == 0) return false;
        clients--;
        return true;
    }
}
