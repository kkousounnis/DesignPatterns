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
//        generateTShirtsAndStrategies(15).forEach(action
//                -> {
//            System.out.println(" // ----------- //");
//            action.entrySet().forEach(entry
//                    -> {
//                System.out.println(entry.getKey() + " Price: " + entry.getValue());
//            });
//        });

//        System.out.println(generateTShirtsAndStrategies(15));
//        for (HashMap<String, Float> h : generateTShirtsAndStrategies(15)) {
//            System.out.println(h);
//        }

        List<Tshirt> tShirts = new ArrayList<Tshirt>();
        // Colos
        for (int i = 0; i < 7; i++) {
            Color color = Color.values()[i];
            // Size
            for (int j = 0; j < 7; j++) {
                Size size = Size.values()[j];
                // Fabric
                for (int k = 0; k < 7; k++) {
                    Fabric fabric = Fabric.values()[k];
                    tShirts.add(new Tshirt(GeneratingRandomAlphabeticString(), color, size, fabric));
                }

            }

        }
        List<IPayment> payments = Arrays.asList(new IPayment[]{new CreditDebitCard(), new MoneyBankTranfer(), new CashPayment()});   // new ArrayList<>();
          
        HashMap<String, Float> allPayments = new HashMap<>();
        Context contextAll = new Context(payments);
        
        for (Tshirt t1 : tShirts) {
            System.out.println(t1);
            System.out.println(contextAll.executePayments(t1.getPrice(),
                    t1.getColor(), t1.getSize(), t1.getFabric()));
        }
    }

//    public static List<HashMap<String, Float>> generateTShirtsAndStrategies(int noOfTShirts) {
//        List<HashMap<String, Float>> aaa = new ArrayList<HashMap<String, Float>>();
//        for (int i = 0; i < noOfTShirts; i++) {
//            aaa.add(generateTShirtAndStategies());
//        }
//        return (aaa);
//    }

//    public static HashMap<String, Float> generateTShirtAndStategies() {
//        Color color = getRandomColor();
//        Size size = getRandomSize();
//        Fabric fabric = getRandomFabric();
//
//        Tshirt t1 = new Tshirt(GeneratingRandomAlphabeticString(), color, size, fabric);
//        System.out.println(t1);
//        List<IPayment> payments = Arrays.asList(new IPayment[]{new CreditDebitCard(), new MoneyBankTranfer(), new CashPayment()});   // new ArrayList<>();
//        System.out.println(payments);
//        HashMap<String, Float> allPayments = new HashMap<>();
//        Context contextAll = new Context(payments);
//        System.out.println(contextAll);
//        allPayments = contextAll.executePayments(t1.getPrice(),
//                t1.getColor(), t1.getSize(), t1.getFabric());
//        return (allPayments);
//
//    }
//
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
        /*
            This code was take from www.baeldung.com/java-random-string method
            ivenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect() 
         */
    }

//    private static Color getRandomColor() {
//        Color[] arr = {
//            Color.RED,
//            Color.ORANGE,
//            Color.YELLOW,
//            Color.GREEN,
//            Color.BLUE,
//            Color.INDIGO,
//            Color.VIOLET
//        };
//
//        return arr[getRandomNumberInRange(0, 6)];
//    }
//
//    private static Size getRandomSize() {
//        Size[] arr = {
//            Size.XS,
//            Size.S,
//            Size.M,
//            Size.L,
//            Size.XL,
//            Size.XXL,
//            Size.XXXL
//        };
//        return arr[getRandomNumberInRange(0, 6)];
//    }
//
//    private static Fabric getRandomFabric() {
//        Fabric[] arr = {
//            Fabric.WOOL,
//            Fabric.COTTON,
//            Fabric.POLYESTER,
//            Fabric.RAYON,
//            Fabric.LINEN,
//            Fabric.CASHMERE,
//            Fabric.SILK
//        };
//        return arr[getRandomNumberInRange(0, 6)];
//    }

    private static int getRandomNumberInRange(int min, int max) {

        System.out.println((int) ((Math.random() * (max - min)) + min));

        return (int) ((Math.random() * (max - min)) + min);
    }

}
