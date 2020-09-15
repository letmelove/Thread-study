package com.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class RunnableDemo2 implements Runnable {

    private String url; //网络图片地址
    private String name;//保存的文件名

    public  RunnableDemo2(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownLoader2 webDownLoader2=new WebDownLoader2();
        webDownLoader2.downLoader(url,name);
        System.out.println("下载图片："+name);
    }

    public static void main(String[] args) {
        RunnableDemo2 rd1=new RunnableDemo2("http://p2.qhimg.com/bdm/341_210_0/t01d63566f7230c9c9d.jpg","4.jpg");
        RunnableDemo2 rd2=new RunnableDemo2("http://p7.qhimg.com/bdm/341_210_0/t0162fd553bb21bdfc6.jpg","5.jpg");
        RunnableDemo2 rd3=new RunnableDemo2("http://p0.qhimg.com/bdm/341_210_0/t01db9a77898eda663f.jpg","6.jpg");
        new Thread(rd1).start();
        new Thread(rd2).start();
        new Thread(rd3).start();
    }
}
/**
 * 下载器
 */
class WebDownLoader2{
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
