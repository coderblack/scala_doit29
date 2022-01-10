package cn.doit.edu.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(3);
        lst.add(2);
        lst.add(7);

        Iterator<Integer> iter = lst.iterator();
        while(iter.hasNext()){
            Integer ele = iter.next();
            System.out.println(ele);
        }

        for(Integer i : lst){
            System.out.println(i);
        }


        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(4);
        set.add(2);

        Iterator<Integer> iter2 = set.iterator();
        while(iter2.hasNext()){
            Integer ele = iter2.next();
            System.out.println(ele);
        }


    }
}
