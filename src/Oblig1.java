////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] a = {9,4,8,1};
        System.out.println(maks(a));
    }


    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {

        if (a.length == 0) {
            throw new NoSuchElementException("Arrayet er tomt");
        }
        /*if (a.length == 1) {
            return a[0];
        }*/

        int minst;

        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                minst = a[i+1];
                a[i+1] = a[i];
                a[i] = minst;
            }
        }

        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        int minst;
        int ombyttinger = 0;

        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                minst = a[i+1];
                a[i+1] = a[i];
                a[i] = minst;

                ombyttinger++;
            }
        }

        return ombyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
       // throw new NotImplementedException();
        for (int i=1; i<a.length; i++){
            if(a[i-1]>a[i]){
                throw new IllegalStateException("det er ikke sortert i stigende rekkefølge");
            }
        }
        int teller=1;
        if(a.length == 0){return 0;}
        for(int i=0; i<a.length-1; i++){
            if(a[i] != a[i+1]){
                teller++;
            }

        }
        return teller;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        //throw new NotImplementedException();
        if (a.length == 0 || a.length == 1)
            return;
        int venstre=0;
        int høyre=a.length-1;
        while(true){
            while (a[høyre] % 2 == 0 && høyre>venstre){
                venstre++;}
            while (a[venstre] % 2 != 0 && høyre>venstre ){
                høyre--;
            }
            if (høyre<venstre){ swap(a, venstre, høyre);}
            if (høyre== venstre){
                quickSort(a, 0, høyre);
                if(venstre == a.length-1){
                    quickSort(a, venstre-1, a.length);
                }
                else { quickSort(a, venstre, a.length);}
            }
            break;


        }


    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

    ///hjelpemetoder fra forelesning///


    public static void swap(int[] values, int from, int to) {
        int tmp = values[from];
        values[from] = values[to];
        values[to] = tmp;
    }

    public static int partition(int[] values, int begin, int end, int pivot_index) {
        swap(values, pivot_index, end-1);

        int l = begin;
        int r = end-2;

        while (l < r) {
            //Move left pointer until first larger
            while (l <= r && values[l] < values[end-1]) {
                ++l;
            }
            while (l <= r && values[r] > values[end-1]) {
                --r;
            }
            if (l < r) {
                swap(values, l, r);
                ++l;
                --r;
            }
        }

        swap(values, l, end-1);

        return l;
    }


    public static void quickSort(int[] values, int left, int right) {

        if (left >= right) {
            return;
        }

        // Velg en pivot
        int pivot_index = (left + right) / 2;
        int pivot = values[pivot_index];

        // Partisjonering
        // Sørg for at alle til høyre blir større enn eller lik pivot
        // og at alle til venstre er mindre enn pivot
        int new_pivot_index = partition(values, left, right, pivot_index);

        // Gjenta for høyre subliste og venstre subliste
        quickSort(values, left, new_pivot_index-1);
        quickSort(values, new_pivot_index+1, right);
    }
}  // Oblig1
