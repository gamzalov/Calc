import java.util.HashMap;

class Dict {
    static int calculation(int first, String operator, int second){
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0;
        };
    }
    static String getKeyFromValue(HashMap dict, Object value){
        for (Object object : dict.keySet()) {
            if (dict.get(object).equals(value)) return (String) object;
        }
        return null;
    }
}
