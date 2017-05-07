package silver.bittiger.cs504.food.payment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import silver.bittiger.cs504.food.payment.domain.PaymentBO;
import silver.bittiger.cs504.food.payment.service.PaymentService;

import com.google.gson.JsonObject;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

    private PaymentService service;

    @Autowired
    public PaymentRestController(PaymentService service){
        this.service = service;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ResponseEntity<?> pay(@RequestBody PaymentBO paymentBO){

        PaymentBO payResultBO = service.pay(paymentBO);
        JsonObject obj = new JsonObject();
        obj.addProperty("paymentId", payResultBO.getPaymentId());
        obj.addProperty("paymentTime", payResultBO.getPayTime().toLocalDateTime().toString());
        obj.addProperty("deliveryTime",service.deliveryTime(payResultBO.getOrderId()).toLocalDateTime().toString());

        return new ResponseEntity<JsonObject>(obj, HttpStatus.OK);
    }


}
