/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articlesummariser;

import java.util.*;
import java.lang.*;


/**
 *
 * @author Carim A
 */
public class markovChain {
    markovChainNode root;
    String[] items;
    
    public markovChain(String article) {
        this.items = article.toLowerCase().split(" ");
        this.root = new markovChainNode("");
    }
    
    public void addWord(String word) {
        this.root.addSuccessor(word);
    }
}
