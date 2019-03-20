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

public class AlocacaoContigua { // cria a classe AlocacaoContigua
    
    public void contigua(ArrayList<Arquivo> arq) { // recebe a arraylist de arquivos e executa a alocacao contigua
        for (Arquivo arquivo1 : arq) {
            if (arquivo1.getQuantidadeBlocos() > 0) {
                for (int j = 0; j < dispositivo.length; j++) { // procura posicoes livres no dispositivo
                    if (dispositivo[j] == null) {
                        boolean livre = true; // se encontra posicao livre, verifica se as posições contiguas estao livres e se suportam alocar todos os blocos do arquivo
                        for (int l = j + 1; l < arquivo1.getQuantidadeBlocos() + j; l++) {
                            if (l >= dispositivo.length) {
                                if (dispositivo[l - dispositivo.length] != null) {
                                    livre = false;
                                    j = l - dispositivo.length;
                                    break;
                                }
                            } else {
                                if (dispositivo[l] != null) {
                                    livre = false;
                                    j = l;
                                    break;
                                }
                            }
                        }
                        if (livre) { // se a quantidade de blocos forem suficientes, aloca os blocos
                            int contadorAuxiliar = 0;
                            Bloco blocoAuxiliar = new Bloco(arquivo1.getNomeDoArquivo(), 0,arquivo1.getQuantidadeBlocos());
                            blocoAuxiliar.quantidadeBlocos = arquivo1.getQuantidadeBlocos();
                            for (int r = j; r < blocoAuxiliar.quantidadeBlocos + j; r++) { // comeca a alocar
                                if (r >= dispositivo.length) {
                                    dispositivo[r - dispositivo.length] = new Bloco(Character.toString(blocoAuxiliar.nomeDoBloco.charAt(contadorAuxiliar)), r - dispositivo.length,blocoAuxiliar.quantidadeBlocos);
                                    contadorAuxiliar++;
                                } else {
                                    dispositivo[r] = new Bloco(Character.toString(blocoAuxiliar.nomeDoBloco.charAt(contadorAuxiliar)), r,blocoAuxiliar.quantidadeBlocos);
                                    contadorAuxiliar++;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void mostraConteudo(String nome){ // mostra o conteudo do arquivo          
        boolean auxiliar = true;
        String n = Character.toString(nome.charAt(0)).toUpperCase();
        
        for(int i=0;i<dispositivo.length;i++){
           if((dispositivo[i]!=null) && (dispositivo[i].nomeDoBloco.equals(n))){
                int j=i;
                auxiliar=false;
                for(j=i;j<dispositivo[i].quantidadeBlocos+i;j++){
                  dispositivo[j].mostraConteudo();
                }
                break;
                }
            }
        if(auxiliar){
            System.out.println("Arquivo nao encontrado");
       }
    }    
}
