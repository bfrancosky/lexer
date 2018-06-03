/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import java.io.IOException;

/**
 *
 * @author Brian
 */
public class LookaheadParser extends Parser{
    
    public LookaheadParser (Lexer input, int k) {
        super(input, k);    
    }
    
    public void graph() {
        if ( LA(1) == LookaheadLexer.RBRACE) {
            throw new Error("EOF"); 
        }
        
        if (LA(1)==LookaheadLexer.ID && LA(2)==LookaheadLexer.ID) {
            match(LookaheadLexer.ID);
            match(LookaheadLexer.ID);
        }
        else stmt_list();
    }
    
    void stmt_list() {
        stmt(); 
        if ( LA(1) == LookaheadLexer.SEMIC) match(LookaheadLexer.SEMIC);                  
    }
    
    void stmt() {
        if (LA(1)==LookaheadLexer.ID && LA(2)==LookaheadLexer.ARROW) edge_stmt();
        else if (LA(1)==LookaheadLexer.ID && LA(2)==LookaheadLexer.LBRACK) node_stmt();
        
        else throw new Error("Expecting an ID; found"+LT(1));         
    }
    
    void attr_stmt() {
 
    }
    
    void attr_list() {
        if (LA(1) == LookaheadLexer.LBRACK){
  
            match(LookaheadLexer.LBRACK);
            do {
                
            a_list();
            
            } while ( !(LA(1)==LookaheadLexer.RBRACK));
         
            
            
        }
         
        if (LA(1) == LookaheadLexer.ID && LA(2) == LookaheadLexer.ID) {
            System.out.println("Secondary attr list condition");
            match(LookaheadLexer.ID);
            do {
                System.out.println("Secondary attr list loop");
            match(LookaheadLexer.ID);
            } while ( (LA(1)==LookaheadLexer.ID));
        }
        if ( LA(1) == LookaheadLexer.RBRACK) match(LookaheadLexer.RBRACK);
        else throw new Error("Expecting a_list or attr_list; found"+LT(1));
    }
    
    void a_list() {

        if (LA(1) == LookaheadLexer.ID && LA(2) == LookaheadLexer.EQUALS){


            match(LookaheadLexer.ID);
            match(LookaheadLexer.EQUALS);
            do {

            match(LookaheadLexer.ID); 
            if ( LA(1) == LookaheadLexer.PERIOD) match(LookaheadLexer.PERIOD);
            if ( LA(1) == LookaheadLexer.NUMBER) match(LookaheadLexer.NUMBER);
            if ( LA(1) == LookaheadLexer.PERIOD) match(LookaheadLexer.PERIOD);
            if ( LA(1) == LookaheadLexer.NUMBER) match(LookaheadLexer.NUMBER);
            if ( LA(1) == LookaheadLexer.PERIOD) match(LookaheadLexer.PERIOD);
            if ( LA(1) == LookaheadLexer.NUMBER) match(LookaheadLexer.NUMBER);
            if ( LA(1) == LookaheadLexer.PERIOD) match(LookaheadLexer.PERIOD);
            if ( LA(1) == LookaheadLexer.NUMBER) match(LookaheadLexer.NUMBER);
            if ( LA(1) == LookaheadLexer.BSLASH) match(LookaheadLexer.BSLASH);
            } while ( (LA(1)==LookaheadLexer.ID));
            
            while ( (LA(1)==LookaheadLexer.COMMA)){

                if ( LA(1) == LookaheadLexer.COMMA) match(LookaheadLexer.COMMA);

                a_list();
            }
            while ( (LA(1)==LookaheadLexer.SEMIC)){

                a_list();
            }

        }

        else throw new Error("Expecting a_list; found"+LT(1));
        
    }
    
    void edge_stmt() {
        if (LA(1)==LookaheadLexer.ID) match(LookaheadLexer.ID);edgeRHS(); 
    }
    
    void edgeRHS() {
        if ( LA(1)==LookaheadLexer.ARROW && LA(2)==LookaheadLexer.ID ){
            match(LookaheadLexer.ARROW);
            match(LookaheadLexer.ID);          
        }
        else throw new Error("Expecting arrow or ID; found"+LT(1));
    }
    
    
    void node_stmt() {
        node_id();
        attr_list();
    }
    
    void node_id() {
        if (LA(1) == LookaheadLexer.ID) match(LookaheadLexer.ID);
        else throw new Error("Expecting ID; found"+LT(1));
    }
    }
    