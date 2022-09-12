package Controllers;

import models.Board;
import models.Player;

import java.util.List;

public class GameController {

    private List<Player>players;
    private Board board;

    public GameController(List<Player>players, Board board){
        this.players = players;
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean addPiece(int row, int col, String playingPiece){
//        System.out.println("row " + row + "col " + col);
        String [][]cells = board.getCells();
        if(row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize() || cells[row][col] != null)
            return false;

        cells[row][col] = playingPiece;
        board.setOccupiedCells(board.getOccupiedCells()+1);
        return true;
    }

    public boolean checkWinner(Player player){

        String playingPiece = player.getPlayingPiece();

        // 3 things to check
        // 1. checking for vertical
        // 2. checking for horizontal
        // 3. checking for diagonal and anti-diagonal

        if(checkColumnWinningCondition(playingPiece))
            return true;

        if(checkRowWinningCondition(playingPiece))
            return true;

        if(checkDiagonalWinningCondition(playingPiece))
            return true;

        if(checkAntiDiagonalWinningCondition(playingPiece))
            return true;

        return false;
    }

    public boolean checkColumnWinningCondition(String playingPiece){

        String [][] cells = board.getCells();
        for(int i=0; i< board.getSize(); i++){
            int cnt =0;
            for(int j=0;j<board.getSize();j++){
                if(cells[j][i] == playingPiece){
                    cnt++;
                }
            }

            if(cnt == board.getSize())
                return true;
        }

        return false;
    }

    public boolean checkRowWinningCondition(String playingPiece){
        String [][] cells = board.getCells();
        for(int i=0; i< board.getSize(); i++){
            int cnt =0;
            for(int j=0;j<board.getSize();j++){
                if(cells[i][j] == playingPiece){
                    cnt++;
                }
            }

            if(cnt == board.getSize())
                return true;
        }

        return false;
    }

    public boolean checkDiagonalWinningCondition(String playingPiece){

        String [][] cells = board.getCells();
        int cnt = 0;
        for(int i=0; i< board.getSize(); i++){
            if(cells[i][i] == playingPiece){
                cnt++;
            }
        }

        if(cnt == board.getSize())
            return true;

        return false;
    }

    public boolean checkAntiDiagonalWinningCondition(String playingPiece){

        String [][] cells = board.getCells();
        int cnt = 0, size = board.getSize();
        for(int i=0; i< board.getSize(); i++){
            if(cells[i][size - i - 1] == playingPiece){
                cnt++;
            }
        }

        if(cnt == board.getSize())
            return true;

        return false;
    }


}
