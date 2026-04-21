# ☕ Java Basic Learning - Day 5 (생성자 · static · Swing 입문)

#### 1) `Employee.java` (필드/생성자/getter-setter/`toString()` 재정의)

```java
package inherit;

public class Employee extends Object{
    public String name;
    String address;
    protected int salary;
    private String rrn;

    public Employee(){ }

    public Employee(String name, String address, int salary, String rrn) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.rrn = rrn;
    }

    public String getRrn() { return rrn; }
    public void setRrn(String rrn) { this.rrn = rrn; }

    @Override
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
    private int bonus;

    public Manager(String name, String address, int salary, String rrn, int bonus) {
        super(name, address, salary, rrn);
        this.bonus = bonus;
    }

    public void test(){
        System.out.println("관리 감독하다.");
    }

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
        System.out.println(e);

        System.out.println(e.name);
        System.out.println(e.salary);
        System.out.println(e.address);
        // System.out.println(e.rrn); // private이라 직접 접근 불가
        System.out.println(e.getRrn());

        Manager manager = new Manager("김길동", "영등포", 100000, "040201", 1000);
        System.out.println(manager);
        manager.test();
    }
}
```

- **핵심**: `Employee`/`Manager` 출력 차이로 **오버라이딩 결과**를 확인 가능

#### 4) `Graphic2.java` (Swing GUI 예시)

```java
package test;

import javax.swing.*;
import java.awt.*;

public class Graphic2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("나의 첫 그래픽 프로그램");
        frame.setSize(600, 500);
        frame.setLayout(new FlowLayout());

        JButton button = new JButton("1증가");
        JButton button2 = new JButton("1감소");
        JButton button3 = new JButton("0으로 초기화");
        JLabel result = new JLabel("0");

        frame.add(button);
        frame.add(button3);
        frame.add(button2);
        frame.add(result);

        frame.setVisible(true);
    }
}
```

- **핵심**: `JFrame`, `JButton`, `JLabel`, `Layout` 같은 **객체를 생성하고 설정(set...)**하는 패턴을 연습

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
<img width="2553" height="1440" alt="image" src="https://github.com/user-attachments/assets/1bf30fc8-8117-465d-ad35-825331e4885f" />
<img width="2549" height="1438" alt="image" src="https://github.com/user-attachments/assets/b370dfb2-d469-4029-9730-a42836ece8a1" />

<br>
<hr>
<br>

<img width="2555" height="1431" alt="image" src="https://github.com/user-attachments/assets/1c653411-5a26-4d87-b0df-5929e15b7284" />
<img width="2560" height="1426" alt="image" src="https://github.com/user-attachments/assets/a3955d9a-1642-400e-8f44-2737fac86d11" />
<img width="2555" height="1436" alt="image" src="https://github.com/user-attachments/assets/a135e59e-eab2-4067-b43d-7fcaea367110" />
<img width="2559" height="1376" alt="image" src="https://github.com/user-attachments/assets/36b5b425-7b79-46d6-8b17-e905afaba1d9" />
*** End of File
