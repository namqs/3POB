package com.mycompany.aula02;
public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;
    
    void status(){
        System.out.print("Uma Caneta " + this.cor);
        System.out.println("Modelo: "+ this.modelo);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println(" está tampada?" +this.tampada);
    }
    void rabiscar(){
        if (this.tampada == true) {
            System.err.println("ERRO! Nao eh possivel rabiscar com tampa");
        } else {
            System.out.println("Estou rabiscando!");
        }
    }
    void tampar(){
        this.tampada = true;
    }
    void destampar(){
        this.tampada = false;
    }
}
