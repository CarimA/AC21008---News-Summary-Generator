/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articlesummariser;

import java.util.*;
import java.lang.*;
import java.util.s;


/**
 *
 * @author Carim A
 */
public class markovChain {
    Set<markovChainNode> nodes;
    String[] items;
    
    public markovChain(String article) {
        this.items = article.toLowerCase().split(" ");
        this.nodes = new HashSet<markovChainNode>();
    }
    
    public void addWord(String word) {
        boolean found = false;
        // check if word exists.
        for (markovChainNode mCN : nodes) {
            if (mCN.getData().equals(word)) {
                found = true;
                break;
            }
        }
        
        if (!found)
            // it doesn't exist, therefore it needs to be added.
            nodes.add(new markovChainNode(word));
        else
            // it does exist, therefore the count should be incremented.
            for (markovChainNode mCN : nodes) {
                if (mCN.getData().equals(word)) {
                    mCN.incrementCount();
                }
            }
    }
}
