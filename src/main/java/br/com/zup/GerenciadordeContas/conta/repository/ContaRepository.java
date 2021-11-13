package br.com.zup.GerenciadordeContas.conta.repository;

import br.com.zup.GerenciadordeContas.conta.Conta;
import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import br.com.zup.GerenciadordeContas.conta.enuns.Tipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
    List<Conta> findAllByStatus(Status status);

    List<Conta> findAllByTipo(Tipo tipo);

    @Query(value = "SELECT * FROM contas WHERE valor BETWEEN :valor -10 AND :valor+10", nativeQuery = true)
    List<Conta> findByValor(Double valor);
}
