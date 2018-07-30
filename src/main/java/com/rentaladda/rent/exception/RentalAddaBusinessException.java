package com.rentaladda.rent.exception;

public class RentalAddaBusinessException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8780199348531170046L;

	public RentalAddaBusinessException(String str) {
		super(str);
	}
	
	public RentalAddaBusinessException(String str,Throwable cause) {
		super(str,cause);
	}

}
