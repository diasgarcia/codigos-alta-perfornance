public class App {
    public static void main(String[] args) throws Exception {

        int numero = 123;

        int centena = numero / 100;
        int dezena = (numero / 10) % 10;
        int unidade = numero % 10;

        int numeroInvertido = unidade * 100 + dezena * 10 + centena;

        System.out.println(numeroInvertido); // 321
    }
}
