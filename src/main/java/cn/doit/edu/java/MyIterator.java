package cn.doit.edu.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


class SoliderIterator implements Iterator<Soldier> {
    BufferedReader br = null;
    String line = null;

    public SoliderIterator() {
        try {
            br = new BufferedReader(new FileReader("data/sanguo.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        try {
            line = br.readLine();
            boolean b = line != null;
            if(!b) br.close();
            return  b;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Soldier next() {
        // 1_张飞:28,100
        String[] split = line.split("_");
        String[] split1 = split[1].split(":");
        String[] split2 = split1[1].split(",");
        Soldier s = new Soldier(Integer.parseInt(split[0]),split1[0],Integer.parseInt(split2[0]),Integer.parseInt(split2[1]));
        return s;
    }
}

class Soldier {
    private int id;
    private String name;
    private int age;
    private int power;

    public Soldier() {
    }

    public Soldier(int id, String name, int age, int power) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", power=" + power +
                '}';
    }
}

class SoldierList implements Iterable<Soldier>{
    @Override
    public Iterator<Soldier> iterator() {
        return new SoliderIterator();
    }
}



public class MyIterator {
    public static void main(String[] args) throws FileNotFoundException {

        Iterator<Soldier> iter = new SoliderIterator();
        while(iter.hasNext()){
            Soldier soldier = iter.next();
            System.out.println(soldier);
        }

        SoldierList soldiers = new SoldierList();
        /**Iterator<Soldier> it = soldiers.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/

        for (Soldier soldier : soldiers) {

        }

    }
}