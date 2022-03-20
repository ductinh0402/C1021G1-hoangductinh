public class test {
    public static void main(String[] args) {
        int number=7;
        triangle(7);
    }
    public static void triangle(int number){
        String shape="";
        for (int i = 1; i <=number ; i++) {
            for (int j = 1; j <=number ; j++) {
                if (i==number){
                    shape+="*" ;
                }else if (j==1||j==i){
                    shape += "*";
                }else {
                    shape+=" ";
                }


            }
            shape+="\n";
        }
        System.out.println(shape);
    }
}
