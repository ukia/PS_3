package exceptions;

import pkgLibrary.Book;

public class BookException extends Exception{
	private Book WrongBook;
	
	public BookException(Book b){
		WrongBook= b;
	}
	public Book getErrorBook() {
		return WrongBook;
	}
}
