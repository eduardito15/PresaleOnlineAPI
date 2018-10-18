package com.presaleonline.presaleonlineapi.service.impl;

import com.presaleonline.presaleonlineapi.dao.ArticleDAO;
import com.presaleonline.presaleonlineapi.domain.*;
import com.presaleonline.presaleonlineapi.dto.ArticleDTO;
import com.presaleonline.presaleonlineapi.service.ArticleService;
import com.presaleonline.presaleonlineapi.service.ClientService;
import com.presaleonline.presaleonlineapi.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ArticleDAO articleDAO;


    @Override
    public List<ArticleDTO> getAll(User user) {
        List<ArticleDTO> articles = new ArrayList<>();
        if(user.getUserType().equals(UserType.CLIENT.toString())) {
            //Es un cliente
            Client client = clientService.getByUser(user);
            for(Article a : articleDAO.getAllByClient(client)) {
                articles.add(createArticleDTOFromArticle(a));
            }
        } else {
            //Es un proveedor
            Provider provider = providerService.getByUser(user);
            for (Article a : articleDAO.getAllByProvider(provider)) {
                articles.add(createArticleDTOFromArticle(a));
            }
        }
        return articles;
    }

    private  ArticleDTO createArticleDTOFromArticle(Article a) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setCode(a.getCode());
        articleDTO.setDescription(a.getLongDescription());
        articleDTO.setCategory(a.getCategory().getName());
        return articleDTO;
    }
}
