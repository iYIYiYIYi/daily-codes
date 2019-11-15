package file_receive_send;//服务端实现

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.text.DecimalFormat;

public class File_receive extends ServerSocket{
	private static final int port = 8899;
	private static DecimalFormat df = null;
	public String Path;
	
	static {
		df = new DecimalFormat("#0.0");
		df.setRoundingMode(RoundingMode.HALF_UP);
		df.setMaximumFractionDigits(1);
		df.setMinimumFractionDigits(1);
	}
	public  File_receive() throws Exception {
		super (port);
	}
	public void load() throws Exception {
		
		
			Socket socket = this.accept();
			new Thread(new Task(socket)).start();
		
	}
		class Task implements Runnable {
			private Socket socket ;
			
			private DataInputStream dataOut ;
			
			private FileOutputStream files ;
			
			public Task(Socket socket) {
				this.socket = socket ;
			}
				
			
			public void run() {
				
				try {
					dataOut = new DataInputStream(socket.getInputStream());
					String filename = dataOut.readUTF();
					File directory = new File(Path);
					if(!directory.exists()) {
						directory.mkdir();
					}
					File file = new File(directory.getAbsolutePath()+File.separatorChar+filename);
					files = new FileOutputStream(file);
					byte[] bytes = new byte[1024];
					int length = 10;
					while ((length = dataOut.read(bytes,0,bytes.length)) != -1) {
						files.write(bytes, 0, length);
						files.flush();
					}
					System.out.println("===========接收成功=========");
					files.close();
					dataOut.close();
					socket.close();
					
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(files != null)
								files.close();
							if(dataOut != null)
								dataOut.close();
							socket.close();
						}catch(Exception e) {}
				}
			}
		}
		
}
