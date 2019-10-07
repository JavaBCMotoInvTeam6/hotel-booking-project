package com.trilogyed.hotelbookingservice.util;

import com.trilogyed.hotelbookingservice.models.Rewards;
import com.trilogyed.hotelbookingservice.models.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "room-service")
public interface FeignRoomServiceClient {
    @RequestMapping(value = "/room/{number}", method = RequestMethod.GET)
    public Room getRoom(@PathVariable int number);
}
