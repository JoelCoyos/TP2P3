package modelo;

import java.util.Random;

public class Util
{
	private static Random r=new Random();
	
	public static void espera(int maximo)
	{
		try
		{
			Thread.sleep(r.nextInt(maximo));
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
