package com.trilogyed.hotelbookingservice.controllers;

import com.trilogyed.hotelbookingservice.service.RewardService;
import com.trilogyed.hotelbookingservice.viewModel.RewardViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelRewardController {
    @Autowired
    private RewardService service;

    @RequestMapping("hotelRewards/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    public RewardViewModel index(
        @PathVariable String roomId,
        @RequestParam(required = false, defaultValue = "false") String rewardsMember,
        @RequestParam(required = false, defaultValue = "false") String doubleBonusDay
    ) {
        return service.getBVM(roomId, rewardsMember, doubleBonusDay);
    }
}
