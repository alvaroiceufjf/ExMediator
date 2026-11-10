package org.example;

public abstract class Conta {

    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public void debitar(double valor) {
        this.saldo -= valor;
    }

    public String enviarTransferencia(double valor, Conta destinatario) {
        return CentralTransferencia.getInstance().transferir(valor, this, destinatario);
    }
}
