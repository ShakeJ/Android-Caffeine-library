package caffeine.utils;

public class ConvertUtil
{
   /**
    * Hexa To byte array
    * @param hexa value
    * @return ByteArray
    */
   public static byte[] hexaToByteArray(String hexa)
   {
      if (hexa == null || hexa.length() == 0 || hexa.length() % 2 == 1)
         return null;
      
      byte[] byteArray = new byte[hexa.length() / 2];
      for (int i = 0; i < byteArray.length; i++)
         byteArray[i] = (byte) Short.parseShort(hexa.substring(2 * i, 2 * i + 2), 16);
      
      return byteArray;
   }
   
   
   /**
    * Int To IP
    * @param intValue
    * @return IP
    */
   public static String intToIP(int intValue)
   {
      return (intValue & 0xFF) + "." + ((intValue >> 8) & 0xFF) + "." + ((intValue >> 16) & 0xFF) + "." + ((intValue >> 24) & 0xFF);
   }
   
   
   /**
    * Int To String
    * @param intValue
    * @return String
    */
   public static String intToString(int intValue)
   {
      return Integer.toString(intValue);
   }
   
   
   /**
    * String to Int
    * @param String
    * @return Int
    */
   public static int stringToInt(String stringValue)
   {
      int kNum = -1;
      try
      {
         kNum = Integer.parseInt(stringValue);
      } catch (NumberFormatException e)
      {
         
      }
      return kNum;
   }
   
   
   /**
    * String to Double
    * @param String
    * @return Double
    */
   public static double stringToDouble(String stringValue)
   {
      return Double.valueOf(stringValue).doubleValue();
   }
   
   
   /**
    * String to Float
    * @param String
    * @return Float
    */
   public static double stringToFloat(String stringValue)
   {
      return Float.valueOf(stringValue).floatValue();
   }
   
   
   /**
    * Decimal to Float
    * @param Decimal(int)
    * @return Binary
    */
   public static String decimalToBinary(int decimal)
   {
      return Integer.toBinaryString(decimal);
   }
   
   
   /**
    * Decimal to Hexa
    * @param Decimal(int)
    * @return Hexa
    */
   public static String decimalToHexa(int decimal)
   {
      return Integer.toString(decimal, 16);
   }
   
   
   /**
    * hexa to Deciaml
    * @param Hexa
    * @return Decimal(int)
    */
   public static int hexaToInt(String hexa)
   {
      return Integer.parseInt(hexa, 16);
   }
   
   
   /**
    * ascil to String
    * @param ascil
    * @return String
    */
   public static String asciiToString(int ascil)
   {
      return Character.valueOf((char) (ascil)).toString();
   }
   
   
   /**
    * String to boolean
    * @param String
    * @return boolean
    */
   public static boolean stringToBoolean(String stringValue)
   {
      boolean result = false;
      
      boolean isInt = false;
      int intResult = 0;
      
      try
      {
         intResult = Integer.parseInt(stringValue);
         isInt = true;
      } catch (Exception e)
      {
      }
      
      if (isInt)
      {
         result = intResult == 1;
      }
      else
      {
         result = Boolean.parseBoolean(stringValue);
      }
      
      return result;
   }
   
   
   /**
    * Int to boolean
    * @param Int
    * @return boolean
    */
   public static boolean intToBoolean(int intValue)
   {
      return stringToBoolean(intValue + "");
   }
}
