package io.github.cellrepair.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.cellrepair.dto.ClienteDto;
import io.github.cellrepair.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<ClienteDto>> listarTodos(
            @PageableDefault(size = 10, sort = "nomeCompleto")Pageable pageable
            ){
        var clientes = clienteService.findAll(pageable);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id){
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity cadastrar(
            @RequestBody
            @Validated(ClienteDto.ClienteView.ClientePost.class)
            @JsonView(ClienteDto.ClienteView.ClientePost.class)
            ClienteDto clienteDto){

        var clienteSalvo = clienteService.save(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizar(
            @PathVariable Long id,
            @RequestBody
            @Validated(ClienteDto.ClienteView.ClientePut.class)
            @JsonView(ClienteDto.ClienteView.ClientePut.class)
            ClienteDto clienteDto
    ){
        var clienteAtualizado = clienteService.update(clienteDto, id);
        return ResponseEntity.ok(clienteAtualizado);
    }
}
