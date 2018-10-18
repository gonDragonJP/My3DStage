package my3DStage;

public class DataContainer {
	
	int screenX = 640;
	int screenY = 640;
	float fovy = 100;		//画面縦方向のカメラの画角
	
	boolean isEnableAxisPlaneDraw = true;
	float scaleMax = 1000;
	float scaleUnit = 1;
	
	float cameraPos_x = 10;
	float cameraPos_y = 10;
	float cameraPos_z = 10;
	
	float lookPoint_x = 0;
	float lookPoint_y = 0;
	float lookPoint_z = 0;
	
	float textureTransparency = 60; //Textureのアルファ値に乗算された透明度となります
	
	boolean isEnableTestDraw = true;
}
