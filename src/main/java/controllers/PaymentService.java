package controllers;

import model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public static PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
