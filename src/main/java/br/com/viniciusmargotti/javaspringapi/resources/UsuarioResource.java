package br.com.viniciusmargotti.javaspringapi.resources;

import br.com.viniciusmargotti.javaspringapi.models.Usuario;
import br.com.viniciusmargotti.javaspringapi.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value="Usuarios")
@RequestMapping(value="/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @ApiOperation(value="Salva um usuário")
    @PostMapping("save")
    public Usuario saveUsuario(@RequestBody @Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @ApiOperation(value="Busca todos os usuários")
    @GetMapping("getAll")
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }


}
