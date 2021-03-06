/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

/**
 *
 * @author Brian
 */
public abstract class Lexer {
    public static final char EOF = (char)-1;
    public static final int EOF_TYPE = 1;
    String input;
    int i = 0;
    char c;
    
    public Lexer(String input){
        this.input = input;
        c = input.charAt(i);
    }
   
    public void consume() {
        i++;
        if (i >= input.length() ) c = EOF;
        else c = input.charAt(i);
        
    }
    
       public void advance() {
        i++;
        if (i >= input.length() ) c = EOF;
        else c = input.charAt(i);
        
    }
    
    public void match(char x){
        if (c == x) consume();
        else throw new Error("expecting "+x+"; found "+c);
    }
    
    public abstract Token nextToken();
    abstract void WS();
    public abstract String getTokenName(int x);
    
}
