package com.devcourse.bridge.bridge.remote;

/**
 * 모든 장치에 대한 공통 인터페이스
 */
public interface Device {

    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    void printStatus();
}
