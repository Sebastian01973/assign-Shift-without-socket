package controllers;

import models.CustomerType;
import models.ManagerEntity;
import models.Client;
import views.Constant;
import views.JMainWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller implements ActionListener {

    private ManagerEntity managerEntity;
    private JMainWindows jMainWindows;

    public Controller(){
        managerEntity = new ManagerEntity();
        jMainWindows = new JMainWindows(this);
        addClients();
        SetLeftPanel();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Command.valueOf(e.getActionCommand())) {
            case TURN_CREATE: this.createClient(); break;
            case DELETE_TURN: this.deleteTurn(); break;
            default:
                break;
        }
    }

    private ArrayList<Client> saveArray(){
        Iterator<Client> iterator = managerEntity.iteratorClients();
        ArrayList<Client> arrayList = new ArrayList<>();
        while (iterator.hasNext()){
            Client client = iterator.next();
            arrayList.add(client);
        }
        return arrayList;
    }

    public void SetLeftPanel(){
        ArrayList<Client> ok = saveArray();
        String[] text = new String[6];
        String[] code = new String[6];
        int size = ok.size();
        for (int i = 0; i < size; i++) {
            Client aux = ok.get(i);
            if (aux != null && i < 6){
                text[i] = aux.getName();
                code[i] = aux.getTurn();
            }
        }
        jMainWindows.setLabels(text,code);
    }


    private void deleteTurn() {
        Client aux = managerEntity.delete();
        if (aux != null){
            jMainWindows.setUser(aux.getName(),aux.getTurn());
            SetLeftPanel();
        }else{
            showMessageDialog(null, Constant.NOT_SHIFT);
            jMainWindows.setUser( Constant.NONE,"-");
        }
    }

    private void createClient() {
        Client aux = jMainWindows.createClient();
        if (aux != null){
            managerEntity.addClient(aux);
            jMainWindows.setLastClient(aux.getTurn(),aux.getName());
            jMainWindows.setValues();
            SetLeftPanel();
        }else{
            showMessageDialog(null, Constant.FILL_SPACE);
        }
    }

    private void addClients() {
        managerEntity.addClient(new Client("Lola", CustomerType.NORMAL_CUSTOMER));
        managerEntity.addClient(new Client("Erneso", CustomerType.OLD_MAN));
        managerEntity.addClient(new Client("Fausto", CustomerType.OLD_MAN));
        managerEntity.addClient(new Client("Maradona", CustomerType.PREGNANT_WOMAN));
        managerEntity.addClient(new Client("Estefa", CustomerType.PREGNANT_WOMAN));
        managerEntity.addClient(new Client("David", CustomerType.NORMAL_CUSTOMER));
        managerEntity.addClient(new Client("Miguel", CustomerType.OLD_MAN));
        managerEntity.addClient(new Client("MIchi", CustomerType.PREGNANT_WOMAN));
        managerEntity.addClient(new Client("Carlo", CustomerType.NORMAL_CUSTOMER));
        managerEntity.addClient(new Client("Camilo", CustomerType.NORMAL_CUSTOMER));
    }


}
