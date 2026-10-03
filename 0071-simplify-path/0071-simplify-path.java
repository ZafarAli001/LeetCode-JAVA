class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for(String part:parts){
              // Empty part or "." means stay in current directory
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // ".." means go one directory back
            else if (part.equals("..")) {

                // Only pop if we actually have a directory
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            // Normal directory
            else {
                stack.push(part);
            }
        }

        // Build the final path
        StringBuilder result = new StringBuilder();

        for (String folder : stack) {
            result.append("/").append(folder);
        }

        // If nothing is left, we're at root
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}