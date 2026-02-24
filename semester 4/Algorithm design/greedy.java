import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class greedy {

    public static void processInputStage(String[] args) {
        Scanner inputDevice = new Scanner(System.in);
        int targetNumber = inputDevice.nextInt();
        inputDevice.close();

        int validationOutcome = preFlightCheck(targetNumber);

        if (validationOutcome == -1) {
            System.out.println("-1");
        } else if (validationOutcome == 0) {
            System.out.println("1");
        } else {
            executeCoreRepunitLogic(targetNumber);
        }
    }

    private static int preFlightCheck(int num) {
        if (num == 1) {
            return 0;
        }

        boolean endsInZero = (num % 10 == 0);
        boolean endsInFive = (num % 10 == 5);
        boolean isEvenAndNotEndingInZero = (num % 2 == 0 && !endsInZero);

        if (endsInZero || endsInFive || isEvenAndNotEndingInZero) {
            return -1;
        }
        return 1;
    }

    private static class RepunitLengthState {
        long currentRemainderModN;
        int stepsTaken;
        boolean targetFound;

        RepunitLengthState(long rem, int steps, boolean found) {
            this.currentRemainderModN = rem;
            this.stepsTaken = steps;
            this.targetFound = found;
        }

        RepunitLengthState nextState(int n_val) {
            if (targetFound) return this;

            long newRem = (this.currentRemainderModN * 10 + 1) % n_val;
            int newSteps = this.stepsTaken + 1;
            boolean newFound = (newRem == 0);
            return new RepunitLengthState(newRem, newSteps, newFound);
        }
    }

    private static void executeCoreRepunitLogic(int n_value) {
        RepunitLengthState state = new RepunitLengthState(1 % n_value, 1, (1 % n_value) == 0);

        for (int safetyCounter = 0; safetyCounter < n_value * 2 && !state.targetFound; safetyCounter++) {
            state = state.nextState(n_value);
        }

        int numberOfOnes = state.stepsTaken;

        StringBuilder quotientBuilder = new StringBuilder();
        long currentSegmentForDivision = 0;
        boolean firstDigitProcessed = false;

        for (int k = 0; k < numberOfOnes; k++) {
            currentSegmentForDivision = currentSegmentForDivision * 10 + 1;
            if (currentSegmentForDivision >= n_value) {
                long digitOfQuotient = currentSegmentForDivision / n_value;
                quotientBuilder.append(digitOfQuotient);
                currentSegmentForDivision = currentSegmentForDivision % n_value;
                firstDigitProcessed = true;
            } else {
                if (firstDigitProcessed) {
                    quotientBuilder.append(0);
                }
            }
        }

        String finalQuotientStr = quotientBuilder.toString();
        if (finalQuotientStr.isEmpty() && n_value != 1) {
            System.out.println("0");
        } else {
            System.out.println(finalQuotientStr.isEmpty() ? "1" : finalQuotientStr);
        }
    }

    public static void main(String[] commandLineArgs) {
        processInputStage(commandLineArgs);
    }
}