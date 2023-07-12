public class String1{
    public static void main(String[] args){

        // Using String Object - Immutable
        String s = new String("Aditya");
        s.concat("Vaste");

        System.out.println(s);

        // Using StringBuffer Object - Mutable
        StringBuffer sb = new StringBuffer("Aditya");
        sb.append("Vaste");

        System.out.println(sb);
    }
}
