package calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ClientRunner {
    static final private Logger log = LoggerFactory.getLogger(ClientRunner.class);

    public static void main(String[] args) {
        boolean isSessionFinish = false;
        final var calculator = SimpleCalculator.getInstance();
        final var inputValuesHandler = InputValuesHandler.getInstance();
        final Scanner scanner = new Scanner(System.in);

        while (!isSessionFinish) {

            log.info("Enter expression to calculate in the next form: [first_operand operator second_operand] (or \"exit\" -> to finish session)");
            log.info("Operands must be separated with space symbol i.e [1 + 1]");

            final var input = scanner.nextLine();
            final var validValues = inputValuesHandler.isValidValues(input);

            if (validValues) {
                inputValuesHandler.setValues(input);
                final var firstOperand = inputValuesHandler.getFirstOperand();
                final var secondOperand = inputValuesHandler.getSecondOperand();
                final var operator = inputValuesHandler.getOperator();

                final var result = calculator.calculate(firstOperand, secondOperand, operator);
                log.info("result is: " + result);
            } else {
                if (input.equals("exit")) {
                    isSessionFinish = true;
                    log.info("You finished your session with calculator! Bye!");
                } else {
                    log.info("You entered invalid values! Try again!");
                }
            }
        }
    }
}
