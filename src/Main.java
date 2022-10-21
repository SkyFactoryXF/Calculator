import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пример из двух римских или арабских чисел.\nЧисла от 1 до 10:");
        String operation = scanner.nextLine();
        String result = calc(operation);
        System.out.println(result);
    }

    public static String calc(String input) throws Exception {
        String[] list = input.split(" ");
        if(list.length != 3) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        ArabicNum arabicNum = new ArabicNum(list[0], list[1], list[2]);
        // Здесь закончили получать данные и переходим к вычислениям
        int a = ArabicNum.a,
            b = ArabicNum.b,
            result;
        String operator = list[1];
        if((a <= 10 && a > 0) && (b <= 10 && b > 0)) {
            switch (operator) {
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                default:
                    throw new Exception("Неизветный оператор (+, -, /, *)");
            }
        } else {
            throw new Exception("Числа должны быть от 1 до 10.");
        }
        if(ArabicNum.cID != 0) {
            if (result < 0) throw new Exception("В римской системе нет отрицательных чисел");
            return ArabicNum.ArabicToRoman(result);
        }
        return Integer.toString(result);
    }
}