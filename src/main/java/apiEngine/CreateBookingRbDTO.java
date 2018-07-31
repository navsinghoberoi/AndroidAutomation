package apiEngine;

/**
 * created by naveenkumar on May, 2018
 */

public class CreateBookingRbDTO {
    private Long tripId;
    private Long fromId;
    private Long toId;
    private Double userFromLat;
    private Double userFromLng;
    private Double userToLat;
    private Double userToLng;
    private String userFromName;
    private String userToName;
    private Long boardingTime;
    private Long couponId;

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public Double getUserFromLat() {
        return userFromLat;
    }

    public void setUserFromLat(Double userFromLat) {
        this.userFromLat = userFromLat;
    }

    public Double getUserFromLng() {
        return userFromLng;
    }

    public void setUserFromLng(Double userFromLng) {
        this.userFromLng = userFromLng;
    }

    public Double getUserToLat() {
        return userToLat;
    }

    public void setUserToLat(Double userToLat) {
        this.userToLat = userToLat;
    }

    public Double getUserToLng() {
        return userToLng;
    }

    public void setUserToLng(Double userToLng) {
        this.userToLng = userToLng;
    }

    public String getUserFromName() {
        return userFromName;
    }

    public void setUserFromName(String userFromName) {
        this.userFromName = userFromName;
    }

    public String getUserToName() {
        return userToName;
    }

    public void setUserToName(String userToName) {
        this.userToName = userToName;
    }

    public Long getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(Long boardingTime) {
        this.boardingTime = boardingTime;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    @Override
    public String toString() {
        return "CreateBookingRbDTO{" +
                "tripId=" + tripId +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", userFromLat=" + userFromLat +
                ", userFromLng=" + userFromLng +
                ", userToLat=" + userToLat +
                ", userToLng=" + userToLng +
                ", userFromName='" + userFromName + '\'' +
                ", userToName='" + userToName + '\'' +
                ", boardingTime=" + boardingTime +
                ", couponId=" + couponId +
                '}';
    }
}

