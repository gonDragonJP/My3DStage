package my3DStage.objects;

import java.nio.FloatBuffer;

import com.jogamp.opengl.GL2;

import myJOGL_v2_1.My3DVectorF;

public class CoordAxis {

	private CoordAxis() {
		
	}
	
	private static GL2 gl2;
	
	public static void draw(GL2 argGL2){
		
		gl2 = argGL2;
		
		gl2.glDisable(GL2.GL_LIGHTING);
		drawAxis();
		gl2.glEnable(GL2.GL_LIGHTING);
	}
	
	private static void drawAxis(){
		
		My3DVectorF start = new My3DVectorF();
		My3DVectorF end = new My3DVectorF();
		
		for(int x=-1000; x<1000; x++) {
			
			start.set(x, 0, -1000);
			end.set(x, 0, 1000);
		
			gl2.glBegin(GL2.GL_LINE_STRIP);
				gl2.glVertex3fv(start.getFloatBuffer());
				gl2.glVertex3fv(end.getFloatBuffer());
			gl2.glEnd();
		}
		
		for(int z=-1000; z<1000; z++) {
			
			start.set(-1000, 0, z);
			end.set(1000, 0, z);
		
			gl2.glBegin(GL2.GL_LINE_STRIP);
				gl2.glVertex3fv(start.getFloatBuffer());
				gl2.glVertex3fv(end.getFloatBuffer());
			gl2.glEnd();
		}
		
		start.set(0, -1000, 0);
		end.set(0, 1000, 0);
	
		gl2.glBegin(GL2.GL_LINE_STRIP);
			gl2.glVertex3fv(start.getFloatBuffer());
			gl2.glVertex3fv(end.getFloatBuffer());
		gl2.glEnd();
	}
}
