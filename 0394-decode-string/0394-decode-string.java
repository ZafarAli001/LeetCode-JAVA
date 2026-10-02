class Solution {
    public String decodeString(String s) {

        // store number before [
        Stack<Integer> countStack = new Stack<>();
        // store string before [
        Stack<StringBuilder> stringStack = new Stack<>();
        
        int number = 0;
        StringBuilder current = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                // buiding the number 
                // currently, ch is in string so ch - '0' converts it integer
                // ex: ch  = 3; number = 0 * 10 + (ch - '0') ==> 0 + 3 ==> 3  
                number = number * 10 + (ch - '0');
            }else if(ch == '['){
                // save the current number
                countStack.push(number);
                // save the current string
                stringStack.push(current);

                //reseting
                number = 0;
                current = new StringBuilder();
            }else if(ch == ']'){
                // get the repeat count
                int repeat = countStack.pop();
                // get the string from before [
                StringBuilder prev = stringStack.pop();

                for(int i =0;i<repeat;i++){
                    prev.append(current);
                }

                current = prev;
            } // if it a normal character
            else{
                current.append(ch);
            }
        }
        return current.toString();
    }
}