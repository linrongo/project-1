# proj1F19

1. HammingDist - Create array of two input, read the file and create an array of STIDs exist in the file.
	a. create an array with the two inputs.
	b. When read the file, it has to ignore the first 6 lines, and then start saving data at the 7th line of the Mesonet.txt file.
	c. The next is to split the string into an array, take the first string in that array which is the stid, but because it has spaces infront of it, I hav to delete it using .replaceAll(" ","");
	d. That string then get placed into an array of all STID read on the file, if there is no space for it, expand the array and put it in its respective placement.

2. getHammingDist - find hamming distance between two STIDs.
	a. go through each letter of the two string using a for loop and .charAt(), increment the result by 1 each time they are different.

3. getStation - find the hamming distance between the inout and NRMN then go through the STIDs array an find how any others with the same distance.
	a. Create a loop the can go through the whole array size and if they hav the same hamming distance increase the result by 1.
4. expandList - double the size of the array
	a. When called, increase capacity and 2 and create a new array with that capacity.
	b. Create a loop to copy contents from the old array into the new array, then replace the oldarray with the new one.
5. toString - Return a string according to the format of the assignment.
	a. copy the format of the assignment and put correct value in that space by calling other methods.	
	