import java.util.Scanner;

public class Game {
    public static void play() {
        //initializing variable

        byte winner = 0;
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;

        while (true) {

            //printing the box
            Box.printBox(box);

            //resettableIfNeeded
            boxEmpty = resetBoxIfNeeded(box, boxEmpty);

            //print "game over" output if winner is 1,2 or 3
            if (isGameResultDecided(winner)) break;

            //move logic
            moveLogic(box);


            //check if user has won
            if(Box.isUserHasWon(box)) {
                winner = 1;
                continue;
            }


            //check if it is a draw
            if(Box.isDraw(box)){
                winner = 3;
                continue;
            }

            //computer move logic
            computerMoveLogic(box);

            //check if computer has won
            if(Box.isComputerHasWon(box)){
                winner = 2;
            }
        }

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
