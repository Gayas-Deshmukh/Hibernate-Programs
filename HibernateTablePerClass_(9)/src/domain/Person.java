package domain;

import javax.persistence.*;

/* do not create any table in database ,tables are created automaically in database
depending on number of classes*/

@Entity
@Table(name="person_data")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person 
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="person_id")
     private int personId;
	
	@Column(name="person_name")
     private String personName;
	
	@Column(name="person_email")
     private String personEmail;

	public int getPersonId()
	{
		return personId;
	}

	public void setPersonId(int personId)
	{
		this.personId = personId;
	}

	public String getPersonName() 
	{
		return personName;
	}

	public void setPersonName(String personName)
	{
		this.personName = personName;
	}

	public String getPersonEmail()
	{
		return personEmail;
	}

	public void setPersonEmail(String personEmail) 
	{
		this.personEmail = personEmail;
	}
    
     
     
     
}
