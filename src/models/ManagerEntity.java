package models;

import structures.ComparatorQueue;
import structures.PriorityQueue;

import java.util.ArrayList;
import java.util.Iterator;

public class ManagerEntity {

    private PriorityQueue<Client> listClients;
    private int[] count;

    public ManagerEntity() {
        count = new int[3];
        listClients = new PriorityQueue(3,new ComparatorQueue());
    }

    public Client getClient(){
        return listClients.peek();
    }

    public  void show(){
        listClients.show(3);
    }

    public void generateTurn(Client client,int priority){
        String[] code = {"A","E","N"};
        count[priority]++;
        client.setTurn(code[priority]+count[priority]);
    }

    public void addClient(Client client){
        int priority = client.getType().ordinal();
        generateTurn(client,priority);
        listClients.push(client,priority);
    }

    public Client createClient(String name,CustomerType type){
        return new Client(name,type);
    }

    public Client delete(){
        return listClients.poll();
    }

    public Iterator<Client> iteratorClients(){
        return listClients.iterator();
    }
}
