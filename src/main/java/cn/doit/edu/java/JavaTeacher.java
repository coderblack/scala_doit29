package cn.doit.edu.java;

public class JavaTeacher {
    // 类的成员是要专门定义的
    private int id;
    private String name;

    // 构造方法中的参数，本质上只是该方法的局部变量
    public JavaTeacher(int xid,String name,int age,String course){
        this.id = xid;
        this.name = name;
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
}
