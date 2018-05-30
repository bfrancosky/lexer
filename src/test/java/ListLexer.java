/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import java.util.regex.*;
/**
 *
 * @author Brian
 */
public class ListLexer extends Lexer{
    int FLAG=1;
    public static int ID = 2;
    public static int LBRACK = 3;
    public static int RBRACK = 4;
    public static int OPTIONAL = 5;
    public static int EQUALS = 6;
    public static int LBRACE = 7;
    public static int RBRACE = 8;
    public static int COMMENT = 9;
    public static int ARROW = 10;
    public static int PERIOD = 11;
    public static int NUMBER = 12;
    public static int COLON = 12;
    public static int SEMIC = 12;
    
    
    public static String[] terminalNames = { "strict", "graph", "diagraph", "node",
        "edge", "subgraph", "n", "ne", "e", "se", "s", "sw", "w", "nw", "c"};
    public static String[] tokenNames = 
    { "n/a", "<EOF>", "ID", "LBRACK", "RBRACK", "OPTIONAL", "EQUALS", "LBRACE", 
        "RBRACE", "COMMENT", "ARROW", "PERIOD", "NUMBER", "COLON", "SEMIC",
    };
    public String getTokenName(int x) {return tokenNames[x]; }
    
    public ListLexer(String input) {super(input);}
    
    boolean isLETTER() { return c>='a'&&c<='z' || c>='A'&&c<='Z'; }
    
    boolean isNUMBER() { return c<=0; }
    
    boolean isID() { 
        //System.out.println("In isID");
        Pattern p = Pattern.compile("[a-zA-z]");
        if (Character.toString(c).matches("^[A-Za-z_-][A-Za-z0-9_-]*$")) {
            return true;
        } 
        return false;
    }
        
    boolean isOPTIONAL() { 
        if (c=='['){
            return true;
        } 
        return false;
    }
    

public Token nextToken(){
    System.out.println("Working on " + c);
    while ( c != EOF ) {
        switch (c) {
            case ' ': case '\t': case '\n': case '\r': WS(); continue;  
            case '1': case '2': case '3': case '4': case '5': case '6': case '7':
                    case '8': case '9': case '0': NUMBER(); continue;     
            //case '[': match('['); LOPTIONAL(); ROPTIONAL();
            case '[': consume(); return new Token(LBRACE, "[");
            //case '[': match('['); isID(); return new Token(LBRACE, "[");
            case ':': consume(); return new Token(COLON, ":");
            case ';': consume(); return new Token(SEMIC, ";");
            case '{': consume(); return new Token(LBRACK, "{");
            case '}': consume(); return new Token(RBRACK, "}");
            case '=': consume(); return new Token(EQUALS, "=");
            case '/': consume(); match('*'); return new Token(COMMENT, "/");
            case '*': consume(); return new Token(COMMENT, "/");
            case '.': consume(); return new Token(PERIOD, "/");
            case '-': consume(); match('>'); return new Token(ARROW, "-");
            
            default: 
                
                if (isID()) return ID(); 
                if (isNUMBER()) return NUMBER();
                throw new Error("invalid character: " +c);
        }
    }
    return new Token(EOF_TYPE, "<EOF>");
}

Token ID() {
    StringBuilder buf = new StringBuilder();
    do {   
        System.out.println("Building [" + buf + "]");
        buf.append(c);
        consume(); 
    } while ( isID() );

    return new Token(ID, buf.toString());
    }

Token NUMBER() {
    StringBuilder buf = new StringBuilder();
        do {   
        buf.append(c);
        consume(); 
    } while ( isNUMBER() );
    
    return new Token(NUMBER, buf.toString());
}

Token LBRACE(){
    
    return new Token(LBRACE, "[");
}

Token EQUALS(){
    consume();
    return new Token(EQUALS, "=");
}

Token LBRACK(){

    return new Token(LBRACK, "{");
    
}

Token RBRACK(){

    consume();
    return new Token(RBRACK, "}");
}

Token LOPTIONAL() {
    StringBuilder lbuf = new StringBuilder();
    do {
        lbuf.append(c);
        consume();
    } while ( isID() );
    match('='); //System.out.println("EQUALS");
    return new Token(ID, lbuf.toString());
}

Token ROPTIONAL(){
    //match('='); 
    StringBuilder rbuf = new StringBuilder();
    do {  
        rbuf.append(c);
        consume();
    } while ( isID() );
    return new Token(ID, rbuf.toString());
}

Token COMMENT(){
   
    System.out.println("COMMENT");
    StringBuilder rbuf = new StringBuilder();
    do {  
        rbuf.append(c);
        consume();
    } while ( isID() );
    
    return new Token(ID, rbuf.toString());
}

void WS() {
    
    while ( c==' ' || c =='\t' || c == '\n' || c == '\r') consume();
}

}

