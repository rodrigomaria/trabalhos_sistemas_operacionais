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
import java.util.Scanner;

public class Main {
    public static ArrayList<Arquivo> arquivos = new ArrayList<Arquivo>(); // cria arraylist com os arquivos
    public static Bloco[] dispositivo = new Bloco[50]; // cria dispositivo com 50 blocos
    public static ArrayList<Bloco> blocos = new ArrayList<Bloco>(); // cria arraylist com os blocos
    
    
    public static void main(String[] args) {
        
        for (int i = 0; i < dispositivo.length; i++) {
            dispositivo[i] = null; // seta todo o dispositivo como nulo
        }
                
        // blocos já ocupados como manda o exercício (bad blocks)
        dispositivo[10] = new Bloco("BadBlock", 10,1);       
        dispositivo[20] = new Bloco("BadBlock", 20,1);       
        dispositivo[30] = new Bloco("BadBlock", 30,1);        
        dispositivo[35] = new Bloco("BadBlock", 35,1);        
        dispositivo[40] = new Bloco("BadBlock", 40,1);
        
        // inserção dos arquivos definidos no exercício no arraylist
        arquivos.add(new Arquivo("Roben.txt", 3, 2));       
        arquivos.add(new Arquivo("Teste.txt", 4, 4));      
        arquivos.add(new Arquivo("Arquivo.txt", 8, 6));      
        arquivos.add(new Arquivo("Musica123.mp3", 12, 8));      
        arquivos.add(new Arquivo("Apresentacao.ppt", 16, 6));       
        arquivos.add(new Arquivo("Pagina.html", 13, 4));       
        arquivos.add(new Arquivo("Video.mpg", 31, 2));        
        arquivos.add(new Arquivo("Documento.pdf", 24, 4));        
          
        System.out.println("Escolha o tipo de alocacao em disco dos arquivos:");
        System.out.println("1 - Alocacao Contígua");
        System.out.println("2 - Alocacao Indexada");
        System.out.println("0 - Sair");
        
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();
    
        switch(opcao){
            case 1:
                AlocacaoContigua alocacaoContigua = new AlocacaoContigua();
                alocacaoContigua.contigua(arquivos);
                for (Bloco dispositivo1 : dispositivo) {
                    if (dispositivo1 != null) {
                        dispositivo1.String(); // mostra o bloco dentro do dispositivo se diferente de null
                    }
                }
                System.out.println();
                System.out.println("Informe o nome do arquivo:");                        
                Scanner leitura1 = new Scanner(System.in);
                alocacaoContigua.mostraConteudo(leitura1.next()); // mostra conteudo do bloco depois de alocado no dispositivo
                break;

            case 2:
                AlocacaoIndexada alocacaoIndexada = new AlocacaoIndexada();
                alocacaoIndexada.indexada(arquivos);
                for (Bloco dispositivo1 : dispositivo) {
                    if (dispositivo1 != null) {
                        dispositivo1.String(); // mostra o bloco dentro do dispositivo se diferente de null
                    }
                }
                System.out.println();
                System.out.println("Informe o nome do arquivo:");                        
                Scanner leitura2 = new Scanner(System.in);
                alocacaoIndexada.mostraConteudo(leitura2.next()); // mostra conteudo do bloco depois de alocado no dispositivo         
                break;      
         
            case 0:
                System.exit(0);           
        }        
    }
}
