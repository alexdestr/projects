package Account;

import java.util.ArrayList;

public class Account {

    private static long counter;
    private long ID;

    private String name;
    private String password;
    private float account;
    private Logs lgs;

    public Account(String name, String password, float account) {
        this.ID = counter;
        counter++;

        this.name = name;
        this.password = password;
        this.account = account;

        lgs = new Logs();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void allLogs() {
        System.out.println("----" + getName() + "----");
        for (int i = 0; i < lgs.size(); i++) {
            lgs.getFromLogs(i).printAllLogs();
        }
    }

    public long getID() {

        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getAccount() {
        return account;
    }

    public void setAccount(float account) {
        this.account = account;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void put(float sum) {                                         // Положить
        this.account += sum;
        lgs.addToLogs(new Log(sum, this.account));
    }

    public void takeOff(float sum, String pass) {                                     // Снять
        if (this.password.equals(pass)) {
            this.account -= sum;
            lgs.addToLogs(new Log(1, sum, this.account));
            return;
        }
        lgs.addToLogs(new Log("Eror"));
    }

    public void pay(Account a, float sum) {                                         // Перевод
        this.account -= sum;
        a.setAccount(a.getAccount() + sum);
        lgs.addToLogs(new Log(a, sum, this.account));
        a.lgs.addToLogs(new Log(sum, a.account));
    }

    public void payBill(String shop, float sum) {                                         // Оплатить
        this.account -= sum;
        lgs.addToLogs(new Log(shop, sum, this.account));
    }

}

class Log {

    String name;
    Account a;
    float sum;
    float ostatok;
    String action;
    String shopName;

    public Log(Account a, float sum, float ostatok) {
        this.a = a;
        this.sum += sum;
        this.ostatok += ostatok;
        this.action = "Перевод";
    }

    public Log(int b, float sum, float ostatok) {
        this.name = name;
        this.sum += sum;
        this.ostatok += ostatok;
        this.action = "Снятие";
    }

    public Log(String shopName, float sum, float ostatok) {
        this.shopName = shopName;
        this.sum += sum;
        this.ostatok += ostatok;
        this.action = "Оплата";
    }

    public Log(float sum, float ostatok) {
        this.shopName = shopName;
        this.name = name;
        this.sum += sum;
        this.ostatok += ostatok;
        this.action = "Пополнение";
    }

    public Log(String eror) {
        this.action = "Ошибка доступа";
    }

    public void printAllLogs() {
        if (name != null) {
            System.out.println(name);
        }
        if (a != null) {
            System.out.println(a);
        }
        System.out.println("Количество: " + sum);
        System.out.println("Остаток на счету: " + ostatok);
        System.out.println("Действие: " + action);
        if (shopName != null) {
            System.out.println("Место: " + shopName);
        }
        System.out.println("-----------------");
    }

}

class Logs {

    private ArrayList<Log> logs = new ArrayList<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void addToLogs(Log o) {
        logs.add(o);
    }

    public Log getFromLogs(int ID) {
        return logs.get(ID);
    }

    public int size() {
        return logs.size();
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}