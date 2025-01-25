package lesson_7;

import java.util.*;

public class TelephoneDirectory {

    private final Map<String, List<String >> directory;

    public TelephoneDirectory(){
        this.directory = new HashMap<>();
    }

    public void add(String surname, String phoneNumber){
        directory.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname){
        return directory.getOrDefault(surname, Collections.emptyList());
    }

    public static void main(String[] args){
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Tatarinovich", "+375444876598");
        telephoneDirectory.add("Ivanov", "548697");
        telephoneDirectory.add("Ivanov", "328437");

        System.out.println("Tatarinovich " + telephoneDirectory.get("Tatarinovich"));
        System.out.println("Ivanov " + telephoneDirectory.get("Ivanov"));
        System.out.println("Pushkin " + telephoneDirectory.get("Pushkin"));
    }
}
