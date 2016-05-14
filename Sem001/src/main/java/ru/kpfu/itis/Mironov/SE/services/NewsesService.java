package ru.kpfu.itis.Mironov.SE.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Mironov.SE.entities.News;
import ru.kpfu.itis.Mironov.SE.repositories.NewsesRepository;

import java.util.List;

/**
 * Created by Юра on 23.04.2016.
 */
@Service
public class NewsesService{
    @Autowired
    public NewsesRepository newsesRepository;
    @Transactional
    public News addEntity(News news) {
        return newsesRepository.saveAndFlush(news);
    }

    @Transactional
    public void delete(long id) {
        newsesRepository.delete(id);
    }

    public List<News> getAll() {
        return newsesRepository.findAll();
    }

    public List<News> get10NewsByPageNumber(int counter){
        counter *=10;
        List<News> newses = this.getAll();
        int max = newses.size();
        return newses.subList(counter - 10, counter > max ? max : counter);
    }

    public News getById(Long id) {
        return newsesRepository.findByIdNews(id);
    }
}
