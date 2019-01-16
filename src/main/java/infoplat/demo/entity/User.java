package infoplat.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int iAdminId;
    private String sName;
    private String sTel;
    private String sPwd;
    private Date dtInsert;
    private int iInsertAdmin;
    private Date dtUpdate;
    private int iUpdateAdmin;
    private int iRoleId;

}

