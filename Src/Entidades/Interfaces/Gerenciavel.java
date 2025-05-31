package Src.Entidades.Interfaces;

import java.util.List;

/**
 * Interface que define operações básicas de CRUD.
 */
public interface Gerenciavel<T> {
    void cadastrar(T item);
    void alterar(T item);
    void remover(T item);
    List<T> listarTodos();
    T buscarPorId(int id);
}
