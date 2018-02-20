import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Esta nos permitirá guardar objetos de tipo moto dentro de un objeto concesionario. 
 *
 * @SergioAcebes97 (Sergio Acebes Ponga)
 * @version 24/01/2018
 */
public class Concesionario
{

    private ArrayList<Moto> listaDeMotos; 
    private int numeroBastidor;

    /**
     * Constructor de la clase Concesionario
     */
    public Concesionario(String nombreArchivo){

        listaDeMotos = new ArrayList<Moto>();
        numeroBastidor = 1;

        try {
            File archivo = new File(nombreArchivo);
            Scanner sc = new Scanner(archivo);

            while (sc.hasNextLine()) {
                String [] wordArray = sc.nextLine().split(" # ");
                String marca = wordArray[0];
                String modelo = wordArray[1];
                int dia = Integer.parseInt(wordArray[2]);
                int mes = Integer.parseInt(wordArray[3]);
                int ano = Integer.parseInt(wordArray[4]);
                int cilindrada = Integer.parseInt(wordArray[5]);

                addMoto(marca,modelo,dia,mes,ano,cilindrada);

            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace(); 
        }        
    }

    /**
     * Añade una moto.
     */
    public void addMoto(String marca,String modelo,int dia,int mes, int ano,int cilindrada)
    {
        Moto nuevaMoto = new Moto(marca,modelo,ano,mes,dia,cilindrada,numeroBastidor);
        listaDeMotos.add(nuevaMoto);
        numeroBastidor++;
    }

    /**
     * Mostrar motos ordenadas por bastidor.
     */
    public void mostrarMotosPorBastidor()
    {
        int contador = 0;
        while (contador < listaDeMotos.size()){
            System.out.println(listaDeMotos.get(contador).getDatosMoto());
            contador++;
        }
    }

    /**
     * Imprime las motos odenadas en funcion de su cilindrada.
     */
    public void mostrarPorCilindrada(){
        if(listaDeMotos.size()>0) {
            ArrayList<Moto> motos = new ArrayList<>();
            motos.addAll(listaDeMotos);
            Moto motoMayorCilindrada = motos.get(0);
            for(int i = 0 ;i<listaDeMotos.size();i++){
                int posAlta = 0;
                int posicion = 0;
                for(int cont=0;cont < motos.size();cont++){
                    if(motos.get(cont).getCilindrada() >= posAlta){
                        motoMayorCilindrada = motos.get(cont);
                        posAlta = listaDeMotos.get(cont).getCilindrada();
                        posicion = cont;
                    }
                }
                System.out.println(motoMayorCilindrada.getDatosMoto());
                motos.remove(posicion);
            }
        }
    }

    /**
     * Imprime las motos odenadas en funcion de su cilindrada.
     */
    public void mostrarPorFecha(){
        if(listaDeMotos.size()>0) {
            ArrayList<Moto> motos = new ArrayList<>();
            motos.addAll(listaDeMotos);
            Moto motoMasAntigua = motos.get(0);
            for(int i = 0 ;i<listaDeMotos.size();i++){
                LocalDate fecha = LocalDate.of(9999,12,31) ;
                int posicion = 0;
                for(int cont=0;cont < motos.size();cont++){
                    if(motos.get(cont).getFechaProduccion().isBefore(fecha)){
                        motoMasAntigua = motos.get(cont);
                        fecha = listaDeMotos.get(cont).getFechaProduccion();
                        posicion = cont;
                    }
                }
                System.out.println(motoMasAntigua.getDatosMoto());
                motos.remove(posicion);
            }
        }
    }

    /**
     * Imprime las motos odenadas en funcion de su fecha.
     */
    public void mostrarPorcilindrada2(){
        int contador = 0;
        if(listaDeMotos.size()>0) {
            ArrayList<Moto> motos = new ArrayList<>();
            motos.addAll(listaDeMotos);
            Moto motoMayorCilindrada = motos.get(0);
            for(int i = 0 ;i<listaDeMotos.size();i++){
                int posAlta = 0;
                int posicion = 0;
                for(int cont=0;cont < motos.size();cont++){
                    if(motos.get(cont).getCilindrada() >= posAlta){
                        motoMayorCilindrada = motos.get(cont);
                        posAlta = listaDeMotos.get(cont).getCilindrada();
                        posicion = cont;
                        
                    }
                }
                if(motos.get(posicion).getCilindrada() != contador){
                    System.out.println("Cilindrada : " + (motos.get(posicion).getCilindrada()));
                    contador = motos.get(posicion).getCilindrada();
                }
                System.out.println(motoMayorCilindrada.getDatosMoto());
                motos.remove(posicion);
            }
        }
    }

    /**
     * Permite modificar la cilindrada de una moto.
     */
    public void modificarCilindrada(int idBastidor, int nuevaCilindrada){
        if(listaDeMotos.size()>= idBastidor && idBastidor >= 0){
            Moto cambioDeCilindrada = listaDeMotos.get(idBastidor - 1);
            cambioDeCilindrada.setCilindrada(nuevaCilindrada);
        }
    }

    /**
     * Permite borrar las motos que sean mas viejas que una fecha introducido con un iterador.
     */
    public void eliminarMotosAntiguas(int dia,int mes, int ano){
        Iterator<Moto> borrar = listaDeMotos.iterator();
        LocalDate antiguas = LocalDate.of(ano,mes,dia);
        while (borrar.hasNext()){
            Moto vieja = borrar.next();
            LocalDate fecha = vieja.getFechaProduccion();
            if (fecha.isBefore(antiguas)){
                borrar.remove();
            }
        }
    }

}
