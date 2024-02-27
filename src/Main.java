public class Main {

 public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> remainders = new ArrayList<>();
        ArrayList<Integer> moduli = new ArrayList<>();
        int size;
        System.out.println("input the size");
        size = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < size; i++) {
            System.out.printf("input the #%d equation\n", i + 1);
            String input = scan.nextLine();
            StringBuilder ip = new StringBuilder(input);
            for (int j = 0; j < ip.length(); j++) {
                if (ip.charAt(j) == ' ') {
                    ip.deleteCharAt(j);
                    j--;
                }
            }
            input = ip.toString();
            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '=') {
                    j++;
                    while (input.charAt(j) != '(') {
                        num1.append(input.charAt(j));
                        j++;
                    }
                }
                if (input.charAt(j) == 'd') {
                    j++;
                    while (input.charAt(j) != ')') {
                        num2.append(input.charAt(j));
                        j++ ;
                    }
                }
            }
            String number1 = num1.toString();
            String number2 = num2.toString();
            remainders.add(Integer.parseInt(number1));
            moduli.add(Integer.parseInt(number2));

        }
        ChineseRemainder chineseRemainder = new ChineseRemainder();
        System.out.println(ChineseRemainder.chineseRemainder(remainders, moduli));
    }
    
}
