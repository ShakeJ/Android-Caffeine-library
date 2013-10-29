package caffeine.bases;

import java.util.ArrayList;

public class MTNodePacket
{
   protected String mName;
   protected String mTxtValue;
   protected ArrayList<MTNodePacket> mNodePacketList;
   
   
   public void name(String name)
   {
      mName = name;
   }
   
   
   public String name()
   {
      return mName;
   }
   
   
   public void textValue(String text)
   {
      mTxtValue = text;
   }
   
   
   public String textValue()
   {
      return mTxtValue;
   }
   
   
   public void add(MTNodePacket packet)
   {
      if (mNodePacketList == null)
      {
         mNodePacketList = new ArrayList<MTNodePacket>();
      }
      
      mNodePacketList.add(packet);
   }
   
   
   public MTNodePacket nodePacketWithName(String name)
   {
      if (mNodePacketList == null)
         return null;
      
      int length = mNodePacketList.size();
      for (int i = 0; i < length; i++)
      {
         MTNodePacket packet = mNodePacketList.get(i);
         if (name.equalsIgnoreCase(packet.name()))
         {
            return packet;
         }
      }
      return null;
   }
   
   
   /**
    * 매개변수에 아무것도 없이 호출하면 모든 child node packet을 ArrayList로 반환한다.<br>
    * (If no parameter, retun mNodePacketList)
    * @return mNodePacketList
    */
   public ArrayList<MTNodePacket> nodePacketList()
   {
      return mNodePacketList;
   }
   
   
   /**
    * @param childNodename
    * @return
    */
   public ArrayList<MTNodePacket> nodePacketList(String name)
   {
      if (mNodePacketList == null)
         return null;
      
      ArrayList<MTNodePacket> packetList = new ArrayList<MTNodePacket>();
      int length = mNodePacketList.size();
      for (int i = 0; i < length; i++)
      {
         MTNodePacket nodePacket = mNodePacketList.get(i);
         if (name.equalsIgnoreCase(nodePacket.name()))
         {
            packetList.add(nodePacket);
         }
      }
      return packetList;
   }
}
