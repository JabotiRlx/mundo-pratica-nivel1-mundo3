package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pessoas = new ArrayList<>();
    
    public void inserir( PessoaJuridica pessoa ) {
        pessoas.add(pessoa);
        Menu.limparConsole();
        System.out.println( "Pessoa Juridica Inserida com Sucesso!" );
    }
    
    public PessoaJuridica obter( int id ) {
        return pessoas.stream().filter(pessoa -> pessoa.getId() ==  id ).findFirst().orElse(null);
    }
  
    public void alterar( int id, PessoaJuridica pessoaDestino ) {
        int index = pessoas.indexOf( obter( id ) );
        pessoas.set( index, pessoaDestino);
        Menu.limparConsole();
        System.out.println( "Pessoa Juridica Alterada com Sucesso!" );
    }
 
    public void excluir( int id ) {
        pessoas = (ArrayList<PessoaJuridica>) pessoas.stream().filter(pessoa -> pessoa.getId() !=  id ).collect(Collectors.toList());
        Menu.limparConsole();
        System.out.println( "Pessoa Juridica Excluida com Sucesso!" );
    }
    
    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoas;
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoas);
            System.out.println( "Dados de Pessoas Juridicas armazenados." );
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoas = (ArrayList<PessoaJuridica>) inputStream.readObject();
            System.out.println( "Dados de Pessoas Juridicas recuperados." );
        }
    }
}
