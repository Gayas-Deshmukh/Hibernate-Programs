package domain;
// Domain Class or Java Bean Class or POJO class
public class Student_1
{
	private  int studentId;
	private String studentName;
	private String studentStream;
	private double studentPercentage;

	public int getStudentId()
	{
		return studentId;
	}
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}
	public String getStudentName() 
	{
		return studentName;
	}
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	public String getStudentStream()
	{
		return studentStream;
	}
	public void setStudentStream(String studentStream)
	{
		this.studentStream = studentStream;
	}
	public double getStudentPercentage() 
	{
		return studentPercentage;
	}
	public void setStudentPercentage(double studentPercentage) 
	{
		this.studentPercentage = studentPercentage;
	}


}
