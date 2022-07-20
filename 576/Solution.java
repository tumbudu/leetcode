class Solution {
    private long totalOB = 0;
    private int m;
    private int n;


    
    public int findPaths(int m1, int n1, int maxMove, int startRow, int startColumn) {
        HashMap<String, MyCell> aList= new HashMap<String, MyCell>();
        MyCell start = new MyCell(startRow, startColumn);
        this.m = m1;
        this.n = n1;
        
        aList.put(start.key(), start);
        
        for(int i=0; i<maxMove; i++){
            HashMap<String, MyCell> newAList = process_move(aList);
            aList = newAList;
        }
        // System.out.println(totalOB);
        return  (int) (totalOB % 1000000007) ;
    }

    
    private void add(HashMap<String, MyCell> alist, MyCell Cell){
        String k = Cell.key();
        MyCell mCell = alist.get(k);
        
        if(mCell == null){
            alist.put(Cell.key(), Cell);
        }else{
            mCell.add(Cell.getPaths());
        }
    }
    
    private HashMap<String, MyCell> process_move(HashMap<String, MyCell> alist){
        HashMap<String, MyCell> newAlist = new HashMap<String, MyCell>();
        
        for (Map.Entry<String, MyCell> e : alist.entrySet()){
            MyCell Cell = e.getValue();
            
            MyCell l = Cell.left();
            if(l.outOfBound(m,n) >0){
                totalOB = (totalOB + l.outOfBound(m,n)% 1000000007) % 1000000007;
            }else{
                add(newAlist, l);
            }
            
            MyCell r = Cell.right();
            if(r.outOfBound(m,n) >0){
                totalOB = (totalOB + r.outOfBound(m,n)% 1000000007) % 1000000007;
            }else{
                add(newAlist, r);
            }
            
            MyCell u = Cell.up();
            if(u.outOfBound(m,n) >0){
                totalOB = (totalOB + u.outOfBound(m,n)% 1000000007) % 1000000007;
            }else{
                add(newAlist, u);                
            }

            MyCell d = Cell.down();
            if(d.outOfBound(m,n) >0){
                totalOB = (totalOB + d.outOfBound(m,n)% 1000000007) % 1000000007;
            }else{
                add(newAlist, d);
            }   
        }
        return newAlist;
    }
}

public class MyCell{
        int r;
        int c;
        long p;
    
        public MyCell(int x, int y){
            this.r = x;
            this.c = y;
            this.p = 1;
        }
    
        public MyCell(int x, int y, long paths){
            this.r = x;
            this.c = y;
            this.p = paths;
        }
        public String toString() {
            String paths = Long.toString(this.p);
            String k = key();
            return k + " paths:" + paths;
        }
        
        public long getPaths(){
            return this.p;
        }
    
        public void add(long paths){
            this.p += paths;
        }
    
        public String key(){
            String str1 = Integer.toString(this.r);
            String str2 = Integer.toString(this.c);
            return str1+"#"+str2;
        }
        
        public long outOfBound(int m, int n){
            if(this.r<0 || this.c<0 || this.r >= m || this.c >=n )
                return this.p;
            return 0;
        }

        public MyCell up(){
            return new MyCell(this.r-1, this.c, this.p);
        }
        public MyCell left(){
            return new MyCell(this.r, this.c-1, this.p);
        }
        public MyCell down(){
            return new MyCell(this.r+1, this.c, this.p);
        }
        public MyCell right(){
            return new MyCell(this.r, this.c+1, this.p);
        }
    }
