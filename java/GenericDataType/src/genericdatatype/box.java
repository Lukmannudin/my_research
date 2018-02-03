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
public class box<T> {
   // T Stands for type "Type"
    private T t;
    
    public void set(T t){
        this.t = t;
    }
    
    public T get(){
        return t;
    }
}
