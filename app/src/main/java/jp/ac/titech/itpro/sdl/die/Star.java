package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Star implements Obj {
    private final static float[] VERTICES = {
            // bottom
            -1, -0.5f, -1,
            1, -0.5f, -1,
            -1, -0.5f, 1,
            1, -0.5f, 1,
            // left
            -1, -0.5f, -1,
            0, 1, 0,
            -1, -0.5f, 1,
            // right
            1, -0.5f, -1,
            0, 1, 0,
            1, -0.5f, 1,
            // back
            -1, -0.5f, -1,
            0, 1, 0,
            1, -0.5f, -1,
            // front
            -1, -0.5f, 1,
            0, 1, 0,
            1, -0.5f, 1,


            // bottom2
            -1, 0.5f, -1,
            1, 0.5f, -1,
            -1, 0.5f, 1,
            1, 0.5f, 1,
            // left2
            -1, 0.5f, -1,
            0, -1, 0,
            -1, 0.5f, 1,
            // right2
            1, 0.5f, -1,
            0, -1, 0,
            1, 0.5f, 1,
            // back2
            -1, 0.5f, -1,
            0, -1, 0,
            1, 0.5f, -1,
            // front2
            -1, 0.5f, 1,
            0, -1, 0,
            1, 0.5f, 1
    };

    private final FloatBuffer vbuf;

    Star() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // bottom
        gl.glNormal3f(0, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // left
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 4, 3);

        // right
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 7, 3);

        // back
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 10, 3);

        // front
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 13, 3);



        // bottom2
        gl.glNormal3f(0, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);

        // left2
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 20, 3);

        // right2
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 23, 3);

        // back2
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 26, 3);

        // front2
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 29, 3);
    }
}
