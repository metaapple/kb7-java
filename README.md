# KB7-java

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




