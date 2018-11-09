package finalFinallyFinalize;

import java.util.HashSet;
import java.util.Set;

public class Parent {
    int c;
    String s;

    public Parent(int a, String s) {
        c = a;
        this.s = s;
        System.out.println("parent generated");
    }

    public static void main(String[] args) {
        final int num = 6;
        Parent p1 = new Parent(2, "a");
        Parent p2 = new Parent(2, "a");
        System.out.print(p1.equals(p2));

        HashSet<Parent> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println(set);

    }

    @Override
    protected void finalize() {
        System.out.println("garage collected");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        if (c != parent.c) return false;
        return s != null ? s.equals(parent.s) : parent.s == null;
    }

//    @Override
//    public int hashCode() {
//        int result = c;
//        result = 31 * result + (s != null ? s.hashCode() : 0);
//        return result;
//    }
}
