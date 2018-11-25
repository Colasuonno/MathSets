package it.colasuonno.mathset.test;

import it.colasuonno.mathset.MathSet;


public class MathTest {


    public static void main(String[] args) {

        MathSet<Integer> a = new MathSet<>(1,2,3);
        MathSet<Integer> b = new MathSet<>(4,2,1,5);
        MathSet<Integer> c = new MathSet<>(6,1,5);

        MathSet aUnionA = a.union(a);
        System.out.println( a + " ∪ " + a + " = " + a );
        System.out.println("Result: " + a.equals(aUnionA));

        MathSet aIntersectionA = a.intersection(a);
        System.out.println( a + " ∩ " + a + " = " + a );
        System.out.println("Result: " + a.equals(aIntersectionA));

        MathSet aIntersectionB = a.intersection(b);
        MathSet bIntersectionA = b.intersection(a);
        System.out.println( a + " ∩ " + b + " = " + b + " ∩ " + a );
        System.out.println("Result: " + aIntersectionB.equals(bIntersectionA));

        MathSet aUnionB = a.union(b);
        MathSet bUnionA = b.union(a);
        System.out.println( a + " ∪ " + b + " = " + b + " ∪ " + a );
        System.out.println("Result: " + aUnionB.equals(bUnionA));

        MathSet ai1 = b.intersection(c).intersection(a);
        MathSet ai2 = (a.intersection(b)).intersection(c);
        System.out.println( a + " ∩ (" + b + " ∩ " + c + ")" + " = ("+ a + " ∩ " + b + ") ∩" + c );
        System.out.println("Result: " + ai1.equals(ai2));

        MathSet au1 = b.union(c).union(a);
        MathSet au2 = (a.union(b)).union(c);
        System.out.println( a + " ∪ (" + b + " ∪ " + c + ")" + " = ("+ a + " ∪ " + b + ") ∪" + c );
        System.out.println("Result: " + au1.equals(au2));

        MathSet la1 = a.intersection(a.union(b));
        MathSet la2 = a.union(a.intersection(b));
        System.out.println(a + " ∩ (" + a + " ∪ " + b + ")" );
        System.out.println("Result: " + la1.equals(a));
        System.out.println(a + " ∪ (" + a + " ∩ " + b + ")" );
        System.out.println("Result: " + la2.equals(a));

        MathSet pdi = a.intersection(b.union(c));
        MathSet pdu = a.intersection(b).union(a.intersection(c));
        System.out.println(a + " ∩ (" + b + " ∪ " + c + ") = (" +  a + " ∩ " + b + ") ∪ (" + a + " ∩ " + c + ")" );
        System.out.println("Result: " + pdi.equals(pdu));

        MathSet pdi2 = a.union(b.intersection(c));
        MathSet pdu2 = a.union(b).intersection(a.union(c));
        System.out.println(a + " ∪ (" + b + " ∩ " + c + ") = (" +  a + " ∪ " + b + ") ∩ (" + a + " ∪ " + c + ")" );
        System.out.println("Result: " + pdi2.equals(pdu2));


    }

}
