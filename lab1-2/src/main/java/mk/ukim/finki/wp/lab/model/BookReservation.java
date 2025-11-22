package mk.ukim.finki.wp.lab.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReservation {
    String bookTitle;
    String readerName;
    String readerAddress;
    Long numberOfCopies;
}
