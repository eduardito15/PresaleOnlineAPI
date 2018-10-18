package com.presaleonline.presaleonlineapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Provider extends AbstractClient{

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Client> clients;

    @JsonIgnore
    @OneToMany
    private List<Article> articles;


    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
