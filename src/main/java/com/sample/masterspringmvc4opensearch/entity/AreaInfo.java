package com.sample.masterspringmvc4opensearch.entity;

/**
 * AreaInfo
 * TODO
 *
 * @author ZhaoGQ
 * 2019/1/23
 * 1.0
 **/

public class AreaInfo {
    private String area;
    private String distric;
    private String areaid;
    private CityInfo cityInfo;
    private String prov;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    @Override
    public String toString() {
        return "AreaInfo{" +
                "area='" + area + '\'' +
                ", distric='" + distric + '\'' +
                ", areaid='" + areaid + '\'' +
                ", cityInfo=" + cityInfo +
                ", prov='" + prov + '\'' +
                '}';
    }
}
