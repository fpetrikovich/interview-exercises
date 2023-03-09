public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        /**
         * Two Pointer Approach
         * Nos vamos moviendo hacia adentro con el puntero que este apuntando
         * a la linea vertical mas corta. Esto es porque la linea x corta es la
         * que limita el area (esta sumergida hasta el tope) y no puede haber
         * ninguna linea mas adentro con la cual el area de esta con x sea
         * mayor a la actual (porque se va achicar el width pero no el height).
         *
         * Tambien puedo saltear las lineas que no me aumenten el tamano minimo
         * del contenedor porque esto significa que estoy achicando el width pero
         * manteniendo igual o menor el height. Nunca puede haber un area mas grande
         * si se cumple esto.
         *
         * Time Complexity O(N) / Space Complexity O(1)
         */

        int maxContainer = 0, leftLine = 0, rightLine = height.length - 1;
        int width, minH;

        while (leftLine < rightLine) {
            // Width of current container and heights
            width = rightLine - leftLine;
            minH = Math.min(height[leftLine], height[rightLine]);

            // Update max area if necessary
            maxContainer = Math.max(maxContainer, width * minH);

            // Update the pointers
            while (leftLine < rightLine && height[leftLine] <= minH) leftLine++;
            while (leftLine < rightLine && height[rightLine] <= minH) rightLine--;

        }
        return maxContainer;
    }

    public int maxAreaBF(int[] height) {

        // Brute Force TC = O(N^2)

        int maxContainer = 0, currContainer;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                currContainer = (j-i) * Math.min(height[i], height[j]);
                maxContainer = Math.max(maxContainer, currContainer);
            }
        }
        return maxContainer;
    }
}
