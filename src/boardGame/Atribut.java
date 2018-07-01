package boardGame;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glRotatef;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.Color;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.math.*;
public class Atribut {
	
	void DrawLine(float x1, float y1, float x2, float y2, float tempat) {
	    //pohon depan
		GL11.glBegin(GL11.GL_POLYGON);
		glColor3f(0, 0.4f, 0);
		GL11.glVertex3f(x1, y1, tempat);
		//GL11.glTexCoord3d(0, 1, 0);
		GL11.glVertex3f(x2, y1, tempat);
		//GL11.glTexCoord3d(1, 1, 1);
		GL11.glVertex3f(x2, y2, tempat);
		//GL11.glTexCoord3d(1, 0, 0);
		GL11.glVertex3f(x1, y2, tempat);
		//GL11.glTexCoord3d(0, 0, 0);
		glEnd();
		
		//pohon belakang
		GL11.glBegin(GL11.GL_POLYGON);
		glColor3f(0, 0.4f, 0);
		GL11.glVertex3f(x1, y1, tempat-0.5f);
		//GL11.glTexCoord3d(0, 1, 0);
		GL11.glVertex3f(x2, y1, tempat-0.5f);
		//GL11.glTexCoord3d(1, 1, 1);
		GL11.glVertex3f(x2, y2, tempat-0.5f);
		//GL11.glTexCoord3d(1, 0, 0);
		GL11.glVertex3f(x1, y2, tempat-0.5f);
		//GL11.glTexCoord3d(0, 0, 0);
		glEnd();
		
		//pohon kiri
		GL11.glBegin(GL11.GL_POLYGON);
		glColor3f(0, 0.7f, 0);
		GL11.glVertex3f(x1, y1, tempat);
		//GL11.glTexCoord3d(0, 1, 0);
		GL11.glVertex3f(x1, y1, tempat-0.5f);
		//GL11.glTexCoord3d(1, 1, 1);
		GL11.glVertex3f(x1, y2, tempat-0.5f);
		//GL11.glTexCoord3d(1, 0, 0);
		GL11.glVertex3f(x1, y2, tempat);
		//GL11.glTexCoord3d(0, 0, 0);
		glEnd();
		
		//pohon kanan
		GL11.glBegin(GL11.GL_POLYGON);
		glColor3f(0, 0.7f, 0);
		GL11.glVertex3f(x2, y1, tempat);
		//GL11.glTexCoord3d(0, 1, 0);
		GL11.glVertex3f(x2, y1, tempat-0.5f);
		//GL11.glTexCoord3d(1, 1, 1);
		GL11.glVertex3f(x2, y2, tempat-0.5f);
		//GL11.glTexCoord3d(1, 0, 0);
		GL11.glVertex3f(x2, y2, tempat);
		//GL11.glTexCoord3d(0, 0, 0);
		glEnd();
		
		//pohon atas
		GL11.glBegin(GL11.GL_POLYGON);
		glColor3f(0, 0.5f, 0);
		GL11.glVertex3f(x1, y2, tempat);
		//GL11.glTexCoord3d(0, 1, 0);
		GL11.glVertex3f(x2, y2, tempat);
		//GL11.glTexCoord3d(1, 1, 1);
		GL11.glVertex3f(x2, y2, tempat-0.5f);
		//GL11.glTexCoord3d(1, 0, 0);
		GL11.glVertex3f(x1, y2, tempat-0.5f);
		//GL11.glTexCoord3d(0, 0, 0);
		glEnd();
		
		//pohon bawah
		GL11.glBegin(GL11.GL_POLYGON);
		glColor3f(0, 0.5f, 0);
		GL11.glVertex3f(x1, y1, tempat);
		//GL11.glTexCoord3d(0, 1, 0);
		GL11.glVertex3f(x2, y1, tempat);
		//GL11.glTexCoord3d(1, 1, 1);
		GL11.glVertex3f(x2, y1, tempat-0.5f);
		//GL11.glTexCoord3d(1, 0, 0);
		GL11.glVertex3f(x1, y1, tempat-0.5f);
		//GL11.glTexCoord3d(0, 0, 0);
		glEnd();
	}
	 
	void DrawLineFlower(float x1, float y1, float x2, float y2, float tempat){
	    DrawLine(x1, y1, x2, y2, tempat);
	    float Radius = (float) Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	    glBegin(GL_POLYGON);
	    glColor3f(0f, 1f, 0f);
	        glVertex3f(x2-0.2f*Radius, y2, tempat+0.01f);
	        glVertex3f(x2, y2+0.2f*Radius, tempat+0.01f);
	        glVertex3f(x2+0.2f*Radius, y2, tempat+0.01f);
	        glVertex3f(x2, y2-0.2f*Radius, tempat+0.01f);
	    glEnd();
	    
	    glBegin(GL_POLYGON);
	    glColor3f(0f, 1f, 0f);
	        glVertex3f(x2-0.2f*Radius, y2, tempat-0.52f);
	        glVertex3f(x2, y2+0.2f*Radius, tempat-0.52f);
	        glVertex3f(x2+0.2f*Radius, y2, tempat-0.52f);
	        glVertex3f(x2, y2-0.2f*Radius, tempat-0.52f);
	    glEnd();
	    
	}
	 
	void DrawTree(float x, float y,float tempat, float length, float theta, float dTheta, int orde){
	    float x0 = x;
	    float y0 = y;
	    float x1, y1, x2, y2;
	    float mTheta = theta+dTheta;
	    float nTheta = theta-dTheta;
	    x1 = (float) (x0 + length*Math.cos(mTheta));
	    y1 = (float) (y0 + length*Math.sin(mTheta));
	    x2 = (float) (x0 + length*Math.cos(nTheta));
	    y2 = (float) (y0 + length*Math.sin(nTheta));
	    if (orde == 0){
	        DrawLineFlower(x0, y0, x1, y1,tempat);
	        DrawLineFlower(x0, y0, x2, y2,tempat);}
	    else{
	        DrawLine(x0, y0, x1, y1,tempat);
	        length = (float) (length/Math.sqrt(1.8));
	        dTheta = dTheta/1.2f;
	        DrawTree(x1, y1,tempat, length, mTheta, dTheta, orde-1);
	        DrawTree(x2, y2,tempat, length, nTheta, dTheta, orde-1);
	        DrawLineFlower(x0, y0, x1, y1,tempat);
	        DrawLineFlower(x0, y0, x2, y2,tempat);
	        }
	}
	 
	void Draw(){
			DrawLine(1.4f, 1.0f, 1.1f, 2.5f,-7.5f);
			//DrawLineFlower(4.4f, 2.5f, 4.6f, 3.5f,-7.5f);
			DrawTree(1.5f, 3.0f,-7.5f, 0.5f, 1.3f, 1.3f, 8);
			DrawLine(-1.7f, 1.0f, -2f, 2.5f,-7.5f);
			DrawTree(-1.8f, 3.0f,-7.5f, 0.5f, 1.3f, 1.3f, 8);
	}
	
public static void Grass(float x, float y, float z){
				
				// rumput depan
				GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glColor3f(0f, 1f, 0.5f);
				GL11.glVertex3f(4.2f + x, 1f + y, -0.4f + z);
				GL11.glVertex3f(4.3f + x, 1f + y, -0.4f + z);
				GL11.glVertex3f(4.25f + x, 1.2f + y, -0.45f + z);
				glEnd();
				
				// rumput kanan
				GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glColor3f(0f, 1f, 0.5f);
				GL11.glVertex3f(4.25f + x, 1f + y, -0.45f + z);
				GL11.glVertex3f(4.3f + x, 1f + y, -0.4f + z);
				GL11.glVertex3f(4.25f + x, 1.2f + y, -0.45f + z);
				glEnd();
				
				// rumput kiri
				GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glColor3f(0f, 1f, 0.5f);
				GL11.glVertex3f(4.2f + x, 1f + y, -0.4f + z);
				GL11.glVertex3f(4.25f + x, 1f + y, -0.45f + z);
				GL11.glVertex3f(4.25f + x, 1.2f + y, -0.45f + z);
				glEnd();
						
			
	}
	

	public static void gambarrumput(int order, float x,float z){
		if(order==0){
			Grass(0,0,0);
		}
		else{
			z-=0.1f;
			Grass(x,0,z);
			gambarrumput(order-1,x,z);
			gambarrumput(order-1,x+0.1f,z);
			if(order%3==0){
				x+=0.1f;
				z=0;
				gambarrumput(order-1,x,z);
				gambarrumput(order-1,x+0.1f,z);
			}
		}
	}
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
}