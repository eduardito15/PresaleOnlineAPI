package com.presaleonline.presaleonlineapi.service;

import com.presaleonline.presaleonlineapi.domain.User;
import com.presaleonline.presaleonlineapi.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {

    List<ArticleDTO> getAll(User user);
}
