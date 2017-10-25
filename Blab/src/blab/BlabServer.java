package blab;

import java.net.*;
import java.io.*;

public class BlabServer extends Thread
{
	private ServerSocket ss;
	int portNumber = 7070;
	
	public static void main(String[] args)
	{
		try
		{
			Thread t = new BlabServer();
			t.start();			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	public BlabServer() throws IOException
	{
		ss= new ServerSocket(portNumber);
		ss.setSoTimeout(100000);
	}
	public void run()
	{
		System.out.println("Waiting for clients at port: "+ portNumber);
			try
			{
				Socket se= ss.accept();
				while(true)
				{
						//DataInputStream din=new DataInputStream(se.getInputStream());
						//System.out.println("Client: "+din.readUTF());
					if((DataInputStream din=new DataInputStream(se.getInputStream())) != null)
					{
						DataInputStream din=new DataInputStream(se.getInputStream());
						System.out.println("Client: "+din.readUTF());
					}
							
						DataOutputStream dout=new DataOutputStream(se.getOutputStream());
						System.out.print("Server: ");
						
						BufferedReader bin=new BufferedReader(new InputStreamReader(System.in));
						//String chat=bin.readLine();
						
						//So basically you check to see if the receiving line (what the client sends) != null
						//and put the lines that read that inside of an if statement, that way it only tries to 
						//read the file if the client actually sent something
						if((chat = bin.readLine()) != null)
						{
							dout.writeUTF(chat);
						}
						
						
						//break on exit
						if(chat.equals("EXIT")) break;
						//dout.writeUTF(chat);
				}
			}
			catch(SocketTimeoutException s)
			{
				System.out.println("Socket Timed Out!!");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}

}
