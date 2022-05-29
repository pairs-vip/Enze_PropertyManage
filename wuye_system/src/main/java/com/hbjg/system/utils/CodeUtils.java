package com.hbjg.system.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CodeUtils {

    public String generator(){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        //将所有字符全部添加
        for (char i = 'a'; i <= 'z'; i++) {
            sb.append(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            sb.append(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            sb.append(i);
        }

        //随机选取6个字符
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            //随机选取sb的一个索引，并将对应的字符添加到sb2中
            int index = r.nextInt(sb.length());
            sb2.append(sb.charAt(index));
        }

        //为了让随机数中至少有一个数字，在生成的6位随机码中选取一个修改成数字，可以使用setCharAt()
        //随机产生一个48-57之间的数字
        int c1 = r.nextInt(10)+48;
        char c2 = (char)c1;     //将数字强行转换成字符
        int i = r.nextInt(sb2.length());
        sb2.setCharAt(i,c2);

        return sb2.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(new CodeUtils().generator());
//    }
}
