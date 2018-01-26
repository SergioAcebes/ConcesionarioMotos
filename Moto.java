import java.time.LocalDate;
/**
 * Crea un objeto que almacena las motos que hay en el concesionario y sus caracteristicas
 * (marca,modelo,fecha de producción  y cilindrada).
 *
 * @SergioAcebes97 (Sergio Acebes Ponga)
 * @version 24/01/2018
 */
public class Moto
{
    
    private String marca;
    private String modelo;
    private LocalDate fechaProduccion;
    private int cilindrada;
    private int numeroBastidor;
    
    /**
     * Constructor de la clase Moto.
     */
    public Moto(String marca,String modelo,int dia,int mes, int ano,int cilindrada,int bastidor)
    {
        this.marca = marca;
        this.modelo = modelo;
        fechaProduccion = LocalDate.of(dia,mes,ano);
        this.cilindrada = cilindrada;
        numeroBastidor = bastidor;
    }
    
    /**
     * Devuelve la marca de la moto.
     */
    public String getMarca(){
        return marca;
    }
    
    /**
     * Devuelve el modelo de la moto.
     */
    public String getModelo(){
        return modelo;
    }
    
    /**
     * Devuelve la fecha de produccion de la moto.
     */
    public LocalDate getFechaProduccion(){
        return fechaProduccion;
    }
    
    /**
     * Devuelve la cilindrada de la moto.
     */
    public int getCilindrada(){
        return cilindrada;
    }
    
    /**
     * Devuelve el bastidor de la moto.
     */
    public int getBastidor(){
        return numeroBastidor;
    }
    
    /**
     * Permite modificar la marca de la moto.
     */
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    /**
     * Permite modificar el modelo de la moto.
     */
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    /**
     * Permite modificar la fecha de produccion de la moto.
     */
    public void setFechaProduccion(int dia,int mes, int ano){
        fechaProduccion = LocalDate.of(ano,mes,dia);
    }
    
    /**
     * Permite modificar la cilindrada de la moto.
     */
    public void setCilindrada(int cilindrada){
        this.cilindrada = cilindrada;
    }
    
    /**
     * Devuelve toda la informacion de la moto en formato String.
     */
    public String getDatosMoto()
    {
        
        String aDevolver = " Bastidor: #" + numeroBastidor + " Marca: " + marca + " Modelo: " + modelo + " Fecha de produccion: " + fechaProduccion + " Cilindrada: " + cilindrada;
        return aDevolver;  
    }
}
