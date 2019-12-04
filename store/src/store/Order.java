package store;
 
public class Order {
    /* COMPLETE ORDER CLASS */
    private int orderNumber;
    private DLL<Item> items;
    
    
    
        public Order (int x) {
        items = new DLL<>();
        orderNumber = x;
    }

    public DLL<Item> getItems() {
        return items;
    }
        
        
    public int getOrderNumber() {
        return orderNumber;
    }
        
        
    
    public void addItem(Item it) {
        if(it == null)
            return;
        
        Item i = new Item(it);
        items.addLast(i);
        
        
        int x = items.getSize();
        items.setSize(x++);
    }
    
    
    public Item removeItem(int itn) {
       Item it;
      
       Node<Item> temp = items.getHead();
       
       for(int i = 0 ; i < items.getSize() ; i++) {
           if(temp.getItem().getItemNumber() == itn)
               break;
           temp = temp.getNext();
       }
       if(temp == null)
           return null;
           
       
       
             Node<Item> cur = items.getHead();
            
            if(cur.getItem().getItemNumber() == itn) {
                it = items.getHead().getItem();
            items.setHead(items.getHead().getNext());
            items.getHead().setPrev(null);
            if(items.getHead() == null)
                items.setTail(null);
            
            int x = items.getSize();
        items.setSize(--x);
        return it;
            
            }
            
            for(int i = 0 ; i < items.getSize() ; i++) {
            if(cur.getNext().getItem().getItemNumber() == itn)
               break;
            cur = cur.getNext();
                } 
            
            
            
            it = cur.getNext().getItem();
            
            if(cur.getNext() == items.getTail()) {
                items.setTail(items.getTail().getPrev());
                
                cur.getNext().setPrev(cur);
                cur.setNext(cur.getNext().getNext());
                
                int x = items.getSize();
                 items.setSize(--x);
                 return it;
            }
             
            cur.getNext().getNext().setPrev(cur);
            cur.setNext(cur.getNext().getNext());
            
           
            
        
       
        int x = items.getSize();
        items.setSize(--x);
        return it;
     }
    
    
    
    public Item searchByNumber(int n) {
        Node<Item> itt = items.getHead();
        
        for(int i = 0 ; i < items.getSize() ; i++) {
            if(itt.getItem().getItemNumber() == n)
             return itt.getItem();
            
            itt = itt.getNext();
        }
        
        return null;
    }
    
    
    public Item searchByName(String na) {
        Node<Item> itt = items.getHead();
        
        for(int i = 0 ; i < items.getSize() ; i++) {
            if(itt.getItem().getItemName().equals(na))
             return itt.getItem();
            
            itt = itt.getNext();
        }
        
        return null;
        
    }
    
    
    public Item searchByPrice(double p) {
        Node<Item> itt = items.getHead();
        
        for(int i = 0 ; i < items.getSize() ; i++) {
            if(itt.getItem().getItemPrice() == p)
             return itt.getItem();
            
            itt = itt.getNext();
        }
        
        return null;
        
    }
    
    public void printOrder() {
        
       
        Node<Item> cur = items.getHead();
         for(int i = 0 ; i < items.getSize() ; i++) {
             System.out.println("            Item #"+(i+1));
             System.out.println(cur.getItem().toString());
             cur = cur.getNext();
         }
        
    }
}
