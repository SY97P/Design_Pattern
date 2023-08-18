package com.devcourse.state;

public class PlayingState implements PlayerState {
    @Override
    public void buttonPush(PlayerContext context) {
        System.out.println("음악을 정지합니다.");
        context.changeState(new TerminatedState());
    }

    @Override
    public String toString() {
        return "음악 재생 중";
    }
}
