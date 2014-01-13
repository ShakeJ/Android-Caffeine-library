package caffeine.utils;

import android.content.Context;
import caffeine.bases.BasePreferenceUtil;

/**
 * sample code.
 * 
 * @author susemi99
 */
public class TestPreferenceUtil extends BasePreferenceUtil
{
	private static TestPreferenceUtil _instance = null;
	
	private static final String PROPERTY_REG_ID = "registration_id";
	private static final String PROPERTY_APP_VERSION = "appVersion";
	
	
	public static synchronized TestPreferenceUtil instance(Context $context)
	{
		if (_instance == null)
			_instance = new TestPreferenceUtil($context);
		return _instance;
	}
	
	
	protected TestPreferenceUtil(Context $context)
	{
		super($context);
	}
	
	
	public void putRedId(String $regId)
	{
		put(PROPERTY_REG_ID, $regId);
	}
	
	
	public String regId()
	{
		return get(PROPERTY_REG_ID);
	}
	
	
	public void putAppVersion(int $appVersion)
	{
		put(PROPERTY_APP_VERSION, $appVersion);
	}
	
	
	public int appVersion()
	{
		return get(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
	}
}
