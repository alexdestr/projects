package Main;

import Account.*;

import java.io.Console;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Account boris = new Account("Boris", "Qwerty", 0.0f);
        Account denis = new Account("Denis", "1234", 0.0f);


        boris.put(100.0f);
        denis.put(50.0f);

        boris.takeOff(15.0f,"Qwerty");
        denis.takeOff(10, "12345");

        boris.pay(denis,40.0f);


        boris.allLogs();
        denis.allLogs();


        }
}


