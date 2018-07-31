package apiEngine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuySubRbDTO {
    private Long routeId;
    private Long returnRouteId;
    private String bookType;
    private Boolean deductShuttlCashback;
    private String email;
    private Long fromId;
    private Long toId;
    private Long returnToId;
    private Long returnFromId;
    private Boolean onlyAddOn;
    private Boolean selectTimeEnabled;
    private Long subscriptionId;
    private Boolean twoWay;
    private Double userFromLat;
    private Double userFromLng;
    private Double userSubscriptionId;
    private Double userToLat;
    private Double userToLng;
    private String wallet;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getReturnRouteId() {
        return returnRouteId;
    }

    public void setReturnRouteId(Long returnRouteId) {
        this.returnRouteId = returnRouteId;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Boolean getDeductShuttlCashback() {
        return deductShuttlCashback;
    }

    public void setDeductShuttlCashback(Boolean deductShuttlCashback) {
        this.deductShuttlCashback = deductShuttlCashback;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getReturnToId() {
        return returnToId;
    }

    public void setReturnToId(Long returnToId) {
        this.returnToId = returnToId;
    }

    public Long getReturnFromId() {
        return returnFromId;
    }

    public void setReturnFromId(Long returnFromId) {
        this.returnFromId = returnFromId;
    }

    public Boolean getOnlyAddOn() {
        return onlyAddOn;
    }

    public void setOnlyAddOn(Boolean onlyAddOn) {
        this.onlyAddOn = onlyAddOn;
    }

    public Boolean getSelectTimeEnabled() {
        return selectTimeEnabled;
    }

    public void setSelectTimeEnabled(Boolean selectTimeEnabled) {
        this.selectTimeEnabled = selectTimeEnabled;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Boolean getTwoWay() {
        return twoWay;
    }

    public void setTwoWay(Boolean twoWay) {
        this.twoWay = twoWay;
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

    public Double getUserSubscriptionId() {
        return userSubscriptionId;
    }

    public void setUserSubscriptionId(Double userSubscriptionId) {
        this.userSubscriptionId = userSubscriptionId;
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

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "BuySubRbDTO{" +
                "routeId=" + routeId +
                ", returnRouteId=" + returnRouteId +
                ", bookType='" + bookType + '\'' +
                ", deductShuttlCashback=" + deductShuttlCashback +
                ", email='" + email + '\'' +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", returnToId=" + returnToId +
                ", returnFromId=" + returnFromId +
                ", onlyAddOn=" + onlyAddOn +
                ", selectTimeEnabled=" + selectTimeEnabled +
                ", subscriptionId=" + subscriptionId +
                ", twoWay=" + twoWay +
                ", userFromLat=" + userFromLat +
                ", userFromLng=" + userFromLng +
                ", userSubscriptionId=" + userSubscriptionId +
                ", userToLat=" + userToLat +
                ", userToLng=" + userToLng +
                ", wallet='" + wallet + '\'' +
                '}';
    }
}