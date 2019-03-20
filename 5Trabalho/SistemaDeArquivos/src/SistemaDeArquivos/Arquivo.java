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

public class Arquivo {

    private String nomeDoArquivo;
    private int quantidadeBlocos;
    private int posicaoPrimeiroBloco;

    public Arquivo(String nomeDoArquivo, int posicaoPrimeiroBloco, int quantidadeBlocos) {
        this.nomeDoArquivo = nomeDoArquivo;
        this.posicaoPrimeiroBloco = posicaoPrimeiroBloco;
        this.quantidadeBlocos = quantidadeBlocos;        
    }

    public Arquivo(String nomeDoArquivo, int quantidadeBlocos) {
        this.nomeDoArquivo = nomeDoArquivo;
        this.quantidadeBlocos = quantidadeBlocos;
        this.posicaoPrimeiroBloco = 0;
    }

    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public void setNomeDoArquivo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    public int getQuantidadeBlocos() {
        return quantidadeBlocos;
    }

    public void setQuantidadeBlocos(int quantidadeBlocos) {
        this.quantidadeBlocos = quantidadeBlocos;
    }

    public int getPosicaoPrimeiroBloco() {
        return posicaoPrimeiroBloco;
    }

    public void setPosicaoPrimeiroBloco(int posicaoPrimeiroBloco) {
        this.posicaoPrimeiroBloco = posicaoPrimeiroBloco;
    }

}
