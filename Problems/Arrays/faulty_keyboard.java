// # Algorithm : 
/*
	1. If typed < name return false
	2. Maintain two pointer for two string i, j
	3. Iterate over the name and check for following conditions each time
			- If ith char of name is equal to jth character of typed then incre i , j;
			- If they are not equal and jth of typed is equal to its prev then incre only j;
			- Else return false
  4. It may possible that after correct name some extra letter will be there, so iterate 
		 them and check is any letter mismatch with last letter of word, if yes return false
	5. Else return true
*/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        if (typed.length() < name.length()) return false;

        while (i<name.length()){
            if (j >= typed.length()) return false;
            if (name.charAt(i) == typed.charAt(j)){ i++; j++; }
            else if ( j>0 && typed.charAt(j) == typed.charAt(j-1)) j++;
            else return false;
        }
        --i;

        while( j<typed.length()){
            if (typed.charAt(j) == name.charAt(i)) j++;
            else return false;
        }
        return true;

    }
}