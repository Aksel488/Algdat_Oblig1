////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static void main(String[] args) {

        char[] a = {'A','B','C'};
        char[] b = {'A','B','C'};

        rotasjon(a,4);
        rotasjon(b, -4);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

        System.out.println();

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }

        char[] x = new char[100_000];
        long tid = System.currentTimeMillis();
        rotasjon(x, 500);
        tid = System.currentTimeMillis() - tid;

        System.out.println(tid);

    }


    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {

        if (a.length == 0) {
            throw new NoSuchElementException("Arrayet er tomt");
        }

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

        if(a.length == 0){return 0;}

        for (int i=1; i < a.length; i++){
            if(a[i-1]>a[i]){
                throw new IllegalStateException("det er ikke sortert i stigende rekkefølge");
            }
        }

        int teller=1;

        for(int i=0; i<a.length-1; i++){
            if(a[i] != a[i+1]){
                teller++;
            }

        }
        return teller;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {

        if (a.length == 0) {
            return 0;
        }

        int teller = 0;

        for (int i = 0; i < a.length; i++) {
            int j = 0;

            for (j = 0; j < a.length; j++) {

                if (a[i] == a[j]) {
                    break;
                }
            }
            if (i == j) {
                teller++;
            }
        }

        return teller;
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

        if (a.length == 0) {
            return;
        }

        char temp = a[a.length-1];

        for ( int i = a.length-2; i > -1; i--) {
            a[i+1] = a[i];
        }

        a[0] = temp;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {

        if (a.length == 0 || k == 0) {
            return;
        }

        if (k > 0) {

            for (int i = 0; i < k; i++) {

                char temp = a[a.length-1];

                for ( int j = a.length-2; j > -1; j--) {
                    a[j+1] = a[j];
                }

                a[0] = temp;
            }
        }

        if (k < 0) {

            for (int i = 0; i > k; k++) {

                char temp = a[0];

                for (int j = 1; j < a.length; j++) {
                    a[j-1] = a[j];
                }

                a[a.length-1] = temp;
            }
        }
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
