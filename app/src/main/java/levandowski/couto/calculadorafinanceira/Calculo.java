package levandowski.couto.calculadorafinanceira;


/**
 * Created by Levandowski
 */

public class Calculo {
    private double valor1;
    private double valor2;

    public Calculo() {
    }

    public double getValor1() {return valor1;}

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    double somar(){
            return valor1+valor2;
    }
    double subtrair(){
        return valor1-valor2;
    }
    double dividir(){return valor1/valor2;}
    double multiplicar(){return valor1*valor2;}
    @Override
    public String toString() {
        return "O Resultado da Soma é: "+somar()+
                "O Resultado da Subtração é: "+subtrair()+
                "O Resultado da Divisão é: "+dividir()+
                "O Resultado da Multiplicação é: "+multiplicar();
    }
}
