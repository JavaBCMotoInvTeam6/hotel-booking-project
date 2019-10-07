package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.models.Rewards;
import com.trilogyed.hotelbookingservice.models.Room;
import com.trilogyed.hotelbookingservice.util.FeignRewardServiceClient;
import com.trilogyed.hotelbookingservice.util.FeignRoomServiceClient;
import com.trilogyed.hotelbookingservice.viewModel.RewardViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class RewardServiceTest {

    @InjectMocks
    private RewardService service;


    @Mock
    private FeignRewardServiceClient feignRewardServiceClient;
    @Mock
    private FeignRoomServiceClient feignRoomServiceClient;

    private void setUpRewardsClientMock() {
        Rewards rewards = new Rewards();

        rewards.setId(1);
        rewards.setRoomType("smoking");
        rewards.setDiscount(0.12f);
        rewards.setPoints(9001);
        rewards.setCanDouble(false);

        doReturn(rewards).when(feignRewardServiceClient).getRewards("smoking");
    }

    private void setUpRoomServiceClientMock() {
        Room room = new Room();
        room.setNumber(1);
        room.setRoomType("smoking");
        room.setBaseRate(3400.34f);

        doReturn(room).when(feignRoomServiceClient).getRoom(1);
    }

    @Before
    public void setUp() throws Exception {
        setUpRewardsClientMock();
        setUpRoomServiceClientMock();
    }

    @Test
    public void getBVM() {
        RewardViewModel result = service.getBVM("1", "false", "true");

        RewardViewModel rvm = new RewardViewModel();

        rvm.setRoomNumber("1");
        rvm.setRoomType("smoking");
        rvm.setRewardsMember(false);
        rvm.setDoubleBonusDay(true);
        rvm.setBaseRate(3400.34f);
        rvm.setMemberDiscount(.12f);
        rvm.setBaseRewardsPoints(9001);
        rvm.setCanDouble(false);
        rvm.setFinalCost(rvm.getBaseRate());
        rvm.setTotalRewardsPoints(0);

        assertEquals(rvm, result);
    }
}