package ru.job4j.loop;

public class Board {

    public String drawBoard(int length, int width) {
        StringBuilder myBoard = new StringBuilder();

        String slineN = System.getProperty("line.separator");
        char cLineN = slineN.charAt(0);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) {
                    myBoard.append('x');
                } else {
                    char lastChar = myBoard.charAt(myBoard.length() - 1);

                    if (lastChar == cLineN) {
                        if (width % 2 == 0) {
                            lastChar = myBoard.charAt(myBoard.length() - 3);
                        } else {
                            lastChar = myBoard.charAt(myBoard.length() - 2);
                        }
                    }
                    if (lastChar == 'x') {
                        myBoard.append(' ');
                    } else {
                        myBoard.append('x');
                    }
                }
            }
            myBoard.append(cLineN);
        }
        String graph = myBoard.toString();
        return graph;
    }

    public static void main(String[] args) {
        Board newBoard = new Board();
        String graph = newBoard.drawBoard(6, 51);

        System.out.print(graph);
    }
}
