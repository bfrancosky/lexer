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
public class ListParser extends Parser {
    
    public ListParser(Lexer input, int k) { 
        super(input, k); 
    }
    /*
    public void graph(){
        match(ListLexer.LBRACK); match(ListLexer.ID); match(ListLexer.RBRACK);
    }
    
    public void stmt(){
        match(ListLexer.ID); match(ListLexer.EQUALS); match(ListLexer.ID);
    }
    
    void stmt_list(){
        stmt();
        while( lookahead.type==ListLexer.COMMA) {
            match(ListLexer.COMMA); stmt();
        }
    }
    
    void element() {
        if (lookahead.type==ListLexer.ID ) match(ListLexer.ID);
        else if (lookahead.type==ListLexer.LBRACK ) stmt();
        else throw new Error("expecting name or list; found "+lookahead);
        }
*/
    }
    

