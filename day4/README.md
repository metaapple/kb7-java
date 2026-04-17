

☕ Java Basic Learning - Day 4 (Class & Object)

## 📚 개요
이 수업에서는 자바의 객체 지향 프로그래밍의 핵심 개념들을 배웁니다:
- **class와 객체** - 추상화를 통한 설계
- **배열** - 같은 타입의 데이터를 효율적으로 관리
- **문자열** - String class의 주요 기능


## 🔗 파일 구조

```
day4/
├── src/
│   ├── object/
│   │   ├── Television.java
│   │   └── TVUse.java
│   └── test/
│       ├── Array.java
│       └── StringTest.java
└── README.md
```

---

## 1️⃣ Class와 객체 (Class & Object)

### 개념 설명

**class**는 현실의 사물을 프로그래밍으로 모델링한 것입니다.
- **속성(State)**: class가 가진 특성 → 멤버변수
- **동작(Behavior)**: class가 할 수 있는 기능 → 멤버method

### 예제: Television class

#### 📝 코드

```java
package object;
public class Television {
    // 정적인 성질(속성) - 멤버변수
    String size;   // null로 자동 초기화
    int price;     // 0으로 자동 초기화

    // 동적인 기능(동작) - 멤버method
    public void powerOn() {
        int bonus = 10000;  // 지역변수
        System.out.println("tv를 켜다.");
        System.out.println(price + 10000);
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            System.out.println(bonus);
        }
    }

    public void powerOff() {
        System.out.println("tv를 끄다.");
    }

    // method 중복: 같은 이름, 다른 입력값
    public int getPrice() {
        return price;
    }

    public int getPrice(int sale) {
        return price - sale;
    }
}
```

#### 🎯 핵심 개념

| 개념 | 설명 | 예시 |
|------|------|------|
| **멤버변수** | class의 속성, 전역변수 | `String size;`, `int price;` |
| **멤버메서드** | class의 동작, 함수 | `powerOn()`, `powerOff()` |
| **자동 초기화** | class 변수는 컴파일시 자동 초기화 | String → null, int → 0 |
| **지역변수** | method 내부 변수, 명시적 초기화 필요 | `int bonus = 10000;` |
| **오버로딩** | 같은 이름, 다른 입력값으로 정의 가능 | `getPrice()`, `getPrice(int sale)` |

---

### 객체 생성 및 사용

#### 📝 코드: TVUse.java

```java
package object;

public class TVUse {
    public static void main(String[] args) {
        // 객체 생성: new 키워드로 힙 메모리에 인스턴스 생성
        Television tv = new Television();
        System.out.println(tv);          // 주소 출력
        System.out.println(tv.price);   // 0
        System.out.println(tv.size);    // null

        // 멤버변수에 값 할당
        tv.price = 100000;
        tv.size = "big";
        System.out.println(tv.price + " " + tv.size);  // 100000 big

        // method 호출
        tv.powerOn();
        tv.powerOff();

        // 두 번째 객체 생성
        Television tv2 = new Television();
        System.out.println(tv2.price + " " + tv2.size);  // 0 null

        tv2.price = 200000;
        tv2.size = "small";
        System.out.println(tv2.price + " " + tv2.size);  // 200000 small

        // 반환값이 있는 method
        System.out.println(tv2.getPrice());              // 200000
        int price2 = tv2.getPrice();
        System.out.println(price2 - 10000);              // 190000

        // method 중복
        int price3 = tv2.getPrice(100);  // 100 할인
        System.out.println("할인 가격은 " + price3);     // 할인 가격은 199900
    }
}
```

#### 📊 메모리 구조 다이어그램

```
┌─────────────────────────────────────────┐
│         STACK (스택)                    │
├─────────────────────────────────────────┤
│  tv  ────┐ (참조변수, 주소 저장)       │
│  tv2 ────┼─┐ (참조변수, 주소 저장)   │
└────────┼─┼───────────────────────────┘
         │ │
         │ └──────────────────────┐
         │                        │
         ▼                        ▼
┌─────────────────────────────────────────┐
│         HEAP (힙)                       │
├─────────────────────────────────────────┤
│ [객체 1]                                 │
│ size: "big"                              │
│ price: 100000                            │
│                                          │
│ [객체 2]                                 │
│ size: "small"                            │
│ price: 200000                            │
└─────────────────────────────────────────┘
```

---

## 2️⃣ 배열 (Array)

### 개념 설명

배열은 **같은 타입의 데이터를 연속된 메모리에 저장**하는 자료구조입니다.
- 고정된 크기
- 인덱스로 접근 (0부터 시작)
- 힙 메모리에 저장, 주소를 변수가 관리

### 배열 생성 방법

#### 📝 코드: Array.java

```java
package test;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // ✅ 방법 1: 배열 생성시 값을 알고 있을 때
        int[] age = {10, 20, 30};

        // 읽기/쓰기 가능한 일반 for문
        for (int i = 0; i < age.length; i++) {
            System.out.println(age[i]);
        }

        // ✅ 방법 2: 배열 생성 후 값을 나중에 입력
        int[] age2 = new int[3];  // {0, 0, 0} - 자동 초기화
        age2[0] = 10;
        age2[1] = 20;
        age2[2] = 30;
        System.out.println(Arrays.toString(age2));  // [10, 20, 30]

        // ✅ 배열 복사 - 얕은 복사 (주소만 복사)
        int[] age3 = age2;
        age2[0] = 999;
        System.out.println(age2 == age3);           // true (같은 주소)

        // ✅ 배열 복사 - 깊은 복사 (값을 복사) ⭐ 중요
        int[] age4 = age2.clone();
        age2[0] = 555;
        System.out.println(age2 == age4);           // false (다른 주소)
    }
}
```

#### 📋 타입별 자동 초기화

| 기본형 | 초기값 | 참조형 | 초기값 |
|--------|--------|--------|--------|
| int | 0 | String | null |
| double | 0.0 | Object | null |
| boolean | false | 배열 | null |

---

## 3️⃣ 문자열 (String)

### 개념 설명

자바의 String은 **불변(Immutable) 참조형**입니다.
- 한번 생성되면 값을 변경할 수 없음
- 값이 변경되면 새로운 문자열이 생성됨

### String method

#### 📝 코드: StringTest.java

```java
package test;

public class StringTest {
    public static void main(String[] args) {
        String str = "  Hello Java World  ";
        String str2 = "  Hello Java World  ";
        
        // 같은 값을 가지면 같은 주소를 가짐
        System.out.println(str == str2);  // true
        
        System.out.println(str.length());             // 21
        System.out.println(str.charAt(2));            // H
        System.out.println(str.substring(2));         // "Hello Java World  "
        System.out.println(str.substring(2, 5));      // "Hel"
        System.out.println(str.trim());               // "Hello Java World"
        System.out.println(str.concat("java"));       // "  Hello Java World  java"
        System.out.println(str.contains("Java"));     // true
    }
}
```

#### 📊 String method 상세 설명

| method | 입력값 | 반환타입 | 설명 |
|--------|---------|---------|------|
| `length()` | - | int | 문자열 길이 |
| `charAt(int)` | 인덱스 | char | 해당 인덱스의 문자 |
| `substring(int)` | 시작 인덱스 | String | 시작부터 끝까지 |
| `trim()` | - | String | 앞뒤 공백 제거 |
| `concat(String)` | 문자열 | String | 문자열 연결 |
| `contains(String)` | 문자열 | boolean | 포함 여부 확인 |

---

## 🎓 핵심 요약 표

| 주제 | 핵심 개념 | 주의사항 |
|------|---------|---------|
| **class와 객체** | class는 설계도, 객체는 인스턴스 | new 키워드로 객체 생성 |
| **method 중복** | 같은 이름, 다른 입력값 | 타입, 개수, 순서로 구분 |
| **배열** | 같은 타입, 고정 크기 | 인덱스는 0부터 시작 |
| **얕은 복사** | 주소만 복사 | 수정하면 원본도 변경 |
| **깊은 복사** | 값 전체 복사 | 독립적으로 수정 가능 |
| **String 불변성** | 값이 변경되면 새로 생성 | 같은 값은 하나만 생성 |

---



