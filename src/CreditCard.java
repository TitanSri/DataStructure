/**
 * This {@code CreditCard} class defines credit card objects that model a simplified version of traditional credit cards.
 * They store information about the customer, issuing bank, account identifier, credit limit, and current balance. They
 * do not charge interest or late payments, but they do restrict charges that would cause a card's balance to go over its
 * credit limit.
 * @author gdouzwt
 * @author TSrira - Javadoc
 */
public class CreditCard {

    // Instance variables:
    private String customer;    // name of the customer (e.g., "John Bowman")
    private String bank;        // name of the bank (e.g., "California Savings")
    private String account;     // account identifier (e.g., "5391 0375 9387 5309")
    private int limit;          // credit limit (measure in dollars)
    protected double balance;   // current balance (measure in dollars)

    /** Constructors:
     * 
     * @param customer 	name of the customer (e.g., "John Bowman")
     * @param bank		name of the bank (e.g., "California Savings")
     * @param account	account identifier (e.g., "5391 0375 9387 5309")
     * @param limit		credit limit (measure in dollars)
     * @param balance	current balance (measure in dollars)
     */
    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }
    /**
     * 
     * @param customer 	name of the customer
     * @param bank		name of the bank
     * @param account	name of the account
     * @param limit		amount in dollars
     */
    public CreditCard(String customer, String bank, String account, int limit) {
        this(customer, bank, account, limit, 0.0); 
    }
    /**
     * 
     */
    public CreditCard() {

    }

    // Accessor methods:
    /** Gets the customers name
     * 
     * @return customer
     */
    public String getCustomer() {
        return customer;
    }
    /** Gets the banks name
     * 
     * @return bank
     */
    public String getBank() {
        return bank;
    }
    /** Gets the Account name
     * 
     * @return account
     */
    public String getAccount() {
        return account;
    }
    /** Gets the limit amount
     * 
     * @return limit
     */
    public int getLimit() {
        return limit;
    }
    /** Gets the balance amount
     * 
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    //Update methods:
    /** Charges the price
     * 
     * @param price		the amount charges
     * @return if the customer has been charged or not
     */
    public boolean charge(double price) {
        if (price + balance > limit) {
            return false;
        }
        balance += price;
        return true;
    }
    /** Makes a payment amount
     * 
     * @param amount the amount payed
     */
    public void makePayment(double amount) {
        balance -= amount;
    }

    /** Utility method to print a card's information
     * 
     * @param card the card number in the wallet
     */
    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);
    }
    /** The main will create 3 objects and insert them in a wallet
     * charges each object and makes a payment of 200 dollars 
     * then prints the balance
     * @param args default parameter
     */
    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300);

        for (int val = 1; val <= 16; val++) { // loops through from 1 to 16
            wallet[0].charge(3 * val); // charges 3 times the amount in the loop
            wallet[1].charge(2 * val); // charges 2 times the amount in the loop
            wallet[2].charge(val); // charges the amount in the loop
        }

        for (CreditCard card : wallet) {
            CreditCard.printSummary(card);  // calling static method
            while (card.getBalance() > 200.0) { // while the balance is over 200 dollars
                card.makePayment(200); // make a payment of 200 dollars
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }
}