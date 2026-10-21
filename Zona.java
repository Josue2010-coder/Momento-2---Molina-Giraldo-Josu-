
public class Zona {

    private final String codigo;
    private String nombre;
    private int nivelRequerido;
    private boolean abierta;

    public Zona(String codigo, String nombre, int nivelRequerido) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                "El codigo no puede estar vacio."
            );
        }

        this.codigo = codigo.trim();
        setNombre(nombre);
        setNivelRequerido(nivelRequerido);
        this.abierta = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelRequerido() {
        return nivelRequerido;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre de la zona no puede estar vacio."
            );
        }

        this.nombre = nombre.trim();
    }

    public void setNivelRequerido(int nivelRequerido) {
        if (nivelRequerido < 1 || nivelRequerido > 3) {
            throw new IllegalArgumentException(
                "El nivel requerido debe estar entre 1 y 3."
            );
        }

        this.nivelRequerido = nivelRequerido;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

@Override
public String toString() {
    return "[" + codigo + "] " + nombre
            + " - Nivel requerido: " + nivelRequerido
            + " (" + (abierta ? "Abierta" : "Cerrada") + ")";
}
 }