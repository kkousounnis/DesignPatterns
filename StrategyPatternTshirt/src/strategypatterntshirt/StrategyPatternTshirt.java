package strategypatterntshirt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import strategypatterntshirt.factory.CashPayment;
import strategypatterntshirt.factory.CreditDebitCard;
import strategypatterntshirt.factory.MoneyBankTranfer;
import strategypatterntshirt.interfaces.IPayment;
import strategypatterntshirt.models.Color;
import strategypatterntshirt.models.Fabric;
import strategypatterntshirt.models.Size;
import strategypatterntshirt.models.Tshirt;

public class StrategyPatternTshirt {

    public static void main(String[] args) {
        makeAllPossiblePaymentsWithAllTshirts(createAllPossibleCombinations());
    }

    public static List<Tshirt> createAllPossibleCombinations() {
        List<Tshirt> tshirts = new ArrayList<Tshirt>();
        // Colos
        for (int i = 0; i < 7; i++) {
            Color color = Color.values()[i];
            // Size
            for (int j = 0; j < 7; j++) {
                Size size = Size.values()[j];
                // Fabric
                for (int k = 0; k < 7; k++) {
                    Fabric fabric = Fabric.values()[k];
                    tshirts.add(new Tshirt(GeneratingRandomAlphabeticString(), color, size, fabric));
                }

            }

        }
        return (tshirts);
    }
    static int i = 0;

    public static void makeAllPossiblePaymentsWithAllTshirts(List<Tshirt> tshirts) {
        List<IPayment> payments = Arrays.asList(new IPayment[]{new CreditDebitCard(), new MoneyBankTranfer(), new CashPayment()});   // new ArrayList<>();

        HashMap<String, Float> allPayments = new HashMap<>();
        ExecutPay contextAll = new ExecutPay(payments);

        List<HashMap<String, Float>> TShirtsPayments = new ArrayList<HashMap<String, Float>>();

        for (Tshirt tshirt : tshirts) {
            //System.out.println(tshirt);
            allPayments = contextAll.executePayments(tshirt.getPrice(),
                    tshirt.getColor(), tshirt.getSize(), tshirt.getFabric());
            TShirtsPayments.add(allPayments);
        }

        TShirtsPayments.forEach(
                action
                -> {
            System.out.println(tshirts.get(i++));

            action.entrySet().forEach(entry -> {

                System.out.println(entry.getKey() + " the price is " + entry.getValue());

            });

            System.out.println("---------------------------------------------");

        });

    }

    /*
            This code was take from www.baeldung.com/java-random-string method
            ivenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect() 
     */
    public static String GeneratingRandomAlphabeticString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return (generatedString);

    }

}
