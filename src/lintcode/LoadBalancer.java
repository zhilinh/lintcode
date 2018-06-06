package lintcode;

import java.util.*;

public class LoadBalancer {
	
	List<Integer> servers;
	
	public LoadBalancer() {
        // do initialization if necessary
		servers = new ArrayList<Integer>();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
    	servers.add(server_id);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
    	for (int i = 0; i < servers.size(); i++) {
    		if (servers.get(i) == server_id) {
    			servers.remove(i);
    			return;
    		}
    	}
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
    	Random ran = new Random();
    	return servers.get(ran.nextInt(servers.size()));
    }
}
