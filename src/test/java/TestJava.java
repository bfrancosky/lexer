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

        ///Scanner inputStream = null;
        //Scanner inputStream = new Scanner(new File("D:\\testfile.txt"));
        BufferedReader inputStream = null;
        
        try {

            
            inputStream = new BufferedReader(new FileReader("D:\\testfile.txt"));

            String l;
            //Token t = lexer.nextToken();
            while ((l = inputStream.readLine() ) != null) {
                System.out.println("Line is " + l);
                //ListLexer lexer = new ListLexer(l);
                //Token t = lexer.nextToken();
                LookaheadLexer lexer = new LookaheadLexer(l);
                LookaheadParser parser = new LookaheadParser(lexer, 2);
                parser.graph();
                
                //while (t.type != Lexer.EOF_TYPE) {
                    //System.out.print(t);
                    //t = lexer.nextToken();
                //}
                
                //System.out.println(t);
            }
          
            /*
                inputStream = new BufferedReader(new FileReader("D:\\testfile.txt")));   
                while (inputStream.hasNext()) {
                String s = inputStream.next();
                //System.out.println("String is " + s);

                ListLexer lexer = new ListLexer(s);

                Token t = lexer.nextToken();
                System.out.println("Token is " + t);
            }
            */
            
            
            
            
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
