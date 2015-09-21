/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articlesummariser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Carim A
 */
public class markovChainNode 
{
    public String data;
    public int count;
    ArrayList<markovChainNode> successors;
    
    public String getData() 
    { 
        return this.data; 
    }
    public int getCount() 
    { 
        return this.count; 
    }
    
    public void setData(String data) 
    { 
        this.data = data; 
    }
    public void setCount(int count)
    { 
        this.count = count; 
    }
    public void incrementCount() 
    { 
        this.count++; 
    }
    
    public markovChainNode(String word) 
    {
        this.data = word;
        this.count = 1;
        this.successors = new ArrayList<markovChainNode>();
    }
    
    public void addSuccessor(String word) 
    {
        if (this.getNode(word) == null) {
            // it doesn't exist. add it and set its count to 0.
            this.successors.add(new markovChainNode(word));
            //System.out.println("Added successor '" + word + "' to '" + this.getData() + "'");
        }
        else {
            // it exists. Incrememnt it's count.
            this.getNode(word).incrementCount();
            //System.out.println("Incremented successor '" + word + "' for '" + this.getData() + "'");
        }
        
    }
    
    markovChainNode getNode(String word) {
        for (markovChainNode mCN : this.successors) 
        {
            if (mCN.getData().equals(word))
                return mCN;
        }
        
        return null;
    }
    
    markovChainNode getMostFrequentNode() {
        int tempCount = 0;
        markovChainNode temp = null;
        
        for (markovChainNode mCN : this.successors) {
            if (mCN.getCount() > tempCount) {             
                tempCount = mCN.getCount();
                temp = mCN;
            }
            else if (mCN.getCount() == tempCount) {
                // if it's the same, have a 50/50 chance of changing   
                Random r = new Random();
                int num = r.nextInt(2);
                if (num == 1)
                {         
                    tempCount = mCN.getCount();
                    temp = mCN;
                }
            }
        }
        return temp;
    }
    
    markovChainNode getWeightedRandomNode() {        
        Random r = new Random();
        int num = r.nextInt(this.getNodeTotal());
        int count = -1;
        
        for (markovChainNode mCN : this.successors) {
            for (int i = 0; i < mCN.getNodeTotal(); i++) {
                count++;
                System.out.println(mCN.toString(0));
                if (count <= num) {
                    return mCN;
                }
            }
        }
        // shouldn't have reached this point.
        System.out.println("Reached");
        return null;
    }
    
    public String toString(int place) 
    {
        char[] charArray = new char[place * 2];
        Arrays.fill(charArray, '-');
        String str = new String(charArray);
        
        String out = str + this.getData() + "[" + this.getCount() + "]\r\n";
        for (markovChainNode mCN : this.successors)
            out += str + mCN.toString(place + 1);
        
        return out;

    /*    // if we do have successors, add them.
        String succession = successors.toArray().length == 0 ? "" : "(Successors: { " + successors.toString() + "})";
        
        return this.getData() + " [" + this.getCount() + "] " + succession;*/
    }
    
    int getNodeTotal() {
        int out = 0;
        for (markovChainNode mCN : this.successors) {
            out += mCN.getCount();
        }
        return out;
    }
}
