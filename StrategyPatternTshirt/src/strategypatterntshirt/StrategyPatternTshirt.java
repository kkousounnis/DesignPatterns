package strategypatterntshirt;

import strategypatterntshirt.interfaces.IPayment;
import strategypatterntshirt.models.Color;
import strategypatterntshirt.models.Fabric;
import strategypatterntshirt.models.Size;
import strategypatterntshirt.models.Tshirt;

public class StrategyPatternTshirt {

    public static void main(String[] args) {
        Tshirt tshirt = new Tshirt("MARCO POLO", Color.RED, Size.XS, Fabric.WOOL);

        Fabric f = Fabric.COTTON;
        System.out.println(f.getUnitPrice());
        System.out.println("hello" + f.values());
        IPayment payment = new CreditDebitCard();

        StrategyPatternTshirt myMainClass = new StrategyPatternTshirt();
        myMainClass.makeAnOrder(tshirt, payment);
        System.out.println("");
        payment = new MoneyBankTranfer();
        myMainClass.makeAnOrder(tshirt, payment);

    }

    public void makeAnOrder(Tshirt tshirt, IPayment payment) {
        payment.pay(320);
        System.out.println(payment.getClass().getName());
        System.out.println(tshirt.getClass().getName());
        
        if (payment.getClass().getName().equals("strategypatterntshirt.CreditDebitCard")) {
            payment.pay(tshirt.getFabric().getUnitPrice() + 5.0f);
        }
        
        if (payment.getClass().getName().contains("MoneyBankTransfer")) {
            payment.pay(tshirt.getFabric().getUnitPrice() + 3.0f);
        }

    }

}
