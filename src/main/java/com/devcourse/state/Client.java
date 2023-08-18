package com.devcourse.state;

public class Client {
    public static void main(String[] args) {
        PlayerContext player = new PlayerContext();
        player.currentStatePrint();

        player.buttonClick();
        player.currentStatePrint();

        player.buttonClick();
        player.currentStatePrint();
    }
}
