class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='{' || ch=='(' || ch=='['){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    char temp=stack.pop();
                if(temp == '['){
                     if(ch!=']'){
                        return false;
                     }
                }else if(temp=='{'){
                    if(ch!='}'){
                        return false;
                    }
                }else{
                    if(ch != ')'){
                        return false;
                    }
                }
                }else{
                    return false;
                }
                
                
            }
        }
        return stack.isEmpty();
    }
}
