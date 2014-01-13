package caffeine.bases;

import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BasePreferenceUtil
{
	private SharedPreferences _sharedPreferences;
	
	
	protected BasePreferenceUtil(Context $context)
	{
		super();
		_sharedPreferences = PreferenceManager.getDefaultSharedPreferences($context);
	}
	
	
	private SharedPreferences.Editor editor()
	{
		return _sharedPreferences.edit();
	}
	
	
	/**
	 * key 수동 설정
	 * 
	 * @param key
	 *            키 값
	 * @param value
	 *            내용
	 */
	protected void put(String $key, String $value)
	{
		editor().putString($key, $value).commit();
	}
	
	
	/**
	 * String 값 가져오기
	 * 
	 * @param key
	 *            키 값
	 * @return String (기본값 null)
	 */
	protected String get(String $key)
	{
		return _sharedPreferences.getString($key, null);
	}
	
	
	/**
	 * key 설정
	 * 
	 * @param key
	 *            키 값
	 * @param value
	 *            내용
	 */
	protected void put(String $key, boolean $value)
	{
		editor().putBoolean($key, $value).commit();
	}
	
	
	/**
	 * Boolean 값 가져오기
	 * 
	 * @param key
	 *            키 값
	 * @param defValue
	 *            기본값
	 * @return Boolean
	 */
	protected boolean get(String $key, boolean $default)
	{
		return _sharedPreferences.getBoolean($key, $default);
	}
	
	
	/**
	 * key 설정
	 * 
	 * @param key
	 *            키 값
	 * @param value
	 *            내용
	 */
	protected void put(String $key, int $value)
	{
		editor().putInt($key, $value).commit();
	}
	
	
	/**
	 * int 값 가져오기
	 * 
	 * @param key
	 *            키 값
	 * @param defValue
	 *            기본값
	 * @return int
	 */
	protected int get(String $key, int $default)
	{
		return _sharedPreferences.getInt($key, $default);
	}
	
	
	/**
	 * HashSet 저장
	 * 
	 * @param $key
	 *            키 값
	 * @param $set
	 *            내용
	 */
	protected void put(String $key, Set<String> $set)
	{
		editor().putStringSet($key, $set).commit();
	}
	
	
	/**
	 * HashSet 가져오기
	 * 
	 * @param $key
	 *            키 값
	 * @return
	 */
	protected Set<String> getStringSet(String $key)
	{
		return _sharedPreferences.getStringSet($key, null);
	}
}
