package apiEngine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * created by naveenkumar on Jul, 2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CombinedSlotLocDTO {
    private Long id;
    private String name;
    private Double lat;
    private Double lng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "CombinedSlotFromLocDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}

