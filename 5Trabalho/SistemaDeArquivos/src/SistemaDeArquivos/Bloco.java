/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeArquivos;

/**
 *
 * @author Rodrigo Maria <rammaria@restinga.ifrs.edu.br>
 * @author Eduarda de Brum <eblucena@restinga.ifrs.edu.br>
 */

public class Bloco {

    String nomeDoBloco;
    int inicioDoBloco;
    int quantidadeBlocos;
    int proximoBloco;
    int[] indice ={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public Bloco(String nomeDoBloco, int inicioDoBloco, int quantidadeBlocos) {
        this.nomeDoBloco = nomeDoBloco;
        this.inicioDoBloco = inicioDoBloco;
        this.quantidadeBlocos = quantidadeBlocos;
    }

    public void String() {
        System.out.println("[Bloco: Nome: " + this.nomeDoBloco + "\tInicio: " + this.inicioDoBloco + "]");
    }
    
    public void mostraConteudo(){
        System.out.println(nomeDoBloco);
    }
}
