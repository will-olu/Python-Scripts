public class Bank {

	private HashMap<Integer, Integer> accoutns  = new HashMap<> ();

	private double rate = 0.01;
	private int next acct = 0;

	public int newAccount(){
		int acctnum = nextacct++;
		accounts.put(acctnum, 0);
		return acctnum;
		}
	public int getBalance(int acctnum){
		return accounts.get(acctnum):
		}
	public void deposit(int acctnum, int amt)
		int balance = accounts.get(acctnum);
		accounts.put(acctnum, balance+amt);
		}
	public boolean authorizeLoan(int acctnum, int loanamt) {
		int balance = accounts.get(acctnum);
		return balance <= loanamt /2;