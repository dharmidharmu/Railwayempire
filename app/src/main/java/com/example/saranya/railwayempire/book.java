package com.example.saranya.railwayempire;

public class book {
    String from;
    String to;
    String tic;
    String type;
    String classid;

    public book(){}

    public book(String from, String to, String tic, String type, String classid) {
        this.from = from;
        this.to = to;
        this.tic = tic;
        this.type = type;
        this.classid = classid;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTic() {
        return tic;
    }

    public void setTic(String tic) {
        this.tic = tic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }
}
