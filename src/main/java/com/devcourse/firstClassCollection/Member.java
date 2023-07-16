package com.devcourse.firstClassCollection;

import java.util.UUID;

public class Member {

    private final UUID id;
    private final String name;
    private final boolean isAlive;

    public Member(UUID id, String name, boolean isAlive) {
        this.id = id;
        this.name = name;
        this.isAlive = isAlive;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAlive=" + isAlive +
                '}';
    }
}
