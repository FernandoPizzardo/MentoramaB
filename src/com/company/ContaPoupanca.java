package com.company;

public class ContaPoupanca extends Conta implements Transferir {
    private int diaRendimento;
    private double taxaDeJuros;

    public ContaPoupanca(int numeroDaConta, int agencia, String banco, double saldo, int diaRendimento, double taxaDeJuros) {
        super(numeroDaConta, agencia, banco, saldo);
        this.diaRendimento = diaRendimento;
        this.taxaDeJuros = taxaDeJuros;
    }



    public double getSaldo(int dia) {
        if (dia >= diaRendimento){
            this.saldo = this.saldo + this.taxaDeJuros*this.saldo;
            return this.saldo;
        }
       else return this.saldo;
    }


    public double getSaque() throws Exception{
        if(this.saque > getSaldo()){
            throw new Exception("SALDO INSUFICIENTE");
        }
        return getSaldo() - this.saque;
    }

    @Override
    public double getDeposito() {
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
}
