package com.nian.model;

import java.awt.*;
import java.util.Random;

public class colorAndChar {
    //随机字符字典
    public static final char[] chars = {'1','2','3','4','5','6','7','8','9','0'};
    //产生随机数
    public static Random random = new Random();
    public static String getRandomString(){
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i<5; i++)
        {
            buffer.append(chars[random.nextInt(chars.length)]);
        }
        return buffer.toString();
    }
    /*获取随机的颜色*/
    public static Color getRandomColor()
    {
        return new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255));
    }
    /*返回某颜色的反色*/
    public static Color getReverseColor(Color c)
    {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }
    private static final long serialVersionUID = 1L;
}
