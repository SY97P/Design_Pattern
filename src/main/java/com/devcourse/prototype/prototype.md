# 프로토타입 패턴

# 📝 생성패턴

- 객체 생성 시 의존에 의해 발생하는 결합 문제를 완화하기 위한 패턴
- 인스턴스 생성 절차를 추상화하는 패턴
- 추상화를 통해 실제 생성되는 구현체에 대한 정보 캡슐화
- 추상화를 통해 실제 객체 생성 방법, 결합 방법에 대한 부분을 캡슐화 (= 정보은닉)

# 🧩 개념

- 이미 생성된 객체를 복사하여 새로운 클래스 생성에 대한 부담을 줄여 쓸 수 있는 패턴
- 객체 생성 비용이 큰 경우 기존 객체를 복사하여 사용하는 패턴
- 각 객체는 서로에게 영향 줄 수 없도록 구현해야 함.
- 추상 팩토리 패턴, 빌더 패턴과 함께 사용 가능
    - 추상 팩토리, 빌더 패턴에 사용하는 베이스 클래스를 프로토타입으로 복제 가능
- 서브 클래스가 필요치 않음

# 🛠️ 구조

- Prototype
    - clone 메소드를 구현하도록 하는 프로토타입 인터페이스
- PrototypeInstance
    - clone (복제) 메소드 구현
    - 원본 객체 데이터, 새로운 객체 데이터 등 다양한 데이터를 이용하여 사용할 수 있음
- Client
    - 프로토타입 클래스 타입 객체 복사본 생성 가능

# 📟 코드

```java
public class Client {

    /** ProtoType 패턴
     *
     * 클래스에 의존하지 않고 기존 객체를 복사하는 생성패턴.
     */
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle =  new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle clonedCircle = (Circle) circle.clone();
        shapes.add(clonedCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape: shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
```

```java
public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape() {}

    public Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Shape)) {
            return false;
        }
        Shape shape = (Shape) object;
        return shape.x == x && shape.y == y && Objects.equals(shape.color, color);
    }

}
```

```java
public class Rectangle extends Shape {

    private int inch;

    public Rectangle() {}

    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.inch = target.inch;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Rectangle) || !super.equals(object)) return false;
        Rectangle shape = (Rectangle) object;
        return shape.inch == inch;
    }

}
```

```java
public class Circle extends Shape {

    public int radius;

    public Circle() {}

    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Circle) || !super.equals(object)) {
            return false;
        }
        Circle shape = (Circle) object;
        return shape.radius == this.radius;
    }
}
```

# 🔮 적용하면 좋을때

- 한 객체에 대한 여러 복사본이 각자의 독립적인 로직을 갖고 싶을 때
    - 객체 복사본이 구현체에 의존하면 안 될 때
- 객체 초기화 방식만 다른 자식 클래스 수를 줄이고 싶을 때

# 🧲 장단점

## ❤️ 장점

- 구상체에 의존하지 않는 객체 복사 가능
- 반복적인 초기화 코드를 미리 만들어진 프로토타입 객체 복사로 대체 가능
    - 무거운 초기화 작업 대체
- 복잡한 객체 쉽게 생성 가능
- 복잡한 클래스 사전 설정 시 상속 방식 대체

## 💔 단점

- 순환 참조 있는 경우 복제가 까다로움

# 🍃 Spring Framework

- Bean 생성 방식에서의 프로토타입 패턴
    - 기본 Bean 생성 방식은 싱글톤 방식
    - 하나의 Bean 객체가 스프링 프로그램 생명주기 전반에 걸쳐서 사용됨.
    - 하지만, 프로토타입 패턴으로 생성한 Bean은 요청 마다 새로운 인스턴스를 생성(복사)하여 반환함.