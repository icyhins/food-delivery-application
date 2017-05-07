package silver.bittiger.cs504.food.payment.service.impl;

import org.springframework.stereotype.Service;
import silver.bittiger.cs504.food.payment.domain.PaymentBO;
import silver.bittiger.cs504.food.payment.service.PaymentService;

import java.sql.Timestamp;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentBO pay(PaymentBO paymentBO) {

        //Call Financial API for payment process
        String result = "Success";
        String paymentId = "123-eee-456-fasfasdf-32ed2-23dqsbrt796532r-cwef435fd217-c165d";
        paymentBO.setPayResult(result);
        paymentBO.setPaymentId(paymentId);

        return paymentBO;
    }

    @Override
    public Timestamp deliveryTime(String orderId) {
        //TODO get order info from order service
        return new Timestamp(System.currentTimeMillis());
    }
}
