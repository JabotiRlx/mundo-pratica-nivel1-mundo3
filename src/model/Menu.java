/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Scanner;

/**
 *
 * @author sendi
 */
public class Menu {
    private Scanner scanner;
    private final String NEW_LINE = System.getProperty("line.separator");
    private String telaInicialResposta;
    
    public Menu () {
        scanner = new Scanner( System.in );
    }
    
    public void telaInicial() {
      System.out.println("==================="  + NEW_LINE
            + "1 - Incluir Pessoa" + NEW_LINE
            + "2 - Alterar Pessoa" + NEW_LINE
            + "3 - Excluir Pessoa" + NEW_LINE
            + "4 - Buscar por ID" + NEW_LINE
            + "5 - Exibir Todos" + NEW_LINE
            + "6 - Persistir Dados" + NEW_LINE
            + "7 - Recuperar Dados" + NEW_LINE
            + "0 - Finalizar Programa" + NEW_LINE
            + "======================");
      
//       ultimaResposta = scanner.nextLine();
    }
    
    public void setTelaInicialResposta( ) {
        telaInicialResposta = scanner.nextLine();
    }
    
    public String getTelaInicialResposta () {
        return telaInicialResposta;
    }
    
    public String escolhaTipoPessoa() {
       
        while( true ) {
            System.out.println("F - Pessoa Fisica | J - Pessoa Juridica" );

            String opcao = scanner.nextLine().toUpperCase();
            
            switch( opcao ) {
                case "J", "F" -> {
                    return opcao;
                }
                default -> System.out.println("Opcao invalida!");
            }
        }
           
    }
    
    public String escolhaPrefixo() {
        System.out.println("Favor Digitar o Prefixo do Arquivo:" );
        return scanner.nextLine();
    }
    
    public PessoaFisica preenchePessoaFisica() {
    
        int id = inputApenasNumeros( "ID" );
                        
        System.out.println("Favor Digitar o Nome:" );       
        String nome = scanner.nextLine();
        
        System.out.println("Favor Digitar o CPF:" );       
        String cpf = scanner.nextLine();
            
        int idade = inputApenasNumeros( "idade" );
      
        return new PessoaFisica( id, nome, cpf,idade );
           
    }
    
    public PessoaJuridica preenchePessoaJuridica() {
   
        int id = inputApenasNumeros( "ID" );
            
        System.out.println("Favor Digitar o Nome:" );       
        String nome = scanner.nextLine();
        
        System.out.println("Favor Digitar o CNPJ:" );       
        String CNPJ = scanner.nextLine();
        
        return new PessoaJuridica( id, nome, CNPJ );
           
    }
     
    public int inputApenasNumeros( String nomeInput ){
        System.out.println("Favor Digitar o " + nomeInput +" (Somente Numeros):" );      
        
        int reloop = 0;
        int result = 0;
        do {
          try {
            String input = scanner.nextLine(); // Scan the next line from System.in
            result = Integer.parseInt(input); // Try to parse it as an int
            reloop++;
          } catch (Exception e) {
            System.out.println("Por favor digite um NUMERO!");
          }
        } while (reloop == 0);
        
        return result;
    }
     
    public final static void limparConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

}
