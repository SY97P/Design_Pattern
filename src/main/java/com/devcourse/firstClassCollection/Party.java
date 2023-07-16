package com.devcourse.firstClassCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Party {

    static final int MAX_MEMBER_COUNT = 4;

    private final List<Member> members;

    Party() {
        this.members = new ArrayList<>();
    }

    private Party(List<Member> members) {
        this.members = members;
    }

    Party add(final Member newMember) {
        if (exists(newMember)) {
            throw new RuntimeException("이미 파티에 참가되어 있습니다.");
        }
        if (isFull()) {
            throw new RuntimeException("풀 파티입니다.");
        }

        final List<Member> adding = new ArrayList<>(members);
        adding.add(newMember);
        return new Party(adding);
    }

    boolean isAlive() {
        return members.stream()
                .anyMatch(Member::isAlive);
    }

    List<Member> members() {
        return members;
    }

    private boolean isFull() {
        return members.size() == MAX_MEMBER_COUNT;
    }

    private boolean exists(final Member newMember) {
        return members.stream()
                .anyMatch(member -> member.getId() == newMember.getId());
    }
}
