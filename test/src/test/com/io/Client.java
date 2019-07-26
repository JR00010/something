package test.com.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;
import java.nio.channels.Pipe.SourceChannel;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
//import sun.nio.ch.PipeImpl.1;
//import sun.nio.ch.PipeImpl.Initializer;


/**
 * @author 80003509
 * 	Nio 的缓冲 Buffer， 
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */
public class Client
{
	public static void main(String[] args) throws IOException {
		methd2();
//		 AccessController.doPrivileged(new Initializer(this, var1, (1)null));
	}
	public static  void methd2()
	{
	}
	
	
	public static  void Nio1() throws IOException
	{
		RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();
	
			while(buf.hasRemaining()){
				System.out.print((char) buf.get());
			}
	
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
	
}
