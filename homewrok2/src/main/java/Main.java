import java.util.*;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);

        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        //Task1
        Map<String, List<Person>> personMap = Arrays.stream(RAW_DATA)
                .distinct()
                .sorted(Comparator.comparing(Person::getId))
                .collect(groupingBy(Person::getName));
        personMap.forEach((k, v) -> System.out.printf("Key: %s%nValue:%d%n", k, v.size()));

        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Found sum from Array");
        System.out.println();
        int[] inputArray = {3, 4, 2, 7};
        int sum = 10;
        Set<Integer> set = new HashSet<>();
        for (int in : inputArray) {
            if (set.contains(in)) {
                {
                    System.out.printf("[%d, %d]%n", (sum-in), in);
                    break;
                }
            } else {
                set.add(sum-in);
            }
        }
    }

    public static boolean fuzzySearch(String pattern, String input) {
        char[] inputCharArr = input.toCharArray();
        int patternIndex = 0;
        for (char c : inputCharArr) {
            if (pattern.charAt(patternIndex) == c) {
                patternIndex++;
            }
            if (patternIndex == pattern.toCharArray().length) {
                return true;
            }
        }
        return false;
    }

}
