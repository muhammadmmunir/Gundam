package boardGame;
import java.nio.FloatBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
public class Main {
	static int rumput = 0;
	static int x = 0, y = 0, z = 0; // koordinat
	
	//pengaturan pergerakan kamera
	public static void cameraMove(Camera camera) {
		//putar ke sumbu z searah jarum jam
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)
				&& Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			camera.Yaw();
		}
		//putar ke sumbu z berlawanan arah jarum jam
		else if (Keyboard.isKeyDown(Keyboard.KEY_UP)
				&& Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			camera.revYaw();
		}
		//memajukan kamera
		else if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)
				&& Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			camera.moveForward();
		}
		//memundurkan kamera
		else if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)
				&& Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			camera.moveBackward();
		}
		//menggeser kamera ke samping kiri
		else if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)
				&& Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			camera.moveRight();
		}
		//menggeser kamera ke samping kanan
		else if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)
				&& Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			camera.moveLeft();
		}
		//putar kearah belakang
		else if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			camera.revRoll();
		}
		//putar kearah depan
		else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			camera.Roll();
		}
		//putar kearah kanan
		else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			camera.Pitch();
		}
		//putar kearah kiri
		else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			camera.revPitch();
		}
		//update kamera
		camera.setView();
	}

	//pengaturan pergerakan robot (gundam)
	public static void gundamMove(float x1, Texture badanDepan, Texture badanBelakang, Texture badanSampingKiri, Texture badanSampingKanan, Texture badanBawah, Texture kakiDepan, Texture kakiSamping, Texture kakiBelakang, Texture kepalaDepan, Texture kepalaBelakang, Texture kepalaKanan, Texture kepalaKiri, Texture kepalaAtas, Texture kepalaBawah, Texture tanganDepan, Texture tanganBelakang, Texture tanganSamping, Texture tanganAtas, Texture tanganBawahKiri, Texture tanganBawahKanan) {
		while (Keyboard.next()) {
			if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
				if (!(x == 0 || z == -10)) {
					gundam(x -= 2, y, z -= 2,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				}
			} else if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
				if (!(x == 8 || z == -10)) {
					gundam(x += 2, y, z -= 2,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				}
			} else if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
				if (!(x == 0 || z == 0)) {
					gundam(x -= 2, y, z += 2,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				}
			} else if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
				if (!(x == 8 || z == 0)) {
					gundam(x += 2, y, z += 2,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				}
			} else if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				if (z != -10) {
					gundam(x, y, z -= 2,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				}
			} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				if (z != 0) {
					gundam(x, y, z += 2,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				}
			} else if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				if (x != 0) {
					gundam(x -= 2, y, z,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				}
			} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				if (x != 8) {
					gundam(x += 2, y, z,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				}
			}
		}
		//rotasi sumbu y
		if (x == 4 && z == -4) {
			glRotatef(-x1, 0, 5f, 0);
		}
		//mengecil setengah kali
		else if (x == 0 && z == -6) {
			glScalef(0.5f, 0.5f, 0.5f);
			glTranslatef(-4f, 1, -2f);
			gundam(x,y,z,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
		}
		//membesar dua kali
		else if (x == 0 && z == -10) {
			glScalef(2, 2, 2);
			glTranslatef(1.95f, -0.5f, 2.8f);
			gundam(x,y,z,badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
		}
	}

	public static void main(String[] args) {
      	display();
		render();
	}

	//mengambil file untuk texture
	public static Texture loadTexture(String key) {
		try {
			return TextureLoader.getTexture("jpg", new FileInputStream(
					new File("gundam/" + key + ".jpg")));
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	public static void gambarKubus(float xBawah, float xAtas, float yBawah, float yAtas, float zBawah, float zAtas, int r, int g, int b) {
        glBegin(GL_QUADS);
        {
//           ----------------UP----------------  papan
            glColor3f(r, g, b);
            glBegin(GL_QUADS);
            {
                glVertex3f(xBawah, yAtas, zBawah);
                glVertex3f(xBawah, yAtas, zAtas);
                glVertex3f(xAtas, yAtas, zBawah);
                glVertex3f(xAtas, yAtas, zAtas);
            }
//          --------------BOTTOM--------------
            glBegin(GL_QUADS);
            {
                glVertex3f(xBawah, yBawah, zBawah);
                glVertex3f(xBawah, yBawah, zAtas);
                glVertex3f(xAtas, yBawah, zAtas);
                glVertex3f(xAtas, yBawah, zBawah);
            }
//          --------------FRONT---------------
            glBegin(GL_QUADS);
            {
                glVertex3f(xBawah, yBawah, zBawah);
                glVertex3f(xBawah, yAtas, zBawah);
                glVertex3f(xAtas, yAtas, zBawah);
                glVertex3f(xAtas, yBawah, zBawah);
            }
//          --------------BACK----------------
            glBegin(GL_QUADS);
            {
                glVertex3f(xBawah, yBawah, zAtas);
                glVertex3f(xBawah, yAtas, zAtas);
                glVertex3f(xAtas, yAtas, zAtas);
                glVertex3f(xAtas, yBawah, zAtas);
            }
//          --------------RIGHT---------------
            glBegin(GL_QUADS);
            {
                glVertex3f(xAtas, yBawah, zBawah);
                glVertex3f(xAtas, yAtas, zBawah);
                glVertex3f(xAtas, yAtas, zAtas);
                glVertex3f(xAtas, yBawah, zAtas);
            }
//          ---------------LEFT---------------
            glBegin(GL_QUADS);
            {
                glVertex3f(xBawah, yBawah, zBawah);
                glVertex3f(xBawah, yAtas, zBawah);
                glVertex3f(xBawah, yAtas, zAtas);
                glVertex3f(xBawah, yBawah, zAtas);
            }
        }
        glEnd();
        glColor3f(0, 1, 0);
    }
	//Rendering
	public static void render() {
		Camera camera = new Camera(70, (float) Display.getWidth()/ Display.getHeight(), 1, 100);
		float loop = 0; // looping rotation
		//Texture latar = loadTexture("latar");
		Texture kakiDepan = loadTexture("kaki_depan");
		Texture kakiSamping = loadTexture("kaki_samping");
		Texture kakiBelakang = loadTexture("kaki_belakang");
		Texture badanBawah = loadTexture("badan_bawah");
		Texture badanDepan = loadTexture("badan_depan");
		Texture badanSampingKanan = loadTexture("badan_samping_kanan");
		Texture badanSampingKiri = loadTexture("badan_samping_kiri");
		Texture badanBelakang = loadTexture("badan_belakang");
		Texture kepalaDepan = loadTexture("kepala_depan");
		Texture kepalaBelakang = loadTexture("kepala_belakang");
		Texture kepalaKanan = loadTexture("kepala_kanan");
		Texture kepalaBawah = loadTexture("kepala_bawah");
		Texture kepalaAtas = loadTexture("kepala_atas");
		Texture tanganDepan = loadTexture("tangan_depan");
		Texture tanganBelakang = loadTexture("tangan_belakang");
		Texture tanganSamping = loadTexture("tangan_samping");
		Texture tanganAtas = loadTexture("tangan_atas");
		Texture tanganBawahKiri = loadTexture("tangan_bawah_kiri");
		Texture tanganBawahKanan = loadTexture("tangan_bawah_kanan");
		cahaya Light = new cahaya();
		Atribut benda = new Atribut();
		while (!Display.isCloseRequested()) {
			glClearColor(0, 0, 0, 0);
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			glPushMatrix();
			{
				
				//Light.lampu();
				glTranslatef(0, -5, -11);
				cameraMove(camera);
				benda.Draw();
				latar();
				for (int i = -10; i < 11; i++) {
	                float j = 1f;
	                for (int k = -15; k < -6; k++) {
	                    gambarKubus(i, i + 0.01f, j, j + 0.2f, k, k + 0.01f, 0, 1, 0);
	                    if (rumput % 3 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.4f, j + 0.2f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 3 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.4f, j + 0.2f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 3 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.4f, j + 0.2f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.4f, j + 0.2f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 6 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.4f, j + 0.6f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 6 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.4f, j + 0.6f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 6 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.4f, j + 0.6f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.4f, j + 0.6f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 9 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.8f, j + 0.6f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 9 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.8f, j + 0.6f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 9 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.8f, j + 0.6f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.8f, j + 0.6f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 12 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.8f, j + 1f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 12 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.8f, j + 1f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 12 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.8f, j + 1f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.8f, j + 1f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                }
	            }
				//
				for (int i = -10; i < -4; i++) {
	                float j = 1f;
	                for (int k = -7; k < 6; k++) {
	                    gambarKubus(i, i + 0.01f, j, j + 0.2f, k, k + 0.01f, 0, 1, 0);
	                    if (rumput % 3 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.4f, j + 0.2f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 3 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.4f, j + 0.2f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 3 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.4f, j + 0.2f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.4f, j + 0.2f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 6 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.4f, j + 0.6f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 6 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.4f, j + 0.6f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 6 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.4f, j + 0.6f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.4f, j + 0.6f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 9 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.8f, j + 0.6f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 9 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.8f, j + 0.6f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 9 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.8f, j + 0.6f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.8f, j + 0.6f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 12 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.8f, j + 1f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 12 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.8f, j + 1f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 12 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.8f, j + 1f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.8f, j + 1f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                }
	            }
				//
				for (int i = 5; i < 11; i++) {
	                float j = 1f;
	                for (int k = -7; k < 6; k++) {
	                    gambarKubus(i, i + 0.01f, j, j + 0.2f, k, k + 0.01f, 0, 1, 0);
	                    if (rumput % 3 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.4f, j + 0.2f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 3 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.4f, j + 0.2f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 3 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.4f, j + 0.2f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.4f, j + 0.2f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 6 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.4f, j + 0.6f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 6 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.4f, j + 0.6f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 6 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.4f, j + 0.6f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.4f, j + 0.6f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 9 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.8f, j + 0.6f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 9 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.8f, j + 0.6f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 9 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.8f, j + 0.6f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.8f, j + 0.6f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                    if (rumput % 12 == 1) {
	                        gambarKubus(i, i - 0.01f, j + 0.8f, j + 1f, k + 0.02f, k + 0.01f, 0, 1, 0);
	                    } else if (rumput % 12 == 2) {
	                        gambarKubus(i + 0.02f, i + 0.01f, j + 0.8f, j + 1f, k, k - 0.01f, 0, 1, 0);
	                    } else if (rumput % 12 == 3) {
	                        gambarKubus(i, i + 0.01f, j + 0.8f, j + 1f, k, k + 0.01f, 0, 1, 0);
	                    } else {
	                        gambarKubus(i - 0.02f, i - 0.01f, j + 0.8f, j + 1f, k - 0.02f, k - 0.01f, 0, 1, 0);
	                    }
	                }
	            }
	            rumput++;
				papan();
				glDisable(GL_TEXTURE_2D);
				gundamMove(loop, badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKanan, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				gundam(x, y, z, badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah, kakiDepan, kakiSamping, kakiBelakang,kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKanan, kepalaAtas, kepalaBawah,tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
				glEnd();
				glEnable(GL_TEXTURE_2D);
			}
			
			glPopMatrix();
			loop += 5f;
			Display.update();
			Display.sync(50);
		}
	}
	
	public static void gundam(int x, int y, int z, Texture badanDepan, Texture badanBelakang, Texture badanSampingKiri, Texture badanSampingKanan, Texture badanBawah, Texture kakiDepan, Texture kakiSamping, Texture kakiBelakang, Texture kepalaDepan, Texture kepalaBelakang, Texture kepalaKanan, Texture kepalaKiri, Texture kepalaAtas, Texture kepalaBawah, Texture tanganDepan, Texture tanganBelakang, Texture tanganSamping, Texture tanganAtas, Texture tanganBawahKiri, Texture tanganBawahKanan){
		glTranslatef(-4.6f, 0, -1.5f);
		glTranslatef(x, y, z);
		kepala(kepalaDepan, kepalaBelakang, kepalaKanan, kepalaKiri, kepalaAtas, kepalaBawah);
		badan(badanDepan, badanBelakang, badanSampingKiri, badanSampingKanan, badanBawah);
		tangan(tanganDepan, tanganBelakang, tanganSamping, tanganAtas, tanganBawahKiri, tanganBawahKanan);
		kaki(kakiDepan,kakiSamping, kakiBelakang);
		glBegin(GL_QUADS);
	}
	
	//papan
	public static void papan() {
		Texture board = loadTexture("board");
		board.bind();
		glColor3f(1, 1, 1);
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3f(-5, 1, -7);
			glTexCoord2f(0.96f, 0);
			glVertex3f(5, 1, -7);
			glTexCoord2f(0.96f, 0.58f);
			glVertex3f(5, 1, 5);
			glTexCoord2f(0, 0.58f);
			glVertex3f(-5, 1, 5);
		glEnd();
	}
	public static void latar() {
		Texture latar = loadTexture("latar");
		latar.bind();
		glColor3f(1, 1, 1);
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex3f(-10, 0.97f, -15);
			glTexCoord2f(0.96f, 0);
			glVertex3f(10, 0.97f, -15);
			glTexCoord2f(0.96f, 0.58f);
			glVertex3f(10, 0.97f, 5);
			glTexCoord2f(0, 0.58f);
			glVertex3f(-10, 0.97f, 5);
		glEnd();
	}

	//tangan
	public static void tangan(Texture tanganDepan, Texture tanganBelakang, Texture tanganSamping, Texture tanganAtas, Texture tanganBawahKiri, Texture tanganBawahKanan){
		//tangan depan kanan
		tanganDepan.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(1.05f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(1.30f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(1.30f, 1.35f, 5.8f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(1.05f, 1.35f, 5.8f);
		}
		glEnd();
		
		//tangan samping kanan
		tanganSamping.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(1.30f, 1.67f, 5.55f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(1.30f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(1.30f, 1.35f, 5.8f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(1.30f, 1.35f, 5.55f);
		}
		glEnd();
		
		//tangan belakang kanan
		tanganDepan.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(1.05f, 1.67f, 5.55f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(1.30f, 1.67f, 5.55f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(1.30f, 1.35f, 5.55f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(1.05f, 1.35f, 5.55f);
		}
		glEnd();
		
		//tangan atas kanan
		tanganAtas.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(1.05f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(1.30f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(1.30f, 1.67f, 5.55f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(1.05f, 1.67f, 5.55f);
		}
		glEnd();
		
		//tangan bawah kanan
		tanganBawahKanan.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(1.05f, 1.35f, 5.8f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(1.30f, 1.35f, 5.8f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(1.30f, 1.35f, 5.55f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(1.05f, 1.35f, 5.55f);
		}
		glEnd();
		
		//tangan depan kiri
		tanganBelakang.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.05f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(0.3f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(0.3f, 1.35f, 5.8f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(0.05f, 1.35f, 5.8f);
		}
		glEnd();
		
		//tangan samping kiri
		tanganSamping.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.05f, 1.67f, 5.55f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(0.05f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(0.05f, 1.35f, 5.8f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(0.05f, 1.35f, 5.55f);
		}
		glEnd();
		
		//tangan belakang kiri
		tanganBelakang.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.05f, 1.67f, 5.55f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(0.3f, 1.67f, 5.55f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(0.3f, 1.35f, 5.55f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(0.05f, 1.35f, 5.55f);
		}
		glEnd();
		
		//tangan Atas kiri
		tanganAtas.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.05f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(0.3f, 1.67f, 5.8f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(0.3f, 1.67f, 5.55f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(0.05f, 1.67f, 5.55f);
		}
		glEnd();
		
		//tangan bawah kiri
		tanganBawahKiri.bind();		
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.05f, 1.35f, 5.8f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(0.3f, 1.35f, 5.8f);
			glTexCoord2f(0.6f, 0.62f);
				glVertex3f(0.3f, 1.35f, 5.55f);
			glTexCoord2f(0, 0.62f);
				glVertex3f(0.05f, 1.35f, 5.55f);
		}
		glEnd();
	}
	
	//kepala
	public static void kepala(Texture kepalaDepan, Texture kepalaBelakang, Texture kepalaKanan, Texture kepalaKiri, Texture kepalaAtas, Texture kepalaBawah){		
		//kepala bawah
		kepalaBawah.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.1f, 1.67f, 6.2f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.1f, 1.67f, 5.15f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(1.25f, 1.67f, 5.15f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(1.25f, 1.67f, 6.2f);
		}
		glEnd();
		
		//kepala depan  
		kepalaDepan.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.1f, 2.57f, 6.2f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.1f, 1.67f, 6.2f);
			glTexCoord2f(0.57f, 0.83f);
				   glVertex3f(1.25f, 1.67f, 6.2f);
			glTexCoord2f(0, 0.83f);
				   glVertex3f(1.25f, 2.57f, 6.2f);
		}
		glEnd();
		
		//kepala belakang
		kepalaBelakang.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.1f, 2.57f, 5.15f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.1f, 1.67f, 5.15f);
			glTexCoord2f(0.57f, 0.83f);
				   glVertex3f(1.25f, 1.67f, 5.15f);
			glTexCoord2f(0, 0.83f);
				   glVertex3f(1.25f, 2.57f, 5.15f);
		}
		glEnd();
		
		//kepala kanan
		kepalaKanan.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.1f, 2.57f, 6.2f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.1f, 1.67f, 6.2f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(0.1f, 1.67f, 5.15f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(0.1f, 2.57f, 5.15f);
		}
		glEnd();
		//kepala kiri
		kepalaKiri.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(1.25f, 2.57f, 6.2f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(1.25f, 1.67f, 6.2f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(1.25f, 1.67f, 5.15f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(1.25f, 2.57f, 5.15f);
		}
		glEnd();
		
		//kepala atas
		kepalaAtas.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.1f, 2.57f, 6.2f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.1f, 2.57f, 5.15f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(1.25f, 2.57f, 5.15f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(1.25f, 2.57f, 6.2f);
		}
		glEnd();
	}
	
	//badan
	public static void badan(Texture badanDepan, Texture badanBelakang, Texture badanSampingKiri, Texture badanSampingKanan, Texture badanBawah){
		//badan bawah
		badanBawah.bind();  
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.3f, 1.27f, 6f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.3f, 1.27f, 5.35f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(1.05f, 1.27f, 5.35f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(1.05f, 1.27f, 6f);
		}
		glEnd();
		
		//badan depan
		badanDepan.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.3f, 1.67f, 6f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.3f, 1.27f, 6f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(1.05f, 1.27f, 6f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(1.05f, 1.67f, 6f);
		}
		glEnd();
		
		//badan belakang  
		badanBelakang.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.3f, 1.67f, 5.35f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.3f, 1.27f, 5.35f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(1.05f, 1.27f, 5.35f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(1.05f, 1.67f, 5.35f);
		}
		glEnd();
		
		//badan samping kanan
		badanSampingKanan.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.3f, 1.67f, 6f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(0.3f, 1.27f, 6f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(0.3f, 1.27f, 5.35f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(0.3f, 1.67f, 5.35f);
		}
		glEnd();
		
		//badan samping kiri 
		badanSampingKiri.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(1.05f, 1.67f, 6f);
			glTexCoord2f(0.57f, 0);
				glVertex3f(1.05f, 1.27f, 6f);
			glTexCoord2f(0.57f, 0.8f);
				   glVertex3f(1.05f, 1.27f, 5.35f);
			glTexCoord2f(0, 0.8f);
				   glVertex3f(1.05f, 1.67f, 5.35f);
		}
		glEnd();
		
		//badan samping kiri
		badanBawah.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.3f, 1.67f, 6f);
			glTexCoord2f(0.6f, 0);
				glVertex3f(0.3f, 1.67f, 5.35f);
			glTexCoord2f(0.6f, 0.8f);
			   glVertex3f(1.05f, 1.67f, 5.35f);
			glTexCoord2f(0, 0.8f);
			   glVertex3f(1.05f, 1.67f, 6f);
		}
		glEnd();
	}
	
	//kaki
	public static void kaki(Texture kakiDepan, Texture kakiSamping, Texture kakiBelakang){
		// kaki kanan depan
		kakiDepan.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.75f, 1.25f, 5.8f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.75f, 1f, 5.8f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(1f, 1f, 5.8f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(1f, 1.25f, 5.8f);
		}
		glEnd();		
		// kaki kiri depan 
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.35f, 1.25f, 5.8f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.35f, 1f, 5.8f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(0.6f, 1f, 5.8f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(0.6f, 1.25f, 5.8f);
		}
		glEnd();
		
		//kaki kanan samping kanan
		kakiSamping.bind(); 
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(1f, 1.25f, 5.8f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(1f, 1f, 5.8f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(1f, 1f, 5.55f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(1f, 1.25f, 5.55f);
		}
		glEnd();
		// kaki kiri samping kanan 
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.6f, 1.25f, 5.8f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.6f, 1f, 5.8f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(0.6f, 1f, 5.55f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(0.6f, 1.25f, 5.55f);
		}
		glEnd();
		
		//kaki kanan samping kiri
		kakiSamping.bind(); 
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.75f, 1.25f, 5.8f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.75f, 1f, 5.8f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(0.75f, 1f, 5.55f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(0.75f, 1.25f, 5.55f);
		}
		glEnd();
		// kaki kiri samping kiri 
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.35f, 1.25f, 5.8f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.35f, 1f, 5.8f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(0.35f, 1f, 5.55f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(0.35f, 1.25f, 5.55f);
		}
		glEnd();

		//kaki kanan belakang
		kakiBelakang.bind();		 
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.75f, 1.25f, 5.55f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.75f, 1f, 5.55f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(1f, 1f, 5.55f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(1f, 1.25f, 5.55f);
		}
		glEnd();
		// kaki kiri belakang 
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.35f, 1.25f, 5.55f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.35f, 1f, 5.55f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(0.6f, 1f, 5.55f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(0.6f, 1.25f, 5.55f);
		}
		glEnd();
		
		// kaki atas kanan
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.75f, 1.25f, 5.8f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.75f, 1.25f, 5.55f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(1f, 1.25f, 5.55f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(1f, 1.25f, 5.8f);
		}
		glEnd();
		
		// kaki atas kiri
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0);
				glVertex3f(0.35f, 1.25f, 5.8f);
			glTexCoord2f(0.8f, 0);
				glVertex3f(0.35f, 1.25f, 5.55f);
			glTexCoord2f(0.8f, 0.8f);
				glVertex3f(0.6f, 1.25f, 5.55f);
			glTexCoord2f(0, 0.8f);
				glVertex3f(0.6f, 1.25f, 5.8f);
		}
		glEnd();
	}
	
	//window
	public static void display() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Ular Tangga");
			Display.create();
		} catch (LWJGLException e) {
			System.err.println("Error! cannot display.");
			System.exit(1);
		}
	}
	public static FloatBuffer floatbuffer(float a, float b, float c, float d) {
        float[] data = new float[]{a, b, c, d};
        FloatBuffer fb = BufferUtils.createFloatBuffer(data.length);
        fb.put(data);
        fb.flip();
        return fb;
    }
}
