package com.neitdisc.demo.entity;


import com.neitdisc.demo.util.MapToEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@SqlResultSetMapping(
        name = "resultMapping",
        classes = @ConstructorResult(targetClass = NetdiscInfo.class,
                columns = {@ColumnResult(name = "GUID", type = String.class),
                        @ColumnResult(name = "SONGNAME", type = String.class),
                        @ColumnResult(name = "AUTHOR", type = String.class),
                        @ColumnResult(name = "FULLNAME", type = String.class),
                        @ColumnResult(name = "TYPE", type = String.class),
                        @ColumnResult(name = "SIZE", type = String.class),
                        @ColumnResult(name = "SLINK_LT", type = String.class),
                        @ColumnResult(name = "CHTIME_LT", type = Date.class),
                        @ColumnResult(name = "YXQ_LT", type = String.class),
                        @ColumnResult(name = "ZT_LT", type = String.class),
                        @ColumnResult(name = "SLINK_360", type = String.class),
                        @ColumnResult(name = "CHTIME_360", type = Date.class),
                        @ColumnResult(name = "YXQ_360", type = String.class),
                        @ColumnResult(name = "ZT_360", type = String.class),
                        @ColumnResult(name = "SLINK_BD", type = String.class),
                        @ColumnResult(name = "CODE", type = String.class),
                        @ColumnResult(name = "CHTIME_BD", type = Date.class),
                        @ColumnResult(name = "YXQ_BD", type = String.class),
                        @ColumnResult(name = "ZT_BD", type = String.class)})
)
@Entity
@Table(name = "netdisc_info")
public class NetdiscInfo {

    private String guid;
    private String songname="";
    private String author="";
    private String fullname="";
    private String type="";
    private String size="0";
    private String slinkLt;
    private java.sql.Timestamp chtimeLt;
    private String yxqLt;
    private String ztLt="0";
    private String slink360;
    private java.sql.Timestamp chtime360;
    private String yxq360;
    private String zt360="0";
    private String slinkBd;
    private String code;
    private java.sql.Timestamp chtimeBd;
    private String yxqBd;
    private String ztBd="0";

    public NetdiscInfo() {
    }

    public NetdiscInfo(String guid, String songname, String author, String fullname, String type, String size,
                       String slinkLt, Date chtimeLt, String yxqLt, String ztLt, String slink360,
                       Date chtime360, String yxq360, String zt360, String slinkBd, String code,
                       Date chtimeBd, String yxqBd, String ztBd) {
        this.guid = guid;
        this.songname = songname;
        this.author = author;
        this.fullname = fullname;
        this.type = type;
        this.size = size;
        this.slinkLt = slinkLt;
        this.chtimeLt = chtimeLt != null ? new Timestamp(chtimeLt.getTime()):null;
        this.yxqLt = yxqLt;
        this.ztLt = ztLt;
        this.slink360 = slink360;
        this.chtime360 = chtime360 != null ? new Timestamp(chtime360.getTime()):null;
        this.yxq360 = yxq360;
        this.zt360 = zt360;
        this.slinkBd = slinkBd;
        this.code = code;
        this.chtimeBd = chtimeBd != null ? new Timestamp(chtimeBd.getTime()):null;
        this.yxqBd = yxqBd;
        this.ztBd = ztBd;
    }

    @Id
    @Column(name = "GUID")
    public String getGuid() {
        return guid;
    }

    @MapToEntity(name = "GUID")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Basic
    @Column(name = "SONGNAME")
    public String getSongname() {
        return songname;
    }

    @MapToEntity(name = "SONGNAME")
    public void setSongname(String songname) {
        this.songname = songname;
    }

    @Basic
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    @MapToEntity(name = "AUTHOR")
    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "FULLNAME")
    public String getFullname() {
        return fullname;
    }

    @MapToEntity(name = "FULLNAME")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    @MapToEntity(name = "TYPE")
    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "SIZE")
    public String getSize() {
        return size;
    }

    @MapToEntity(name = "SIZE")
    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "SLINK_LT")
    public String getSlinkLt() {
        return slinkLt;
    }

    @MapToEntity(name = "SLINK_LT")
    public void setSlinkLt(String slinkLt) {
        this.slinkLt = slinkLt;
    }

    @Basic
    @Column(name = "CHTIME_LT")
    public java.sql.Timestamp getChtimeLt() {
        return chtimeLt;
    }

    @MapToEntity(name = "CHTIME_LT")
    public void setChtimeLt(java.sql.Timestamp chtimeLt) {
        this.chtimeLt = chtimeLt;
    }

    @Basic
    @Column(name = "YXQ_LT")
    public String getYxqLt() {
        return yxqLt;
    }

    @MapToEntity(name = "YXQ_LT")
    public void setYxqLt(String yxqLt) {
        this.yxqLt = yxqLt;
    }

    @Basic
    @Column(name = "ZT_LT")
    public String getZtLt() {
        return ztLt;
    }

    @MapToEntity(name = "ZT_LT")
    public void setZtLt(String ztLt) {
        this.ztLt = ztLt;
    }

    @Basic
    @Column(name = "SLINK_360")
    public String getSlink360() {
        return slink360;
    }

    @MapToEntity(name = "SLINK_360")
    public void setSlink360(String slink360) {
        this.slink360 = slink360;
    }

    @Basic
    @Column(name = "CHTIME_360")
    public java.sql.Timestamp getChtime360() {
        return chtime360;
    }

    @MapToEntity(name = "CHTIME_360")
    public void setChtime360(java.sql.Timestamp chtime360) {
        this.chtime360 = chtime360;
    }

    @Basic
    @Column(name = "YXQ_360")
    public String getYxq360() {
        return yxq360;
    }

    @MapToEntity(name = "YXQ_360")
    public void setYxq360(String yxq360) {
        this.yxq360 = yxq360;
    }

    @Basic
    @Column(name = "ZT_360")
    public String getZt360() {
        return zt360;
    }

    @MapToEntity(name = "ZT_360")
    public void setZt360(String zt360) {
        this.zt360 = zt360;
    }

    @Basic
    @Column(name = "SLINK_BD")
    public String getSlinkBd() {
        return slinkBd;
    }

    @MapToEntity(name = "SLINK_BD")
    public void setSlinkBd(String slinkBd) {
        this.slinkBd = slinkBd;
    }

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    @MapToEntity(name = "CODE")
    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "CHTIME_BD")
    public java.sql.Timestamp getChtimeBd() {
        return chtimeBd;
    }

    @MapToEntity(name = "CHTIME_BD")
    public void setChtimeBd(java.sql.Timestamp chtimeBd) {
        this.chtimeBd = chtimeBd;
    }

    @Basic
    @Column(name = "YXQ_BD")
    public String getYxqBd() {
        return yxqBd;
    }

    @MapToEntity(name = "YXQ_BD")
    public void setYxqBd(String yxqBd) {
        this.yxqBd = yxqBd;
    }

    @Basic
    @Column(name = "ZT_BD")
    public String getZtBd() {
        return ztBd;
    }

    @MapToEntity(name = "ZT_BD")
    public void setZtBd(String ztBd) {
        this.ztBd = ztBd;
    }


    @Override
    public String toString() {
        return "NetdiscInfo{" +
                "guid='" + guid + '\'' +
                ", songname='" + songname + '\'' +
                ", author='" + author + '\'' +
                ", fullname='" + fullname + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", slinkLt='" + slinkLt + '\'' +
                ", chtimeLt=" + chtimeLt +
                ", yxqLt='" + yxqLt + '\'' +
                ", ztLt='" + ztLt + '\'' +
                ", slink360='" + slink360 + '\'' +
                ", chtime360=" + chtime360 +
                ", yxq360='" + yxq360 + '\'' +
                ", zt360='" + zt360 + '\'' +
                ", slinkBd='" + slinkBd + '\'' +
                ", code='" + code + '\'' +
                ", chtimeBd=" + chtimeBd +
                ", yxqBd='" + yxqBd + '\'' +
                ", ztBd='" + ztBd + '\'' +
                '}';
    }
}
