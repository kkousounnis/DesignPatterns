package strategypatterntshirt.factory;

import strategypatterntshirt.interfaces.IPayment;
import strategypatterntshirt.models.Color;
import strategypatterntshirt.models.Fabric;
import strategypatterntshirt.models.Size;

public class MoneyBankTranfer  implements IPayment{ 
    
    @Override
    public float pay( Fabric fabric, Color color, Size size) {
        //it's the commision for every kind of payment
        return(calculatePrice(color, size, fabric)+(1.8f));
    }
    

    

}
