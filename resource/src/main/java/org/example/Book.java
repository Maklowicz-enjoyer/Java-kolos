package org.example;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class Book extends CommonBase {
    @Size(max = 120, message = "nazwa książki musi mieć maksymalnie 120 znakow")
    private String bookName;
    @Size(max = 100, message = "imie autora nie może być dłuższe niż 100 znaków")
    private String author;

    private int minAge;




    // getters


    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getMinAge() {
        return minAge;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public Book(String bookName, String author, int minAge) {
        this.bookName = bookName;
        this.author = author;
        this.minAge = minAge;
    }
}
