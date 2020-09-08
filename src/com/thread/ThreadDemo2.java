package com.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 实现多线程同步下载图片
 */
public class ThreadDemo2 extends Thread {

    private String url; //网络图片地址
    private String name;//保存的文件名

    public  ThreadDemo2(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader=new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("下载名为："+name+"的文件");
    }

    public static void main(String[] args) {
        ThreadDemo2 td1=new ThreadDemo2("http://browser9.qhimg.com/bdm/683_422_0/t013a4ed4683039d101.jpg","1.jpg");
        ThreadDemo2 td2=new ThreadDemo2("http://browser9.qhimg.com/bdm/683_422_0/t01a5211bae6d28520e.jpg","2.jpg");
        ThreadDemo2 td3=new ThreadDemo2("http://browser9.qhimg.com/bdm/341_210_0/t01039b44f7c7ca5ca3.jpg","3.jpg");
        td1.start();
        td2.start();
        td3.start();
    }
}

/**
 * 下载器
 */
class WebDownLoader{
    /**
     * 下载方法
     * @param url 地址
     * @param name 文件名
     */
    public void downLoader(String url,String name){
        try {
            //copyURLToFile:把地址变成一个文件
            FileUtils .copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常downLoader方法出错");
        }
    }
}
