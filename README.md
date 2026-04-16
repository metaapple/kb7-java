# KB7-java

<img width="1739" height="983" alt="image" src="https://github.com/user-attachments/assets/c4ef970e-52d1-4fcb-9157-ae79d6315742" />
<hr>
<br>

- 프로젝트 생성
<img width="1067" height="488" alt="image" src="https://github.com/user-attachments/assets/2b3ded41-fcb0-494d-b120-5a1a2d2f639a" />
<img width="1233" height="628" alt="image" src="https://github.com/user-attachments/assets/61d4f81b-0c4e-4c44-84e3-ad022d07210d" />
<img width="1204" height="971" alt="image" src="https://github.com/user-attachments/assets/08a4e069-6ee8-486a-8b90-97850969d004" />

- 프로젝트 설정
<img width="508" height="356" alt="image" src="https://github.com/user-attachments/assets/6730e136-8746-43c9-b2b2-1bd1333f4e43" />
<img width="1546" height="692" alt="image" src="https://github.com/user-attachments/assets/d770c0c2-9453-417e-aeb7-b402bdd4ab06" />
<img width="801" height="447" alt="image" src="https://github.com/user-attachments/assets/e6555746-c0a7-47ed-a630-68d4863797be" />
<img width="1304" height="479" alt="image" src="https://github.com/user-attachments/assets/b8d45691-28ab-40e5-af7a-144791bff97f" />

- 전체구조
<img width="2247" height="1275" alt="image" src="https://github.com/user-attachments/assets/2fbb9858-88bb-474a-b451-19ec4ddc21c3" />
<img width="2246" height="1276" alt="image" src="https://github.com/user-attachments/assets/83d608be-4e79-4033-9b64-8119c553f140" />

```
package test;
//맨 위에 패키지명 나와야함.

public class Test { //class명은 파일명과 반드시 같아야함.
    //jvm(자바실행엔진, 프로그램)에 의해 처음 호출되는 메서드
    //정해져 있음. 다른 이름으로 쓰면 XXXX
    //main + enter 자동완성됨.
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");

        //ctrl + D : 한 줄 복사
        //ctrl + s : 저장
        //ctrl + x : 한 줄 삭제
    } //main end
} //class end
```

<img width="1966" height="1108" alt="image" src="https://github.com/user-attachments/assets/9b1771cf-8150-4aa9-8bd2-9b59d63cb30f" />
<img width="1965" height="1109" alt="image" src="https://github.com/user-attachments/assets/4e9a375f-15c0-457e-bc41-9e5ff071a154" />
<img width="1962" height="1105" alt="image" src="https://github.com/user-attachments/assets/106c8bf6-4f14-4825-81fd-3212872cd7fa" />











**Java String 클래스**에서 가장 자주 사용되고 중요한 메서드 **10개**
<hr>
<img width="2309" height="1164" alt="image" src="https://github.com/user-attachments/assets/00a5b954-3550-4703-a676-798a22dc5aed" />
<img width="815" height="312" alt="image" src="https://github.com/user-attachments/assets/b1019fa3-24d7-4d21-81ed-390895194efe" />

```
public class StringMethodExample {
    public static void main(String[] args) {
        
        String str = "  Hello Java World  ";
        
        System.out.println("원본 문자열: [" + str + "]");
        System.out.println("1. length()          : " + str.length());
        System.out.println("2. charAt(7)         : " + str.charAt(7));
        System.out.println("3. substring(7, 11)  : " + str.substring(7, 11));
        System.out.println("4. equals(\"hello\")   : " + str.equals("hello"));
        System.out.println("5. equalsIgnoreCase  : " + str.trim().equalsIgnoreCase("hello java world"));
        System.out.println("6. indexOf(\"Java\")    : " + str.indexOf("Java"));
        System.out.println("7. contains(\"World\") : " + str.contains("World"));
        System.out.println("8. replace(\"Java\", \"Python\") : " + str.replace("Java", "Python"));
        System.out.println("9. trim()            : [" + str.trim() + "]");
        
        String[] arr = str.trim().split(" ");
        System.out.print("10. split(\" \")       : ");
        for (String s : arr) {
            System.out.print("[" + s + "] ");
        }
        System.out.println();
    }
}
```

```
원본 문자열: [  Hello Java World  ]
1. length()          : 20
2. charAt(7)         : J
3. substring(7, 11)  : Java
4. equals("hello")   : false
5. equalsIgnoreCase  : true
6. indexOf("Java")    : 9
7. contains("World") : true
8. replace("Java", "Python") : [  Hello Python World  ]
9. trim()            : [Hello Java World]
10. split(" ")       : [Hello] [Java] [World]
```




