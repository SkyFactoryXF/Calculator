public class ArabicNum {
    static String[] in = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"}; // Входящие числа
    static String[] out = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X",
            "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
            "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
            "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
            "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
            "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
            "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
            "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
            "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
            "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"}; // То что выдаём в ответе

    static int a,b,output,cID = 0;

    ArabicNum(String firstNumber, String operation, String secondNumber) { // Определяем оба числа арабские или оба числа римские и присваиваем числа нашим переменным
        try {
            for (String in: in) {
                if (firstNumber.toUpperCase().equals(in)) {
                    firstNumber = firstNumber.toUpperCase();
                    cID++;
                }
                if (secondNumber.toUpperCase().equals(in)) {
                    secondNumber = secondNumber.toUpperCase();
                    cID++;
                }
            }
            switch (cID) {
                case 0:
                    a = Integer.parseInt(firstNumber);
                    b = Integer.parseInt(secondNumber);
                    break;
                case 1:
                    throw new Exception("Используются одновременно разные системы счисления");
                case 2:
                    a = RomanToArabic(firstNumber);
                    b = RomanToArabic(secondNumber);
                    break;
            }
        }
        catch (Exception e) { System.err.println("Ошибка: Введите цифру от 1 до 10. " + e.getMessage()); }
    }

    static int RomanToArabic (String roman) {
        for (int i = 0; i < in.length; i++) {
            if (roman.equals(in[i])){
                return i;
            }
        }
        return -1;
    }
    static String ArabicToRoman(int arab ) {
        try {
            return out[arab];
        } catch(IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }
        return "";
    }
}
