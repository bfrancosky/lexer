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
public class Token {
    public int type;
    public String text;
    
    public Token(int type, String text){
        this.type = type;
        this.text = text;
    
    }
    
    
    public String toString(){
        String tname = LookaheadLexer.tokenNames[type];
        return "<'"+text+"',"+tname+">";
        
    }
}
