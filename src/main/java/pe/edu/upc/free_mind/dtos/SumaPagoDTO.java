package pe.edu.upc.free_mind.dtos;

public class SumaPagoDTO {
    private String nombre;
    private Double amountByUsuario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getAmountByUsuario() {
        return amountByUsuario;
    }

    public void setAmountByUsuario(Double amountByUsuario) {
        this.amountByUsuario = amountByUsuario;
    }
}