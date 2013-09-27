package caffeine.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class NetworkUtil
{
   
   /**
    * Mac Address 가져오기 (Wi-Fi가 연결이 되지 않으면 가져오지 못함) <br>
    * Get Mac address. <br>
    * (if Wi-Fi not on, dont get)
    * @param context
    * @return
    */
   public static String macAddress(Context context)
   {
      WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
      WifiInfo wifiInfo = wifiManager.getConnectionInfo();
      return wifiInfo.getMacAddress();
   }
   
}
