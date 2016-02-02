package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Record {
    private int rec_ID;
    private int isPut;
    private String date;
    private int amount;
    private String description;
    private String accountName;
    private int catID;

    public Record(int rec_ID, int isPut, String date, int amount, String description, String accountName, int catID) {
        this.rec_ID = rec_ID;
        this.isPut = isPut;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.accountName = accountName;
        this.catID = catID;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public int getRec_ID() {
        return rec_ID;
    }

    public void setRec_ID(int rec_ID) {
        this.rec_ID = rec_ID;
    }

    public int getIsPut() {
        return isPut;
    }

    public void setIsPut(int isPut) {
        this.isPut = isPut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }



    @Override
    public String toString() {
        return "Record{" +
                "rec_ID=" + rec_ID +
                ", isPut=" + isPut +
                ", date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", accountName='" + accountName + '\'' +
                ", catID=" + catID +
                '}';
    }
}
