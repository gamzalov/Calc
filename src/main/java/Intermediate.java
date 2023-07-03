import java.util.HashSet;
import Exception.*;
class Intermediate {
    static void isRightMathematicOperation(String[] sub) throws NotMathematicOperation {
        HashSet<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        HashSet<String> digits = new HashSet<>();
        digits.add("1");
        digits.add("2");
        digits.add("3");
        digits.add("4");
        digits.add("5");
        digits.add("6");
        digits.add("7");
        digits.add("8");
        digits.add("9");
        digits.add("10");
        digits.add("I");
        digits.add("II");
        digits.add("III");
        digits.add("IV");
        digits.add("V");
        digits.add("VI");
        digits.add("VII");
        digits.add("VIII");
        digits.add("IX");
        digits.add("X");

        if (sub.length < 3) {
            throw new NotMathematicOperation("Cтрока не является математической операцией");
        }
        if ((sub.length > 3) || !(operators.contains(sub[1]) && digits.contains(sub[0]) && digits.contains(sub[2]))) {
            throw new NotMathematicOperation("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
}
