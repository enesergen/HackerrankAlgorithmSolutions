//URL:https://www.hackerrank.com/challenges/extra-long-factorials/problem
public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger bigInteger=BigInteger.ONE;
        for(int i=n;i>1;i--){
            bigInteger=bigInteger.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigInteger.toString());
    }
