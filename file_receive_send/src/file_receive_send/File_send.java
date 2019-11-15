package file_receive_send;//客户端实现

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.sql.ClientInfoStatus;

public class File_send extends Socket {
	static int port = 8899;
	public String path;
	
    Socket client = new Socket();
	
	private FileInputStream files;
	
	private DataOutputStream dataOut;
	
	public File_send(String IP) throws Exception {
		super(IP,port);
		this.client = this ;
		System.out.println("successfully connected");
	}//构造方法
	
	public  void FileSend () throws  Exception {
		try {
			File file = new File(path);
				if (file.exists()) {
				    files = new FileInputStream(file);
					dataOut = new DataOutputStream(client.getOutputStream());
					
					dataOut.writeUTF(file.getName());
					dataOut.flush();
					dataOut.writeLong(file.length());
					dataOut.flush();
					
					//文件传输
					System.out.println("**********开始传输**************");
					byte[] bytes = new byte[1024];
					int length = 0;
					long progress = 0;
					while((length = files.read(bytes,0,bytes.length))!=-1) {
						dataOut.write(bytes,0,bytes.length);
						dataOut.flush();
						progress += length;
					}
					System.out.println("==========传输完成========");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(files != null)
				files.close();
			if(dataOut != null)
				dataOut.close();
			client.close();
		}
		//主方法部分（测试用）
		//使用AppGUI调用本类
	}
		

}