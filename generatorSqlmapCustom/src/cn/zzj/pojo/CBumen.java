package cn.zzj.pojo;

public class CBumen {
    private Integer id;

    private String suoshubumen;

    private String bumenmingcheng;

    private Integer suoshubumenid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuoshubumen() {
        return suoshubumen;
    }

    public void setSuoshubumen(String suoshubumen) {
        this.suoshubumen = suoshubumen == null ? null : suoshubumen.trim();
    }

    public String getBumenmingcheng() {
        return bumenmingcheng;
    }

    public void setBumenmingcheng(String bumenmingcheng) {
        this.bumenmingcheng = bumenmingcheng == null ? null : bumenmingcheng.trim();
    }

    public Integer getSuoshubumenid() {
        return suoshubumenid;
    }

    public void setSuoshubumenid(Integer suoshubumenid) {
        this.suoshubumenid = suoshubumenid;
    }
}