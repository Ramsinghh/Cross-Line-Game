import java.util.*;

public class CrossLineGame {

    static String[] matrix;
    static String turn;

    static String checkWinner()
    {
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = matrix[0] + matrix[1] + matrix[2];
                    break;
                case 1:
                    line = matrix[3] + matrix[4] + matrix[5];
                    break;
                case 2:
                    line = matrix[6] + matrix[7] + matrix[8];
                    break;
                case 3:
                    line = matrix[0] + matrix[3] + matrix[6];
                    break;
                case 4:
                    line = matrix[1] + matrix[4] + matrix[7];
                    break;
                case 5:
                    line = matrix[2] + matrix[5] + matrix[8];
                    break;
                case 6:
                    line = matrix[0] + matrix[4] + matrix[8];
                    break;
                case 7:
                    line = matrix[2] + matrix[4] + matrix[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            }

            else if (line.equals("***")) {
                return "*";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(matrix).contains(
                    String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) {
                return "draw";
            }
        }
        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }

    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + matrix[0] + " | "
                + matrix[1] + " | " + matrix[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + matrix[3] + " | "
                + matrix[4] + " | " + matrix[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + matrix[6] + " | "
                + matrix[7] + " | " + matrix[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        matrix = new String[9];
        turn = "X";
        String winner = null;

        for (int i = 0; i < 9; i++) {
            matrix[i] = String.valueOf(i + 1);
        }

        System.out.println("Welcome to 3x3 Cross Line Game.");
        printBoard();
        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input!!\n please enter a valid slot number:");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }
            if (matrix[numInput - 1].equals(
                    String.valueOf(numInput))) {
                matrix[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "*";
                }
                else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            }
            else {
                System.out.println("Slot already taken!!\n please enter a empty slot number:");
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw!! \nThanks for playing.");
        }

        else {
            System.out.println("Congratulations!! " + winner+ "'s have won!!\nThanks for playing.");
        }
    }
}
