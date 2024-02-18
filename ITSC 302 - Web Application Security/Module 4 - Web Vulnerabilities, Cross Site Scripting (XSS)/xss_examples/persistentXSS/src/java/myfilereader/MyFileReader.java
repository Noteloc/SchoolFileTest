/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfilereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class MyFileReader {
    
    public String readFile(String filename) throws FileNotFoundException
    {
        String fileData="";
        
        File f = new File(filename);
        Scanner s = new Scanner(f);
        
        while (s.hasNext())
        {
            fileData = fileData + s.nextLine();
        }
        
        s.close();
        
        return fileData;
    }
}
