package codes.showme.book.domain;

import codes.showme.book.repository.BookStarRepository;
import codes.showme.tech.ioc.InstanceFactory;

public class BookStar {

    public static final int MAX_STAR = 5;
    public static final int MIN_STAR = 1;
    private long uid;

    private long bookId;

    private int start;

    public BookStar(long uid, long bookId, int start) {
        this.uid = uid;
        this.bookId = bookId;
        this.start = Math.max(Math.min(start, MAX_STAR), MIN_STAR);
    }

    public static int agvCount(long bookId){
        BookStarRepository bookStarRepository = InstanceFactory.getInstance(BookStarRepository.class);
        return bookStarRepository.getAverageStartCount(bookId);
    }

    public static boolean isHighlyRecommended(int count) {
        return MAX_STAR == count;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
