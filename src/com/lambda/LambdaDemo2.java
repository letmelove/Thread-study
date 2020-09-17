package com.lambda;

//lambda是1.8开始有的
public class LambdaDemo2 {


    public static void main(String[] args) {
        ILove love;

        love = (String str) -> {
            System.out.println(" i love " + str);
        };

        //简化参数类型
        love=(str)->{
            System.out.println(" i love " + str);
        };

        //去掉括号（只有一个参数的时候才可以去掉）
        love=str->{
            System.out.println(" i love " + str);
        };

        //去掉花括号（只有一行代码的时候才可以去掉）
        love=str-> System.out.println(" i love " + str);

        love.love("jk");
    }

}

//接口中只有一个方法的时候才能使用lambda表达式
interface ILove {
    void love(String str);
}