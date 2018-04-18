package search;

import java.text.NumberFormat;

/**
 *
 * @author AezA
 */
public class Entity {

    private double radif;
    private String sharh;
    private double variz;
    private double bardasht;
    private double mojodi;
    private String shobeAmel;
    private String sanadNumber;
    private String checkNumber;
    private String yaddasht;
    private String date;
    private String time;
    
    public short getRadif() {
        return (short) radif;
    }

    public void setRadif(double radif) {
        this.radif = radif;
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSharh() {
        return sharh;
    }

    public void setSharh(String sharh) {
        this.sharh = sharh;
    }

    public String getVariz() {
        return NumberFormat.getInstance().format(variz);
    }

    public void setVariz(double variz) {
        this.variz = variz;
    }

    public double getBardasht() {
        return bardasht;
    }
    
    public String getBardashtInString() {
        return NumberFormat.getInstance().format(bardasht);
    }
    

    public void setBardasht(double bardasht) {
        this.bardasht = bardasht;
    }

    public String getMojodi() {
        return NumberFormat.getInstance().format(mojodi);
    }

    public void setMojodi(double mojodi) {
        this.mojodi = mojodi;
    }

    public String getShobeAmel() {
        return shobeAmel;
    }

    public void setShobeAmel(String shobeAmel) {
        this.shobeAmel = shobeAmel;
    }

    public String getSanadNumber() {
        return sanadNumber;
    }

    public void setSanadNumber(String sanadNumber) {
        this.sanadNumber = sanadNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getYaddasht() {
        return yaddasht;
    }

    public void setYaddasht(String yaddasht) {
        this.yaddasht = yaddasht;
    }
}
