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
            String word = items[i].trim();
            markovChainNode temp = root.getNode(word);
            if (temp == null)
                temp = new markovChainNode(word);
            
            root.addSuccessor(temp.getData());   
            
            if (i < items.length - 1)
                root.getNode(word).addSuccessor(items[i + 1]);
            
        }
    }
    
    String generateFrequentSentence() {
        int count = 0;
        String temp = this.root.getMostFrequentNode().getData();
        String output = "";
        markovChainNode n = this.root.getNode(temp);
        while (count < 250 && n != null) {
            output += temp + " ";
            //System.out.println(output);
            //System.out.println(temp);
            n = this.root.getNode(temp);
            //System.out.println(n.toString(0));
            temp = n.getMostFrequentNode().getData();
            count++;
        }
        
        return output;
    }
    
    String generateWeightedRandomSentence() {
        int count = 0;
        String temp = this.root.getWeightedRandomNode().getData();
        String output = "";
        markovChainNode n = this.root.getNode(temp);
        while (count < 250 && n != null) {
            output += temp + " ";
            //System.out.println(output);
            //System.out.println(temp);
            n = this.root.getNode(temp);
            //System.out.println(n.toString(0));
            temp = n.getWeightedRandomNode().getData();
            count++;
        }
        
        return output;
    }
}
