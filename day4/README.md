# 자바 객체 지향 기초

자바는 객체 지향 프로그래밍(OOP) 언어로, 객체와 클래스 개념을 사용하여 프로그램을 구성합니다. 객체는 데이터와 해당 데이터를 처리하는 메소드를 포함하는 독립적인 단위입니다. 클래스는 객체를 생성하기 위한 설계도입니다.

## 객체와 클래스

- **클래스:** 객체를 생성하기 위한 청사진. 클래스는 속성과 메소드를 정의합니다.  
- **객체:** 클래스의 인스턴스입니다.

### 코드 예제
```java
// 클래스 정의
class Car {
    String color;
    int year;

    // 생성자
    Car(String c, int y) {
        color = c;
        year = y;
    }

    // 메소드
    void display() {
        System.out.println("색상: " + color + ", 연식: " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("빨강", 2021);
        myCar.display(); // 색상: 빨강, 연식: 2021
    }
}
```

## 배열

배열은 같은 타입의 여러 데이터를 저장할 수 있는 데이터 구조입니다. 자바에서 배열은 고정 크기이며, 각 요소는 인덱스로 접근할 수 있습니다.

### 코드 예제
```java
public class ArrayExample {
    public static void main(String[] args) {
        // 배열 선언 및 초기화
        int[] numbers = {1, 2, 3, 4, 5};

        // 배열 요소 출력
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("번호: " + numbers[i]);
        }
    }
}
```

## 문자열

자바에서 문자열은 `String` 클래스를 사용하여 나타냅니다. 문자열은 불변(immutable) 객체입니다. 즉, 한 번 생성된 문자열은 변경할 수 없습니다.

### 코드 예제
```java
public class StringExample {
    public static void main(String[] args) {
        String greeting = "안녕하세요!";

        // 문자열 길이
        System.out.println("문자열 길이: " + greeting.length());

        // 문자열 연결
        String name = "홍길동";
        String welcomeMessage = greeting + " 만나서 반가워요, " + name;
        System.out.println(welcomeMessage);
    }
}
```

## 요약

자바는 객체 지향 프로그래밍 방식을 사용하며, 클래스와 객체를 통해 프로그램을 구성합니다. 배열은 데이터를 저장하는 데 유용하며, 문자열은 불변 객체로 처리됩니다. 이러한 기본 개념들을 이해하는 것은 자바 프로그래밍을 배우는 데 중요한 첫 걸음입니다.

---

### 다이어그램

![Java OOP Diagram](https://example.com/java-oop-diagram.png)  
*(이미지는 자바 객체 지향 개념을 설명하는 예시입니다.)*  

이 파일은 자바의 기본 개념을 이해하는 데 도움을 주기 위한 것입니다. 
자세한 질문이 있다면, 자유롭게 문의해 주세요!