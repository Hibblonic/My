package br.inatel.cdg.algebra.scene;

public class Reta {
    Ponto ponto1;
    Ponto ponto2;

    double calcCa(){
        double result;
        result = (ponto2.y-ponto1.y)/(ponto2.x-ponto1.x);
        return result;
    }

    double calcCl(){
        double result;
        result = (ponto1.y-calcCa()*ponto1.x);
        return result;
    }
}
