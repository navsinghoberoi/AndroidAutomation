package apiEngine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * created by naveenkumar on Jul, 2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CombinedSlotCouponDTO {
    private Long activeCouponId;
    private String couponCode;
    private String couponDescription;
    private String couponExpiryDate;

    public Long getActiveCouponId() {
        return activeCouponId;
    }

    public void setActiveCouponId(Long activeCouponId) {
        this.activeCouponId = activeCouponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public String getCouponExpiryDate() {
        return couponExpiryDate;
    }

    public void setCouponExpiryDate(String couponExpiryDate) {
        this.couponExpiryDate = couponExpiryDate;
    }

    @Override
    public String toString() {
        return "CombinedSlotCouponDTO{" +
                "activeCouponId=" + activeCouponId +
                ", couponCode='" + couponCode + '\'' +
                ", couponDescription='" + couponDescription + '\'' +
                ", couponExpiryDate='" + couponExpiryDate + '\'' +
                '}';
    }
}

