package xyz.srgnis;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.*;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.system.AppSettings;
import com.jme3.light.DirectionalLight;

/**
 * This is the Main Class of your Game. It should boot up your game and do initial initialisation
 * Move your Logic into AppStates or Controls or other java classes
 */
public class JMEMovementTest extends SimpleApplication {

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setResolution(1920,1080);

        JMEMovementTest app = new JMEMovementTest();
        app.setSettings(settings);

        app.start();
    }

    @Override
    public void simpleInitApp() {
        float r = FastMath.DEG_TO_RAD * 90f;

        cam.setLocation(new Vector3f(0.0f ,10.0f ,-10.0f));
        cam.lookAtDirection(new Vector3f(-1,0,-1), new Vector3f(0,1,0));

        DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White);
        sun.setDirection(new Vector3f(-.5f,-.5f,-.5f).normalizeLocal());
        rootNode.addLight(sun);

        Box b = new Box(1, 1, 1);
        Geometry geomb = new Geometry("Box", b);
        geomb.setLocalTranslation(0,1,0);

        Material matb = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        matb.setBoolean("UseMaterialColors",true);
        matb.setColor("Ambient", ColorRGBA.Red);
        matb.setColor("Diffuse", ColorRGBA.Red);
        geomb.setMaterial(matb);


        rootNode.attachChild(geomb);

        Quad floor = new Quad(100, 100);
        Geometry geomf = new Geometry("Floor", floor);
        geomf.rotate(-r,-r,0);
        geomf.setLocalTranslation(-50,0,-50);

        Material matf = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        matf.setBoolean("UseMaterialColors",true);
        matf.setColor("Ambient", ColorRGBA.Blue);
        matf.setColor("Diffuse", ColorRGBA.Blue);
        geomf.setMaterial(matf);


        rootNode.attachChild(geomf);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //this method will be called every game tick and can be used to make updates
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //add render code here (if any)
    }
}
