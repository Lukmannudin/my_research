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
public class orderedPair<K,V> implements pair<K,V> {
    
    private K key;
    private V value;
    
    public orderedPair(K key, V value){
        this.key = key;
        this.value = value;
    }
    
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
    
}
