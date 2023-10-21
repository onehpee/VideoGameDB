package org.example.Repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RepoInfo {
    protected Map<String,String> readFile() {
        Map<String,String> databaseinfo = new HashMap<>();
        try {
            File myObj = new File("databaseinfo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] info = data.split(":");
                databaseinfo.put(info[0].trim(),info[1].trim());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return databaseinfo;
    }
}
