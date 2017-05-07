package silver.bittiger.cs504.food.restaurant.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import silver.bittiger.cs504.food.restaurant.domain.RestaurantBO;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantBO, Long> {

    Page<RestaurantBO> findByName(@Param("name") String restName, Pageable pageable);
}
