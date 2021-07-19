package testPackages;

import models.Client;
import models.CustomerType;
import models.ManagerEntity;

import java.util.Iterator;

public class testadd {
    public static void main(String[] args) {
        ManagerEntity test = new ManagerEntity();

        test.addClient(new Client("Robertu", CustomerType.OLD_MAN));
        test.addClient(new Client("Agustin", CustomerType.OLD_MAN));
        test.addClient(new Client("Federico", CustomerType.OLD_MAN));
        test.addClient(new Client("Lulu", CustomerType.OLD_MAN));
        test.addClient(new Client("Assd", CustomerType.NORMAL_CUSTOMER));
        test.addClient(new Client("afghfg", CustomerType.NORMAL_CUSTOMER));
        test.addClient(new Client("Ummu", CustomerType.NORMAL_CUSTOMER));
        test.addClient(new Client("adghjhg", CustomerType.PREGNANT_WOMAN));

        Iterator<Client> ok = test.iteratorClients();
        while (ok.hasNext()){
            Client a = ok.next();
            System.out.println(a.getName());
        }
    }
}
