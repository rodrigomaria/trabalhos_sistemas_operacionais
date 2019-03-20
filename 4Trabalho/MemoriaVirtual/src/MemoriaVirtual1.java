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
public class MemoriaVirtual1 {
    String pagina;
    String conteudo;
    
    public MemoriaVirtual1(String pagina, String conteudo) {
        this.pagina = pagina;
        this.conteudo = conteudo;
    }
    
    @Override
    public String toString() {
        return getClass().getName();
    }   
    
}
