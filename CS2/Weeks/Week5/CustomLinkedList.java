/**
 * 	
 * @author lunarfuror
 *
 */
public class CustomLinkedList {
		public static void main (String[] args) {
			LinkedNode nodeObj1 = new LinkedNode();
			LinkedNode nodeObj2 = new LinkedNode();
			LinkedNode nodeObj3 = new LinkedNode();
			LinkedNode nodeObj4 = new LinkedNode();
			LinkedNode currObj = new LinkedNode();

			nodeObj2.setAllData("Dayton", 20, "Orange");
			nodeObj3.setAllData("Grayson", 24, "Purple");
			nodeObj4.setAllData("Grant", 22, "Black");
			
			nodeObj1.setNext(nodeObj2);
			nodeObj2.setNext(nodeObj3);
			nodeObj3.setNext(nodeObj4);

			// Print linked list
			currObj = nodeObj1;
			while (currObj != null) {
				System.out.println(currObj.getAllData());
				currObj = currObj.getNext();
			}
			
			System.out.println();
			nodeObj2.setNext(nodeObj4);
			
			// Print linked list
			currObj = nodeObj1;
			while (currObj != null) {
				System.out.println(currObj.getAllData());
				currObj = currObj.getNext();
			}
			
			System.out.println();
			nodeObj2.setNext(null);
			
			// Print linked list
			currObj = nodeObj1;
			while (currObj != null) {
				System.out.println(currObj.getAllData());
				currObj = currObj.getNext();
			}
		}
	}