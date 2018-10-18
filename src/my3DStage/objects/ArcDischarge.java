package my3DStage.objects;

import com.jogamp.opengl.GL2;

import myJOGL_v2_1.My3DVectorF;
import myJOGL_v2_1.MyGLUtil;

public class ArcDischarge {

	private GL2 gl2;

	private My3DVectorF posN, velN, posS, velS;
	private My3DVectorF zeroVec, oldPos, randVel, vecNS;

	private final float randVelFactor = 0.2f;

	public void draw(GL2 argGL2) {

		gl2 = argGL2;

		gl2.glPushAttrib(GL2.GL_ALL_ATTRIB_BITS);

		gl2.glDisable(GL2.GL_LIGHTING);
		
		
		double radian = 3.1415926/180;
		double angle =0, radius;
		
		for(int i=0; i<5; i++) {
			
			angle += Math.random() * 100;
			radius = Math.random() * 3 + 3;
			
			float x = (float)(Math.cos(radian * angle) * radius);
			float z = (float)(Math.sin(radian * angle) * radius);
			
			initialize(x, z);
			discharge();
		}
		
		gl2.glPopAttrib();
	}

	private void initialize(float x, float z) {

		posN = new My3DVectorF(x, 0, z);
		velN = new My3DVectorF(0, 3, 0);

		posS = new My3DVectorF(-x, 0, -z);
		velS = new My3DVectorF(0, 3, 0);

		zeroVec = new My3DVectorF(0,0,0);
		randVel = new My3DVectorF();
		vecNS = new My3DVectorF();
		oldPos = new My3DVectorF();
	}
	
	private float getRandVelCoe() {
		
		return (float)Math.random() * (randVelFactor * 2) - randVelFactor;
	}

	private void discharge() {
		
		float NSLength, velLength;
		
		do {
			vecNS.set(posS);
			vecNS.minus(posN);
			NSLength = My3DVectorF.distance(vecNS, zeroVec);
			
			velLength = My3DVectorF.distance(velN, zeroVec);
			randVel.set(velLength * getRandVelCoe(), velLength * getRandVelCoe(), velLength * getRandVelCoe());
			
			velN.mult(0.6f);
			velN.plus(randVel);
			vecNS.mult(0.1f);
			velN.plus(vecNS);
				
			oldPos.set(posN);
			posN.plus(velN);
				
			drawGradLine(oldPos, posN);
			
			//
			
			vecNS.set(posN);
			vecNS.minus(posS);
			NSLength = My3DVectorF.distance(vecNS, zeroVec);
			
			velLength = My3DVectorF.distance(velS, zeroVec);
			randVel.set(velLength * getRandVelCoe(), velLength * getRandVelCoe(), velLength * getRandVelCoe());
			
			velS.mult(0.6f);
			velS.plus(randVel);
			vecNS.mult(0.1f);
			velS.plus(vecNS);
				
			oldPos.set(posS);
			posS.plus(velS);
				
			drawGradLine(oldPos, posS);
		
		}while(NSLength >1);
	
		drawGradLine(posN, posS);
	}
	
	private void drawGradLine(My3DVectorF start, My3DVectorF end) {
		
		gl2.glColor4f(1f, 1f, 0, 1f);
		MyGLUtil.setLineWidth(0);
		MyGLUtil.drawLine(start, end);
		
		gl2.glColor4f(1f, 1f, 1f, 1f);
		MyGLUtil.setLineWidth(0.1f * (float)Math.random());
		MyGLUtil.drawLine(start, end);
		
	}
}
