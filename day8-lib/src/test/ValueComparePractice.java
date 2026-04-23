package test;

public class ValueComparePractice {
    public static void main(String[] args) {
        //-128~127범위가 아니므로 각각 주소를 만든다.
        Integer a = 300;
        Integer b = 300;
        System.out.println(a.intValue());
        System.out.println("300 비교");
        System.out.println("주소 비교 == : " + (a == b)); //false
        System.out.println("값 비교 equals : " + a.equals(b)); //true
        System.out.println("a identityHashCode: " + System.identityHashCode(a));
        System.out.println("b identityHashCode: " + System.identityHashCode(b));
        System.out.println("\n값 변경 후");
        a =  100;
        System.out.println("주소 비교 == : " + (a == b)); //false
        System.out.println("a identityHashCode: " + System.identityHashCode(a));
        System.out.println("b identityHashCode: " + System.identityHashCode(b));

        System.out.println("======================");

        //-128-127까지는 클래스로 저장시 미리 넣어둠.
        Integer c = 10;
        Integer d = 10;
        System.out.println("\n10 비교");
        System.out.println("== : " + (c == d)); //true
        System.out.println("equals : " + c.equals(d)); //true
        System.out.println("c identityHashCode: " + System.identityHashCode(c));
        System.out.println("d identityHashCode: " + System.identityHashCode(d));

        System.out.println("\n값 변경 후");
        c = 100;
        System.out.println("== : " + (c == d)); //false
        System.out.println("equals : " + c.equals(d)); //false
        System.out.println("초기 상태");
        System.out.println("c identityHashCode: " + System.identityHashCode(c));
        System.out.println("d identityHashCode: " + System.identityHashCode(d));
        }
}