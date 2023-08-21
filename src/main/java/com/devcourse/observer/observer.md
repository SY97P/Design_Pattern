# 옵저버 패턴

# 개념

- 관찰 중인 객체에 발생하는 모든 이벤트를 다른 여러 객체에 알리는 구독 매커니즘 행동 패턴
- 발행/구독 모델
- 다른 객체 상태 변화를 별도 함수 호출 없이 즉각적으로 알 수 있음
- MVC 패턴에서 자주 사용
- 이벤트 기반 시스템에서 활용

# 구조
![스크린샷 2023-08-21 오후 12.44.02.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDesktop%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-21%20%EC%98%A4%ED%9B%84%2012.44.02.png)

### Subject (객체)

- 상태 변화하는 개체
- 다른 객체 들에 관심 이벤트 발행
- Subject 상태 전환 혹은 행동 시 이벤트 발생
- Subject에는 구독할 수 있는 인프라(메소드, 필드)가 정의
- 인프라에는 Observer가 구독 리스트에 추가되거나 삭제될 수 있는 기능 담당
- 새 이벤트가 발생하면 Subject는 Observer 리스트를 살펴본 후 각 Observer 알림 메소드 호출

### Observer 인터페이스

- 알림 인터페이스 update 메소드 선언
- Subject가 이벤트의 세부 정보 전달하는 매개변수 포함

### Observer 구현 클래스

- 객체 상태 변환 시 추가 변화 사항 발생하는 개체
- Subject 가 보낸 알림에 대한 응답 작업 수행
- Subject와 직접적인 결합하지 않도록 작성

### Client

- Subject, Observer 객체를 별도 생성, 구독자 출판사 업데이트 등록

# 코드

```java
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
```

```java
public interface Observer {
    void update();
}
```

```java
public class TopicSubscriber implements Observer {

    private String name;
    private Subject topic;

    public TopicSubscriber(String name, Subject topic) {
        this.name = name;
        this.topic = topic;
    }

    @Override
    public void update() {
        String message = (String) topic.getUpdate(this);
        System.out.println(name + ":: got message >> " + message);
    }
}
```

```java
public interface Subject {
    void register(Observer oberser);
    void unregister(Observer observer);
    void notifyObservers();
    Object getUpdate(Observer observer);
}
```

```java
public class Topic implements Subject {
    private List<Observer> observers;
    private String message;

    public Topic() {
        this.observers = new ArrayList<>();
        this.message = "";
    }

    @Override
    public void register(Observer oberser) {
        if (!observers.contains(oberser)) {
            observers.add(oberser);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer observer) {
        return message;
    }

    public void postMessage(String msg) {
        System.out.println("Message sended to Topic : " + msg);
        this.message = msg;
        notifyObservers();
    }
}
```

# 적용하면 좋을때

- 객체 상태 시 다른 객체를 변경하고 싶을 때
- 실제 객체 집합을 미리 알 수 없지만, 집합을 구성하는 객체들을 동적으로 변화시키고 싶을 때
- 일부 객체들이 일정 시간 동안이나 특정 경우에 다른 객체 관찰할 때

# 장단점

## 장점

- OCP
  - Publisher 코드 변경 없이 Subscriber 클래스 도입 가능
- 느슨한 결합
  - 상태 변화를 알리는 객체가 변화 수신하는 객체를 직접 알지 않아도 됨.
- 런타임에 객체 간 관계 형성 가능

## 단점

- Subscriber는 무작위로 알림 수신
- 데이터 배분에 문제 발생 시 큰 문제