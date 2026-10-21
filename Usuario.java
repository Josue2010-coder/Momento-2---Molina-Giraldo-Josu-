
public abstract class Usuario {

    private final String id;
    private String nombre;
    private int edad;
    private int nivelAcceso;

    public Usuario(String id, String nombre, int edad, int nivelAcceso) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                "El id no puede estar vacio, ponle un id bro"
            );
        }

        this.id = id.trim();
        setNombre(nombre);
        setEdad(edad);
        setNivelAcceso(nivelAcceso);
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacio, ponle un nombre chaval"
            );
        }

        this.nombre = nombre.trim();
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException(
                "La edad no puede ser negativa, pon una edad bien"
            );
        }

        this.edad = edad;
    }

    protected void setNivelAcceso(int nivelAcceso) {
        if (nivelAcceso < 1 || nivelAcceso > 3) {
            throw new IllegalArgumentException(
                "El nivel de acceso debe ser 1, 2 o 3 bro"
            );
        }

        this.nivelAcceso = nivelAcceso;
    }

    public abstract String getTipoUsuario();

@Override
public String toString() {
    return getTipoUsuario() + "[" + id + "] " + nombre
            + " (" + edad + " años) - Nivel de acceso: "
            + nivelAcceso;
}
 }