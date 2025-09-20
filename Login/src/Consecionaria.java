import java.util.List;
import java.util.ArrayList;


public class Consecionaria {
    
    private String nombre;
    List<Auto> autos;

    public Consecionaria(String nombre) {
        this.nombre = nombre;
        this.autos = new ArrayList<>();
    }
    
    public void agregarAuto(Auto auto){
        this.autos.add(auto);
    }
    
    public List<Auto> getAutos(){
                return this.autos;
    }

    @Override
    public String toString() {
        return "Consecionaria{" + "nombre=" + nombre + ", autos=" + autos + '}';
    }

    
    
}
