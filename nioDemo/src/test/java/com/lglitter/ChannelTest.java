package com.lglitter;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelTest {

    //transferfrom（）and transferto（）
    @Test
    public void test(){
            FileChannel inChannel = null;
            FileChannel outChannel = null;
        try {
             inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
             outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
            outChannel.transferFrom(inChannel,0,inChannel.size());

//            inChannel.transferTo(0,inChannel.size(),outChannel);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //使用直接缓冲区完成文件的复制（内存映射文件）
    @Test
    public void test3() {

        try {
            //创建相应的通道对象
            FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);
            //创建对应的内存映射文件对象
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, outChannel.size());
            //直接在物理内存缓冲区中进行数据的读写操作
            byte[] bytes = new byte[inMappedBuf.limit()];
            inMappedBuf.get(bytes);
            outMappedBuf.put(bytes);
            inChannel.close();
            outChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //非直接缓冲区进行文件复制
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fisChannel = null;
        FileChannel fosChannel = null;
        try {
            //创建对应的流对象
            fis = new FileInputStream("1.txt");

            fos = new FileOutputStream("2.txt");
            //获取对应的channel对象
            fisChannel = fis.getChannel();

            fosChannel = fos.getChannel();
            //创建非直接缓冲区对象
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            //开始读写
            while (fisChannel.read(allocate) != -1) {

                //切换写模式
                allocate.flip();
                //写数据
                fosChannel.write(allocate);
                //清除缓冲区
                allocate.clear();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fisChannel != null) {
                try {
                    fisChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fosChannel != null) {
                try {
                    fosChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

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
