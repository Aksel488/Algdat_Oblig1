////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static void main(String[] args) {

        String s = "";
        String t = "AB";

        System.out.println(flett(s,t));



        //Teste tid

        /*System.out.println();

        char[] x = new char[100_000];
        long tid = System.currentTimeMillis();
        rotasjon(x, 9999);
        tid = System.currentTimeMillis() - tid;

        System.out.println(tid);
        */
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
        if (a.length == 0 || a.length == 1){
            return;}
        int venstre=0;
        int høyre=a.length-1;


        while(true) {
            while (a[venstre] % 2 != 0 && høyre > venstre) {
                venstre++;
            }
            while (a[høyre] % 2 == 0 && venstre < høyre) {
                høyre--;
            }
            if (høyre > venstre) {
                bytt(a, venstre, høyre);
            }
            if (venstre == høyre) {
                quicksort(a, 0, høyre-1);
                if (venstre == a.length - 1) {
                    quicksort(a, venstre - 1, a.length-1);
                } else {
                    quicksort(a, venstre, a.length-1);
                }
                break;
            }
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

        int lengde = a.length;
        if (lengde < 2) {
            return;
        }

        if ((k %= lengde) < 0) {
            k += lengde;
        }

        int gcd = GCD(lengde, k);

        for (int i = 0; i < gcd; i++) {
            char temp = a[i];

            for (int l = i - k, j = i; l != i; l -= k) {
                if (l < 0) {
                    l += lengde;
                }

                a[j] = a[l];
                j = l;
            }
            a[i + k] = temp;
        }
    }

    private static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a % b);
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String ut = "";

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            ut += s.charAt(i);
            i++;
            ut += t.charAt(j);
            j++;
        }

        if (i < s.length()) {
            for (int l = i; l < s.length(); l++) {
                ut += s.charAt(l);
            }
        }

        if (j < t.length()) {
            for (int k = j; k < t.length(); k++) {
                ut += t.charAt(k);
            }
        }

        return ut;
    }

    /// 7b)
    public static String flett(String... s) {
        
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
       // throw new NotImplementedException();
        int[] index = new int[a.length];
        int[] b = a.clone();
        quicksort(b,0,b.length-1);
        for(int i = 0; a.length>i; i++){
            for(int j = 0; a.length>j; j++){
                if(b[i]==a[j] && ikkeIArray(index, j)){
                    index[i]=j;
                }
            }
        }
        return index;
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
       // throw new NotImplementedException();
        if(a.length<3){throw new NoSuchElementException("tabellen er mindre enn 3 verdier");}
        int [] b= Arrays.copyOf(a,3);
        b=indekssortering(b);
        int minst = b[0]; // minst index
        int nest = b[1]; //nest minst index
        int tredje = b[2]; //tredje minst index

        int minstV = a[minst];
        int nestminstV = a[nest];
        int tredjeminstV = a[tredje];

        for(int i = 3 ; i<a.length; i++){
            if(a[i]<tredjeminstV){
                if(a[i]<nestminstV){
                    if(a[i]<minstV){
                        tredje=nest;
                        tredjeminstV=nestminstV;

                        nest=minst;
                        nestminstV=minstV;

                        minst=i;
                        minstV=a[minst];
                    }
                    else {
                        tredje=nest;
                        tredjeminstV=nestminstV;

                        nest=i;
                        nestminstV=a[nest];
                    }
                }
                else {
                    tredje=i;
                    tredjeminstV=a[tredje];
                }
            }
        }
        return new int[] { minst, nest, tredje};
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();

    }

    public static boolean inneholdt(String a, String b) {
        //throw new NotImplementedException();
        if(a.length()== 0 || a.equals(b)){
            return true;
        }
        char[] bokstavNr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Æ','Ø','Å'};

        long [] aCount = new long [29];
        long [] bCount = new long [29];

        for (int i=0; a.length()>i; i++){
            for (int j=0; bokstavNr.length>j; j++){
                if(a.charAt(i)== bokstavNr[j]){
                    aCount[j]= aCount[j]+1;
                }
            }
        }
        for(int i=0 ; i<b.length(); i++){
            for (int j = 0 ; j<bokstavNr.length;j++) {
                if (b.charAt(i)==bokstavNr[j]){
                    bCount[j]= bCount[j] +1;
                }
            }
        }
        for (int i=0; aCount.length>i; i++){
            if (aCount[i]>bCount[i]){return false;}
        }
        return true;
    }

    ///hjelpemetoder fra forelesning///





    public static void bytt(int[] a, int fra, int til) {
        int temp = a[fra];
        a[fra] = a[til];
        a[til] = temp;
    }

    private static void quicksort(int[] a, int venstre, int høyre) {
        if (venstre >= høyre) return;  // a[v:h] er tomt eller har maks ett element
        int k = Parter2(a, venstre, høyre, (venstre + høyre) / 2);  // bruker midtverdien
        quicksort(a, venstre, k - 1);     // sorterer intervallet a[v:k-1]
        quicksort(a, k + 1, høyre);     // sorterer intervallet a[k+1:h]
    }



    private static int Parter2(int[] a, int start, int slutt, int indeks) {
        bytt(a, indeks, slutt);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter(a, start, slutt - 1, a[slutt]);  // partisjonerer a[start:slutt − 1]
        bytt(a, pos, slutt);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien .Dden er nå sortert
    }


    private static int parter(int[] a, int venstre, int høyre, int skilleverdi) {
        while (true)                                  // stopper når venstre > høyre
        {
            while (venstre <= høyre && a[venstre] < skilleverdi) venstre++;   // høyre er stoppverdi for venstre
            while (venstre <= høyre && a[høyre] >= skilleverdi) høyre--;  // venstre er stoppverdi for høyre

            if (venstre < høyre) {
                bytt(a, venstre, høyre);                 // bytter om a[venstre] og a[høyre]
            } else return venstre;
        }
    }
    public static boolean ikkeIArray(int[] a, int j){
        for (int i : a ) {
            if (j == i)
                return false;
        }
        return true;
    }

    
}  // Oblig1
