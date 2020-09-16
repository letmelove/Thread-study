package com.lambda;

public class LambdaDemo {

    //将like简化为静态内部类
    static class like2 implements Lambda{
        @Override
        public void study() {
            System.out.println("学习lambda2");
        }
    }
    public static void main(String[] args) {
        Lambda l=new Like();
        l.study();
        l=new like2();
        l.study();

        //将like2简化为局部内部类
        class like3 implements Lambda{
            @Override
            public void study() {
                System.out.println("学习lambda3");
            }
        }

        l=new like3();
        l.study();
        //匿名内部类，需要通过接口或者父类来实现
        l=new Lambda(){
            @Override
            public void study() {
                System.out.println("学习lambda4");
            }
        };
        l.study();

        //使用lamdba简化
        l=()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };
        l.study();
    }
}

interface Lambda{
    void study();
}

class Like implements Lambda{
    @Override
    public void study() {
        System.out.println("学习lambda");
    }
}
