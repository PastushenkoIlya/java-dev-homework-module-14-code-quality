public class Box {
    private char [] box = new char[9];
    public void setPositionNumbers(){
        box = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }
    public char getValue(int position){
        return box[position];
    }
    public void setValue(int position, char value){
        box[position] = value;
    }
    public boolean isUserHasWon() {
        return ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X') || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X') || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[3] == 'X' && box[6] == 'X') || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X'));
    }
    public boolean isComputerHasWon(){
        return((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O') || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O'));
    }
    public boolean isDraw(){
        for (int i = 0; i < 9; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                return false;
            }
        }
        return true;
    }
    public void printBox() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }
}
