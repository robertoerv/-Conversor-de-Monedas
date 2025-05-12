import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion=0;
        double cantidadFinal=0;
        while (opcion !=7){
            System.out.println("**********************************************\n" +
                    "Bienvenido/a al convertidor de monedas.\n\n" +
                    "-1 Dolar Americano => peso Argentino.\n" +
                    "-2 peso Argentino a Dolar Americano.\n" +
                    "-3 Dolar Americano => Real brazileño.\n" +
                    "-4 Real Brazileño  => Dolar americano.\n" +
                    "-5 Dolar Americano => Peso Colombiano.\n" +
                    "-6 Dolar Americano => Peso Mexicano.\n" +
                    "-7 Salir \n" +
                    "Elija una opcion Valida:\n" +
                    "**********************************************************");
            opcion =teclado.nextInt();
            // System.out.println("igresa el valor que deseas converit.");

            if( opcion <= 6 && opcion > 0 ){
                System.out.println("igresa el valor que deseas converit.");
                cantidadFinal= teclado.nextDouble();
            }

            switch (opcion){
                case 1:
                    ConsultaMonedas.consultaMonedas("USD","ARS",cantidadFinal );
                    break;
                case 2:
                    ConsultaMonedas.consultaMonedas("ARS","USD",cantidadFinal);
                    break;
                case 3:
                    ConsultaMonedas.consultaMonedas("USD","BRL",cantidadFinal);
                    break;
                case 4:
                    ConsultaMonedas.consultaMonedas("BRL","USD",cantidadFinal);
                    break;
                case 5:
                    ConsultaMonedas.consultaMonedas("USD","COP",cantidadFinal);
                    break;
                case 6:
                    ConsultaMonedas.consultaMonedas("USD","MXN",cantidadFinal);
                    break;
                case 7:
                    System.out.println("Saliendo. Gracias por usar este servicio.");
                    break;
                default:
                    System.out.println("ingresa un numero valido");
                    break;

            }

        }
    }
}
