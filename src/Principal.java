import modelo.Moneda;
import modelo.TipoCambio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private final static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salida = false;
        String[] tipoMoneda = {"USD", "ARS", "BRL", "COP"};
        TipoCambio tipoCambio = new TipoCambio();
        do {
            try {
                mostrarMenu();
                byte eleccion = s.nextByte();
                Moneda moneda;
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
                    case 6 ->{
                        System.out.println("Programa finalizado. Gracias por utilizar nuestros servicios!");
                        salida = true;
                    }
                    default -> System.out.println("Elección incorrecta, vuelva a intentarlo!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Intento Ingresar un dígito en un campo que es solo númerico. " +
                        "Elija del 0 al 6. Vuelva a intentarlo!");
                s.nextLine();
            } catch (NullPointerException e){
                System.out.println("Algo fallo, contacte con el Administrador!");
                salida = true;
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

        boolean entradaValida = false;
        double valor = 0.0;

        while (!entradaValida) {
            try {
                System.out.println("Ingrese el valor que desea cambiar:");
                valor = s.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido (ej: 100.50).");
                s.nextLine(); // Limpia el buffer del Scanner
            }
        }

        moneda.setValorACambiar(valor);
        return moneda;
    }
}
