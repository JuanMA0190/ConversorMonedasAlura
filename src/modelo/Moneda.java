package modelo;


import java.util.Map;

public class Moneda {
    private final String baseCode;
    private final Map<String, Double> conversionRates;
    private Double valorACambiar;
    private String tipoMonedaACambiar;

    public Moneda(MonedaDTO monedaDTO) {
        this.baseCode = monedaDTO.baseCode();
        this.conversionRates = monedaDTO.conversionRates();
    }

    public void setValorACambiar(Double valorACambiar) {
        this.valorACambiar = valorACambiar;
    }

    public void setTipoMonedaACambiar(String tipoMonedaACambiar){
        this.tipoMonedaACambiar = tipoMonedaACambiar;
    }

    public Double filtrarMoneda(String monedaACambiar){
        Double valorActual = conversionRates.get(monedaACambiar);
        return this.valorACambiar * valorActual;
    }

    @Override
    public String toString() {
        return String.format("El valor = %s [%s] corresponde al valor final de => %.2f [%s]",
                String.valueOf(this.valorACambiar).replace('.', ','),
                this.baseCode,
                filtrarMoneda(this.tipoMonedaACambiar),
                this.tipoMonedaACambiar);
    }
}
