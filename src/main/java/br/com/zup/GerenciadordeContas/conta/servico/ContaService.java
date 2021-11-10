package br.com.zup.GerenciadordeContas.conta.servico;

import br.com.zup.GerenciadordeContas.conta.Conta;
import br.com.zup.GerenciadordeContas.conta.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public void salvarConta(Conta conta) {
        contaRepository.save(conta);
    }

}
