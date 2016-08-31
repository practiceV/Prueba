

package ungs.pps2.testingQualityEvaluator.resources;


public class Ejemplo {
    public static int sumaTresYCincoDosVeces() {
        @Linea 9 ejecutada desde el test Ejemplo;
        @Linea 8 ejecutada desde el test Ejemplo;
        int a;
        int b;
        int c;
        a = 3;
        b = 5;
        c = a + b;
        a = a * b;
        return c;
    }

    public int multiplicaDosNumero(int a, int b) {
        @Linea 16 ejecutada desde el test Ejemplo;
        @Linea 14 ejecutada desde el test Ejemplo;
        @Linea 13 ejecutada desde el test Ejemplo;
        if (a == 2)
            return a * b;
        else
            return b * a;
        
    }
}

