package com.crud.produto.service;

import com.crud.produto.ProdutoApplication;
import com.crud.produto.model.Produto;
import com.crud.produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto criar(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listaTodosProdutos() {
        return repository.findAll();
    }

    public ResponseEntity<Produto> encontraPorId(Long id){
        return repository.findById(id)
                .map(task -> ResponseEntity.ok()
                        .body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Produto> atualizarProduto(Produto produto, Long id){
        return repository.findById(id)
                .map(produtoAtualizado -> {
                    produtoAtualizado.setNome(produto.getNome());
                    produtoAtualizado.setPreco(produto.getPreco());
                    produtoAtualizado.setDescricao(produto.getDescricao());

                    Produto atualizado = repository.save(produtoAtualizado);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> excluir (Long id){
        return repository.findById(id)
                .map(produtoDeletado ->{
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());

    }

}
