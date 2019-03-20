/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo Maria <rammaria@restinga.ifrs.edu.br>
 * @author Eduarda de Brum <eblucena@restinga.ifrs.edu.br>
 */
public class Principal {
    String posicaoMemoriaPrincipal;
    String conteudoMemoriaPrincipal;
    String memoriaVirtualDono;

    public Principal(String posicao, String conteudo, String dono) {
        this.posicaoMemoriaPrincipal = posicao;
        this.conteudoMemoriaPrincipal = conteudo;
        this.memoriaVirtualDono = dono;
    }
    
    @Override
    public String toString() {
        return getClass().getName();
    }
}
