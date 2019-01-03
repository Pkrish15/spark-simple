/**
 * 
 */
package com.redhat.gpte;

import java.io.Serializable;

/**
 * @author prakrish
 *
 */
public class MovieData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String slno;
	private String name;
	private String year;
	private String rating;
	private String viewers;
	
	
	public MovieData(String _slno,String _name, String _year, String _rating, String _viewers )
	
	{
		_slno=slno;
		_name=name;
		_year=year;
		_rating=rating;
		_viewers=viewers;
	}
	
	

}
