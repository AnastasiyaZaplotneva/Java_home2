import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;


class Calculator {
    int a;
    int b;
    double result;
    
    public void help () {
        System.out.println("Введите выражение вида (с пробелами):");
        System.out.println("a + b - для сложения чисел a и b");
        System.out.println("a - b- - для вычитания числа b из a");
        System.out.println("a * b - для перемножения чисел a и b");                    
        System.out.println("a / b - для деления число a на b");                   
        System.out.println("a ** b - для возведения числа a в степень b");
    }
    public double calculate(String str) {
        String[] elements = str.split(" ");
        // for (String string : elements) {
        //     System.out.println(string);
        // }
        int a = Integer.parseInt(elements[0]);
        int b = Integer.parseInt(elements[2]);
        
        switch(elements[1]) {
            case "+":
                result = addition(a, b);
                break;
            case "-":
                result = subtraction(a, b);
                break;
            case "*":
                result = multiplication(a, b);
                break;
            case "/":
                result = division(a, b);
                break;
            case "**":
                result = exponent(a, b);
                break;
        }
        return result;
    }

    
    private int addition (int x, int y) {
        return x+y;
    }

    private int subtraction (int x, int y) {
        return x-y;
    }

    private int multiplication (int x, int y) {
        return x*y;
    }

    private double division (int x, int y) {
        double x2 = (double) x;
        double result = x2/y;
        return result;
    }

    private double exponent (int x, int y) {
        return Math.pow(x, y);
    }
}


public class CalcDemo {

    public static void logging(String str) throws IOException {
        Logger logger = Logger.getLogger(MyArray.class.getName());
        FileHandler fh = new FileHandler("CalcDemoLog.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
                
        logger.info(str);
    }
    
    public static void main(String[] args) throws IOException {
        Calculator calc = new Calculator();
        Scanner in = new Scanner(System.in);
        calc.help();
        String exam = in.nextLine();
        
        double answer = calc.calculate(exam);
        String logMsg = exam + " = " + calc.calculate(exam);
        System.out.println(answer);
        logging(logMsg);
        in.close();       
    }
    
}