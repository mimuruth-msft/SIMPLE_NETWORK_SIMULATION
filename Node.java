import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class Node {
	private String id;
	private long duration;// in secs
	private String destid;
	private String message;
	private long trasportBeginTime;
	private String[] neighbors;

	public Node(String pid, long pduration, String pdestid, String pmessage, long ptime, String[] pneighbors) {

		this.id = pid;
		this.duration = pduration;
		this.destid = pdestid;
		this.message = pmessage;
		this.trasportBeginTime = ptime;
		this.neighbors = pneighbors;
		System.out.println("Node:" + id + " is created. Sending message to Node: " + destid);

		sendMessage(destid, pmessage);

		stopNode(duration);

	}

	public Node(String pid, long pduration, String[] pneighbors) {

		this.id = pid;
		this.duration = pduration;
		// this.trasportBeginTime = ptime;
		this.neighbors = pneighbors;
		System.out.println("Node:" + id + " is created");

		// (destid, pmessage);
		//Stop the node once the timelimit is reached
		stopNode(duration);
		
	}

	public void sendMessage(String destID, String message) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			File file = new File("from" + this.id + "to" + destID + ".txt");
			//Enhance the message with source and destination IDs
			message = message+ " from " + this.id  + " to " + destID;
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			System.out.println("Writing message to file  --> " + file.getName());

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write("\n" + message);// enter messge in new line

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
		System.out.println("\nMessage from neghbor Node:" + neghborNode + " are:\n" + messages);
	}

	private void stopNode(long timelimit) {

		try {
			Thread.sleep(timelimit * 1000L);
			System.out.println("Timelimit reached. Reading messages from neighboring nodes ---->");
			//receieveMessages();
			System.out.println("Stopping Node:" + id);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do {
			System.out.println(
					"Please enter nodeid, duration( > 60), destination node id, message, transport start time and list of neighbors");
		} while (!(args.length >= 6) && !(Long.parseLong(args[1]) > 60));
		// Destination nodes are from 5th position. Create array of destination
		// nodes
		String[] destinationNodes = new String[args.length - 5];
		System.arraycopy(args, 5, destinationNodes, 0, destinationNodes.length);
		System.out.println("Destination nodes are:  " + destinationNodes.toString());
		// We have all the info. Create the node and start sending and recieving
		// messages
		Node currNode = new Node(args[0], Long.parseLong(args[1]), args[2], args[3], Long.parseLong(args[4]),
				destinationNodes);

	}

}
