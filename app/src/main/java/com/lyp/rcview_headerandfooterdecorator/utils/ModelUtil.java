package com.lyp.rcview_headerandfooterdecorator.utils;

import com.lyp.rcview_headerandfooterdecorator.bean.Message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lyp on 2016/9/23.
 */
public class ModelUtil {

    /**
     * 获取当前系统时间
     * @return
     */
    public static String getNowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        return simpleDateFormat.format(new Date());
    }

    /**
     * 假数据
     */
    public static List<Message> getMessageData() {
        List<Message> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(new Message("联系人"+i, "消息内容"+i));
        }
        return data;
    }
}
