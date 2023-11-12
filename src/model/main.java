package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class main {
    public static void main ( String[] args ) throws IOException, ClassNotFoundException {
        try {
            Menu menu = new Menu();
            PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo( );
            PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo( );
            
            while (true) {
                menu.telaInicial();
                menu.setTelaInicialResposta();
                
                switch( menu.getTelaInicialResposta() ) {
                    case "1" -> {
                            String tipoPessoa = menu.escolhaTipoPessoa();
                            if( "F".equals(tipoPessoa) ) pessoaFisicaRepo.inserir(menu.preenchePessoaFisica() );
                            if( "J".equals(tipoPessoa) ) pessoaJuridicaRepo.inserir(menu.preenchePessoaJuridica() );
                        }
                    case "2" -> {
                            int id = menu.inputApenasNumeros( "ID" );
                            String tipoPessoa = menu.escolhaTipoPessoa();
                            
                            if( "F".equals(tipoPessoa) ) pessoaFisicaRepo.alterar( id,menu.preenchePessoaFisica() );
                            if( "J".equals(tipoPessoa) ) pessoaJuridicaRepo.alterar( id,menu.preenchePessoaJuridica() );
                        }
                    case "3" -> {
                            int id = menu.inputApenasNumeros( "ID" );
                            String tipoPessoa = menu.escolhaTipoPessoa();
                            
                            if( "F".equals(tipoPessoa) ) pessoaFisicaRepo.excluir( id );
                            if( "J".equals(tipoPessoa) ) pessoaJuridicaRepo.excluir( id );
                        }
                    case "4" -> {
                            int id = menu.inputApenasNumeros( "ID" );
                            String tipoPessoa = menu.escolhaTipoPessoa();
                            
                            if( "F".equals(tipoPessoa) ){
                                PessoaFisica pessoaFisica = pessoaFisicaRepo.obter( id );
                                pessoaFisica.exibir();
                            }
                            
                            if( "J".equals(tipoPessoa) ){
                                PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter( id );
                                pessoaJuridica.exibir();
                            }
                        }
                    case "5" -> {
                            String tipoPessoa = menu.escolhaTipoPessoa();
                            
                            if( "F".equals(tipoPessoa) ){
                                ArrayList<PessoaFisica> pessoasFisicas =  pessoaFisicaRepo.obterTodos();
                                pessoasFisicas.stream().forEach( pessoa -> pessoa.exibir() );
                            }

                            if( "J".equals(tipoPessoa) ) {
                                ArrayList<PessoaJuridica> pessoasJuridicas =  pessoaJuridicaRepo.obterTodos();
                                pessoasJuridicas.stream().forEach( pessoa -> pessoa.exibir() );
                            }
                        }
                    case "6" -> {
                            try{
                                String preFixo = menu.escolhaPrefixo();
                                pessoaFisicaRepo.persistir(preFixo + ".fisica.bin" );
                                pessoaJuridicaRepo.persistir(preFixo + ".juridica.bin" );    
                            } catch (Exception e) {
                                System.out.println("O sistema não pode criar o arquivo especificado!");
                            }
                                                  
                        }
                    case "7" -> {
                            try{
                                String preFixo = menu.escolhaPrefixo();
                                pessoaFisicaRepo.recuperar(preFixo + ".fisica.bin" );
                                pessoaJuridicaRepo.recuperar(preFixo + ".juridica.bin" );    
                            } catch (Exception e) {
                                System.out.println("O sistema não pode encontrar o arquivo especificado!");
                            }
                        }
                    case "0" -> System.exit(0);
                    default -> System.out.println("Opcao invalida!");
                }
                
            }
        } catch(IllegalStateException | NoSuchElementException e) {
            // System.in has been closed
            System.out.println("System.in was closed; exiting");
        }

        
    }
}