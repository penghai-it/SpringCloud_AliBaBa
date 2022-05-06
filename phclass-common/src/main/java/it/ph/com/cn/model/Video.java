package it.ph.com.cn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频实体类
 *
 * @author penghai
 * @type Class
 * @date 2022年01月13日 15:48
 */
public class Video implements Serializable {
    private Integer id;
    private String title;
    private String summary;
    private String coverImg;
    private Integer price;
    private Date createTime;
    private Double point;
    private String serveInfo;
    private String serviceInfo;

    public String getServeInfo() {
        return serveInfo;
    }

    public void setServeInfo(String serveInfo) {
        this.serveInfo = serveInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", point=" + point +
                ", serveInfo='" + serveInfo + '\'' +
                ", serviceInfo='" + serviceInfo + '\'' +
                '}';
    }
}
