class Solution {
public int calcSum(int [] nums,int mid)
{
int sum = 0 ; int k = 0;
for(int i=0;i<nums.length;i++)
{
sum = sum + nums[i] ;
if(sum > mid )
{
sum = nums[i] ;
k++;
}
}
return k + 1;
}
public int minSum(int [] nums,int i, int j ,int k) 
{
while(i<j)
{
	int mid = i+j >>1 ;
	if(calcSum(nums,mid) > k)
	i = mid + 1  ;
    else
    j = mid ;
} 
return i ;  
}
   public int splitArray(int[] nums, int k) {
      int sum =0 ; int max = 0;
	for(int i=0;i<nums.length;i++)
	{
	max = Math.max(max,nums[i] );
	sum = sum + nums[i] ;
	}
    return minSum(nums,max,sum ,k) ;	
   }
}


