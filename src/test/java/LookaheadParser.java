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
public class LookaheadParser extends Parser{
    
    public LookaheadParser (Lexer input, int k) {
        super(input, k);
       
    }
    
    void graph() {
        System.out.println("Found graph");
        //System.out.println("Input - " + input.toString());
        //System.out.println("K - " + k);
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        System.out.println("LA1 - " + LT(1));
        System.out.println("LA2 - " + LT(2));
        
        if (LookaheadLexer.ID).equals("strict") 
        if (LA(1) == LookaheadLexer.ID) { };
        
        match(LookaheadLexer.LBRACE); 
        do {
            //stmt_list();
        } while (LA(1) != (LookaheadLexer.RBRACK)); 
        //else throw new Error("Expecting ID or stmt_list; found"+LT(1));
    }
    
    void stmt_list() {
        System.out.println("Found stmt_list");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        
        stmt();
       
            
                        
    }
    
    void stmt() {
        System.out.println("Found stmt");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        attr_stmt();
               
    }
    
    void attr_stmt() {
        System.out.println("Found attr_stmt");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        
      
        attr_list();
    }
    
    void attr_list() {
        System.out.println("Found attr_list");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        
            a_list();
            
        
        //else throw new Error("Expecting a_list or attr_list; found"+LT(1));
    }
    
    void a_list() {
        System.out.println("Found a_list");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        if (LA(1)==LookaheadLexer.ID) {
            match(LookaheadLexer.ID);
            
            match('=');
            match(LookaheadLexer.ID);
        }
        else throw new Error("Expecting ID or _list; found"+LT(1));
        
    }
    
    void edge_stmt() {
        System.out.println("Found edge_stmt");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        node_id();
        subgraph();
        edgeRHS();
        match(LookaheadLexer.LBRACE);
            a_list();
            match(LookaheadLexer.RBRACE);
        
    }
    
    void edgeRHS() {
        System.out.println("Found edgeRHS");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        match(LookaheadLexer.ARROW);
        node_id();
        subgraph();
        edgeRHS();
    }
    
    void node_stmt() {
        System.out.println("Found node_stmt");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        node_id();
        attr_list();
    }
    
    void node_id() {
        System.out.println("Found node_id");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        match(LookaheadLexer.ID);
        port();
    }
    
    void port() {
        System.out.println("Found port");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        match(':');
        match(LookaheadLexer.ID);
        match(':');
        compass_pt();
        
    }
    
    void subgraph() {
        System.out.println("Found subgraph");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        match(LookaheadLexer.ID);
        match(LookaheadLexer.ID);
        match('{');
        stmt_list();
        match('}');
        
    }
    
    void compass_pt() {
        System.out.println("Found compass_pt");
        System.out.println("LA1 - " + LA(1));
        System.out.println("LA2 - " + LA(2));
        
        
    }
    
    /*
    void element() {
        if ( LA(1) == LookaheadLexer.ID && LA(2)==LookaheadLexer.EQUALS ) {
            match(LookaheadLexer.ID);
            match(LookaheadLexer.EQUALS);
            match(LookaheadLexer.ID);
        }
        else if ( LA(1)==LookaheadLexer.ID ) match(LookaheadLexer.ID);
        else if ( LA(1)==LookaheadLexer.LBRACK ) list();
        else throw new Error("expecting name or list; found " +LT(1));
        
    }
    
    void list() {
        if ( LA(1) == LookaheadLexer.ID && LA(2)==LookaheadLexer.EQUALS ) {
            match(LookaheadLexer.ID);
            match(LookaheadLexer.EQUALS);
            match(LookaheadLexer.ID);
        }
        else if ( LA(1)==LookaheadLexer.ID ) match(LookaheadLexer.ID);
        else if ( LA(1)==LookaheadLexer.LBRACK ) list();
        else throw new Error("expecting name or list; found " +LT(1));
        
    }
*/

}
