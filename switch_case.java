public class switch_case{
    public static void main(String[] args){
       int dayOfWeek = 6;
       String schedule;

       switch(dayOfWeek){
           case 1: {
               schedule = "Gym in the morning!";
               break;
           } case 2: {
               schedule = "Class after work!";
               break;
           } case 3: {
               schedule = "Meetings all day";
               break;
           } case 4: {
               schedule = "Work from Home!";
               break;
           } case 5: {
               schedule = "Game night after work!";
               break;
           } default: {
               schedule = "Freeeee!!";
               break;
           }
       }
       System.out.println(schedule);
    }
}