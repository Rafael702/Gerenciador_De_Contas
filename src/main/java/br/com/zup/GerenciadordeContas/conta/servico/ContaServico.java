package br.com.zup.GerenciadordeContas.conta.servico;

import br.com.zup.GerenciadordeContas.conta.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServico {
    @Autowired
    private ContaRepository contaRepository;


}
