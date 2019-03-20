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
public class main {
    public static void main(String[] args) {
        // criação das páginas das memória virtual 1
        MemoriaVirtual1[] memoriaVirtual1 = {
            new MemoriaVirtual1("000-100", "ABC"),
            new MemoriaVirtual1("100-200", "DEF"),
            new MemoriaVirtual1("200-300", ""),
            new MemoriaVirtual1("300-400", "GHI"),
            new MemoriaVirtual1("400-500", "JKL")
        };

        // criação das páginas das memória virtual 2
        MemoriaVirtual2[] memoriaVirtual2 = {
            new MemoriaVirtual2("000-100", ""), 
            new MemoriaVirtual2("100-200", "MNO"), 
            new MemoriaVirtual2("200-300", "PQR"),
            new MemoriaVirtual2("300-400", ""), 
            new MemoriaVirtual2("400-500", "STU")
        };
        
        // criação dos mapeamentos, definindo em que tipo de memória será enviado a página,
        // a posição na memória
        Mapeador[] mapeador = {
            new Mapeador("Principal", "100-200", "MemoriaVirtual1", "000-100"),
            new Mapeador("Secundaria", "000-100", "MemoriaVirtual1", "100-200"),
            new Mapeador("Principal", "300-400", "MemoriaVirtual1", "300-400"),
            new Mapeador("Principal", "900-999", "MemoriaVirtual1", "400-500"),
            new Mapeador("Secundaria", "400-500", "MemoriaVirtual2", "100-200"),
            new Mapeador("Principal", "200-300", "MemoriaVirtual2", "200-300"),
            new Mapeador("Secundaria", "500-600", "MemoriaVirtual2", "400-500")
        };
        
        // criação da memória principal vazia
        Principal[] memoriaPrincipal = {
            new Principal("000-100", "", ""),
            new Principal("100-200", "", ""),
            new Principal("200-300", "", ""),
            new Principal("300-400", "", ""),
            new Principal("400-500", "", ""),
            new Principal("500-600", "", ""),
            new Principal("600-700", "", ""),
            new Principal("700-800", "", ""),
            new Principal("800-900", "", ""),
            new Principal("900-999", "", "")
        };
        
        // criação da memória secundária vazia
        Secundaria[] memoriaSecundaria = {
            new Secundaria("000-100", "", ""),
            new Secundaria("100-200", "", ""),
            new Secundaria("200-300", "", ""),
            new Secundaria("300-400", "", ""),
            new Secundaria("400-500", "", ""),
            new Secundaria("500-600", "", ""),
            new Secundaria("600-700", "", ""),
            new Secundaria("700-800", "", ""),
            new Secundaria("800-900", "", ""),
            new Secundaria("900-999", "", "")
        };
        
        // conteúdo da memória virtual 01
        System.out.println("Memória Virtual 01");
        for (int i=0; i < memoriaVirtual1.length; i++){
            System.out.println("Página: " + memoriaVirtual1[i].pagina + "\tConteúdo: " + memoriaVirtual1[i].conteudo);
        }
        System.out.println("");
        
        // conteúdo da memória virtual 02
        System.out.println("Memória Virtual 02");
        for (int i=0; i < memoriaVirtual2.length; i++){
            System.out.println("Página: " + memoriaVirtual2[i].pagina + "\tConteúdo: " + memoriaVirtual2[i].conteudo);
        }
        System.out.println("");
        
        // conteúdo das mapeações
        System.out.println("Mapeamentos");
        for (int i=0; i < mapeador.length; i++){
            System.out.println("Tipo de Memória: " + mapeador[i].tipoDeMemoriaQueSeraAlocado + "\tPosição: " + mapeador[i].posicaoQueSeraAlocado + "\tProcedência: " + mapeador[i].memoriaVirtualQueVeio + "\tPágina procedente: " + mapeador[i].paginaDeOndeVeio);
        }
        System.out.println("");
        
        System.out.println("Conteúdo Memória Principal");     
        for (int i=0; i < memoriaPrincipal.length; i++){
            System.out.println("Página: " + memoriaPrincipal[i].posicaoMemoriaPrincipal + "\tConteúdo: " + memoriaPrincipal[i].conteudoMemoriaPrincipal + "\tDono: " + memoriaPrincipal[i].memoriaVirtualDono);
        }
        System.out.println("");


        System.out.println("Conteúdo Memória Secundária");
        for (int i=0; i < memoriaSecundaria.length; i++){
            System.out.println("Página: " + memoriaSecundaria[i].posicaoMemoriaSecundaria + "\tConteúdo: " + memoriaSecundaria[i].conteudoMemoriaSecundaria + "\tDono: " + memoriaSecundaria[i].memoriaVirtualDono);
        }
        
        System.out.println("");        
        System.out.println("------------------------------------------------------------------");        
        System.out.println("");
        
              
        System.out.println("Após a lógica:");
        // lógica de mapeamento
        for (int i=0; i < mapeador.length; i++){ // executa o mapeador
           if (mapeador[i].tipoDeMemoriaQueSeraAlocado.equals("Principal")){ // se o tipo de memoria para alocar for principal
               for (int p=0; p < memoriaPrincipal.length; p++){ // executa a memoria principal
                   if (memoriaPrincipal[p].posicaoMemoriaPrincipal.equals(mapeador[i].posicaoQueSeraAlocado) && 
                           (mapeador[i].memoriaVirtualQueVeio.equals("MemoriaVirtual1"))){ // se a posicao da memoria principal for igual a posicao do mapeador que sera alocado e a memoria de onde vira o conteudo for a virtual 1
                        for (int v=0; v < memoriaVirtual1.length; v++){ // executa a virtual 1
                           if (!memoriaVirtual1[v].conteudo.equals("")){ // se o conteudo for diferente de vazio
                                if (memoriaVirtual1[v].pagina.equals(mapeador[i].paginaDeOndeVeio)){ // se a pagina da memoria virtual 1 for igual a pagina do mapeador de onde veio
                                    if (memoriaPrincipal[p].conteudoMemoriaPrincipal.equals("")){ // se o conteudo da posicao da memoria principal for vazio
                                        memoriaPrincipal[p].conteudoMemoriaPrincipal = memoriaVirtual1[v].conteudo; // principal recebe o conteudo da virtual 1
                                        memoriaPrincipal[p].memoriaVirtualDono = memoriaVirtual1[v].toString(); // principal recebe o dono, que é a virtual 1
                                    }
                                    else{ // se o conteudo da posicao já estiver preenchido
                                        System.out.println("Tentativa de alocação dupla. Espaço " + memoriaPrincipal[p].posicaoMemoriaPrincipal + " da Memória " + memoriaPrincipal[p].toString() + " já foi utilizado anteriormente.");
                                        System.out.println("");
                                    }
                                }                               
                            }                               
                        }                           
                    }
                   else{
                       if (memoriaPrincipal[p].posicaoMemoriaPrincipal.equals(mapeador[i].posicaoQueSeraAlocado) && 
                               (mapeador[i].memoriaVirtualQueVeio.equals("MemoriaVirtual2"))){ // se a posicao da memoria principal for igual a posicao do mapeador que sera alocado e a memoria de onde vira o conteudo for a virtual 2
                            for (int v=0; v < memoriaVirtual2.length; v++){ // executa a virtual 2
                               if (!memoriaVirtual2[v].conteudo.equals("")){ // se o conteudo for diferente de vazio
                                    if (memoriaVirtual2[v].pagina.equals(mapeador[i].paginaDeOndeVeio)){ // se a pagina da memoria virtual 2 for igual a pagina do mapeador de onde veio
                                        if (memoriaPrincipal[p].conteudoMemoriaPrincipal.equals("")){ // se o conteudo da posicao da memoria principal for vazio
                                            memoriaPrincipal[p].conteudoMemoriaPrincipal = memoriaVirtual2[v].conteudo; // principal recebe o conteudo da virtual 2
                                            memoriaPrincipal[p].memoriaVirtualDono = memoriaVirtual2[v].toString(); // principal recebe o dono, que é a virtual 2
                                        }
                                        else{ // se o conteudo da posicao já estiver preenchido
                                            System.out.println("Tentativa de alocação dupla. Espaço " + memoriaPrincipal[p].posicaoMemoriaPrincipal + " da Memória " + memoriaPrincipal[p].toString() + " já foi utilizado anteriormente.");
                                            System.out.println("");
                                        }
                                    }                               
                                }                               
                            }                           
                        } 
                   }
               }
            }
           else{
               for (int p=0; p < memoriaSecundaria.length; p++){ // se o tipo de memoria para alocar for secundaria
                   if (memoriaSecundaria[p].posicaoMemoriaSecundaria.equals(mapeador[i].posicaoQueSeraAlocado) && 
                           (mapeador[i].memoriaVirtualQueVeio.equals("MemoriaVirtual1"))){ // se a posicao da memoria secundaria for igual a posicao do mapeador que sera alocado e a memoria de onde vira o conteudo for a virtual 1
                        for (int v=0; v < memoriaVirtual1.length; v++){ // executa a virtual 1
                           if (!memoriaVirtual1[v].conteudo.equals("")){ // se o conteudo for diferente de vazio
                                if (memoriaVirtual1[v].pagina.equals(mapeador[i].paginaDeOndeVeio)){ // se a pagina da memoria virtual 1 for igual a pagina do mapeador de onde veio
                                    if (memoriaSecundaria[p].conteudoMemoriaSecundaria.equals("")){ // se o conteudo da posicao da memoria secundaria for vazio
                                        memoriaSecundaria[p].conteudoMemoriaSecundaria = memoriaVirtual1[v].conteudo; // secundaria recebe o conteudo da virtual 1
                                        memoriaSecundaria[p].memoriaVirtualDono = memoriaVirtual1[v].toString(); // secundaria recebe o dono, que é a virtual 1
                                    }
                                    else{ // se o conteudo da posicao já estiver preenchido
                                        System.out.println("Tentativa de alocação dupla. Espaço " + memoriaSecundaria[p].posicaoMemoriaSecundaria + " da Memória " + memoriaSecundaria[p].toString() + " já foi utilizado anteriormente.");
                                        System.out.println("");
                                    }
                                }                               
                            }                               
                        }                           
                    }
                   else{
                       if (memoriaSecundaria[p].posicaoMemoriaSecundaria.equals(mapeador[i].posicaoQueSeraAlocado) && 
                               (mapeador[i].memoriaVirtualQueVeio.equals("MemoriaVirtual2"))){ // se a posicao da memoria secundaria for igual a posicao do mapeador que sera alocado e a memoria de onde vira o conteudo for a virtual 2
                            for (int v=0; v < memoriaVirtual2.length; v++){ // executa a virtual 2
                               if (!memoriaVirtual2[v].conteudo.equals("")){ // se o conteudo for diferente de vazio
                                    if (memoriaVirtual2[v].pagina.equals(mapeador[i].paginaDeOndeVeio)){ // se a pagina da memoria virtual 2 for igual a pagina do mapeador de onde veio
                                        if (memoriaSecundaria[p].conteudoMemoriaSecundaria.equals("")){ // se o conteudo da posicao da memoria secundaria for vazio
                                            memoriaSecundaria[p].conteudoMemoriaSecundaria = memoriaVirtual2[v].conteudo; // secundaria recebe o conteudo da virtual 2
                                            memoriaSecundaria[p].memoriaVirtualDono = memoriaVirtual2[v].toString(); // secundaria recebe o dono, que é a virtual 1
                                        }
                                        else{ // se o conteudo da posicao já estiver preenchido
                                            System.out.println("Tentativa de alocação dupla. Espaço " + memoriaSecundaria[p].posicaoMemoriaSecundaria + " da Memória " + memoriaSecundaria[p].toString() + " já foi utilizado anteriormente.");
                                            System.out.println("");
                                        }
                                    }                               
                                }                               
                            }                           
                        } 
                    }
                }
            }
        }
        
        System.out.println("Conteúdo Memória Principal");     
        for (int i=0; i < memoriaPrincipal.length; i++){
            System.out.println("Página: " + memoriaPrincipal[i].posicaoMemoriaPrincipal + "\tConteúdo: " + memoriaPrincipal[i].conteudoMemoriaPrincipal + "\tDono: " + memoriaPrincipal[i].memoriaVirtualDono);
        }
        System.out.println("");


        System.out.println("Conteúdo Memória Secundária");
        for (int i=0; i < memoriaSecundaria.length; i++){
            System.out.println("Página: " + memoriaSecundaria[i].posicaoMemoriaSecundaria + "\tConteúdo: " + memoriaSecundaria[i].conteudoMemoriaSecundaria + "\tDono: " + memoriaSecundaria[i].memoriaVirtualDono);
        }
    }
}
