import java.util.Arrays;

public class QuickSortNombres {

    
      // Quick Sort principal 
   
    public static void quickSort(String[] nombres, int bajo, int alto) {
        if (bajo < alto) {
            // Encuentra el índice del pivote después de la partición
            int indiceParticion = particion(nombres, bajo, alto);

            // Llama recursivamente a la función para ordenar las dos sublistas
            quickSort(nombres, bajo, indiceParticion - 1); // Sublista izquierda
            quickSort(nombres, indiceParticion + 1, alto); // Sublista derecha
        }
    }

    
    //Realiza el paso de partición del Quick Sort.
    //Elige el último elemento como pivote y coloca los elementos más
    //"pequeños" (alfabéticamente) a su izquierda y los "grandes" a su derecha.
   
    private static int particion(String[] nombres, int bajo, int alto) {
        // Seleccionamos el último elemento como pivote
        String pivote = nombres[alto];
        int i = (bajo - 1); // Índice del elemento más pequeño

        for (int j = bajo; j < alto; j++) {
            // Usamos compareTo() para la comparación alfabética:
            // Si nombres[j] es menor que (o igual a) el pivote, significa que va antes.
            if (nombres[j].compareTo(pivote) <= 0) {
                i++;

                // Intercambio de nombres[i] y nombres[j]
                String temp = nombres[i];
                nombres[i] = nombres[j];
                nombres[j] = temp;
            }
        }

        // Intercambia el pivote con el elemento en la posición (i + 1)
        String temp = nombres[i + 1];
        nombres[i + 1] = nombres[alto]; // nombres[alto] es el pivote
        nombres[alto] = temp;

        return i + 1;
    }

    // Método principal para demostrar el uso
    public static void main(String[] args) {
        String[] listaNombres = {
            "Carlos", "Ana", "David", "Beatriz", "Eva", "Felipe", "Gala"
        };

        System.out.println("Lista de nombres original: " + Arrays.toString(listaNombres));

        // Llamada a la función Quick Sort
        quickSort(listaNombres, 0, listaNombres.length - 1);

        System.out.println("---------------------------------");
        System.out.println("Lista de nombres ordenada: " + Arrays.toString(listaNombres));
    }
}
