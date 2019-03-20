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
public class Mapeador {
    String tipoDeMemoriaQueSeraAlocado;
    String posicaoQueSeraAlocado;
    String memoriaVirtualQueVeio;
    String paginaDeOndeVeio;
    

    public Mapeador(String tipoDeMemoriaQueSeraAlocado, String posicaoQueSeraAlocado, String memoriaVirtualQueVeio, String paginaDeOndeVeio) {
        this.tipoDeMemoriaQueSeraAlocado = tipoDeMemoriaQueSeraAlocado;
        this.posicaoQueSeraAlocado = posicaoQueSeraAlocado;
        this.memoriaVirtualQueVeio = memoriaVirtualQueVeio;
        this.paginaDeOndeVeio = paginaDeOndeVeio;
        
    }
}
