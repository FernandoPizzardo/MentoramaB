package com.company;

public class ContaInvestimento extends Conta implements Tributavel, Transferir{
    String fundoDeInvestimentos;
    double taxaDeRetorno;
    double taxaDeRetirada;
    public ContaInvestimento(int numeroDaConta, int agencia, String banco, double saldo, String fundoDeInvestimentos, double taxaDeRetorno, double taxaDeRetirada) {
        super(numeroDaConta, agencia, banco, saldo);
        this.fundoDeInvestimentos = fundoDeInvestimentos;
        this.taxaDeRetirada = taxaDeRetirada;
        this.taxaDeRetorno = taxaDeRetorno;
    }

    @Override
    public String toString() {
        return "ContaInvestimento{" +
                "numeroDaConta=" + numeroDaConta +
                ", agencia=" + agencia +
                ", banco='" + banco + '\'' +
                ", saldo=" + saldo +
                ", fundoDeInvestimentos='" + fundoDeInvestimentos + '\'' +
                ", taxaDeRetorno=" + taxaDeRetorno +
                ", taxaDeRetirada=" + taxaDeRetirada +
                '}';
    }

    public double getSaldo(int dia) {
        if (dia >= 30) {
            return this.saldo * this.taxaDeRetorno;
        } else return this.saldo;
    }

    @Override
    public double getSaque() throws Exception {
        return getSaldo() - (this.saque - (this.saque % taxaDeRetirada));
    }

    @Override
    public double getDeposito() throws Exception {
        return getSaldo() + this.deposito;
    }

    @Override
    public boolean getTransferencia() {
        if (this.saque > getSaldo()){
            System.out.println("Sem saldo para fazer essa transferencia");
            return false;
        }
        return true;
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }
}
