package in.nuphos.projectEuler;

import java.util.Scanner;

public class Problem17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 1 ; i <= T ; i++) {
            long N = scan.nextLong();
            if(N == 0) {
                System.out.println("Zero");
            } else {
                System.out.println(twelveDigitsInWords(N));
            }
        }
        scan.close();
    }

    public static String twelveDigitsInWords(long twelveDigits) {
        String word;
        short billions = (short) (twelveDigits / 1000000000);
        long lastNineDigits = twelveDigits % 1000000000;
        if(billions > 0) {
            String billionsWords = threeDigitsInWords(billions);
            word = billionsWords + " Billion";
            if(lastNineDigits > 0) {
                word += " " + nineDigitsInWords(lastNineDigits);
            }
        } else {
            word = nineDigitsInWords(lastNineDigits);
        }
        return word;
    }

    public static String nineDigitsInWords(long nineDigits) {
        String word;
        short millions = (short) (nineDigits / 1000000);
        int lastSixDigits = (int) (nineDigits % 1000000);
        if(millions > 0) {
            String millionsWords = threeDigitsInWords(millions);
            word = millionsWords + " Million";
            if(lastSixDigits > 0) {
                word += " " + sixDigitsInWords(lastSixDigits);
            }
        } else {
            word = sixDigitsInWords(lastSixDigits);
        }
        return word;
    }

    public static String sixDigitsInWords(int sixDigits) {
        String word;
        short thousands = (short) (sixDigits / 1000);
        short lastThreeDigits = (short) (sixDigits % 1000);
        if(thousands > 0) {
            String thousandsWords = threeDigitsInWords(thousands);
            word = thousandsWords + " Thousand";
            if(lastThreeDigits > 0) {
                word += " " + threeDigitsInWords(lastThreeDigits);
            }
        } else {
            word = threeDigitsInWords(lastThreeDigits);
        }
        return word;
    }

    public static String threeDigitsInWords(short threeDigits) {
        String word, hundreds = null;
        if(threeDigits > 999) {
            throw new RuntimeException("Expected three digits. More provided!");
        }
        byte firstDigit = (byte) (threeDigits / 100);
        byte lastTwoDigits = (byte) (threeDigits % 100);
        if(firstDigit > 0) {
            word = oneDigitInWords(firstDigit) + " Hundred";
            if(lastTwoDigits > 0) {
                 word += " " + twoDigitsInWords(lastTwoDigits);
            }
        } else {
            word = twoDigitsInWords(lastTwoDigits);
        }
        return word;
    }

    public static String twoDigitsInWords(byte twoDigits) {
        if(twoDigits > 99) {
            throw new RuntimeException("Expected two digits. More provided!");
        }
        String word = null, tens = null;
        if(twoDigits < 10) {
            return oneDigitInWords(twoDigits);
        }
        switch (twoDigits) {
            case 10 -> word = "Ten";
            case 11 -> word = "Eleven";
            case 12 -> word = "Twelve";
            case 13 -> word = "Thirteen";
            case 14 -> word = "Fourteen";
            case 15 -> word = "Fifteen";
            case 16 -> word = "Sixteen";
            case 17 -> word = "Seventeen";
            case 18 -> word = "Eighteen";
            case 19 -> word = "Nineteen";
        }
        if(twoDigits > 19) {
            byte firstDigit = (byte) (twoDigits / 10);
            byte secondDigit = (byte) (twoDigits % 10);
            switch (firstDigit) {
                case 2 -> tens = "Twenty";
                case 3 -> tens = "Thirty";
                case 4 -> tens = "Forty";
                case 5 -> tens = "Fifty";
                case 6 -> tens = "Sixty";
                case 7 -> tens = "Seventy";
                case 8 -> tens = "Eighty";
                case 9 -> tens = "Ninety";
            }
            if(secondDigit > 0) {
                word = tens + " " + oneDigitInWords(secondDigit);
            } else {
                word = tens;
            }
        }
        return word;
    }

    public static String oneDigitInWords(byte singleDigit) {

        return switch (singleDigit) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> throw new RuntimeException("Expected single digit. More provided!");
        };
    }
}
