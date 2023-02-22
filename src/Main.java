import java.util.*;

public class Main {
    public static void main(String[] args) {
//        ex0();
        System.out.println(ex1());
    }

    public static void ex0() {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Маша", "89564562250");
        phoneBook.put("Саша", "89284958564");
        phoneBook.put("Каша", "89346846581");
        System.out.println("Сколько номеров вы хотите добавить: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Введите имя контакта: ");
            String name = scanner.next();
            System.out.println("Введите номер: ");
            String number = scanner.next();
            if (phoneBook.containsKey(name)) {
                String oldNumber = phoneBook.get(name);
                StringJoiner stringJoiner = new StringJoiner("/");
                String newNumbers = stringJoiner.add(oldNumber).add(number).toString();
                phoneBook.put(name, newNumbers);
            } else {
                phoneBook.put(name, number);
            }
        }
        System.out.println(phoneBook);
    }

    static TreeMap ex1() {
        String s = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";
        s = s.replace(".", "");
        s = s.replace(",", "");
        String[] words = s.split(" ");
        System.out.println(Arrays.toString(words));
        ArrayList<String> arrayName = new ArrayList<>();
        int valueMax = 1;
        for (int i = 0; i < words.length; i += 2) {
            arrayName.add(words[i]);
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String word : arrayName) {
            if (treeMap.containsKey(word)){
                treeMap.put(word, treeMap.get(word) + 1);
            } else {
                treeMap.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()){
            if (valueMax < entry.getValue()){
                valueMax = entry.getValue();
            }
        }
        TreeMap<String, Integer> sortMap = new TreeMap<>();
        for (int i = 0; i < treeMap.size(); i++) {
            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                if (valueMax == entry.getValue()) {
                    sortMap.put(entry.getKey(), entry.getValue());
                }
            }
            valueMax--;
        }
        return sortMap;
    }
}