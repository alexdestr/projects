package File_all;

import java.io.*;

public class File_text extends File_main {

    public void read(String name) {
        this.file = new File(pathName);
        String line = "";
        try {
            BufferedReader br  = new BufferedReader(
                    new InputStreamReader(new FileInputStream(pathName + name),"Cp1251"));
            while ( ( line = br.readLine() ) != null ) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            File directory = new File(String.valueOf(pathName));

            if(!directory.exists()){

                directory.mkdir();
                if(!file.exists() ){
                    file.getParentFile().mkdir();
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
