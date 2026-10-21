
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GestorZonas implements Operaciones<Zona, String> {

    private final Map<String, Zona> zonas = new LinkedHashMap<>();

    @Override
    public void guardar(Zona zona) {
        if (zona == null) {
            throw new IllegalArgumentException(
                "La zona no puede ser nula."
            );
        }

        if (zonas.containsKey(zona.getCodigo())) {
            throw new IllegalArgumentException(
                "Ya existe una zona con ese codigo bro"
            );
        }

        zonas.put(zona.getCodigo(), zona);
    }

    @Override
    public Zona buscar(String codigo) {
        return zonas.get(codigo);
    }

    @Override
    public boolean eliminar(String codigo) {
        return zonas.remove(codigo) != null;
    }

    public List<Zona> listar() {
        return new ArrayList<>(zonas.values());
    }
}
