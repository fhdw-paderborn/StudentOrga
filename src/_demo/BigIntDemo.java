package _demo;

import java.math.BigInteger;

public class BigIntDemo {

    public static void main(String[] args) {
        BigInteger factor1 = new BigInteger("12345678901234567890123456789");
        BigInteger factor2 = new BigInteger("7777777777777777799999999999999999999999999999999");
        BigInteger product = factor1.multiply(factor2);     // factor1 * factor2
        System.out.println("\n" + product + "\n");          // ist product.toString()
        
        product = product.multiply(product);                // product * product
        System.out.println(product);                        // ist product.toString() 

        // letzte 3 Ziffern
        // int zahl = product.mod(new BigInteger("1000")).intValue();
        int zahl = Integer.valueOf(product.mod(new BigInteger("1000")).toString());
        System.out.println(zahl);
    }

}
