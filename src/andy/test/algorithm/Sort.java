package andy.test.algorithm;

public class Sort {

    public static void descendingSort(double[] nums) {
      for(int i = 0; i < nums.length; i++) {
            int max = i;  // holds the index of the largest element
            // find the largest one between i and the end of the array
            for(int j = i; j < nums.length; j++) {
                if (nums[j] > nums[max]) max = j;
            }
            // swap the largest one with element i.  
            double tmp;
            tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
        }
    }
    public static double getSecondLargest(double[] nums) {
    	double largest = nums[0];
    	double secondLargest = -99999;// give it a null value
        for(int i = 1; i < nums.length; i++) {
             if (nums[i] > largest){
            	 // find another largest, update largest and second largest
            	 secondLargest = largest;
            	 largest = nums[i];            	 
             }
             else{
            	 if (nums[i] > secondLargest){
            		 secondLargest = nums[i];
            	 }
             }             
          }
        return secondLargest;
      }
    public static void main(String[] args) {
        double[] nums = new double[10];      // Create an array to hold numbers
        for(int i = 0; i < nums.length; i++) // Generate random numbers
            nums[i] = Math.random() * 100;
        System.out.println(getSecondLargest(nums));
        descendingSort(nums);                          // Sort them
        for(int i = 0; i < nums.length; i++) // Print them out
            System.out.println(nums[i]);
        
    }
}
