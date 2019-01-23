package com.logmei.content.assorts.jdk8Featurs;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NIOTest {
    //读文件
    static void readFile(){
        String path = "D:\\02_WorkSpace\\nea\\logs.txt";
        FileInputStream fin = null;
        try {

            fin = new FileInputStream(new File(path));
           FileChannel channel = fin.getChannel();//获取通道
           //设置缓冲区
            int capacity = 100;//设置缓冲区容量为100字节
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);//创建缓冲区
            System.out.format("1缓冲器容量：%d;限制：%d;位置：%d\n",byteBuffer.capacity(),byteBuffer.limit(),byteBuffer.position());

            //读取内容
            int length = -1;//读到缓冲区的长度
            while ((length=channel.read(byteBuffer))!= -1){
                System.out.format("2缓冲器容量：%d;限制：%d;位置：%d\n",byteBuffer.capacity(),byteBuffer.limit(),byteBuffer.position());
                byteBuffer.flip();//必须：切换模式写-》读
                System.out.print(Charset.forName("utf-8").decode(byteBuffer));//解决中文乱码
                byteBuffer.clear();//将位置设为0，limit设置为容量，以备下次读入到缓冲区时从0开始存储
                /*byte[] bypes = byteBuffer.array();
                System.out.write(bypes,0,length);*/
                System.out.println();

                System.out.format("3缓冲器容量：%d;限制：%d;位置：%d\n",byteBuffer.capacity(),byteBuffer.limit(),byteBuffer.position());
            }
            channel.close();//通道关闭

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fin != null){
                try {
                    fin.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //写文件
    public static void writeFile(){
        String path="D:\\02_WorkSpace\\nea\\logmeiTest.txt";
        FileOutputStream fout = null;

        try {
            fout = new FileOutputStream(new File(path));
            //通道
            FileChannel channel = fout.getChannel();
            //缓冲区
            ByteBuffer byteBuffer = Charset.forName("UTF-8").encode("说了对方可加适量的空间发了啥地方科技\n，史莱克的" +
                    "风景类似款发动机sldkjflskfdjl\nskdjflkdsf,alsdkjflaskdjflskjfdkj");
            //字节缓冲区的capacity和limit会随着数据的长度而变化
            System.out.format("1缓冲器容量：%d;限制：%d;位置：%d\n",byteBuffer.capacity(),byteBuffer.limit(),byteBuffer.position());

            int length = 0;
            while ((length = channel.write(byteBuffer)) != 0){
                //注意这里不需要clear,将缓冲中的数据写入到通道后，第二次接着上次继续往下读
                System.out.println("写入的长度："+length);
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if( fout != null ){
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    //读和写
    static void readAndWrite(){
        String path1 = "D:\\02_WorkSpace\\nea\\logs1.txt";
        String path2 = "D:\\02_WorkSpace\\nea\\test.txt";
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream(new File(path1));
            fout = new FileOutputStream(new File(path2));

            //获取读取通道
            FileChannel inChannel = fin.getChannel();
            //设置缓存
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            System.out.format("1缓冲器容量：%d;限制：%d;位置：%d\n",byteBuffer.capacity(),byteBuffer.limit(),byteBuffer.position());
            //写通道
            FileChannel outChannel = fout.getChannel();

            int readLength = -1;

            while ((readLength = inChannel.read(byteBuffer))!= -1 ) {
               // System.out.format("2缓冲器容量：%d;限制：%d;位置：%d\n",byteBuffer.capacity(),byteBuffer.limit(),byteBuffer.position());
                byte[] bytes = byteBuffer.array();
                System.out.write(byteBuffer.array(),0,readLength);
                //写
                int writeLength = 0;
                byteBuffer.flip();
                while (( writeLength = outChannel.write(byteBuffer)) != 0){
                    //System.out.format("1缓冲器容量：%d;限制：%d;位置：%d\n",byteBuffer.capacity(),byteBuffer.limit(),byteBuffer.position());
                }
                byteBuffer.clear();

            }
            inChannel.close();
            outChannel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                try {
                    if(fin != null){
                        fin.close();
                    }
                    if( fout != null ) {
                        fout.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }

    public static void main(String[] args){
        readAndWrite();
    }
}
