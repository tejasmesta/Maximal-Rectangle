class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        
        int n = matrix[0].length;
        
        int mat[] = new int[n];
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<m;i++)
        {
            if(i==0)
            {
                for(int j=0;j<n;j++)
                {
                    mat[j] = Integer.parseInt(matrix[i][j]+"");
                }
                
                max = Math.max(max,histo(mat,n));                              
                               
            }
            else{
                for(int j=0;j<n;j++)
                {
                    if(matrix[i][j]=='0')
                    {
                        mat[j] = 0;
                    }
                    else{
                        mat[j] += Integer.parseInt(matrix[i][j]+"");
                    }
                }                
                
                max = Math.max(max,histo(mat,n));             
                                
                                
            }
            
            for(int k=0;k<n;k++)
            {
                System.out.print(mat[k]+" ");
            }
            
            System.out.println("");
            
            System.out.println("");
        }
                
        return max;
    }
    
    int histo(int mat[],int n)
    {
        int l[] = new int[n];
        int r[] = new int[n];
        
        prev(mat,l,n);
        next(mat,r,n);
        
        for(int i=0;i<n;i++)
        {
            System.out.print(l[i]+" ");
        }
        
        System.out.println("");
        
        for(int i=0;i<n;i++)
        {
            System.out.print(r[i]+" ");
        }
        
        System.out.println("");
        
        int ans = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++)
        {
            int a = r[i] + l[i] -1;
            int b = mat[i];
            
            ans = Math.max(ans,a*b);
        }
        
        System.out.println(ans+" ");
        
        return ans;
    }
    
    void prev(int mat[],int l[],int n)
    {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            if(mat[i]==0)
            {
                l[i] = 0;
                st.push(i);
                continue;
            }
            else if(st.isEmpty())
            {
                l[i] = 1;
            }
            else if(mat[st.peek()]==0)
            {
                l[i] = 1;
            }
            else if(mat[st.peek()]<mat[i])
            {
                l[i] = 1;
            }
            else{
                while(st.empty()==false && mat[st.peek()]>=mat[i])
                    st.pop();
            
                if(st.empty())
                    l[i]=i+1;
                else
                    l[i]=i-st.peek();
            }
            st.push(i);
        }
    }
    
    void next(int mat[],int r[],int n)
    {
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1;i>=0;i--)
        {
            if(mat[i]==0)
            {
                r[i] = 0;
                st.push(i);
                continue;
            }
            else if(st.isEmpty())
            {
                r[i] = 1;
            }
            else if(mat[st.peek()]==0)
            {
                r[i] = 1;
            }
            else if(mat[st.peek()]<mat[i])
            {
                r[i] = 1;
            }
            else{
                while(st.empty()==false && mat[st.peek()]>=mat[i])
                    st.pop();
                
                if(st.empty())
                    r[i]=mat.length-i;
                
                else
                    r[i]=st.peek()-i;
            }
            st.push(i);
        }
    }
};

/*
for(int i=0;i<n;i++)
{
    System.out.print(l[i]+" ");
}

System.out.println("");

for(int i=0;i<n;i++)
{
    System.out.print(r[i]+" ");
}
*/
        
