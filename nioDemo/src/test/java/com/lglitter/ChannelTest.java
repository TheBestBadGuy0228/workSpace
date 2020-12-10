package com.lglitter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

    @Test
    public void Test1() throws IOException {
        //创建一个随机访问的文件流从"D:/nio-data.txt"中读取，并指定读写权限
        RandomAccessFile afile = new RandomAccessFile("D:/nio-data.txt", "rw");
        //获取改文件的唯一fileChannel对象
        FileChannel inChannel = afile.getChannel();
        //分配一个新的字节缓冲区,容量为48个字节
        ByteBuffer buf = ByteBuffer.allocate(48);
        //从通道读取到给定缓冲区的字节序列
        int byteRead = inChannel.read(buf);
        //读取的字节数，可能为零，如果通道已达到流出端， 则为-1 ,当返回值为-1时则读取完毕
        while (byteRead != -1) {

            System.out.println("Read" + byteRead);
            //翻转缓冲区。该限制设置为当前位置，然后将该位置设置为零。 如果标记被定义，则它被丢弃。
            //在通道读取或放置操作的序列之后，调用此方法来准备一系列通道写入或相对获取操作。
            buf.flip();
            //public final boolean hasRemaining()
            //告诉当前位置和极限之间是否存在任何元素。
            //结果
            //true如果，并且只有在此缓冲区中至少有一个元素
            while (buf.hasRemaining()) {
                //获取缓冲区当前位置的字节
                System.out.println((char) buf.get());

            }
            //清除缓冲区
            buf.clear();

            byteRead = inChannel.read(buf);
        }
        //关闭此随机访问文件流并释放与流相关联的任何系统资源
        afile.close();

    }



}
