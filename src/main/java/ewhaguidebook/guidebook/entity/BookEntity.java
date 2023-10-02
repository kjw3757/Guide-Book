package ewhaguidebook.guidebook.entity;

import ewhaguidebook.guidebook.dto.BookDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "book_table")
public class BookEntity {
    @Id // pk 지정
    private Long id;

    @Column(unique = true)  // unique 제약조건 추가
    private String bookName;

    @Column
    private String bookPublisher;

    @Column
    private String bookAuthor;

    @Column
    private String bookGenre;

    @Column
    private String bookDifficulty;

    @Column
    private String bookISBN;

    @Column
    private String bookKeyword;

    public static BookEntity toBookEntity(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDTO.getId());
        bookEntity.setBookName(bookDTO.getBookName());
        bookEntity.setBookPublisher(bookDTO.getBookPublisher());
        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
        bookEntity.setBookGenre(bookDTO.getBookGenre());
        bookEntity.setBookDifficulty(bookDTO.getBookDifficulty());
        bookEntity.setBookISBN(bookDTO.getBookISBN());
        bookEntity.setBookKeyword(bookDTO.getBookKeyword());
        return bookEntity;
    }

    public static BookEntity toUpdateBookEntity(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDTO.getId());
        bookEntity.setBookName(bookDTO.getBookName());
        bookEntity.setBookPublisher(bookDTO.getBookPublisher());
        bookEntity.setBookAuthor(bookDTO.getBookAuthor());
        bookEntity.setBookGenre(bookDTO.getBookGenre());
        bookEntity.setBookDifficulty(bookDTO.getBookDifficulty());
        bookEntity.setBookISBN(bookDTO.getBookISBN());
        bookEntity.setBookKeyword(bookDTO.getBookKeyword());
        return bookEntity;
    }
}
