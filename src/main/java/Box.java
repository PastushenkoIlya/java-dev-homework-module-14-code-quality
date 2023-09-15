public class Box {
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
    static boolean isDraw(char[] box){


        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return false;

            }
        }
        return true;


    }
    static void printBox(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
}
