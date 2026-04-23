package test;


public class LombokTest {
    public static void main(String[] args) {
        Bag bag = new Bag("홍길동",
                "목요일이야",
                1000);

        System.out.println(bag.getName());
        bag.setName("김길동");
        System.out.println(bag);


    }
}
