class perm
{
  public static void main(String [] args)
  {
  String s1 = "ram";
  String s2 = "r";
  char ch1[] = s1.toCharArray();
  char ch2[] = s2.toCharArray();
  java.util.Arrays.sort(ch1);
  java.util.Arrays.sort(ch2);
  
  s1 = new String(ch1);
  s2 = new String(ch2);
  if(s1.equals(s2))
    System.out.println("true");
  else
    System.out.print("false");
  }
}







