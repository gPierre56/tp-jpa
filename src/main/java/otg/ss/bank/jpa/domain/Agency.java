package otg.ss.bank.jpa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Agency implements Serializable {
	
	private Long id;
	private String code;
	private Address address;
	private Set<Account> accounts;
	private Set<Transaction> transactions;
	
	public Agency() {
		address = new Address();
		accounts = new HashSet<>();
		transactions = new HashSet<>();
	}
	
	public Agency( String code, Address address ) {
		this();
		this.code = code;
		this.address = address;
	}
	
	public Agency( Long id, String code, Address address ) {
		this();
		this.id = id;
		this.code = code;
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId( Long id ) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode( String code ) {
		this.code = code;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress( Address address ) {
		this.address = address;
	}
	
	public Set<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts( Set<Account> accounts ) {
		this.accounts = accounts;
	}
	
	public void addAccount( Account account ) {
		account.setAgency( this );
	}
	
	public void removeAccount( Account account ) {
		account.setAgency( null );
	}
	
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions( Set<Transaction> transactions ) {
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer( "Agency{" );
		sb.append( "id=" ).append( id );
		sb.append( ", code='" ).append( code ).append( '\'' );
		sb.append( ", address=" ).append( address );
		sb.append( '}' );
		return sb.toString();
	}
}