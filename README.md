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
<img width="1877" height="1057" alt="image" src="https://github.com/user-attachments/assets/b9908ef7-c527-4fbd-8544-0b8eb4e3dae2" />
<img width="1868" height="1061" alt="image" src="https://github.com/user-attachments/assets/113582fc-9d71-40cb-a228-9a5e32072f17" />
<img width="1960" height="1107" alt="image" src="https://github.com/user-attachments/assets/2cefa10d-878b-4704-a118-780bdcc99413" />
<img width="1868" height="1057" alt="image" src="https://github.com/user-attachments/assets/d340da2b-2923-4751-bfe6-7f09fff55a21" />
<img width="1875" height="1063" alt="image" src="https://github.com/user-attachments/assets/3895dc04-95bf-40f9-a63e-532c94dbce89" />

<img width="1961" height="1108" alt="image" src="https://github.com/user-attachments/assets/37d2fbc9-3f12-417b-be7e-8f9056ab9716" />
<img width="1875" height="1054" alt="image" src="https://github.com/user-attachments/assets/57ba7118-ab15-4264-8204-cc2f0451fddb" />
<img width="1872" height="1060" alt="image" src="https://github.com/user-attachments/assets/4e92d579-0a44-4bd5-9cfa-6987b8b98fbb" />
<img width="1973" height="1108" alt="image" src="https://github.com/user-attachments/assets/ea337fef-b64a-4ff7-9566-b746b3dfa3cc" />
<img width="1973" height="1108" alt="image" src="https://github.com/user-attachments/assets/56b37896-f5b2-4504-b580-e2557f9603f7" />
<img width="1959" height="1106" alt="image" src="https://github.com/user-attachments/assets/93a2451f-8bf6-4404-94fd-b1cd7e254e77" />
<img width="1959" height="1106" alt="image" src="https://github.com/user-attachments/assets/735f7b21-7e5a-4086-b481-a53e4197d300" />

- 아스키코드(ASCII, AMERICAN STANDADARD CHARACTOR....) --> UNICODE에 포함
  <img width="632" height="299" alt="image" src="https://github.com/user-attachments/assets/f27efb26-815c-4d80-afcc-c13f43ddec9b" />
- 8비트로 표현될 수 있는 정수값의 범위, 자바
<img width="629" height="503" alt="image" src="https://github.com/user-attachments/assets/d3bf5e28-1a22-4bb1-9d24-d08eec4d1c5e" />

```
2의 0승 - 1
2의 1승 - 2
2의 2승 - 4
2의 3승 - 8
2의 4승 - 16
2의 5승 - 32
2의 6승 - 64


2¹ = 2
2² = 4
2³ = 8
2⁴ = 16
2⁵ = 32
2⁶ = 64
총합 = 1 + 2 + 4 + 8 + 16 + 32 + 64 = 127

맨 앞 비트는 부호비트(1, 0)

맨 앞 비트 (최상위 비트, MSB) 가 부호를 결정
0이면 → 양수 (Positive)
1이면 → 음수 (Negative)



```

<img width="595" height="493" alt="image" src="https://github.com/user-attachments/assets/1321b133-5515-4b08-a62b-d202bab7705a" />
<img width="1194" height="117" alt="image" src="https://github.com/user-attachments/assets/4dc9f14a-262c-485f-841d-069a936b47f2" />
<img width="1193" height="182" alt="image" src="https://github.com/user-attachments/assets/a40767a9-a6b5-4623-bcf1-ccf79bcfb42b" />


- jdk download
  jdk17 download(windows) - https://jdk.java.net/java-se-ri/17
- 컴파일+실행
<img width="1528" height="1852" alt="image" src="https://github.com/user-attachments/assets/b9decace-6563-4011-abf7-3e82205edf3a" />
<img width="735" height="526" alt="image" src="https://github.com/user-attachments/assets/3100ef7e-ec2a-41bc-9085-1d014ed6483d" />
<img width="1973" height="1564" alt="image" src="https://github.com/user-attachments/assets/efc792ca-6def-422b-a779-614466aa0639" />

- 패키지 만들기
<img width="1745" height="795" alt="image" src="https://github.com/user-attachments/assets/da6a61cd-b53d-4efc-9538-88c8a3a67549" />

- 한국어 언어팩 삭제(영어로 사용하고자 하는 경우)
<img width="2282" height="1867" alt="image" src="https://github.com/user-attachments/assets/b2aac58b-665b-4655-9f6a-97647d17e521" />

- 코드리포맷(코드정리) - reformat(한글로) ==> 에러 없을 때만 코드정리해줌.
<img width="2272" height="1774" alt="image" src="https://github.com/user-attachments/assets/129371a9-2c84-493f-8456-2830610eca37" />


- new(한글로) --> 변경하지 말고 alt + insert를 그대로 쓰시기를 권장
- 영문버전으로는 키를 변경하는 것이 적용이 되는데 한글로는 적용이 되지 않음.
<img width="2255" height="1763" alt="image" src="https://github.com/user-attachments/assets/89b4928a-a32d-46bc-99a2-92863b06d165" />


```
package test;

//자바파일하나 == class
//class이름은 파일명과 동일해야함.
//파일이름은 무조건 대문자로 시작
//낙타표기법
//클래스 첫줄은 무조건 패키지이름
//문장의 끝은 무조건 ;을 붙여야함.
public class Primitive {
    public static void main(String[] args) {
        //기본형 4가지
        //변수하나에 값하나 저장됨.
        //정수, 실수, 문자1, 논리
        //정수
        int age = 100; //정적타입핑, 정수말고는 다른 것 넣으면 에러
        //실수
        double height = 122.2; //소수점 15자리까지
        //문자1
        char gender = '남'; //무조건 홑따옴표
        //논리
        boolean food = true; //false

        //주의점.
        //정수는 byte --> short --> int --> long
        long money = 3333333333L; //L, l
        //실수는 float --> double
        float weight = 88.8F;
        //88.80000000000000 처럼 인식함.

        //추가
        //사람은 문자1글자보다 문자를 여러개를 많이 씀(문자열)
        String name = "홍길동"; //이중따옴표를 써야함.

        System.out.println("나이는 " + age + "세");
        System.out.println("성별은 " + gender + "임");
    }
}

```



  





















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




