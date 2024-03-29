package cool.chinalanguagegame.android.utils;

import android.text.TextUtils;

import cool.chinalanguagegame.android.bean.CurrentUser;
import cool.chinalanguagegame.android.constants.AppConstant;

public class CurrentUserHelper {

    private static CurrentUserHelper currentUserHelper;

    private CurrentUser mUser;

    public static CurrentUserHelper getInstance() {
        if (currentUserHelper == null) {
            synchronized (CurrentUserHelper.class) {
                if (currentUserHelper == null) {
                    currentUserHelper = new CurrentUserHelper();
                }
            }
        }
        return currentUserHelper;
    }

    public boolean hasLogin() {
        return getCurrentUser() != null;
    }

    public CurrentUser getCurrentUser() {
        if (mUser == null) {
            synchronized (this) {
                if (mUser == null) {
                    String json = SharedPrefUtils.getInstance().getString(AppConstant.SharedPreferenceKey.CURRENT_USER);
                    CurrentUser currentUser = !TextUtils.isEmpty(json) ? GsonConverter.fromJson(json, CurrentUser.class) : null;
                    mUser = currentUser;
                }
            }
        }
        return mUser;
    }

    public void updateCurrentUser(CurrentUser currentUser) {
        CurrentUser old = mUser;
        mUser = currentUser;
        if (currentUser != null) {
            SharedPrefUtils.getInstance().putString(AppConstant.SharedPreferenceKey.CURRENT_USER, GsonConverter.toJson(currentUser));
        } else {
            SharedPrefUtils.getInstance().removeValue(AppConstant.SharedPreferenceKey.CURRENT_USER);
        }
    }

    public void updateCurrentUser(String jason) {
        if (!TextUtils.isEmpty(jason)) {
            SharedPrefUtils.getInstance().putString(AppConstant.SharedPreferenceKey.CURRENT_USER, jason);
        }
    }
}
