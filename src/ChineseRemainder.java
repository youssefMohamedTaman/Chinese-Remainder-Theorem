import java.util.ArrayList;

public class ChineseRemainder {
    public static long chineseRemainder(ArrayList<Integer> remainders, ArrayList<Integer> moduli) {
        if (!isCoPrime(moduli)) {
            System.out.println("The system is inconsistent.");
            System.exit(-1);
        }
        long x =0;
        long M = 1 ;
        for (Integer integer : moduli) {
            M *= integer;
        }
        ArrayList<Integer> new_moduli = new ArrayList<>();
        for (Integer integer : moduli) {
            Integer mod = Math.toIntExact(M / integer);
            new_moduli.add(mod);
        }
        ArrayList<Integer> new_moduli_inverse = new ArrayList<>();
        for (int i = 0; i < moduli.size(); i++) {
            new_moduli_inverse.add(multi_inverse(new_moduli.get(i), moduli.get(i)));
        }
        for (int i = 0; i < moduli.size(); i++) {
            long value = (long) remainders.get(i) * new_moduli.get(i) * new_moduli_inverse.get(i);
            x+= value ;
        }
        return (x%M);
    }
    private static boolean isCoPrime(ArrayList<Integer> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            for (int j = i + 1; j < values.size(); j++) {
                if (gcd(values.get(i), values.get(j)) != 1) {
                    return (false);
                }
            }
        }
        return (true);
    }
    private static int multi_inverse(int value, int modulo) {
        int orig_modulo = modulo ;
        int t1=1 , t2=0 , t ;
        if (modulo > value) {
            int temp = value ;
            value = modulo ;
            modulo = temp;
            t1=0 ; t2=1 ;
        }
        while (modulo > 0) {
            int mod = value % modulo ;
            int quotient = value / modulo ;
            t = t1 - (t2 * quotient);
            value = modulo ;
            modulo = mod ;
            t1 = t2 ;
            t2 = t ;
        }

        if (value != 1) {
            return (-1);
        }
        if (t1 < 0) {
            t1 += orig_modulo;
        }
        return (t1);
    }

    public static int gcd(int num1, int num2) {
        if (num2 > num1) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        return (num1);
    }
}
