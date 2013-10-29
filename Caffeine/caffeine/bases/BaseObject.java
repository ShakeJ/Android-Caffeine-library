package caffeine.bases;

import java.lang.reflect.Method;

import android.graphics.drawable.BitmapDrawable;

public class BaseObject
{
   public Object callTarget = null;
   public String callMethod = null;
   
   
   public void registerCallback(Object target, String method)
   {
      callTarget = target;
      callMethod = method;
   }
   
   
   public void unregisterCallback()
   {
      callTarget = null;
      callMethod = null;
   }
   
   
   protected void invokeCallback()
   {
      invokeCallback(callTarget, callMethod);
   }
   
   
   protected void invokeCallback(String target)
   {
      
      if (callTarget == null || callMethod == null)
         return;
      try
      {
         Class<?> kClass = callTarget.getClass();
         Class<?> kTypes[] = new Class[] { String.class };
         Method kInvocation = kClass.getMethod(callMethod, kTypes);
         kInvocation.invoke(callTarget, target);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   protected void invokeCallback(Object target)
   {
      
      if (callTarget == null || callMethod == null)
         return;
      try
      {
         Class<?> kClass = callTarget.getClass();
         Class<?> kTypes[] = new Class[] { Object.class };
         Method kInvocation = kClass.getMethod(callMethod, kTypes);
         kInvocation.invoke(callTarget, target);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   protected void invokeCallback(boolean target)
   {
      
      if (callTarget == null || callMethod == null)
         return;
      try
      {
         Class<?> kClass = callTarget.getClass();
         Class<?> kTypes[] = new Class[] { Boolean.class };
         Method kInvocation = kClass.getMethod(callMethod, kTypes);
         kInvocation.invoke(callTarget, target);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   protected void invokeCallback(BitmapDrawable $content)
   {
      
      if (callTarget == null || callMethod == null)
         return;
      try
      {
         Class<?> kClass = callTarget.getClass();
         Class<?> kTypes[] = new Class[] { BitmapDrawable.class };
         Method kInvocation = kClass.getMethod(callMethod, kTypes);
         kInvocation.invoke(callTarget, $content);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   protected void invokeCallback(String $name, String $value)
   {
      if (callTarget == null || callMethod == null)
         return;
      try
      {
         Class<?> kClass = callTarget.getClass();
         Class<?> kTypes[] = new Class[] { String.class, String.class };
         Method kInvocation = kClass.getMethod(callMethod, kTypes);
         kInvocation.invoke(callTarget, $name, $value);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   protected void invokeCallback(int $int)
   {
      if (callTarget == null || callMethod == null)
         return;
      try
      {
         Class<?> kClass = callTarget.getClass();
         Class<?> kTypes[] = new Class[] { int.class };
         Method kInvocation = kClass.getMethod(callMethod, kTypes);
         kInvocation.invoke(callTarget, $int);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   protected void invokeCallback(Object $target, String $method)
   {
      if ($target == null || $method == null)
         return;
      
      try
      {
         Class<?> kClass = $target.getClass();
         Method kInvocation = kClass.getMethod($method);
         kInvocation.invoke($target);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
