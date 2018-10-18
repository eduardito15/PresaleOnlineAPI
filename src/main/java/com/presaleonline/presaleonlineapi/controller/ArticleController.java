package com.presaleonline.presaleonlineapi.controller;

import com.presaleonline.presaleonlineapi.domain.User;
import com.presaleonline.presaleonlineapi.dto.ArticleDTO;
import com.presaleonline.presaleonlineapi.service.ArticleService;
import com.presaleonline.presaleonlineapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public @ResponseBody
    Iterable<ArticleDTO> getAllArticles() {
        // This returns a JSON or XML with the articles
        User user = userService.getLoggedUser();
        return this.articleService.getAll(user);
    }
}
