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
public class markovChain 
{
    markovChainNode root;
    String[] items;
    
    public markovChain(String article) 
    {
        this.items = article.toLowerCase().split(" ");
        this.root = new markovChainNode("");
        
        for (int i = 0; i < items.length; i++) 
        {
            markovChainNode temp = new markovChainNode(items[i]);
            if (i < items.length - 1)
                temp.addSuccessor(items[i + 1]);
            
            this.addWord(items[i]);
            if (i < items.length - 1)
                temp.addSuccessor(items[i + 1]);
            
            
            
        }
    }
    
    public void addWord(String word) 
    {
        this.root.addSuccessor(word);
    }
    
    public void addWordSuccessor(String word, String successor) 
    {
        boolean found = false;
        // check if word exists.
        for (markovChainNode mCN : this.root.successors) 
        {
            if (mCN.getData().equals(word)) 
            {
                found = true;
                break;
            }
        }
        
        if (!found)
            // it doesn't exist, therefore it needs to be added.
            this.root.successors.add(new markovChainNode(word));
        else
            // it does exist, therefore the count should be incremented.
            for (markovChainNode mCN : this.root.successors) 
            {
                if (mCN.getData().equals(word)) 
                {
                    mCN.incrementCount();
                }
            }
    }
}
