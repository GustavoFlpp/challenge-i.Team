package com.iTeam.service;

import com.iTeam.model.Product;
import com.iTeam.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ProdutoServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarProduto() {
        Product product = new Product();
        product.setName("Produto 1");
        product.setPrice(BigDecimal.valueOf(10.0));
        product.setQuantityInStock(5);

        when(productRepository.save(product)).thenReturn(product);
        Product novoProduto = productService.createProduct(product);
        assertEquals("Produto 1", novoProduto.getName());
    }

    @Test
    public void testListarProdutos() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(productService.listarProdutos().isEmpty());
    }

    @Test
    public void testObterProdutoPorId() {
        Product produto = new Product();
        produto.setId(1L);
        produto.setName("Produto 1");

        when(productRepository.findById(1L)).thenReturn(Optional.of(produto));
        Product encontrado = productService.obterProdutoPorId(1L);
        assertEquals("Produto 1", encontrado.getNome());
    }

    // Adicione mais testes para os outros métodos...
}
