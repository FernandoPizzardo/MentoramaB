package com.company;

import java.util.HashMap;

public class ContaCorrente extends Conta implements Tributavel, Transferir{
    private double lis;

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numeroDaConta=" + numeroDaConta +
                ", agencia=" + agencia +
                ", banco='" + banco + '\'' +
                ", saldo=" + saldo +
                ", saque=" + saque +
                ", deposito=" + deposito +
                '}';
    }

    @Override
    public double getSaldo() {
        return this.lis + this.saldo;
    }

    @Override
    public double getSaque() throws Exception {
        if(getSaldo() < this.saque){
            System.out.println("SEM SALDO");
            throw new Exception("Saldo insuficiente para sacar");
        }
            return getSaldo() - this.saque;
    }

    @Override
    public double getDeposito() {
        return getSaldo() + this.deposito;
    }

    public ContaCorrente(int numeroDaConta, int agencia, String banco, double saldo, double lis) {
        super(numeroDaConta, agencia, banco, saldo);
        this.lis = lis;
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }

    @Override
    public boolean getTransferencia() {
       if (this.saque > getSaldo()){
           System.out.println("Sem saldo para fazer essa transferencia");
           return false;
       }
        return true;
    }
}
