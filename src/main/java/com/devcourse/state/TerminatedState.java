package com.devcourse.state;

public class TerminatedState implements PlayerState {
    @Override
    public void buttonPush(PlayerContext context) {
        System.out.println("음악을 재생합니다.");
        context.changeState(new PlayingState());
    }

    @Override
    public String toString() {
        return "음악 정지 중";
    }
}
