import java.util.ArrayList;
import java.time.LocalDate;
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
    public Concesionario(){
        listaDeMotos = new ArrayList<Moto>();
        numeroBastidor = 1;
    }

    /**
     * Añade una moto.
     */
    public void addMoto(String marca,String modelo,int dia,int mes, int ano,int cilindrada)
    {
        Moto nuevaMoto = new Moto(marca,modelo,dia,mes,ano,cilindrada,numeroBastidor);
        listaDeMotos.add(nuevaMoto);
        numeroBastidor++;
    }

    /**
     * Mostrar motos ordenadas por bastidor.
     */
    public void mostrarMotos()
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
    public void mostrarFecha(){
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
    
 
}
