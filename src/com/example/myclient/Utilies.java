package com.example.myclient;

import java.util.UUID;



import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;

@SuppressLint("UseValueOf") public class Utilies 
{
	private static SQLiteDatabase db;

	public final static int USER_TYPE=1;
	public final static int WORD_TYPE=2;
	
	public static UserVO curUser;
	public static int curWordIndex;
	public static SQLiteDatabase getDB()
	{
		if (db==null)
			db=SQLiteDatabase.openOrCreateDatabase("/data/data/android.test/info.db", null);
		return db;
	}
	
    public static boolean isName(String s)
    {
    	char c;
    	int i;
    	int len=s.length();
    	
    	for(i=0;i<len;i++)
    	{
    		c=s.charAt(i);
    		if ((c>='a' && c<='z') || (c>='A' && c<='Z') || c=='.' || c=='-'||(c>='0'&&c<='9'))
    		{
    			
    		}
    		else
    		{
    			return false;
    		}
    		
    		
    	}
    	return true;
    	
    }
    public static boolean isAge(String s)
    {
    	int i;
    	char c;
    	int len=s.length();
    	
    	for(i=0;i<len;i++)
    	{
    		c=s.charAt(i);
    		if(c>='0'&&c<='9'){
    			
    		}
    		else{
    			return false;
    		}
    	}
    	return true;
    	
    }
	@SuppressLint("UseValueOf") public static String getGUID(int type)
	{
		String maxWid="0";
		switch(type)
		{
		case USER_TYPE:
			UUID uuid1 = UUID.randomUUID();
			maxWid=uuid1.toString();
			break;
		case WORD_TYPE:
			UUID uuid2 = UUID.randomUUID();
			maxWid=uuid2.toString();
			break;
		}
		return maxWid;
/*		
		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer();
		String s_id = "";
		String valueBeforeMD5 = "";
		String valueAfterMD5 = "";
		
		try 
		{
			md5 = MessageDigest.getInstance("MD5");

		}
		catch (NoSuchAlgorithmException e) 
		{
			System.out.println("Utilities error: " + e);
		}



		try 
		{
			long time = System.currentTimeMillis();
			long rand = 0;

			SecureRandom mySecureRand = new SecureRandom();

			long secureInitializer = mySecureRand.nextLong();
			rand = mySecureRand.nextLong();
			Random myRand = new Random(secureInitializer);

			try {

				s_id = InetAddress.getLocalHost().toString();

			} catch (UnknownHostException e) {

				e.printStackTrace();

			}


			// This StringBuffer can be a long as you need; the MD5

			// hash will always return 128 bits.  You can change

			// the seed to include anything you want here.

			// You could even stream a file through the MD5 making

			// the odds of guessing it at least as great as that

			// of guessing the contents of the file!


			sbValueBeforeMD5.append(s_id);

			sbValueBeforeMD5.append(":");

			sbValueBeforeMD5.append(Long.toString(time));

			sbValueBeforeMD5.append(":");

			sbValueBeforeMD5.append(Long.toString(rand));



			valueBeforeMD5 = sbValueBeforeMD5.toString();

			md5.update(valueBeforeMD5.getBytes());



			byte[] array = md5.digest();

			StringBuffer sb = new StringBuffer();

			for (int j = 0; j < array.length; ++j) {

				int b = array[j] & 0xFF;

				if (b < 0x10) sb.append('0');

				sb.append(Integer.toHexString(b));

			}



			valueAfterMD5 = sb.toString();



		} catch (Exception e) {

			System.out.println("Error:" + e);

		}

		String raw = valueAfterMD5.toUpperCase();

		StringBuffer sb = new StringBuffer();

		sb.append(raw.substring(0, 8));

		sb.append("-");

		sb.append(raw.substring(8, 12));

		sb.append("-");

		sb.append(raw.substring(12, 16));

		sb.append("-");

		sb.append(raw.substring(16, 20));

		sb.append("-");

		sb.append(raw.substring(20));



		return sb.toString();
*/
	}	
}
