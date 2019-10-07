package com.trilogyed.hotelbookingservice.util;

import com.trilogyed.hotelbookingservice.models.Rewards;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rewards-service")
public interface FeignRewardServiceClient {
    @RequestMapping(value = "/rewards/type/{roomType}", method = RequestMethod.GET)
    public Rewards getRewards(@PathVariable String roomType);
}
