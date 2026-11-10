package org.example;

public class CentralTransferencia implements CentralOperacoes {

    private static CentralTransferencia instance = new CentralTransferencia();

    private CentralTransferencia() {}

    public static CentralTransferencia getInstance() {
        return instance;
    }

    @Override
    public String transferir(double valor, Conta remetente, Conta destinatario) {
        if (remetente.getSaldo() < valor) {
            return "Transferência recusada: saldo insuficiente.";
        }

        remetente.debitar(valor);
        destinatario.creditar(valor);

        return "Transferência de R$ " + valor + " realizada com sucesso de " +
                remetente.getTitular() + " para " + destinatario.getTitular();
    }
}
