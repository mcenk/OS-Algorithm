package odevOS;

import java.util.Scanner;


public class ProcessAlgorithm {
    public static void main(String[] args) {
    	System.out.println(" ");
    	System.out.println("Lütfen algoritma türünü seçiniz: ");
    	System.out.println(" ");
    	System.out.println("1-First Come First Served(FCFS)");
    	System.out.println("2-Shortest Job First/np");
    	System.out.println("3-Shortest Job First/p");
    	
    	Scanner secimSc= new Scanner(System.in);
    	int secim= secimSc.nextInt();
    	
    	if (secim ==1)   		
    		FCFS();
    	
    	else if (secim==2)     		
    		SJFnp();
   	
    	else SJFp();
			
	}
    public static void FCFS() {
    	
    	
		System.out.println("***First Come First Served(FCFS) Algoritmasý***");
		System.out.println(" ");
        System.out.println("Toplam process sayýsýný giriniz");
        Scanner in = new Scanner(System.in);
        int processSayisi = in.nextInt();

        int pID[] = new int[processSayisi];
        int patlamaZamani[] = new int[processSayisi];
        int varisZamani[] = new int[processSayisi];
        int tamamlanmaZamani[] = new int[processSayisi];
        int turnAroundZamani[] = new int[processSayisi];
        int beklemeZamani[] = new int[processSayisi];
        float ortalamaZaman=0;
        int i;

        
        for( i = 0; i < processSayisi; i++) {
        	
            System.out.println( (i+1) +" numarali prosesin " +  " varýþ zamanýný giriniz: ");
            varisZamani[i] = in.nextInt();
            System.out.println((i+1) +" numarali prosesin " +  " patlama zamanýný giriniz: ");
            patlamaZamani[i] = in.nextInt();
            pID[i] = i+1;
        }
        int siralamaTemp;
        for ( i = 0; i < processSayisi; i++) {
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
        for( i = 1; i < processSayisi; i++) {
        	tamamlanmaZamani[i] = tamamlanmaZamani[i - 1] + patlamaZamani[i];
        }
        for( i = 0; i < processSayisi; i++) {
        	turnAroundZamani[i] = tamamlanmaZamani[i] - varisZamani[i];
            beklemeZamani[i] = turnAroundZamani[i] - patlamaZamani[i];
        }
        
        for ( i= 0; i<processSayisi;i++) {
        	
        	 ortalamaZaman += beklemeZamani[i];
     
        }
        	
        	
        System.out.println("Proseslerin Sýralamasý: ");
        for( i = 0; i < processSayisi; i++) {
            System.out.print("P" + pID[i] +" => ");
        }
        
        System.out.println("\n");
        
        System.out.println("Prosesler\tVarýþ Zamaný\tPatlama Zamaný\tTamamlanma Zamaný\tÇýkýs Zamaný\tBekleme Zamaný");
        for( i = 0; i < processSayisi; i++) {
            System.out.println("\t"+ pID[i]+"\t\t" + varisZamani[i] + "\t\t" + patlamaZamani[i]+ "\t\t" + tamamlanmaZamani[i]+ "\t\t\t" + turnAroundZamani[i]+ "\t\t" + beklemeZamani[i]);
        }
        
        System.out.println("\n");
        System.out.println("Ortalama Bekleme Süresi:" + ortalamaZaman/processSayisi );

		
	
    	
    }
    
    public static void SJFnp() {
    		
        System.out.println("****Shortest Job First/np Algoritmasý****");
		System.out.println(" ");
        System.out.println("Toplam process sayýsýný giriniz");
        Scanner in = new Scanner(System.in);
        int processSayisi = in.nextInt();
        
	
        int pID[] = new int[processSayisi];
        int patlamaZamani[] = new int[processSayisi];
        int varisZamani[] = new int[processSayisi];
        int tamamlanmaZamani[] = new int[processSayisi];
        int turnAroundZamani[] = new int[processSayisi];
        int beklemeZamani[] = new int[processSayisi];   
        int kontrol[] = new int[processSayisi];

        int baslamaZamani=0;
        int toplam=0;
        int i;
        float ortalamaZaman=0;

        for( i = 0; i < processSayisi; i++) {
        	
            System.out.println( (i+1) +" numarali prosesin " +  " varýþ zamanýný giriniz: ");
            varisZamani[i] = in.nextInt();
            System.out.println((i+1) +" numarali prosesin " +  " patlama zamanýný giriniz: ");
            patlamaZamani[i] = in.nextInt();
            pID[i] = i+1;
            kontrol[i] = 0;
        }


        while(true)
        {
            int x=0, min = processSayisi*100;
            if (toplam == processSayisi) {
            	
            	System.out.println("Geçersiz bir deðer girdiniz!");
            	System.out.println("\n");
                break;
            }

            for ( i=0; i<processSayisi; i++){

                if ((varisZamani[i] <= baslamaZamani) && (kontrol[i] == 0) && (patlamaZamani[i]<min)){
                    min=patlamaZamani[i];
                    x=i;
                }
            }
            if (x==processSayisi)
            	baslamaZamani++;
            else{
            	tamamlanmaZamani[x]=baslamaZamani+patlamaZamani[x];
            	baslamaZamani+=patlamaZamani[x];
                turnAroundZamani[x]=tamamlanmaZamani[x]-varisZamani[x];
                beklemeZamani[x]=turnAroundZamani[x]-patlamaZamani[x];
                kontrol[x]=1;
                pID[toplam] = x + 1;
                toplam++;
            }
        }
        
        System.out.println("Proseslerin Sýralamasý: ");
        
        for( i = 0; i < processSayisi; i++) {
            System.out.print("P" + pID[i] +" => ");}
        
        System.out.println("\n");
        
        System.out.println("Prosesler\tVarýþ Zamaný\tPatlama Zamaný\tTamamlanma Zamaný\tTurnAround Zamaný\tBekleme Zamaný");
        
        for( i=0;i<processSayisi;i++) {
        	ortalamaZaman+= beklemeZamani[i];
    
            System.out.println("\t"+pID[i]+"\t\t"+varisZamani[i]+"\t\t"+patlamaZamani[i]+"\t\t"+tamamlanmaZamani[i]+"\t\t\t"+turnAroundZamani[i]+"\t\t"+beklemeZamani[i]);
        }
     
        System.out.println("\n");
        System.out.println("Ortalama Bekleme Süresi:"+ (float)(ortalamaZaman/processSayisi));}
	
    public static void SJFp() {

		System.out.println("****Shortest Job First/p Algoritmasý****");
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Toplam process sayýsýný giriniz");
		int processSayisi= sc.nextInt();
		int pID[] = new int[processSayisi]; // it takes pid of process
		int varisZamani[] = new int[processSayisi]; // at means arrival time
		int patlamaZamani[] = new int[processSayisi]; // bt means burst time
		int tamamlanmaZamani[] = new int[processSayisi]; // ct means complete time
		int turnAroundZamani[] = new int[processSayisi];// ta means turn around time
		int beklemeZamani[] = new int[processSayisi];  // wt means waiting time
		int processArr[] = new int[processSayisi];  // f means it is flag it checks process is completed or not
		int patlamaArr[]= new int[processSayisi];   // it is also stores brust time
		int i, baslamaZamani=0, toplam=0;
		float ortalamaZaman=0;
		 
		    for (i=0;i<processSayisi;i++)
		    {
		
		     System.out.println( (i+1) +" numarali prosesin " +  " varýþ zamanýný giriniz: ");
             varisZamani[i] = sc.nextInt();
             System.out.println((i+1) +" numarali prosesin " +  " patlama zamanýný giriniz: ");
             patlamaZamani[i] = sc.nextInt();
             pID[i] = i+1;   
             patlamaArr[i]= patlamaZamani[i];
             processArr[i]= 0;
		    }
		    
		    while(true){
		     int min=processSayisi*100, x=processSayisi;
		     if (toplam==processSayisi)
		     break;
		    
		     for ( i=0;i<processSayisi;i++){
			     if ((varisZamani[i]<=baslamaZamani) && (processArr[i]==0) && (patlamaZamani[i]<min)){
			     min=patlamaZamani[i];
			     x=i;
			     }
		     }
		    
		     if (x==processSayisi)
		    	 baslamaZamani++;
		     
		     else{
		     patlamaZamani[x]--;
		     baslamaZamani++;
		     
			     if (patlamaZamani[x]==0){
			     tamamlanmaZamani[x]= baslamaZamani;
			     processArr[x]=1;
			     toplam++;}
		     }
		    }
		    
		    for( i=0;i<processSayisi;i++){
		    	turnAroundZamani[i] = tamamlanmaZamani[i] - varisZamani[i];
		    	beklemeZamani[i] = turnAroundZamani[i] - processArr [i];

		    }
		    
		    System.out.println("Proseslerin Sýralamasý: ");
	        
            for( i = 0; i < processSayisi; i++) {
                System.out.print("P" + pID[i] +" => ");}
            
            System.out.println("\n");
	        
	        System.out.println("Prosesler\tVarýþ Zamaný\tPatlama Zamaný\tTamamlanma Zamaný\tTurnAround Zamaný\tBekleme Zamaný");
	        
	        for( i=0;i<processSayisi;i++) {
	        	ortalamaZaman+= beklemeZamani[i];
	    
	            System.out.println("\t"+pID[i]+"\t\t"+varisZamani[i]+"\t\t"+patlamaZamani[i]+"\t\t"+tamamlanmaZamani[i]+"\t\t\t"+turnAroundZamani[i]+"\t\t"+beklemeZamani[i]);
	        }
	     
	        System.out.println("\n");
            System.out.println("Ortalama Bekleme Süresi:"+ (float)(ortalamaZaman/processSayisi));
		
    }
}