package com.lyp.rcview_headerandfooterdecorator.bean;

import com.lyp.rcview_headerandfooterdecorator.utils.ModelUtil;

/**
 * Created by lyp on 2016/9/23.
 */
public class Message {

    private String name;
    private String content;
    private String time;

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
        this.time = ModelUtil.getNowTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
