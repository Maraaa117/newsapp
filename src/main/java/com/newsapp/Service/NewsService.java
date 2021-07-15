package com.newsapp.Service;

import com.newsapp.Model.DAO.News;
import com.newsapp.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public String saveNews(News news) {
        if (!newsRepository.existsById(news.getId_news())) {
            newsRepository.save(news);
            return "User added successfully";
        } else {
            return "This user already exists in the database";
        }
    }

}
