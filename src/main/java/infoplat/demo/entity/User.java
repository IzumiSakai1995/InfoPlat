package infoplat.demo.entity;

import lombok.Data;

import java.sql.Date;


@Data
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

    public User(){

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

}
class TestUser{
    public static void main(String[] args) {
        User user= new User();
    }
}
