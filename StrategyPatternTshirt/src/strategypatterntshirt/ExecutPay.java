package strategypatterntshirt;

import java.util.HashMap;
import java.util.List;
import strategypatterntshirt.interfaces.IPayment;
import strategypatterntshirt.models.Color;
import strategypatterntshirt.models.Fabric;
import strategypatterntshirt.models.Size;

public class ExecutPay {

    List<IPayment> payments;

    public ExecutPay(List<IPayment> payments) {
        this.payments = payments;
    }

    // executePayments(float basePrice, Color color, Size size, Fabric fabric)
    public HashMap<String, Float> executePayments(float amount, Color color, Size size, Fabric fabric) {
        HashMap<String, Float> arrayOfPays = new HashMap<>();

        for (IPayment payment : payments) {
            //System.out.println(payment.getClass().getSimpleName());
            arrayOfPays.put(choosePaymentMethod(payment.getClass().getSimpleName()),
                    payment.pay(fabric, color, size));
        }
        return arrayOfPays;
    }

    public String choosePaymentMethod(String paymentMethod) {

        if (paymentMethod.equals("CashPayment")) {
            paymentMethod = "Pay with cash";
        } else if (paymentMethod.equals("MoneyBankTranfer")) {
            paymentMethod = "Pay with Bank Transfer";
        } else if (paymentMethod.equals("CreditDebitCard")) {
            paymentMethod = "Pay with credit card";
        }

        return paymentMethod;
    }

}
