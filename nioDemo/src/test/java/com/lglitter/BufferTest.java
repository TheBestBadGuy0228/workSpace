package com.lglitter;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * @Author TheBestBadGuy
 * 只要有我在，世界充满爱！
 * @Date 2020/12/4 10:37
 * @Email TheBestBadGuy@qq.com
 */
public class BufferTest {
    /**
     * Buffer（缓冲区）在Java NIO中负责数据的存取。缓冲区就是数组。用于存储不同的数据类型的数据
     * <p>
     * 根据不同的数据类型（Boolean除外），提供了相应类型的数据缓冲区：
     * ByteBuffer
     * CharBuffer
     * ShortBuffer
     * IntBuffer
     * LongBuffer
     * FloatBuffer
     * DoubleBuffer
     * 上述缓冲区的管理方式几乎一致，通过allocate（）方法获取
     * <p>
     * 缓冲区存取数据的核心方法：
     * put（）：存入数据到缓冲区
     * get（）：从缓冲区中获取数据
     * <p>
     * 缓冲区中的四个核心属性
     * <p>
     * capacity：容量，表阿斯缓冲区中最大存储数据的容量。一旦指定无法修改。
     * limit：界限，缓冲区中可以操作数据的大小。（limit后面的数据不能进行读写）
     * position：位置，表示缓冲区中正在操作数据的位置
     * 关系：position <= limit <= capacity
     */
    @Test
    public void Test1() {
        String str = "abcde";
        //分配一个大小为1024个字节的缓冲区
        System.out.println("-------------allocate----------------");
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

    }

}
