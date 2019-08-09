package Prepodavatel;

import Kurs.Kurs;
import Student.Student;

import java.util.ArrayList;

public class Prepodavatel {

    Kurs kurs = new Kurs();
    static ArrayList<String> closedKurs = new ArrayList<String>();

    public String getClosedKursById(int id) {
        return closedKurs.get(id);
    }

    public int getSizeClosedKurs() {
        int i = closedKurs.size();
        return i;
    }

    public void addKurs(String kursName) {
        kurs.addKurs(kursName);
        closedKurs.add(kursName);
    }
    public String getKursByID(int id) {
       return kurs.getKursByID(id);
    }



//    public void Init() {
//    //    ArrayList openKurs = new ArrayList<>();
//       closedKurs = kurs.kursi;
//    }

    public void openRecruting(String kursName) {
        for (int i = 0; i < closedKurs.size(); i++) {
            if (closedKurs.get(i).equals(kursName)) {
                closedKurs.set(i, "nul");
            }
        }
    }

    public void postavitBall(Student s, int ball) {
        s.setOcenka(ball);
    }



}
