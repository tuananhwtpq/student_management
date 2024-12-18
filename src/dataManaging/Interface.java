/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataManaging;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public interface Interface<T> {
    public int insert(T t);
    

//     public int update(String t);

    public int update(String t, String a, String b, String c);

    
    public int delete(String t);
    
    public ArrayList<T> selectAll();
    
    public T selectBId();
    
    public ArrayList<T> selectByCondition(String condition, String condition2);
}
