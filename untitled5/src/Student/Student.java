package Student;

import Kurs.Kurs;
import Archive.Archive;
import Prepodavatel.Prepodavatel;

import java.util.ArrayList;

public class Student {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getOcenka() {
        return ocenka;
    }

    public void setOcenka(int ocenka) {
        this.ocenka = ocenka;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Student(String name) {
        this.name = name;

        id++;
        ID = id;
    }

    public Student() {}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private String name;
    private String kurs;
    private int ocenka;

    private long ID;
    private static long id = -1;

    Kurs krs = new Kurs();
    Archive arch = new Archive();
    ArrayList<Student> listOfStudents = new ArrayList<Student>();

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    Prepodavatel prepod = new Prepodavatel();
    private static boolean isOpen = true;

    public void registration(String kurss) {
        for (int i = 0; i < prepod.getSizeClosedKurs(); i++) {
            if (kurss.equals(prepod.getClosedKursById(i))) {
                isOpen = false;
            }
        }

        if (isOpen == true) {
            this.kurs = kurss;
        }
        isOpen = true;
   //         arch.addStudentToList(this); // а так можно было?

    }


}

