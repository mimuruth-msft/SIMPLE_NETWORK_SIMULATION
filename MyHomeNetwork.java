import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MyHomeNetwork {

	public static void main(String[] args) {

		// (1)Set up all nodes (start with 3 nodes and expand later)
		int numNodes = 3;// default 3 nodes
		// Prompt the user for number of nodes in the network
		long duration = 0;
		Scanner scanner = new Scanner(System.in);
		String[] inputArray = null;
		String input;

		System.out.println("\n Please enter the number of nodes  in the network. (Should be < 10) \n");
		// create a String array to
		// save user input String[] input = new String[length];
		input = scanner.next();

		if (input != null) {
			numNodes = Integer.parseInt(input);
		}
		//scanner.close();
		// Prompt the user for each node details (id, duration it need to be
		// live and list of it neighbors
		HashMap nodesMap = new HashMap();

		int nodeInstances = 0;

		/*
		 * for (int i = 0; i < numNodes; i++) { System.out.println(
		 * "\nPlease enter deatils for Node:" + nodeInstances +
		 * " --> node id, duration( >= 100), and list of neighbors\n");
		 * input=scanner.nextLine();
		 * 
		 * inputArray=convertInputToArray(input); duration =
		 * Long.parseLong(inputArray[1]);
		 * 
		 * // Destination nodes are from 3rd position. Create array of //
		 * destination nodes String[] destinationNodes = new
		 * String[inputArray.length - 2]; System.arraycopy(inputArray, 2,
		 * destinationNodes, 0, destinationNodes.length); Node currNodeObj = new
		 * Node(inputArray[0], duration, destinationNodes); //
		 * nodesList.add(currNode); nodesMap.put(inputArray[0], currNodeObj);
		 * 
		 * }
		 */
		System.out.println("\n Please enter node details\n ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s1 = "";
		int counter = numNodes;
		while (counter > 0) {
			try {
				while ((s1 = in.readLine()) != null) {
					System.out.println(s1);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			counter--;
		}
		// BufferedReader cl = new BufferedReader(new
		// InputStreamReader(System.in));
		// for (int i = 0; i < numNodes; i++) {
		// System.out.println("\nPlease enter deatils for Node:" + nodeInstances
		// + " --> node id, duration( >= 100), and list of neighbors\n");
		// input=scanner.nextLine();
		/*
		 * Scanner scanner2 = new Scanner(System.in); input=null; try { // input
		 * = cl.readLine(); System.out.println(
		 * "\nPlease enter deatils for Node2:"); while (scanner2.hasNextLine())
		 * { input = scanner2.nextLine(); if (input.isEmpty()) { break; }
		 * System.out.println("Printing Line --> " + input); //
		 * lines.add(lineNew);
		 * 
		 * inputArray = convertInputToArray(input); duration =
		 * Long.parseLong(inputArray[1]);
		 * 
		 * // Destination nodes are from 3rd position. Create array of //
		 * destination nodes String[] destinationNodes = new
		 * String[inputArray.length - 2]; System.arraycopy(inputArray, 2,
		 * destinationNodes, 0, destinationNodes.length); Node currNodeObj = new
		 * Node(inputArray[0], duration, destinationNodes); //
		 * nodesList.add(currNode); nodesMap.put(inputArray[0], currNodeObj); }
		 * } catch (NumberFormatException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } scanner2.close();
		 */

		System.out.println("\n Please enter message for Node:\n ");
		BufferedReader in3 = new BufferedReader(new InputStreamReader(System.in));
		String s3 = "";
		counter = 2 * numNodes;
		while (counter > 0) {
			try {
				while ((s3 = in3.readLine()) != null) {
					System.out.println(s3);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			counter--;
		}

		/*
		 * do { nodeInstances++; System.out.println(
		 * "\nPlease enter deatils for Node:" + nodeInstances +
		 * " --> node id, duration( >= 100), and list of neighbors\n");
		 * while(scanner.hasNext()) { input=scanner.nextLine(); }
		 * 
		 * inputArray=convertInputToArray(input); duration =
		 * Long.parseLong(inputArray[1]);
		 * 
		 * // Destination nodes are from 3rd position. Create array of //
		 * destination nodes String[] destinationNodes = new
		 * String[inputArray.length - 2]; System.arraycopy(inputArray, 2,
		 * destinationNodes, 0, destinationNodes.length); Node currNodeObj = new
		 * Node(inputArray[0], duration, destinationNodes); //
		 * nodesList.add(currNode); nodesMap.put(inputArray[0], currNodeObj);
		 * 
		 * } while (!(args.length >= 3) && !(duration >= 100) && !(nodeInstances
		 * >= numNodes));
		 */
		// Prompt the user for messages . Make sure each nodes sends message to
		// the other node (n-1)
		// messages from each node: if there are 3 nodes number of messages
		// would be 3 *2 = 6 messages
		/*
		 * int numMessages = 0; int node = 0; inputArray = null;// reset input
		 * array input = null; Scanner scanner3 = new Scanner(System.in); //for
		 * (int i = 0; i < numNodes * 2; i++) { //numMessages++; //if
		 * (numMessages % 2 != 0) { //node++; //} System.out.println(
		 * "\n Please enter message for Node:" + node +
		 * " --->source id, dest id and message\n "); // Get the corresponding
		 * node from the hashmap and sent message to // the destination); //
		 * BufferedReader cl = new BufferedReader(new //
		 * InputStreamReader(System.in)); try { // input = cl.readLine(); //
		 * input = scanner.nextLine(); while (scanner3.hasNextLine()) { input =
		 * scanner3.nextLine(); if (input.isEmpty()) { break; }
		 * System.out.println("Printing Line --> " + input); inputArray =
		 * convertInputToArray(input); Node nodeObj = (Node)
		 * nodesMap.get(inputArray[0]); // Call send message with dest id and
		 * message nodeObj.sendMessage(inputArray[1], inputArray[2]); } } catch
		 * (NumberFormatException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } scanner3.close(); //} /* do { numMessages++;
		 * if (numMessages % 2 != 0) { node++; } System.out.println(
		 * "\n Please enter message for Node:" + node +
		 * " --->source id, dest id and message\n "); // Get the corresponding
		 * node from the hashmap and sent message to // the destination); input
		 * = scanner.next(); inputArray=convertInputToArray(input); Node nodeObj
		 * = (Node) nodesMap.get(inputArray[0]); // Call send message with dest
		 * id and message nodeObj.sendMessage(inputArray[1], inputArray[2]);
		 * 
		 * } while (!(inputArray.length >= 3) && (numMessages >= 2 *
		 * numNodes));//
		 * 
		 */
	}

	private static String[] convertInputToArray(String input) {
		System.out.println("Parsing Input string: " + input);
		String[] args = new String[10];
		int i = 0;
		StringTokenizer st1 = new StringTokenizer(input);
		while (st1.hasMoreTokens()) {
			args[i] = st1.nextToken();
			i++;
		}
		System.out.println("Input array is : " + Arrays.toString(args));
		return args;

	}

}
