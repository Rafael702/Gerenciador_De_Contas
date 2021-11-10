package br.com.zup.GerenciadordeContas.conta.repository;

import br.com.zup.GerenciadordeContas.conta.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository<Conta,Integer> {

}
