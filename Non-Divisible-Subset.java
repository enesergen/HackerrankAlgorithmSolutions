//URL:https://www.hackerrank.com/challenges/non-divisible-subset/problem
public static int nonDivisibleSubset(int k, List<Integer> s) {
    // A%K=0 one number
    // A%K=K/2(if k is even) one number
    // Otherwise
    /*
    S:6,11,7,12,22,8,9,14,19,24 k=5
    remainder:1 2 3 4
    1:6,11          2:7,12,22 
    4:9,14,19,24    3:8     
    we must choose 4 and 2 because we are finding maxlength subset
    */
    
    int[] remainderArray=new int[k];
    
    for(int i=0;i<s.size();i++){
        int remainder=s.get(i)%k;
        remainderArray[remainder]++;
    }
    int length=0;
    
    if(remainderArray[0]>0){
            length++;
        }
        if(k%2==0){//k=6 remainders:0 1 2 3 4 5
            if(remainderArray[k/2]>0){
                length++;
            }
            for (int i=1;i<k/2;i++){
                int temp=remainderArray[i];
                if(remainderArray[i]<remainderArray[k-i]){
                    temp=remainderArray[k-i];
                }
                length+=temp;
            }
        }else{//k=5 remainders:0 1 2 3 4
            for(int i=1;i<(k+1)/2;i++){
                int temp=remainderArray[i];
                if(remainderArray[i]<remainderArray[k-i]){
                    temp=remainderArray[k-i];
                }
                length+=temp;
            }
        }
    
    return length;
    }
