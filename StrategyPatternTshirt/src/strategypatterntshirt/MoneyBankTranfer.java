package strategypatterntshirt;

import strategypatterntshirt.interfaces.IPayment;

public class MoneyBankTranfer  implements IPayment{

    @Override
    public boolean pay(float amount) {
        System.out.printf("Payment of amount %s was made via Credit / Bank transaction \n", amount);
        return true;
    }

}
