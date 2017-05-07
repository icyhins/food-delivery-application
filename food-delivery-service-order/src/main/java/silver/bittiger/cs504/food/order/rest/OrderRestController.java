package silver.bittiger.cs504.food.order.rest;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import silver.bittiger.cs504.food.order.bean.OrderInfoBO;
import silver.bittiger.cs504.food.order.service.OrderService;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/order")
public class OrderRestController {

    private OrderService service;

    @Autowired
    public OrderRestController(OrderService service){
        this.service = service;
    }

    /**
     * Create a now order with request information.
     * */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderInfoBO orderInfoBO){

    }




}
