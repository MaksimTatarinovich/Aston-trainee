package lesson_7;

import java.util.*;
import java.util.stream.Collectors;

public class FirstExercise {
    public static void main(String[] args){
        String[] arrayOfWords = {"Конь", "Машина", "Корабль", "Кот", "Самолет", "Башня"
        , "Лопасть", "Машина", "Мотоцикл", "Кот", "Кресло", "Водоросли", "Язык", "Язык"
        , "Лосось", "Остров", "Девушка"};

        List<String> uniqueWords = Arrays.stream(arrayOfWords)
                .collect(Collectors.groupingBy(
                        w -> w, LinkedHashMap::new, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> 1L == e.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Map<String , Integer> counter = new HashMap<>();
        for (String word : arrayOfWords) {
            int newValue = counter.getOrDefault(word, 0) + 1;
            counter.put(word, newValue);
        }

        System.out.println(counter + "\n");
        System.out.println(String.join(", ", uniqueWords));
    }
}
