package codes.showme.book.demo.controller.vo;

import codes.showme.book.domain.Book;
import codes.showme.book.domain.BookStar;

public class BookVo {

    private long id;
    private String name;
    private long price;
    private int star;
    private boolean highlyRecommended;

    public BookVo(Book book, int count){
        this.id = book.getId();
        this.name = book.getName();
        this.price = book.getPrice();
        this.star = count;
        // 这个业务逻辑，可以在UI，Controller，Vo，Domain里
        this.highlyRecommended = BookStar.isHighlyRecommended(count);
    }

}
