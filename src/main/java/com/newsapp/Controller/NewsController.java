package com.newsapp.Controller;

import com.newsapp.Model.DAO.News;
import com.newsapp.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/saveNews", method = RequestMethod.POST)
    public String saveNews(@RequestBody News news) {
        return newsService.saveNews(news);
    }

    @RequestMapping(value = "/getNews", method = RequestMethod.GET)
    public List<News> getNews() {
        return newsService.getNews();
    }

    @RequestMapping(value = "/updateNews/{id}", method = RequestMethod.PUT)
    public String updateNews(@RequestBody News news, @PathVariable int id) {
        return newsService.updateNews(news, id);
    }

    @RequestMapping(value = "/deleteNews/{id}", method = RequestMethod.DELETE)
    public String deleteNews(@PathVariable int id) {
        return newsService.deleteNewsById(id);
    }

}
