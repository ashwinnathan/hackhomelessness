package test.asdf;

import android.app.Application;

/**
 * Created by Vinay on 9/25/2016.
 */

public class GlobalVar extends Application {
    private String mGlobalVarValue;

    public String getGlobalVarValue() {
        return mGlobalVarValue;
    }

    public void setGlobalVarValue(String str) {
        mGlobalVarValue = str;
    }
}
