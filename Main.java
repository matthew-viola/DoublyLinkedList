package lab2;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<String> animals = new DoublyLinkedList<String>();
		
		// Expected outputs
		String output1 = "start <-> [dog] <-> [cat] <-> [goldfish] <-> [turtle] <-> end";
		String output2 = "start <-> [dog] <-> [cat] <-> [turtle] <-> end";
		String output3 = "start <-> [dog] <-> [hamster] <-> [turtle] <-> end";
		String output4 = "turtle";
		String output5 = "start <-> [frog] <-> [dog] <-> [rabbit] <-> [hamster] <-> [turtle] <-> end";
		String output6 = "start <-> [turtle] <-> [hamster] <-> [rabbit] <-> [dog] <-> [frog] <-> end";
		String output7 = "start <-> end";
		
		// 1. Sanity check for add method
		animals.add("dog");
		animals.add("cat");
		animals.add("goldfish");
		animals.add("turtle");
		System.out.print("Sanity Check 1 Passed == ");
		System.out.println(animals.toString().equals(output1));
		
		// 2. Sanity check for remove method
		animals.remove(2);
		System.out.print("Sanity Check 2 Passed == ");
		System.out.println(animals.toString().equals(output2));
		
		// 3. Sanity check for set method
		animals.set(1, "hamster");
		System.out.print("Sanity Check 3 Passed == ");
		System.out.println(animals.toString().equals(output3));
		
		// 4. Sanity check for get method
		System.out.print("Sanity Check 4 Passed == ");
		System.out.println(animals.get(2).equals(output4));
		
		// 5. Another sanity check for add methods
		animals.add(1, "rabbit");
		animals.addToFront("frog");
		System.out.print("Sanity Check 5 Passed == ");
		System.out.println(animals.toString().equals(output5));
		
		// 6. Sanity check for reverse method
		System.out.print("Sanity Check 6 Passed == ");
		System.out.println(animals.reverse().toString().equals(output6));
		
		// 7. Another sanity check for remove methods
		animals.removeFromFront();
		animals.removeFromFront();
		animals.removeFromBack();
		animals.removeFromBack();
		animals.removeFromBack();
		System.out.print("Sanity Check 7 Passed == ");
		System.out.println(animals.toString().equals(output7));
	}
	
}
