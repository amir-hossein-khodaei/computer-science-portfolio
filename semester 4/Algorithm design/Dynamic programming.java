import java.util.Scanner;

public class shekarchi {

    static int boardNumRows;
    static int boardNumCols;
    static char[][] mainGameBoard;
    static int[][] calculatedScores;

    public static void main(String[] commandLineArguments) {
        Scanner inputReader = new Scanner(System.in);

        boardNumRows = inputReader.nextInt();
        boardNumCols = inputReader.nextInt();
        inputReader.nextLine();

        mainGameBoard = new char[boardNumRows][boardNumCols];
        int rCounter1;
        for (rCounter1 = 0; rCounter1 < boardNumRows; rCounter1 = rCounter1 + 1) {
            String rowStringVal = inputReader.nextLine();
            int cCounter1;
            for (cCounter1 = 0; cCounter1 < boardNumCols; cCounter1 = cCounter1 + 1) {
                mainGameBoard[rCounter1][cCounter1] = rowStringVal.charAt(cCounter1);
            }
        }

        calculatedScores = new int[boardNumRows][boardNumCols];
        int rCounter2;
        for (rCounter2 = 0; rCounter2 < boardNumRows; rCounter2 = rCounter2 + 1) {
            int cCounter2;
            for (cCounter2 = 0; cCounter2 < boardNumCols; cCounter2 = cCounter2 + 1) {
                calculatedScores[rCounter2][cCounter2] = -1;
            }
        }

        int highestScoreSoFar = 0;

        int startPieceRow;
        for (startPieceRow = 0; startPieceRow < boardNumRows; startPieceRow = startPieceRow + 1) {
            int startPieceCol;
            for (startPieceCol = 0; startPieceCol < boardNumCols; startPieceCol = startPieceCol + 1) {

                char currentPiece = mainGameBoard[startPieceRow][startPieceCol];

                if (currentPiece == 'W') {
                    int firstStepTargetRow;
                    int firstStepTargetCol;
                    boolean isFirstStepValid;
                    char pieceAtFirstStep;
                    int scoreFromThisPath;

                    firstStepTargetRow = startPieceRow - 1;
                    firstStepTargetCol = startPieceCol - 1;
                    isFirstStepValid = firstStepTargetRow >= 0;
                    if (firstStepTargetRow >= boardNumRows) { isFirstStepValid = false; }
                    if (firstStepTargetCol < 0) { isFirstStepValid = false; }

                    if (isFirstStepValid) {
                        pieceAtFirstStep = mainGameBoard[firstStepTargetRow][firstStepTargetCol];
                        if (pieceAtFirstStep != 'W') {
                            scoreFromThisPath = getMaxKillsFromThisPosition(firstStepTargetRow, firstStepTargetCol);
                            if (scoreFromThisPath > highestScoreSoFar) {
                                highestScoreSoFar = scoreFromThisPath;
                            }
                        }
                    }

                    firstStepTargetRow = startPieceRow - 1;
                    firstStepTargetCol = startPieceCol;
                    isFirstStepValid = firstStepTargetRow >= 0;
                    if (firstStepTargetRow >= boardNumRows) { isFirstStepValid = false; }
                    if (firstStepTargetCol >= boardNumCols) { isFirstStepValid = false; }

                    if (isFirstStepValid) {
                        pieceAtFirstStep = mainGameBoard[firstStepTargetRow][firstStepTargetCol];
                        if (pieceAtFirstStep != 'W') {
                            scoreFromThisPath = getMaxKillsFromThisPosition(firstStepTargetRow, firstStepTargetCol);
                            if (scoreFromThisPath > highestScoreSoFar) {
                                highestScoreSoFar = scoreFromThisPath;
                            }
                        }
                    }

                    firstStepTargetRow = startPieceRow - 1;
                    firstStepTargetCol = startPieceCol + 1;
                    isFirstStepValid = firstStepTargetRow >= 0;
                    if (firstStepTargetRow >= boardNumRows) { isFirstStepValid = false; }
                    if (firstStepTargetCol < 0) { isFirstStepValid = false; }
                    if (firstStepTargetCol >= boardNumCols) { isFirstStepValid = false; }

                    if (isFirstStepValid) {
                        pieceAtFirstStep = mainGameBoard[firstStepTargetRow][firstStepTargetCol];
                        if (pieceAtFirstStep != 'W') {
                            scoreFromThisPath = getMaxKillsFromThisPosition(firstStepTargetRow, firstStepTargetCol);
                            if (scoreFromThisPath > highestScoreSoFar) {
                                highestScoreSoFar = scoreFromThisPath;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(highestScoreSoFar);
        inputReader.close();
    }

    public static int getMaxKillsFromThisPosition(int activeRow, int activeCol) {

        boolean isRowOffBoard = activeRow < 0 || activeRow >= boardNumRows;
        boolean isColOffBoard = activeCol < 0 || activeCol >= boardNumCols;

        if (isRowOffBoard || isColOffBoard) {
            return 0;
        }

        if (mainGameBoard[activeRow][activeCol] == 'W') {
            return Integer.MIN_VALUE;
        }

        if (calculatedScores[activeRow][activeCol] != -1) {
            return calculatedScores[activeRow][activeCol];
        }

        int killCountOnThisSquare = 0;
        if (mainGameBoard[activeRow][activeCol] == 'B') {
            killCountOnThisSquare = 1;
        }

        int bestScoreFromLaterMoves = 0;
        int scoreFromNextStep;

        int potentialNextR_Opt1 = activeRow - 1;
        int potentialNextC_Opt1 = activeCol - 1;
        scoreFromNextStep = getMaxKillsFromThisPosition(potentialNextR_Opt1, potentialNextC_Opt1);
        if (scoreFromNextStep != Integer.MIN_VALUE) {
            if (scoreFromNextStep > bestScoreFromLaterMoves) {
                bestScoreFromLaterMoves = scoreFromNextStep;
            }
        }

        int potentialNextR_Opt2 = activeRow - 1;

        scoreFromNextStep = getMaxKillsFromThisPosition(potentialNextR_Opt2, activeCol);
        if (scoreFromNextStep != Integer.MIN_VALUE) {
            if (scoreFromNextStep > bestScoreFromLaterMoves) {
                bestScoreFromLaterMoves = scoreFromNextStep;
            }
        }

        int potentialNextR_Opt3 = activeRow - 1;
        int potentialNextC_Opt3 = activeCol + 1;
        scoreFromNextStep = getMaxKillsFromThisPosition(potentialNextR_Opt3, potentialNextC_Opt3);
        if (scoreFromNextStep != Integer.MIN_VALUE) {
            if (scoreFromNextStep > bestScoreFromLaterMoves) {
                bestScoreFromLaterMoves = scoreFromNextStep;
            }
        }

        int totalKillsValue = killCountOnThisSquare + bestScoreFromLaterMoves;
        calculatedScores[activeRow][activeCol] = totalKillsValue;
        return totalKillsValue;
    }
}