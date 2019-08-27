package otg.ss.bank.jpa.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TransactionId implements Serializable {
	
	private Long accountId;
	private Long agencyId;
	private Date date;
	
	public TransactionId() {}
	
	public Long getAgencyId() {
		return agencyId;
	}
	
	public void setAgencyId( Long agencyId ) {
		this.agencyId = agencyId;
	}
	
	public Long getAccountId() {
		return accountId;
	}
	
	public void setAccountId( Long accountId ) {
		this.accountId = accountId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate( Date date ) {
		this.date = date;
	}
	
	@Override
	public boolean equals( Object o ) {
		if ( this == o ) return true;
		if ( !(o instanceof TransactionId) ) return false;
		TransactionId that = ( TransactionId ) o;
		return Objects.equals( agencyId, that.agencyId ) && Objects.equals( accountId, that.accountId ) && Objects
				.equals( date, that.date );
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash( agencyId, accountId, date );
	}
}
