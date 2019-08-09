package Kurs;

import java.util.ArrayList;

import Prepodavatel.Prepodavatel;
import Student.Student;


public class Kurs {

    public static ArrayList getKursi() {
        return kursi;
    }

    public static void setKursi(ArrayList kursi) {
        Kurs.kursi = kursi;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static ArrayList<String> kursi = new ArrayList<String>();

//    private String kursName;
//    private boolean isAvaible = false;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void addKurs(String kursName) {
       kursi.add(kursName);
    }

    public String getKursByID(int id) {
       return kursi.get(id);
    }

    public int getSize() {
       return kursi.size();
    }




}
