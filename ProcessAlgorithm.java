package odevOS;

import java.util.Scanner;


public class ProcessAlgorithm {
    public static void main(String[] args) {
    	
    	System.out.println("L�tfen algoritma t�r�n� se�iniz");
    	System.out.println(" ");
    	System.out.println("1-First Come First Served(FCFS)");
    	System.out.println("2-Shortest Job First/np");
    	System.out.println("3-Shortest Job First/p");
    	
    	Scanner secimSc= new Scanner(System.in);
    	int secim= secimSc.nextInt();
    	
    	if (secim ==1) {
    		System.out.println("***First Come First Served(FCFS) Algoritmas�***");
    		System.out.println(" ");
            System.out.println("Toplam process say�s�n� giriniz");
            Scanner in = new Scanner(System.in);
            int processSayisi = in.nextInt();

            int pID[] = new int[processSayisi];
            int patlamaZamani[] = new int[processSayisi];
            int varisZamani[] = new int[processSayisi];
            int tamamlanmaZamani[] = new int[processSayisi];
            int cikisZamani[] = new int[processSayisi];
            int beklemeZamani[] = new int[processSayisi];
            double ortalamaZaman=0;

            
            for(int i = 0; i < processSayisi; i++) {
            	
                System.out.println( (i+1) +" numarali prosesin " +  " var�� zaman�n� giriniz: ");
                varisZamani[i] = in.nextInt();
                System.out.println((i+1) +" numarali prosesin " +  " patlama zaman�n� giriniz: ");
                patlamaZamani[i] = in.nextInt();
                pID[i] = i+1;
            }
            int siralamaTemp;
            for (int i = 0; i < processSayisi; i++) {
                for (int j = i+1; j < processSayisi; j++) {

                    if(varisZamani[i] > varisZamani[j]) {
                    	siralamaTemp = varisZamani[i];
                        varisZamani[i] = varisZamani[j];
                        varisZamani[j] = siralamaTemp;

                        siralamaTemp = pID[i];
                        pID[i] = pID[j];
                        pID[j] = siralamaTemp;
                        siralamaTemp = patlamaZamani[i];
                        patlamaZamani[i] = patlamaZamani[j];
                        patlamaZamani[j] = siralamaTemp;
                    }
                }
            }

            System.out.println();
            tamamlanmaZamani[0] = patlamaZamani[0] + varisZamani[0];
            for(int i = 1; i < processSayisi; i++) {
            	tamamlanmaZamani[i] = tamamlanmaZamani[i - 1] + patlamaZamani[i];
            }
            for(int i = 0; i < processSayisi; i++) {
            	cikisZamani[i] = tamamlanmaZamani[i] - varisZamani[i];
                beklemeZamani[i] = cikisZamani[i] - patlamaZamani[i];
            }
            
            for (int i= 0; i<processSayisi;i++) {
            	
            	 ortalamaZaman += beklemeZamani[i];
            	 System.out.println(ortalamaZaman);
            }
            	
            	
            System.out.println("Proseslerin S�ralamas�: ");
            for(int i = 0; i < processSayisi; i++) {
                System.out.print("P" + pID[i] +" => ");
            }
            
            System.out.println("\n");
            
            System.out.println("Prosesler\tVar�� Zaman�\tPatlama Zaman�\tTamamlanma Zaman�\t��k�s Zaman�\tBekleme Zaman�");
            for(int i = 0; i < processSayisi; i++) {
                System.out.println("\t"+ pID[i]+"\t\t" + varisZamani[i] + "\t\t" + patlamaZamani[i]+ "\t\t" + tamamlanmaZamani[i]+ "\t\t\t" + cikisZamani[i]+ "\t\t" + beklemeZamani[i]);
            }
            
            System.out.println("\n");
            System.out.println("Ortalama Bekleme S�resi:" + ortalamaZaman/processSayisi );

    		
    	}
    	else if (secim==2) {
    		System.out.println("***Shortest Job First/np Algoritmas�***");
    
    	}
    	else {
    		System.out.println("***Shortest Job First/p Algoritmas�***");
    		
    	}
    	
    	
    }

}