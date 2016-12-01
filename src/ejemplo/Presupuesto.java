package ejemplo;

/**
 * Created by Alan on 13/10/2016.
 */
public class Presupuesto {
    private Integer num;
    private String concepto;
    private Double precioNeto;
    private String estado;

    public Presupuesto(){}

    public Presupuesto(Integer num, String concepto, Double precioNeto) {
        this.num = num;
        this.concepto = concepto;
        this.precioNeto = precioNeto;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(Double precioNeto) {
        this.precioNeto = precioNeto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPresupuestoDescuento(Integer precio_neto){

        return precio_neto;
    }
    public Integer getPrecioIva(Integer getPresupuestoDescuento){

        Integer iva = getPresupuestoDescuento / 21;


        return getPresupuestoDescuento + 21;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "num=" + num +
                ", concepto='" + concepto + '\'' +
                ", precioNeto=" + precioNeto +
                ", estado='" + estado + '\'' +
                '}';
    }
}
