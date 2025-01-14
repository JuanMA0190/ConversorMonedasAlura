import modelo.Moneda;
import modelo.TipoCambio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salida = false;
        String[] tipoMoneda = {"USD", "ARS", "BRL", "COP"};
        TipoCambio tipoCambio = new TipoCambio();

        do {
            mostrarMenu();
            byte eleccion = s.nextByte();
            Moneda moneda = null;
            switch (eleccion) {
                case 0 -> {
                    moneda = transaccionCambio(0, 1, tipoCambio, tipoMoneda);
                    System.out.println(moneda);
                }
                case 1 -> {
                    moneda = transaccionCambio(1, 0, tipoCambio, tipoMoneda);
                    System.out.println(moneda);
                }
                case 2 -> {
                    moneda = transaccionCambio(0, 2, tipoCambio, tipoMoneda);
                    System.out.println(moneda);
                }
                case 3 -> {
                    moneda = transaccionCambio(2, 0, tipoCambio, tipoMoneda);
                    System.out.println(moneda);
                }
                case 4 -> {
                    moneda = transaccionCambio(0, 3, tipoCambio, tipoMoneda);
                    System.out.println(moneda);
                }
                case 5 -> {
                    moneda = transaccionCambio(3, 0, tipoCambio, tipoMoneda);
                    System.out.println(moneda);
                }
                case 6 -> salida = true;
                default -> System.out.println("Elección incorrecta, vuelva a intentarlo!");
            }

            if (moneda == null) {
                System.out.println("Algo fallo, contacte con el Administrador!");
                break;
            }

        } while (!salida);
    }

    public static void mostrarMenu(){
        System.out.println("""
                *******************************************************************
                \t\tSea bienvenido/a al Conversor de Moneda:
                
                *******************************************************************
                
                0) Dolar => Peso argentino
                1) Peso argentino => Dolar
                2) Dolar => Real brasileño
                3) Real brasileño => Dolar
                4) Dolar => Peso colombiano
                5) Peso colombiano => Dolar
                6) Salir
                
                *******************************************************************
                Elija una opción:
                """);
    }

    public static Moneda transaccionCambio(int eleccion, int monedaACambiar, TipoCambio tipoCambio, String[] tipoMoneda){
        Moneda moneda = tipoCambio.buscaTipoCambio(tipoMoneda[eleccion]);
        moneda.setTipoMonedaACambiar(tipoMoneda[monedaACambiar]);
        System.out.println("Ingrese el valor que desea cambiar:");
        moneda.setValorACambiar(s.nextDouble());

        return moneda;
    }
}
