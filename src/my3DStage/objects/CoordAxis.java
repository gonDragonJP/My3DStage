package my3DStage.objects;

import java.nio.FloatBuffer;

import com.jogamp.opengl.GL2;

import myJOGL_v2_1.My3DVectorF;
import myJOGL_v2_1.MyGLUtil;

public class CoordAxis {

	private CoordAxis() {
		
	}
	
	private static GL2 gl2;
	
	public static void draw(GL2 argGL2, float scaleMax, float scaleUnit){
		
		gl2 = argGL2;
		
		gl2.glPushAttrib(GL2.GL_ALL_ATTRIB_BITS);
		
		gl2.glDisable(GL2.GL_LIGHTING);
		gl2.glColor4f(1f, 1f, 1f, 1f);
		
		drawAxis(scaleMax);
		drawXZPlane(scaleMax, scaleUnit);
		
		gl2.glPopAttrib();
	}
	
	private static void drawXZPlane(float scaleMax, float scaleUnit){
		
		My3DVectorF start = new My3DVectorF();
		My3DVectorF end = new My3DVectorF();
		
		for(float x=0; x<scaleMax; x+=scaleUnit) {
			
			start.set(x, 0, -scaleMax);
			end.set(x, 0, scaleMax);		
			MyGLUtil.drawLine(start, end);
			
			start.set(-x, 0, -scaleMax);
			end.set(-x, 0, scaleMax);		
			MyGLUtil.drawLine(start, end);
		}
		
		for(float z=0; z<scaleMax; z+=scaleUnit) {
			
			start.set(-scaleMax, 0, z);
			end.set(scaleMax, 0, z);
			MyGLUtil.drawLine(start, end);
			
			start.set(-scaleMax, 0, -z);
			end.set(scaleMax, 0, -z);
			MyGLUtil.drawLine(start, end);
		}
	}
	
	private static void drawAxis(float scaleMax) {
		
		My3DVectorF start = new My3DVectorF();
		My3DVectorF end = new My3DVectorF();
		
		gl2.glPushAttrib(GL2.GL_ALL_ATTRIB_BITS);
		
		start.set(0, 0, 0);
		
		gl2.glColor4f(1f, 0, 0, 1f);
		end.set(scaleMax, 0, 0);
		MyGLUtil.drawLine(start, end);
		
		gl2.glColor4f(0, 1f, 0, 1f);
		end.set(0, scaleMax, 0);
		MyGLUtil.drawLine(start, end);
		
		gl2.glColor4f(0, 0, 1f, 1f);
		end.set(0, 0, scaleMax);
		MyGLUtil.drawLine(start, end);
		
		gl2.glPopAttrib();
		
		start.set(0, -scaleMax, 0);
		end.set(0, scaleMax, 0);
		MyGLUtil.drawLine(start, end);
	}
}
