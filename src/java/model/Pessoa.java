/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author aluno
 */
public class Pessoa {
    private int codigo;
    private String nome;
    private Date datanasc;
    private String email;
    private String usuario;
    private String senha;
    private String tipo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigo(String c) {
        this.setCodigo(Integer.parseInt(c));
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
    
     public void setDatanasc(String d) throws Exception {
        SimpleDateFormat df ;
        
        if(d.contains("/")){
        df = new SimpleDateFormat("dd/MM/yyyy"); //html text
        this.datanasc = df.parse(d);
        }
        else
        {
            df = new SimpleDateFormat("yyyy-MM-dd"); //html date
            this.datanasc = df.parse(d);
        }
    }
    public int getIdade(){
        Date hoje;
        int idade;
        try{
            hoje =new Date(System.currentTimeMillis());
            
            idade = hoje.getYear()- this.datanasc.getYear();
            if((hoje.getMonth() < this.datanasc.getMonth()) || (hoje.getMonth() == this.datanasc.getMonth())
               && (hoje.getDate() == this.datanasc.getDate()))
            {
                idade --;
            }
            return(idade);
        }
        catch(Exception ex){
            return(-1);
        }
    }
    
    public int calculaIdade(){
        int idade;
        Calendar dataN = new GregorianCalendar();
        dataN.setTime(this.datanasc);
        Calendar today = Calendar.getInstance();
        idade = today.get(Calendar.YEAR) - dataN.get(Calendar.YEAR);
        dataN.add(Calendar.YEAR, idade); //passa a data de nascimento para o dia atual
        if(today.before(dataN)){
            idade --;
        }
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
