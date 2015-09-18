/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articlesummariser;
import java.util.ArrayList;

/**
 *
 * @author Carim A
 */
public class markovChainNode {
    public String data;
    public int count;
    ArrayList<markovChainNode> successors;
    
    public String getData() { return this.data; }
    public int getCount() { return this.count; }
    
    public void setData(String data) { this.data = data; }
    public void setCount(int count){ this.count = count; }
    public void incrementCount() { this.count++; }
    
    public markovChainNode(String word) {
        this.data = word;
        this.count = 1;
        this.successors = new ArrayList<markovChainNode>();
    }
    
    public void addSuccessor(String word) {
        boolean found = false;
        // check if word exists.
        for (markovChainNode mCN : successors) {
            if (mCN.getData().equals(word)) {
                found = true;
                break;
            }
        }
  
        if (!found)
            // it doesn't exist, therefore it needs to be added.
            successors.add(new markovChainNode(word));
        else
            // it does exist, therefore the count should be incremented.
            for (markovChainNode mCN : successors) {
                if (mCN.getData().equals(word)) {
                    mCN.incrementCount();
                }
            }
    }
}
