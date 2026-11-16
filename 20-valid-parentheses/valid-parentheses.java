class Solution {
    public boolean isValid(String s) {

        
        Stack<Character> stack = new Stack<>();
        char ch = ' ';
        for(int i=0; i<s.length(); i++){
            ch=s.charAt(i);

            if(ch=='{'|| ch=='[' || ch=='('){
                stack.push(ch);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else{
                if(ch==')'&&stack.peek()!='(') return false;
                else if(ch==']'&&stack.peek()!='[') return false;
                else if(ch=='}'&&stack.peek()!='{') return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
        
    }
}