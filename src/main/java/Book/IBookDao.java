package Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookDao extends JpaRepository<Book, Integer> {

}
