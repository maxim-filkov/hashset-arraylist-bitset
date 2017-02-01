# hashset-arraylist-bitset
This project contains performance comparison for Hashset, ArrayList and BitSet.

## Complexity

* ArrayList - O(1) (size, get, set, ...), O(n) - add operation.
* HashSet - all operations O(1) if proper hash function is applied.
* BitSet - for a single bit it will be O(1), the complexity for setting n bits is O(N).

## Results

### HashSet test
average time = **76567961**

### ArrayList test
average time = **263286**

### BitSet test
average time = **379266**
