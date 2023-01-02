/*Problem link: https://leetcode.com/problems/evaluate-reverse-polish-notation/description/ */

class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> s = new Stack<>();
       int val1,val2;
       for(int i=0;i<tokens.length;i++){
           switch(tokens[i]){
               case "+":
                s.push(s.pop()+s.pop());
                break;
               case "-":
               val1 = s.pop();
               val2 = s.pop();
               s.push(val2-val1);
               break;
               case "*":
                s.push(s.pop()*s.pop());
               break;
               case"/":
                val1 = s.pop();
               val2 = s.pop();
               s.push(val2/val1);
               break;
               default:
               s.push(Integer.parseInt(tokens[i]));
           }
       }
       return s.pop();
    }
}

/*Submission Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/869681423/ */
