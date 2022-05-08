package controllers;

import model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public static Payment processPayment(){
        throw new NotEnoughMoneyException();
    }
}
