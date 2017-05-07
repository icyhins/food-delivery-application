package silver.bittiger.cs504.food.restaurant.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import silver.bittiger.cs504.food.restaurant.dao.RestaurantRepository;
import silver.bittiger.cs504.food.restaurant.domain.RestaurantBO;
import silver.bittiger.cs504.food.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository){
        this.repository = repository;
    }

    @Override
    public Page<RestaurantBO> findByName(String restName, Pageable pageable){
        return  repository.findByName(restName, pageable);
    }

}
