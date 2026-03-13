public class FindInDeque {

    public static String find(int[] q, int y){
        String position = "";
        int n = q.length - 1;


        for(int i = 0; i <= q.length/2; i ++){

            if(q[i] == y){
                position =  "" +  i;
                return position;
            } else if(q[n-i] == y){
                position =  "" + (n-i);
                return position;
            } else {
                position = "Target not found.";
            }

        }
        return position;
    }

    public static void main(String[] args){
        int[] q = {1, 2, 3, 4, 5, 6, 7};
        int y = 7;
        System.out.println("Find in Deque: " + find(q, y));
    }


}

