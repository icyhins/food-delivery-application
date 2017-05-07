package silver.bittiger.cs504.food.order.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import silver.bittiger.cs504.food.order.bean.OrderInfoBO;

@RepositoryRestResource(path = "orders", collectionResourceRel = "orders")
public interface OrderRepository extends PagingAndSortingRepository<OrderInfoBO, Long> {

    @RestResource(path = "orderId", rel = "by-orderId ")
    Page<OrderInfoBO> findByOrderId(@Param("orderId") String orderId, Pageable pageable);

}
