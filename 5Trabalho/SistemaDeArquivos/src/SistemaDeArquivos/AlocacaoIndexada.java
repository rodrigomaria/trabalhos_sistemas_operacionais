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

import java.util.ArrayList;
import static SistemaDeArquivos.Main.dispositivo;

public class AlocacaoIndexada { // cria a classe AlocacaoIndexada

    public void indexada(ArrayList<Arquivo> arq) {
        for (Arquivo arquivo1 : arq) { // aloca os blocos de inicio de cada arquivo no dispositivo
            dispositivo[arquivo1.getPosicaoPrimeiroBloco()] = new Bloco(arquivo1.getNomeDoArquivo(), arquivo1.getPosicaoPrimeiroBloco(),arquivo1.getQuantidadeBlocos());
        }

        for (Arquivo arquivo1 : arq) {                          
            if (arquivo1.getQuantidadeBlocos() > 0) {
                if (dispositivo[arquivo1.getPosicaoPrimeiroBloco()].nomeDoBloco.contains(arquivo1.getNomeDoArquivo())) {
                    int contadorEspacosLivres = 0;
                    for (int j = 0; j < dispositivo.length; j++) { // conta a quantidade de blocos livres
                        if (dispositivo[j] == null) {
                            contadorEspacosLivres++;
                        }
                    }
                    if (contadorEspacosLivres >= arquivo1.getQuantidadeBlocos()) { // se houver posicoes livres suficientes comeca a alocacao
                        int auxiliar = 0;
                        int r = arquivo1.getPosicaoPrimeiroBloco()+1;
                        for (int l = r; l < dispositivo.length + r; l++) { // aloca os demais blocos de cada arquivo nas posicoes que estao vazias
                            if (arquivo1.getQuantidadeBlocos() > auxiliar) {
                                if (l >= dispositivo.length) {
                                    if (dispositivo[l - dispositivo.length] == null) {
                                        dispositivo[l - dispositivo.length] = new Bloco(Character.toString(arquivo1.getNomeDoArquivo().charAt(auxiliar)), l - dispositivo.length,arquivo1.getQuantidadeBlocos());
                                        dispositivo[arquivo1.getPosicaoPrimeiroBloco()].indice[auxiliar] = l - dispositivo.length; // guarda a posicao alocada no vetor index
                                        auxiliar++;
                                        
                                    }
                                } else {
                                    if (dispositivo[l] == null) {
                                        dispositivo[l] = new Bloco(Character.toString(arquivo1.getNomeDoArquivo().charAt(auxiliar)), l,arquivo1.getQuantidadeBlocos());
                                        dispositivo[arquivo1.getPosicaoPrimeiroBloco()].indice[auxiliar] = l; // guarda a posicao alocada no vetor indice
                                        auxiliar++;
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void mostraConteudo(String nome){ // mostra o conteudo do arquivo
        boolean aux=true;
        for(int i=0;i<dispositivo.length;i++){
           if(dispositivo[i]!=null && (dispositivo[i].nomeDoBloco.equals(nome))){
              aux=false;
              for(int j=0;j<dispositivo[i].indice.length;j++){
                  if(dispositivo[i].indice[j]!=-1){
                    dispositivo[dispositivo[i].indice[j]].mostraConteudo();
                  }
              }  
         }
      }
    if(aux){
           System.out.println("Arquivo nao encontrado");
       }
    }
}

