package domain;

import javax.persistence.*;

@Entity
@Table(name="book_data3")
public class Book3
{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator = "book_generator")
	@SequenceGenerator(name="book_generator",sequenceName = "book_seq" ,initialValue=20 )
	@Column(name="book_id")
	private int bookId;
	                                 /* it  maintain the sequence if we use only GenerationType.SEQUENCE.
	                                  * but if  we want to costomize the intial value and increse by value
									  *  then go for SequenceGenerator  anotaion. 
									  */
	
									/* if we asssign GenerationType.SEQUENCE with initial value only
									 * but not provoid increase by value i.e allocationsize then it 
									 *  provoides any random number in database table.
									 */
	
									/*it is used to maintain sequence for dedicated table only ,not 
									 * for entire database.
									 */
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="book_price")
	private double bookPrice;
	
	public int getBookId() 
	{
		return bookId;
	}
	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
	}
	public String getBookName() 
	{
		return bookName;
	}
	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}
	public double getBookPrice() 
	{
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) 
	{
		this.bookPrice = bookPrice;
	}
	
	
}
