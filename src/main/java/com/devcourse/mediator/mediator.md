# 중재자 패턴

# 🖍️ 개념

- 객체 간 혼란스러운 의존 관계를 줄일 수 있는 행동 디자인 패턴
- 객체 간 직접 통신 제한하고 중재자 객체를 통해서만 동작하도록 강제
- 클래스 간 복잡한 관계를 하나의 클래스로 캡슐화해서 관리
- M:N 관계를 M:1 관계로 만들어 복잡도를 낮추는 양상
- 각 객체들은 서로를 알지 몰라도 되므로, 결합도가 낮아짐

## 행동 패턴

- 알고리즘, 객체 간 책임 할당에 관한 패턴

# 👨‍👩‍👧 구성요소

![스크린샷 2023-08-10 오후 11.18.36.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDesktop%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-10%20%EC%98%A4%ED%9B%84%2011.18.36.png)

## 🚎 컴포넌트

- 비즈니스 로직 클래스
- 중재자 참조 존재
- 중재자 구현체 알지 못함 → 다른 중재자와 연결 가능

## 🚥 중재자

- 컴포넌트와 통신 가능한 메소드 선언
- 컴포넌트가 중재자를 통해 컴포넌트 컨텍스트 송신 가능
    - 다만, 송수신 컴포넌트 간 결합 발생하지 않는 정도만 가능

## 🚧 중재자 구현체

- 컴포넌트 간 관계 캡슐화
- 자신이 관리하는 모든 컴포넌트에 대한 참조 유지
- 자신이 관리하는 모든 컴포넌트에 대한 생명주기 관리 가능

# 📌 핵심

- 중재자는 알림에 대한 발송자 식별 가능
- 알림 수신 컴포넌트 결정
- 컴포넌트는 서로의 존재 모름
- 컴포넌트 이벤트 발생 시 무조건 중재자에게만 알림
- 컴포넌트 관점 모든 것이 블랙박스
- 발송 컴포넌트는 요청 처리 대상 모름
- 수신 컴포넌트는 요청 생성 주체 모름

# 📟 코드

![스크린샷 2023-08-11 오전 12.05.19.png](..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2F..%2FDesktop%2F%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202023-08-11%20%EC%98%A4%EC%A0%84%2012.05.19.png)

```java
public class Client {

    static Mediator mediator;

    static Unit police;
    static Unit fireFighterA;
    static Unit fireFighterB;

    public static void main(String[] args) {
        setup();

        ignition();
        extinguishing();
        extinguished();
    }

    private static void ignition() {
        police.sendMessage("불 났다!");
        System.out.println();
    }

    private static void extinguishing() {
        police.sendMessage("집 간다!");
        mediator.deleteUnit(police);
        System.out.println();
    }

    private static void extinguished() {
        fireFighterA.sendMessage("불 껐다!");
        System.out.println();
    }

    private static void setup() {
        mediator = new CommandCenter();

        police = new Police(mediator, "0");
        fireFighterA = new FireFighter(mediator, "A");
        fireFighterB = new FireFighter(mediator, "B");

        mediator.addUnit(police);
        mediator.addUnit(fireFighterA);
        mediator.addUnit(fireFighterB);
    }

}
```

```java
public interface Mediator {

    void addUnit(Unit unit);

    void deleteUnit(Unit unit);

    void sendMessage(Unit unit, String message);

}
```

```java
public class CommandCenter implements Mediator {

    private List<Unit> units;

    public CommandCenter() {
        this.units = new ArrayList<>();
    }

    @Override
    public void addUnit(Unit unit) {
        if (!units.contains(unit)) {
            this.units.add(unit);
        }
    }

    @Override
    public void deleteUnit(Unit unit) {
        if (units.contains(unit)) {
            this.units.remove(unit);
        }
    }

    @Override
    public void sendMessage(Unit unit, String message) {
        this.units.stream()
                .filter(seperateUnit -> !Objects.equals(seperateUnit, unit))
                .forEach(seperateUnit -> seperateUnit.receiveMessage(message));
    }
}
```

```java
public abstract class Unit {

    protected Mediator mediator;

    public Unit(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}
```

```java
public class FireFighter extends Unit {

    private final String unitName;

    public FireFighter(Mediator mediator, String name) {
        super(mediator);
        this.unitName = "소방"+name;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(this.unitName + ": 메시지 전송 -> " + this.unitName + " " + message);
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(this.unitName + ": 메시지 수신 -> " + message);
    }
}
```

```java
public class Police extends Unit {

    private final String unitName;

    public Police (Mediator mediator, String name) {
        super(mediator);
        this.unitName = "경찰"+name;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(this.unitName + ": 메시지 전송 -> " + this.unitName + " " + message);
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(this.unitName + ": 메시지 수신 -> " + message);
    }
}
```

# 🔑 적용하면 좋을때

- 클래스 간 심한 결합으로, 변경 힘든 경우
- 클래스 간 심한 결합으로, 다른 프로그램에서 컴포넌트 재사용 힘든 경우
- 몇 가지 기본 행동을 공유하는 클래스가 자식 클래스를 양산할 때

# ❤️ 장점

- SRP
    - 컴포넌트 간 통신 책임 중재자만 담당
- OCP
    - 컴포넌트 수정 없이 새 중재자 도입 가능
- 컴포넌트 간 결합 감소
- 컴포넌트 재사용성 증가

# 💔 단점

- 중재자가 갓 클래스가 될 가능성