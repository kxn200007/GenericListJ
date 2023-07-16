
import java.util.ArrayList;

public class GenericList<E extends Comparable<E>> {

    //Data Member
    private final ArrayList<E> list;

    //Constructor
    public GenericList() {

        //Initialize Empty List
        list = new ArrayList<E>();
    }

    //Copy Constructor
    public GenericList(ArrayList<E> thatList) {

        //Initialize Empty List
        this.list = new ArrayList<>();

        if (thatList != null) {

            //Copy all elements from that List.
            this.list.addAll(thatList);
        }
    }

    //Accessor and Mutator Methods:
    public ArrayList<E> getList() {

        //Returns a copy of list.
        return new ArrayList<E>(this.list);
    }

    public void setList(E value) {

        if (value != null) {

            //add a valid value to list
            this.list.add(value);
        }

    }


    public void InsertionSort() {

        for (int i = 1; i < list.size(); ++i) {

            //set key as pivot element
            E key = list.get(i);
            int j = i - 1;

            // Move elements of list from i-1 to 0, that are greater than key, to one position ahead of their current position
            while (j >= 0 && list.get(j).compareTo(key) > 0) {

                list.set(j + 1, list.get(j));
                j--;
            }

            //place key in its correct position
            list.set(j + 1, key);
        }
    }


    public boolean BinarySearch(E value) {

        boolean isFound = false;

        //Create new Clone Generic List
        GenericList<E> sortedList = new GenericList<E>(list);

        //Sort it using Insertion Sort since Binary Search works only on Sorted List
        sortedList.InsertionSort();

        //Indexing Variables
        int left = 0;
        int right = sortedList.list.size() - 1;

        while (left <= right && !isFound) {

            //Calculate Mid Point of Array
            int mid = left + (right - left) / 2;

            // Check if value at mid matches the value at mid point
            if (sortedList.list.get(mid).compareTo(value) == 0) {

                //Search completed
                isFound = true;
            }
            // If value is greater, ignore left half
            else if (sortedList.list.get(mid).compareTo(value) < 0) {

                left = mid + 1;
            }
            // If value is less, ignore right half
            else {
                right = mid - 1;
            }
        }

        //return true if search was completed and false if not found
        return isFound;
    }
}
