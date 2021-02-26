import java.awt.Color;

public class GammaCorrectionPink {
    
    public static MyImage execute(MyImage input) {
	
	MyImage output = new MyImage(input.width, input.height);
	
	for(int i = 0; i < input.height; i++) {
	    for(int j = 0; j < input.width; j++) {
		
		Color color1 = input.getColor(j, i);
		
		int r = color1.getRed();
		int g = color1.getGreen();
		int b = color1.getBlue();

		int r2 = (int)Math.round(255*Math.pow(((double)r/255), 1/2.8));
		int g2 = (int)Math.round(255*Math.pow(((double)g/255), 1/1.6));
		int b2 = (int)Math.round(255*Math.pow(((double)b/255), 1/2.4));
		
		Color color2 = new Color(r2, g2, b2);
		
		output.setColor(j, i, color2);
	    }
	}
	
	return output;
    }   
}
