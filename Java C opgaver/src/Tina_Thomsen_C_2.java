/**
 * Created by tinab on 17-Mar-17.
 */
public class Tina_Thomsen_C_2 {

    public class LinkedIntList {
        private ListNode front;   // null for an empty list

        public void set(int index, int value) {
            if (index == 0) {
                front.data = value;
            } else {
                ListNode current = front;
                int i = 0;

                while (index != i) {
                    current = current.next;
                    i++;
                }
                current.data = value;
            }
        }
    }
}
