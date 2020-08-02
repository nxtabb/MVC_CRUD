package com.hrbeu.Entity;

import java.util.Date;

public class New {
    private int nid;
    private String title;
    private String author;
    private Date pubdate;
    private String content;
    private int lockflag;

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLockflag() {
        return lockflag;
    }

    public void setLockflag(int lockflag) {
        this.lockflag = lockflag;
    }
    public New(){}

    public New(int nid, String title, String author, Date pubdate, String content, int lockflag) {
        this.nid = nid;
        this.title = title;
        this.author = author;
        this.pubdate = pubdate;
        this.content = content;
        this.lockflag = lockflag;
    }
}
