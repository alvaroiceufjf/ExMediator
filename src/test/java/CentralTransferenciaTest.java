package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CentralTransferenciaTest {

    @Test
    void deveRealizarTransferenciaEntreAssociados() {
        ContaAssociado joao = new ContaAssociado("João", 1000.0);
        ContaAssociado maria = new ContaAssociado("Maria", 500.0);

        String resultado = joao.enviarTransferencia(300.0, maria);

        assertEquals(700.0, joao.getSaldo());
        assertEquals(800.0, maria.getSaldo());
        assertEquals("Transferência de R$ 300.0 realizada com sucesso de João para Maria", resultado);
    }

    @Test
    void deveRecusarTransferenciaPorSaldoInsuficiente() {
        ContaAssociado joao = new ContaAssociado("João", 100.0);
        ContaAssociado maria = new ContaAssociado("Maria", 500.0);

        String resultado = joao.enviarTransferencia(300.0, maria);

        assertEquals(100.0, joao.getSaldo());
        assertEquals(500.0, maria.getSaldo());
        assertEquals("Transferência recusada: saldo insuficiente.", resultado);
    }
}