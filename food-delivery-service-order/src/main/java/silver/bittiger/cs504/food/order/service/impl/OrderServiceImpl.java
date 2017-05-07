package silver.bittiger.cs504.food.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import silver.bittiger.cs504.food.order.domain.OrderInfoBO;
import silver.bittiger.cs504.food.order.dao.OrderRepository;
import silver.bittiger.cs504.food.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository){
        this.repository = repository;
    }

    @Override
    public void newOneOrder(OrderInfoBO orderInfoBO) {
        repository.save(orderInfoBO);
    }



}


