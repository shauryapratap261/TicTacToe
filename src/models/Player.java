package models;


public class Player {
    private String name;
    private String playingPiece;

    public Player(String name, String playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(String playingPiece) {
        this.playingPiece = playingPiece;
    }
}
