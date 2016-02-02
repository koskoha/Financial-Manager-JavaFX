package Model;

import Model.Account;

import java.util.Set;

public interface DataStore {
    // return null if no such user
    User getUser(String name);
    // If no users, return empty collection (not null)
    Set<String> getUserNames();
    // If no accounts, return empty collection (not null)
    Set<Account> getAccounts(User owner);
    // If no records, return empty collection (not null)
    Set<Record> getRecords(Account account);
    void addUser(User user);
    void addAccount(User user, Account account);
    void addRecord(Account account, Record record);
    // return removed User or null if no such user
    User removeUser(String name);
    // return null if no such account
    Account removeAccount(User owner, Account account);
    // return null if no such record
    Record removeRecord(Account from, Record record);

    void addCategory(Category category);

    Set<Category> getCategories(Record record);

    Category removeCategory(Category category);
}
