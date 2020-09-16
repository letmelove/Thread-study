package com.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 创建线程的方式三：实现callable接口
 * 可以定义返回值
 * 可以抛出异常
 */
public class CallableDemo implements Callable<Boolean> {

    private String url; //网络图片地址
    private String name;//保存的文件名

    public CallableDemo(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoader3 webDownLoader3=new WebDownLoader3();
        webDownLoader3.downLoader(url,name);
        System.out.println("下载的图片为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo cd1=new CallableDemo("http://browser9.qhimg.com/bdm/683_422_0/t010824ab8b5cdfa138.jpg","7.jpg");
        CallableDemo cd2=new CallableDemo("http://browser9.qhimg.com/bdm/341_210_0/t01753453b660de14e9.jpg","8.jpg");
        CallableDemo cd3=new CallableDemo("http://browser9.qhimg.com/bdm/341_210_0/t01bbd94b90e850d1d3.jpg","9.jpg");

        //创建执行服务  这里相当于是创建了线程池
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(cd1);
        Future<Boolean> r2 = ser.submit(cd2);
        Future<Boolean> r3 = ser.submit(cd3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        //关闭服务
        ser.shutdown();
    }
}
/**
 * 下载器
 */
class WebDownLoader3{
    /**
     * 下载方法
     * @param url 地址
     * @param name 文件名
     */
    public void downLoader(String url,String name){
        try {
            //copyURLToFile:把地址变成一个文件
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常downLoader方法出错");
        }
    }
}