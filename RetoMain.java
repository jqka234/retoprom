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
