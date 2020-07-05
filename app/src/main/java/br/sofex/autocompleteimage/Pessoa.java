package br.sofex.autocompleteimage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.List;

public class Pessoa {

    private int image;
    private String name;
    private Long idade;
    private String email;

    private List<Integer> Listimage;
    private List<String> Listname;
    private List<Long> Listidade;
    private List<String> Listemail;


    public Pessoa(int antes, String antes1) {
        this.image = antes;
        this.name = antes1;
    }
    public Pessoa() {

    }
    public Pessoa(int antes, String antes1,Long Idade, String email) {
        this.image = antes;
        this.name = antes1;
        this.idade = Idade;
        this.email = email;
    }
    public Pessoa(List<Integer> antes, List<String> antes1, List<Long> Idade, List<String> email) {
        this.Listimage = antes;
        this.Listname = antes1;
        this.Listidade = Idade;
        this.Listemail = email;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getListimage() {
        return Listimage;
    }

    public void setListimage(List<Integer> listimage) {
        Listimage = listimage;
    }

    public List<String> getListname() {
        return Listname;
    }

    public void setListname(List<String> listname) {
        Listname = listname;
    }

    public List<Long> getListidade() {
        return Listidade;
    }

    public void setListidade(List<Long> listidade) {
        Listidade = listidade;
    }

    public List<String> getListemail() {
        return Listemail;
    }

    public void setListemail(List<String> listemail) {
        Listemail = listemail;
    }
}
