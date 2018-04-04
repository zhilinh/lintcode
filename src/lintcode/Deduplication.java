package lintcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Deduplication {
	
	public byte[] hexToBytes(String s) {
		if (s == null) {
			return null;
		}
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i + 1), 16));
	    }
	    return data;
	}
	
	private String chunking(byte[] b) {
		int len = b.length;
        String data = new String();

        for (int i = 0; i < len; i++){
            data += Integer.toHexString((b[i] >>> 4) & 0xf);
            data += Integer.toHexString(b[i] & 0xf);
        }
        return data;
	}
	
	public void dedup(String inpath, String outpath) {
		try {
	        FileInputStream file;
	        FileWriter output = new FileWriter(outpath);
	        BufferedWriter outBuffer = new BufferedWriter(output);
	        
	        Map<String, String> map = new HashMap<String, String>();
	        byte[] chunk = new byte[1024];
	        int size = 0;
	        
	        file = new FileInputStream(inpath);
            while (file.read(chunk) != -1) {
                String key = chunking(chunk);
                
                if (!map.containsKey(key)) {
                    String tmp = String.valueOf(size) + " ";
                    map.put(key, tmp);
                } else {
                    map.put(key, map.get(key) + String.valueOf(size) + " ");
                }
                size++;
            }
            file.close();
	        
	        outBuffer.write(String.valueOf(size) + "\n");
	        outBuffer.write(String.valueOf(map.keySet().size()) + "\n");
	        for (Map.Entry<String, String> i : map.entrySet()) {
				outBuffer.write(i.getKey() + ":" + i.getValue() + "\n");
	        }
	        outBuffer.close();
		} catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public boolean redup(String inpath, String outpath) {
		try {
			BufferedReader file;
			FileOutputStream stream = new FileOutputStream(outpath);
	        
	        file = new BufferedReader(new FileReader(inpath));
	        int size = Integer.valueOf(file.readLine());
	        String[] data = new String[size];
	        int count = Integer.valueOf(file.readLine());
	        for (int i = 0; i < count; i++) {
	         	String line = file.readLine();
	          	String[] pair = line.split(":");
	           	String[] pos = pair[1].split(" ");
	           	for (int j = 0; j < pos.length; j++) {
	           		data[Integer.valueOf(pos[j])] = pair[0];
	           	}
	        }
	        file.close();
	        
	        for (int i = 0; i < size; i++) {
	        	byte[] chunk = hexToBytes(data[i]);
	        	stream.write(chunk);
	        }
	        stream.close();
		} catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
	    return true;
    }
}
