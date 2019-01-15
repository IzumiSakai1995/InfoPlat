package infoplat.demo.entity;

import java.sql.Date;

public class User {
    private int iAdminId;
    private String sName;
    private String sTel;
    private String sPwd;
    private Date dtInsert;
    private int iInsertAdmin;
    private Date dtUpdate;
    private int iUpdateAdmin;
    private int iRole;

    @Override
    public String toString() {
        return "User{" +
                "iAdminId=" + iAdminId +
                ", sName='" + sName + '\'' +
                ", sTel='" + sTel + '\'' +
                ", sPwd='" + sPwd + '\'' +
                ", dtInsert=" + dtInsert +
                ", iInsertAdmin=" + iInsertAdmin +
                ", dtUpdate=" + dtUpdate +
                ", iUpdateAdmin=" + iUpdateAdmin +
                ", iRole=" + iRole +
                '}';
    }

    public User() {
    }

    public User(int iAdminId, String sName, String sTel, String sPwd, Date dtInsert, int iInsertAdmin, Date dtUpdate, int iUpdateAdmin, int iRole) {
        this.iAdminId = iAdminId;
        this.sName = sName;
        this.sTel = sTel;
        this.sPwd = sPwd;
        this.dtInsert = dtInsert;
        this.iInsertAdmin = iInsertAdmin;
        this.dtUpdate = dtUpdate;
        this.iUpdateAdmin = iUpdateAdmin;
        this.iRole = iRole;
    }

    public void setiAdminId(int iAdminId) {
        this.iAdminId = iAdminId;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public void setDtInsert(Date dtInsert) {
        this.dtInsert = dtInsert;
    }

    public void setiInsertAdmin(int iInsertAdmin) {
        this.iInsertAdmin = iInsertAdmin;
    }

    public void setDtUpdate(Date dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public void setiUpdateAdmin(int iUpdateAdmin) {
        this.iUpdateAdmin = iUpdateAdmin;
    }

    public void setiRole(int iRole) {
        this.iRole = iRole;
    }
}
