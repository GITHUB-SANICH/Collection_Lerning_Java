package learning_themes.collections;


import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class CollectionLearning {
    public void learning() {
        iterable();
    }

    public void iterable(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int x : list) System.out.println("Вывод элемента: "+x);

        Iterator<Integer> iterator = list.iterator();
        int idx = 0;
        while (iterator.hasNext()){
            System.out.println("Вывод элементов через иттератор: "+iterator.next());
            if (idx == 1) iterator.remove();
            idx++;
        }
        System.out.println("Список после иттерирования: "+list);
    }

    public void stack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Последний выведенный элемент коллекции stack: "+stack.peek());
        System.out.println("Последний извлеченный элемент коллекции stack: "+stack.pop());
        System.out.println("Предпоследний извлеченный элемент коллекции stack: "+stack.pop());

        while (!stack.empty()){
            System.out.println("Извлечение последнего элемента: "+stack.pop());
        }
    }

    public void queue(){
        Human human1 = new Human(1, "one");
        Human human4 = new Human(4, "fore");
        Human human2 = new Human(2, "two");
        Human human3 = new Human(3, "tre");

        Queue<Human> humans = new LinkedList<>();
        Queue<Human> humans_blocking = new ArrayBlockingQueue<>(3);
        humans.add(human3);
        humans.add(human2);
        humans.add(human4);
        humans.add(human1);

        humans_blocking.offer(human3);
        humans_blocking.offer(human2);
        humans_blocking.offer(human4);
        humans_blocking.offer(human1);



        for (Human human : humans) System.out.println("Хумы из очереди LinkedList: "+human);
        for (Human human : humans_blocking) System.out.println("Хумы из очереди ArrayBlockingQueue: "+human);
        System.out.println("Удаление первого элемента из очереди: "+humans.remove());
        System.out.println("Вывод первого элемента в очереди: "+humans.peek());
        System.out.println("Вывод очереди: "+humans);

    }

    public void comparator_sort(){
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        strings.add("str1");
        strings.add("str2");
        strings.add("str123");
        strings.add("str3210");
        integers.add(1);
        integers.add(12);
        integers.add(13);
        integers.add(11);
        integers.add(100);
        people.add(new Person(1, "Bob"));
        people.add(new Person(4, "Katy"));
        people.add(new Person(3, "Fred"));
        people.add(new Person(2, "Jon"));


        Collections.sort(strings, new StringLengthComparator());
        Collections.sort(integers, (o1, o2) -> {
            if (o1 > o2){
                return -1;
            }else if (Objects.equals(o1, o2)){
                return 0;
            }else{
                return 1;
            }
        });
        people.sort((o1, o2) -> Integer.compare(o2.getId(), o1.getId()));
        System.out.println("Сортировка строк кастомная: "+strings);
        System.out.println("Сортировка чисел кастомная: "+integers);
        System.out.println("Сортировка людей по id: "+people);
    }

    public void comparable_sort(){
        List<Human> humanList = new ArrayList<>();
        Set<Human> humanSet = new TreeSet<>();

        this.addElements(humanList);
        this.addElements(humanSet);

        Collections.sort(humanList);

        System.out.println("HumanList: " + humanList);
        System.out.println("HumanSet: " + humanSet);
    }

    private void addElements(Collection collections){
        collections.add(new Human(2, "TwoHumanName"));
        collections.add(new Human(1, "FirstHumanName"));
        collections.add(new Human(4, "ForeHumanName"));
        collections.add(new Human(3, "TreeHumanName"));
    }

    public void hashcode_inner(){
        Map <String, Integer> scores = new HashMap<>();
        scores.put("KING", 100);
    }

    public void hashcode_and_equals(){
//        Map<Integer, String> map = new HashMap<>();
//        Set<Integer> set = new HashSet<>();
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();
        Person person1 = new Person(1, "Make");
        Person person2 = new Person(1, "Make");
//        Person person2 = new Person(2, "Katy");

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println("map: "+map);
        System.out.println("set: "+set);

    }


    public static void learning_arrayList() {

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< 10; i++) {
            list.add(i);
        }
        list.remove(5);
        System.out.println(list);

        list = new LinkedList<>();
    }

    public static void learning_linkedList(){
//        List<Integer> linkedList = new LinkedList<>();
//        List<Integer> arrayList = new ArrayList<>();
//        measureTime(linkedList);
//        measureTime(arrayList);
    }

    private static void measureTime(List<Integer> list){
//        время запуска метода
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){list.add(0, i);}
//        время завершения метда метода
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения метода: " + (end-start) + "мс");
    }

    public static void learning_HashMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");

        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    class Person {
        private int id;
        private String name;
        public Person(int id, String name){
            this.id = id;
            this.name = name;
        }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}



    class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()){
                return 1;
            }
            if (Objects.equals(o1.length(), o2.length())){
                return 0;
            }
            return -1;
        }
    }

    public class Human implements Comparable<Human>{
        private int id;
        private String name;
        public Human(int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human chelik = (Human) o;

            if (id != chelik.id) return false;
            return Objects.equals(name, chelik.name);
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public int compareTo(Human o) {
            return Integer.compare(this.id, o.getId());
        }
    }
}
