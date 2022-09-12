import Controllers.GameController;
import models.Board;
import models.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int MAX_PLAYERS = 2;
    static final int BOARD_SIZE = 3;

    public static void main(String[] args) {


        List<Player> players = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<MAX_PLAYERS;i++){
            String command = scanner.nextLine();
            String [] commands = command.split(" ");
            players.add(new Player(commands[1], commands[0]));
        }


        Board board = new Board(BOARD_SIZE);

        GameController gameController = new GameController(players, board);
        int currentPlayerIndex = 0;
        boolean playerWon = false;

        while(true){

            String command = scanner.nextLine();
            String [] commands = command.split(" ");

            if(commands[0].equals("exit"))
                break;

            // ignores all moves after a player won or no valid moves left
            if(playerWon == true || gameController.getBoard().getOccupiedCells() == gameController.getBoard().getSize() * gameController.getBoard().getSize())
                continue;

            int row = Integer.parseInt(commands[0]) - 1;
            int col = Integer.parseInt(commands[1]) - 1;
            Player playerTurn = players.get(currentPlayerIndex);


            if(!(gameController.addPiece(row, col, playerTurn.getPlayingPiece()))){
                // Invalid case
                System.out.println("Invalid Move");
            } else{

                if(gameController.checkWinner(playerTurn)){
                    playerWon = true;
                    System.out.println(playerTurn.getName() + " won the game");
                }

                if(gameController.getBoard().getOccupiedCells() == gameController.getBoard().getSize() * gameController.getBoard().getSize()){
                    System.out.println("Game Over");
                }

                gameController.getBoard().printBoard();

                currentPlayerIndex = (currentPlayerIndex + 1) % MAX_PLAYERS;

            }
        }

    }
}
