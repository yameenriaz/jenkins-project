public class Rectangulator {

   public static void main(String[] args){

	int length = Integer.parseInt(args[0]);
        int width  = Integer.parseInt(args[1]);

	Rectangle myRectangle = new Rectangle(length,width);
	String output = String.format("*** Your Rectanble ***\n\n Length: %d\nWidth: %d\nArea: %d\nPermieter: %d\n\n",myRectangle.length,myRectangle.width,myRectangle.getArea(),myRectangle.getPerimeter());
        System.out.println(output);      
   }

}
