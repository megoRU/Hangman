import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static String WORD = "программирование";
    public static char[] strToArray;
    public static String WORD_HIDDEN = "";
    public static ArrayList<String> word = new ArrayList<>();
    public static ArrayList<Integer> index = new ArrayList<>();
    public static ArrayList<String> usedLetters = new ArrayList<>();
    private static boolean isLetterPresent;
    public static Integer count = 0;

    public static void main(String[] args) throws IOException {
        String word = "программирование";
        // char x = '_';
        strToArray = WORD.toCharArray(); // Преобразуем строку str в массив символов (char)
//        for (int i = 0; i < strToArray.length; i++) {
//          // System.out.println(strToArray[i]);
//        }
        System.out.println(WORD);
        StringBuffer sb = new StringBuffer("Юра");
        sb.replace(1, 6, "ProgLang");

        System.out.println(padLeftZeros(WORD.length()));
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String letter = bufferedReader.readLine();

            for (String listLoop : usedLetters) {
                if (listLoop.contains(letter)) {
                    isLetterPresent = true;
                    break;
                }
                if (!listLoop.contains(letter)) {
                    isLetterPresent = false;
                }
            }
            System.out.println();
            if (letter.length() == 1) {

                if (isIsLetterPresent()) {
                    System.out.println("Вы уже использовали эту букву!");
                }

                if (!isIsLetterPresent()) {
                    usedLetters.add(letter);
                }


                if (!isIsLetterPresent() && word.contains(letter)) {
                    System.out.println(word.indexOf(letter));
                    char c = letter.charAt(0);
                    checkMethod(strToArray, c);
                    System.out.println("Слово которое получилось: " + replacementLetters(word.indexOf(letter)));
                }

                if (!word.contains(letter)) {
                    System.out.println("Такой буквы нет!");
                }
            }
            if (letter.length() > 1) {
                System.out.println("Нужна 1 буква!");
            }
        }
    }

    //Создает скрытую линию из длины слова
    public static String padLeftZeros(int length) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length) {
            sb.append('_');
        }
        //sb.append(inputString);
        WORD_HIDDEN = sb.toString();
        return sb.toString();
    }

    //Ищет все одинаковые буквы и записывает в коллекцию
    public static String replacementLetters(int length) {
        if (count < 1) {
            word.add(WORD_HIDDEN);
            count++;
        }
        int size = word.size() - 1;
        StringBuilder sb = new StringBuilder(word.get(size));
        for (int i = 0; i < index.size(); i++) {
            sb.replace(index.get(i), index.get(i), String.valueOf(strToArray[length]));
        }
        word.add(sb.toString());
        index.clear();
        return sb.toString();
    }

    //Ищет все одинаковые буквы и записывает в коллекцию
    public static void checkMethod(char[] checkArray, char letter) {
        for (int i = 0; i < checkArray.length; i++) {
            if (checkArray[i] == letter) {
                checkArray[i] = letter;
                index.add(i);
                //System.out.println(checkArray[i]);
            }
        }
    }

    public static boolean isIsLetterPresent() {
        return isLetterPresent;
    }
}