package codes.showme.book.demo.controller;


import codes.showme.book.domain.Book;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookController {

    /**
     * 添加一本书（使用json格式直接传递一个对象）
     */
    @PostMapping(value = "/book", consumes = "application/json")
    public void addBook(@RequestBody Book book) {
        book.save();
    }

    /**
     * 获取所有的书
     *
     * @return
     */
    @GetMapping(value = "/book")
    public List<Book> getAllBooks() {
        return Book.findAll();
    }

    /**
     * 根据书的id获取书
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/book/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return Book.findById(id);
    }

    /**
     * 根据书的id删除书
     *
     * @param id
     */
    @DeleteMapping(value = "/book/{id}")
    public void delBookById(@PathVariable("id") Integer id) {
         Book.deleteById(id);
    }

    /**
     * 根据书名查书
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/book/name/{name}")
    public Book findByName(@PathVariable("name") String name) {
        return Book.findByName(name);
    }

    /**
     * 更新一本书（使用json格式直接传递一个对象）
     *
     * @param
     * @param id
     * @return
     */
    @PutMapping(value = "/book/{id}", consumes = "application/json")
    public String updateById(@RequestBody BookUpdateReq bookUpdateReq, @PathVariable("id") Integer id) {
        Book.update(id, bookUpdateReq.getName(), bookUpdateReq.getPrice());
        return "success";
    }
}
