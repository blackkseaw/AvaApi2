package org.senai.ecommerce.controle;
import org.senai.ecommerce.entidade.Produto;
import org.senai.ecommerce.entidade.dto.NovoProduto;
import org.senai.ecommerce.servico.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<?> getProdutos() {
        return new ResponseEntity<>(produtoService.getProdutos(), HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> getProdutoPorCodigo(@PathVariable Long codigo) {
        return new ResponseEntity<>(produtoService.getProdutoPorCodigo(codigo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody NovoProduto produto) {
        Produto produtoCriado = produtoService.criarProduto(produto);
        return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long codigo, @RequestBody NovoProduto novoProduto) {

        Produto produto = (produtoService.atualizarProduto(nome,descricao);

        return ResponseEntity.ok(produto);
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long codigo) {
        produtoService.excluirProduto(codigo);
        return new ResponseEntity<>("Produto Excluído do Sucesso!", HttpStatus.OK);
    }


}
