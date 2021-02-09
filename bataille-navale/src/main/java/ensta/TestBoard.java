package ensta;

public class TestBoard {

    public static void main(String args[]){
        Board board = new Board("TestBoard");
        board.print();

        Board board2 = new Board("TestBoard", 12);
        board2.print();
    }
}