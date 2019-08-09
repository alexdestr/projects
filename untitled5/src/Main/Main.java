package Main;

import Archive.Archive;
import Prepodavatel.Prepodavatel;
import Student.*;
import Kurs.Kurs;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Archive archive = new Archive();
        Prepodavatel prepod = new Prepodavatel();
        Kurs krs = new Kurs();
        Student st = new Student();

        archive.addStudentToList(new Student("Bob"));
        archive.addStudentToList(new Student("Boris"));
        archive.addStudentToList(new Student("Fedor"));
        archive.addStudentToList(new Student("Semyon"));
        archive.addStudentToList(new Student("Sashenka"));

        prepod.addKurs("Karmannoi tyagi");
        prepod.addKurs("Roflan Pominok");

        prepod.openRecruting("Roflan Pominok");

            archive.getStudentByID(1).registration("Roflan Pominok");
            archive.getStudentByID(2).registration("Roflan Pominok");

            archive.getStudentByID(0).registration("Karmannoi tyagi");

            prepod.openRecruting("Karmannoi tyagi");

    archive.getStudentByID(3).registration("Karmannoi tyagi");
    archive.getStudentByID(4).registration("Karmannoi tyagi");

        prepod.postavitBall(archive.getStudentByID(0),1);
        prepod.postavitBall(archive.getStudentByID(1),2);
        prepod.postavitBall(archive.getStudentByID(2),5);
        prepod.postavitBall(archive.getStudentByID(3),7);
        prepod.postavitBall(archive.getStudentByID(4),10);

        System.out.println(archive.getBall(archive.getStudentByID(0)));
        System.out.println(archive.getBall(archive.getStudentByID(1)));
        System.out.println(archive.getBall(archive.getStudentByID(2)));
        System.out.println(archive.getBall(archive.getStudentByID(3)));
        System.out.println(archive.getBall(archive.getStudentByID(4)));

        try {
            System.out.println(archive.getKurs(archive.getStudentByID(0)));
        }
        catch (RegistrException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(archive.getKurs(archive.getStudentByID(1)));
        }
        catch (RegistrException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(archive.getKurs(archive.getStudentByID(2)));
        }
        catch (RegistrException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(archive.getKurs(archive.getStudentByID(3)));
        }
        catch (RegistrException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(archive.getKurs(archive.getStudentByID(4)));
        }
        catch (RegistrException e) {
            System.out.println(e.getMessage());
        }


//        System.out.println(prepod.getKursByID(0));
//        System.out.println(prepod.getKursByID(1));

          }
}
