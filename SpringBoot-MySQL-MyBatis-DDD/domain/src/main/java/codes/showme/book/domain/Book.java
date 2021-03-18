package codes.showme.book.domain;

import codes.showme.book.repository.BookRepository;
import codes.showme.tech.ioc.InstanceFactory;

import java.util.List;

public class Book {

    private Integer id;

    private String name;

    private Integer price;

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
        BookRepository repository = InstanceFactory.getInstance(BookRepository.class);
        return repository.save(this);
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



}
