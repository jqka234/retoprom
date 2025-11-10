import javax.swing.JOptionPane;

public class RetoMain {
    public static void main(String[] args) {
        Evaluador ev = new Evaluador();

        while (true) {// interfaz del programa  principal
            String m = """
                    === Sistema de Evaluación ===
                    1. Registrar estudiante
                    2. Asignar puntos
                    3. Mostrar ranking
                    4. Salir
                    """;

            String op = JOptionPane.showInputDialog(m);
            if (op == null) break;

            switch (op) {
                case "1" -> ev.registrar();
                case "2" -> ev.asignar();
                case "3" -> ev.ranking();
                case "4" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}
//Pregunta 1
//Puse el método calcularNivel() en la clase Estudiante porque es el propio estudiante el que debe saber su nivel según los puntos que tiene
//Pensé en ponerlo en la clase Evaluador, pero me pareció más ordenado que cada estudiante se encargue de eso. Así el código queda más fácil de entender.

//pregunta 2
//Podría fallar si alguien escribe letras en lugar de números al asignar puntos. Para evitarlo, usé un try-catch que muestra un mensaje de error cuando pasa eso,
//También podría fallar si el usuario deja campos vacíos, así que en el futuro se podría validar eso mejor

//Pregunta 3
//Porque si no se guardan, todo se pierde cuando se cierra el programa. Guardarlos en un archivo permite que la próxima vez que se abra, todo siga igual

//pregunta 4
//Aprendí cómo usar clases para organizar mejor el código y cómo guardar datos en un archivo de texto con FileWriter y BufferedReader
//me ccosto muchho lo de guardar el archihvo, siento que es una logica un poco distitnta a como me tenia acostubrado python

//pregunta 5
//creo que si se necesitara ampliar muchho la cantidadd de estudiantes se deberia crear otra clase para ir organizando la lista de los estuiantes
