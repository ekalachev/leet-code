# Split array into two parts

Split array into two parts, such that the number of elements equal to X in the first part is the same as the number of elements different from X in the other part

Except of one edge case the solution is as simple as counting for a number of X within the A and then calculating K as that number substracted from an array length... Just think of it a bit:

e.g. assume there're 4 occurences of X within a given A;
divide an array by cutting off 4 element from the right;
whatever remained is gonna be on the left;
even if after such a cut some of X's was 'lost' on the right - not a big deal; logically enough that after division every X found on the right side is gracefully leveled by a non-X on the left side.
`[3,5,1,5,7,8,3,2,8] -> [3,5,1,5,7,8,3 | 2,8]` Two of X on the left = two of non-X on the right

`[3,5,1,5,7,8,5,5,8] -> [3,5,1,5,7 | 8,5,5,8]` Are two of X 'trapped' on the right side? Not problem at all! That only means that we have got for two less X on the left and for two less non-X on the right, thus anyway 2 of X on the left = 2 of non-X on the right;

As for an exception mentioned earlier, the described solution will fail when all the X values are grouped in one rightmost sequence, e.g. `[3,5,5,5,5] -> [3 | 5,5,5,5]` is wrong because for X=5 by cutting 4 elements from the right eventually we will get an index of 1 thus leaving no elements equal to X on the left at all. But as you may remember according to the condition it's the first (i.e. left) part of an array that must contain X in quantity equal to a quantity of non-X's in the second part (i.e. right). And as for this very edge case we're gonna return just length of an input array which is a sort of an acceptable answer due to this: "for K = N, A[K..N-1] does not contain any elements".