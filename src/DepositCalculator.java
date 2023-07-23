import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().calculate();
    }
    /*
    В параметрах метода calculateComplexPercentFunction использовал бы такие же имена как
    и у метода calculateSimplePercentFunction.
    Как понял они берут одни и теже значения.
     */
    double calculateComplexPercentFunction(double a, double y, int d) {
       double pay = a * Math.pow((1 + y / 12), 12 * d);
       return round(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        double contributionResult = 0;

        if (action == 1) {
            contributionResult = calculateSimplePercentFunction(amount, 0.06, period);
        } else if (action == 2) {
            contributionResult = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за "
                + period + " лет превратятся в " + contributionResult);
    }
}
