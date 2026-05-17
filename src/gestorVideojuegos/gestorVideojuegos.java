package gestion;

import modelo.Videojuego;
import utilidades.Utilidades;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GestorVideojuegos {

    private static ArrayList<Videojuego> lista = new ArrayList<>();

    public static void iniciarPrograma() {

        int opcion;

        do {

            opcion = mostrarMenu();

            switch (opcion) {

                case 1:
                    añadirVideojuego();
                    break;

                case 2:
                    editarVideojuego();
                    break;

                case 3:
                    mostrarVideojuegos();
                    break;

                case 4:
                    eliminarVideojuego();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Programa finalizado.");
                    break;
            }

        } while (opcion != 5);
    }

    public static int mostrarMenu() {

        return Utilidades.pedirNumero(
                "=== MENÚ ===\n" +
                        "1. Añadir videojuego\n" +
                        "2. Editar videojuego\n" +
                        "3. Mostrar videojuegos\n" +
                        "4. Eliminar videojuego\n" +
                        "5. Salir",
                1,
                5
        );
    }

    public static void añadirVideojuego() {

        String nombre = Utilidades.pedirTexto("Nombre:");
        String genero = Utilidades.pedirTexto("Género:");
        String plataforma = Utilidades.pedirTexto("Plataforma:");
        int puntuacion = Utilidades.pedirNumero("Puntuación (1-5):", 1, 5);

        Videojuego videojuego = new Videojuego(
                nombre,
                genero,
                plataforma,
                puntuacion
        );

        lista.add(videojuego);

        JOptionPane.showMessageDialog(null,
                "Videojuego añadido correctamente.");
    }

    public static void mostrarVideojuegos() {

        if (lista.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "No hay videojuegos guardados.");

            return;
        }

        Collections.sort(lista,
                Comparator.comparing(Videojuego::getPuntuacion).reversed());

        String texto = "";

        for (Videojuego v : lista) {

            texto += v + "\n\n";
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    public static void editarVideojuego() {

        if (lista.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "No hay videojuegos para editar.");

            return;
        }

        String listaNombres = "";

        for (int i = 0; i < lista.size(); i++) {

            listaNombres += i + " - "
                    + lista.get(i).getNombre() + "\n";
        }

        int indice = Utilidades.pedirNumero(
                "Selecciona un videojuego:\n" + listaNombres,
                0,
                lista.size() - 1
        );

        Videojuego v = lista.get(indice);

        v.setNombre(Utilidades.pedirTexto("Nuevo nombre:"));
        v.setGenero(Utilidades.pedirTexto("Nuevo género:"));
        v.setPlataforma(Utilidades.pedirTexto("Nueva plataforma:"));
        v.setPuntuacion(Utilidades.pedirNumero(
                "Nueva puntuación:",
                1,
                5
        ));

        JOptionPane.showMessageDialog(null,
                "Videojuego editado correctamente.");
    }

    public static void eliminarVideojuego() {

        if (lista.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "No hay videojuegos para eliminar.");

            return;
        }

        String listaNombres = "";

        for (int i = 0; i < lista.size(); i++) {

            listaNombres += i + " - "
                    + lista.get(i).getNombre() + "\n";
        }

        int indice = Utilidades.pedirNumero(
                "Selecciona el videojuego a eliminar:\n" + listaNombres,
                0,
                lista.size() - 1
        );

        lista.remove(indice);

        JOptionPane.showMessageDialog(null,
                "Videojuego eliminado correctamente.");
    }
}