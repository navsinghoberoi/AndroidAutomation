package apiEngine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * created by naveenkumar on Jul, 2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExploredPlansDTO {
    private Long subscriptionId;
    private Long userSubscriptionId;
    private Long routeId;
    private Long returnRouteId;
    private Long fromId;
    private Long toId;
    private Long returnFromId;
    private Long returnToId;
    private String type;
    public Long getUserSubscriptionId() {
        return userSubscriptionId;
    }
    public void setUserSubscriptionId(Long userSubscriptionId) {
        this.userSubscriptionId = userSubscriptionId;
    }
    public Long getSubscriptionId() {
        return subscriptionId;
    }
    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
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
    public Long getReturnFromId() {
        return returnFromId;
    }
    public void setReturnFromId(Long returnFromId) {
        this.returnFromId = returnFromId;
    }
    public Long getReturnToId() {
        return returnToId;
    }
    public void setReturnToId(Long returnToId) {
        this.returnToId = returnToId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "ExploredPlansDTO{" +
                "subscriptionId=" + subscriptionId +
                ", userSubscriptionId=" + userSubscriptionId +
                ", routeId=" + routeId +
                ", returnRouteId=" + returnRouteId +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", returnFromId=" + returnFromId +
                ", returnToId=" + returnToId +
                ", type='" + type + '\'' +
                '}';
    }
}

