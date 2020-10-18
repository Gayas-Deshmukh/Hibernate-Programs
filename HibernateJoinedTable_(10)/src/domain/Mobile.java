package domain;

import javax.persistence.*;

@Entity
@Table(name = "mobile_data")
@PrimaryKeyJoinColumn(name="id")

public class Mobile extends Product
{
	@Column(name = "mobile_brand")
	private String mobilrBrand;
	
	@Column(name = "os_type")
	private String osType;
	
	public String getMobilrBrand()
	{
		return mobilrBrand;
	}
	public void setMobilrBrand(String mobilrBrand) 
	{
		this.mobilrBrand = mobilrBrand;
	}
	public String getOsType()
	{
		return osType;
	}
	public void setOsType(String osType) 
	{
		this.osType = osType;
	}
	
	
}
