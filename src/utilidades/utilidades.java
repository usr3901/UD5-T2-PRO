package utilidades;

import javax.swing.JOptionPane;

/*
 * Clase Utilidades
 * Contiene métodos estáticos reutilizables para validaciones y solicitudes de datos.
 */

public class Utilidades {

    public static String pedirTexto(String mensaje) {

        String texto = "";

        do {

            texto = JOptionPane.showInputDialog(mensaje);

            if (texto == null || texto.trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "El texto no puede estar vacío.");
            }

        } while (texto == null || texto.trim().isEmpty());

        return texto;
    }

    public static int pedirNumero(String mensaje, int min, int max) {

        int numero = 0;
        boolean valido = false;

        while (!valido) {

            try {

                String entrada = JOptionPane.showInputDialog(mensaje);

                numero = Integer.parseInt(entrada);

                if (numero >= min && numero <= max) {

                    valido = true;

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Introduce un número entre " + min + " y " + max);
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null,
                        "Debes introducir un número válido.");
            }
        }

        return numero;
    }
}