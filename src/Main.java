import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задания [1, 3] : ");
        int task = scanner.nextInt();
        switch (task)
        {
            case 1 :
                FirstTask.firstTask();
                break;
            case 2 :
                SecondTask<String> queue = new SecondTask<>();
                queue.enqueue("first");
                queue.enqueue("second");
                queue.enqueue("third");

                System.out.println("Размер очереди : " + queue.size());
                System.out.println("Первый элемент : " + queue.first());

                System.out.println("Dequeue 1 : " + queue.dequeue());
                System.out.println("Dequeue 2 : " + queue.dequeue());
                System.out.println("Dequeue 3 : " + queue.dequeue());

                System.out.println("Пустая ли очередь? " + queue.isEmpty());
                break;
            case 3 :
                ThirdTask.Calculator();
                break;
            default :
                System.out.println("Нет такого номера задания :)");
        }
        scanner.close();
    }
}