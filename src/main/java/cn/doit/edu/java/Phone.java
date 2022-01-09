package cn.doit.edu.java;

/**
 * 模拟  object Phone
 */
class Phone${
    static Phone$ MODULE$;
    private String name;

    private Phone$(String name){
        this.name = name;
    }

    static{
        MODULE$ = new Phone$("多易日用");
    }

    public String getName() {
        return name;
    }

}


public class Phone {
    public static String getName(){
        return Phone$.MODULE$.getName();
    }
}


class Test{
    public static void main(String[] args) {
        Phone.getName();
        Phone.getName();
        Phone.getName();
        Phone.getName();
    }
}