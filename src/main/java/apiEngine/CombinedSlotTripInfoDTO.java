package apiEngine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * created by naveenkumar on Jul, 2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CombinedSlotTripInfoDTO {
    private Long id;
    private Long time;
    private Integer fare;
    private Long journeyTime;
    private Boolean isEtaStatic;
    private Long routeId;
    private Integer seatsAvailable;
    private Boolean selected;
    private Long startTime;
    private Long staticTime;
    private String statusText;
    private String startMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }

    public Long getJourneyTime() {
        return journeyTime;
    }

    public void setJourneyTime(Long journeyTime) {
        this.journeyTime = journeyTime;
    }

    public Boolean getEtaStatic() {
        return isEtaStatic;
    }

    public void setEtaStatic(Boolean etaStatic) {
        isEtaStatic = etaStatic;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getStaticTime() {
        return staticTime;
    }

    public void setStaticTime(Long staticTime) {
        this.staticTime = staticTime;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStartMessage() {
        return startMessage;
    }

    public void setStartMessage(String startMessage) {
        this.startMessage = startMessage;
    }

    @Override
    public String toString() {
        return "CombinedSlotTripInfoDTO{" +
                "id=" + id +
                ", time=" + time +
                ", fare=" + fare +
                ", journeyTime=" + journeyTime +
                ", isEtaStatic=" + isEtaStatic +
                ", routeId=" + routeId +
                ", seatsAvailable=" + seatsAvailable +
                ", selected=" + selected +
                ", startTime=" + startTime +
                ", staticTime=" + staticTime +
                ", statusText='" + statusText + '\'' +
                ", startMessage='" + startMessage + '\'' +
                '}';
    }
}

