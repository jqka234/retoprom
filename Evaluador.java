import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Evaluador {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private File archivo = new File("estudiantes.txt");

    public Evaluador() {
        cargar();
    }

   
    public void registrar() {
        String id = JOptionPane.showInputDialog("ID del estudiante:");
        String nombre = JOptionPane.showInputDialog("Nombre del estudiante:");

        if (buscar(id) != null) {
            JOptionPane.showMessageDialog(null, "Ese ID ya existe.");
            return;
        }

        estudiantes.add(new Estudiante(id, nombre));
        guardar();
        JOptionPane.showMessageDialog(null, "Estudiante registrado.");
    }// este metodo se encarga de registrar estudiantes nuevos


    public void asignar() {
        String id = JOptionPane.showInputDialog("ID del estudiante:");
        Estudiante e = buscar(id);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "No encontrado.");
            return;
        }

        try {
            int p = Integer.parseInt(JOptionPane.showInputDialog("Puntos a agregar:"));
            e.agregarPuntos(p);
            guardar();
            JOptionPane.showMessageDialog(null, "Puntos agregados.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }//este es el metodo  que le asigna los puntos a los estuiantes

    
    public void ranking() {
        if (estudiantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes.");
            return;
        }

        estudiantes.sort((a, b) -> b.getPuntos() - a.getPuntos());
        StringBuilder s = new StringBuilder("=== Ranking ===\n");
        for (Estudiante e : estudiantes) s.append(e).append("\n");
        JOptionPane.showMessageDialog(null, s.toString());
    }//muestra el ranking en orden de mauyor a menor

    
    private Estudiante buscar(String id) {
        for (Estudiante e : estudiantes)
            if (e.getId().equalsIgnoreCase(id)) return e;
        return null;
    }

    // Guardar datos en archivo
    private void guardar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Estudiante e : estudiantes)
                pw.println(e.getId() + "," + e.getNombre() + "," + e.getPuntos() + "," + e.getNivel());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar.");
        }
    }

    // Cargar datos desde archivo
    private void cargar() {
        if (!archivo.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                String[] p = l.split(",");
                if (p.length == 4) {
                    Estudiante e = new Estudiante(p[0], p[1]);
                    e.agregarPuntos(Integer.parseInt(p[2]));
                    estudiantes.add(e);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar.");
        }
    }
}
