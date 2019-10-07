package com.trilogyed.hotelbookingservice.viewModel;

import java.util.Objects;

public class RewardViewModel {
    private String roomNumber;
    private String roomType;
    private Boolean rewardsMember;
    private Boolean doubleBonusDay;
    private Float baseRate;
    private Float memberDiscount;
    private Integer baseRewardsPoints;
    private Boolean canDouble;
    private Float finalCost;
    private Integer totalRewardsPoints;

    // default
    public RewardViewModel() {

    }

    public RewardViewModel(String roomNumber, String roomType, Boolean rewardsMember, Boolean doubleBonusDay, Float baseRate, Float memberDiscount, Integer baseRewardsPoints, Boolean canDouble, Float finalCost, Integer totalRewardsPoints) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.rewardsMember = rewardsMember;
        this.doubleBonusDay = doubleBonusDay;
        this.baseRate = baseRate;
        this.memberDiscount = memberDiscount;
        this.baseRewardsPoints = baseRewardsPoints;
        this.canDouble = canDouble;
        this.finalCost = finalCost;
        this.totalRewardsPoints = totalRewardsPoints;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Boolean getRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(Boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }

    public Boolean getDoubleBonusDay() {
        return doubleBonusDay;
    }

    public void setDoubleBonusDay(Boolean doubleBonusDay) {
        this.doubleBonusDay = doubleBonusDay;
    }

    public Float getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Float baseRate) {
        this.baseRate = baseRate;
    }

    public Float getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(Float memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public Integer getBaseRewardsPoints() {
        return baseRewardsPoints;
    }

    public void setBaseRewardsPoints(Integer baseRewardsPoints) {
        this.baseRewardsPoints = baseRewardsPoints;
    }

    public Boolean getCanDouble() {
        return canDouble;
    }

    public void setCanDouble(Boolean canDouble) {
        this.canDouble = canDouble;
    }

    public Float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Float finalCost) {
        this.finalCost = finalCost;
    }

    public Integer getTotalRewardsPoints() {
        return totalRewardsPoints;
    }

    public void setTotalRewardsPoints(Integer totalRewardsPoints) {
        this.totalRewardsPoints = totalRewardsPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardViewModel that = (RewardViewModel) o;
        return getRoomNumber().equals(that.getRoomNumber()) &&
                getRoomType().equals(that.getRoomType()) &&
                getRewardsMember().equals(that.getRewardsMember()) &&
                getDoubleBonusDay().equals(that.getDoubleBonusDay()) &&
                getBaseRate().equals(that.getBaseRate()) &&
                getMemberDiscount().equals(that.getMemberDiscount()) &&
                getBaseRewardsPoints().equals(that.getBaseRewardsPoints()) &&
                getCanDouble().equals(that.getCanDouble()) &&
                getFinalCost().equals(that.getFinalCost()) &&
                getTotalRewardsPoints().equals(that.getTotalRewardsPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber(), getRoomType(), getRewardsMember(), getDoubleBonusDay(), getBaseRate(), getMemberDiscount(), getBaseRewardsPoints(), getCanDouble(), getFinalCost(), getTotalRewardsPoints());
    }
}
