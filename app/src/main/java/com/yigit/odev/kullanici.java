package com.yigit.odev;

import android.net.Uri;

import java.util.Date;

public class kullanici {
     String kadi;
    String password;
    String UID;
     Uri homedizi;
     Date tarih;

    public kullanici(String kadi, String password) {
        this.kadi = kadi;
        this.password = password;
    }


    public String getKadi() {
        return kadi;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public Uri getHomedizi() {
        return homedizi;
    }

    public void setHomedizi(Uri homedizi) {
        this.homedizi = homedizi;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }
}
