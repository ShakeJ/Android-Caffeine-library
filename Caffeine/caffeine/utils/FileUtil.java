package caffeine.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import android.net.Uri;
import android.webkit.MimeTypeMap;

public class FileUtil
{
   /**
    * Get path from file
    * @param filePath 
    * @return
    */
   public static Uri uriFromFile(String filePath)
   {
      return Uri.fromFile(new File(filePath));
   }
   
   
   /**
    * Get file mimeType
    * @param filePath
    * @return image/png, video/xxx
    */
   public static String mimeTypeOfFile(String filePath)
   {
      MimeTypeMap type = MimeTypeMap.getSingleton();
      return type.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(filePath));
   }
   
   
   /**
    * Copy file 
    * @param original file path
    * @param copy file path
    * @param is delete original file 
    */
   public static void copyTo(String fromFilePath, String toFilepath, boolean isDeleteOriginalFile)
   {
      File fromFile = new File(fromFilePath);
      File toFile = new File(toFilepath);
      
      FileChannel src = null;
      FileChannel dst = null;
      
      try
      {
         src = new FileInputStream(fromFile).getChannel();
         dst = new FileOutputStream(toFile).getChannel();
         src.transferTo(0, src.size(), dst);
         src.close();
         dst.close();
         
         if (isDeleteOriginalFile)
            fromFile.delete();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      } catch (IOException e)
      {
         e.printStackTrace();
      } finally
      {
         try
         {
            src.close();
         } catch (IOException e)
         {
            e.printStackTrace();
         }
         
         try
         {
            dst.close();
         } catch (IOException e)
         {
            e.printStackTrace();
         }
      }
   }
}
