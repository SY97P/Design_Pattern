package com.devcourse.observer;

import com.devcourse.observer.observer.object.Observer;
import com.devcourse.observer.observer.object.TopicSubscriber;
import com.devcourse.observer.observer.subject.Topic;

public class Client {
    public static void main(String[] args) {
        Topic topic = new Topic();
        Observer a = new TopicSubscriber("a", topic);
        Observer b = new TopicSubscriber("b", topic);
        Observer c = new TopicSubscriber("c", topic);

        topic.register(a);
        topic.register(b);
        topic.register(c);

        topic.postMessage("상태 변화!!!!!");
    }
}
