/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatterntshirt;

import java.util.HashMap;
import java.util.List;
import strategypatterntshirt.interfaces.IPayment;
import strategypatterntshirt.models.Color;
import strategypatterntshirt.models.Fabric;
import strategypatterntshirt.models.Size;

/**
 *
 * @author mac
 */
public class Context {

    IPayment payment;
    List<IPayment> payments;

    public Context(IPayment payment) {
        this.payment = payment;
    }

    public Context(List<IPayment> payments) {
        this.payments = payments;
    }

//    public float executePayment(float basePrice, Color color, Size size, Fabric fabric) {
//        return payment.pay(fabric, color, size);
//    }
    // executePayments(float basePrice, Color color, Size size, Fabric fabric)
    public HashMap<String, Float> executePayments(float amount, Color color, Size size, Fabric fabric) {
        HashMap<String, Float> arrayOfPays = new HashMap<>();

        for (IPayment payment : payments) {

            arrayOfPays.put(choosePaymentMethod(payment.getClass().getSimpleName()),
                    payment.pay(fabric, color, size));
        }
        return arrayOfPays;
    }

    public String choosePaymentMethod(String paymentMethod) {
        switch (paymentMethod) {
            case "CashPayment":
                paymentMethod = "Pay with cash";
                break;
            case "MoneyBankTranfer":
                paymentMethod = "Pay with Bank Transfer";
                break;
            case "CreditDebitCard":
                paymentMethod = "Pay with credit card";
                break;
        }

        return paymentMethod;
    }

}
