package com.example.gidview;

public class RateItem {
    private String cname;
    private float cval;

    public RateItem(float cval, String cname) {
        this.cval = cval;
        this.cname = cname;
    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public float getCval() {
        return cval;
    }

    public void setCval(float cval) {
        this.cval = cval;
    }

}
