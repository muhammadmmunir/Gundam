package boardGame;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class Camera {

    private float x, y, z, rx, ry, rz;
    private float angle, ratio, near, far;
    public Camera(float angle, float ratio, float near, float far) {
        x = 0;
        y = 0;
        z = 0;
        rx = 0;
        ry = 0;
        rz = 0;
        this.angle = angle;
        this.ratio = ratio;
        this.near = near;
        this.far = far;
        initProjection();
    }

    private void initProjection() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(angle, ratio, near, far);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_DEPTH_TEST);        
        glEnable(GL_TEXTURE_2D);
    }

    //meng-update kamera
    public void setView() {
        glRotatef(rx, 1, 0, 0);
        glRotatef(ry, 0, 1, 0);
        glRotatef(rz, 0, 0, 1);
        glTranslatef(x, y, z);
    }

    //Perputaran dan perpindahan kamera
    public void moveForward() { this.z += 0.5f; }
    public void moveBackward() { this.z -= 0.5f; }
    public void moveRight() { this.x += 0.5f; }
    public void moveLeft() { this.x -= 0.5f; }
    public void moveUp() { this.y += 0.5f; }
    public void moveDown() { this.y -= 0.5f; }    
    public void Roll() { this.rx -= 5f; }
    public void revRoll() { this.rx += 5f; }    
    public void Pitch() { this.ry += 5; }
    public void revPitch() { this.ry -= 5; }
    public void Yaw() { this.rz += 5; }    
    public void revYaw() { this.rz -= 5; }    
}