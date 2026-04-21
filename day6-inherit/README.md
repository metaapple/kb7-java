### Employee.java

```java
public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {  
        this.name = name;  
        this.age = age;  
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

이 코드는 `Employee` 클래스를 정의하며, 이름과 나이를 속성으로 가집니다. 생성자를 통해 이러한 속성을 초기화하고, 이름과 나이를 가져오는 메소드도 포함되어 있습니다.

### Manager.java

```java
public class Manager extends Employee {
    private String department;

    public Manager(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
```

`Manager` 클래스는 `Employee` 클래스를 상속받아 추가적으로 부서 속성을 포함합니다. 생성자를 통해 상위 클래스의 속성을 초기화하고, 부서를 가져오는 메소드를 제공합니다.

### CompanyUse.java

```java
public class CompanyUse {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 30);
        Manager mgr = new Manager("Bob", 40, "IT");
        System.out.println(emp.getName() + "는 " + emp.getAge() + "세입니다.");
        System.out.println(mgr.getName() + "는 " + mgr.getDepartment() + " 부서의 관리자입니다.");
    }
}
```

이 코드는 `CompanyUse` 클래스를 정의하여 `Employee`와 `Manager` 객체를 생성하고, 그들의 정보를 출력하는 예제입니다.

### Graphic2.java

```java
import javax.swing.*;
import java.awt.*;

public class Graphic2 extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello, World!", 20, 20);
    }
}
```

`Graphic2` 클래스는 `JPanel`을 확장하여 그래픽 요소를 그리는 예제입니다. `paintComponent` 메소드를 오버라이드하여 문자열을 화면에 출력합니다.