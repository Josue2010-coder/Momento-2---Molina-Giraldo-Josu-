
public class Cliente extends Usuario {

    public Cliente(String id, String nombre, int edad, int nivelAcceso) {
        super(id, nombre, edad, nivelAcceso);

        if (nivelAcceso == 3) {
            throw new IllegalArgumentException(
                "Un cliente solo puede tener nivel 1 o 2"
            );
        }
    }

    @Override
    public String getTipoUsuario() {
        return "Cliente";
    }
}
