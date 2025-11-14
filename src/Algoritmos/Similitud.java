package Algoritmos;

import Modelo.Empresa;
import Modelo.Postulante;

public class Similitud {

    public static double similitudLevenshtein(Empresa e, Postulante p) {

        //Se estandariza la distancai de levenshtein => poder analizarlo mejor junto a Jaro
        String a = e.getTexto();
        String b = p.getTexto();

        int dist = DistanciaLevenshtein.CalcularDistancia(a, b);
        int max = Math.max(a.length(), b.length());

        if (max == 0) {
            return 1.0;
        }

        return 1.0 - ((double) dist / max);
    }

    public static double similitudJaro(Empresa e, Postulante p) {

        String a = e.getTexto();
        String b = p.getTexto();

        return Jaro.jaro(a, b);
    }

    public static double puntajeFinal(Empresa e, Postulante p) {
        double jw = similitudJaro(e, p);
        double lv = similitudLevenshtein(e, p);

        double ponderado = (0.7 * jw) + (0.3 * lv); //se consideran ambos valores

        return ponderado;
    }

    public static void imprimirPuntajes(Empresa[] empresas, Postulante[] postulantes) {
        for (Empresa e : empresas) {
            for (Postulante p : postulantes) {
                System.out.println("Empresa: " + e.getNombre() + " - Postulante: " + p.getNombre());
                System.out.println("  -> Jaro-Winkler: " + similitudJaro(e, p));
                System.out.println("  -> Levenshtein:  " + similitudLevenshtein(e, p));
                System.out.println("  -> Puntaje final (0.7/0.3): " + puntajeFinal(e, p));
                System.out.println();
            }
        }
    }

}
