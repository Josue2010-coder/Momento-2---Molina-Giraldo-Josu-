
import java.util.ArrayList;
import java.util.List;

public class ControlAcceso {

    private final GestorUsuarios gestorUsuarios = new GestorUsuarios();
    private final GestorZonas gestorZonas = new GestorZonas();
    private final List<String> bitacora = new ArrayList<>();

    public void registrarUsuario(Usuario usuario) {
        gestorUsuarios.guardar(usuario);
        System.out.println("Usuario registrado: " + usuario);
    }

    public Usuario buscarUsuario(String id) {
        return gestorUsuarios.buscar(id);
    }

    public boolean eliminarUsuario(String id) {
        return gestorUsuarios.eliminar(id);
    }

    public boolean actualizarUsuario(String id, String nombre, int edad) {
        return gestorUsuarios.actualizar(id, nombre, edad);
    }

    public void registrarZona(Zona zona) {
        gestorZonas.guardar(zona);
        System.out.println("Zona registrada: " + zona);
    }

    public Zona buscarZona(String codigo) {
        return gestorZonas.buscar(codigo);
    }

    public boolean intentarIngreso(String idUsuario, String codigoZona) {

        Usuario usuario = buscarUsuario(idUsuario);

        if (usuario == null) {
            System.out.println(
                "ningun usuario tiene ese id: " + idUsuario
            );
            return false;
        }

        Zona zona = buscarZona(codigoZona);

        if (zona == null) {
            System.out.println(
                "No existe una zona con codigo: " + codigoZona
            );
            return false;
        }

        boolean permitido =
            usuario.getNivelAcceso() >= zona.getNivelRequerido();

String evento = usuario.getNombre() + " (" 
        + usuario.getTipoUsuario() + ") intento ingresar a "
        + zona.getNombre();

if (permitido) {
    evento = evento + "SI PUEDES BRO PASA";
} else {
    evento = evento + "NEL BRO NO PUEDES";
}

        bitacora.add(evento);
        System.out.println(evento);

        if (permitido) {
            zona.setAbierta(true);
        }

        return permitido;
    }

    public void cerrarZona(String codigoZona) {

        Zona zona = buscarZona(codigoZona);

        if (zona == null) {
            System.out.println(
                "Una zona con ese codigo no existe: " + codigoZona
            );
            return;
        }

        zona.setAbierta(false);

        System.out.println(
            "Zona \"" + zona.getNombre() + "\" cerrada."
        );
    }

    public void mostrarUsuarios() {

        System.out.println("Usuarios registrados");

        List<Usuario> usuarios = gestorUsuarios.listar();

        if (usuarios.isEmpty()) {
            System.out.println("(sin usuarios)");
        }

        for (Usuario usuario : usuarios) {
            System.out.println(" - " + usuario);
        }
    }

    public void mostrarZonas() {

        System.out.println("Zonas registradas");

        List<Zona> zonas = gestorZonas.listar();

        if (zonas.isEmpty()) {
            System.out.println("(sin zonas)");
        }

        for (Zona zona : zonas) {
            System.out.println(" - " + zona);
        }
    }

    public void mostrarBitacora() {

        System.out.println("Bitacora de accesos");

        if (bitacora.isEmpty()) {
            System.out.println("(sin eventos)");
        }

        for (String evento : bitacora) {
            System.out.println(" - " + evento);
        }
    }
}
