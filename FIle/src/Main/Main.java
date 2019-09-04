package Main;

import File_all.File_main;
import File_all.File_text;

public class Main {

    public static void main(String[] args) {

        File_main file_main = new File_main();
        File_text file_text = new File_text();

        file_main.create("asda.txt");
        file_main.create("zxc.txt");

        file_main.delete("asda.txt");

        file_main.reName("zxc.txt","qwerty.txt");

        file_text.read("qwerty.txt");
    }
}
