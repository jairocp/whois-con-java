/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whois;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.apache.commons.net.whois.WhoisClient;

/**
 *
 * @author macaco
 */
public class Whois {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
 Whois s = new Whois();
 System.out.println(s.getWhois("google.com"));

    }
    
    public String getWhois(String domainName) {
 
		StringBuilder result = new StringBuilder("");
 
		WhoisClient whois = new WhoisClient();
		try {
 
			//default is internic.net
			whois.connect(WhoisClient.DEFAULT_HOST);
			String whoisData1 = whois.query("=" + domainName);
			result.append(whoisData1);
			whois.disconnect();
 
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		return result.toString();
 
	}
}
