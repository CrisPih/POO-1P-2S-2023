/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.juego;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marcito
 */
public class Juego {
    private ArrayList<Ficha> lineaJuego;
    private ArrayList<Jugador> jugadores;

    public Juego() {
        this.lineaJuego = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }
    
    public void agregarJugador(String nombre){
        Jugador jugadorcito= new Jugador(nombre, Utilitaria.crearManoJugador());
        jugadores.add(jugadorcito);
        
    }
    
    public int obtenerValorInicio(){
        return lineaJuego.get(0).getLado1();
    }
    
    public int obtenerValorFin(){
        return lineaJuego.get(lineaJuego.size()-1).getLado2();
    }
    
    public void mostrarLinea(){
        for(int i=0; i<this.lineaJuego.size(); i++){
            Ficha f= this.lineaJuego.get(i);
            if(i!=this.lineaJuego.size()-1){
                System.out.println(f.toString()+"-");
                
            }
            else
                System.out.println(f.toString());
        }
    }
    
    public boolean agregarFichaLinea(Ficha f, Jugador j){
        if(f instanceof FichaComodin){
            Scanner sc= new Scanner(System.in);
            FichaComodin efecita= (FichaComodin)f;
            if(lineaJuego.isEmpty()){
                lineaJuego.add(efecita);
                System.out.println("Ingrese un lado 1: ");
                int ladito1= sc.nextInt();
                while(ladito1 <1 && ladito1>6){
                    System.out.println("Escribe un valor válido del lado 1");
                    ladito1= sc.nextInt();
                }
                efecita.setLado1(ladito1);
                System.out.println("Ingrese un lado 2: ");
                int ladito2= sc.nextInt();
                while(ladito2 <1 && ladito2>6){
                    System.out.println("Escribe un valor válido del lado 2");
                    ladito2= sc.nextInt();
                }                
                
                efecita.setLado2(ladito2);
            }    
            else{
                
                System.out.println("¿Donde quieres posicionar tu ficha? ¿Inicio o Fin?: ");
                String palabrita= sc.next();                
                while(!palabrita.equals("Inicio") && !palabrita.equals("Fin"))
                    System.out.println("Palabra no válida, ingrese Inicio o Fin: ");
                     palabrita=sc.next();
                if(palabrita.equals("Inicio")){
                    System.out.println("Escribe el valor del lado 1");
                    int laditito1= sc.nextInt();
                    while(laditito1 <1 && laditito1>6){
                        System.out.println("Escribe un valor válido del lado 1");
                        laditito1= sc.nextInt();
                    }
                    efecita.setLado1(laditito1);
                    lineaJuego.add(0,f);
                
                }
                else if(palabrita.equals("Final")){
                    System.out.println("Esribe el valor del lado2");
                    int laditito2= sc.nextInt();
                    while(laditito2 <1 && laditito2>6){
                        System.out.println("Escribe un valor válido del lado 1");
                        laditito2= sc.nextInt();
                    }                    
                    efecita.setLado2(laditito2);
                    lineaJuego.add(lineaJuego.size()-1,f);                
                  
                }     
                
            }  
        }    
        
        else{
                
               
            if(lineaJuego.isEmpty()){
                lineaJuego.add(f);
            }
            
            else{
                if(f.getLado2()==this.obtenerValorInicio()){
                    lineaJuego.add(0, f);
                    j.removerFicha(f);
                    return true;
                    }
                    
                else if(f.getLado1()==this.obtenerValorFin()){
                    lineaJuego.add(lineaJuego.size()-1, f);
                    j.removerFicha(f);
                    return true;

                    }
                
                return false;    
                   
                }
                
        }
        
        return false;
    }
       
    public static void main(String[] args) {
        Juego juego= new Juego();
        Scanner sc= new Scanner (System.in);
        System.out.println("Elija el modo de juego: ");
        System.out.println("1. Jugador vs Jugador ");
        System.out.println("Jugador vs Maquina");
        int seleccion = scnextInt();
        if(seleccion == 1){
            System.out,println("Ingrese el nombre del jugador 1: ");
            String jugador1 = sc.next();
            System.out.println("Ingrese el nombre del jugador 2");
            String jugador2= sc.next();
            juego.agregarjugador(jugador1);
            juego.agregarjugador(jugador2);
            System.ou.println("Iniciemos con el juego!");

            boolean manoJ1 = juego.manoValida(juego.getJugadores().get(0));     
            boolean manoJ2 = juego.manoValida(juego.getJugadores().get(1));

            boolean cantmanoJ1 = !juego.getJugadores().get(0).getMano().isEmpty();
            boolean cantmanoJ2 = !juego.getJugadores().get(1).getMano().isEmpty();
            
            do {
                System.out.println("Jugador: "+" "+jugador1+" "+"Mano :");
                juego.getJugadores().get(0).imprimirMano();
                juego.mostrarLínea();
                manoJugador1= juego.manoValida


                
            }
           
    }
}
