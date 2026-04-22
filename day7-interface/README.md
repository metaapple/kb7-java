# ☕ Java Basic Learning - Day 7 (인터페이스, 다형성, 캐스팅, interface)

Day 7에서는 **인터페이스(interface)로 “규격(기능 명세)”을 먼저 만들고**, `implements`로 구현 클래스를 교체 가능하게 조립하는 방법을 연습합니다.  
추가로 **업캐스팅/다운캐스팅**을 실제 예제로 확인합니다.

---

### 🔗 파일 구조 (day7-interface)

```
day7-interface/
├── src/
│   ├── inter/
│   │   ├── RemoteControl.java      # 인터페이스(규격) + 상수
│   │   ├── Television.java         # implements 예시(구현 클래스)
│   │   ├── Video.java              # implements 예시(구현 클래스 + 추가 메서드)
│   │   ├── RemoteControlUse.java   # 인터페이스 타입 다형성 사용(main)
│   │   ├── Phone.java              # 인터페이스(전화/메신저 기능 규격)
│   │   ├── Gps.java                # 인터페이스(지도 기능 규격)
│   │   ├── MegaPhone.java          # 인터페이스 extends(다중 상속) + siri
│   │   ├── ApplePhone.java         # 추상클래스(일부 구현 + 일부 추상)
│   │   ├── ApplePhone1.java        # ApplePhone 구현(카메라 1)
│   │   ├── ApplePhone2.java        # ApplePhone 구현(카메라 2)
│   │   └── CameraUse.java          # 인터페이스 타입으로 객체 사용(main)
│   └── test/
│       ├── CastingTest.java        # List에 다양한 타입 저장 + 다운캐스팅
│       ├── Person.java             # CastingTest에서 사용하는 모델
│       ├── Man.java                # 상속 기반 캐스팅 예제(부모)
│       ├── SuperMan.java           # Man 상속(자식) + 오버라이딩
│       ├── SuperManUse.java        # (기본 사용)
│       └── SuperManUse2.java       # 업캐스팅/다운캐스팅(main)
└── README.md
```

---

### 1) `RemoteControl.java` (인터페이스: 기능 명세 + 상수)

```java
package inter;

public interface RemoteControl {
    // 인터페이스 안의 필드는 기본적으로 "상수"로 사용 (public static final)
    public static final String COMPANY = "kb";

    void turnOn();
    public abstract void turnOff();
}
```

- **핵심**: 인터페이스는 “무엇을 해야 하는지”만 정의(추상 메서드 중심)
- **핵심**: `COMPANY` 같은 값은 보통 **공유 상수(public static final)** 로 둠

---

### 2) `Television.java`, `Video.java` (implements: 규격을 실제 동작으로 구현)

#### `Television.java`

```java
package inter;

public class Television implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("Television ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Television OFF");
    }
}
```

#### `Video.java` (구현 + 추가 메서드)

```java
package inter;

public class Video implements RemoteControl {
    int volume;

    @Override
    public void turnOn() {
        System.out.println("Video ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Video OFF");
    }

    public void changeVolume(int volume) {
        this.volume = volume + 1;
        System.out.println("Change volume to " + this.volume);
    }
}
```

- **핵심**: `implements RemoteControl`이면 `turnOn/turnOff`를 **반드시 구현**해야 “완전한 클래스”가 됨
- **포인트**: 인터페이스 규격 외에 `Video.changeVolume()` 같은 **추가 기능도 자유롭게 확장 가능**

---

### 3) `RemoteControlUse.java` (인터페이스 다형성: 교체 가능한 코드)

```java
package inter;

public class RemoteControlUse {
    public static void main(String[] args) {
        // RemoteControl rc = new Television();
        RemoteControl rc = new Video();
        rc.turnOn();
        rc.turnOff();
        System.out.println(RemoteControl.COMPANY);
    }
}
```

- **핵심**: `RemoteControl rc`로 선언하면 `Television` ↔ `Video`를 **코드 수정 최소로 교체** 가능(결합도↓)
- **핵심**: 인터페이스 타입으로는 **인터페이스에 선언된 메서드만 호출 가능**  
  (예: `rc.changeVolume()`은 `RemoteControl`에 없으므로 호출 불가 → 필요하면 다운캐스팅)

---

### 4) 다중 인터페이스 + 추상클래스 조합: `MegaPhone` → `ApplePhone` → `ApplePhone1/2`

#### `MegaPhone.java` (인터페이스 extends: 다중 상속)

```java
package inter;

public interface MegaPhone extends Gps, Phone {
    String COMPANY = "mega";
    void siri();
}
```

#### `ApplePhone.java` (추상클래스: “일부 구현 + 일부 미완성(추상)”)

```java
package inter;

public abstract class ApplePhone implements MegaPhone {
    public abstract void camera();

    @Override
    public void siri() {
        System.out.println("음성 인식 기능");
    }

    @Override
    public void map() {
        System.out.println("지도 기능");
    }

    @Override
    public void internet() {
        System.out.println("인터넷 기능");
    }

    @Override
    public void call() {
        System.out.println("전화통화 기능");
    }

    @Override
    public void text() {
        System.out.println("문자 기능");
    }

    @Override
    public void kakao() {
        System.out.println("카카오 기능");
    }
}
```

#### `ApplePhone1.java`, `ApplePhone2.java` (남은 추상 메서드 구현)

```java
package inter;

public class ApplePhone1 extends ApplePhone {
    @Override
    public void camera() {
        System.out.println("인덕션 카메라로 찍다.");
    }
}
```

```java
package inter;

public class ApplePhone2 extends ApplePhone {
    @Override
    public void camera() {
        System.out.println("렌즈 1개짜리로 찍다.");
    }
}
```

- **핵심**: 인터페이스(`MegaPhone`)는 “규격”, 추상클래스(`ApplePhone`)는 “공통 구현”을 모아 재사용
- **핵심**: `ApplePhone`이 `camera()`를 미구현(추상)으로 남겨두면, 자식 클래스가 각자 방식으로 완성 가능

---

### 5) `CameraUse.java` (인터페이스 타입으로 사용)

```java
package inter;

public class CameraUse {
    public static void main(String[] args) {
        Phone phone = new ApplePhone1();
        phone.call();
        phone.kakao();
    }
}
```

- **핵심**: `Phone` 타입으로 선언하면 “전화기 규격”만 보이므로 **필요한 기능만 노출**됨

---

### 6) `CastingTest.java` (List에 여러 타입 저장 + 다운캐스팅)

```java
package test;

import java.util.*;

public class CastingTest {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(new String("test"));
        list.add(new Random());
        list.add(new Date());
        list.add(new Person("클라크", 28));

        String s = (String)list.get(0);
        System.out.println(s.charAt(0));

        Date date = (Date)list.get(2);
        System.out.println(date.getHours());
        System.out.println(date.getMinutes());
        System.out.println(date.getSeconds());
    }
}
```

- **핵심**: `List`는 내부적으로 `Object`로 받는 구조(제네릭 전/미사용 시)라 **업캐스팅**으로 다양한 타입 저장 가능
- **핵심**: 다시 각 타입의 메서드를 쓰려면 `(String)`, `(Date)` 같은 **다운캐스팅**이 필요

---

### 7) 상속 기반 업/다운캐스팅: `SuperManUse2.java`

```java
package test;

public class SuperManUse2 {
    public static void main(String[] args) {
        Man superMan = new SuperMan("클라크", 22, 100, true);
        System.out.println(superMan);

        superMan.run();

        SuperMan sm = (SuperMan)superMan;
        sm.space();

        superMan.eat();
    }
}
```

- **핵심**: `Man superMan = new SuperMan(...)` 은 **업캐스팅(자동 형변환)**  
  → 교체 가능한 코드(결합도↓) 만들기 좋음
- **핵심**: 자식 고유 기능(`space()`)은 업캐스팅 상태에서 안 보이므로 **다운캐스팅** 후 사용

---

### 표로 요약

#### 1) interface vs abstract class vs class

| 구분 | 목적 | 객체 생성 | 메서드 형태 | 예시 |
|---|---|---:|---|---|
| `interface` | “규격(기능 명세)” | 불가 | 주로 추상 메서드(명세) | `RemoteControl`, `Phone`, `Gps` |
| `abstract class` | 공통 구현 재사용 + 일부 미완성 허용 | 불가 | 구현/추상 메서드 혼합 가능 | `ApplePhone` |
| `class` | 실제 동작하는 완성품 | 가능 | 구현 메서드 | `Television`, `Video`, `ApplePhone1/2` |

#### 2) `implements / extends` 관계 정리

| 타입 | 선언 | 의미 |
|---|---|---|
| 클래스 → 인터페이스 | `class A implements I` | 인터페이스 규격을 구현해서 “완성 클래스”가 됨 |
| 인터페이스 → 인터페이스 | `interface I2 extends I1, I0` | 기능 규격을 합성(다중 상속 가능) |
| 클래스 → 클래스 | `class Child extends Parent` | 공통 필드/메서드 재사용(상속) |

#### 3) 업캐스팅/다운캐스팅 한 줄 요약

| 구분 | 방향 | 예시 | 특징 |
|---|---|---|---|
| 업캐스팅 | 작은 타입 → 큰 타입 | `Man m = new SuperMan()` | 자동, 교체 가능 코드에 유리 |
| 다운캐스팅 | 큰 타입 → 작은 타입 | `SuperMan sm = (SuperMan)m` | 강제, 자식 기능 사용 목적 |

---

### 실행 방법 (간단)

IntelliJ에서 각 `main()` 클래스 우클릭 → Run.

- `inter.RemoteControlUse` 실행: 인터페이스 다형성 + 상수 접근
- `inter.CameraUse` 실행: `Phone` 타입으로 구현체 사용
- `test.CastingTest` 실행: `List` + 다운캐스팅 예제
- `test.SuperManUse2` 실행: 업캐스팅/다운캐스팅 흐름 확인
