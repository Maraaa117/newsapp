package com.newsapp.Service;

import com.newsapp.Model.DAO.News;
import com.newsapp.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public String saveNews(News news) {
        this.newsRepository.save(news);
        return "News added successfully";
    }

    public List<News> getNews() {
        return this.newsRepository.findAll();
    }

    public String updateNews(News news, int id){
        News oldNews = newsRepository.findById(id).get();

        oldNews.setAuthor(news.getAuthor());
        oldNews.setTitle(news.getTitle());
        oldNews.setContent(news.getContent());
        oldNews.setPostingDate(news.getPostingDate());
        oldNews.setReadingTime(news.getReadingTime());
        oldNews.setType(news.getType());
        oldNews.setURL(news.getURL());
        oldNews.setImageUrl(news.getImageUrl());
        oldNews.setComments(news.getComments());

        this.newsRepository.save(oldNews);
        return "News updated successfully";
    }

    public String deleteNewsById(int id) {
        this.newsRepository.deleteById(id);
        return "News deleted successfully";
    }
}
