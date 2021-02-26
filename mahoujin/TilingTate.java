import java.awt.*;

public class TilingTate {
    
    static MyImage execute(MyImage input1, MyImage input2) { 
      
	int width1 = input1.width;
	int width2 = input2.width;
	int height1 = input1.height;
	int height2 = input2.height;
	
	int width  = width1;
	int height = height1 + height2;
	
	MyImage output = new MyImage(width, height);
	
	for(int i = 0; i < height; i++) {
	    for(int j = 0; j < width; j++) {
				
		if(i < height1 && j < width1) {   
		    Color color1 = input1.getColor(j, i);
		    output.setColor(j, i, color1);     
		}
		
		if(i < height2 && j < width2) {
		    Color color2 = input2.getColor(j, i);
		    output.setColor(j, i+height1, color2);
		}
	    }
	}
	
	return output;
	
    }    
}
