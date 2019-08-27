package otg.ss.bank.jpa.domain;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
	
	private TransactionId id;
	private Type type;
	private double amount;
	private double balanceBefore;
	private double balanceAfter;
	
	private Account account;
	private Agency agency;
	
	public Transaction() {}
	
	public Transaction( Type type, Date date, double amount, double balanceBefore ) {
		this.type = type;
		this.amount = amount;
		this.balanceBefore = balanceBefore;
	}
	
	public Transaction( Type type, double balanceBefore, double balanceAfter ) {
		this.type = type;
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
	}
	
	public Transaction( TransactionId id, Type type, double balanceBefore, double balanceAfter ) {
		this.id = id;
		this.type = type;
		this.balanceBefore = balanceBefore;
		this.balanceAfter = balanceAfter;
	}
	
	public TransactionId getId() {
		return id;
	}
	
	public void setId( TransactionId id ) {
		this.id = id;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType( Type type ) {
		this.type = type;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount( double amount ) {
		this.amount = amount;
	}
	
	public double getBalanceBefore() {
		return balanceBefore;
	}
	
	public void setBalanceBefore( double balanceBefore ) {
		this.balanceBefore = balanceBefore;
	}
	
	public double getBalanceAfter() {
		return balanceAfter;
	}
	
	public void setBalanceAfter( double balanceAfter ) {
		this.balanceAfter = balanceAfter;
	}
	
	public Agency getAgency() {
		return agency;
	}
	
	public void setAgency( Agency agency ) {
		this.agency = agency;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount( Account account ) {
		if ( this.account != null ) {
			this.account.getTransactions().remove( this );
		}
		this.account = account;
		if ( this.account != null ) {
			this.account.getTransactions().add( this );
		}
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder( "Transaction{" );
		sb.append( "id=" ).append( id );
		sb.append( ", type=" ).append( type );
		sb.append( ", amount=" ).append( amount );
		sb.append( ", balanceBefore=" ).append( balanceBefore );
		sb.append( ", balanceAfter=" ).append( balanceAfter );
		sb.append( ", agency=" ).append( agency );
		sb.append( ", account=" ).append( account );
		sb.append( '}' );
		return sb.toString();
	}
	
	public enum Type {
		IPM( "Versement initial" ), PM( "Versement" ), DM( "Retrait" ), SIM( "Interêt" );
		
		private String value;
		
		private Type( String value ) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
}
