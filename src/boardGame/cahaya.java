package boardGame;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;

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
public class cahaya {
	public FloatBuffer floatBuffer(float a, float b, float c, float d)
    {
    float[] data = new float[]{a,b,c,d};
    FloatBuffer fb = BufferUtils.createFloatBuffer(data.length);
    fb.put(data);
    fb.flip();
    return fb;
     }

void lampu(){
  GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_LIGHT0);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glShadeModel(GL_SMOOTH);
        GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE,floatBuffer(1f,1f,1f,1f));
        GL11.glMaterial(GL_FRONT, GL_DIFFUSE,floatBuffer(0f,1f,0f,1f));
        GL11.glLight(GL11.GL_LIGHT0,GL11.GL_POSITION,floatBuffer(4f, 2f, -3f,2f));
//        //lampu atas
//        GL11.glBegin(GL11.GL_POLYGON);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.5f, 2f, -3.5f);
//        //GL11.glTexCoord3d(0, 1, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 2f, -4.0f);
//        //GL11.glTexCoord3d(1, 1, 1);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 2f, -4.0f);
//        //GL11.glTexCoord3d(1, 0, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.5f, 2f, -3.5f);
//        //GL11.glTexCoord3d(0, 0, 0);
//        glEnd();
//        
//        //lampu bawah
//        GL11.glBegin(GL11.GL_POLYGON);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.5f, 1f, -3.5f);
//        //GL11.glTexCoord3d(0, 1, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 1f, -4.0f);
//        //GL11.glTexCoord3d(1, 1, 1);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 1f, -4.0f);
//        //GL11.glTexCoord3d(1, 0, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.5f, 1f, -3.5f);
//        //GL11.glTexCoord3d(0, 0, 0);
//        glEnd();
//       
//        //lampu kiri
//        GL11.glBegin(GL11.GL_POLYGON);
//        glColor3f(1, 1, 1);
//        GL11.glVertex3f(4.5f, 1f, -4.0f);
//        //GL11.glTexCoord3d(0, 1, 0);
//        glColor3f(1, 1, 1);
//        GL11.glVertex3f(4.5f, 1f, -3.5f);
//        //GL11.glTexCoord3d(1, 1, 1);
//        glColor3f(1, 1, 1);
//        GL11.glVertex3f(4.5f, 2f, -3.5f);
//        //GL11.glTexCoord3d(1, 0, 0);
//        glColor3f(1, 1, 1);
//        GL11.glVertex3f(4.5f, 2f, -4.0f);
//        //GL11.glTexCoord3d(0, 0, 0);
//        glEnd();
//        
//        //lampu kanan
//        GL11.glBegin(GL11.GL_POLYGON);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 1f, -4.0f);
//        //GL11.glTexCoord3d(0, 1, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 1f, -3.5f);
//        //GL11.glTexCoord3d(1, 1, 1);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 2f, -3.5f);
//        //GL11.glTexCoord3d(1, 0, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 2f, -4.0f);
//        //GL11.glTexCoord3d(0, 0, 0);
//        glEnd();
//       
//        //lampu depan
//        GL11.glBegin(GL11.GL_POLYGON);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.5f, 1f, -3.5f);
//        //GL11.glTexCoord3d(0, 1, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 1f, -3.5f);
//        //GL11.glTexCoord3d(1, 1, 1);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 2f, -3.5f);
//        //GL11.glTexCoord3d(1, 0, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.5f, 2f, -3.5f);
//        //GL11.glTexCoord3d(0, 0, 0);
//        glEnd();
//        
//        //lampu belakang
//        GL11.glBegin(GL11.GL_POLYGON);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.5f, 1f, -4.0f);
//        //GL11.glTexCoord3d(0, 1, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 1f, -4.0f);
//        //GL11.glTexCoord3d(1, 1, 1);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.8f, 2f, -4.0f);
//        //GL11.glTexCoord3d(1, 0, 0);
//        glColor3f(0, 1, 0);
//        GL11.glVertex3f(4.5f, 2f, -4.0f);
//        //GL11.glTexCoord3d(0, 0, 0);
//        glEnd();
      }
      
}
 