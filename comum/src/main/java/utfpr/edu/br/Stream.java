package utfpr.edu.br;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class Stream implements Serializable{

	private static final long serialVersionUID = 1L;

	byte[] bytes;
    String md5;

	public Stream(InputStream input) {
		try {
			setBytes(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] getBytes() {
		return bytes;
	}

	private void setBytes(InputStream input) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];

		for (int length = 0; (length = input.read(buffer)) > 0;) {
		    output.write(buffer, 0, length);
		}
		
		//serializa em bytes para o rmi nao encher o saco
		bytes = output.toByteArray(); 
	}

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
