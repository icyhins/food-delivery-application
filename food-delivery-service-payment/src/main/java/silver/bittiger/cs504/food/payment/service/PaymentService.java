package silver.bittiger.cs504.food.payment.service;

import silver.bittiger.cs504.food.payment.domain.PaymentBO;

import java.sql.Timestamp;

public interface PaymentService {

    PaymentBO pay(PaymentBO paymentBO);

    Timestamp deliveryTime(String orderId);
}
