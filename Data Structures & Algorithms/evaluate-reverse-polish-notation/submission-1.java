class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int n=tokens.length;
        boolean num1IsNegetive=false;
        boolean num2IsNegetive=false;
        for(int i=0;i<n;i++){
            String s=tokens[i];
            if(s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")){
                int num1=stack.pop();
                int num2=stack.pop();
                if(s.equals("+")){
                    stack.push(num1+num2);
                }else if(s.equals("*")){
                    stack.push(num1*num2);
                }else if(s.equals("/")){
                    stack.push(num2/num1);
                }else {
                    stack.push(num2-num1);
                }
            }else{
                if(s.startsWith("-")){
                    stack.push(-1*Integer.valueOf(s.substring(1)));
                }else{
                    stack.push(Integer.valueOf(s));
                }
            }
        }
        return stack.peek();
    }
}
