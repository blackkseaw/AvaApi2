package org.senai.ecommerce.entidade.dto;

import lombok.Data;

@Data
public class NovoProduto {

    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
}
