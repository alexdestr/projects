package Archive;

import Student.*;

import java.util.ArrayList;

public class Archive {

    ArrayList<Student> spisokStudentov = new ArrayList<>();

    public void addStudentToList(Student s) {
        spisokStudentov.add(s);
    }

    public Student getStudentByID(int id) {
       return spisokStudentov.get(id);
    }

    public int getBall(Student s) {
        return s.getOcenka();
    }

    public String getKurs(Student s) throws RegistrException {
        if (s.getKurs() != null) {
            return s.getKurs();
        }
        else if (s.getKurs() == null) {
            throw new RegistrException("Набор на данный курс закрыт или еще не был открыт.");
        }
        return "Eror";
    }

}
