package test;

public class MemberRecordUse {
    public static void main(String[] args) {
        MemberRecord m1 = new MemberRecord("winter", "눈송이", 25);
        MemberRecord m2 = new MemberRecord("winter", "눈송이", 25);

        System.out.println(m1.id());
        System.out.println(m1.name());
        System.out.println(m1.age());
        System.out.println(m1);
        System.out.println("equals: " + m1.equals(m2));
        System.out.println("hashCode 비교: " + (m1.hashCode() == m2.hashCode()));
    }
}
