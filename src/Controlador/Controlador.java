package Controlador;

import Algoritmos.GaleShapley;
import Algoritmos.Similitud;
import Modelo.Empresa;
import Modelo.Postulante;
import Algoritmos.HashTable;
import java.util.List;

public class Controlador {

    public static void main(String[] args) {

        // Definir empresas
        Empresa[] empresas = new Empresa[3];
        empresas[0] = new Empresa(
                "E123",
                "TechSecurity S.A.",
                "Compañía líder en servicios de ciberseguridad y análisis de datos.",
                "Se requieren analistas de datos y ciberseguridad, con interés en Python y cloud.",
                "Lima, Perú",
                "Servicios TI",
                new String[]{"ciberseguridad", "analítica de datos", "cloud", "automatización"},
                2
        );

        empresas[1] = new Empresa(
                "E456",
                "DataInsights Consulting",
                "Consultora especializada en proyectos de analítica de datos para diversas industrias.",
                "Buscamos practicantes con interés en BI, SQL y modelos de machine learning básicos.",
                "Lima, Perú",
                "Consultoría",
                new String[]{"analítica de datos", "business intelligence", "machine learning"},
                2
        );

        empresas[2] = new Empresa(
                "E789",
                "CloudSolutions Peru",
                "Empresa dedicada a migración y gestión de infraestructura en la nube.",
                "Se requiere interés en DevOps, automatización y servicios cloud.",
                "Lima, Perú",
                "Servicios TI",
                new String[]{"cloud", "devops", "infraestructura", "automatización"},
                1
        );

        // Definir postulantes
        Postulante[] postulantes = new Postulante[5];
        postulantes[0] = new Postulante(
                "P001",
                "Juan Pérez",
                "Estudiante de ingeniería de sistemas, proactivo, con gusto por la ciberseguridad y aprendizaje automático.",
                "Me interesa la programación, ciberseguridad, análisis de datos y trabajar en cloud.",
                new String[]{"Python", "SQL", "Linux", "ciberseguridad"},
                "Lima, Perú",
                "Pregrado – Ingeniería de Sistemas"
        );

        postulantes[1] = new Postulante(
                "P002",
                "María López",
                "Estudiante de ingeniería industrial con interés en inteligencia de negocios.",
                "Me gusta el análisis de datos, dashboards y reporting.",
                new String[]{"Power BI", "Excel", "SQL"},
                "Lima, Perú",
                "Pregrado – Ingeniería Industrial"
        );

        postulantes[2] = new Postulante(
                "P003",
                "Carlos Díaz",
                "Estudiante de ingeniería de sistemas con interés en cloud y DevOps.",
                "Me interesa automatizar despliegues y trabajar con contenedores.",
                new String[]{"Linux", "Docker", "Python"},
                "Lima, Perú",
                "Pregrado – Ingeniería de Sistemas"
        );

        postulantes[3] = new Postulante(
                "P004",
                "Ana Torres",
                "Estudiante de computación científica con interés en machine learning.",
                "Me gusta experimentar con modelos de clasificación y regresión.",
                new String[]{"Python", "Pandas", "Scikit-learn"},
                "Lima, Perú",
                "Pregrado – Computación Científica"
        );

        postulantes[4] = new Postulante(
                "P005",
                "Luis Gómez",
                "Estudiante de informática con interés en soporte y redes.",
                "Me interesa la administración de sistemas y mantenimiento de redes.",
                new String[]{"Redes", "Soporte técnico", "Windows Server"},
                "Lima, Perú",
                "Pregrado – Informática"
        );

        // Mostrar similitudes
        System.out.println("==== SIMILITUDES ====");
        for (Empresa e : empresas) {
            for (Postulante p : postulantes) {
                double jaro = Similitud.jaroWinkler(e, p);
                double lev = Similitud.levenshteinSim(e, p);
                double fin = Similitud.similitudFinal(e, p);

                System.out.println(e.getNombre()+" <-> "+p.getNombre());
                System.out.println("  Jaro: "+jaro);
                System.out.println("  Levenshtein: "+lev);
                System.out.println("  Ponderado: "+fin);
            }
        }

        // Gale-Shapley
        HashTable resultado = GaleShapley.emparejar(empresas, postulantes);

        System.out.println("\n==== RESULTADO FINAL ====");
        for (Empresa e : empresas) {
            System.out.println("Empresa: " + e.getNombre());
            @SuppressWarnings("unchecked")
            List<Postulante> lista = (List<Postulante>) resultado.buscar(e.getCodigo());
            if (lista != null && !lista.isEmpty()) {
                for (Postulante p : lista) {
                    System.out.println(" - " + p.getNombre());
                }
            } else System.out.println(" - Sin asignados");
        }
    }
}
