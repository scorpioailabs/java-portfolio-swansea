import java.io.*;

import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class FastRead { 

	public static int[] FastReadArray (String filename) throws Exception {
		// This function create an integer array, and fill it with contents from a binary file.
		
		FileInputStream fis = new FileInputStream(new File(filename));
		FileChannel channel = fis.getChannel();
		ByteBuffer bb = ByteBuffer.allocateDirect(64*1024);
		bb.clear();
		int C[] = new int [(int)channel.size()/4];
		long len = 0;
		int offset = 0;
		while ((len = channel.read(bb))!= -1){
			bb.flip();
			bb.asIntBuffer().get(C,offset,(int)len/4);
			offset += (int)len/4;
			bb.clear();
		}
		channel.close();
		fis.close();
		return C;
	}

}