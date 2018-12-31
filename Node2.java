import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class Node2 {
	private String id;
	private long duration;// in secs
	private String destid;
	private String message;
	private long trasportBeginTime;
	private String[] neighbors;

	public Node2(String pid, long pduration, String pdestid, String pmessage, long ptime, String[] pneighbors) {

		this.id = pid;
		this.duration = pduration;
		this.destid = pdestid;
		this.message = pmessage;
		this.trasportBeginTime = ptime;
		this.neighbors = pneighbors;
		System.out.println("\nNode:" + id + " is created. Sending message to Node: " + destid);

		//sendMessage(destid, pmessage);

		stopNode(duration);

	}

	

	private void stopNode(long timelimit) {

		try {
			Thread.sleep(timelimit * 1000L);
			System.out.println("Timelimit reached. Reading messages from neighboring nodes ---->");
			receieveMessages();
			System.out.println("Stopping Node:" + id);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	// *********DataLinklayer Implementation************
	public void recieveFromNetwork(String message, String node) {

	}

	
	public void receieveMessages() {

		for (int i = 0; i < neighbors.length; i++) {
			readFileAsString("from" + neighbors[i] + "to" + id + ".txt", neighbors[i]);
		}

	}

	public void readFileAsString(String fileName, String neghborNode) {
		// System.out.println("Reading message from neghbor Node:"+neghborNode);
		String messages = "";
		try {
			messages = new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nMessage from neighbor Node:" + neghborNode + " are:\n" + messages);
	}


	// *************NetworkLayer Implementation*********
	public void recieveFromTransport(String message, int len, String dest) {

	}

	public void recieveFromDataLink(String message, String source) {

	}

	public void routeMessages() {

	}

	// *************TransportLayer Implementation*******
	public void recieveFromNetwork(String message, int len, String source) {

	}

	
	public void sendMessage(String destID, String message) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			File file = new File("from" + id + "to" + destID + ".txt");

			// if file doesn't exist, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("Writing message to file  --> " + file.getName());

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write("\n" + message);// enter message in new line

			System.out.println("Done writing to file ---->" + file.getName());

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

	public static void outputAllMessages() {
		

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(1) Set up all nodes (start with 3 nodes and expand later)
		long duration=0;
		do {
			System.out.println(
					"Please enter nodeid, duration( > 60), destination node id, message, transport start time and list of neighbors");
			duration = Long.parseLong(args[1]);
		} while (!(args.length >= 6) && !(duration > 60));
		// Destination nodes are from 5th position. Create array of destination
		// nodes
		String[] destinationNodes = new String[args.length - 5];
		System.arraycopy(args, 5, destinationNodes, 0, destinationNodes.length);
		System.out.println("Destination nodes are:  " + destinationNodes.toString());
		// We have all the info. Create the node and start sending and recieving
		// messages
		Node currNode = new Node(args[0], Long.parseLong(args[1]), args[2], args[3], Long.parseLong(args[4]),
				destinationNodes);
		
		//Sleep for 2 mins specific duration before processing all messages
		try {
			Thread.sleep(120*1000);
			outputAllMessages();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
