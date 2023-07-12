// # Link : https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1
class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        for(int ele: arr){
            if (ele < 0) neg.add(ele);
            else pos.add(ele);
        }
        
        for(int i=0; i<pos.size(); i++){
            arr[i] = pos.get(i);
        }
        for(int i=0; i<neg.size(); i++){
            arr[i+pos.size()] = neg.get(i);
        }
    }
}