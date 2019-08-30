import java.util.HashSet;

/*
 Opgave 1.
 Lav en klasse: HashIntSet
 add(int value) // man kan kun indsætte en værdi én gang
 Gem i et array.
 Find index positioner, som på en smart måde gemmer værdierne, så det nemt kan findes igen.

 Indsæt 107, i et array med længde 101
 int index = 107 % 101; // 6


 Opgave 2:
 Implementer separate chaining i HashIntSet
 - håndter kollisioner, så man kan tilføje mere end én værdi der falder på samme
 Index.
 - skift int ud med Node i arrayet
 */
public class HashIntSet extends HashSet{

    private int size = 101;
    //private int[] values = new int[size];
    private Node[] values = new Node[size];


    public boolean add(Object value){
        int index = Math.abs(value.hashCode()) % values.length;
        Node front = values[index];

        if (front == null) {
            values[index] = new Node(value);
            System.out.println("true " + value);
            return  true;
        } else {
            Node current = front;
            int i = 0;
            while (current.next != null) {
                if (value == current.value) {
                    System.out.println("false " + value);
                    return false;
                }
                current = current.next;
                i++;
            }
            if (i > 2) {
                grow();
            }

            current.next = new Node(value);
            System.out.println("Yay " + value);
            return true;
        }
    }

    public void grow(){
        Node[] oldValues = values;

        values = new Node[values.length * 2];
    }

    public String toString(){
        String out ="";

        for (int i = 0; i < values.length; i++){
            Node current = values[i];

            while (current != null){
                out += current.value + ", ";
                current = current.next;
            }
            if  (values[i] != null){
                out += "\n";
            }
        }
        return out;
    }
/**Exercise 1, page 1118 in Building Java Programs 3ed
Write a method in the HashIntSet class called addAll that accepts another hash set as a parameter
 and adds all of the elements from the other set into the current set.

 For example, if the set stores [-5, 1, 2, 3] and the method is passed [2, 3, 6, 44, 79], your set would store [-5, 1, 2, 3, 6, 44, 79].
 **/
    public void addAll(HashSet[] newValues) {
        HashSet[] set1 = new HashSet[size];
        HashSet[] set2 = new HashSet[size];

        //combine
        HashSet[] set1 = newValues;



    }
    /**
     Write a method in the HashIntSet class called containsAll
     that accepts another hash set as a parameter
     and returns true if your set contains every element from the other set.

     For example,
     if the set stores [-2, 3, 5, 6, 8]
     and the method is passed [3, 6, 8],
     your method would return true.
     If the method were passed [3, 6, 7, 8],
     your method would return false because your set does not contain the value 7.
     */

    public boolean containsAll(HashSet[] checking){
        int index = Math.abs(values.hashCode()) % values.length;
        int index2 = Math.abs(checking.hashCode()) % checking.length;
        Node front = values[index];
        HashSet front2 = checking[index2];

        for(int i = 0; i < values.length; i++){
            if (front == null && )
        }
        if(front && front2 == null){
            return true
        }else{

        }
    }

    /**
     Write a method in the HashIntSet class called removeAll
     that accepts another hash set as a parameter
     and ensures that this set does not contain any of the elements from the other set.

     For example, if the set stores [-2, 3, 5, 6, 8] and the method is passed [2, 3, 6, 8, 11], your set would store [-2, 5].
     */
}
