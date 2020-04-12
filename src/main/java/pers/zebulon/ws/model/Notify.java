package pers.zebulon.ws.model;

import java.util.Date;

/**
 * 通知
 */
public class Notify {
    private String title;
    private String content;
    private Date nTime;//通知内容中的事情的原发生时间

    public Notify(String title, String content, Date nTime) {
        this.title = title;
        this.content = content;
        this.nTime = nTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getnTime() {
        return nTime;
    }

    public void setnTime(Date nTime) {
        this.nTime = nTime;
    }
}
