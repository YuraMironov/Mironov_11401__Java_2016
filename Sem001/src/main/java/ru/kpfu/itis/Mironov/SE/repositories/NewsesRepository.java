package ru.kpfu.itis.Mironov.SE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Mironov.SE.entities.News;

/**
 * Created by Юра on 23.04.2016.
 */
@Repository
public interface NewsesRepository extends JpaRepository<News, Long> {
    News findByTitle(String title);

    News findByIdNews(Long id);
}
