package br.com.zup.GerenciadordeContas.conta.servico;

import br.com.zup.GerenciadordeContas.conta.Conta;
import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import br.com.zup.GerenciadordeContas.conta.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        validarConta(conta);
        return contaRepository.save(conta);
    }

    public Status validarConta(Conta conta) {
        conta.setStatus(Status.AGUARDANDO);
        LocalDate diaDoCadastroDaConta = LocalDate.now();
        if (conta.getDataDeVencimento().isBefore(diaDoCadastroDaConta)) {
            conta.setStatus(Status.VENCIDA);
        }
        return conta.getStatus();
    }

}
