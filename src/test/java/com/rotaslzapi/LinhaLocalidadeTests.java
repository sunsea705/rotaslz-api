package com.rotaslzapi;

import com.rotaslzapi.entities.Linha;
import com.rotaslzapi.entities.LinhaLocalidade;
import com.rotaslzapi.entities.Localidade;
import com.rotaslzapi.services.LinhaLocalidadeService;
import com.rotaslzapi.services.LinhaService;
import com.rotaslzapi.services.LocalidadeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class LinhaLocalidadeTests {

    @Mock private LinhaService linhaService;
    @Mock private LocalidadeService localidadeService;
    @Mock private LinhaLocalidadeService linhaLocalidadeService;

    @Test
    void testarCriacaoLinhaLocalidade() {

        Linha mockLinha = Linha.builder().id(1L).descricao("Sol e Mar").build();
        Localidade mockLocalidade = Localidade.builder().id(1L).descricao("Av. Acre").build();

        LinhaLocalidade mockLinhaLocalidade = LinhaLocalidade.builder().linha(mockLinha).localidade(mockLocalidade).ordem(1).build();

        // configuração de comportamento
        when(linhaService.buscarPorId(1L)).thenReturn(mockLinha);
        when(localidadeService.buscarPorId(1L)).thenReturn(mockLocalidade);
        when(linhaLocalidadeService.buscarPorId(1L)).thenReturn(mockLinhaLocalidade);

        // criando objeto de teste
        LinhaLocalidade linhaLocalidade = linhaLocalidadeService.buscarPorId(1L);

        // testando...
        assertNotNull(linhaLocalidade);
        assertEquals("L", 1L, linhaLocalidade.getLinha().getId());
        assertEquals("L", 1L, linhaLocalidade.getLocalidade().getId());

    }


}
