package com.presaleonline.presaleonlineapi.dao;

import com.presaleonline.presaleonlineapi.domain.Article;
import com.presaleonline.presaleonlineapi.domain.Client;
import com.presaleonline.presaleonlineapi.domain.Provider;
import com.presaleonline.presaleonlineapi.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleDAO {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Article> getAllByClient(Client client) {
        List<Article> clientArticles = new ArrayList<>();
        List<Provider> providers = providerRepository.getByClient(client.getId());
        for (Provider p: providers) {
            clientArticles.addAll(p.getArticles());
        }
        return clientArticles;
    }

    public List<Article> getAllByProvider(Provider provider) {
        return provider.getArticles();
    }

}
