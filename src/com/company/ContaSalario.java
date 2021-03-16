package com.company;

public class ContaSalario extends Conta implements Tributavel, Transferir{
private String empregador;

    public ContaSalario(int numeroDaConta, int agencia, String banco, double saldo, String empregador) {
        super(numeroDaConta, agencia, banco, saldo);
        this.empregador = empregador;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        return "ContaSalario{" +
                "saldo=" + saldo +
                ", saque=" + saque +
                ", deposito=" + deposito +
                '}';
    }
// Coloquei que a conta salario só pode ser feito com salário todo 
    @Override
    public double getSaque() throws Exception {
        if(this.saque != this.saldo){
            System.out.println("O saque só deve ser feito de maneira inteira");
            throw new Exception("SAQUE FEITO FORA DO PADRÃO");
        }
        return getSaldo() - this.saque;
    }
   // utilizei de uma regra real de conta salário, supondo que quem consulta não é o empregador
    @Override
    public double getDeposito() throws Exception{
        throw new Exception("SEM AUTORIZAÇÃO PARA FAZER DEPOSITOS");
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
