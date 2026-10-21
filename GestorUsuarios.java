
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GestorUsuarios implements Operaciones<Usuario, String> {

    private final Map<String, Usuario> usuarios = new LinkedHashMap<>();

    @Override
    public void guardar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException(
                "El usuario no puede ser nada bro"
            );
        }

        if (usuarios.containsKey(usuario.getId())) {
            throw new IllegalArgumentException(
                "Ya existe un usuario con ese id bro"
            );
        }

        usuarios.put(usuario.getId(), usuario);
    }

    @Override
    public Usuario buscar(String id) {
        return usuarios.get(id);
    }

    @Override
    public boolean eliminar(String id) {
        return usuarios.remove(id) != null;
    }

    public List<Usuario> listar() {
        return new ArrayList<>(usuarios.values());
    }

    public boolean actualizar(String id, String nuevoNombre, int nuevaEdad) {
        Usuario usuario = buscar(id);

        if (usuario == null) {
            return false;
        }

        usuario.setNombre(nuevoNombre);
        usuario.setEdad(nuevaEdad);

        return true;
    }
}
