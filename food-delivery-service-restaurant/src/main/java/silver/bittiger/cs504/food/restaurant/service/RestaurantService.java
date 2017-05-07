package silver.bittiger.cs504.food.restaurant.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import silver.bittiger.cs504.food.restaurant.domain.RestaurantBO;

public interface RestaurantService {

    Page<RestaurantBO> findByName(String restName, Pageable pageable);
}
