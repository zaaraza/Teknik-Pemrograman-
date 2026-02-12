package Pertemuan1;

import java.util.Scanner;
import java.math.BigInteger;

public class Cobainlagi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String input = sc.next();
            BigInteger n = new BigInteger(input);

            BigInteger minLong = BigInteger.valueOf(Long.MIN_VALUE);
            BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);

            if (n.compareTo(minLong) < 0 || n.compareTo(maxLong) > 0) {
                System.out.println(input + " can't be fitted anywhere.");
                continue;
            }

            System.out.println(input + " can be fitted in:");

            if (n.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0 &&
                    n.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0) {
                System.out.println("* byte");
            }

            if (n.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0 &&
                    n.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0) {
                System.out.println("* short");
            }

            if (n.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 &&
                    n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0) {
                System.out.println("* int");
            }

            System.out.println("* long");
        }

        sc.close();
    }
}