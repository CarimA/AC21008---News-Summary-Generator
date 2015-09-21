/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package articlesummariser;

/**
 *
 * @author Carim A
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        markovChain mc = new markovChain("Randomness is the lack of pattern or predictability in events. A random sequence of events, symbols or steps has no order and does not follow an intelligible pattern or combination. Individual random events are by definition unpredictable, but in many cases the frequency of different outcomes over a large number of events (or \"trials\") is predictable. For example, when throwing two dice, the outcome of any particular roll is unpredictable, but a sum of 7 will occur twice as often as 4. In this view, randomness is a measure of uncertainty of an outcome, rather than haphazardness, and applies to concepts of chance, probability, and information entropy." +
"The fields of mathematics, probability, and statistics use formal definitions of randomness. In statistics, a random variable is an assignment of a numerical value to each possible outcome of an event space. This association facilitates the identification and the calculation of probabilities of the events. Random variables can appear in random sequences. A random process is a sequence of random variables whose outcomes do not follow a deterministic pattern, but follow an evolution described by probability distributions. These and other constructs are extremely useful in probability theory and the various applications of randomness." +
"Randomness is most often used in statistics to signify well-defined statistical properties. Monte Carlo methods, which rely on random input (such as from random number generators or pseudorandom number generators), are important techniques in science, as, for instance, in computational science.[2] By analogy, quasi-Monte Carlo methods use quasirandom number generators." +
"Random selection is a method of selecting items (often called units) from a population where the probability of choosing a specific item is the proportion of those items in the population. For example, with a bowl containing just 10 red marbles and 90 blue marbles, a random selection mechanism would choose a red marble with probability 1/10. Note that a random selection mechanism that selected 10 marbles from this bowl would not necessarily result in 1 red and 9 blue. In situations where a population consists of items that are distinguishable, a random selection mechanism requires equal probabilities for any item to be chosen. That is, if the selection process is such that each member of a population, of say research subjects, has the same probability of being chosen then we can say the selection process is random.");
        
        
        System.out.println(mc.root.toString());
    }
    
}
