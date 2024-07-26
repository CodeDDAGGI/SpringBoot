class Main {
    public static void main(String[] args) {
        int[] a = {4, 7, 1, 2};
        for(int i=0; i<3; i++) {
            for(int j=i+1; j<4; j++) {
                if(a[i] > a[j]) {
                    System.out.println(a[i]); // i[0] = 4 j= [1] 7
                    System.out.println(a[j]); //
                    System.out.println();
                    int temp = a[j];
                    System.out.println(temp);
                    System.out.println(a[j]);
                    System.out.println();
                    a[j] = a[i];
                    System.out.println(a[j]);
                    System.out.println(a[i]);
                    System.out.println();
                    a[i] = temp;
                    System.out.println(a[i]);
                    System.out.println(temp);
                    System.out.println();
                }
            }
        }
        for(int i=0; i<4; i++) {
            System.out.print(a[i] + "a");
        }
    }
}