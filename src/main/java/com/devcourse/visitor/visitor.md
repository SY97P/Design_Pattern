# 개념

- 로직을 객체와 분리해주는 행동 디자인 패턴

# 상황

- 지리 정보를 나타내는 노드 그래프를 xml 형식으로 내보낼 때
- 기존 노드 클래스 변경이 오류가 될 가능성
- 기존 노드 클래스에 xml 내보내키 코드가 있는 것이 응집도를 해침
- xml 외 다른 형식이 필요하게 될 경우 또다시 망가지기 쉬운 클래스를 변경해야 함

# 해결

- 비지터 패턴을 통해, 기존 클래스에 전달되는 영향을 최소화
- xml 내보내기 기능만 비지터 클래스로 만들어 배치
- 기존 클래스(노드) 종류에 따라 적절한 비지터 클래스를 선택해야 하는 경우, [더블 디스패치](https://refactoring.guru/ko/design-patterns/visitor-double-dispatch) 방식을 사용

# 구조

![img.png](img.png)

- Visitor 인터페이스
    - Element 인터페이스를 매개변수로 사용하는 비지터 메소드 선언
    - 비지터 메소드는 이름은 같지만, 매개변수 타입이 다른 오버라이딩을 제공해야 함.
- Visitor 구현체
    - Element 구현체 별로 맞는 적절한 로직 메소드를 구현
- Element 인터페이스
    - 비지터를 수락하는 메소드 선언
    - 비지터 인터페이스를 매개변수로 받는 메소드 선언
- Element 구현체
    - 수락 메소드 구현
    - Element 구현체 별로 적절한 비지터 메소드로 리다이렉트 하는것
    - 자신에게 맞는 Visitor 인터페이스 메소드를 호출하도록 해야 함
- Client
    - 일반적으로 컬렉션, 복합체를 나타냄.
    - Visitor, Element 인터페이스로 작업하기 때문에 실제 구현체에 대해서는 알지 못함.

# 코드

```java
public class Client {
    public static void main(String[] args) {
        Shopper shopper = new Shopper();
        Cart cart = new Cart();
        cart.accept(shopper);
    }
}
```

```java
public interface Visitor {
    void visit(Cart cart);
    void visit(Snack snack);
    void visit(Milk milk);
}
```

```java
public class Shopper implements Visitor {
    @Override
    public void visit(Cart cart) {
        System.out.println("카트를 사용합니다.");
    }

    @Override
    public void visit(Snack snack) {
        System.out.println("과자를 카트에 넣습니다.");
    }

    @Override
    public void visit(Milk milk) {
        System.out.println("우유를 카트에 넣습니다.");
    }
}
```

```java
public interface Element {
    void accept(Visitor visitor);
}
```

```java
public class Cart implements Element {

    List<Element> cart = new ArrayList<>();

    public Cart() {
        cart.add(new Snack());
        cart.add(new Milk());
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("카드가 준비되었습니다.");
        visitor.visit(this);

        cart.forEach(element -> element.accept(visitor));
    }
}
```

```java
public class Milk implements Element {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("과자 준비되었습니다.");
        visitor.visit(this);
    }
}
```

```java
public class Snack implements Element {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("우유가 준비되었습니다.");
        visitor.visit(this);
    }
}
```

# 적용하면 좋을 때

- 복잡한 객체 구조 (트리 구조 등) 의 모든 요소를 대상으로 작업할 때 유용
- 보조 행동 (횡단 관심사) 로직 정리
- 클래스 계층 구조 일부 클래스에서만 로직이 의미 있고, 나머지에는 의미가 없는 경우 사용

# 장단점

## 장점

- SRP
    - 같은 역할을 하는 로직을 한 군데 모음
    - 기존 클래스 역할을 해치지 않음
- OCP
    - 다른 클래스 변경하지 않으면서 해당 클래스 객체와 작동 가능한 새로운 행위 도입 가능
- 다양한 객체와 작업하면서 정보 축적 가능
    - 트리 순회하면서 객체 구조의 정보 습득 가능

## 단점

- 클래스가 요소 계층(트리) 에 추가될 때마다 모든 비지터 업데이트 해야 함.
- 
- 비지터는 작업에 필요한 클래스의 비공개 필드, 메소드 접근 권한이 부족할 수 있음