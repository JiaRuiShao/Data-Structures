/**
 * Implement two stacks using one array.
* */

package stackqueue;

class TwoStacks<V> {
    private int maxSize;
    private V[] array;
    private int left, right; // pointers to record the last element in stacks

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];// type casting Object[] to V[]
        left = -1;
        right = max_size;
    }

    //insert at top of first stack
    public void push1(V value) {
        if (left >= right - 1) { // if is full
            return;
        }
        array[++left] = value;
    }

    //insert at top of second stack
    public void push2(V value) {
        if (left >= right - 1) { // if is full
            return;
        }
        array[--right] = value;
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (left == -1) { // nothing to be popped
            return null;
        }
        return array[left--];
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (right == maxSize) { // nothing to be popped
            return null;
        }
        return array[right++];
    }

    public static void main(String[] args) {
        TwoStacks<Integer> tS = new TwoStacks<Integer>(5);
        tS.push1(11);
        tS.push1(3);
        tS.push1(7);
        tS.push2(1);
        tS.push2(9);

        System.out.println(tS.pop1());
        System.out.println(tS.pop2());
        System.out.println(tS.pop2());
        System.out.println(tS.pop2());
        System.out.println(tS.pop1());
    }
}
