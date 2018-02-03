/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericdatatype;

/**
 *
 * @author Lukman
 */
public class GenericDataType {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        box<Integer> integer =  new box<>();
        integer.set(20);
        
        pair<String, Integer> p1 = new orderedPair<String, Integer>("Even", 8);
        pair<String, String> p2 =  new orderedPair<String, String>("Hello","World");
        
//        System.out.println(p1.getKey());

    orderedPair<String,box<Integer>> p = new orderedPair<>("primes", new box<Integer>());
    }
    
}
