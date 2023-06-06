package com.jdbc;

/**
 * ClassName: CityEntity
 * Package: com.jdbc
 * Description:
 *
 * @Author chgwyellow
 * @Create 2023-06-05
 */
public class CityEntity {

    private Integer city_id;
    private String city;
    private Integer country_id;

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "city_id=" + city_id +
                ", city='" + city + '\'' +
                ", country_id=" + country_id +
                '}';
    }
}
