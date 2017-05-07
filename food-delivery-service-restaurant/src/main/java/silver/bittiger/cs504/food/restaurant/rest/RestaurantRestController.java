package silver.bittiger.cs504.food.restaurant.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import silver.bittiger.cs504.food.restaurant.domain.RestaurantBO;
import silver.bittiger.cs504.food.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final String kDefaultPage = "0";//Search result default browse page

    private final String kDefaultSize = "20";//Search result default size

    private RestaurantService service;

    @Autowired
    RestaurantRestController(RestaurantService service){
        this.service = service;
    }

    @RequestMapping(value = "/{restName}", method = RequestMethod.GET)
    public Page<RestaurantBO> searchRestaurant(@PathVariable String restName,
                                               @RequestParam(name = "page", required = false, defaultValue = kDefaultPage) Integer page,
                                               @RequestParam(name = "size", required = false, defaultValue = kDefaultSize) Integer size){
        return service.findByName(restName, new PageRequest(page,size));
    }



}
