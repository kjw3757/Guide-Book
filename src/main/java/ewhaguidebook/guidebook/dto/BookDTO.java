package ewhaguidebook.guidebook.dto;

import ewhaguidebook.guidebook.entity.BookEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDTO {
    private Long id;
    private String bookName;
    private String bookPublisher;
    private String bookAuthor;
    private String bookGenre;
    private String bookDifficulty;
    private String bookISBN;
    private String bookKeyword;

    public static BookDTO toBookDTO(BookEntity bookEntity) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(bookEntity.getId());
        bookDTO.setBookName(bookEntity.getBookName());
        bookDTO.setBookPublisher(bookEntity.getBookPublisher());
        bookDTO.setBookAuthor(bookEntity.getBookAuthor());
        bookDTO.setBookGenre(bookEntity.getBookGenre());
        bookDTO.setBookDifficulty(bookEntity.getBookDifficulty());
        bookDTO.setBookISBN(bookEntity.getBookISBN());
        bookDTO.setBookKeyword(bookEntity.getBookKeyword());
        return bookDTO;
    }
}
