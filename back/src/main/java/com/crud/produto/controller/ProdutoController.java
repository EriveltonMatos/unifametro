package com.crud.produto.controller;

import com.crud.produto.model.Produto;
import com.crud.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

    @Autowired
    private ProdutoService service;


    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody Produto produto){
        return service.criar(produto);
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarTodos(){
        return service.listaTodosProdutos();
    }

    @GetMapping("/buscar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> encontraPorId(@PathVariable(value = "id") long id){
        return service.encontraPorId(id);
    }

    @PutMapping("/atualiza/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> atualizar(@PathVariable (value = "id") Long id, @RequestBody Produto produto) {
        return service.atualizarProduto(produto,id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long id){
        return service.excluir(id);
    }
}
