package unip.com.br.util;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by Cleber on 13/11/2015.
 */
public class ApplicationUtils {

    public static  boolean isMyApplicationTaskOnTop(Context context){
        String packageName = context.getPackageName();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);

        if(recentTasks != null && recentTasks.size() > 0){
            ActivityManager.RunningTaskInfo t = recentTasks.get(0);
            String pack = t.baseActivity.getPackageName();
            if(pack.equals(packageName)){
                return true;
            }
        }
        return false;
    }
}
