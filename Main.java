public class Main {

    static class Contador {
        int trocas = 0;
        int iteracoes = 0;
    }

    public static void main(String[] args) {

        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        comparar("VETOR 1", vetor1);
        comparar("VETOR 2", vetor2);
        comparar("VETOR 3", vetor3);
    }

    static void comparar(String nome, int[] vetorOriginal) {
        System.out.println("\n=== " + nome + " ===");
        System.out.printf("%-15s %-15s %-15s\n", "Algoritmo", "Trocas", "Iterações");

        testar("BubbleSort flag", vetorOriginal, Main::bubbleSortFlag);
        testar("SelectionSort", vetorOriginal, Main::selectionSort);
        testar("CocktailSort", vetorOriginal, Main::cocktailSort);
        testar("CombSort", vetorOriginal, Main::combSort);
        testar("GnomeSort", vetorOriginal, Main::gnomeSort);
        testar("BucketSort", vetorOriginal, Main::bucketSort);
    }

    interface SortFunc {
        void sort(int[] v, Contador c);
    }

    static void testar(String nome, int[] vetorOriginal, SortFunc func) {
        int[] vetor = vetorOriginal.clone();
        Contador c = new Contador();
        func.sort(vetor, c);
        System.out.printf("%-15s %-15d %-15d\n", nome, c.trocas, c.iteracoes);
    }




    static void bubbleSortFlag(int[] v, Contador c) {
        boolean trocou;
        for (int i = 0; i < v.length - 1; i++) {
            trocou = false;
            for (int j = 0; j < v.length - i - 1; j++) {
                c.iteracoes++;
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    c.trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }


    static void selectionSort(int[] v, Contador c) {
        for (int i = 0; i < v.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < v.length; j++) {
                c.iteracoes++;
                if (v[j] < v[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = v[i];
                v[i] = v[minIndex];
                v[minIndex] = temp;
                c.trocas++;
            }
        }
    }

    // 3. Cocktail Sort
    static void cocktailSort(int[] v, Contador c) {
        boolean trocou = true;
        int inicio = 0;
        int fim = v.length - 1;
        while (trocou) {
            trocou = false;
            for (int i = inicio; i < fim; i++) {
                c.iteracoes++;
                if (v[i] > v[i + 1]) {
                    int temp = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = temp;
                    c.trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
            trocou = false;
            fim--;
            for (int i = fim; i > inicio; i--) {
                c.iteracoes++;
                if (v[i] < v[i - 1]) {
                    int temp = v[i];
                    v[i] = v[i - 1];
                    v[i - 1] = temp;
                    c.trocas++;
                    trocou = true;
                }
            }
            inicio++;
        }
    }


    static void combSort(int[] v, Contador c) {
        int tamanho = v.length;
        int gap = tamanho;
        boolean trocou = true;
        double shrink = 1.3;

        while (gap > 1 || trocou) {
            gap = (int)(gap / shrink);
            if (gap < 1) gap = 1;
            trocou = false;

            for (int i = 0; i + gap < tamanho; i++) {
                c.iteracoes++;
                if (v[i] > v[i + gap]) {
                    int temp = v[i];
                    v[i] = v[i + gap];
                    v[i + gap] = temp;
                    c.trocas++;
                    trocou = true;
                }
            }
        }
    }


    static void gnomeSort(int[] v, Contador c) {
        int i = 0;
        while (i < v.length) {
            c.iteracoes++;
            if (i == 0 || v[i] >= v[i - 1]) {
                i++;
            } else {
                int temp = v[i];
                v[i] = v[i - 1];
                v[i - 1] = temp;
                c.trocas++;
                i--;
            }
        }
    }


    static void bucketSort(int[] v, Contador c) {
        int max = v[0];
        int min = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] > max) max = v[i];
            if (v[i] < min) min = v[i];
        }

        int bucketCount = 5; // quantidade de baldes
        int range = (max - min + 1);
        int bucketRange = (int)Math.ceil((double)range / bucketCount);
        java.util.LinkedList<Integer>[] buckets = new java.util.LinkedList[bucketCount];
        for (int i = 0; i < bucketCount; i++) buckets[i] = new java.util.LinkedList<>();

        for (int i = 0; i < v.length; i++) {
            c.iteracoes++;
            int index = (v[i] - min) / bucketRange;
            if (index >= bucketCount) index = bucketCount - 1;
            buckets[index].add(v[i]);
        }

        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
            int[] temp = new int[buckets[i].size()];
            for (int j = 0; j < temp.length; j++) temp[j] = buckets[i].get(j);
            insertionSort(temp, c);
            for (int j = 0; j < temp.length; j++) {
                v[k++] = temp[j];
            }
        }
    }

    static void insertionSort(int[] v, Contador c) {
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                c.iteracoes++;
                v[j + 1] = v[j];
                j--;
                c.trocas++;
            }
            v[j + 1] = chave;
        }
    }
}
