package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Model implements DataStore {

    @Override
    public User getUser(String name) {
        String password;
        try {
            password = DbHelper.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM users WHERE name =\"" + name + "\";").getString("password");
        } catch (SQLException e) {
            return null;
        }
        return new User(name, password);
    }

    @Override
    public Set<String> getUserNames() {
        Set<String> usersNames = new TreeSet<>();
        ResultSet resultSet;
        try {
            resultSet = DbHelper.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM users;");
            while (resultSet.next()) {
                usersNames.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersNames;
    }

    @Override
    public Set<Account> getAccounts(User owner) {
        Set<Account> accounts = new TreeSet<>();
        ResultSet resultSet;
        try {
            resultSet = DbHelper.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM accounts WHERE user_name = \"" + owner.getLogin() + "\";");
            while (resultSet.next()) {
                int acc_id = resultSet.getInt("ACCOUNT_ID");
                int balance = resultSet.getInt("BALLANCE");
                String description = resultSet.getString("DESCRIPTION");

                accounts.add(new Account(acc_id, description, balance, owner.getLogin()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(accounts);
        return accounts;
    }

/*    public Account getAccountFromName(String name) {
        ResultSet resultSet;
        int id = 0;
        int ball = 0;
        String userName = null;
        try {
            resultSet = DbHelper.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM accounts WHERE description = \"" + name + "\";");
            id = resultSet.getInt("ACCOUNT_ID");
            ball = resultSet.getInt("BALLANCE");
            userName = resultSet.getString("USER_NAME");
        } catch (SQLException e) {
            System.out.println("Error in removing Category");
            e.printStackTrace();
        }
        return new Account(id,name,ball,userName);
    }*/

    @Override
    public Set<Record> getRecords(Account account) {
        Set<Record> records = new HashSet<>();
        ResultSet resultSet;
        try {
            resultSet = DbHelper.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM records WHERE ACCOUNT_ID = \"" + account.getAcc_id() + "\";");
            while (resultSet.next()) {
                int recordID = resultSet.getInt("RECORD_ID");
                String descr = resultSet.getString("DESCRIPTION");
                int ammount = resultSet.getInt("AMOUNT");
                int isPut = resultSet.getInt("IS_PUT");
                int category = resultSet.getInt("CATEGORY_ID");
                String date = resultSet.getString("RECORD_DATE");
                records.add(new Record(recordID, isPut, date, ammount, descr, account.getDescription(), category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(records.size());
        return records;
    }

    @Override
    public Set<Category> getCategories(Record record) {
        Set<Category> category = new HashSet<>();
        ResultSet resultSet;
        try {
            resultSet = DbHelper.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM categories WHERE ID = \"" + record.getCatID() + "\";");
            while (resultSet.next()) {
                int catID = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                category.add(new Category(catID, name));
            }
        } catch (SQLException e) {
            System.out.println("Error in get categories");
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void addUser(User user) {
        try {
            DbHelper.getInstance().getConnection().createStatement().executeUpdate("INSERT OR REPLACE INTO users (name,password) Values(\"" + user.getLogin() + "\",\"" + user.getPassword() + "\");");
        } catch (SQLException e) {
            System.out.println("Error in adding User");
            e.printStackTrace();
        }
    }

    @Override
    public void addAccount(User user, Account account) {
        try {
            DbHelper.getInstance().getConnection().createStatement().executeUpdate("INSERT OR REPLACE INTO accounts (ballance,description, user_name)" +
                    " values(\"" + account.getBalance() + "\",\"" + account.getDescription() + "\",\"" + user.getLogin() + "\");");
        } catch (SQLException e) {
            System.out.println("Error in adding Account");
            e.printStackTrace();
        }
    }

    @Override
    public void addRecord(Account account, Record record) {
        try {
            DbHelper.getInstance().getConnection().createStatement().executeUpdate("INSERT OR REPLACE INTO records (record_date,description, amount, is_put, category_id, account_id) values" +
                    " values(\"" + record.getDate() + "\",\"" + record.getDescription() + "\",\"" + record.getAmount() + "\",\"" + record.getIsPut() + "\",\"" + record.getCatID() + "\",\"" + account.getAcc_id() + "\");");
        } catch (SQLException e) {
            System.out.println("Error in adding Record");
            e.printStackTrace();
        }
    }

    @Override
    public void addCategory(Category category) {
        try {
            DbHelper.getInstance().getConnection().createStatement().executeUpdate("INSERT OR REPLACE INTO categories (id,name) values(\"" + category.getID() + "\",\"" + category.getName() + "\");");
        } catch (SQLException e) {
            System.out.println("Error in adding Category");
            e.printStackTrace();
        }
    }

    @Override
    public User removeUser(String name) {
        User user = getUser(name);
        try {
            DbHelper.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM users WHERE name  = \"" + name + "\";");
        } catch (SQLException e) {
            System.out.println("Error in removing User");
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Account removeAccount(User owner, Account account) {
        try {
            DbHelper.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM accounts WHERE user_name  = \"" + owner.getLogin() + "\" AND ACCOUNT_ID = \"" + account.getAcc_id() + "\";");
        } catch (SQLException e) {
            System.out.println("Error in removing Account");
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Record removeRecord(Account from, Record record) {
        try {
            DbHelper.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM records WHERE RECORD_ID  = \"" + record.getRec_ID() + "\" AND ACCOUNT_ID = \"" + from.getAcc_id() + "\";");
        } catch (SQLException e) {
            System.out.println("Error in removing Record");
            e.printStackTrace();
        }
        return record;
    }

    @Override
    public Category removeCategory(Category category) {
        try {
            DbHelper.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM categories WHERE id  = \"" + category.getID() + "\";");
        } catch (SQLException e) {
            System.out.println("Error in removing Category");
            e.printStackTrace();
        }
        return category;
    }

}
