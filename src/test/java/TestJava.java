/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import java.util.*;
import java.io.*;

/**
 *
 * @author Brian
 */
public class TestJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException{

        Scanner inputStream = null;
        //Scanner inputStream = new Scanner(new File("D:\\testfile.txt"));
        //BufferedReader inStream = null;
        
        try {

            /*
            inStream = new BufferedReader(new FileReader("D:\\testfile.txt"));

            String l;
            
            while ((l = inStream.readLine() ) != null) {
                System.out.println("Found string - " + l);
                ListLexer lexer = new ListLexer(l);
                
                Token t = lexer.nextToken();
                System.out.println("Token is " + t);
            }
          */
            
                inputStream = new Scanner(new BufferedReader(new FileReader("D:\\testfile.txt")));   
                while (inputStream.hasNext()) {
                String s = inputStream.next();
                //System.out.println("String is " + s);

                ListLexer lexer = new ListLexer(s);

                Token t = lexer.nextToken();
                System.out.println("Token is " + t);
            }
            
            
            
            
            
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
