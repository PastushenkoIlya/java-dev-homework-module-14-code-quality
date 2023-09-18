import java.util.Scanner;

public class Game {


    public void play() {
        //initializing variable


        Box box = new Box();
        box.setPositionNumbers(); // setting starting tip about position numbers

        boolean boxEmpty = false;
        GameResult gameResult = GameResult.IN_PROCESS;

        //printing starting text
        System.out.println("Enter box number to select. Enjoy!\n");

        //principal cycle
        while (true) {

            //printing the box
            box.printBox();

            //resettableIfNeeded
            boxEmpty = resetBoxIfNeeded(box, boxEmpty);

            //print "game over" output if winner is 1,2 or 3
            if (isGameResultDecided(gameResult)) break;

            //move logic
            moveLogic(box);


            //check if user has won
            if(box.isUserHasWon()) {
                gameResult = GameResult.WIN;
                continue;
            }


            //check if it is a draw
            if(box.isDraw()){
                gameResult = GameResult.DRAW;
                continue;
            }

            //computer move logic
            computerMoveLogic(box);

            //check if computer has won
            if(box.isComputerHasWon()){
                gameResult = GameResult.LOSE;
            }
        }

    }



    enum GameResult{
        WIN,LOSE,DRAW, IN_PROCESS
    }
    static boolean resetBoxIfNeeded(Box box, boolean boxEmpty) {
        if (!boxEmpty) {
            for (int i = 0; i < 9; i++)
                box.setValue(i,' ');
        }
        return true;
    }

    static boolean isGameResultDecided(final GameResult variant) {
        if (GameResult.WIN.equals(variant)) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (GameResult.LOSE.equals(variant)) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (GameResult.DRAW.equals(variant)) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    static void moveLogic(Box box) {
        Scanner scan = new Scanner(System.in);
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box.getValue(input - 1) == 'X' || box.getValue(input - 1) == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box.setValue(input-1, 'X');
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }



    static void computerMoveLogic(Box box){
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box.getValue(rand - 1) != 'X' && box.getValue(rand - 1) != 'O') {
                box.setValue(rand - 1, 'O');
                break;
            }
        }
    }

}
