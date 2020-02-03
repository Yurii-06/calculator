package calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputValuesHandler {
    static final private Logger fileLogger = LoggerFactory.getLogger("file_logger");
    private int firstOperand;
    private int secondOperand;
    private String operator;
    private final String VALID_MATH_OPERATORS = "+/-*";
    private final int INPUT_LENGTH_MINIMUM = 5;

    private static InputValuesHandler mInstance;

    private InputValuesHandler() { }

    public static InputValuesHandler getInstance() {
        if (mInstance == null) {
            mInstance = new InputValuesHandler();
        }
        return mInstance;
    }

    public boolean isValidValues(String userInput) {
        boolean isInputValueValid = true;

        if (userInput != null) {
            if (userInput.length() >= INPUT_LENGTH_MINIMUM) {
                userInput = userInput.trim();
                final var valuesArray = userInput.split(" ");

                try {
                    Integer.parseInt(valuesArray[0]);
                    String operator = valuesArray[1];
                    final var secondOperand = Integer.parseInt(valuesArray[2]);

                    if (!VALID_MATH_OPERATORS.contains(operator)) {
                        isInputValueValid = false;
                        fileLogger.debug("Entered invalid operator -> {}!", operator);
                    } else if(operator.equals("/") & secondOperand == 0) {
                        fileLogger.debug("Divison by zero!");
                        isInputValueValid = false;
                    }

                } catch (Exception e) {
                    fileLogger.debug("Couldn't cast operands to int value!");
                    isInputValueValid = false;
                }
            } else {
                isInputValueValid = false;
                fileLogger.debug("Expression length is less then 5 symbols!");
            }
        } else {
            isInputValueValid = false;
            fileLogger.debug("Input value is null! Couldn't perform input value checking.");
        }

        return isInputValueValid;
    }

    public void setValues(String input) {
        fileLogger.debug("Set InputValuesHandler values. Input string is: {}.", input);

        final var valuesArray = input.split(" ");

        firstOperand = Integer.parseInt(valuesArray[0]);
         operator = valuesArray[1];
        secondOperand = Integer.parseInt(valuesArray[2]);
    }


    public int getFirstOperand() {
        return firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public String getOperator() {
        return operator;
    }
}
