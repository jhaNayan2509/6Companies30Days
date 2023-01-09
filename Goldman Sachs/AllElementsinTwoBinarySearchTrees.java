/*Related Topic: Tree,DFS,BFS,etc. */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

ArrayList<Integer> al1=new ArrayList<Integer>();
ArrayList<Integer> al2=new ArrayList<Integer>();
        inorder(root1,al1);
        inorder(root2,al2);
    merge(al1,al2);        

        ArrayList<Integer> res=new ArrayList<Integer>(al1.size()+al2.size());

for(int i=0;i<al1.size();i++)
{
    res.add(al1.get(i));
}
for(int i=0;i<al2.size();i++)
{
    res.add(al2.get(i));
}
return  res;

    }
    public int findgap(int n)
    {
        if(n<=1)
        {
            return 0;
        }
        return (n/2)+(n%2);
    }
    public void merge(ArrayList<Integer> al1,ArrayList<Integer> al2)
    {
        int n1=al1.size();
        int n2=al2.size();

         int n=al1.size()+al2.size();
       
        int i,j,k=0;
         for( int gap=findgap(n);gap>0;gap=findgap(gap))
         { 
              for( i=0;i+gap<n1;i++)
              {
                   if(al1.get(i)>al1.get(i+gap))
                   {
                       int temp=al1.get(i);
                       al1.set(i,al1.get(i+gap));
                       al1.set(i+gap,temp);
                   }

              }
              for( j=gap>n1?gap-n1:0;j<n2 && i<n1 ;i++,j++)
              {

                        if(al1.get(i)>al2.get(j))
                   {
                       int temp=al1.get(i);
                       al1.set(i,al2.get(j));
                       al2.set(j,temp);
                   }


              }
              if(j<n2)
              {
                for( k=0;k+gap<n2;k++)
                {


                    if(al2.get(k)>al2.get(k+gap))
                   {
                       int temp=al2.get(k);
                       al2.set(k,al2.get(k+gap));
                       al2.set(k+gap,temp);
                   }

                }

              }

         }
    }

    public void inorder(TreeNode root1,ArrayList<Integer> al)
    {
        if(root1==null)
        return;

      inorder(root1.left,al);
      al.add(root1.val);
      inorder(root1.right,al);

    }
}