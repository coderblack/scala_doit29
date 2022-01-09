package cn.doitedu.scala.func;

public class FunctionDemo {
    public static void main(String[] args) {

        Function2 add = new Function2<Integer, Integer>() {
            @Override
            public Integer apply(Integer t1, Integer t2) {
                return t1 + t2;
            }
        };
        add.apply(3,5);

        Function2 mutiply = new Function2<Float,Float>(){
            @Override
            public Float apply(Float t1, Float t2) {
                return t1*t2;
            }
        };


        mutiply.apply(1.5,3);

    }
}
