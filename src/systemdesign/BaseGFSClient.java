package systemdesign;

import java.util.Map;

class BaseGFSClient {
    private Map<String, String> chunk_list;
    public BaseGFSClient() {}
    public String readChunk(String filename, int chunkIndex) {
        // Read a chunk from GFS
    	return "";
    }
    public void writeChunk(String filename, int chunkIndex,
                           String content) {
        // Write a chunk to GFS
    }
}