class Account
 {
 private int balance;
 public Account(int b) { balance = b; }
 public void withdraw(int amt) { balance -= amt; }
 public int getBalance() { return balance; }
 public boolean equals(Object otherObj)
 {
    if(this==otherObj)return true;
    if(otherObj==null)return false;
    if(getClass()!=otherObj.getClass()) return false;
    Account other =(Account) otherObj;
    return this.balance==other.balance;
 }
 }