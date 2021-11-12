package br.com.zup.GerenciadordeContas.conta.servico;

import br.com.zup.GerenciadordeContas.conta.Conta;
import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import br.com.zup.GerenciadordeContas.conta.exception.ContaNaoEncontrada;
import br.com.zup.GerenciadordeContas.conta.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public List<Conta> exibirTodasAsContas() {
        List<Conta> contas = (List<Conta>) contaRepository.findAll();
        return contas;
    }

    public Conta atualizarConta(int id, Status status) {
        Conta conta = buscarConta(id);
        conta.setDataDePagamento(LocalDateTime.now());
        conta.setStatus(status);
        contaRepository.save(conta);
        return conta;
    }

    public Conta buscarConta(int id) {
        Optional<Conta> contaId = contaRepository.findById(id);

        if (contaId.isEmpty()) {
            throw new ContaNaoEncontrada("Não Encontramos esta Conta");
        }
        return contaId.get();
    }
}
