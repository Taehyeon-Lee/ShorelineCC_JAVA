public class AssassinNode {

   public final String name;
   public String assassin;
   public AssassinNode next;
   
   
   public AssassinNode(String name) {
      this.name = name;
      this.assassin = null;
      this.next = null;
   }

   public AssassinNode(String name, AssassinNode next) {
      this.name = name;
      this.assassin = null;
      this.next = next;
   }


}