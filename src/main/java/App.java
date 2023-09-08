import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        //initializing variable

        byte i;
        boolean boxAvailable; //initially was false
        byte winner = 0;
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println("Enter box number to select. Enjoy!\n");


        boolean boxEmpty = false;

        while (true) {

            //printing the box
            printBox(box);

            //resettableIfNeeded
            boxEmpty = resetBoxIfNeeded(box, boxEmpty);

            //print "gameover" output if winner is 1,2 or 3
            if (isGameResultDecided(winner)) break;

            //move logic
            moveLogic(box);


            //check if user has won
            if(isUserHasWon(box)) {
                winner = 1;
                continue;
            }


            boxAvailable = false;

            for (i = 0; i < 9; i++) {
                if (box[i] != 'X' && box[i] != 'O') {
                    boxAvailable = true;
                    break;
                }
            }

            if (!boxAvailable) {
                winner = 3;
                continue;
            }

            //computer move logic
            computerMoveLogic(box);

            //check if computer has wom
            if(isComputerHasWon(box)){
                winner = 2;
            }
        }

    }

    static void printBox(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    static boolean resetBoxIfNeeded(char[] box, boolean boxEmpty) {
        if (!boxEmpty) {
            for (int i = 0; i < 9; i++)
                box[i] = ' ';
        }
        return true;
    }

    static boolean isGameResultDecided(byte winner) {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    static void moveLogic(char[] box) {
        Scanner scan = new Scanner(System.in);
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    static boolean isUserHasWon(char[] box) {
        return ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X') || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X') || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[3] == 'X' && box[6] == 'X') || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X'));
    }
    static boolean isComputerHasWon(char[] box){
        return((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O') || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O'));

    }
    static void computerMoveLogic(char[] box){
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }
}

























