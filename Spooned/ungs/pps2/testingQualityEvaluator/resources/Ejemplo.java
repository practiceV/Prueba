

package ungs.pps2.testingQualityEvaluator.resources;


public class Ejemplo {
    public static int sumaTresYCincoDosVeces() {
        int a;
        int b;
        int c;
        a = 3;
        b = 5;
        c = a + b;
        a = a + b;
        return c;
    }

    public int multiplicaDosNumero(int a, int b) {
        if (a == 2)
            return a * b;
        else
            return b * a;
        
    }
}

