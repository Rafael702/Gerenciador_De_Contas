package br.com.zup.GerenciadordeContas.conta;

import br.com.zup.GerenciadordeContas.conta.enuns.Status;
import br.com.zup.GerenciadordeContas.conta.enuns.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double valor;
    @Column(nullable = false)
    private LocalDate dataDeVencimento;
    private LocalDateTime dataDePagamento;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    private Status status;

}
