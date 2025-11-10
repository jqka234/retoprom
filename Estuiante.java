public class Estuiante {
    private String id;
    private String nombre;
    private int puntos;
    private String nivel;


    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = 0;
        this.nivel = "Novato";
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getPuntos() { return puntos; }
    public String getNivel() { return nivel; } // metodos getter


    public void agregarPuntos(int p) {
        puntos += p;
        calcularNivel();
    }//sumo los puntos y los actualizo


    public void calcularNivel() {
        if (puntos < 100) nivel = "Novato";
        else if (puntos < 200) nivel = "Intermedio";
        else if (puntos < 300) nivel = "Avanzado";
        else nivel = "Experto";
    }//calculo el nivel segun los puntos

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + puntos + " pts | " + nivel;
    }
}
