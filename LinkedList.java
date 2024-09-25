package TTT;
// import org.w3c.dom.Node;
// package TTT_LinkedList{

public class LinkedList {

    private Node head; // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {                             //creates an empty list w/ "" as its data
        
        this.head = null;               
        for(int x = 0; x < 9; x++){
            insertAtEnd("");
        }
    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
        Node temp = new Node(data);
        
        if(head==null){
            head = temp;
            return;
        }
            // Node curr = new Node();
            Node curr = head;
            while(curr.next!=null){                 //iterates to the end of the list, breaks then makes the last
                                                    //node point to the temp node
                curr = curr.next;
        }
        curr.next = temp;
     
        // To be implemented
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        // To be implemented
       
        Node temp = head;
        int count = 1;
        while(temp!=null && count<position){        //iterates to 1 before the given position, proceed to next position then apply the data to that postion
            temp = temp.next;
            count++;
        }
            if(temp != null){
                temp.data= data;
            }
        }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        Node temp = head;
        int count = 1;
        while(temp !=null && count < position){     //iterates to the 1 before the position, then proceed next position, then return data of that position
            temp = temp.next;
            count++;
        }
        if(temp != null){
                return temp.data;
        }else{
            return "";
        }
        // To be implemented
       
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        
        Node temp = head;
        int count = 1;
        String value;

        while(temp != null){                        //
            if(temp.data.isEmpty()){
                value = String.valueOf(count);

            }else{
                value = temp.data;
            }
            System.out.print(temp.data+ " ");
            if(count % 3 ==0){
                System.out.println();
            }
            temp = temp.next;
            count++;
        }
    }

    // Method to check for a win
    public boolean checkWinCondition() {        
        
        Node temp = head;
        int [][] winCond = {
                                                                            
            {1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}   //possible wins; rows top to bottom, collums left to right, diagonal topLeft to bottomRight and topRight to bottomLeft
            
        };
        for(int x = 0; x < winCond.length;x++){
            int[] check = winCond[x];

            String a = getPositionValue(check[0]);
            String b = getPositionValue(check[1]);
            String c = getPositionValue(check[2]);

            if(!a.isEmpty()&&a.equals(b)&&b.equals(c)){
                return true;
            }
            
        }
        return false;
      
      
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
   
        int count = 1;
     
        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
            count++;
            return false;
       
    }
        return true;
    }

    // Method to reset the board
    public void resetBoard() {
       Node temp = head;
        // temp = head;
        while(temp!=null){
            temp.data = "";
            temp = temp.next;
           
        }
        // To be implemented
    }
}

