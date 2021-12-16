package CapaPresentacion;
import java.util.Scanner;

public class Aplicacion {

     public static void main(String[] args) {
        int opcion,cJugadas=0,cDoble=0,cTriple=0;
        double mJugada,mActual,mInicial;
        Scanner objEntrada = new Scanner(System.in);
        
        System.out.println("BIENVENIDO");
        System.out.println("==========");
        do{
            System.out.print("Ingrese monto inicial : ");
            mInicial = objEntrada.nextDouble();
            if(mInicial <= 0){
                System.out.println("\t* El monto debe ser mayor a S/.0");
            }
        }while(!(mInicial>=0));
        mActual = mInicial;
          do{
            opcion = menu();
            switch (opcion)
            {
                case 1: if(mActual > 0){
                            int dado[]=new int[4];
                            cJugadas++;
                            do{
                                System.out.print("\nIngrese monto de la jugada[1-"+mActual+"] : ");
                                mJugada=objEntrada.nextDouble();
                            }while(!(mJugada > 0 && mJugada <= mActual));
                            mActual-=mJugada;
                            for(int i=0;i<4;i++){
                                dado[i] = (int)Math.floor(6*Math.random())+1;
                                System.out.println("Dado nro ["+(i+1)+"]: "+dado[i]);
                            }
                            wait(2000);
                            System.out.println("\nRepeticiones : "+repeticiones(dado));
                            switch(repeticiones(dado)){
                                case 2:
                                case 3:
                                        System.out.println("Usted recupero lo apostado");
                                        mActual+=mJugada;
                                        System.out.println("Monto actual : S/."+mActual);       
                                        break;
                                case 4: if(dado[0]==6){
                                            cTriple++;
                                            System.out.println("Felicitaciones");
                                            System.out.println("Triplica lo apostado");
                                            mActual+=(3*mJugada);
                                            System.out.println("Monto actual: S/."+mActual);
                                        }
                                        else{
                                            cDoble++;
                                            System.out.println("Felicitaciones");
                                            System.out.println("Duplica lo apostado");
                                            mActual+=(2*mJugada);
                                            System.out.println("Monto actual: S/."+mActual);
                                        }
                                        break;
                                case 1: System.out.println("Mala suerte, piertes lo apostado :(");
                                        System.out.println("Monto actual: S/."+mActual);
                                        break;
                            }
                            wait(2000);
                        }else{
                            System.out.println("\nYa no cuenta con dinero");
                        }
                        break;
                case 2: 
                        if(cJugadas==0){
                            System.out.println("\nNo se jugo ni una vez");
                        }else{
                            System.out.println("\nMonto inicial: S/."+mInicial);
                            System.out.println("Cantidad de juegos: "+cJugadas);
                            System.out.println("Cantidad de dobles: "+cDoble);
                            System.out.println("Cantidad de triples: "+cTriple);
                            System.out.println("Monto final: S/."+mActual);
                        }
                        break;
            }
        }while (opcion!=2);
    }
    
    private static int menu ()
    {
        Scanner objEntrada = new Scanner(System.in);
        int opt;
        System .out.println("\nMENU PRINCIPAL");
        System .out.println("[1] Jugar");
        System .out.println("[2] Finalizar sesion");
        do{
            System.out.print("Ingrese opcion: ");
            opt = objEntrada.nextInt();
        }while(opt<1|| opt>2);
        return opt;
    }
    
    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    public static int repeticiones(int dado[]){
        int repet=0;
        int repetAux;
        for(int i=0;i<3;i++){
            repetAux=0;
            for(int j=i+1;j<4;j++){
                if(dado[i]==dado[j]){
                    repetAux++;
                }
            }
            if(repetAux>repet){
                repet=repetAux;
            }
        }
        return (repet+1);
    }
}