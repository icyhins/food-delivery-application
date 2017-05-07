package silver.bittiger.cs504.food.order.service.impl;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Service;
import silver.bittiger.cs504.food.order.bean.OrderInfoBO;
import silver.bittiger.cs504.food.order.service.OrderService;

import java.sql.Timestamp;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void newOneOrder(OrderInfoBO orderInfoBO) {
        //Timestamp of new an Order
        Timestamp startTime = new Timestamp(System.currentTimeMillis());

        //Delivery Minutes estimation



    }



}


