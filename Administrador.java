
public class Administrador extends Usuario {

    public Administrador(String id, String nombre, int edad) {
        super(id, nombre, edad, 3);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
}
