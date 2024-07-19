
package bookstoremanagement.model.Backend.Price;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormat {
     public static String format(float num) {
        BigDecimal ngan = new BigDecimal(num * 1000);
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat fmoney = NumberFormat.getCurrencyInstance(vietnam);

        return fmoney.format(ngan);
    }
}
