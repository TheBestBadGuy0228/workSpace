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
     * <p>
     * 关系：0 <= mark <= position <= limit <= capacity
     * <p>
     * * mark:标记当前的position位置，reset（）：将position恢复到mark的位置
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

        //利用put（）存入数据到缓冲区
        byteBuffer.put(str.getBytes());

        System.out.println("--------------put()----------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //切换读取模式利用flip（）方法将position从数据末尾切换到数据起点；flip()函数的作用是将写模式转变为读模式
        byteBuffer.flip();
        System.out.println("--------------flip()----------------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //利用get（）读取缓冲区中的数据
        System.out.println("--------------get()----------------------");
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //rewind()重复读/写；rewind()在读写模式下都可用，它单纯的将当前位置置0，同时取消mark标记，仅此而已；
        // 也就是说写模式下limit仍保持与Buffer容量相同，只是重头写而已；读模式下limit仍然与rewind()调用之前相同
        System.out.println("--------------rewind()----------------------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //clear（）：清空缓冲区，但是缓冲区中的数据仍然存在，
        // 但是处于“被遗忘”状态，position和limit被设置为 初始状态
        System.out.println("--------------clear()----------------------");
        byteBuffer.clear();
        System.out.println(byteBuffer.position()); //0
        System.out.println(byteBuffer.limit()); //1024
        System.out.println(byteBuffer.capacity());//1024

    }

    @Test
    public void test2() {

        String s = new String("abcde");
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(s.getBytes());
        buf.flip();
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes, 0, 2);
        System.out.println(new String(bytes, 0, 2));
        System.out.println(buf.position());

        //mark()：标记
        buf.mark();
        buf.get(bytes, 2, 2);
        System.out.println(new String(bytes, 2, 2));
        System.out.println(buf.position());
        buf.reset();
        System.out.println("--------------------reset------------------------");
        System.out.println(buf.position());
        System.out.println("--------------------clear------------------------");
        buf.clear();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
    }

    @Test
    public void test3() {

        //创建非直接缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println(allocate.isDirect()); //false
        //创建直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());//true

    }

}
