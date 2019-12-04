package store;


public class Store {
    
    /* STORE CLASS FUNCTIONS AND DATA FIELDS SHOULD BE HERE */
    Queue<Order> newOrders;
    Queue<Order> processedOrders;
    Queue<Order> removedOrders ;    
    DLL<Item> items ;
    double Sales;
    
    public Store() {
        newOrders = new Queue<>();
        processedOrders =  new Queue<>();
        removedOrders =  new Queue<>();
        items = new DLL<>();
    }

    
    
    
    
    
    
    
    public void resetOrders() {
        while(!newOrders.isEmpty()) {
            newOrders.dequeue();
        }
        
        while(!processedOrders.isEmpty()) {
            processedOrders.dequeue();
        }
        
        while(!removedOrders.isEmpty()) {
            removedOrders.dequeue();
        }
    }
    
    public void addNewOrder(Order o) {
        if(o == null) 
            return;
        
        newOrders.enqueue(o);
       
        
        
        Node<Item> itt = o.getItems().getHead();
        for(int i = 0 ; i < o.getItems().getSize() ; i++) {
           items.addLast(itt.getItem());
            itt = itt.getNext();
        }
        
    }
    
    public void processOrder() {
        Order o = newOrders.dequeue();
        double oSale = 0;
        if(o == null) 
            return;
        
            processedOrders.enqueue(o);
        
            Node<Item> temp = o.getItems().getHead();
            
           for(int i = 0 ; i < o.getItems().getSize() ; i++) {
              oSale = oSale + temp.getItem().getItemPrice();
              temp = temp.getNext();
           }
           
           Sales = Sales + oSale;
    }
    
    public double calculateSales() {
        return Sales;
    }
    
    public Order removeOrder(int on) {
        Order o = null;
        Queue<Order> qo = new Queue<>();
        while(!newOrders.isEmpty()) {
            if(newOrders.first().getOrderNumber() == on) {
                o = newOrders.first();
                removedOrders.enqueue(newOrders.dequeue());
            }
            qo.enqueue(newOrders.dequeue());
        }
        
        while(!qo.isEmpty()){
            newOrders.enqueue(qo.dequeue());
        }

        return o;
        
    }
    
    static int oc = 1 ;
   public void printAllOrders(Queue<Order> q) {
       if(q == null)
           return;
       
        Queue<Order> qo = new Queue<>();
       
        while(!q.isEmpty()) {
           System.out.println("     Order #"+oc);
           q.first().printOrder();
           
           oc++;
            qo.enqueue(q.dequeue());
       }
        
         while(!qo.isEmpty()){
            q.enqueue(qo.dequeue());
        }
         
   }
   
   
   //
   // ||||||||||| BONUS METHODS ||||||||||||||||| 
   //
   
   
   // METHODS ONE , Searching for an item using binary search
   public Item binarySearchItems(DLL<Item> ite , int K) { // K -> key (item number that we are searching).
      
       //Sorting the DLL first 
       DLL<Item> tempitems = sortItemsDLL(ite);
        
        int L = 0;
        int H = ite.getSize()-1;
        int mid;
        while(L <= H) {
           mid = (L+H)/2; 
           
           Node<Item> cur = ite.getHead();
            for(int i = 0 ; i < mid ; i++) {
                cur = cur.getNext();
            }
            if( K == cur.getItem().getItemNumber()) 
                return cur.getItem();
            if( K < cur.getItem().getItemNumber())
                H = mid - 1 ;
            if( K > cur.getItem().getItemNumber())
                L = mid + 1;
        }
        ite.print();
        System.out.println("");
        tempitems.print();
        return null ;
   }
   
   
   
   public DLL<Item> sortItemsDLL(DLL<Item> ite) {
       DLL<Item> tempItems = new DLL<>();
       Node<Item> cur = ite.getHead();
       int[] arr = new int[ite.getSize()];
       for(int i = 0 ; i < ite.getSize() ; i++) {
           arr[i] = cur.getItem().getItemNumber();
           cur=cur.getNext();
       }
       int t;
       arrSort(arr);
        
        for(int i = 0 ; i < arr.length ; i++) { 
        tempItems.addFirst(searchByNumber(ite,arr[i]));
            
        }
      
       return tempItems;
   }
   
    public void arrSort(int[] a) {
        int t;
        for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a.length; j++) {
        if (a[i] < a[j]) {
             t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
        
    }
    public Item searchByNumber(DLL<Item> ite , int n) {
        Node<Item> itt = ite.getHead();
        
    
        for(int i = 0 ; i < ite.getSize() ; i++) {
            if(itt.getItem().getItemNumber() == n)
             return itt.getItem();
            
            itt = itt.getNext();
            
        }
        
        return null;
    }
    
    
    
    
    
    
    /// METHOD TWO , Generating tree of store’s items .
    // We will add th BinaryTree and TNode classes .
    public void generateItemsTree(DLL<Item> ite) {
        BinaryTree<Item> bti = new BinaryTree<>();
        
        
        bti.addRoot(ite.getHead().getItem());
        TNode<Item> r = bti.getRoot();
        Node<Item> cur = ite.getHead().getNext();
       for(int i = 0 ; i < ite.getSize()/2 ; i++) {
           
           bti.addLeft(r, cur.getItem());
           bti.addRight(r, cur.getNext().getItem());
           System.out.println(""+i);
          
           if(i == 1) {
            r = r.getParent().getRight();
           } else { 
               if(i == 2) {
                   r = r.getParent().getLeft().getLeft();
               } else {  
          r = r.getLeft();                   
               }
           }
           cur = cur.getNext().getNext();
           
       }
       
    }
    
    
    
 /* AFTER COMPLETING THE REQUIREMENTS ALL ERRORS SHOULD BE RESOLVED */
    public static void main(String[] args) {
       
        
        //---------------------------------------------------------------------------------------------------------------------------------
        Store store = new Store();
        Order o4 = new Order(4);
        o4.addItem(new Item(111,"iPhone X",3750));
        o4.addItem(new Item(133,"Bose Headphone",1099));
        store.addNewOrder(o4);
        Order o5 = new Order(5);
        o5.addItem(new Item(111,"iPhone X Max",5550));
        store.addNewOrder(o5);
        Order o1 = new Order(1);
        o1.addItem(new Item(111,"iPhone X",3750));
        o1.addItem(new Item(122,"iPhone X Max",5550));
        o1.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        store.addNewOrder(o1);
        Order o2 = new Order(2);
        o2.addItem(new Item(122,"iPhone X Max",5550));
        o2.addItem(new Item(131,"Apple AirPods",599));
        store.addNewOrder(o2);
        Order o3 = new Order(3);
        o3.addItem(new Item(231,"Samsung Galaxy Note 10",2500));
        store.addNewOrder(o3);
        
        store.removeOrder(5);   
        store.processOrder();
        System.out.println("New:");
        store.printAllOrders(store.newOrders);
        System.out.println("Processed:");
        store.printAllOrders(store.processedOrders);
        System.out.println("Removed:");
        store.printAllOrders(store.removedOrders);
        //---------------------------------------------------------------------------------------------------------------------------------

        
        
        
        
        
      
        
    }
    
}
