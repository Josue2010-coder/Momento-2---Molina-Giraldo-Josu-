
public interface Operaciones<T, K> {

    void guardar(T objeto);

    T buscar(K id);

    boolean eliminar(K id);
}
