package codes.showme.book.domain;

import codes.showme.book.repository.BookRepository;
import codes.showme.book.service.ReviewService;
import codes.showme.book.service.WordCountService;
import codes.showme.tech.ioc.InstanceFactory;

import java.util.List;


public class Book {

    private Integer id;

    private String name;

    private Integer price;

    private String text;

    private long wordCount;

    public Book() {
    }

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static void update(Integer id, String name, Integer price) {
        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        repository.update(id, name, price);
    }

    public long save(){
        // 计算字数
        refreshWorldCount();

        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        Long id = repository.save(this);

        // 审核
        review(id);

        return id;
    }

    private void review(long id) {
        ReviewService reviewService = InstanceFactory.getInstance(ReviewService.class);
        reviewService.review(id);
    }

    private void refreshWorldCount(){
        WordCountService wordCountService = InstanceFactory.getInstance(WordCountService.class);
        this.wordCount = wordCountService.count(text);
    }

    public static List<Book> findAll(){
        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        return repository.findAll();
    }

    public static Book findById(Integer id){
        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        return repository.findById(id);

    }

    public static Book findByName(String name){
        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        return repository.findByName(name);
    }

    public void update(){
        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        repository.update(this);
    }


    public int remove(){
        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        return repository.remove(this);
    }

    public static void deleteById(Integer id) {
        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        repository.deleteById(id);
    }

    public void setWordCount(long wordCount) {
        this.wordCount = wordCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
