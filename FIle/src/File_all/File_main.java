package File_all;


import java.io.*;

public class File_main implements File_interface {

    protected String pathName = "C:\\Users\\Alex\\Desktop\\Zadanie\\";
    protected File file = new File(pathName);


    public void allGood() {
        File directory = new File(String.valueOf(pathName));

        if (!directory.exists()) {

            directory.mkdir();
            if (!file.exists()) {
                file.getParentFile().mkdir();
                try {
                    file.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }



    @Override
    public void create(String name) {
        try {
            allGood();
            file = new File(pathName + name);
            file.createNewFile();
            System.out.println("The file " + name + " " + "was successfully created");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String file) {
        allGood();
        this.file = new File(pathName + file);
        boolean st = this.file.delete();
        if ( st ) {
            System.out.println("The file " + file + " " + "was successfullt deleted.");
        }
    }

    @Override
    public void reName(String file, String newName) {
        allGood();
        File newNamed = new File(pathName + newName);
        this.file = new File(pathName + file);
        boolean st = this.file.renameTo(newNamed);
        if ( st ) {
            System.out.println("The file " + file + " was successfully renamed to " + newName);
        }
    }

}
