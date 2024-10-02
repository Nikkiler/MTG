package edu.qasmt.nikita.mtg;

public class Cell {
    private boolean isMine = false;
    private boolean isRevealed = false;
    private boolean isFlagged = false;
    private int adjacentMines = 0;
    MineSweeperPlayer player = MineSweeperPlayer.getInstance();

    public boolean getIsMine() {
        return isMine;
    }

    public boolean getIsRevealed() {
        return isRevealed;
    }

    public boolean getIsFlagged() {
        return isFlagged;
    }

    public int getAdjacentMines () {
        return adjacentMines;
    }

    public void setMine() {
        isMine = true;
    }

    public void reveal() {
        isRevealed = true;
    }

    public void changeFlag() {
        if (isFlagged) {
            isFlagged = false;
            player.takeFlag();
        } else {
            isFlagged = true;
            player.addFlag();
        }
    }

    public void setAdjacentMines(int n) {
        adjacentMines = n;
    }

}
