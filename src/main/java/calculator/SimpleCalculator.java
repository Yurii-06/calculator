package calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleCalculator {
    private static SimpleCalculator mInstance;
    static final private Logger fileLogger = LoggerFactory.getLogger("file_logger");

    private SimpleCalculator() {}

    public static SimpleCalculator getInstance() {
        if (mInstance == null) {
            mInstance = new SimpleCalculator();
        }
        return mInstance;
    }

    private int add(int firstOperand, int secondOperand) {
        fileLogger.debug("\"add\" operation performed on operands: {} and {}", firstOperand, secondOperand);
        return firstOperand + secondOperand;
    }

    private int substract(int firstOperand, int secondOperand) {
        fileLogger.debug("\"substract\" operation performed on operands: {} and {}", firstOperand, secondOperand);
        return firstOperand - secondOperand;
    }

    private int divide(int firstOperand, int secondOperand) {
        fileLogger.debug("\"divide\" operation performed on operands: {} and {}", firstOperand, secondOperand);
        return firstOperand / secondOperand;
    }

    private int multiply(int firstOperand, int secondOperand) {
        fileLogger.debug("\"multiply\" operation performed on operands: {} and {}", firstOperand, secondOperand);
        return firstOperand * secondOperand;
    }

    public int calculate(int firstOperand, int secondOperand, String operator) {
        int result = 0;
        fileLogger.debug("\"calculate\" operation performed on operands: {} and {} using operator: {}", firstOperand, secondOperand, operator);

        switch (operator) {
            case "+":
                result = add(firstOperand, secondOperand);
                break;
            case "*":
                result = multiply(firstOperand, secondOperand);
                break;
            case "/":
                result = divide(firstOperand, secondOperand);
                break;
            case "-":
                result = substract(firstOperand, secondOperand);
                break;
        }

        return result;
    }
}
