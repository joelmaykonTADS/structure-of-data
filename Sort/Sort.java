import java.io.*;
import java.util.*;
import java.util.Date;

class Sort {
  public void ordenar() {
    Timer timer = new Timer();
    lerBubleSort("teste_100000_1.dat");
     System.out.println("  Tempo: " + timer);
    Timer timer2 = new Timer();
    lerSelectSort("teste_100000_1.dat");
    System.out.println("  Tempo: " + timer2);
    Timer timer3 = new Timer();
    lerInsertSort("teste_100000_1.dat");
    System.out.println("  Tempo: " + timer3);
    Timer timer5 = new Timer();
    lerHeapSort("teste_100000_1.dat");
    System.out.println("  Tempo: " + timer5);
  }

  public void lerBubleSort(String caminho) {
    try {
      FileReader fr = new FileReader(caminho);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) {
        int[] numeros = convertStrToInt(line);
        bubleSort(numeros);
        line = br.readLine();
      }
      br.close();
      fr.close();

    } catch (IOException e2) {
    }
  }

  public void lerSelectSort(String caminho) {
    try {
      FileReader fr = new FileReader(caminho);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) {
        int[] numeros = convertStrToInt(line);
        selectSort(numeros);
        line = br.readLine();
      }
      br.close();
      fr.close();

    } catch (IOException e2) {
    }
  }

  public void lerInsertSort(String caminho) {
    try {
      FileReader fr = new FileReader(caminho);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) {
        int[] numeros = convertStrToInt(line);
        insertSort(numeros);
        line = br.readLine();
      }
      br.close();
      fr.close();

    } catch (IOException e2) {
    }
  }

  public void lerMergeSort(String caminho) {
    try {
      FileReader fr = new FileReader(caminho);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) {
        int[] numeros = convertStrToInt(line);
        mergeSort(numeros);
        line = br.readLine();
      }
      br.close();
      fr.close();

    } catch (IOException e2) {
    }
  }

  public void lerHeapSort(String caminho) {
    try {
      FileReader fr = new FileReader(caminho);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();     
      while (line != null) {
        int[] numeros = convertStrToInt(line);
        ordena(numeros);
        line = br.readLine();
      }
      br.close();
      fr.close();

    } catch (IOException e2) {
    }
  }

  public int[] convertStrToInt(String str) {
    int size = str.length();
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = Character.digit(str.charAt(i), 10);
    }
    return arr;
  }

  
  public void bubleSort(int[] lista) {
    int aux = 0;
    // Timer timer = new Timer();
    for (int i = 0; i < lista.length - 2; i++) {
      for (int j = 0; j < lista.length - 2 - i; j++) {
        if (lista[j] > lista[j + 1]) {
          aux = lista[j];
          lista[j] = lista[j + 1];
          lista[j + 1] = aux;
        }
      }
    }
    
    /*
     * for(int i = 0; i < lista.length; i++){ System.out.print(lista[i]); }
     * 
     * System.out.println("  Tempo: "+timer); System.out.println("");
     */
  }

  public void selectSort(int[] lista) {
    int aux = 0;
    // Timer timer = new Timer();
    for (int i = 0; i < lista.length - 2; i++) {
      for (int j = i + 1; j < lista.length - 1; j++) {
        if (lista[j] < lista[i]) {
          aux = lista[j];
          lista[j] = lista[i];
          lista[i] = aux;
        }
      }
    }
    /*
     * for(int i = 0; i < lista.length; i++){ System.out.print(lista[i]); }
     * 
     * System.out.println("  Tempo: "+timer); System.out.println("");
     */
  }

  public void insertSort(int[] lista) {
    // Timer timer = new Timer();
    for (int i = 1; i < lista.length - 1; i++) {
      int aux = lista[i];
      int j = i - 1;
      while ((j >= 0) && (aux < lista[j])) {
        lista[j + 1] = lista[j];
        j = j - 1;
      }
      lista[j + 1] = aux;
    }
    /*
     * for (int i = 0; i < lista.length; i++) { System.out.print(lista[i]); }
     * System.out.println("");
     * 
     * System.out.println("  Tempo: "+timer); System.out.println("");
     */
  }

  public int[] mergeSort(int[] lista) {
    int n = lista.length;
    if (n == 1)
      return lista;
    int[] s1 = new int[(n + 1) / 2];
    int[] s2 = new int[n - s1.length];
    // System.out.println(s1.length);
    // System.out.println(s2.length);
    for (int i = 0; i < n; i++) {
      if (i < s1.length)
        s1[i] = lista[i];
      else
        s2[i - s1.length] = lista[i];
    }

    s1 = mergeSort(s1);
    s2 = mergeSort(s2);

    return merge(s1, s2);
  }

  public int[] merge(int[] s1, int[] s2) {
    int[] arr = new int[0];
    /*
      int[] arr = new int[s1.length + s2.length -1];
      while((s1.length > 0) &&(s2.length > 0))
      { if(s1[0] > s2[0]){ s2[0] = c[c.length]; } }
     */

    return arr;
  }

  public static void ordena(int[] lista) {
    montaHeap(lista);
    int n = lista.length;

    for (int i = lista.length - 1; i > 0; i--) {
      int aux = lista[i];
      lista[i] = lista[0];
      lista[0] = aux;
      ordenarArvore(lista, 0, --n);

    }
  }

  public static void montaHeap(int[] lista) {
    for (int posicao = (lista.length - 1) / 2; posicao >= 0; posicao--) {
      ordenarArvore(lista, posicao, lista.length);
    }
  }

  public static void ordenarArvore(int[] lista, int posicao, int tamanhoVetor) {

    int filho1 = 2 * posicao + 1;
    int filho2 = filho1 + 1;

    if (filho1 < tamanhoVetor) {
      if (filho2 < tamanhoVetor) {
        if (lista[filho1] < lista[filho2]) {
          filho1 = filho2;
        }
      }
      if (lista[filho1] > lista[posicao]) {
        int aux = lista[filho1];
        lista[filho1] = lista[posicao];
        lista[posicao] = aux;

        ordenarArvore(lista, filho1, tamanhoVetor);
      }
    }
  }
}