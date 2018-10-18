package my3DStage;

public class DataContainer {
	
	int screenX = 256;
	int screenY = 256;
	float fovy = 100;		//画面縦方向のカメラの画角
	
	boolean isEnableAxisPlaneDraw = false;
	float scaleMax = 1000;
	float scaleUnit = 1;
	
	float cameraPos_x = 0;
	float cameraPos_y = 30;
	float cameraPos_z = 0.01f;
			;
	
	float lookPoint_x = 0;
	float lookPoint_y = 0;
	float lookPoint_z = 0;
	
	float textureTransparency = 60; //Textureのアルファ値に乗算された透明度となります
	
	boolean isEnableTestDraw = false;
}
