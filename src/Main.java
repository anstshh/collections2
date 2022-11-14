import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {
    private static final List<String> NAMES = List.of(
            "Иван",
            "Анна",
            "Катя",
            "Марина",
            "Владимир",
            "Ира",
            "Костя",
            "Дима",
            "Виталий",
            "Лиза"
    );
    private static final int MAX_SIZE = 5;

    public static void main(String[] args) {

        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        fillQueue(queue1);
        fillQueue(queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Первая очередь: " + queue2);
        addName("Дима", queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Первая очередь: " + queue2);
        remove(queue1, queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Первая очередь: " + queue2);
    }

    private static final Random RANDOM = new Random();

    private static void fillQueue(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }

    private static void addName(String name, Queue<String> queue1, Queue<String> queue2) {
        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE) {
            System.out.println("Позовите Галю!!");
            return;
        }
        if (queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else {
            queue2.offer(name);
        }
    }

    private static void remove(Queue<String> queue1, Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }
}