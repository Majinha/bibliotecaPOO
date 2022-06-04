package Dados;

import java.time.LocalDate;
import java.time.Month;
//import java.util.GregorianCalendar;
import java.time.Period;

public class Contato {

    private String nome;
    private Endereco enderecoResidencial;
    private LocalDate dataNasc;
    
    //sobrecarga de metedos, mesmo nome, ass diferente
    
    public Contato(String nome, int dia, int mes, int ano) {
        this.nome = nome;
        //GregorianCalendar data = new GregorianCalendar(ano, month mes - 1, dia)
        this.dataNasc = LocalDate.of(ano, mes, dia); //data que eu quero, nao hoje, naquele momento
    }
    
    public Contato(String nome, LocalDate dataNasc) {
        this.nome = nome;
        this.dataNasc = dataNasc;
    }
    
    public Contato(String nome) {
    	// chamando outro construtor, passando o nome 
    	//e uma data default para anoNascimento
        this(nome, 1, 1, 1900);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // classe period
    public int getIdade(){
        int idade = 0;
        LocalDate hoje = LocalDate.now(); //usa o timezone da virtualmachine
        Period tempo = Period.between(this.getDataNasc(), hoje); //this e optavel, apenas para achar mais facil | sub da data de nasc
        idade = tempo.getYears(); //pega o total de anos
        return idade;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    // ver o format de data e retornar format dd/mm/aaaa
    public String getDataNascFormatoBR() {
        String dataNascStr = dataNasc.getDayOfMonth() + "/" + 
        					 dataNasc.getMonthValue() + "/" + 
        					 dataNasc.getYear();

        return dataNascStr;
    }
    
    // FAZER UM GETDATANASCFORMATOBR USANDO

    // sobrecarga => overload
    // do método setDataNasc para aumentar a flexibilidade do uso deste setter
    public void setDataNasc(int dia, int mes, int ano) {
        this.dataNasc = LocalDate.of(ano, mes, dia);
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Endereco getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(Endereco enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    // estamos redefinindo ou sobrescrevendo o comportamento do toString padrão herdado da Object
    // é recomenado retornar um texto com uma informação útil do objeto
    @Override
    public String toString() {
        String retorno;
        retorno = "Eu me chamo " + nome;
        if (dataNasc.getYear() != 1900) {
        	retorno += " (" + getDataNascFormatoBR() + ") " + "-" + getIdade() + "anos";
        }
        
        return retorno;
    }
}