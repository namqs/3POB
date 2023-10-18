package com.mycompany.aula02;
public class Caneta {
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    private boolean tampada;
    
    public void status(){
        System.out.print("Uma Caneta " + this.cor);
        System.out.println("Modelo: "+ this.modelo);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println(" está tampada?" +this.tampada);
    }
    protected void rabiscar(){
        if (this.tampada == true) {
            System.err.println("ERRO! Nao eh possivel rabiscar com tampa");
        } else {
            System.out.println("Estou rabiscando!");
        }
    }
    public void tampar(){
        this.tampada = true;
    }
    public void destampar(){
        this.tampada = false;
    }
}
