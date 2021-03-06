import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static String WORD = "программирование";
    public static char[] strToArray;
    public static String WORD_HIDDEN = "";
    public static ArrayList<String> wordList = new ArrayList<>();
    public static ArrayList<Integer> index = new ArrayList<>();
    public static ArrayList<String> usedLetters = new ArrayList<>();
    private static boolean isLetterPresent;
    public static Integer count = 0;

    public static void main(String[] args) throws IOException {
        String word = "программирование";
        strToArray = WORD.toCharArray(); // Преобразуем строку str в массив символов (char)
        System.out.println(WORD);

        System.out.println(padLeftZeros(WORD.length()));
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String letter = bufferedReader.readLine();

            if (WORD_HIDDEN.contains("_")) {

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
                        if (!wordList.get(wordList.size() - 1).contains("_")) {
                            System.out.println("Игра завершена, вы победили!");
                            wordList.clear();
                            return;
                        }
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
            wordList.add(WORD_HIDDEN);
            count++;
        }
        int size = wordList.size() - 1;
        StringBuilder sb = new StringBuilder(wordList.get(size));
        for (int i = 0; i < index.size(); i++) {
            sb.replace(index.get(i), index.get(i) + 1, String.valueOf(strToArray[length]));
        }
        wordList.add(sb.toString());
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