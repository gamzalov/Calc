import java.util.HashMap;
import java.util.Scanner;
import Exception.*;
public class Main {





    public static void main(String[] args) throws TwoTypesException, NegativeRomeException, NotMathematicOperation {
        while (true){
            Scanner console = new Scanner(System.in);
            String input = console.nextLine();
            System.out.println(calc(input));
        }
    }
    public static String calc(String input) throws NegativeRomeException, TwoTypesException, NotMathematicOperation {
        HashMap<String, Integer> romeDict = new HashMap<>();
        romeDict.put("I", 1);
        romeDict.put("II", 2);
        romeDict.put("III", 3);
        romeDict.put("IV", 4);
        romeDict.put("V", 5);
        romeDict.put("VI", 6);
        romeDict.put("VII", 7);
        romeDict.put("VIII", 8);
        romeDict.put("IX", 9);
        romeDict.put("X", 10);
        romeDict.put("C", 100);

        HashMap<String, Integer> arabicDict = new HashMap<>();
        arabicDict.put("1", 1);
        arabicDict.put("2", 2);
        arabicDict.put("3", 3);
        arabicDict.put("4", 4);
        arabicDict.put("5", 5);
        arabicDict.put("6", 6);
        arabicDict.put("7", 7);
        arabicDict.put("8", 8);
        arabicDict.put("9", 9);
        arabicDict.put("10", 10);
        HashMap<String, Integer> extraRomeDict = new HashMap<>();
        extraRomeDict.put("X", 1);
        extraRomeDict.put("XX", 2);
        extraRomeDict.put("XXX", 3);
        extraRomeDict.put("XL", 4);
        extraRomeDict.put("L", 5);
        extraRomeDict.put("LX", 6);
        extraRomeDict.put("LXX", 7);
        extraRomeDict.put("LXXX", 8);
        extraRomeDict.put("XC", 9);

        String[] sub = input.split(" ");
        Intermediate.isRightMathematicOperation(sub);
        Calculation type = Calculation.NOTYPE;
        if (romeDict.containsKey(sub[0]) && romeDict.containsKey(sub[2])){
            type = Calculation.ROME;
        }
        else if (arabicDict.containsKey(sub[0]) && arabicDict.containsKey(sub[2])) {
            type = Calculation.ARABIC;
        }
        else if ((romeDict.containsKey(sub[0]) && arabicDict.containsKey(sub[2])) || (arabicDict.containsKey(sub[0]) && romeDict.containsKey(sub[2]))) {
            throw new TwoTypesException("Используются одновременно разные системы счисления");
        }
        switch (type) {
            case ROME -> {
                int a = Dict.calculation(romeDict.get(sub[0]), sub[1], romeDict.get(sub[2]));
                if (a <= 0) {
                    throw new NegativeRomeException("В римской системе нет отрицательных чисел и нуля");
                }
                if ((10 < a) && (a < 100)) {
                    return (Dict.getKeyFromValue(extraRomeDict, a / 10) + Dict.getKeyFromValue(romeDict, a % 10));
                } else return Dict.getKeyFromValue(romeDict, a);
            }
            case ARABIC -> {
                return Integer.toString(Dict.calculation(arabicDict.get(sub[0]), sub[1], arabicDict.get(sub[2])));
            }
        }
        return null;
    }
}


