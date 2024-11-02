import java.util.Scanner;

public class Calculator {
    private double result; // 현재 계산 결과 값

    // 생성자: 초기 결과 값 설정
    public Calculator(double initialValue) {
        this.result = initialValue;
    }

    // 덧셈 메소드
    public void add(double value) {
        result += value;
        System.out.println("결과: " + result);
    }

    // 뺄셈 메소드
    public void subtract(double value) {
        result -= value;
        System.out.println("결과: " + result);
    }

    // 곱셈 메소드
    public void multiply(double value) {
        result *= value;
        System.out.println("결과: " + result);
    }

    // 나눗셈 메소드
    public void divide(double value) {
        if (value != 0) {
            result /= value;
            System.out.println("결과: " + result);
        } else {
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }

    // 현재 결과 값 가져오기
    public double getResult() {
        return result;
    }

    // 계산 수행 메소드
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("초기 값을 입력하세요:");
        double initialValue = scanner.nextDouble();
        Calculator calculator = new Calculator(initialValue); // 초기 값으로 계산기 생성

        while (true) {
            System.out.println("현재 결과: " + calculator.getResult());
            System.out.println("원하는 연산자를 입력하세요 (+, -, *, /) 또는 '종료' 입력하여 종료:");
            String operation = scanner.next();

            if (operation.equals("종료")) {
                System.out.println("계산을 종료합니다. 최종 결과: " + calculator.getResult());
                break;
            }

            System.out.println("연산할 값을 입력하세요:");
            double value = scanner.nextDouble();

            switch (operation) {
                case "+":
                    calculator.add(value);
                    break;
                case "-":
                    calculator.subtract(value);
                    break;
                case "*":
                    calculator.multiply(value);
                    break;
                case "/":
                    calculator.divide(value);
                    break;
                default:
                    System.out.println("잘못된 연산자입니다. 다시 입력해 주세요.");
                    continue; // 잘못된 연산자일 때 다음 반복으로 넘어가기
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Calculator calculatorApp = new Calculator(0); // 초기 값 0으로 시작
        calculatorApp.start(); // 사용자 입력 기반 계산 시작
    }
}
