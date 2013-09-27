package caffeine.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class DialogUtil
{
   private static Dialog _dialog;
   
   
   /**
    * 팝업창 띄우기 <br>
    * Show dialog
    * @param context
    * @param msg
    */
   public static void show(Context context, CharSequence msg)
   {
      show(context, "", msg);
   }
   
   
   /**
    * 팝업창 띄우기 <br>
    * Show dialog contain title
    * @param context
    * @param title 제목
    * @param msg 내용
    */
   public static void show(Context context, CharSequence title, CharSequence msg)
   {
      show(context, title, msg, null);
   }
   
   
   /**
    * 팝업창 띄우기 <br>
    * Show dialog contain title, confirm listener
    * @param context
    * @param title 제목
    * @param msg 내용
    * @param confirmListener 버튼 눌렀을 때
    */
   public static void show(Context context, CharSequence title, CharSequence msg, DialogInterface.OnClickListener confirmListener)
   {
      show(context, title, msg, confirmListener, null);
   }
   
   
   /**
    * 팝업창 띄우기 <br>
    * Show dialog contain title, confirm listener, cancel listener
    * @param context
    * @param title 제목
    * @param msg 내용
    * @param confirmListener ok 버튼 눌렀을 때
    * @param cancelListener cancel 버튼 눌렀을 때
    */
   public static void show(Context context, CharSequence title, CharSequence msg, DialogInterface.OnClickListener confirmListener, DialogInterface.OnClickListener cancelListener)
   {
      show(context, title, msg, confirmListener, "", cancelListener, "");
   }
   
   
   /**
    * 팝업창 띄우기 <br>
    * Show dialog contain title, confirm listener, confirm button title, cancel
    * listener, cancel button title
    * @param context
    * @param title 제목
    * @param msg 내용
    * @param confirmListener ok 버튼 눌렀을 때
    * @param confirmTitle ok 버튼 제목
    * @param cancelListener cancel 버튼 눌렀을 때
    * @param cancelTitle cancel 버튼 제목
    */
   public static void show(Context context, CharSequence title, CharSequence msg, DialogInterface.OnClickListener confirmListener, CharSequence confirmTitle,
         DialogInterface.OnClickListener cancelListener, CharSequence cancelTitle)
   {
      show(context, title, msg, confirmListener, confirmTitle, cancelListener, cancelTitle, -1);
   }
   
   
   /**
    * 팝업창 띄우기 <br>
    * Show dialog contain title, confirm listener, confirm button title, cancel
    * listener, cancel button title (during 'duration')
    * @param context
    * @param title 제목
    * @param msg 내용
    * @param confirmListener ok 버튼 눌렀을 때
    * @param confirmTitle ok 버튼 제목
    * @param cancelListener cancel 버튼 눌렀을 때
    * @param cancelTitle cancel 버튼 제목
    * @param duration 켜져있는 시간(초)
    */
   public static void show(Context context, CharSequence title, CharSequence msg, DialogInterface.OnClickListener confirmListener, CharSequence confirmTitle,
         DialogInterface.OnClickListener cancelListener, CharSequence cancelTitle, int duration)
   {
      try
      {
         if (_dialog != null && _dialog.isShowing())
            _dialog.dismiss();
         
         if (cancelListener != null)
         {
            cancelTitle = TextUtils.isEmpty(cancelTitle) ? context.getText(android.R.string.cancel) : cancelTitle;
            _dialog = new AlertDialog.Builder(context).setTitle(title).setMessage(msg).setPositiveButton(confirmTitle, confirmListener).setNegativeButton(cancelTitle, cancelListener).show();
         }
         else
         {
            confirmTitle = TextUtils.isEmpty(confirmTitle) ? context.getText(android.R.string.ok) : confirmTitle;
            
            if (confirmListener == null)
            {
               confirmListener = new DialogInterface.OnClickListener()
               {
                  
                  @Override
                  public void onClick(DialogInterface dialog, int which)
                  {
                     _dialog.dismiss();
                  }
               };
            }
            
            _dialog = new AlertDialog.Builder(context).setTitle(title).setMessage(msg).setPositiveButton(confirmTitle, confirmListener).show();
         }
         
         _dialog.setCanceledOnTouchOutside(false);
         
         if (duration > 0)
         {
            Runnable runnable = new Runnable()
            {
               @Override
               public void run()
               {
                  _dialog.dismiss();
               }
            };
            Handler handler = new Handler();
            handler.postDelayed(runnable, duration * 1000);
         }
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   /**
    * 입력란이 있는 팝업창 띄우기 <br>
    * Show input-Dialog
    * @param context
    * @param title 제목
    * @param msg 내용
    * @param input 입력을 받을 EditText
    * @param confirmListener ok 버튼 눌렀을 때
    */
   public static void showEditText(Context context, CharSequence title, CharSequence msg, EditText input, DialogInterface.OnClickListener confirmListener)
   {
      showEditText(context, title, msg, input, confirmListener, "", null, "");
   }
   
   
   /**
    * 입력란이 있는 팝업창 띄우기 <br>
    * Show input-Dialog
    * @param context
    * @param title 제목
    * @param msg 내용
    * @param input 입력을 받을 EditText
    * @param confirmListener ok 버튼 눌렀을 때
    * @param confirmTitle ok 버튼 제목
    * @param cancelListener cancel 버튼 눌렀을 때
    * @param cancelTitle cancel 버튼 제목
    */
   public static void showEditText(Context context, CharSequence title, CharSequence msg, EditText input, DialogInterface.OnClickListener confirmListener, CharSequence confirmTitle,
         DialogInterface.OnClickListener cancelListener, CharSequence cancelTitle)
   {
      try
      {
         if (_dialog != null && _dialog.isShowing())
            _dialog.dismiss();
         
         confirmTitle = TextUtils.isEmpty(confirmTitle) ? context.getText(android.R.string.ok) : confirmTitle;
         cancelTitle = TextUtils.isEmpty(cancelTitle) ? context.getText(android.R.string.cancel) : cancelTitle;
         
         _dialog = new AlertDialog.Builder(context).setTitle(title).setMessage(msg).setView(input).setPositiveButton(confirmTitle, confirmListener).setNegativeButton(cancelTitle, cancelListener)
               .setCancelable(false).show();
         
         _dialog.setCanceledOnTouchOutside(false);
         
         // 키보드 바로 보여주기
         input.setOnFocusChangeListener(new View.OnFocusChangeListener()
         {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
               if (hasFocus)
                  _dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
         });
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   /**
    * Keyboard가 자동으로 올라오는 팝업 뷰 <br>
    * Show Dialog (auto showing keyborad)
    * @param context
    * @param view 표시할 view
    * @param confirmListener ok 클릭 했을 때
    */
   public static void show(Context context, String title, View view, CharSequence okTitle, DialogInterface.OnClickListener confirmListener, CharSequence cancelTitle,
         DialogInterface.OnClickListener cancelListnenr)
   {
      try
      {
         close();
         
         if (cancelTitle == null)
         {
            _dialog = new AlertDialog.Builder(context).setTitle(title).setView(view).setPositiveButton(okTitle, confirmListener).setCancelable(false).show();
         }
         else
         {
            _dialog = new AlertDialog.Builder(context).setTitle(title).setView(view).setPositiveButton(okTitle, confirmListener).setNegativeButton(cancelTitle, cancelListnenr).setCancelable(false)
                  .show();
         }
         _dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   /**
    * Keyboard가 자동으로 올라오는 팝업 뷰 <br>
    * Show Dialog (auto showing keyborad)
    * @param context
    * @param title
    * @param view
    * @param confirmTitle
    * @param confirmListener ok 클릭 했을 때
    * @param cancelTitle
    * @param cancelListnenr cancel 클릭 했을 때
    * @param cancelAble 백버튼으로 닫기 여부
    */
   public static void show(Context context, String title, View view, CharSequence confirmTitle, DialogInterface.OnClickListener confirmListener, CharSequence cancelTitle,
         DialogInterface.OnClickListener cancelListnenr, boolean cancelAble)
   {
      // TODO 일단은 민트샵에서 사용중이라 추가 추후에 제거 예정
      try
      {
         close();
         
         if (cancelTitle == null)
         {
            _dialog = new AlertDialog.Builder(context).setTitle(title).setView(view).setPositiveButton(confirmTitle, confirmListener).setCancelable(cancelAble).show();
         }
         else
         {
            _dialog = new AlertDialog.Builder(context).setTitle(title).setView(view).setPositiveButton(confirmTitle, confirmListener).setNegativeButton(cancelTitle, cancelListnenr)
                  .setCancelable(cancelAble).show();
         }
         _dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
   
   /**
    * 다이얼로그 닫기 <br>
    * Close Dialog
    */
   public static void close()
   {
      if (_dialog != null)
         _dialog.dismiss();
   }
}
