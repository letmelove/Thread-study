package com.syn;

import java.lang.reflect.Modifier;

public class UnsafeBank {
    public static void main(String[] args) {
        Accounnt accounnt = new Accounnt(1000, "基金");
        Drawing drawing = new Drawing(accounnt, 50, "小明");
        Drawing drawing2 = new Drawing(accounnt, 100, "小红");

        drawing.start();
        drawing2.start();
    }
}

//账户
class Accounnt {
    //余额
    int money;
    //卡名
    String name;

    public Accounnt(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//模拟银行取款
class Drawing extends Thread {
    //账户
    Accounnt accounnt;
    //取了多少钱
    int drawingMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Accounnt accounnt, int drawingMoney, String name) {
        super(name);
        this.accounnt = accounnt;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        //这里如果直接在方上加synchronized那么锁的对象就是Drawing,但是这里应该锁的是Accounnt 所以应synchronized块
        synchronized (accounnt) {
            //判断有没有钱
            if (accounnt.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够,取不了");
                return;
            }

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-取得钱
            accounnt.money = accounnt.money - drawingMoney;
            //手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(accounnt.name + "余额为：" + accounnt.money);

            System.out.println(this.getName() + "手里的钱：" + nowMoney);
        }

    }
}