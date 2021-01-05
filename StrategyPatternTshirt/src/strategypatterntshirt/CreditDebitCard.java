package strategypatterntshirt;

import strategypatterntshirt.interfaces.IPayment;

public class CreditDebitCard implements IPayment {

    @Override
    public boolean pay(float amount) {
        System.out.printf("Payment of amount %s was made via Credit / Debit transaction \n", amount);
        return true;
    }

}
