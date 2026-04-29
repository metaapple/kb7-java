<br>

# ☕ Java Basic Learning - Day 11 (Collection / Lambda / Properties)

Day11은 컬렉션 프레임워크에서 자주 사용하는 **Set / Map / TreeSet**과,  
함수형 인터페이스 기반의 **람다식 + 메서드 참조**, 그리고 설정 파일 로딩용 **Properties**를 함께 정리한 프로젝트입니다.

---

## 핵심 개념 한 장 요약

- **HashSet**
  - 중복을 허용하지 않고, 저장 순서를 보장하지 않습니다.
  - 인덱스가 없기 때문에 `Iterator` 또는 `for-each`로 순회합니다.
- **HashMap**
  - `key:value` 구조로 데이터를 저장하고, 키는 중복될 수 없습니다.
  - 같은 키를 `put()`하면 기존 값이 덮어써집니다.
- **TreeSet**
  - 중복 제거 + 정렬을 동시에 수행합니다.
  - 사용자 정의 객체를 넣으려면 정렬 기준(`Comparable` 또는 `Comparator`)이 필요합니다.
- **Lambda + Method Reference**
  - 함수형 인터페이스(`@FunctionalInterface`)를 대상으로 람다식과 `Class::method` 문법을 사용할 수 있습니다.
- **Properties**
  - `.properties` 파일에서 키-값 설정을 읽어 애플리케이션 설정값을 분리 관리할 수 있습니다.

---

## 실행 흐름 그림(mermaid)

### 1) Set / Map / TreeSet 동작 흐름

```mermaid
flowchart LR
  A[데이터 추가] --> B{컬렉션 종류}
  B --> C[HashSet]
  B --> D[HashMap]
  B --> E[TreeSet]
  C --> C1[중복 제거]
  C --> C2[순서 보장 안됨]
  D --> D1[key:value 저장]
  D --> D2[중복 key는 덮어쓰기]
  E --> E1[중복 제거]
  E --> E2[자동 정렬]
```

### 2) TreeSet + 사용자 정의 객체 정렬

```mermaid
sequenceDiagram
  participant M as main(TreeSetTest)
  participant T as TreeSet<Person2>
  participant P as Person2(compareTo)
  M->>T: add(new Person2("홍길동",100))
  M->>T: add(new Person2("김길동",200))
  T->>P: compareTo() 호출
  P-->>T: 나이 기준 비교 결과
  T-->>M: 정렬 + 중복 제거된 결과
```

### 3) Lambda / Method Reference 실행 흐름

```mermaid
flowchart TB
  A["Person3 action 호출"] --> B["calc 실행 (10,20)"]
  B --> C1["람다식 전달: x+y"]
  B --> C2["정적 메서드 참조 전달"]
  B --> C3["인스턴스 메서드 참조 전달"]
  C1 --> D[결과 출력]
  C2 --> D
  C3 --> D
```

---

## 코드 + 설명 (코드 아래에 바로 해설)

### `HashSetTest.java` (중복 제거, 순회 방법)

```java
package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");
        set.add("Spring");

        System.out.println(set);
        System.out.println(set.size());

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String e = iterator.next();
            System.out.println("꺼낸 값은 " + e);
        }

        set.remove("JDBC");
        System.out.println(set);

        for (String s : set){
            System.out.println(s);
        }
    }
}
```

- `Set`은 중복을 허용하지 않으므로 `"Spring"`은 한 번만 유지됩니다.
- `Set`에는 인덱스가 없어서 `get(0)` 같은 접근이 불가능합니다.
- 순회는 `Iterator` 또는 `for-each`를 사용합니다.

---

### `HashMapTest.java` (key:value 저장, keySet/entrySet 순회)

```java
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("홍길동", 85);
        map.put("김길동", 85);
        map.put("송길동", 85);
        map.put("송길동", 90);
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get("홍길동"));

        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key + ":" + map.get(key));
        }

        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Entry<String, Integer> entry = iterator1.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        map.remove("홍길동");
        System.out.println(map.size());
    }
}
```

- 같은 키(`"송길동"`)를 다시 넣으면 값이 **90으로 갱신(덮어쓰기)** 됩니다.
- 키만 필요할 때는 `keySet()`, 키와 값을 같이 다룰 때는 `entrySet()`이 효율적입니다.

---

### `TreeSetTest.java` + `Person2.java` (정렬 + 비교 기준)

```java
package collection;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("홍길동");
        treeSet.add("김길동");
        treeSet.add("정길동");
        treeSet.add("홍길동");
        System.out.println(treeSet);

        TreeSet<Person2> treeSet2 = new TreeSet<>();
        treeSet2.add(new Person2("홍길동", 100));
        treeSet2.add(new Person2("김길동", 200));
        treeSet2.add(new Person2("홍길동", 100));
        System.out.println(treeSet2);
    }
}
```

```java
package collection;

import java.util.Objects;

public class Person2 implements Comparable<Person2>{
    public String name;
    public int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person2 person2)) return false;
        return age == person2.age && Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person2 o) {
        if (age < o.age) return -1;
        else if (age == o.age) return 0;
        else return 1;
    }
}
```

- `TreeSet`은 내부 정렬을 위해 비교가 가능한 기준이 필요합니다.
- `Person2`가 `Comparable<Person2>`를 구현하고 `compareTo()`를 제공해서 정렬이 가능합니다.
- `equals()` / `hashCode()`도 함께 정의해 객체 동등성 판단을 명확히 했습니다.

---

### `LambdaTest.java` + `Calcuable.java` + `Computer.java` (람다식 / 메서드 참조)

```java
package collection;

public class LambdaTest {
    public static void main(String[] args) {
        Person3 person = new Person3();
        person.action((x, y) -> x + y);
        person.action(Computer::staticMethod);
        Computer com = new Computer();
        person.action(com::instanceMethod);
    }
}
```

```java
package collection;

@FunctionalInterface
public interface Calcuable {
    double calc(double x, double y);
}
```

```java
package collection;

public class Computer {
    public static double staticMethod(double x, double y) {
        return x + y;
    }
    public double instanceMethod(double x, double y) {
        return x * y;
    }
}
```

- `Calcuable`은 단 하나의 추상 메서드만 가진 함수형 인터페이스입니다.
- 같은 시그니처를 가진 람다식/정적 메서드/인스턴스 메서드를 모두 전달할 수 있습니다.

---

### `PropertiesExample.java` + `database.properties` (설정 파일 읽기)

```java
package collection;

import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String admin = properties.getProperty("admin");

        System.out.println("driver : " + driver);
        System.out.println("url : " + url);
        System.out.println("username : " + username);
        System.out.println("password : " + password);
        System.out.println("admin : " + admin);
    }
}
```

```properties
driver=oracle.jdbc.OracleDirver
url=jdbc:oracle:thin:@localhost:1521:orcl
username=scott
password=tiger
admin=\uD64D\uAE38\uB3D9
```

- 코드에 DB 정보 하드코딩 대신, 외부 파일로 분리해 관리할 수 있습니다.
- `getResourceAsStream()`으로 클래스패스 기준 파일을 읽어옵니다.

---

## 컬렉션 비교 표

| 구분 | HashSet | HashMap | TreeSet |
|---|---|---|---|
| 기본 구조 | 값(value) 집합 | key:value 매핑 | 값(value) 집합 |
| 중복 | 중복 값 불가 | key 중복 불가 (값 덮어쓰기) | 중복 값 불가 |
| 순서/정렬 | 순서 보장 안됨 | 순서 보장 안됨 | 자동 정렬 |
| 주요 접근 방식 | iterator / for-each | keySet / entrySet / get(key) | iterator / for-each |
| 대표 사용 상황 | 중복 제거 목록 | 사전(lookup), 점수표 | 정렬 + 중복 제거 |

---

## 실행 가이드

### IntelliJ IDEA 기준
- `day11-collection/src/collection`에서 클래스별 `main()` 실행
  - Set 예제: `HashSetTest`
  - Map 예제: `HashMapTest`
  - 정렬 Set 예제: `TreeSetTest`
  - Lambda 예제: `LambdaTest`
  - 설정 파일 예제: `PropertiesExample`

<br>
<hr>
<br>

## 학습 포인트 체크리스트

- `HashSet`에서 중복 데이터가 왜 제거되는지 설명할 수 있는가?
- `HashMap`에서 `keySet()`과 `entrySet()`의 차이를 설명할 수 있는가?
- `TreeSet`에서 사용자 정의 객체를 정렬하려면 무엇이 필요한가?
- 람다식과 메서드 참조를 언제 교체해서 쓸 수 있는지 알고 있는가?
- `Properties`를 통해 설정을 외부화하는 이유를 설명할 수 있는가?


<br>
<img width="1215" height="1295" alt="image" src="https://github.com/user-attachments/assets/159dd87a-a983-4ebb-b8e6-1df8d7e1d57b" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/86d159fa-31d3-4ff9-9988-95c671407681" />

<img width="3643" height="1892" alt="image" src="https://github.com/user-attachments/assets/47c09a13-6ec2-4901-bfaa-5131f4f56ccc" />
- 처리할 함수들을 모아 미리 클래스로 만들어둔 경우 클래스의 메서드를 직접호출하여 지정 가능
<img width="3620" height="1762" alt="image" src="https://github.com/user-attachments/assets/abffb03c-7cb7-412d-923c-12ef73c9035c" />

<br>
<hr>
- 코드 정리(컴파일 에러가 없을 때만)
<img width="2344" height="1838" alt="image" src="https://github.com/user-attachments/assets/b428d845-3dcd-4926-9f2d-a73451c70d17" />
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/57f10941-4d24-4a57-8338-1887b42bfe5d" />

<br>
- intellij에서 equals()와 hashCode() 재정의 코드 생성하기
<img width="914" height="877" alt="image" src="https://github.com/user-attachments/assets/b1ca912c-267e-4cf8-b866-309302a7406f" />
<img width="621" height="723" alt="image" src="https://github.com/user-attachments/assets/dbfd0ce1-dd3a-4899-8deb-2f7c2aab0ad4" />
<img width="1158" height="657" alt="image" src="https://github.com/user-attachments/assets/bd69d2bf-ce16-4758-96bc-d02d0aba2e1a" />
<img width="1151" height="655" alt="image" src="https://github.com/user-attachments/assets/c355d3b1-8275-4074-8177-84c49a163f9f" />
<img width="1158" height="652" alt="image" src="https://github.com/user-attachments/assets/66d5a862-f427-4f0e-8b1d-4b275e76765b" />

```
package test;

public class Person   {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

```

```

package test;

import java.util.Objects;

public class Person2 implements Comparable<Person2> {
    public String name;
    public int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //객체 비교(동일) --> 값: equals(), 주소: hashcode()
    //생성된 객체 필드의 값과 주소가 동일한지 비교


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person2 person2)) return false;
        return age == person2.age && Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //객체 비교(누가 더 큰가/작은가)
    @Override
    public int compareTo(Person2 o) {
        if (age < o.age) return -1;
        else if (age == o.age) return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


```

```
package test;

import java.util.Objects;

public class Person2 implements Comparable<Person2> {
    public String name;
    public int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //객체 비교(동일) --> 값: equals(), 주소: hashcode()
    //생성된 객체 필드의 값과 주소가 동일한지 비교


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person2 person2)) return false;
        return age == person2.age && Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    //객체 비교(누가 더 큰가/작은가)
    @Override
    public int compareTo(Person2 o) {
        if (age < o.age) return -1;
        else if (age == o.age) return 0;
        else return 1;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


```

```

package test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("홍길동");
        treeSet.add("김길동");
        treeSet.add("정길동");
        System.out.println(treeSet);

        //자동 정렬해주는 기능이 있는데, 주소를 가지고 대소를 비교할 수 없으므로
        //내부적으로 정렬기능 수행못함. 에러
        //비교할 수 있는 메서드를 구현해주어야함.
        //Comparable 인터페이스 구현
//        TreeSet<Person> treeSet2 = new TreeSet<>();
//        treeSet2.add(new Person("홍길동", 100));
//        treeSet2.add(new Person("김길동", 200));
//        treeSet2.add(new Person("홍길동", 100));
//        System.out.println(treeSet2);

//        Exception in thread "main" java.lang.ClassCastException: class test.Person cannot be cast to class java.lang.Comparable (test.Person is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
//        at java.base/java.util.TreeMap.compare(TreeMap.java:1569)
//        at java.base/java.util.TreeMap.addEntryToEmptyMap(TreeMap.java:776)
//        at java.base/java.util.TreeMap.put(TreeMap.java:785)
//        at java.base/java.util.TreeMap.put(TreeMap.java:534)
//        at java.base/java.util.TreeSet.add(TreeSet.java:255)
//        at test.TreeSetTest.main(TreeSetTest.java:16)


        TreeSet<Person2> treeSet3 = new TreeSet<>();
        treeSet3.add(new Person2("홍길동", 100));
        treeSet3.add(new Person2("김길동", 200));
        //정렬의 대상인 age가 100으로 동일하므로 들어가지 않음.
        treeSet3.add(new Person2("홍길동", 100));
        System.out.println(treeSet3);

        Set<Person2> set = new HashSet<>();
        set.add(new Person2("홍길동", 100));
        set.add(new Person2("김길동", 200));
        set.add(new Person2("홍길동", 100));
        System.out.println(set);


//[김길동, 정길동, 홍길동]
//[Person2{name='홍길동', age=100}, Person2{name='김길동', age=200}]
// equals(), hashcode()를 재정의해주지 않으면 new로 생성한 주소가 모두 다르므로
// 중복이 되지 않았다고 봄.
//[Person2{name='김길동', age=200}, Person2{name='홍길동', age=100}, Person2{name='홍길동', age=100}]
//equals(), hashcode()를 재정의후
//[Person2{name='김길동', age=200}, Person2{name='홍길동', age=100}]
    }
}



```
