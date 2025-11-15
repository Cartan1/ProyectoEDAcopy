package Algoritmos;

import Modelo.Empresa;
import Modelo.Postulante;
import java.util.Arrays;
import java.util.Comparator;

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
    
    public static Postulante[][] puntajeFinalIni(Empresa[] em, Postulante[] post){
        Postulante[][] puntajes = new Postulante [em.length][post.length];
        double jw;
        double lv;
        double ponderado;
        for (int e = 0; e < em.length; e++) {
            for (int p = 0; p < post.length; p++) {
                jw = similitudJaro(em[e], post[p]);
                lv = similitudLevenshtein(em[e], post[p]);
                ponderado = (0.7 * jw) + (0.3*lv);
                post[p].setPuntaje(ponderado, e); //el postulante guarda el puntaje ponderado en su lista de puntajes 
                puntajes[e][p] = post[p]; 
            }
            
        }
        OrdenarPuntajes(puntajes);
        return puntajes; //postulantes ordenas de mejor a peor nota por empresa
    }
    
    public static void OrdenarPuntajes(Postulante[][] post){
        for (int emp = 0; emp < post.length; emp++) {
            final int indexEmp = emp; //el indice para obtener los puntajes de los postulantes correspondientes a la empresa 
            
            Arrays.sort(post[emp], new Comparator<Postulante>(){
            @Override
            public int compare(Postulante post1, Postulante post2){
            double punt1 = post1.getPuntaje()[indexEmp];
            double punt2 = post2.getPuntaje()[indexEmp];
            return Double.compare(punt1, punt2);}}
            );
        }
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
