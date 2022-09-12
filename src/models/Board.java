package models;

public class Board {
    private int size;
    private String [][] cells;
    private int occupiedCells;

    public Board(int size){
        this.size = size;
        this.cells = new String[size][size];
        this.occupiedCells = 0;
        printBoard();
    }

    public int getSize() {
        return size;
    }

    public void setCells(String[][] cells) {
        this.cells = cells;
    }

    public String[][] getCells() {
        return cells;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOccupiedCells() {
        return occupiedCells;
    }

    public void setOccupiedCells(int occupiedCells) {
        this.occupiedCells = occupiedCells;
    }

    public void printBoard(){

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(cells[i][j] == null){
                    System.out.print("- ");
                } else{
                    System.out.print(cells[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
