import java.util.Scanner;
import java.util.Stack;

public class ThirdTask {
    public static void Calculator() {
        System.Logger logger = System.getLogger("ThirdTask");
        logger.log(System.Logger.Level.INFO, "Calculator start");
        Scanner scanner = new Scanner(System.in);

        double currentResult = 0.0;
        Stack<Double> resultsStack = new Stack<>();

        while(true)
        {
            System.out.println("Введите операцию (+, -, *, /, undo, exit) : ");
            String operation = scanner.nextLine();
            if (operation.equalsIgnoreCase("Выход"))
            {
                logger.log(System.Logger.Level.INFO, "Выход из калькулятора");
                break;
            } else if (operation.equalsIgnoreCase("Отменить"))
            {
                if (!resultsStack.isEmpty())
                {
                    currentResult = resultsStack.pop();
                    System.out.println("Предыдущий результат: " + currentResult);
                } else
                {
                    System.out.println("Нет предыдущих результатов для отмены.");
                }
                continue;
            }

            double num1, num2;
            System.out.println("Введите первое число : ");
            if (scanner.hasNextDouble())
            {
                num1 = scanner.nextDouble();
            } else
            {
                System.out.println("Введено некорректное значение. Попробуйте еще раз.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            System.out.println("Введите второе число : ");
            if (scanner.hasNextDouble())
            {
                num2 = scanner.nextDouble();
            } else {
                System.out.println("Введено некорректное значение. Попробуйте еще раз.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch(operation)
            {
                case "+":
                    currentResult = num1 + num2;
                    break;
                case "-":
                    currentResult = num1 - num2;
                    break;
                case "*":
                    currentResult = num1 * num2;
                    break;
                case "/":
                    if(num2 == 0)
                    {
                        logger.log(System.Logger.Level.ERROR, "Деление на 0");
                        return;
                    }
                    currentResult = num1 / num2;
                    break;
                default:
                    logger.log(System.Logger.Level.ERROR, "Неверная операция!");
                    continue;
            }
            resultsStack.push(currentResult);
            logger.log(System.Logger.Level.INFO, String.format("%f %s %f = %f", num1, operation, num2, currentResult));
        }
        scanner.close();
    }
}