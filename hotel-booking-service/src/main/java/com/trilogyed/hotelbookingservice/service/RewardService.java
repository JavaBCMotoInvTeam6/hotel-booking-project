package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.models.Rewards;
import com.trilogyed.hotelbookingservice.models.Room;
import com.trilogyed.hotelbookingservice.util.FeignRewardServiceClient;
import com.trilogyed.hotelbookingservice.util.FeignRoomServiceClient;
import com.trilogyed.hotelbookingservice.viewModel.RewardViewModel;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    private FeignRewardServiceClient feignRewardServiceClient;
    private FeignRoomServiceClient feignRoomServiceClient;

    @Autowired
    public RewardService(FeignRewardServiceClient feignRewardServiceClient, FeignRoomServiceClient feignRoomServiceClient) {
        this.feignRoomServiceClient = feignRoomServiceClient;
        this.feignRewardServiceClient = feignRewardServiceClient;
    }

    public RewardViewModel getBVM(String roomId, String isRewardsMember, String isDoubleDayBonus) {
        Boolean rewardsMember = false;
        Boolean doubleDayBonus = false;

        if(isRewardsMember == "true") {
            rewardsMember = true;
        }

        // TODO: add better error handling
        if(isDoubleDayBonus == "true") {
            doubleDayBonus = true;
        }

        Room room = new Room();
        Rewards rewards = new Rewards();

        try {
            // Get the room
            room = feignRoomServiceClient.getRoom(Integer.parseInt(roomId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            // Use the room to get the room type
            rewards = feignRewardServiceClient.getRewards(room.getRoomType());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        RewardViewModel rvm = new RewardViewModel();

        rvm.setRoomNumber(roomId);
        rvm.setRoomType(room.getRoomType());
        rvm.setRewardsMember(rewardsMember);
        rvm.setDoubleBonusDay(doubleDayBonus);
        rvm.setBaseRate(room.getBaseRate());
        rvm.setMemberDiscount(rewards.getDiscount());
        rvm.setBaseRewardsPoints(rewards.getPoints());
        rvm.setCanDouble(rewards.getCanDouble());

        if(rvm.getRewardsMember()) {
            rvm.setFinalCost(rvm.getBaseRate() * (1 - rvm.getMemberDiscount()));
        } else {
            rvm.setFinalCost(rvm.getBaseRate());
        }

        if(rvm.getCanDouble() && rvm.getDoubleBonusDay() && rvm.getRewardsMember()) {
            rvm.setTotalRewardsPoints(rvm.getBaseRewardsPoints() * 2);
        } else if(rvm.getRewardsMember()) {
            rvm.setTotalRewardsPoints(rvm.getBaseRewardsPoints());
        } else {
           rvm.setTotalRewardsPoints(0);
        }

        return rvm;
    }
}
