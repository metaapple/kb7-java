# ☕ Java Basic Learning - Day 6 (상속, 재사용, inherit)

#### 1) `Employee.java` (필드/생성자/getter-setter/`toString()` 재정의)

```java
package inherit;

public class Employee extends Object{
    /**
     * Object이 가지는 필드와 메서드를 다 상속받았음.
     * toString() --> Employee e = new Employee();
     * System.out.println(e) --> 패키지명.클래스명@ds9dspfs
     * 주소말고 toString()을 재정의해서 많이 씀.
     * 주소가 가르키는 필드값들 문자열로 만들어주는 기능으로 재정의해서 많이씀.
     * 부모에게 받은 메서드를 똑같이 써주면됨.(오버라이드, 재정의)
     * -------------------------------------------------------
     * 클래스는 기본적으로 3가지를 가짐
     * 필드(멤버변수)
     */
    public String name; //null로 초기화
    String address;
    protected int salary; //0
    private String rrn; //주민번호, null로 초기화

    //생성자
    //프로그래머가 안쓰면 컴파일할 때 기본생성자가 자동으로 추가됨.
    //객체생성한 후 초기화 나중에 하게 하고 싶고
    public Employee(){

    }
    //객체생성할 때 필드값 넣어서 초기화 동시에 하고 싶고
    public Employee(String name, String address, int salary, String rrn) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.rrn = rrn;
    }

    //멤버메서드
    //값넣을 때 set필드명(첫글자대문자) --> setter
    //값꺼낼 때 get필드명(첫글자대문자) --> getter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    @Override //--> 의미없는 표시를 넣어서 프로그래머가 구분하기 쉽게 도와줌.
    //@ --> hera@naver.com : naver.com에(At) 가입한 hera
    //@ --> Annotation(어노테이션, 애노테이션, 표시)
    //Car car = new Car()'
    //System.out.println(car); --> toString()을 무조건 호출함.
    //Object에 있는 toString()은 패키지명.클래스명@주소
    //우리가 만든 클래스에서 toString()을 재정의해서 필드값 문자열로 만들어주면 더 편함.
    public String toString() {
        return name + " " + address + " " + salary + " " + rrn;
    }
}
```

- **핵심**: `rrn`은 `private`이라 **직접 접근 불가** → `getRrn()`으로 접근
- **핵심**: `System.out.println(e)` 시 `toString()`이 자동 호출되므로 출력이 깔끔해짐

#### 2) `Manager.java` (상속 + `super(...)` + `toString()` 확장)

```java
package inherit;

public class Manager extends Employee {
    //필드 4개
    //메서드
    //Object이 상속한 메서드들
    //Employee가 상속한 메서드들
    private int bonus; //필드 5개

    public Manager(String name, String address, int salary, String rrn, int bonus) {
        //무조건 부모의 생성자를 호출하는 메서드는 첫번째 줄에 와야함.
        super(name, address, salary, rrn);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    public void test(){ //메서드 14개
        System.out.println("관리 감독하다.");
    }

    //재정의한 메서드
    @Override
    public String toString() {
        return super.toString() + " " + bonus;
    }
}
```

- **핵심**: 자식 생성자에서 `super(...)`로 **부모 필드 초기화**를 먼저 처리
- **핵심**: `toString()`에서 `super.toString()`을 호출해 **부모 출력 + bonus**로 확장

#### 3) `CompanyUse.java` (실행/확인용 main)

```java
package inherit;

public class CompanyUse {
    public static void main(String[] args) {

        Employee e = new Employee("홍길동", "광진구", 100000, "040701");
        System.out.println(e); //객체 프린트하면 toString() 무조건 호출됨.

        System.out.println(e.name); //public
        System.out.println(e.salary); //default
        System.out.println(e.address); //protected
//        System.out.println(e.rrn); //private

        System.out.println(e.getRrn());

        Manager manager = new Manager("김길동", "영등포", 100000, "040201", 1000);
        System.out.println(manager);

        manager.test();

//e.test();
    }
}
```

<img width="1093" height="540" alt="image" src="https://github.com/user-attachments/assets/a3d4456a-b714-49ce-9561-f8c6a647eabe" />


- **핵심**: `Employee`/`Manager` 출력 차이로 **오버라이딩 결과**를 확인 가능

#### 4) `Graphic2.java` (Swing GUI 예시)

```java
package test;

import javax.swing.*;
import java.awt.*;
//import java.awt.point.*;

public class Graphic2 {
    public static void main(String[] args) {
        //필요한 객체 ram에 가져다 두어야함.
//        JFrame frame = new JFrame(); //기본 생성자 메서드가 자동 호출
//        frame.setTitle("나의 첫 그래픽 프로그램"); //멤버변수가 title에 메서드로 문자열을 넣음.
        //멤버변수를 직접 접근해서 값을 넣거나 꺼내거나 하는 작업을 잘하지 않음.
        //set멤버변수이름, get멤버변수이름으로 메서드를 만들어서 멤버변수를 넣거나 꺼내는 작업을 하는 편.
        //frame.title = "나의 첫 그래픽 프로그램";
        JFrame frame = new JFrame("나의 첫 그래픽 프로그램");
        frame.setSize(600, 500);
        FlowLayout layout = new FlowLayout();
        frame.setLayout(layout); //주소를 넣음.!!

        JButton button = new JButton("1증가");
        JButton button2 = new JButton("1감소");
        JButton button3 = new JButton("0으로 초기화");
        JLabel result = new JLabel("0"); //String.valueOf(0)

        frame.add(button);
        frame.add(button3);
        frame.add(button2);
        frame.add(result);

        //글자를 키우자.
        Font font = new Font("궁서", Font.BOLD, 40);
        button.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        result.setFont(new Font("궁서", Font.ITALIC, 400));

        //색을 넣어보자. 배경색 + 글자색
        button.setBackground(Color.RED);
        button2.setBackground(Color.BLUE);
        button.setForeground(Color.YELLOW);
        button2.setForeground(Color.YELLOW);
        button3.setBackground(Color.GREEN);
        button3.setForeground(Color.YELLOW);
        result.setForeground(Color.RED);

        //맥유저는 넣어주세요.
        button.setOpaque(true);
        button2.setOpaque(true);

        //위 설정대로 하면에 보여주세요!! 맨 끝에 위치해야함.
        frame.setVisible(true);
    }
}


```
<img width="977" height="695" alt="image" src="https://github.com/user-attachments/assets/5a9d4a3c-2f5c-44ad-ac13-2a4542e987d1" />
<img width="979" height="988" alt="image" src="https://github.com/user-attachments/assets/b03aad54-6201-4caf-a1ca-753d4af7eecc" />
<img width="1178" height="988" alt="image" src="https://github.com/user-attachments/assets/6d0be13d-e2cb-4f79-8a06-8e16ce4f632e" />


- **핵심**: `JFrame`, `JButton`, `JLabel`, `Layout` 같은 **객체를 생성하고 설정(set...)**하는 패턴을 연습
- **포인트**: `FlowLayout` 객체를 만들고 `frame.setLayout(layout)`처럼 **레이아웃도 “객체(주소)”로 주입**함
- **포인트**: `Font`, `Color`를 이용해 **글꼴/색상**을 꾸밀 수 있음
- **포인트**: (특히 macOS에서) 배경색이 안 먹으면 `setOpaque(true)`가 필요할 수 있음

---

### 표로 요약

#### 1) 클래스별 역할

| 클래스 | 패키지 | 역할 | 핵심 포인트 |
|---|---|---|---|
| `Employee` | `inherit` | 직원 기본 정보(이름/주소/급여/주민번호) 모델 | `toString()`을 재정의해서 보기 좋은 출력 |
| `Manager` | `inherit` | 직원(Employee)을 확장한 관리자 모델 | `bonus` 추가 + `super(...)`로 부모 초기화 |
| `CompanyUse` | `inherit` | 실행(테스트) 클래스 | 필드 접근 제어자/오버라이딩 결과 확인 |
| `Graphic2` | `test` | Swing GUI 맛보기 | 상속보다는 “객체 생성 + setter 스타일 사용” 관점 |

#### 2) `Employee` 필드 접근 제어자 정리

| 필드 | 타입 | 접근 제어자 | 외부 접근(권장/가능) | 의미 |
|---|---|---|---|---|
| `name` | `String` | `public` | 직접 접근 가능(하지만 보통 getter/setter 권장) | 이름 |
| `address` | `String` | default | 같은 패키지에서만 직접 접근 | 주소 |
| `salary` | `int` | `protected` | 같은 패키지/상속 관계에서 접근 | 급여 |
| `rrn` | `String` | `private` | 직접 접근 불가 → `getRrn()` 사용 | 주민번호(민감정보) |

#### 3) `toString()` 오버라이딩 비교

| 클래스 | 구현 | 출력 형태(요약) |
|---|---|---|
| `Object` | 기본 제공 | `패키지.클래스@주소` |
| `Employee` | 재정의 | `name address salary rrn` |
| `Manager` | 재정의 | `Employee정보 + bonus` (`super.toString()` 활용) |

---

### “왜 private은 getter/setter로 접근할까?”

`rrn`처럼 민감한 데이터는

- “마구 변경/조회”를 막고,
- 필요한 곳에서만 규칙을 걸어서(예: 마스킹, 검증) 공개하려고

`private`로 숨긴 뒤 `getRrn()` / `setRrn()`로 통제하는 패턴을 사용합니다.

---

### 실행 방법 (간단)

이 프로젝트는 빌드 도구(pom/gradle) 없이도 실행할 수 있는 구조입니다.

- `inherit.CompanyUse` 실행: 상속/오버라이딩/접근제어자 확인
- `test.Graphic2` 실행: Swing 화면 확인

IDE(IntelliJ)에서 각 `main()` 클래스 우클릭 → Run 하면 가장 편합니다.

---

<img width="2559" height="1439" alt="image" src="https://github.com/user-attachments/assets/7736c16c-0075-4b30-bead-66b7ddda3d9a" />
<img width="2556" height="1437" alt="image" src="https://github.com/user-attachments/assets/3fe2c93a-f66d-43ea-b2b7-062c8f37f96b" />
<img width="2557" height="1438" alt="image" src="https://github.com/user-attachments/assets/c3c8a858-e5ca-49fa-b5c4-77d3bb11ff42" />
<img width="2547" height="1429" alt="image" src="https://github.com/user-attachments/assets/7daea12f-fcfe-4e72-914b-ff26f247759a" />
<img width="2560" height="1446" alt="image" src="https://github.com/user-attachments/assets/7ad1bae8-157e-492d-aa41-58473948e779" />
<img width="2547" height="1434" alt="image" src="https://github.com/user-attachments/assets/16ec8d33-58b0-458b-99f0-5b01b88ca436" />
<img width="2548" height="1441" alt="image" src="https://github.com/user-attachments/assets/72015628-1072-47c3-81dc-8d3f8d5a9e5f" />
<img width="2553" height="1436" alt="image" src="https://github.com/user-attachments/assets/698ffd9c-307c-485e-8dd2-465d05c70ffa" />
<img width="2310" height="1298" alt="image" src="https://github.com/user-attachments/assets/09ea0907-6d20-4002-8329-014bc8eb0aac" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/0764fcbe-3fe6-4c3f-9327-a42cd58c741b" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/c47d5b54-43a2-4378-9504-72a2d8f1d81d" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/6a1a9a8e-fee4-4839-8fbf-09ea2f55bb22" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/7591674d-bfe8-4da5-90d0-5c0bca3d12bb" />


<img width="2553" height="1440" alt="image" src="https://github.com/user-attachments/assets/1bf30fc8-8117-465d-ad35-825331e4885f" />
<img width="2549" height="1438" alt="image" src="https://github.com/user-attachments/assets/b370dfb2-d469-4029-9730-a42836ece8a1" />
<br>
<img width="2555" height="1431" alt="image" src="https://github.com/user-attachments/assets/1c653411-5a26-4d87-b0df-5929e15b7284" />
<img width="2560" height="1426" alt="image" src="https://github.com/user-attachments/assets/a3955d9a-1642-400e-8f44-2737fac86d11" />
<img width="2555" height="1436" alt="image" src="https://github.com/user-attachments/assets/a135e59e-eab2-4067-b43d-7fcaea367110" />
<img width="2559" height="1376" alt="image" src="https://github.com/user-attachments/assets/36b5b425-7b79-46d6-8b17-e905afaba1d9" />

<br>
<hr>
<br>
- 클래스 만들기와 상속(재사용)
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/fe3b8c40-9e49-475f-8e64-74dbc8f2c1af" />

<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/ad8d8806-a7a5-4967-a89c-f863665c62ad" />
<br>
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/8b814891-1803-4270-b9fe-0b97ec961245" />
<img width="1652" height="952" alt="image" src="https://github.com/user-attachments/assets/bce4f08d-be64-4991-8dce-e1c3f76e1f54" />
<img width="1652" height="952" alt="image" src="https://github.com/user-attachments/assets/1e1d9587-4d1e-4d41-9399-9fe19c5c0ad6" />
<br>
- 클래스 다형성(오버로딩)
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/07f0c248-c470-4529-b554-768719d99e21" />
<br>
- 객체 지향 프로그래밍의 2대 원칙
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/44281055-229e-4376-a923-cc610a0fbc4f" />
<br>
- 형변환
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/cbf0184e-d7db-49fe-a40f-8829fc5e02d0" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/92001e3e-82a8-408a-8d23-5a008a3876ba" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/e32ba550-e750-4e5a-b1c4-6d0971e29f9b" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/97af1056-82a9-4d8e-bcd0-1d09fb823459" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/42780571-9d23-4d88-9322-7417c36487c3" />
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/1225929e-e603-4b83-9923-c3cf0a61a279" />

<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/c459699b-611c-487f-9f1c-defec4a3d6d3" />

- 요약
<img width="2545" height="1427" alt="image" src="https://github.com/user-attachments/assets/e8986144-c3ec-4fd5-8d6d-a3f1333c4f52" />











---

## ☕ Java Basic Learning - Day 7 (인터페이스, 다형성, 캐스팅, interface)

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
└── README.md (없음)
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