package Model;

import java.util.Comparator;
import java.util.Objects;

public class Account implements Comparable<Account> {
    private int acc_id;
    private String description;
    private int balance;
    private String userName;

    public Account(int acc_id, String description, int balance, String userOwner) {
        this.acc_id = acc_id;
        this.description = description;
        this.balance = balance;
        this.userName = userOwner;
    }

    public Account(int i, String text, int i1) {
        acc_id=i;
        description = text;
        balance = i1;
        userName = "";

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    @Override
    public String toString() {
        return acc_id +". " + description;
    }


    @Override
    public int compareTo(Account o) {
        if (this.getAcc_id()>o.getAcc_id())
            return 1;
        else if (this.getAcc_id()<o.getAcc_id())
            return -1;
        return 0;
    }
}
