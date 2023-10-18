
package editordibujosvectoriales;

/**
 *
 * @author yijana
 */
public class ListaLigada {

    Nodo cabeza;

    public ListaLigada() {
        cabeza = null;
    }

    public void agregar(Trazo trazo) {
        Nodo nuevoNodo = new Nodo(trazo);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void eliminarUltimo() {
        if (cabeza == null) {
            // La lista está vacía, no hay nada que eliminar
            return; 
        }
        if (cabeza.siguiente == null) {
            // Hay solo un elemento en la lista, se elimina
            cabeza = null; 
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            // Eliminar el último nodo
            actual.siguiente = null; 
        }
    }  
}
