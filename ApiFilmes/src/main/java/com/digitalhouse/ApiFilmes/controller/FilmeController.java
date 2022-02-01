package com.digitalhouse.ApiFilmes.controller;

import com.digitalhouse.ApiFilmes.model.Filme;
import com.digitalhouse.ApiFilmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//www.digitalhouse.com.br/filme
//localhost:8080/filme

@RestController
@RequestMapping("/filme")
@CrossOrigin(origins = "*", allowedHeaders = "")
public class FilmeController {

    @Autowired
    private FilmeService service;

    @GetMapping
    public List<Filme> getAll() {
        return service.selectAll();
    }

    //localhost:8080/filme/5
    @GetMapping("/{id}")
    public Filme getById(@PathVariable Integer id) {
        return service.select(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Filme deletado com sucesso";
    }

    // @RequestBody pega um objeto Json e transforma num objeto java
    @PostMapping
    public Filme post(@RequestBody Filme filme) {
        return service.create(filme);
    }

    @PutMapping
    public Filme put(@RequestBody Filme filme) {
        return service.update(filme);
    }


}
