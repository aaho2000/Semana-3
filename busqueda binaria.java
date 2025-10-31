import java.util.Arrays;

public class QuickSortNombres {

  

    // Método de Quick Sort principal
    public static void quickSort(String[] nombres, int bajo, int alto) {
        if (bajo < alto) {
            // ... (cuerpo del método quickSort) ...
            int indiceParticion = particion(nombres, bajo, alto);
            quickSort(nombres, bajo, indiceParticion - 1);
            quickSort(nombres, indiceParticion + 1, alto);
        }
    }

    // Realiza el paso de partición del Quick Sort.
    private static int particion(String[] nombres, int bajo, int alto) {
        // ... (cuerpo del método particion) ...
        String pivote = nombres[alto];
        int i = (bajo - 1);

        for (int j = bajo; j < alto; j++) {
            if (nombres[j].compareTo(pivote) <= 0) {
                i++;
                String temp = nombres[i];
                nombres[i] = nombres[j];
                nombres[j] = temp;
            }
        }
        String temp = nombres[i + 1];
        nombres[i + 1] = nombres[alto];
        nombres[alto] = temp;
        return i + 1;
    }

    

    
    //  Realiza una búsqueda binaria en un array de nombres ORDENADO.
    
    public static int busquedaBinaria(String[] nombres, String clave) {
        int bajo = 0;
        int alto = nombres.length - 1;

        while (bajo <= alto) {
            int medio = bajo + (alto - bajo) / 2; // Previene desbordamiento de enteros

            // Comparamos el elemento central con la clave
            int comparacion = clave.compareTo(nombres[medio]);

            // Caso 1: Encontrado (comparacion es 0)
            if (comparacion == 0) {
                return medio;
            }
            // Caso 2: La clave es mayor (va alfabéticamente después)
            else if (comparacion > 0) {
                bajo = medio + 1; // Busca en la mitad derecha
            }
            // Caso 3: La clave es menor (va alfabéticamente antes)
            else {
                alto = medio - 1; // Busca en la mitad izquierda
            }
        }

        // Si el bucle termina, el elemento no se encontró
        return -1;
    }

    // main

    public static void main(String[] args) {
        String[] listaNombres = {
            "Carlos", "Ana", "David", "Beatriz", "Eva", "Felipe", "Gala"
        };

        System.out.println("Lista de nombres original: " + Arrays.toString(listaNombres));

        // 1. Ordenar la lista (PRERREQUISITO para Búsqueda Binaria)
        quickSort(listaNombres, 0, listaNombres.length - 1);
        System.out.println("---------------------------------");
        System.out.println("Lista de nombres ordenada: " + Arrays.toString(listaNombres));
        System.out.println("---------------------------------");

        // 2. Aplicar Búsqueda Binaria para encontrar nombres

        String nombreBuscado1 = "David";
        int indice1 = busquedaBinaria(listaNombres, nombreBuscado1);

        if (indice1 != -1) {
            System.out.println("'" + nombreBuscado1 + "' encontrado en el índice: " + indice1);
        } else {
            System.out.println("'" + nombreBuscado1 + "' no se encontró.");
        }

        String nombreBuscado2 = "Zulema";
        int indice2 = busquedaBinaria(listaNombres, nombreBuscado2);

        if (indice2 != -1) {
            System.out.println("'" + nombreBuscado2 + "' encontrado en el índice: " + indice2);
        } else {
            System.out.println("'" + nombreBuscado2 + "' no se encontró.");
        }
    }
}
