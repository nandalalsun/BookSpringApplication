package Book;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Resource
    private IBookDao iBookDao;

    public List<Book> getAll(){
        return iBookDao.findAll();
    }

    public Book add(Book book){
        return iBookDao.save(book);
    }

    public Book get(int id){
        return iBookDao.findById(id).get();
    }

    public void update(Book book){
        iBookDao.save(book);
    }

    public void delete(int id){
        iBookDao.deleteById(id);
    }

}
