package com.newsapp.Controller;

import com.newsapp.Model.DAO.News;
import com.newsapp.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/saveNews", method = RequestMethod.POST)
    public String saveNews(@RequestBody News news) {
        return newsService.saveNews(news);
    }

}
