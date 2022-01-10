package cn.doit.edu.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Order{
    private int oid;
    private int amt;
    private int time;

    public Order(int oid, int amt, int time) {
        this.oid = oid;
        this.amt = amt;
        this.time = time;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}



class Order2 implements Comparable<Order2>{
    private int oid;
    private int amt;
    private int time;

    public Order2(int oid, int amt, int time) {
        this.oid = oid;
        this.amt = amt;
        this.time = time;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Order2 o) {
        return this.time - o.time;
    }
}


class OrderComparator1 implements Comparator<Order>{
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getAmt()-o2.getAmt();
    }
}
class OrderComparator2 implements Comparator<Order>{
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getTime()-o2.getTime();
    }
}


class SortUtil{
    public static void sort(List<Order> orders,OrderComparator1 comparator){
        for(int i=0;i<orders.size();i++){
            for (int j=0;j<orders.size()-i-1;j++){
                Order cur = orders.get(j);
                Order next = orders.get(j+1);
                // 看到了comparator的使用方式了吧！！！
                if(comparator.compare(cur,next)>0){
                    orders.set(j,next);
                    orders.set(j+1,cur);
                }
            }
        }
    }

    public static void sort(List<Order2> orders){
        for(int i=0;i<orders.size();i++){
            for (int j=0;j<orders.size()-i-1;j++){
                Order2 cur = orders.get(j);
                Order2 next = orders.get(j+1);
                // 看到了Comparable的使用方式了吧！！！
                if(cur.compareTo(next)>0){
                    orders.set(j,next);
                    orders.set(j+1,cur);
                }
            }
        }
    }

}



public class CompareDemo {

    public static void main(String[] args) {
        Order od1 = new Order(1,20,1);
        Order od2 = new Order(2,10,5);
        Order od3 = new Order(3,60,2);
        Order od4 = new Order(4,40,3);

        ArrayList<Order> orders = new ArrayList<>();
        orders.add(od1);
        orders.add(od2);
        orders.add(od3);
        orders.add(od4);

        Collections.sort(orders,new OrderComparator1());  // 按订单金额比
        Collections.sort(orders,new OrderComparator2());  // 按订单时间比


        Order2 o1 = new Order2(1,20,1);
        Order2 o2 = new Order2(2,10,5);
        Order2 o3 = new Order2(3,60,2);
        Order2 o4 = new Order2(4,40,3);
        ArrayList<Order2> orders2 = new ArrayList<>();
        orders2.add(o1);
        orders2.add(o2);
        orders2.add(o3);
        orders2.add(o4);
        Collections.sort(orders2);  // 只能按时间比了，因为比较的逻辑已经写死在了Order对象中了


    }
}
