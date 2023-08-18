package com.devcourse.state;

public class PlayerContext {

    private PlayerState playerState;

    public PlayerContext() {
        this.playerState = new TerminatedState();
    }

    void changeState(PlayerState state) {
        this.playerState = state;
    }

    public void buttonClick() {
        playerState.buttonPush(this);
    }

    public void currentStatePrint() {
        System.out.println(playerState.toString());
        System.out.println();
    }

}
