package strategypatterntshirt.interfaces;

import strategypatterntshirt.models.Color;
import strategypatterntshirt.models.Fabric;
import strategypatterntshirt.models.Size;

public interface IPayment {

    float pay(Fabric fabric, Color color, Size size);    
    default float calculatePrice(Color color, Size size, Fabric fabric) { 
        float result = 0;
        result += color.getColorPrice();
        result += size.getSizePrice();
        result += fabric.getFabricPrice();
        return result;
    };

}
