package com.dayi.demo.util;


import java.util.Random;

/**
 * 该类用于生成数据库12位主键
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-24
 */
public class IdUtil {
    private static String KEYS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int PRIMARY_KEY_SIZE = 12;
    private static final int KEY_LENGTH_TIME = 8;

    /**
     * 生成主键
     *
     * @return
     */
    public static String getPrimaryKey() {
        // 当前时间戳
        long currentTime = System.currentTimeMillis();
        //  可选字符数
        int size = KEYS.length();
        StringBuilder sb = new StringBuilder("");
        int number;
        //  把当前时间戳转换成7-8位字符
        while (currentTime != 0) {
            number = (int) (currentTime % size);
            sb.insert(0, KEYS.charAt(number));
            currentTime /= size;
        }
        //  如果sb不够8位，则往前补0
        while (sb.length() != KEY_LENGTH_TIME) {
            sb.insert(0, "0");
        }
        Random random = new Random();
        // 一位线程号
        long threadId = Thread.currentThread().getId();
        sb.append(KEYS.charAt((int) threadId % size));
        //  随机生成剩下位数，直到12位
        while (sb.length() != PRIMARY_KEY_SIZE) {
            char c = KEYS.charAt(random.nextInt(size));
            sb.append(c);
        }
        return sb.toString();
    }
}
