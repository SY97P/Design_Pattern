package com.devcourse.firstClassCollection;

import java.util.List;
import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        Party party = new Party();

        party = party.add(new Member(UUID.randomUUID(), "사과", true));
        party = party.add(new Member(UUID.randomUUID(), "딸기", false));

        List<Member> members = party.members();

        System.out.println(members);
    }
}
