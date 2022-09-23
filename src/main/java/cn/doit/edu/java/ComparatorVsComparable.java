package cn.doit.edu.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorVsComparable {

    // 冒泡排序
    public static void sortStu(List<Stu> stuList, Comparator<Stu> comparator){
        for(int i=0;i<stuList.size()-1;i++){
            for(int j=0;j<stuList.size()-i-1;j++){
                //if(stuList.get(j) > stuList.get(j+1)){
                if(comparator.compare(stuList.get(j),stuList.get(j+1))>0){
                    // 如果第 j 个元素  大于  第j+1 元素，则调换顺序
                    Stu tmp = stuList.get(j+1);
                    stuList.set(j+1,stuList.get(j));
                    stuList.set(j,tmp);
                }
            }
        }

    }


    // 冒泡排序
    public static void sortStu2(List<Stu> stuList){
        for(int i=0;i<stuList.size()-1;i++){
            for(int j=0;j<stuList.size()-i-1;j++){

                Stu stuJ1 = stuList.get(j);
                Stu stuJ2 = stuList.get(j+1);

                if(stuJ1.compareTo(stuJ2)>0){
                    // 如果第 j 个元素  大于  第j+1 元素，则调换顺序
                    Stu tmp = stuList.get(j+1);
                    stuList.set(j+1,stuList.get(j));
                    stuList.set(j,tmp);
                }
            }
        }

    }



    public static void main(String[] args) {

        Stu s1 = new Stu("张三", 19, 160);
        Stu s2 = new Stu("李四", 29, 170);
        Stu s3 = new Stu("王五", 16, 180);
        Stu s4 = new Stu("赵六", 18, 175);

        List<Stu> stuList = Arrays.asList(s1, s2, s3, s4);

        sortStu(stuList, new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {

                /*if(o1.getAge()> o2.getAge()){
                    return 1;
                }else if(o1.getAge() == o2.getAge()){
                    return 0;
                }else{
                    return -1;
                }*/

                //return o1.getAge() -  o2.getAge();

                return Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        System.out.println(stuList);


        sortStu(stuList, new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                return Integer.compare(o1.getHeight(),o2.getHeight());
            }
        });
        System.out.println(stuList);





    }

}


class Stu implements Comparable<Stu>{

    private String name;
    private int age;
    private int height;

    public Stu(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Stu o) {
        return Integer.compare(this.age,o.getAge());
    }
}
